package se2xb3.io;

import se2xb3.io.source.DataSource;

/**
 * A class that handles messages from a data source. When a data source
 * receives a message it inserts it into an implementation of IMessageQueue
 * and then waits for more messages to arrive. Messages are then taken from the
 * queue as fast as they can be processed and passed to the message handler
 * by calling receiveMessage() on it. The message is then passed to the
 * IOController instance where it is then sent to be processed by the data
 * controller.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class MessageHandler implements IMessageReceiver<String> {

    //    private IOController controller;
    private DataSource dataSource;
    //private DataSource dataSource;

    /**
     * Constructor that takes a DataSource instance. This reference is
     * required so that messages from the data source can be passed back to
     * the controller using the onMessageReceived() hook.
     *
     * @param dataSource a data source implementation
     */
    public MessageHandler(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    /**
     * Receive new message from message queue and send it to be processed.
     *
     * @param msg a string message
     */
    @Override
    public synchronized void receiveMessage(String msg) {
        dataSource.passMessageToController(msg);
    }

    /**
     * Get DataSource instance.
     *
     * @return a data source implementation
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * Set DataSource instance.
     *
     * @param dataSource a data source implementation
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Shutdown.
     */
    public void shutdown() {
    }

}
