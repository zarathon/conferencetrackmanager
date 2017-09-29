package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TalkUtil {
    public static String getTitleFromTopic(String topic){

        if(topic.toLowerCase().endsWith("lightning")){
            return topic.replaceAll("lightning", "").trim();
        }

        Pattern pattern = Pattern.compile(".+?(?=[0-9].min)");
        Matcher matcher = pattern.matcher(topic);

        while(matcher.find()){
            return matcher.group().trim();
        }
        return "";
    }

    public static int getDurationFromTopic(String topic){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(topic);

        String tempDuration = "";
        while (matcher.find()){
            tempDuration = matcher.group();
        }

        if(tempDuration != ""){
            return Integer.parseInt(tempDuration);
        } else{
            if((topic.toLowerCase().contains("lightning"))) {
                return 5;
            }
        }
        return -1;
    }
}
