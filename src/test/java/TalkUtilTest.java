import org.junit.Assert;
import org.junit.Test;
import utils.TalkUtil;

public class TalkUtilTest {

    @Test
    public void testGetTitleFromTopic(){
        String title = TalkUtil.getTitleFromTopic(Constants.topic);
        Assert.assertFalse(title.equals(""));
        Assert.assertTrue(title.equals("Writing Fast Tests Against Enterprise Rails"));

        title = TalkUtil.getTitleFromTopic(Constants.lightningTopic);
        Assert.assertFalse(title.equals(""));
        Assert.assertTrue(title.equals("Rails for Python Developers"));
    }

    @Test
    public void testGetDurationFromTopic(){

        int duration = TalkUtil.getDurationFromTopic(Constants.topic);
        Assert.assertTrue(duration!=0);
        Assert.assertTrue(duration==60);

        duration = TalkUtil.getDurationFromTopic(Constants.lightningTopic);
        Assert.assertTrue(duration!=0);
        Assert.assertTrue(duration==5);
    }


}