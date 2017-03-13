package se2xb3.tests;

import se2xb3.control.AppController;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class TestDataSource {
    private static final Lock      lock        = new ReentrantLock();
    private static final Condition waitForTest = lock.newCondition();
    static volatile boolean isDone = false;
    public static volatile boolean testing = true;
    public TestDataSource() {}


    public static void main(String[] args) {

        AppController app = AppController.getInstance();
            waitForEver();
    }

    // used to block until test is completed
    static volatile LinkedBlockingQueue<String> blockingQueue = new
            LinkedBlockingQueue<>();

    static  void waitForEver() {
        try {
            blockingQueue.take(); // wait here
            AppController.shutdownApp();
//            lock.lock();
//            while (!isDone)
//                waitForTest.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
        }
    }


    public static  void endTest() {
//        isDone = true;
//        waitForTest.signal();

        blockingQueue.add("Done");
    }

}
