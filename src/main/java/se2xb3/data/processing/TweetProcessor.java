package se2xb3.data.processing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import se2xb3.data.algorithms.WordGraph;
import se2xb3.data.algorithms.WordNode;
import se2xb3.data.models.Tweet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static se2xb3.config.Constants.TWEET_REGEX;

/**
 * A class to process JSON encoded tweets.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class TweetProcessor implements IProcessor<String> {
    ObjectMapper objectMapper = new ObjectMapper();
    WordGraph    graph        = new WordGraph();

    public TweetProcessor() {}

    /**
     * Process a string containing a JSON encoded string. The string is deserialized and the data is
     * stored in a new instance of a {@link Tweet}.
     *
     * @param tweetStr a JSON encoded string containing a tweet
     * @return a Tweet object containing the data from the JSON string
     */
    @Override
    public Object process(String tweetStr) {
        JsonNode n     = jsonStringToTree(tweetStr);
        Tweet    tweet = new Tweet(n);
        return tweet;
    }


    /**
     * Deserialize tweet stored in a JSON encoded string. Then, return a new instance of a {@link
     * Tweet}
     * containing the twee data.
     *
     * @param tweetStr a JSON encoded string containing a tweet
     * @return a Tweet object containing the data from the JSON string
     */
    public Tweet deserializeTweet(String tweetStr) {
        JsonNode n = jsonStringToTree(tweetStr);
        return new Tweet(n);
    }

    /**
     * Convert JSON string into a tree containging the parsed data. The tree structure provides a
     * means to easily search through the tree and extract the data we want.
     *
     * @param jsonStr a JSON encoded string containing a tweet
     * @return a tree of {@link JsonNode} objects
     */
    private JsonNode jsonStringToTree(String jsonStr) {
        JsonNode node = null;
        try {
            node = objectMapper.readValue(jsonStr, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }

    /**
     * Process the text of each tweet as they are received. The words are
     * extracted from the string using regular expressions and then inserted into the word graph.
     *
     * @param tweet a tweet
     */
    public void processTweetText(Tweet tweet) {
        // extract all words from the tweet's text using a regular expression
        Matcher matcher = Pattern.compile(TWEET_REGEX).matcher(tweet.getText());

        String word = "";

        while (matcher.find()) {
            word = matcher.group(0);
            // ignore words shorter than 3 characters
            if (word.length() < 3) continue;

            graphWord(word, tweet);

        }
    }

    /**
     * This is building a graph of words and tweets. One tweet is connected to many word nodes.
     *
     * @param word  a word to add to the graph
     * @param tweet the tweet that uses the word
     */
    public void graphWord(String word, Tweet tweet) {
        graph.addWord(word, tweet);
    }

    /**
     * Get array of all mentions as an array of word nodes
     *
     * @return an array of all of the word nodes
     */
    public WordNode[] getAllMentions() {
        return graph.getAllMentions();
    }

    /**
     * Get array of hashtag mentions as an array of word nodes
     *
     * @return an array of all words that start with a #
     */
    public WordNode[] getHashtags() {
        return graph.getHashtags();
    }

    /**
     * Get array of user mentions as an array of word nodes
     *
     * @return all words that start with a @
     */
    public WordNode[] getUsers() {
        return graph.getUsers();
    }
}
