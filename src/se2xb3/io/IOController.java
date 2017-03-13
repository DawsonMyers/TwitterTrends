package se2xb3.io;

import se2xb3.control.AppController;
import se2xb3.control.Controller;
import se2xb3.control.EventBus;
import se2xb3.io.source.DataSource;
import se2xb3.io.source.FileDataSource;

import java.util.concurrent.ExecutorService;

/**
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class IOController extends Controller {

    private DataSource dataSource;
    private AppController app;


    /**
     * A constructor that takes an instance of the AppConstroller.
     * @param appController
     */
    public IOController(AppController appController) {
        app = appController;
        init();}

    /**
     * Initialize the controller by creating a new data source instance.
     */
    private void init() {
        dataSource = new FileDataSource(this);
    }


    /**
     * Post the message to the event bus so that it can be delivered for
     * processing.
     * @param msg
     */
    public void onMessageReceived(String msg) {
        EventBus.postNewMessageEvent(msg);
    }

    /**
     * Return the executorService instance
     * @return executorService
     */
    public  ExecutorService getExecutorService() {
        return AppController.getExecutorService();
    }

    /**
     * Shutdown blocking queue thread.
     */
    @Override public void shutdown() {
        dataSource.shutdown();
    }
}
