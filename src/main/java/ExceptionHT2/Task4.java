package ExceptionHT2;

import java.util.Scanner;

//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
public class Task4 {
    public static void main(String[] args) {
        ThrowExceptionOnEmptyString();
    }

    private static void ThrowExceptionOnEmptyString() {
        System.out.println("Enter anything you want :");
        Scanner scanner = new Scanner(System.in);
        String enter = scanner.nextLine();
        if (enter == "") {
            throw new RuntimeException("Empty input is forbidden! ");
        }
        System.out.println("Thanks!");
    }
}
