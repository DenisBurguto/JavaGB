package HomeTask1;

import java.util.Arrays;

//** Написать метод, которому на вход подается одномерный массив и число n
// (может быть положительным, или отрицательным), при этом метод должен сместить все
// элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя
// пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) ->
// [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую
// сторону сдвиг можете выбирать сами.
public class Task4 {
    public static void main(String[] args) {
        int size = 4;
        int[] startArray = new int[size];
        for (int i = 0; i < startArray.length; i++) {
            // fill array with random int [0,10]
            startArray[i] = (int) (Math.random() * 11);
        }
        System.out.println("initial array " + Arrays.toString(startArray));
        //  possible shift in range[-size,size]
        int shift = (int) (Math.random() *size*2) - size;
        System.out.println("shift " + shift);


        if (shift > 0) {
            //to the right
            //shift = shift % startArray.length; // in case shift more then array length
            while (shift > 0 && shift < startArray.length ) {
                for (int i = 0; i < startArray.length - 1; i++) {
                    int temp = startArray[i];
                    startArray[i] = startArray[startArray.length - 1];
                    startArray[startArray.length - 1] = temp;
                }
                shift--;
            }
        } else if (shift < 0)
            //to the left
            // shift = -(-shift % startArray.length); // in case shift more then array length
            while (shift < 0 && -shift < startArray.length) {
                for (int i = startArray.length - 1; i >= 0; i--) {
                    int temp = startArray[i];
                    startArray[i] = startArray[startArray.length - 1];
                    startArray[startArray.length - 1] = temp;
                }
                shift++;
            }
        System.out.println("final array " + Arrays.toString(startArray));
    }
}
