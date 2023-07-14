package lesson4.services;

import lesson4.models.Student;
import lesson4.models.User;
import lesson4.repositories.UserRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentService implements UserService<Student> {

    private final UserRepository<Student> studentUserRepository;

    public StudentService(UserRepository<Student> studentUserRepository) {
        this.studentUserRepository = studentUserRepository;
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {

        studentUserRepository.create(new Student(fullName, age, phoneNumber, groupTitle));
    }

    @Override
    public List<Student> getAll() {
        var students = studentUserRepository.getAll();
        Collections.sort(students);
        return students;
    }

    public List<Student> getAllSortByFullName() {
        var students = studentUserRepository.getAll();
/*        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });*/
//        students.sort((o1, o2) -> o1.getFullName().compareTo(o2.getFullName()));
        students.sort(Comparator.comparing(User::getFullName));

        return students;
    }

    public List<Student> getAllSortById() {
        var students = studentUserRepository.getAll();
        students.sort(Comparator.comparing(User::getId));
        return students;
    }



    @Override
    public int remove(String fullName) {
        return studentUserRepository.remove(fullName);
    }

    @Override
    public List<Student> getAllByTitle(String groupTitle) {
        return studentUserRepository.getAllByGroupTitle(groupTitle);
    }
}
