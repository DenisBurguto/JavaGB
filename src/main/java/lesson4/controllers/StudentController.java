package lesson4.controllers;

import lesson4.models.Student;
import lesson4.services.UserService;

import java.util.List;

public class StudentController implements UserController<Student> {

    private final UserService<Student> studentService;

    public StudentController(UserService<Student> studentService) {
        this.studentService = studentService;
    }

    //@PostMethod("/students")
    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        studentService.create(fullName, age, phoneNumber, groupTitle);
    }

    //@GetMethod("/students")
    @Override
    public List<Student> getAll() {
        return studentService.getAll();
    }

    //@DeleteMethod("/students")
    @Override
    public int remove(String fullName) {
        return studentService.remove(fullName);
    }

    @Override
    public List<Student> getAllSortByFullName() {
        return studentService.getAllSortByFullName();
    }

    @Override
    public List<Student> getAllSortById() {
        return studentService.getAllSortById();

    }
}
