package lesson1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class sem6 {
    public static void main(String[] args) {

       ArrayList myArray = randomArray(1000,1000);
        for (int i = 0; i <10000 ; i++) {
        }
        HashSet<Integer> mySet = new HashSet<>(myArray);
        System.out.println(myArray);
        double uniquePercent = 1.0*mySet.size()/ myArray.size()*100;
        System.out.println("percent of unique elements in array is " + uniquePercent + "%");
    }

    private static ArrayList<Integer> randomArray(int size, int bound) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i <size ; i++) {
            array.add(random.nextInt(bound+1));
        }
        return array;
    }
}

