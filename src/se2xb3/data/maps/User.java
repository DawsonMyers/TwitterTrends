package se2xb3.data.maps;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Dawson
 * @version 1.0
 * @since 2/23/2017
 */
public class User {

    public long id;
    public String id_str, name, screen_name, location, url, description;
   // public boolean protected
    public boolean verified;
    public int followers_count, friends_count, listed_count, favourites_count, statuses_count, utc_offset;
    public String created_at, time_zone, lang;
    public boolean geo_enabled, contributors_enabled, is_translator, profile_background_tile, profile_use_background_image,
            default_profile, default_profile_image;
    public String profile_background_color, profile_background_image_url, profile_background_image_url_https,
            profile_link_color, profile_sidebar_border_color, profile_sidebar_fill_color, profile_text_color,
            profile_image_url, profile_image_url_https, profile_banner_url, following, follow_request_sent,
            notifications;

    public User() {}

    public User(JsonNode n) {

        id = n.findValue("id").asLong();
        followers_count = n.findValue("followers_count").asInt();
        favourites_count = n.findValue("favourites_count").asInt();
        statuses_count = n.findValue("statuses_count").asInt();
        utc_offset = n.findValue("utc_offset").asInt();
        friends_count = n.findValue("friends_count").asInt();
        listed_count = n.findValue("listed_count").asInt();

        id_str = n.findValue("id_str").asText();
        name = n.findValue("name").asText();
        screen_name = n.findValue("screen_name").asText();
        location = n.findValue("location").asText();
        description = n.findValue("description").asText();
        created_at = n.findValue("created_at").asText();
        time_zone = n.findValue("time_zone").asText();
        lang = n.findValue("lang").asText();

    }

}
