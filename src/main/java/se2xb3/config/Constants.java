package se2xb3.config;

/**
 * System constants
 * @author Dawson Myers
 * @version 1.0
 * @since 3/10/2017
 */
public interface Constants {

    /**
     * The rate at which the simulated data source inserts messages into system.
     * The default value is {@value DATA_SOURCE_STREAM_RATE}.
     */
    int DATA_SOURCE_STREAM_RATE = 500;

    /**
     * The default input file name is set to {@value INPUT_FILE_NAME}.
     */
    String INPUT_FILE_NAME = "tweets-simple-min-100k.txt";
//    String INPUT_FILE_NAME = "tweets-10k.txt";

    /**
     * The default input file name is set to {@value INPUT_FILE}.
     */
    String INPUT_FILE = "data/tweets-simple-min-100k.txt";
//    String INPUT_FILE = "./data/tweets-10k.txt";

//    String INPUT_FILE = "./TwitterDataProcessor/data/tweets-1k.txt";

    /**
     * True if live streaming is enabled. The default value is {@value LIVE_STREAM}.
     */
    boolean LIVE_STREAM = false;

    /**
     * The regular expression to parse words, hashtags (words starting with '#'), and users
     * (words starting with '@'). The default value is {@value TWEET_REGEX}.
     */
    String TWEET_REGEX = "([@|#]*\\w)+";

    boolean TESTING = true;


    // Web server and REST constants
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Default count of items to respond to a REST request.  The default value is {@value DEFAULT_REST_RESP_COUNT}.
     */
    int DEFAULT_REST_RESP_COUNT = 10;

    /**
     * Maximum count of items that a REST request can ask for (i.e. /trends/users/500). The default
     * value is {@value MAX_REST_RESP_COUNT}. This is to stop people from requesting something like
     * this: trends/100000000000.
     */
    int MAX_REST_RESP_COUNT = 500;

    /**
     * Javadoc root url path (i.e. the root path for DawsonMyers.ca/docs is "docs").
     *  The default value is {@value JAVADOC_ROOT_PATH}.
     */
    String JAVADOC_ROOT_PATH = "docs";

    /**
     * Javadoc index.html path. The default value is {@value JAVADOC_INDEX_FILE}.
     */
    String JAVADOC_INDEX_FILE = JAVADOC_ROOT_PATH + "/" + "index.html";

    /**
     * Web app root url path (i.e. the root path for DawsonMyers.ca/ is "" or "/"). This is the url
     * that bootstraps the web app.
     */
    String WEB_APP_ROOT_PATH = "";

    /**
     * Web app index.html path. This is the file that bootstraps the web app.
     * The default value is {@value WEB_APP_ROOT_FILE}.
     */
    String WEB_APP_ROOT_FILE = "index.html";


    // REST resource constants
    //

    /**
     * The regex for the trend REST resource. The default value is {@value REST_TREND_RESOURCE_PATH_REGEX}.
     */
    String REST_TREND_RESOURCE_PATH_REGEX = "trends/:type?/:count?";

    /**
     * All word mentions REST resource name. The default value is {@value REST_RESOURCE_TRENDS_ALL}.
     */
    String REST_RESOURCE_TRENDS_ALL = "all";

    /**
     * Hashtag mentions REST resource name. The default value is {@value REST_RESOURCE_TRENDS_HASHTAGS}.
     */
    String REST_RESOURCE_TRENDS_HASHTAGS = "hashtags";

    /**
     * User mentions REST resource name. The default value is {@value REST_RESOURCE_TRENDS_USERS}.
     */
    String REST_RESOURCE_TRENDS_USERS = "users";

    /**
     * REST response message when the request doesn't match any resources.
     *  The default value is {@value REST_REQUEST_NO_MATCH}.
     */
    String REST_REQUEST_NO_MATCH = "NO REST RESOURCE MATCH";
}
