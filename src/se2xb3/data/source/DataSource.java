package se2xb3.data.source;

import se2xb3.io.AsyncMessageBuffer;
import se2xb3.io.IMessageQueue;
import se2xb3.io.IOController;
import se2xb3.io.MessageHandler;

/**
 * Abstract base class for data sources.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/10/2017
 */
public abstract class DataSource extends Thread {

    protected String                url;
    protected AsyncMessageBuffer<String> queue;
//    protected IMessageQueue<String> queue;
    protected MessageHandler msgHandler;
    protected IOController controller;

    /**
     * This method is called when the thread is started. It begins the process
     * of reading data from a data source.
     */
    abstract void startSource();


    /**
     * Constructor that takes an IOController.
     *
     * @param controller
     */
    public DataSource(IOController controller) {
        super("DataSource Thread");
        this.controller = controller;
        start();
    }
//    public DataSource(IMessageQueue<String> queue) {
//        this.queue = queue;
//
//    }

    /**
     * Method to run when the thread is started.
     */
    public void run() {
        // The handler has to be given the controller instance so that it can
        // pass messages to it when they are received.
        msgHandler = new MessageHandler(controller);
        // The queue is given the handler instance so that messages can be
        // taken from the queue and given to the handler. The queue runs in a
        // separate thread.
        queue = new AsyncMessageBuffer<String>(msgHandler);

        // Now that all the components involved in passing data through the
        // IO subsystem have been initialized, the data source implementation
        // can be started and begin feeding messages into it as they are
        // received.
        startSource();
    }


    /**
     * Get the url string.
     */
    public String getUrl() {
        return url;
    }


    /**
     * Set the url string. This could be any relavent url that is used in
     * conjunction with a data source.
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the message queue.
     */
    public IMessageQueue<String> getQueue() {
        return queue;
    }

    /**
     * Set the message queue.
     *
     * @param queue
     */
    public void setQueue(AsyncMessageBuffer<String> queue) {
        this.queue = queue;
    }

}
