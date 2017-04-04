package se2xb3.config;

/**
 * System constants
 * @author Dawson
 * @version 1.0
 * @since 3/10/2017
 */
public interface Constants {

    /**
     * The default input file name is set to {@value INPUT_FILE}.
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
     * True if live streaming is enabled.
     */
    boolean LIVE_STREAM = false;

    /**
     * The regular expression to parse words, hashtags (words starting with '#'), and users
     * (words starting with '@').
     */
    String TWEET_REGEX = "([@|#]*\\w)+";

    boolean TESTING = true;


    // Web server and REST constants
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Default count of items to respond to a REST request
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
     */
    String JAVADOC_ROOT_PATH = "docs";

    /**
     * Javadoc index.html path.
     */
    String JAVADOC_INDEX_FILE = JAVADOC_ROOT_PATH + "/" + "index.html";

    /**
     * Web app root url path (i.e. the root path for DawsonMyers.ca/ is "" or "/"). This is the url
     * that bootstraps the web app.
     */
    String WEB_APP_ROOT_PATH = "";

    /**
     * Web app index.html path. This is the file that bootstraps the web app.
     */
    String WEB_APP_ROOT_FILE = "index.html";


    // REST resource constants
    //

    /**
     * The regex for the trend REST resource
     */
    String REST_TREND_RESOURCE_PATH_REGEX = "trends/:type?/:count?";

    /**
     * All word mentions REST resource name.
     */
    String REST_RESOURCE_TRENDS_ALL = "all";

    /**
     * Hashtag mentions REST resource name.
     */
    String REST_RESOURCE_TRENDS_HASHTAGS = "hashtags";

    /**
     * User mentions REST resource name.
     */
    String REST_RESOURCE_TRENDS_USERS = "users";

    /**
     * REST response message when the request doesn't match any resources.
     */
    String REST_REQUEST_NO_MATCH = "NO REST RESOURCE MATCH";
}
