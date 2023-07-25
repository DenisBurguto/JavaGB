package ExceptionHT2;

import java.io.FileNotFoundException;

public class Task3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 2;
            System.out.println(a / b);
            printSum(23, null);
            int[] abc = {1, 2};
            abc[1] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!"); // можно убрать отсюда в метод pintSum ( если уберем Exception ex  ниже)
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (ArithmeticException ex) {
            System.out.println("Делить на ноль нельзя!");
        } catch (
                Exception ex) { // это можно вообще убрать по -моему,  оставил чтобы показать где должен находиться верхний уровень исключения
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws NullPointerException {
        System.out.println(a + b);
    }

}
