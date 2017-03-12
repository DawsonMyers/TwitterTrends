package se2xb3.tests;

import se2xb3.control.AppController;
import se2xb3.data.source.FileDataSource;
import se2xb3.io.IOController;

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

    public TestDataSource() {}


    public static void main(String[] args) {

            //new Thread(()-> {
                IOController   controller = new IOController(AppController.getInstance());

                FileDataSource source     = new FileDataSource(controller);
                //Thread.currentThread().wait();
            //}).start();
            waitForEver();

    }

    static synchronized void waitForEver() {
        try {
            lock.lock();
            while (true)
                waitForTest.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
