package se2xb3.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import se2xb3.config.Constants;
import se2xb3.data.algorithms.GraphStrategy;
import se2xb3.data.algorithms.SearchStrategy;
import se2xb3.data.algorithms.SortStrategy;
import se2xb3.data.algorithms.WordIndexer;
import se2xb3.data.models.Tweet;
import se2xb3.data.processing.TweetProcessor;

import java.util.ArrayList;
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
    List<Tweet> tweetsList = new ArrayList<>();
    WordIndexer indexer = new WordIndexer();
    DataController dataController;
    TweetProcessor tweetProcessor = new TweetProcessor();

    SortStrategy   sortStrategy   = new SortStrategy();
    GraphStrategy  graphStrategy  = new GraphStrategy();
    SearchStrategy searchStrategy = new SearchStrategy();
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


    /**
     * Process a tweet string by deserializing it into a new tweet object.
     * Then store it in a list and send it for further processing and analysis.
     * @param tweetStr
     */
    public void processTweet(String tweetStr) {
        Tweet tweet = tweetProcessor.deserializeTweet(tweetStr);
        tweetsList.add(tweet);
        processTweetText(tweet);
    }


    /**
     * Process the text of each tweet as they are received. The words are
     * extracted from the string using regular expressions and then indexed.
     * @param tweet
     */
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
