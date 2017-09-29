package models;

import java.util.ArrayList;
import java.util.List;

public class TrackSession {

    private String name;
    private int duration;
    private List<Talk> sessionTalks;

    public TrackSession(String name, int duration){
        this.name = name;
        this.duration = duration;
        this.sessionTalks = new ArrayList<Talk>();
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

    public List<Talk> getSessionTalks() {
        return sessionTalks;
    }

    public void setSessionTalks(List<Talk> sessionTalks) {
        this.sessionTalks = sessionTalks;
    }
}
