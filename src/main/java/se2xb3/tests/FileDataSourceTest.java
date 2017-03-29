package se2xb3.tests;

import org.junit.*;//Before;
import org.junit.Test;
import se2xb3.control.AppController;
import se2xb3.io.source.FileDataSource;
import se2xb3.io.IOController;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//import static org.junit.Assert*;
/**
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class FileDataSourceTest {
    private final Lock lock = new ReentrantLock();
    private final Condition waitForTest = lock.newCondition();

    @Before
    public void setUp() throws Exception {

    }

    // list files in dir
    // new File("./").getCanonicalFile();
    // or new File("./").listFiles();
    @Test
    public synchronized void startSource() throws Exception {
        IOController controller = new IOController(AppController.getInstance());
        FileDataSource source = new FileDataSource(controller);
        Thread.currentThread().wait();

        waitForEver();
    }


    synchronized void waitForEver() {
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