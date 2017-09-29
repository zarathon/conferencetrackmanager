package services;

import config.Constants;
import models.ConferenceTrack;
import models.Talk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConferenceManager {

    private List<ConferenceTrack> tracks;
    private List<Talk> talks;

    public ConferenceManager(List<String> topics) throws Exception {
        this.talks = getTalksFromTopics(topics);
        this.talks = orderByTalkDuration(this.talks);
        this.tracks = generateConferenceTracksList(this.talks);
    }

    public List<ConferenceTrack> getTracks() {
        return tracks;
    }

    public void setTracks(List<ConferenceTrack> tracks) {
        this.tracks = tracks;
    }

    private List<ConferenceTrack> generateConferenceTracksList(List<Talk> talks){
        List<ConferenceTrack> tracks = new ArrayList<ConferenceTrack>();
        for (int i = 0; i<calculateNumberOfConferenceTracks(talks);i++){
            tracks.add(new ConferenceTrack(i+1));
        }
        return tracks;
    }


    public List<Talk> getTalksFromTopics(List<String> topics) throws Exception {
        List<Talk> talks = new ArrayList<Talk>();

        for (String topic:topics){
            Talk talk = new Talk(topic);
            talks.add(talk);
        }

        return talks;
    }

    public int getTotalTalksTime(List<Talk> talksList){
        if(talksList == null || talksList.isEmpty())
            return 0;

        int totalTime = 0;
        for(Talk talk : talksList) {
            totalTime += talk.getDuration();
        }
        return totalTime;
    }


    public int calculateNumberOfConferenceTracks(List<Talk> talks){

        int totalTimeTalks = getTotalTalksTime(talks);
        int totalTimeInAConferenceTrack = Constants.TRACK_SESSION_MAX_MINUTES + Constants.TRACK_SESSION_MIN_MINUTES;
        if(totalTimeTalks%totalTimeInAConferenceTrack==0)
            return totalTimeTalks/totalTimeInAConferenceTrack;

        return totalTimeTalks/totalTimeInAConferenceTrack + 1;
    }

    public List<Talk> orderByTalkDuration(List<Talk> talks){
        Collections.sort(talks);
        return talks;
    }

    public List<ConferenceTrack> doSchedule(){
        for(ConferenceTrack track : this.tracks){
            boolean morningSessionFull = false;
            boolean afternoonSessionFull = false;

            int morningDurationTime = track.getMorningSession().getDuration();
            for(int i = this.talks.size()-1;i>=0;i--){
                if(morningDurationTime>=this.talks.get(i).getDuration() && !morningSessionFull){
                    track.getMorningSession().getSessionTalks().add(this.talks.get(i));
                    morningDurationTime -= this.talks.get(i).getDuration();
                    this.talks.remove(i);
                }
                if(morningDurationTime==0)
                    morningSessionFull=true;
            }

            morningSessionFull = true;

            int afternoonDurationTime = track.getAfternoonSession().getDuration();
            for(int i = this.talks.size()-1;i>=0;i--){
                if(morningSessionFull){
                    if(afternoonDurationTime>=this.talks.get(i).getDuration() && !afternoonSessionFull){
                        track.getAfternoonSession().getSessionTalks().add(this.talks.get(i));
                        afternoonDurationTime -= this.talks.get(i).getDuration();
                        this.talks.remove(i);
                    }
                    if(afternoonDurationTime==0)
                        morningSessionFull=true;
                }
            }

            track.setTimeSaved(track.getTimeSaved()+morningDurationTime+afternoonDurationTime);

        }
        return this.tracks;
    }


}
