package se2xb3.data.source;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import se2xb3.config.Constants;
import se2xb3.data.DataProcessor;
import se2xb3.data.models.Tweet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dawson
 * @version 1.0
 * @since 3/10/2017
 */
public class FileDataSource implements Constants{
     String       fname        = INPUT_FILE;
     ObjectMapper objectMapper = new ObjectMapper();
     List<Tweet> tweets;// = new ArrayList<>();
    DataProcessor processor;

    public FileDataSource(DataProcessor dp) {processor = dp;}

    public List<Tweet> readData(){
       return readDataFromFile(fname);
    }
    public List<Tweet> readDataFromFile(String name) {
        List<Tweet> tweetList = new ArrayList<>();
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                count++;
                //println(line);
                JsonNode n     = jsonStringToTree(line);
                Tweet    tweet = new Tweet(n);
                tweetList.add(tweet);
                process(tweet);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       // println("Count = " + count);
        return tweetList;
    }

    private  void process(Tweet tweet) {
        processor.processTweet(tweet);
    }

    private JsonNode jsonStringToTree(String jsonStr) {

//        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {

            node = objectMapper.readValue(jsonStr, JsonNode.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return node;
    }


    ////////////////////////////////////////////////////////////
    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }

}

