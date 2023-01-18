package info.uaic.ro.project.algorithm;

import info.uaic.ro.project.entities.FacultyGroup;
import info.uaic.ro.project.entities.Preference;
import info.uaic.ro.project.entities.Student;
import info.uaic.ro.project.services.GroupService;
import info.uaic.ro.project.services.PreferenceService;
import info.uaic.ro.project.services.StudentService;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Named
@ApplicationScoped
public class AlgorithmBean implements Serializable {
    @Inject
    StudentService studentService;
    
    @Inject
    PreferenceService preferenceService;
    
    @Inject
    GroupService groupService;

    private List<Student> students;
    private List<Preference> preferences;
    private List<FacultyGroup> groups;
    private List<Integer> groupCapacity;
    private Map<FacultyGroup, Integer> groupsEffective;
    private int numberOfGroups;

    @PostConstruct
    public void init() {
        students = studentService // GET ONLY STUDENTS FROM 1ST YEAR
                .findAll()
                .stream()
                .filter(c -> c.getYear() == 1)
                .collect(Collectors.toList());
        preferences = preferenceService.findAll();
        groups = groupService.findAll();
        groupsEffective = new HashMap<>();
    }

    public void calculateGroups() {
        addGroupsToBeChosen();
        satisfyPreferences(); // FIRST SATISFY THE PREFERENCES
        for (Student student : students) { // THEN ASSIGN TO THE SMALLEST GROUP
            if (hasGroup(student))
                continue;
            FacultyGroup group = getGroupWithSmallestSize();
            assign(student, group);
        }
    }

    public void satisfyPreferences() {
        for (Preference preference : preferences) {
            Student student = getStudentFromRegistration(preference.getStudent1());
            Student friend = getStudentFromRegistration(preference.getStudent2());
            groupFriends(student, friend);
        }
    }

    public void resetGroups() {
        students = studentService.findAll();
        for (Student student: students) {
            student.setGroup(-1);
            studentService.update(student);
        }
    }

    private void addGroupsToBeChosen() {
        for (int i = 0; i < numberOfGroups; i++) {
            groupsEffective.put(groups.get(i), 0);
        }
    }

    private void groupFriends(Student student, Student friend) {
        if (hasGroup(student)) {
            assign(friend, getGroupFromId(student.getGroup()));
        } else if (hasGroup(friend)) {
            assign(student, getGroupFromId(friend.getGroup()));
        } else {
            FacultyGroup group = getGroupWithSmallestSize();
            assign(student, group);
            assign(friend, group);
        }
    }

    private boolean hasGroup(Student student) {
        return student.getGroup() >= 0;
    }

    private FacultyGroup getGroupWithSmallestSize() {
        FacultyGroup smallestGroup = null;
        int smallestSize = Integer.MAX_VALUE;
        for (Map.Entry<FacultyGroup, Integer> entry: groupsEffective.entrySet()) {
            if (entry.getValue() < smallestSize) {
                smallestSize = entry.getValue();
                smallestGroup = entry.getKey();
            }
        }
       return smallestGroup;
    }

    private void assign(Student student, FacultyGroup group) {
        incrementGroupEffective(group);
        student.setGroup(group.getId());
        studentService.update(student);
    }

    private void incrementGroupEffective(FacultyGroup group) {
        groupsEffective.put(group, groupsEffective.get(group) + 1);
    }

    public Student getStudentFromRegistration(String registration) {
        return students
                .stream()
                .filter(s -> s.getRegistrationNumber().equals(registration))
                .collect(Collectors.toList())
                .get(0);
    }

    public FacultyGroup getGroupFromId(int id) {
        return groups
                .stream()
                .filter(g -> g.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }
}
