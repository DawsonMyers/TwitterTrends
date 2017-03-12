package se2xb3.io;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that asynchronously decouples incoming messages from the rest of the system by
 * running the buffer in separate thread.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class AsyncMessageBuffer<M> extends Thread implements IMessageQueue<M>{

    private volatile LinkedBlockingQueue<M> blockingQueue = new LinkedBlockingQueue<M>();
    private IMessageReceiver<M> messageReceiver;


    /**
     * Contructor that takes a message receiver
     *
     * @param receiver
     */
    public AsyncMessageBuffer(IMessageReceiver<M> receiver) {
        super("AsyncMessageBuffer Thread");
        messageReceiver = receiver;
        this.start();
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, throwing an
     * IllegalStateException if no space is currently available.
     *
     * @param msg
     */
    public  void enqueue(M msg) {
        blockingQueue.add(msg);
    }

    /**
     * Start message loop thread.
     */
    public void run() {
        while (true) {

            M msg;
            try {
                // Loop forever, taking messages from the queue when available.
                msg =  blockingQueue.take();
                //if(msg instanceof String) System.out.println(msg);
                messageReceiver.receiveMessage(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
