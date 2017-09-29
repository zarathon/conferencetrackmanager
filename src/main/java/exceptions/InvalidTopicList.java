package exceptions;

public class InvalidTopicList extends Exception {
    private String message;

    public InvalidTopicList(){
        super();
        this.message = "Invalid Talk List";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
