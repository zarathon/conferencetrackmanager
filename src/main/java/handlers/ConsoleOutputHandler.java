package handlers;

import config.Constants;

public class ConsoleOutputHandler extends OutputHandler {

    public ConsoleOutputHandler(){
        super(Constants.CONSOLE_TYPE);
    }

    @Override
    public String writeOut() throws Exception {
        return this.convertConferenceTracksToString();
    }
}
