package exceptions;

import config.Constants;

public class InvalidDurationTalkException extends Exception {

    private String message;

    public InvalidDurationTalkException(){
        super();
        this.message = "Duration must be a number between 1 and "+ Constants.MAX_DURATION_TRACK +" minutes";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
