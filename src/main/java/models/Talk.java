package models;

import config.Constants;
import exceptions.InvalidDurationTalkException;
import exceptions.InvalidTitleTalkException;
import utils.TalkUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Talk implements Comparable{

    private String title;
    private int duration;

    public Talk(){}

    public Talk(String topic) throws Exception {
        setDuration(TalkUtil.getDurationFromTopic(topic));
        setTitle(TalkUtil.getTitleFromTopic(topic));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        if (isTitleInvalid(title))
            throw new InvalidTitleTalkException();
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) throws Exception {
        if(isDurationInvalid(duration))
            throw new InvalidDurationTalkException();
        this.duration = duration;
    }

    private boolean isTitleInvalid(String title) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(title);
        while (matcher.find()){
            return true;
        }
        return false;
    }

    private boolean isDurationInvalid(int duration) {
        if((duration < 0) || (duration > Constants.MAX_DURATION_TRACK))
            return true;
        return false;
    }

    @Override
    public int compareTo(Object obj){
        Talk talk = (Talk)obj;
        if(this.duration > talk.duration)
            return -1;
        else if(this.duration < talk.duration)
            return 1;
        else
            return 0;
    }
    
}
