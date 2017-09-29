package exceptions;

public class InvalidTitleTalkException extends Exception {
    private String message;

    public InvalidTitleTalkException(){
        super();
        this.message = "Title Cannot Contain Numbers";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
