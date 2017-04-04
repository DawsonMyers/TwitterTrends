package se2xb3.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import se2xb3.config.Constants;
import se2xb3.data.algorithms.GraphStrategy;
import se2xb3.data.algorithms.SearchStrategy;
import se2xb3.data.algorithms.SortStrategy;
import se2xb3.data.algorithms.WordNode;
import se2xb3.data.models.Tweet;
import se2xb3.data.processing.TweetProcessor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A class to process tweets and use various algorithms to sort, search, and graph the data.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 2/23/2017
 */

public class DataHandler implements Constants {

    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Tweet>  tweetsList   = new ArrayList<>();

    private DataController dataController;
    private TweetProcessor tweetProcessor = new TweetProcessor();

    private SortStrategy   sortStrategy   = new SortStrategy();
    private GraphStrategy  graphStrategy  = new GraphStrategy();
    private SearchStrategy searchStrategy = new SearchStrategy();

    // comparator to sort maps by value
    private Comparator<Map.Entry<String, Integer>> byValue      =
            (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue());

    /**
     * Constructor
     *
     * @param dataController a reference to the data controller
     */
    public DataHandler(DataController dataController) {
        this.dataController = dataController;
    }


    /**
     * Process a tweet string by deserializing it into a new tweet object.
     * Then store it in a list and send it for further processing and analysis.
     *
     * @param tweetStr a string containing a JSON encoded tweet
     */
    public void processTweet(String tweetStr) {
        Tweet tweet = tweetProcessor.deserializeTweet(tweetStr);

        // the simulator never cleared this list as it loaded tweets into the system, causing the
        // memory to run out and cause the program to crash
        //tweetsList.add(tweet);
        tweetProcessor.processTweetText(tweet);
    }

    /**
     * Get Get trending words.
     *
     * @return list containing the maps of the most popular word, hashtags, and user mentions.
     */
    public List<Map<String, Integer>> getTrends() {
        return getTrends(DEFAULT_REST_RESP_COUNT);
    }

    /**
     * Get trending words.
     *
     * @param count number of top trending items to get.
     * @return list containing the maps of the most popular word, hashtags, and user mentions.
     */
    public List<Map<String, Integer>> getTrends(int count) {
        List<Map<String, Integer>> trends = new ArrayList<>();

        trends.add(getTrendingWords(count));
        trends.add(getTrendingHashtags(count));
        trends.add(getTrendingUsers(count));

        return trends;
    }

    /**
     * Get trending words.
     *
     * @param count number of top trending items to get
     * @return a map containing the top trending items
     */
    public Map<String, Integer> getTrendingWords(int count) {
        WordNode[] allMentions = tweetProcessor.getAllMentions();

        sortStrategy.sort(allMentions);
        Map<String, Integer> m = new LinkedHashMap<>();

        Arrays.stream(allMentions)
              .filter(a -> !a.id.contains("http"))
              .limit(count)
              .collect(Collectors.toMap(a -> ((WordNode) a).id, a -> ((WordNode) a).size()))
              .entrySet().stream().sorted(byValue.reversed()).forEachOrdered(a -> m.put(a.getKey
                (), a.getValue()));
        return m;
    }

    /**
     * Get trending hashtags.
     *
     * @param count number of top trending items to get.
     * @return a map containing the top trending items
     */
    public Map<String, Integer> getTrendingHashtags(int count) {

        WordNode[] hashtagMentions = tweetProcessor.getHashtags();
        sortStrategy.sort(hashtagMentions);
        Map<String, Integer> m = new LinkedHashMap<>();
        Arrays.stream(hashtagMentions)
              .limit(count) // only grab the top n number of items
              .collect(Collectors.toMap(a -> ((WordNode) a).id, a -> ((WordNode) a).size()))
              .entrySet().stream().sorted(byValue.reversed()).forEachOrdered(a -> m.put(a.getKey
                (), a.getValue()));
        return m;
    }

    /**
     * Get trending users.
     *
     * @param count number of top trending items to get.
     * @return a map containing the top trending items
     */
    public Map<String, Integer> getTrendingUsers(int count) {
        WordNode[] userMentions = tweetProcessor.getUsers();
        sortStrategy.sort(userMentions);
        Map<String, Integer> m = new LinkedHashMap<>();
        Arrays.stream(userMentions)
              .limit(count)
              .collect(Collectors.toMap(a -> ((WordNode) a).id, a -> ((WordNode) a).size()))
              .entrySet().stream().sorted(byValue.reversed()).forEachOrdered(a -> m.put(a.getKey
                (), a.getValue()));
        return m;
    }


    ////////////////////////////////////////////////////////////
    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public void resetData() {
        tweetProcessor.resetData();
        tweetsList.clear();
    }
}
