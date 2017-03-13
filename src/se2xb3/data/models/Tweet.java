package se2xb3.data.models;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Dawson
 * @version 1.0
 * @since 2/23/2017
 */
public class Tweet {

    // value to fill field with if null is returned instead of a string
    static final String IF_NULL_STR = "none";
    static final int IF_NULL_INT = -1;
    static final long IF_NULL_LONG = -1;

    public String created_at;
    public long id;
    public String id_str, text;
    public int[] display_text_range;
    public String source;
    public boolean truncated;
    public long in_reply_to_status_id, in_reply_to_user_id;
    public String in_reply_to_status_id_str, in_reply_to_user_id_str, in_reply_to_screen_name;
    public User user;
    public String geo, coordinates;
    public Place place;

    public String contributors, quoted_status_id_str, filter_level, timestamp_ms, lang;
    public long quoted_status_id;

    public boolean is_quote_status, favorited, retweeted, possibly_sensitive;
    public Tweet quoted_status;
    public int retweet_count, favorite_count;
    //public Entities entities;

    private JsonNode node;
    public Tweet() {}

    public Tweet(JsonNode n) {
        node = n;
        created_at = n.findValue("created_at").asText(IF_NULL_STR);
        id = n.findValue("id").asLong(IF_NULL_LONG);

        id_str = n.findValue("id_str").asText(IF_NULL_STR);
        text = n.findValue("text").asText(IF_NULL_STR);
        in_reply_to_status_id_str = n.findValue("in_reply_to_status_id_str").asText(IF_NULL_STR);
        in_reply_to_user_id_str = n.findValue("in_reply_to_user_id_str").asText(IF_NULL_STR);
        in_reply_to_screen_name = n.findValue("in_reply_to_screen_name").asText(IF_NULL_STR);
        timestamp_ms = checkNull("timestamp_ms");
//       timestamp_ms = n.findValue("timestamp_ms").asText(IF_NULL_STR);
        lang = n.findValue("lang").asText(IF_NULL_STR);

        in_reply_to_status_id = checkNullLong("in_reply_to_status_id");
//        in_reply_to_status_id = n.findValue("in_reply_to_status_id").asLong(IF_NULL_INT);
        in_reply_to_user_id = checkNullLong("in_reply_to_user_id");
                //n.findValue("in_reply_to_user_id").asLong(IF_NULL_INT);

        quoted_status_id = checkNullLong("quoted_status_id");
                                         //n.findValue("quoted_status_id").asLong(IF_NULL_LONG);

        retweet_count = n.findValue("retweet_count").asInt(IF_NULL_INT);
        favorite_count = n.findValue("favorite_count").asInt(IF_NULL_INT);

        user = new User(n.findValue("user"));
        if (n.findValue("quoted_status") != null) {
        quoted_status = new Tweet(n.findValue("quoted_status"));
        }

        if (n.findValue("place") != null) {
            //place = new Place(n.findValue("quoted_status"));
        }
    }


    /**
     * Check if the value of a field exists. Returns the value of the field
     * if it is not null, "none" is returned otherwise.
     * @param key
     * @return the value of the field if not null, "none" otherwise.
     */
    private String checkNull(String key) {
        if(node.findValue(key) != null){
            return node.findValue(key).asText(IF_NULL_STR);
        }
        return IF_NULL_STR;
    }
    /**
     * Check if the value of a field exists. Returns the value of the field
     * if it is not null, -1L is returned otherwise.
     * @param key
     * @return the value of the field if not null, "none" otherwise.
     */
    private Long checkNullLong(String key) {
        if(node.findValue(key) != null){
            return node.findValue(key).asLong(IF_NULL_LONG);
        }
        return IF_NULL_LONG;
    }

    /**
     * Get the value of the tweet text.
     * @return tweet text.
     */
    public String getText() {
        return text;
    }
}

/*
class Entities{
    public String[] hashtags;
    public Url[] urls;


    class Url{
        public String url, expanded_url, display_url;
        public int[] indices;
    }
}*/
