package se2xb3.control;

import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.listener.Listener;

/**
 * A class to containing observable events using an eventbus.
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class EventBus {

    private static EventBus  bus = null;

    private MBassador eventBus = null;

    /**
     * Constructor for singleton instance of EventBus.
     */
    private EventBus() {
        eventBus = new MBassador();
    }

    /**
     * Singleton getter.
     */
//    public EventBus getEventbus() {
//        // return singleton
//        return bus;
//    }

    /**
     * Post new message to be processed.
     */
    public static void postNewMessageEvent(String msg) {
        AppController.getDataController().onMessageReceivedEvent(msg);
    }


    /**
     * A class that handles events
     */
    @Listener
    class MessageListener {
    }

    class MessageReceivedEvent{

    }


}
