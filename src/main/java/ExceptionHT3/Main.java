package ExceptionHT3;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> pattern = List.of
                ("surname", "name", "patronymicName", "dateOfBirth", "phoneNumber", "sex");
        List<String> userData = getUserData(pattern);

        if (isValidUserInput(userData, pattern)) {
            Person person = new Person(userData.get(0), userData.get(1),
                    userData.get(2), userData.get(3), userData.get(4), userData.get(5));
            writeUserDataToFile(person);
        }

    }

    private static List<String> getUserData(List<String> pattern) {
        System.out.println("Please enter: " + pattern.toString()
                .replaceAll("^\\[|]$", "")
                .replaceAll(",", " ") + ", all data separated by space : ");
        Scanner scanner = new Scanner(System.in);
        List<String> userData = new ArrayList<>(List.of(scanner.nextLine().split(" ")));
        scanner.close();
        return userData;

    }

    private static boolean isValidUserInput(List<String> userData, List<String> pattern) {
        if (userData.size() == pattern.size()) {
            try {
                // check string format dd.mm.yyyy
                new SimpleDateFormat("dd.mm.yyyy").parse(userData.get(3));

            } catch (ParseException e) {
                throw new DateOfBirthException();
            }
            try {
                Long.parseLong(userData.get(4));// check phone number
            } catch (NumberFormatException e) {
                throw new PhoneNumberException();
            }
            return true;
        } else if (userData.size() < pattern.size()) {
            throw new RuntimeException("You have entered less data then required");
        } else {
            throw new RuntimeException("You have entered more data then required");
        }

    }

    private static void writeUserDataToFile(Person person) {
        try (FileWriter fileWriter = new FileWriter(person.getSurname(), true)) {
            fileWriter.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with writing data to file");
        }
        System.out.println("Your data is successfully added to file named " + person.getSurname());

    }

}
