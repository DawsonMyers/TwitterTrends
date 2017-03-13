package se2xb3.io;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that asynchronously decouples incoming messages from the rest of the system by
 * running the buffer in separate thread. It continuously tries to take
 * messages from a blocking queue.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class AsyncMessageLooper<M> implements Runnable, IMessageQueue<M>{

    private volatile LinkedBlockingQueue<M> blockingQueue = new LinkedBlockingQueue<M>();
    private IMessageReceiver<M> messageReceiver;
    private boolean doShutdown = false;

    /**
     * Contructor that takes a message receiver
     *
     * @param receiver
     * @param executorService
     */
    public AsyncMessageLooper(IMessageReceiver<M> receiver, ExecutorService
            executorService) {
//        super("AsyncMessageBuffer Thread");
        messageReceiver = receiver;
        executorService.execute(this);
//        this.start();
//        new Thread().
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
        while (!doShutdown) {

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


    /**
     * Shutdown thhread by breaking out of the message loop.
     */
    public void shutdown() {
        doShutdown = true;
        blockingQueue.add((M) new Object());

    }

}
