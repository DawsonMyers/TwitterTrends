package se2xb3.data.processing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import se2xb3.data.models.Tweet;

import java.io.IOException;

/**
 * @author Dawson Myers
 * @version 1.0
 * @since 3/11/2017
 */
public class TweetProcessor implements IProcessor<String> {
    ObjectMapper objectMapper = new ObjectMapper();
    public TweetProcessor() {}

    @Override public Object process(String tweetStr) {
        JsonNode n     = jsonStringToTree(tweetStr);
        Tweet    tweet = new Tweet(n);
        return tweet;
    }


    /**
     * Deserialize tweet string and return a new Tweet object.
     * @param tweetStr
     * @return
     */
    public Tweet deserializeTweet(String tweetStr) {
        JsonNode n     = jsonStringToTree(tweetStr);
        Tweet    tweet = new Tweet(n);
        return tweet;
    }

    private JsonNode jsonStringToTree(String jsonStr) {

//        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {

            node = objectMapper.readValue(jsonStr, JsonNode.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return node;
    }


}
