import config.Constants;
import handlers.PlainTextOutputHandler;
import models.ConferenceTrack;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlainTextOutputHandlerTest {
    @Test
    public void writeOut() throws Exception {
        PlainTextOutputHandler pt = new PlainTextOutputHandler();
        Assert.assertNotNull(pt.writeOut(Constants.PLAIN_TEXT_TYPE,new ArrayList<ConferenceTrack>()));
    }

}