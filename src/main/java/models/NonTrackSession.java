package models;

import config.Constants;

public class NonTrackSession {
    private String name;
    private int duration;

    public NonTrackSession(String name){
        this.name = name;
        this.duration = Constants.NON_TRACK_MINUTES;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
