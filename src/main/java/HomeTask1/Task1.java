package HomeTask1;

import org.example.Main;

import java.util.Arrays;

//1. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
public class Task1 {
    public static void main(String[] args) {
        int size = 10;
        int[] arrayA = new int[size];
        for (int i = 0; i < arrayA.length; i++) {
            // fill array with random int [0,10]
            arrayA[i] = (int) (Math.random() * 11);
        }
        int maximum = arrayA[0];
        int minimum = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            if (arrayA[i] > maximum) maximum = arrayA[i];
            else if (arrayA[i] < minimum) minimum = arrayA[i];
        }
        System.out.println(Arrays.toString(arrayA));
        System.out.println("max element in array is " + maximum +" while min is " + minimum);

    }
}
