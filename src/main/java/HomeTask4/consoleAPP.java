package HomeTask4;
/*
Реализовать консольное приложение, которое:
1. Принимает от пользователя и “запоминает” строки.
2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
3. Если введено revert, удаляет предыдущую введенную строку из памяти.
4. Если введено exit, то программа завершается
> - ввод в консоль (stdin), < - вывод на консоль (stdout)
> java
> python
> c#
> print
< [c#, python, java]
> revert
> print
< [python, java]
> revert
> revert
> print
< []
> revert -> throw new NoSuchElementException
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class consoleAPP {
    public static void main(String[] args) {
        Deque<String> userStrings = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userInput = scanner.nextLine();
            if ("exit".equals(userInput)) {
                break;
            } else if ("print".equals(userInput)) {
                System.out.println(userStrings);
            } else if ("revert".equals(userInput)) {
                if(userStrings.size()>0){
                    userStrings.pollFirst();
                }
                else {
                    System.out.println("NoSuchElement");
                }
            } else {
                userStrings.addFirst(userInput);
            }
        }
    }
}
