package OOPHomeTask1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Animals> ourAnimals = new ArrayList<>();
        Animals dog1 = new Dog("Pups", "Doberman", 7, 0.7, 15.2, "Gav", 12);
        Dog dog2 = new Dog("GER", "Kolli", 3, 0.6, 14.2, "r-Gav", 20);
        ourAnimals.add(dog1);
        ourAnimals.add(dog2);
        Cat cat1 = new Cat("Rich", "main-coon", 7, 0.3, 10.1, "mur", 1);
        ourAnimals.add(cat1);
        Animals horse1 = new Horse("Gnedoy", "Arabic", 4, 1.4, 143.5, "R-Rrra", 110);
        ourAnimals.add(horse1);
        Cow cow1 = new Cow("Burenka", "milky", 9, 1.2, 200.4, "muuuuu-u", -123);
        ourAnimals.add(cow1);


        for (Animals animals : ourAnimals
        ) {
            System.out.println(animals);
        }
        System.out.println("************************************************************************************************");
        Random random = new Random();
        for (Animals animals : ourAnimals
        ) {
            double meal = random.nextDouble(0, 10);
            animals.eatMeal(meal);
            int move = random.nextInt(100);
            animals.move(move);
            animals.letsMakeSomeNoiceB();
            System.out.println(animals);
        }


    }
}
