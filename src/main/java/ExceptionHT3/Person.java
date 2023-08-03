package ExceptionHT3;


import java.util.Objects;

public class Person {
    private String surname;
    private String name;
    private String patronymicName;
    private String dateOfBirth;
    private String phoneNumber;
    private String sex;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(surname, person.surname) && Objects.equals(name, person.name) && Objects.equals(patronymicName, person.patronymicName) && Objects.equals(dateOfBirth, person.dateOfBirth) && Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymicName, dateOfBirth, sex);
    }


    public Person(String surname, String name, String patronymicName, String dateOfBirth, String phoneNumber, String sex) {
        this.surname = surname;
        this.name = name;
        this.patronymicName = patronymicName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>", surname, name, patronymicName, dateOfBirth, phoneNumber, sex);
    }
}
