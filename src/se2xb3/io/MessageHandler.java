package se2xb3.io;

/**
 * A class that handles messages from a data source. When a data source
 * receives a message it inserts it into an implementation of IMessageQueue
 * and then waits for more messages to arrive. Messages are then taken from the
 * queue as fast as they can be processed and passed to the message handler
 * by calling receiveMessage() on it. The message is then passed to the
 * IOController instance where it is then sent to be processed by the data
 * controller.
 * the
 * Messages are received
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class MessageHandler implements IMessageReceiver<String> {

    private IOController controller;

    //private DataSource dataSource;

    /**
     * Constructor that takes IOController instance.
     * @param controller
     */
    public MessageHandler(IOController controller) {
        this.controller = controller;
    }


    /**
     * Receive new message from message queue and send it to be processed.
     * @param msg
     */
    @Override public synchronized void receiveMessage(String msg) {
        controller.onMessageReceived(msg);
    }

    /**
     * Get controller instance.
     */
    public IOController getController() {
        return controller;
    }

    /**
     * Set controller instance.
     * @param controller
     */
    public void setController(IOController controller) {
        this.controller = controller;
    }


}
