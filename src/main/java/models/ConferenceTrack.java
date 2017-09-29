package models;

import config.Constants;

public class ConferenceTrack {
    private int trackNumber;
    private TrackSession morningSession;
    private NonTrackSession lunch;
    private TrackSession afternoonSession;
    private NonTrackSession networkingEvent;
    private int timeSaved;

    public ConferenceTrack(int trackNumber){
        this.trackNumber = trackNumber;
        this.morningSession = new TrackSession("Morning Session", Constants.TRACK_SESSION_MIN_MINUTES);
        this.afternoonSession = new TrackSession("Afternoon Session", Constants.TRACK_SESSION_MAX_MINUTES);
        this.lunch = new NonTrackSession("Lunch");
        this.networkingEvent = new NonTrackSession("Networking Event");
        this.timeSaved = 0;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public TrackSession getMorningSession() {
        return morningSession;
    }

    public void setMorningSession(TrackSession morningSession) {
        this.morningSession = morningSession;
    }

    public NonTrackSession getLunch() {
        return lunch;
    }

    public void setLunch(NonTrackSession lunch) {
        this.lunch = lunch;
    }

    public TrackSession getAfternoonSession() {
        return afternoonSession;
    }

    public void setAfternoonSession(TrackSession afternoonSession) {
        this.afternoonSession = afternoonSession;
    }

    public NonTrackSession getNetworkingEvent() {
        return networkingEvent;
    }

    public void setNetworkingEvent(NonTrackSession networkingEvent) {
        this.networkingEvent = networkingEvent;
    }

    public int getTimeSaved() {
        return timeSaved;
    }

    public void setTimeSaved(int timeSaved) {
        this.timeSaved = timeSaved;
    }
}
