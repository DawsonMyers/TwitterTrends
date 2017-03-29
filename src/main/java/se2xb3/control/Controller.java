package se2xb3.control;

/**
 * Abstract base class for controllers
 * @author Dawson Myers
 * @version 1.0
 * @since 3/12/2017
 */
public abstract class Controller {

    public Controller() {}

    /**
     * Shutdown blocking queue.
     */
    public abstract void shutdown();

    ////////////////////////////////////////////////////////////
    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }
}
