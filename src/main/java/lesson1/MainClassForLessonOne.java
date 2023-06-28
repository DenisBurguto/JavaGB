package lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainClassForLessonOne {
    @Override
    public String toString() {
        return super.toString();
    }

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
//
//
//    private static Integer ex3(String romanNum) {
//
//        Map<Character, Integer> romanToDecimalMap = Map.of(
//                'I', 1,
//                'V', 5,
//                'X', 10,
//                'L', 50,
//                'C', 100,
//                'D', 500,
//                'M', 1000
//        );
//
//        StringBuilder romanNumSB = new StringBuilder(romanNum.trim()).reverse();
//        int decimalNum = 0;
//        int prevNum = -1;
//
//        for (Character romanChar : romanNumSB.toString().toCharArray()) {
//            int currentNum = romanToDecimalMap.get(romanChar);
//            if (currentNum < prevNum) {
//                currentNum *= -1;
//            }
//            decimalNum += currentNum;
//            prevNum = currentNum;
//        }
//
//        return decimalNum;
//
//    }