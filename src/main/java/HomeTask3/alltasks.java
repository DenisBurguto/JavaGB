package HomeTask3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//Задание
//        Пусть дан произвольный список целых чисел.
//        1) Найти максимальное значение
//        2) Найти минимальное значение
//        3) Найти среднее значение
//        4) Нужно удалить из него чётные числа
public class alltasks {
    public static void main(String[] args) {

        List<Integer> myList = createRandomIntList(10, 10);
        System.out.println("Initial list: " + myList);
        findMax(myList);
        findMin(myList);
        findAvg(myList);
        removeEvens(myList);
        System.out.println("List without even numbers: " + myList);

    }

    private static void removeEvens(List<Integer> myList) {
        int i = 0;
        while (i < myList.size()){
            if (myList.get(i) % 2 ==0){
                myList.remove(myList.get(i));
                i--;
            }
            i++;
        }
    }

    private static void findAvg(List<Integer> myList) {
        int sum = 0;
        for (int i = 0; i < myList.size(); i++) {
            sum += myList.get(i);
        }
        System.out.println("Average value is: " + (double) sum / myList.size());
    }

    private static void findMin(List<Integer> myList) {
        int min = myList.get(0);
        for (int i = 1; i < myList.size(); i++) {
            if (myList.get(i) < min) {
                min = myList.get(i);
            }
        }
        System.out.println("Min number in list is: " + min);
    }

    private static void findMax(List<Integer> myList) {
        int max = myList.get(0);
        for (int i = 1; i < myList.size(); i++) {
            if (myList.get(i) > max) {
                max = myList.get(i);
            }
        }
        System.out.println("Max number in list is: " + max);
    }


    private static List<Integer> createRandomIntList(int len, int maxValue) {
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            randomList.add(i, random.nextInt(-maxValue + 1, maxValue));
        }
        return randomList;
    }
}
