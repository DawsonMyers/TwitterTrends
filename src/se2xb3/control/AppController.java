package se2xb3.control;

import se2xb3.data.DataController;
import se2xb3.io.IOController;

/**
 * Main app controller.
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class AppController {
    // Singleton instance.
    private static AppController app = new AppController();

    private IOController   ioController;
    private DataController dataController;

    /**
     * Private constructor for singleton instance.
     */
    private AppController() {
        ioController  = new IOController(this);
        dataController  = new DataController(this);
    }

    /**
     * Singleton getter.
     */
    public static AppController getInstance() {return app;}


    /**
     * Get instance the data controller instance.
     */
    public static DataController getDataController() {
        return app.dataController;
    }

    /**
     * Get instance the data controller instance.
     */
    public static IOController getIOController() {
        return app.ioController;
    }
}
