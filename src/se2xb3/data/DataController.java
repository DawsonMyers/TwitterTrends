package se2xb3.data;

import se2xb3.control.AppController;
import se2xb3.data.models.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * A class controls processing and analysis of the tweet data.
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class DataController {
    private AppController app;
    private DataHandler dataHandler;// = new DataHandler();
    private volatile List<Tweet> tweetList = new ArrayList<>();

    /**
     * Constructor that takes an instance of the AppController.
     */
    public DataController(AppController appController) {
        app = appController;
        dataHandler = new DataHandler(this);
    }

    /**
     *
     */
    public void onMessageReceivedEvent(String msg) {
//        System.out.println(msg);
        dataHandler.processTweet(msg);

    }
}
