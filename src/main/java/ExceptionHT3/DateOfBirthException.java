package ExceptionHT3;

public class DateOfBirthException extends RuntimeException {
    public DateOfBirthException() {
        super("Incorrect birthday, must be in format dd.mm.yyyy ");
    }
}
