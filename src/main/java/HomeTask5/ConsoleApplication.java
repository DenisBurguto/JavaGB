package HomeTask5;

import java.util.*;

public class ConsoleApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> phBook = new HashMap<>();
        while (true) {
            String[] userInput = scanner.nextLine().split(" ");
            if ("EXIT".equals(userInput[0])) {
                break;
            } else if ("LIST".equals(userInput[0])) {
                System.out.println(phBook);
            } else if ("ADD".equals(userInput[0])) {
                if (userInput.length < 3) {
                    System.out.println("incorrect input");
                } else {
                    List<String> number = new ArrayList<>();
                    if (phBook.containsKey(userInput[1])) {
                        number = phBook.get(userInput[1]);
                        for (int i = 2; i < userInput.length; i++) {
                            number.add(userInput[i]);
                        }
                        phBook.put(userInput[1], number);
                    } else {
                        for (int i = 2; i < userInput.length; i++) {
                            number.add(userInput[i]);
                        }
                        phBook.put(userInput[1], number);
                    }
                }
            } else if ("GET".equals(userInput[0]) && userInput.length > 1) {
                if (phBook.containsKey(userInput[1])) {
                    System.out.println(userInput[1] + "=" + phBook.get(userInput[1]));
                } else {
                    System.out.println("There is no any " + userInput[1] + " in our phonebook");
                }

            } else if ("REMOVE".equals(userInput[0]) && userInput.length > 1) {
                if (phBook.containsKey(userInput[1])) {
                    phBook.remove(userInput[1]);
                } else {
                    System.out.println("There is no any " + userInput[1] + " in our phonebook");
                }
            } else {
                System.out.println("Incorrect input");
            }
        }
    }
}
