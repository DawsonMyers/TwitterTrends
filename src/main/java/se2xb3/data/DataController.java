package se2xb3.data;

import se2xb3.control.AppController;
import se2xb3.control.Controller;
import se2xb3.data.models.Tweet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A class controls processing and analysis of the tweet data.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class DataController extends Controller {
    private AppController app;
    private DataHandler   dataHandler;// = new DataHandler();
    private List<Tweet> tweetList = new ArrayList<>();

    /**
     * Constructor that takes an instance of the AppController.
     * @param appController the app controller instance
     */
    public DataController(AppController appController) {
        app = appController;
        dataHandler = new DataHandler(this);
    }

    /**
     * Called whenever a message is received from the IO subsystem.
     * @param msg a message string
     */
    public void onMessageReceivedEvent(String msg) {
//        System.out.println(msg);
        dataHandler.processTweet(msg);
    }

    /**
     * Get list of trends
     * @return a list of maps of the top trending items
     */
    public List<Tweet> getTweetList() {
        return tweetList;
    }

    /**
     * Get list of trends
     * @return a list of maps of the top trending items
     */
    public List<Map<String, Integer>> getTrends() {
        return dataHandler.getTrends();
    }
    
    /**
     * Get list of trends
     * @param count the number of top trending items to get
     * @return a list of maps of the top trending items
     */
    public List<Map<String, Integer>> getTrends(int count) {
        return dataHandler.getTrends(count);
    }

    /**
     * Get trending words.
     *
     * @param count the number of top trending items to get
     * @return a map of the top trending items
     */
    public Map<String, Integer> getTrendingWords(int count) {
        return dataHandler.getTrendingWords(count);
    }

    /**
     * Get trending hashtags.
     *
     * @param count number of top trending items to get.
     * @return a map of the top trending items
     */
    public Map<String, Integer> getTrendingHashtags(int count) {
        return dataHandler.getTrendingHashtags(count);
    }

    /**
     * Get trending users.
     *
     * @param count number of top trending items to get.
     * @return a map of the top trending items
     */
    public Map<String, Integer> getTrendingUsers(int count) {
        return dataHandler.getTrendingUsers(count);
    }

    /**
     * Shutdown.
     */
    @Override
    public void shutdown() {

    }

    public void resetData(){
        dataHandler.resetData();
    }

}
