package lesson4.services;

import lesson4.models.Teacher;
import lesson4.models.User;
import lesson4.repositories.UserRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeacherService implements UserService<Teacher>{


    private final UserRepository<Teacher> teacherUserRepository;

    public TeacherService(UserRepository<Teacher> teacherUserRepository) {
        this.teacherUserRepository = teacherUserRepository;
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        teacherUserRepository.create(new Teacher(fullName, age, phoneNumber, groupTitle));
    }

    @Override
    public List<Teacher> getAll() {
        var teachers = teacherUserRepository.getAll();
        Collections.sort(teachers);
        return teachers;
    }

    @Override
    public List<Teacher> getAllSortByFullName() {
        var teachers = teacherUserRepository.getAll();
        teachers.sort(Comparator.comparing(User::getFullName));
        return teachers;
    }

    @Override
    public List<Teacher> getAllSortById() {
        var teachers = teacherUserRepository.getAll();
        teachers.sort(Comparator.comparing(User::getId));
        return teachers;
    }

    @Override
    public int remove(String fullName) {
        return teacherUserRepository.remove(fullName);
    }

    @Override
    public List<Teacher> getAllByTitle(String groupTitle) {
        return teacherUserRepository.getAllByGroupTitle(groupTitle);
    }
}
