package se2xb3.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Dawson
 * @version 1.0
 * @since 2/23/2017
 */
public class DataProcessor {

    static ObjectMapper objectMapper = new ObjectMapper();
    static String json = "{\"created_at\":\"Thu Feb 23 04:23:01 +0000 2017\",\"id\":834619546610835500,\"id_str\":\"834619546610835456\",\"text\":\"RT @susanemoney: Amazing! Though the poker analogy is yikes. Hey @KeithOlbermann - let's play next time you hit up Vegas! (You're to… \",\"source\":\"<a href=\\\"http://twitter.com/download/android\\\" rel=\\\"nofollow\\\">Twitter for Android</a>\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":738145176271474700,\"id_str\":\"738145176271474693\",\"name\":\"PJ Pope\",\"screen_name\":\"StJacki\",\"location\":null,\"url\":null,\"description\":\"Speaking truth to power. Dedicated to Nonviolent Resistance\",\"protected\":false,\"verified\":false,\"followers_count\":227,\"friends_count\":196,\"listed_count\":7,\"favourites_count\":34233,\"statuses_count\":8052,\"created_at\":\"Wed Jun 01 23:08:18 +0000 2016\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":false,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"F5F8FA\",\"profile_background_image_url\":\"\",\"profile_background_image_url_https\":\"\",\"profile_background_tile\":false,\"profile_link_color\":\"1DA1F2\",\"profile_sidebar_border_color\":\"C0DEED\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"profile_image_url\":\"http://abs.twimg.com/sticky/default_profile_images/default_profile_1_normal.png\",\"profile_image_url_https\":\"https://abs.twimg.com/sticky/default_profile_images/default_profile_1_normal.png\",\"profile_banner_url\":\"https://pbs.twimg.com/profile_banners/738145176271474693/1486229308\",\"default_profile\":true,\"default_profile_image\":true,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweeted_status\":{\"created_at\":\"Thu Feb 23 03:30:04 +0000 2017\",\"id\":834606222137454600,\"id_str\":\"834606222137454592\",\"text\":\"Amazing! Though the poker analogy is yikes. Hey @KeithOlbermann - let's play next time you hit up Vegas! (You're to… https://t.co/BwOGBQJRpM\",\"display_text_range\":[0,140],\"source\":\"<a href=\\\"http://twitter.com/download/android\\\" rel=\\\"nofollow\\\">Twitter for Android</a>\",\"truncated\":true,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":629143437,\"id_str\":\"629143437\",\"name\":\"Susan Money\",\"screen_name\":\"susanemoney\",\"location\":\"Las Vegas, NV\",\"url\":null,\"description\":\"Former patent attorney turned fake writer/comedian. Finally joined Twitter cuz WTFISHAPPENING. #resist\",\"protected\":false,\"verified\":false,\"followers_count\":79,\"friends_count\":198,\"listed_count\":0,\"favourites_count\":807,\"statuses_count\":1339,\"created_at\":\"Sat Jul 07 06:16:11 +0000 2012\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":false,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"C0DEED\",\"profile_background_image_url\":\"http://abs.twimg.com/images/themes/theme1/bg.png\",\"profile_background_image_url_https\":\"https://abs.twimg.com/images/themes/theme1/bg.png\",\"profile_background_tile\":false,\"profile_link_color\":\"1DA1F2\",\"profile_sidebar_border_color\":\"C0DEED\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"profile_image_url\":\"http://pbs.twimg.com/profile_images/830823388847288320/0KkQXgW9_normal.jpg\",\"profile_image_url_https\":\"https://pbs.twimg.com/profile_images/830823388847288320/0KkQXgW9_normal.jpg\",\"profile_banner_url\":\"https://pbs.twimg.com/profile_banners/629143437/1487577417\",\"default_profile\":true,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"quoted_status_id\":834578715447328800,\"quoted_status_id_str\":\"834578715447328768\",\"quoted_status\":{\"created_at\":\"Thu Feb 23 01:40:46 +0000 2017\",\"id\":834578715447328800,\"id_str\":\"834578715447328768\",\"text\":\"NEW: \\\"He will die in prison.\\\" The Intelligence Community is no longer being subtle towards Trump. https://t.co/m1zHuzJBqb\",\"source\":\"<a href=\\\"http://twitter.com/download/iphone\\\" rel=\\\"nofollow\\\">Twitter for iPhone</a>\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":130617778,\"id_str\":\"130617778\",\"name\":\"Keith Olbermann\",\"screen_name\":\"KeithOlbermann\",\"location\":null,\"url\":\"http://www.gq.com/story/watch-the-closer-keith-olbermann\",\"description\":\"GQ Special Correspondent: THE RESISTANCE. On Bojack Horseman. Dulwich Hamlet FC. Hacked by Russia. I had the biggest electoral college win since Ronald Reagan.\",\"protected\":false,\"verified\":true,\"followers_count\":849006,\"friends_count\":897,\"listed_count\":19454,\"favourites_count\":9,\"statuses_count\":69666,\"created_at\":\"Wed Apr 07 20:43:27 +0000 2010\",\"utc_offset\":-18000,\"time_zone\":\"Eastern Time (US & Canada)\",\"geo_enabled\":true,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"C0DEED\",\"profile_background_image_url\":\"http://pbs.twimg.com/profile_background_images/196246275/KO1971YankeeStadium.jpg\",\"profile_background_image_url_https\":\"https://pbs.twimg.com/profile_background_images/196246275/KO1971YankeeStadium.jpg\",\"profile_background_tile\":false,\"profile_link_color\":\"0084B4\",\"profile_sidebar_border_color\":\"C0DEED\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"profile_image_url\":\"http://pbs.twimg.com/profile_images/831400004271144960/wsC4JV8G_normal.jpg\",\"profile_image_url_https\":\"https://pbs.twimg.com/profile_images/831400004271144960/wsC4JV8G_normal.jpg\",\"profile_banner_url\":\"https://pbs.twimg.com/profile_banners/130617778/1486709043\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"is_quote_status\":false,\"retweet_count\":363,\"favorite_count\":957,\"entities\":{\"hashtags\":[],\"urls\":[],\"user_mentions\":[],\"symbols\":[],\"media\":[{\"id\":834503151310995500,\"id_str\":\"834503151310995456\",\"indices\":[98,121],\"media_url\":\"http://pbs.twimg.com/media/C5TCSRaW8AABhbi.jpg\",\"media_url_https\":\"https://pbs.twimg.com/media/C5TCSRaW8AABhbi.jpg\",\"url\":\"https://t.co/m1zHuzJBqb\",\"display_url\":\"pic.twitter.com/m1zHuzJBqb\",\"expanded_url\":\"https://twitter.com/GQMagazine/status/834507825774616576/video/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"large\":{\"w\":1620,\"h\":1080,\"resize\":\"fit\"},\"medium\":{\"w\":1200,\"h\":800,\"resize\":\"fit\"},\"small\":{\"w\":680,\"h\":453,\"resize\":\"fit\"}},\"source_status_id\":834507825774616600,\"source_status_id_str\":\"834507825774616576\",\"source_user_id\":21701757,\"source_user_id_str\":\"21701757\"}]},\"extended_entities\":{\"media\":[{\"id\":834503151310995500,\"id_str\":\"834503151310995456\",\"indices\":[98,121],\"media_url\":\"http://pbs.twimg.com/media/C5TCSRaW8AABhbi.jpg\",\"media_url_https\":\"https://pbs.twimg.com/media/C5TCSRaW8AABhbi.jpg\",\"url\":\"https://t.co/m1zHuzJBqb\",\"display_url\":\"pic.twitter.com/m1zHuzJBqb\",\"expanded_url\":\"https://twitter.com/GQMagazine/status/834507825774616576/video/1\",\"type\":\"video\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"large\":{\"w\":1620,\"h\":1080,\"resize\":\"fit\"},\"medium\":{\"w\":1200,\"h\":800,\"resize\":\"fit\"},\"small\":{\"w\":680,\"h\":453,\"resize\":\"fit\"}},\"source_status_id\":834507825774616600,\"source_status_id_str\":\"834507825774616576\",\"source_user_id\":21701757,\"source_user_id_str\":\"21701757\",\"video_info\":{\"aspect_ratio\":[16,9],\"duration_millis\":466591,\"variants\":[{\"bitrate\":832000,\"content_type\":\"video/mp4\",\"url\":\"https://video.twimg.com/amplify_video/834503151310995456/vid/640x360/E2ULr44PcKtt1sPU.mp4\"},{\"content_type\":\"application/x-mpegURL\",\"url\":\"https://video.twimg.com/amplify_video/834503151310995456/pl/vZPl4rdCEu63wm_3.m3u8\"},{\"bitrate\":320000,\"content_type\":\"video/mp4\",\"url\":\"https://video.twimg.com/amplify_video/834503151310995456/vid/320x180/2HKOF1zkGXB1Nncz.mp4\"},{\"bitrate\":2176000,\"content_type\":\"video/mp4\",\"url\":\"https://video.twimg.com/amplify_video/834503151310995456/vid/1280x720/fL3rhTrnoxIUfvId.mp4\"},{\"content_type\":\"application/dash+xml\",\"url\":\"https://video.twimg.com/amplify_video/834503151310995456/pl/vZPl4rdCEu63wm_3.mpd\"}]}}]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"filter_level\":\"low\",\"lang\":\"en\"},\"is_quote_status\":true,\"extended_tweet\":{\"full_text\":\"Amazing! Though the poker analogy is yikes. Hey @KeithOlbermann - let's play next time you hit up Vegas! (You're totally right btw.) https://t.co/QKdLzuN2gV\",\"display_text_range\":[0,132],\"entities\":{\"hashtags\":[],\"urls\":[{\"url\":\"https://t.co/QKdLzuN2gV\",\"expanded_url\":\"https://twitter.com/KeithOlbermann/status/834578715447328768\",\"display_url\":\"twitter.com/KeithOlbermann…\",\"indices\":[133,156]}],\"user_mentions\":[{\"screen_name\":\"KeithOlbermann\",\"name\":\"Keith Olbermann\",\"id\":130617778,\"id_str\":\"130617778\",\"indices\":[48,63]}],\"symbols\":[]}},\"retweet_count\":1,\"favorite_count\":1,\"entities\":{\"hashtags\":[],\"urls\":[{\"url\":\"https://t.co/BwOGBQJRpM\",\"expanded_url\":\"https://twitter.com/i/web/status/834606222137454592\",\"display_url\":\"twitter.com/i/web/status/8…\",\"indices\":[117,140]}],\"user_mentions\":[{\"screen_name\":\"KeithOlbermann\",\"name\":\"Keith Olbermann\",\"id\":130617778,\"id_str\":\"130617778\",\"indices\":[48,63]}],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"filter_level\":\"low\",\"lang\":\"en\"},\"quoted_status_id\":834578715447328800,\"quoted_status_id_str\":\"834578715447328768\",\"quoted_status\":{\"created_at\":\"Thu Feb 23 01:40:46 +0000 2017\",\"id\":834578715447328800,\"id_str\":\"834578715447328768\",\"text\":\"NEW: \\\"He will die in prison.\\\" The Intelligence Community is no longer being subtle towards Trump. https://t.co/m1zHuzJBqb\",\"source\":\"<a href=\\\"http://twitter.com/download/iphone\\\" rel=\\\"nofollow\\\">Twitter for iPhone</a>\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":130617778,\"id_str\":\"130617778\",\"name\":\"Keith Olbermann\",\"screen_name\":\"KeithOlbermann\",\"location\":null,\"url\":\"http://www.gq.com/story/watch-the-closer-keith-olbermann\",\"description\":\"GQ Special Correspondent: THE RESISTANCE. On Bojack Horseman. Dulwich Hamlet FC. Hacked by Russia. I had the biggest electoral college win since Ronald Reagan.\",\"protected\":false,\"verified\":true,\"followers_count\":849006,\"friends_count\":897,\"listed_count\":19454,\"favourites_count\":9,\"statuses_count\":69666,\"created_at\":\"Wed Apr 07 20:43:27 +0000 2010\",\"utc_offset\":-18000,\"time_zone\":\"Eastern Time (US & Canada)\",\"geo_enabled\":true,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"C0DEED\",\"profile_background_image_url\":\"http://pbs.twimg.com/profile_background_images/196246275/KO1971YankeeStadium.jpg\",\"profile_background_image_url_https\":\"https://pbs.twimg.com/profile_background_images/196246275/KO1971YankeeStadium.jpg\",\"profile_background_tile\":false,\"profile_link_color\":\"0084B4\",\"profile_sidebar_border_color\":\"C0DEED\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"profile_image_url\":\"http://pbs.twimg.com/profile_images/831400004271144960/wsC4JV8G_normal.jpg\",\"profile_image_url_https\":\"https://pbs.twimg.com/profile_images/831400004271144960/wsC4JV8G_normal.jpg\",\"profile_banner_url\":\"https://pbs.twimg.com/profile_banners/130617778/1486709043\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"is_quote_status\":false,\"retweet_count\":363,\"favorite_count\":957,\"entities\":{\"hashtags\":[],\"urls\":[],\"user_mentions\":[],\"symbols\":[],\"media\":[{\"id\":834503151310995500,\"id_str\":\"834503151310995456\",\"indices\":[98,121],\"media_url\":\"http://pbs.twimg.com/media/C5TCSRaW8AABhbi.jpg\",\"media_url_https\":\"https://pbs.twimg.com/media/C5TCSRaW8AABhbi.jpg\",\"url\":\"https://t.co/m1zHuzJBqb\",\"display_url\":\"pic.twitter.com/m1zHuzJBqb\",\"expanded_url\":\"https://twitter.com/GQMagazine/status/834507825774616576/video/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"large\":{\"w\":1620,\"h\":1080,\"resize\":\"fit\"},\"medium\":{\"w\":1200,\"h\":800,\"resize\":\"fit\"},\"small\":{\"w\":680,\"h\":453,\"resize\":\"fit\"}},\"source_status_id\":834507825774616600,\"source_status_id_str\":\"834507825774616576\",\"source_user_id\":21701757,\"source_user_id_str\":\"21701757\"}]},\"extended_entities\":{\"media\":[{\"id\":834503151310995500,\"id_str\":\"834503151310995456\",\"indices\":[98,121],\"media_url\":\"http://pbs.twimg.com/media/C5TCSRaW8AABhbi.jpg\",\"media_url_https\":\"https://pbs.twimg.com/media/C5TCSRaW8AABhbi.jpg\",\"url\":\"https://t.co/m1zHuzJBqb\",\"display_url\":\"pic.twitter.com/m1zHuzJBqb\",\"expanded_url\":\"https://twitter.com/GQMagazine/status/834507825774616576/video/1\",\"type\":\"video\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"large\":{\"w\":1620,\"h\":1080,\"resize\":\"fit\"},\"medium\":{\"w\":1200,\"h\":800,\"resize\":\"fit\"},\"small\":{\"w\":680,\"h\":453,\"resize\":\"fit\"}},\"source_status_id\":834507825774616600,\"source_status_id_str\":\"834507825774616576\",\"source_user_id\":21701757,\"source_user_id_str\":\"21701757\",\"video_info\":{\"aspect_ratio\":[16,9],\"duration_millis\":466591,\"variants\":[{\"bitrate\":832000,\"content_type\":\"video/mp4\",\"url\":\"https://video.twimg.com/amplify_video/834503151310995456/vid/640x360/E2ULr44PcKtt1sPU.mp4\"},{\"content_type\":\"application/x-mpegURL\",\"url\":\"https://video.twimg.com/amplify_video/834503151310995456/pl/vZPl4rdCEu63wm_3.m3u8\"},{\"bitrate\":320000,\"content_type\":\"video/mp4\",\"url\":\"https://video.twimg.com/amplify_video/834503151310995456/vid/320x180/2HKOF1zkGXB1Nncz.mp4\"},{\"bitrate\":2176000,\"content_type\":\"video/mp4\",\"url\":\"https://video.twimg.com/amplify_video/834503151310995456/vid/1280x720/fL3rhTrnoxIUfvId.mp4\"},{\"content_type\":\"application/dash+xml\",\"url\":\"https://video.twimg.com/amplify_video/834503151310995456/pl/vZPl4rdCEu63wm_3.mpd\"}]}}]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"filter_level\":\"low\",\"lang\":\"en\"},\"is_quote_status\":true,\"retweet_count\":0,\"favorite_count\":0,\"entities\":{\"hashtags\":[],\"urls\":[{\"url\":\"\",\"expanded_url\":null,\"indices\":[134,134]}],\"user_mentions\":[{\"screen_name\":\"susanemoney\",\"name\":\"Susan Money\",\"id\":629143437,\"id_str\":\"629143437\",\"indices\":[3,15]},{\"screen_name\":\"KeithOlbermann\",\"name\":\"Keith Olbermann\",\"id\":130617778,\"id_str\":\"130617778\",\"indices\":[65,80]}],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"filter_level\":\"low\",\"lang\":\"en\",\"timestamp_ms\":\"1487823781050\"}";

    public DataProcessor() {}


//    public static void main(String[] args) {
//
//        JsonNode tree = jsonStringToTree(json);
//
//        println(tree.findValue("id").asText());
//
//    }

    public static JsonNode jsonStringToTree(String jsonStr){

//        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;

        try {

            node = objectMapper.readValue(jsonStr, JsonNode.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return node;
    }

    ////////////////////////////////////////////////////////////
    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }

}