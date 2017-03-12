package se2xb3.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import se2xb3.config.Constants;
import se2xb3.data.algorithms.WordIndexer;
import se2xb3.data.models.Tweet;
import se2xb3.data.source.TweetProcessor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class to process JSON encoded tweets.
 * @author Dawson Myers
 * @version 1.0
 * @since 2/23/2017
 */

public class DataHandler implements Constants {

    //    static String fname = "./TwitterDataProcessor/data/tweets-100.txt";
    String       fname        = "./TwitterDataProcessor/data/tweets-100k.txt";
    ObjectMapper objectMapper = new ObjectMapper();
    List<Tweet> tweets;// = new ArrayList<>();
    WordIndexer indexer = new WordIndexer();
    DataController dataController;
    TweetProcessor tweetProcessor = new TweetProcessor();
    // regex to get words/hashtags/usernames from tweet body


    public DataHandler(DataController dataController) {
        this.dataController = dataController;
    }


//    public static void main(String[] args) {
//
//        //JsonNode tree = jsonStringToTree(json);
//
//        //println(tree.findValue("id").asText());
//
//        //tweets = readDataFromFile(fname);
//
//        DataHandler    dp         = new DataHandler();
//        FileDataSource dataSource = new FileDataSource(dp);
//
//        dataSource.readData();
//        println(dp.indexer.max()+"");
//
//    }



    public void processTweet(String tweet) {

        //processTweetText(tweet);
    }

    private void processTweetText(Tweet tweet) {
        // extract all words from the tweet's text using a regular expression
        Matcher matcher = Pattern.compile(TWEET_REGEX).matcher(tweet.getText());

        String word = "";

//        matcher.find();
        while (matcher.find()) {
            word = matcher.group(0);
            if(word.length()< 3) continue;

            indexWord(word, tweet);

            //println(word);
        }

//        println(indexer.max()+"");

    }

    public void indexWord(String word, Tweet tweet) {
        indexer.addWord(word, tweet);
    }


    ////////////////////////////////////////////////////////////
    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }

}
