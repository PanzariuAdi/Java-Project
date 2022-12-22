package info.uaic.ro.project.controllers;

import info.uaic.ro.project.entities.FacultyGroup;
import info.uaic.ro.project.entities.Student;
import info.uaic.ro.project.services.GroupService;
import info.uaic.ro.project.services.StudentService;

import javax.inject.Inject;
import java.util.List;

public class SecretaryController {
    @Inject
    StudentService studentService;
    @Inject
    GroupService groupService;

    public void addStudent(Student student) {
        studentService.create(student);
    }

    public void updateStudent(Student student) {
        studentService.update(student);
    }

    public void removeStudent(Student student) {
        studentService.remove(student);
    }

    public Student findStudent(int id) {
        return studentService.findById(id);
    }

    public List<Student> getStudents() {
        return studentService.findAll();
    }

    public void addGroup(FacultyGroup facultyGroup) {
        groupService.create(facultyGroup);
    }

    public void updateGroup(FacultyGroup facultyGroup) {
        groupService.update(facultyGroup);
    }

    public void removeGroup(FacultyGroup facultyGroup) {
        groupService.remove(facultyGroup);
    }

    public FacultyGroup findGroup(int id) {
        return groupService.findById(id);
    }

    public List<FacultyGroup> getGroups() {
        return groupService.findAll();
    }
}
