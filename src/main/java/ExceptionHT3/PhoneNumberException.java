package ExceptionHT3;

public class PhoneNumberException extends NumberFormatException{
    public PhoneNumberException() {
        super("Incorrect phone number, must be only digits without separators");
    }
}
