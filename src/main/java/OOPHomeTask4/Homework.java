package OOPHomeTask4;

import java.util.ArrayList;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        //   Box<String> stringBox = new Box<>(); // не должно компилироваться

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange(1));
        orangeBox.add(new Orange(2));
        //orangeBox.add(new Apple(2));       // не должно компилироваться
        // orangeBox.add(new GoldenApple(2)); // не должно компилироваться

        System.out.println(orangeBox.getWeight()); // 3

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple(1));
        appleBox.add(new GoldenApple(2)); // допустимый вариант
        System.out.println(appleBox.getWeight()); // 3

        Box<GoldenApple> goldenAppleBox = new Box<>();
        goldenAppleBox.add(new GoldenApple(5)); // допустимый вариант
        // goldenAppleBox.add(new Apple(5));       // не должно компилироваться
        System.out.println(goldenAppleBox.getWeight()); // 5


        goldenAppleBox.moveTo(appleBox); // допустимый вариант
        // appleBox.moveTo(goldenAppleBox); // не должно компилироваться
        //  orangeBox.moveTo(appleBox);      // не должно компилироваться
        System.out.println(appleBox);

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox.moveTo(orangeBox2);
        System.out.println(orangeBox.getWeight()); // 0
        System.out.println(orangeBox2.getWeight()); // 3
        System.out.println(orangeBox2);

    }

    // FIXME: 06.07.2023 Добавить нужный дженерик.
    static class Box<T extends Fruit> {
        @Override
        public String toString() {
            return "Box{" + storageBox +
                    '}';
        }

        public Box() {
            this.storageBox = new ArrayList<>();
        }

        private List<T> storageBox;

        public void add(T t) {
            this.storageBox.add(t);

        }

        public int getWeight() {
            int weight = 0;
            for (T t : this.storageBox
            ) {
                weight += t.getWeight();

            }
            return weight;
        }

        public void moveTo(Box<? super T> otherBox) {

            for (T t : this.storageBox
            ) {
                otherBox.add(t);
            }
            this.storageBox.clear();


        }

    }

    // FIXME: 06.07.2023 Реализовать методы согласно заданию.


    static class Fruit {

        private final int weight;

        public Fruit(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    static class Orange extends Fruit {
        @Override
        public String toString() {
            return "Orange{" + "weight" + getWeight() + "}";
        }

        public Orange(int weight) {
            super(weight);
        }
    }

    static class Apple extends Fruit {
        @Override
        public String toString() {
            return "Apple{" + "weight" + getWeight() + "}";
        }

        public Apple(int weight) {
            super(weight);
        }
    }

    static class GoldenApple extends Apple {
        @Override
        public String toString() {
            return "GoldenApple{" + "weight" + getWeight() + "}";
        }

        public GoldenApple(int weight) {
            super(weight);
        }
    }

}
