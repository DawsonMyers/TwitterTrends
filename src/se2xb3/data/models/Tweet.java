package se2xb3.data.models;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Dawson
 * @version 1.0
 * @since 2/23/2017
 */
public class Tweet {
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

    public Tweet() {}

    public Tweet(JsonNode n) {
        created_at = n.findValue("created_at").asText();
        id = n.findValue("id").asLong();

        id_str = n.findValue("id_str").asText();
        text = n.findValue("text").asText();
        in_reply_to_status_id_str = n.findValue("in_reply_to_status_id_str").asText();
        in_reply_to_user_id_str = n.findValue("in_reply_to_user_id_str").asText();
        in_reply_to_screen_name = n.findValue("in_reply_to_screen_name").asText();
//        timestamp_ms = n.findValue("timestamp_ms").asText();
        lang = n.findValue("lang").asText();

        in_reply_to_status_id = n.findValue("in_reply_to_status_id").asLong();
        in_reply_to_user_id = n.findValue("in_reply_to_user_id").asLong();
//        quoted_status_id = n.findValue("quoted_status_id").asLong();

        retweet_count = n.findValue("retweet_count").asInt();
        favorite_count = n.findValue("favorite_count").asInt();

        user = new User(n.findValue("user"));
        if (n.findValue("quoted_status") != null) {
        quoted_status = new Tweet(n.findValue("quoted_status"));
        }

        if (n.findValue("place") != null) {
            //place = new Place(n.findValue("quoted_status"));
        }
    }

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
