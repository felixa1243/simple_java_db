package responses;

import exceptions.Error;

public class FailStatus extends Responses {
    private Error error;
    public FailStatus(String message,Error error) {
        super(false, message);
        this.error = error;
    }
}
