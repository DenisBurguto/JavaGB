package lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainClassForLessonOne {
    public static void main(String[] args) {
        Object o = 1;
        GetType(o);
        Object a = 1.2;
        GetType(a);
        List<String> pl = new ArrayList<>();


    }

    private static void GetType(Object o) {
        System.out.println(o.getClass().getName());
    }
}


