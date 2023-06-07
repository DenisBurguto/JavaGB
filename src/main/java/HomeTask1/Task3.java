package HomeTask1;
//. В консоли запросить имя пользователя. В зависимости от текущего времени,
// вывести приветствие вида:
//"Доброе утро, <Имя>!", если время от 05:00 до 11:59
//"Добрый день, <Имя>!", если время от 12:00 до 17:59;
//"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//"Доброй ночи, <Имя>!", если время от 23:00 до 4:59

import java.util.Scanner;
import java.util.Calendar;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("hello user, what is your name? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        if (5 <= hour && hour <= 11)
            System.out.println("Good morning, " + name + "!");
        else if (12 <= hour && hour <= 17)
            System.out.println("Good day, " + name + "!");
        else if (18 <= hour && hour <= 22)
            System.out.println("Good evening, " + name + "!");
        else
            System.out.println("Good night, " + name + "!");
    }
}
