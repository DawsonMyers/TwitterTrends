package se2xb3.io;

/**
 * @author Dawson
 * @version 1.0
 * @since 3/11/2017
 */
public interface IMessageReceiver<M> {
    void receiveMessage(M msg);
}
