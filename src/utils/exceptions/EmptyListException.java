package utils.exceptions;

public class EmptyListException extends RuntimeException{
    public EmptyListException() {
        super("Empty list");
    }
}
