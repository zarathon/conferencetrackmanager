package handlers;

import config.Constants;
import exceptions.HandlerNotFoundException;
import models.ConferenceTrack;
import models.Talk;
import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public abstract class OutputHandler {
    protected OutputHandler next;
    protected String type;
    protected List<ConferenceTrack> conferenceTracks;

    public OutputHandler(String type){
        next = null;
        this.type = type;
    }

    public String writeOut(String type, List<ConferenceTrack> conferenceTracks) throws Exception {
        this.conferenceTracks = conferenceTracks;
        if (canHandle(type)) {
            return writeOut();
        } else {
            if (next == null) {
                throw new HandlerNotFoundException();
            }
            return next.writeOut(type, conferenceTracks);
        }
    }

    private boolean canHandle(String type) {
        if (this.type.equals(type)) {
            return true;
        }
        return false;
    }

    protected String convertConferenceTracksToString(){
        StringBuffer content = new StringBuffer();
        DateFormat dateFormat = new SimpleDateFormat("hh:mma");


        DateTime dateTime;

        int minutesCounter;

        for (ConferenceTrack track : this.conferenceTracks){
            content.append("Track "+track.getTrackNumber()+":\n");

            minutesCounter = 0;

            for(Talk talk : track.getMorningSession().getSessionTalks()){
                dateTime = new DateTime(2017, 1, 1, Constants.START_MORNING_HOUR, 00, 00);
                dateTime = dateTime.plusMinutes(minutesCounter);
                content.append(dateFormat.format(dateTime.toDate())+" "+talk.getTitle()+"\n");
                minutesCounter +=talk.getDuration();
            }

            dateTime = new DateTime(2017, 1, 1, 12, 00, 00);
            content.append(dateFormat.format(dateTime.toDate())+" "+track.getLunch().getName()+"\n");

            minutesCounter = 0;

            for(Talk talk : track.getAfternoonSession().getSessionTalks()){
                dateTime = new DateTime(2017, 1, 1, Constants.START_AFTERNOON_HOUR, 00, 00);
                dateTime = dateTime.plusMinutes(minutesCounter);
                content.append(dateFormat.format(dateTime.toDate())+" "+talk.getTitle()+"\n");
                minutesCounter +=talk.getDuration();
            }

            if(track.getTimeSaved()<=60){
                dateTime = new DateTime(2017, 1, 1, Constants.NETWORK_EVENT_HOUR+1, 00, 00);
            }else{
                dateTime = new DateTime(2017, 1, 1, Constants.NETWORK_EVENT_HOUR, 00, 00);
            }
            content.append(dateFormat.format(dateTime.toDate())+" "+track.getNetworkingEvent().getName()+"\n");
            content.append("\n");
        }
        return content.toString();
    }

    public abstract String writeOut() throws Exception;
}
