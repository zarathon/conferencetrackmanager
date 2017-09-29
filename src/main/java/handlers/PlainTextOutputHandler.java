package handlers;

import config.Constants;
import models.ConferenceTrack;
import models.Talk;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PlainTextOutputHandler extends OutputHandler{

    public PlainTextOutputHandler(){
        super(Constants.PLAIN_TEXT_TYPE);
    }

    @Override
    public String writeOut() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = classLoader.getResource("").getPath()+"output.txt";

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(this.convertConferenceTracksToString());

            if (bw != null)
                bw.close();

            if (fw != null)
                fw.close();

            return file;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
