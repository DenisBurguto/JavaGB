package HomeTask6;


import java.util.HashSet;
import java.util.Scanner;

//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//        Создать множество ноутбуков (ArrayList).
//        Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. Например,
//        спросить у пользователя
//        минимальный размер оперативной памяти или конкретный цвет. Выводить только те ноутбуки,
//        что соответствуют условию
public class consoleOperated {
    public static void main(String[] args) {

        HashSet<noutebooks> noutes = new HashSet<>();
        noutebooks testNoute1 = new noutebooks("Apple", "MacBook Air");
        noutes.add(testNoute1);
        noutebooks testNoute2 = new noutebooks("HP", "Omen");
        noutes.add(testNoute2);
        noutebooks testNoute3 = new noutebooks("Dell", "Latitude");
        noutes.add(testNoute3);
        noutebooks testNoute4 = new noutebooks("Lenovo", "Simple");
        noutes.add(testNoute4);
        noutebooks testNoute5 = new noutebooks("Acer", "Aspire");
        noutes.add(testNoute5);


        testNoute1.setDiagonal(13.3);
        testNoute2.setDiagonal(14.0);
        testNoute3.setDiagonal(16.0);
        testNoute4.setDiagonal(13.0);
        testNoute5.setDiagonal(17.0);

        testNoute1.setProcessor("AppleSilicon");
        testNoute2.setProcessor("AMD");
        testNoute3.setProcessor("AMD");
        testNoute4.setProcessor("Intel");
        testNoute5.setProcessor("Intel");

        testNoute1.setRom(256);
        testNoute2.setRom(512);
        testNoute3.setRom(1024);
        testNoute4.setRom(256);
        testNoute5.setRom(128);

        testNoute1.setRam(16);
        testNoute2.setRam(8);
        testNoute3.setRam(16);
        testNoute4.setRam(8);
        testNoute5.setRam(16);

        Scanner scanner = new Scanner(System.in);
        Double diaFilter = 0.0;
        Integer romFilter = 0;
        Integer ramFilter = 0;

        do {
            System.out.println("Please enter minimum desired diagonal in inches: ");
            try {
                diaFilter = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Incorrect input");
            }
        } while (diaFilter == 0);

        do {
            System.out.println("Minimum storage capacity in GB?: ");
            try {
                romFilter = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Incorrect input");
            }
        } while (romFilter == 0);

        do {
            System.out.println("Minimum RAM in GB? : ");
            try {
                ramFilter = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Incorrect input");
            }
        } while (ramFilter == 0);
        System.out.println("we found below models available according to your request: ");
        for (noutebooks noutebooks : noutes
        ) {
            if (noutebooks.getDiagonal() >= diaFilter &&
                    noutebooks.getRom() >= romFilter &&
                    noutebooks.getRam() >= ramFilter) {
                System.out.println(noutebooks);
            }

        }

    }

}

