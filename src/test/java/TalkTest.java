import exceptions.InvalidDurationTalkException;
import exceptions.InvalidTitleTalkException;
import handlers.PlainTextInputHandler;
import models.ConferenceTrack;
import services.ConferenceManager;
import models.Talk;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TalkTest {

    @Test
    public void testCreateTalk() throws Exception {
        Talk talk1 = new Talk(Constants.topic);
        Assert.assertTrue(talk1.getTitle().equals("Writing Fast Tests Against Enterprise Rails"));
        Assert.assertTrue(talk1.getDuration()==60);

        Talk talk2 = new Talk(Constants.lightningTopic);
        Assert.assertTrue(talk2.getTitle().equals("Rails for Python Developers"));
        Assert.assertTrue(talk2.getDuration()==5);
    }

    @Test(expected = InvalidDurationTalkException.class)
    public void testCreateTalkWithBadDuration() throws Exception {
        Talk talk4 = new Talk(Constants.badDurationTopic);
    }

    @Test(expected = InvalidTitleTalkException.class)
    public void testCreateTalkWithBadTitle() throws Exception{
        Talk talk3 = new Talk(Constants.badTitleTopic);
    }

}