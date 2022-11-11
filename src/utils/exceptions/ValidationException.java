package utils.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException() {
        super("field must not be empty");
    }
}
