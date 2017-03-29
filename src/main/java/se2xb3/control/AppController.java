package se2xb3.control;

import se2xb3.data.DataController;
import se2xb3.io.IOController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Main app controller.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class AppController extends Controller {
    // Singleton instance.
    private static AppController app = getInstance();
    private static volatile ExecutorService executorService;// = Executors.newFixedThreadPool(5);
    private static          IOController    ioController;
    private static          DataController  dataController;

    /**
     * Private constructor for singleton instance.
     */
    private AppController() {
        //app = this;
        executorService = Executors.newFixedThreadPool(5);
        ioController = new IOController(this);
        dataController = new DataController(this);
    }

    /**
     * Start app.
     *
     * @return a reference to the app controller
     */
    public static AppController start() {
//        if(app == null) app  = new AppController();
        return getInstance();
    }

    /**
     * Singleton getter.
     *
     * @return a reference to the app controller
     */
    public static AppController getInstance() {
        if (app == null) app = new AppController();
        return app;
    }


    /**
     * Shutdown thread pool.
     */
    public static void shutdownApp() {
        app.shutdown();
        try {
            System.out.println("attempt to shutdown executor");
            TimeUnit.SECONDS.sleep(2);
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executorService.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    /**
     * Shutdown thread pool.
     */
    public void shutdown() {
        dataController.shutdown();
        ioController.shutdown();
    }

    /**
     * Return the executorService instance
     *
     * @return executorService the executor service
     */
    public static ExecutorService getExecutorService() {
        return executorService;
    }

    /**
     * Get instance the data controller instance.
     *
     * @return a reference to the IOController
     */
    public static DataController getDataController() {
        return getInstance().dataController;
    }

    /**
     * Get instance the data controller instance.
     *
     * @return a reference to the IOController
     */
    public static IOController getIOController() {
        return ioController;
    }

}
