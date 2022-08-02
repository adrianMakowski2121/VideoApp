package application.exceptions;

public class BadLoginOrPasswordException extends RuntimeException{
    public BadLoginOrPasswordException(String message) {
        super(message);
    }
}
