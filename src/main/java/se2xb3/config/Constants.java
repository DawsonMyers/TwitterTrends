package se2xb3.config;

/**
 * System constants
 * @author Dawson
 * @version 1.0
 * @since 3/10/2017
 */
public interface Constants {
    String INPUT_FILE = "./data/tweets-10k.txt";
//    String INPUT_FILE = "./TwitterDataProcessor/data/tweets-1k.txt";
    boolean LIVESTREAM = false;
    String TWEET_REGEX = "([@|#]*\\w)+";

    boolean TESTING = true;
}