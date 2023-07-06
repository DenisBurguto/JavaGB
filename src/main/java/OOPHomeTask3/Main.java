package OOPHomeTask3;

import java.util.ArrayList;
import java.util.List;

//Создать класс Контейнер - Container.
//        В контейнере могут быть ящики (класс Box).
//        У каждого ящика есть вес.
//        У каждого контейнера есть метод "получить вес" - это сумма всех весов ящиков, которые находятся в контейнере.
//        Класс Контейнер должен быть Comparable. Сравнивать он должен по весам контейнера (чем меньше вес, тем меньше
//        контейнер).
//        Класс ContainerCountComparator - Comparator, который сравнивает контейнеры по количеству ящиков (чем меньше
//        ящиков, тем меньше контейнер).
//        Класс контейнер должен быть Iterable - итерирование должно происходить по ящикам внутри контейнера.
//        Container c = new Container(...);
//// ...
//        for (Box box: c) {
//        box - это контейнер
//        }
public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(10);
        Box box2 = new Box(5);
        Box box3 = new Box(8);
        Box box4 = new Box(11);
        Box box5 = new Box(20);

        List<Box> boxes1 = new ArrayList<>();
        boxes1.add(box1);
        boxes1.add(box2);
        boxes1.add(box3);

        Container container1 = new Container(boxes1);

        System.out.println("Container1 weight: " + container1.getWeight());

        for (Box box : container1) {
            System.out.println("Box weight: " + box.getWeight());
        }

        List<Box> boxes2 = new ArrayList<>();

        boxes2.add(box4);
        boxes2.add(box5);

        Container container2 = new Container(boxes2);


        System.out.println("Container2 weight: " + container2.getWeight());
        for (Box box : container2) {
            System.out.println("Box weight: " + box.getWeight());

        }

        ContainerCountComparator countComparator = new ContainerCountComparator();
        int comparisonResult = countComparator.compare(container1, container2);
        String result = "";
        if (comparisonResult == 0) {
            result = "containers have the same boxes quantity in them";

        } else if (comparisonResult > 0) {
            result = "first container contains more boxes";

        } else {
            result = "last  container contains more boxes";
        }

        System.out.println("Comparison result: " + result);

       int weightComparisonResult = container1.compareTo(container2);
        if (weightComparisonResult == 0) {
            result = "containers are the same weight";

        } else if (weightComparisonResult > 0) {
            result = "first container is heavier";

        } else {
            result = "last  container is heavier";
        }

        System.out.println("Comparison result: " + result);

    }
}
