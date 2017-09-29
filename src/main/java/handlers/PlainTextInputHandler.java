package handlers;

import config.Constants;
import exceptions.InvalidTopicList;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PlainTextInputHandler extends InputHandler {

    public PlainTextInputHandler(){
        super(Constants.PLAIN_TEXT_TYPE);
    }

    @Override
    public List<String> getTopicListFromInput() throws Exception {
        List<String> topicList = new ArrayList<String>();
        try{
            ClassLoader classLoader = getClass().getClassLoader();
            FileInputStream fstream = new FileInputStream(classLoader.getResource(this.input).getFile());
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();

            while (strLine != null)   {
                topicList.add(strLine);
                strLine = br.readLine();
            }

            in.close();
        }catch (Exception ex){
            System.err.println("Error: " + ex.getMessage());
        }

        if(topicList.isEmpty())
            throw new InvalidTopicList();

        return topicList;
    }
}
