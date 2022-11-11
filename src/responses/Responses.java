package responses;

public class Responses {
    private boolean isValid;
    private String message;

    public boolean isValid() {
        return isValid;
    }

    public String getMessage() {
        return message;
    }

    public Responses(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }
}
