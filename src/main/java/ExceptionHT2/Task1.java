package ExceptionHT2;

import java.sql.SQLOutput;
import java.util.Scanner;

//Реализуйте метод, который запрашивает у пользователя ввод
//        дробного числа (типа float), и возвращает введенное
//        значение. Ввод текста вместо числа не должно приводить
//        к падению приложения, вместо этого,
//        необходимо повторно запросить у пользователя ввод данных.
public class Task1 {
    public static void main(String[] args) {
        getUserDouble();
    }

    private static void getUserDouble() {
        while (true) {
            System.out.println(" Please enter float number(separated with dot) : ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextFloat()) {
                float userNumber = scanner.nextFloat();
                System.out.println("Your number is :" + userNumber);
                System.exit(0);
            } else {
                System.out.println("Incorrect input , one more try below");
            }


        }
    }
}

