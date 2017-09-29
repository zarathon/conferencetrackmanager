package handlers;

import exceptions.HandlerNotFoundException;

import java.util.List;

public abstract class InputHandler {
    protected InputHandler next;
    protected String type;
    protected String input;

    public InputHandler(String type){
        next = null;
        this.type = type;
    }

    public List<String> getTopicListFromInput(String type, String input) throws Exception {
        this.input = input;
        if (canHandle(type)) {
            return getTopicListFromInput();
        } else {
            if (next == null) {
                throw new HandlerNotFoundException();
            }
            return next.getTopicListFromInput(type, input);
        }
    }

    private boolean canHandle(String type) {
        if (this.type.equals(type)) {
            return true;
        }
        return false;
    }

    public abstract List<String> getTopicListFromInput() throws Exception;
}
