package HomeTask1;

import java.util.Arrays;

//Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из
// диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему
// принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
public class Task2 {
    public static void main(String[] args) {
        int size = 10;
        int[] square[] = new int[size][size]; // rows, columns;
        int end = size - 1;
        for (int i = 0; i < square.length; i++) { // rows
            for (int j = 0; j < square[0].length; j++) { //columns
                if (i == j) square[i][j] = 1;
            }
            square[i][end] = 1;
            end--;
        }
        // print with foreach each row of array
        for (int[] row: square) {
            System.out.println(Arrays.toString(row));
        }
    }
}
