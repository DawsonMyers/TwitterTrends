package se2xb3.io;

import se2xb3.control.AppController;
import se2xb3.control.Controller;
import se2xb3.io.source.DataSource;
import se2xb3.io.source.FileDataSource;
import se2xb3.io.web.WebServer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * Controls all subsystems that involve input/output operations with external resources.
 * <br><br>
 * <p>
 * The first subsystem is a {@link DataSource} which is an abstract class that can be implemented
 * for any external data source (e.g. Twitter/Facebook/Instagram streams, IoT message brokers,
 * databases, etc.). {@link FileDataSource} is a concrete implementation of {@link DataSource} and
 * is
 * used in the current system setup. It simulates a stream of tweets by reading prerecorded tweets
 * from a file and then inserting them one at a time into the system to be processed.
 * <br><br>
 * <p>
 * The second subsystem is a web server. It provides a REST endpoint that provides data trends from
 * the processed tweets. It also serves an AngularJs web app.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class IOController extends Controller {

    private        DataSource    dataSource;
    private static AppController app;
    private        WebServer     webServer;

    /**
     * A constructor that takes an instance of the AppConstroller.
     *
     * @param appController the controller instance
     */
    public IOController(AppController appController) {
        app = appController;
        init();
    }

    /**
     * Initialize the controller by creating a new data source instance.
     */
    private void init() {
        dataSource = new FileDataSource(this);
        webServer = new WebServer(this);
        getExecutorService().execute(webServer);
    }


    /**
     * Post the message to the event bus so that it can be delivered for
     * processing.
     *
     * @param msg a message string
     */
    public void onMessageReceived(String msg) {
//        EventBus.postNewMessageEvent(msg);
        AppController.getDataController().onMessageReceivedEvent(msg);
    }

    /**
     * Return the executorService instance
     *
     * @return executorService
     */
    public ExecutorService getExecutorService() {
        return AppController.getExecutorService();
    }

    /**
     * Shutdown blocking queue thread.
     */
    @Override
    public void shutdown() {
        dataSource.shutdown();
    }

    /**
     * Get trends from data controller
     *
     * @return list of trends
     */
    public List<Map<String, Integer>> getTrends() {
        return AppController.getDataController().getTrends();
    }

    /**
     * Get trends from data controller
     *
     * @param count the number of trends to get
     * @return list of trends
     */
    public List<Map<String, Integer>> getTrends(int count) {
        return AppController.getDataController().getTrends(count);
    }

    /**
     * Get trending words.
     *
     * @param count number of top trending items to get.
     * @return a map containing the top trending items
     */
    public Map<String, Integer> getTrendingWords(int count) {
        return AppController.getDataController().getTrendingWords(count);
    }

    /**
     * Get trending hashtags.
     *
     * @param count number of top trending items to get.
     * @return a map containing the top trending items
     */
    public Map<String, Integer> getTrendingHashtags(int count) {
        return AppController.getDataController().getTrendingHashtags(count);
    }

    /**
     * Get trending users.
     *
     * @param count number of top trending items to get.
     * @return a map containing the top trending items
     */
    public Map<String, Integer> getTrendingUsers(int count) {
        return AppController.getDataController().getTrendingUsers(count);
    }
}
