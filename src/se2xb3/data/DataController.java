package se2xb3.data;

import se2xb3.control.AppController;
import se2xb3.control.Controller;
import se2xb3.data.models.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * A class controls processing and analysis of the tweet data.
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class DataController extends Controller {
    private AppController app;
    private DataHandler dataHandler;// = new DataHandler();
    private  List<Tweet> tweetList = new ArrayList<>();

    /**
     * Constructor that takes an instance of the AppController.
     */
    public DataController(AppController appController) {
        app = appController;
        dataHandler = new DataHandler(this);
    }

    /**
     * Called whenever a message is received from the IO subsystem.
     */
    public void onMessageReceivedEvent(String msg) {
//        System.out.println(msg);
        dataHandler.processTweet(msg);


    }

    /**
     * Get list of tweets
     */
    public List<Tweet> getTweetList() {
        return  tweetList;
    }

    /**
     * Shutdown.
     */
    @Override public void shutdown() {

    }
}
