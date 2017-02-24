package se2xb3.data.maps;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Dawson
 * @version 1.0
 * @since 2/23/2017
 */
public class Tweet {
    public String created_at;
    public int id;
    public String id_str, text;
    public int[] display_text_range;
    public String source;
    public boolean truncated;
    public int in_reply_to_status_id, in_reply_to_user_id;
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
        id = n.findValue("id").asInt();
        id_str = n.findValue("id_str").asText();
        text = n.findValue("text").asText();
        created_at = n.findValue("created_at").asText();
        created_at = n.findValue("created_at").asText();
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
