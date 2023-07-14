package lesson4.controllers;

import lesson4.models.Teacher;
import lesson4.services.UserService;

import java.util.List;

public class TeacherController implements UserController<Teacher>{

    private final UserService<Teacher> teacherService;

    public TeacherController(UserService<Teacher> teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        teacherService.create(fullName, age, phoneNumber, groupTitle);
    }

    @Override
    public List<Teacher> getAll() {
       return teacherService.getAll();
    }

    @Override
    public int remove(String fullName) {
        return teacherService.remove(fullName);
    }

    @Override
    public List<Teacher> getAllSortByFullName() {
        return teacherService.getAllSortByFullName();
    }

    @Override
    public List<Teacher> getAllSortById() {
        return teacherService.getAllSortById();
    }
}
