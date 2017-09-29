package exceptions;

public class HandlerNotFoundException extends Exception {

    private String message;

    public HandlerNotFoundException(){
        super();
        this.message = "No handler found.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
