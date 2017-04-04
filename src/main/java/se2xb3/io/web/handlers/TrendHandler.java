package se2xb3.io.web.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import se2xb3.config.Constants;
import se2xb3.io.IOController;

import static java.lang.Math.abs;
import static se2xb3.io.web.JsonParser.toJson;

/**
 * Handle all REST request received by the web server with a prefix of <code>trends/</code>.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/27/2017
 */
public class TrendHandler implements Handler, Constants{
    private static final String _CLASS_NAME  = TrendHandler.class.getSimpleName();
    private final static Logger log          = LoggerFactory.getLogger(_CLASS_NAME);
    private              long   requestCount = 0;
    private IOController ioController;

    public TrendHandler(IOController ioController) {this.ioController = ioController;}

    /**
     * This method handles all REST request matching the path pattern
     * <b><code>trends/:type?/:count?</code></b>. The optional query parameter for the
     * <code>trends</code> REST resource are <b><code>:type?</code></b> and
     * <b><code>:count?</code></b> (a prefix of '<b>:</b>' indicates a parameter and a
     * suffix of '<b>?</b>' means it's optional). Request can be made in the following ways:
     * <ul>
     *     <li>
     *         <b>trends/{count}</b> <br>
     *             Type parameter is empty. The response will include the top
     *             <b>count</b> overall word, hashtag, and user mentions as a JSON array
     *             containing 3 arrays (one for each trend). If the the request is just
     *             <code>trends/</code> without the <b>count</b> parameter empty, then the a
     *             default value of 10 is used.
     *     </li>
     *         <li>
     *         <b>trends/{type}/{count}</b> <br>
     *             The response will include the top <b>count</b> (an integer value) trends
     *             of the type <b>type</b>. Where <b>type</b> is either overall word,
     *             hashtag, or user mentions as a JSON array. If the the request is just
     *             <i><code>trends/{type}/</code></i> without the <b>count</b> parameter
     *             empty, then the a default value of 10 is used.
     *     </li>
     * </ul>
     *
     */
    @Override
    public void handle(Context ctx) throws Exception {
        String type  = ctx.getPathTokens().get("type");
        String count = ctx.getPathTokens().get("count");

        // print out the request count every 100 request
        requestCount++;
        if (requestCount % 100 == 0) {
            log.info("Trend request count = " + requestCount);
        }

        if(count != null && count.length() > 3) count = count.substring(0, 2);
        // trends/ or count is too long
        if (type == null || type.length() == 0){
//            if(type.length() > MAX_REST_RESP_COUNT)
//                ctx.render(toJson(ioController.getTrends(MAX_REST_RESP_COUNT)));
//            else
                ctx.render(toJson(ioController.getTrends(DEFAULT_REST_RESP_COUNT)));
            return;
            // path = trends/#
        }  else if (isNumber(type)) {
            ctx.render(toJson(ioController.getTrends(Integer.parseInt(type))));
            return;
        }else if (type.toLowerCase().equals(REST_RESOURCE_TRENDS_ALL)) {
//        }else if (type.toLowerCase().equals("all")) {
            if (isNumber(count)) {
                ctx.render(toJson(ioController.getTrendingWords(Integer.parseInt(count))));
                return;
            }
            ctx.render(toJson(ioController.getTrendingWords(DEFAULT_REST_RESP_COUNT)));
            return;
            // trends/hashtags/#
        } else if (type.toLowerCase().equals(REST_RESOURCE_TRENDS_HASHTAGS)) {
            if (isNumber(count)) {
                ctx.render(toJson(ioController.getTrendingHashtags(Integer.parseInt(count))));
                return;
            }
            ctx.render(toJson(ioController.getTrendingHashtags(DEFAULT_REST_RESP_COUNT)));
            return;
            // trends/users/#
        } else if (type.toLowerCase().equals(REST_RESOURCE_TRENDS_USERS)) {
            if (isNumber(count)) {
                ctx.render(toJson(ioController.getTrendingUsers(Integer.parseInt(count))));
                return;
            }
            ctx.render(toJson(ioController.getTrendingUsers(DEFAULT_REST_RESP_COUNT)));
            return;
        }
        ctx.render(REST_REQUEST_NO_MATCH);
//        ctx.render("no match");
    }

    private int parseInt(String s) {
        return abs(Integer.parseInt(s));
    }

    /**
     * Check if a string contains all numeric characters
     * @param s a string
     * @return true if string is a number
     */
    private boolean isNumber(String s) {
            return s != null && s.length() != 0 && s.chars().allMatch( Character::isDigit );
    }

    /**
     * Get trends from data controller
     * @return JSON encoded string containing the trends
     */
    public String getTrends() {
        return toJson(ioController.getTrends());
    }

    /**
     * Get trends from data controller.
     *
     * @param count the number of items to get
     * @return JSON encoded string containing the trends
     */
    public String getTrends(String count) {
        if(count != null && count != ""){
            return toJson(ioController.getTrends(Integer.parseInt(count)));
        }
        return toJson(ioController.getTrends());
    }

    /**
     * Get trending words.
     * @param count number of top trending items to get.
     * @return a JSON encoded string containing the top trending items
     */
    public String getTrendingWords(String count) {
        if(count != null && count != ""){
            return toJson(ioController.getTrendingWords(Integer.parseInt(count)));
        }
        return toJson(ioController.getTrendingWords(DEFAULT_REST_RESP_COUNT));
    }

    /**
     * Get trending hashtags.
     * @param count number of top trending items to get.
     * @return a JSON encoded string containing the top trending items
     */
    public String getTrendingHashtags(String count) {
        if(count != null && count != ""){
            return toJson(ioController.getTrendingHashtags(Integer.parseInt(count)));
        }
        return toJson(ioController.getTrendingHashtags(DEFAULT_REST_RESP_COUNT));
    }

    /**
     * Get trending users.
     * @param count number of top trending items to get.
     * @return a JSON encoded string containing the top trending items
     */
    public String getTrendingUsers(String count) {
        if(count != null && count != ""){
            return toJson(ioController.getTrendingUsers(Integer.parseInt(count)));
        }
        return toJson(ioController.getTrendingUsers(DEFAULT_REST_RESP_COUNT));
    }

}
