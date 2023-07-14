package lesson4;

import lesson4.controllers.GroupController;
import lesson4.controllers.StudentController;
import lesson4.controllers.TeacherController;
import lesson4.repositories.StudentRepository;
import lesson4.repositories.TeacherRepository;
import lesson4.services.GroupService;
import lesson4.services.StudentService;
import lesson4.services.TeacherService;
import lesson4.view.GroupView;
import lesson4.view.SortType;
import lesson4.view.StudentView;
import lesson4.view.TeacherView;

public class Main {

    private static StudentRepository studentRepository;
    private static StudentService studentService;
    private static StudentController studentController;
    private static TeacherRepository teacherRepository;
    private static TeacherService teacherService;
    private static TeacherController teacherController;


    public static void main(String[] args) {
      StudentView studentView = getStudentController();
        TeacherView teacherView= getTeacherController();
        GroupView groupView = getGroupView();
//        -------------------------------------------------------------------------

        studentView.create("Ivan Morozov", 18, "02", "11Б");
        studentView.create("Ivan Morozov", 18, "02", "11Б");
        studentView.create("Petr Vorobev", 19, "03", "10А");
        studentView.create("Sidor Sidorov", 20, "112", "10А");
        studentView.create("Elena Ivanova", 19, "911", "10А");
        studentView.create("Anna Morozova", 17, "01", "11А");


        teacherView.create("Учитель Один", 44, "434", "11Б");
        teacherView.create("Учитель Два", 43, "554", "11Б");
        teacherView.create("Учитель  Три", 37, "89", "10А");
        teacherView.create("Учитель  Четыре ", 29, "656", "10А");
        teacherView.create("Учитель  Пять", 50, "76654", "10А");
        teacherView.create("Учитель  Шесть", 47, "098", "11А");

        groupView.printAllFromGroup("11А");
//        studentView.sendOnConsole();
//        studentView.sendOnConsole(SortType.NAME);
//        studentView.sendOnConsole(SortType.ID);
//
//        studentView.removeUser("Ivan Morozov");
//
        studentView.sendOnConsole();
        teacherView.sendOnConsole();

        teacherView.sendOnConsole(SortType.ID);
        teacherView.sendOnConsole(SortType.NAME);
        teacherView.removeUser("Учитель Один");
        teacherView.sendOnConsole();

    }



    private static TeacherView getTeacherController() {
        teacherRepository = new TeacherRepository();
        teacherService = new TeacherService(teacherRepository);
        teacherController = new TeacherController(teacherService);
        return new TeacherView(teacherController);
    }

    private static StudentView getStudentController() {
        studentRepository = new StudentRepository();
        studentService = new StudentService(studentRepository);
        studentController = new StudentController(studentService);
        return new StudentView(studentController);
    }

    private static GroupView getGroupView() {
        GroupService groupService = new GroupService(studentService, teacherService);
        GroupController groupController = new GroupController(groupService);
        return new GroupView(groupController);
    }


}
