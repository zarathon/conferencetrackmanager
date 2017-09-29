import config.Constants;
import handlers.ConsoleOutputHandler;
import handlers.PlainTextInputHandler;
import handlers.PlainTextOutputHandler;
import models.ConferenceTrack;
import services.ConferenceManager;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        try {
            PlainTextInputHandler plainTextInputHandler = new PlainTextInputHandler();
            List<String> topics = plainTextInputHandler.getTopicListFromInput(config.Constants.PLAIN_TEXT_TYPE, "input.txt");

            ConferenceManager cm = new ConferenceManager(topics);
            List<ConferenceTrack> conferenceTracks = cm.doSchedule();

            PlainTextOutputHandler plainTextOutputHandler = new PlainTextOutputHandler();
            ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

            System.out.println("Results can be found in: "+plainTextOutputHandler.writeOut(Constants.PLAIN_TEXT_TYPE,conferenceTracks));
            System.out.println(consoleOutputHandler.writeOut(Constants.CONSOLE_TYPE,conferenceTracks));

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
