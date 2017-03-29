package se2xb3.io;

/**
 * An interface for a message queue.
 *
 * @author Dawson
 * @version 1.0
 * @since 3/11/2017
 */
public interface IMessageQueue<M> {
    /**
     * Inserts the specified element into a queue.
     *
     * @param msg a message
     */
    public void enqueue(M msg);

    /**
     * Shutdown.
     */
    public void shutdown();
}
