package se2xb3.bootstrap;

import se2xb3.control.AppController;
import se2xb3.tests.TestDataSource;

/**
 * Bootstrap the app
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/26/2017
 */
public class TwitterProcessorApp {

    public TwitterProcessorApp() {}

    static TwitterProcessorApp app;

    /**
     * Bootrap the app
     * @param args input args
     */
    public static void main(String[] args) {
        AppController app = AppController.getInstance();
        TestDataSource.waitForEver();
        //TestDataSource.main(new String[]{"a"});

    }

}
