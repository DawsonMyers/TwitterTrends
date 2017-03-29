package se2xb3.io.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A class to handle JSON encoding and decoding for the web server.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/26/2017
 */
public class JsonParser {
    private static ObjectMapper mapper = new ObjectMapper();

    public JsonParser() {}


    /**
     * Convert trends to a JSON encoded string.
     *
     * @param list an object to be serialized into a JSON string
     * @return a JSON encoded string
     */
    public static String toJson(List<Map<String, Integer>> list) {
        try {
            return mapper.writeValueAsString(toContainerObject(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "none";
    }

    /**
     * Convert trends to a JSON encoded string.
     *
     * @param map an object to be serialized into a JSON string
     * @return a JSON encoded string
     */
    public static String toJson(Map<String, Integer> map) {
        try {
            return mapper.writeValueAsString(toContainerObject(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "none";
    }

    /**
     * Convert trends to a list of list of trends. This is done to give the trends proper format
     * when converting to JSON.
     *
     * @param trends trend data to be converted into trend pojos
     */
    private static List<List<Trend>> toContainerObject(List<Map<String, Integer>> trends) {
        List<List<Trend>> t = new ArrayList<>();

        for (int i = 0; i < trends.size(); i++) {
            t.add(mapToTrendList(trends.get(i)));
        }

        return t;
    }

    /**
     * Convert trends to a list of list of trends. This is done to give the trends proper format
     * when converting to JSON.
     *
     * @param trends trend data to be converted into trend pojos
     */
    private static List<Trend> toContainerObject(Map<String, Integer> trends) {
        return mapToTrendList(trends);
    }

    /**
     * Convert a {@code Map<String, Integer>} to a list of trends {@code List<Trend>}.
     *
     * @param trendMap trend data to be converted into trend pojos
     * @return map of trend pojos
     */
    private static List<Trend> mapToTrendList(Map<String, Integer> trendMap) {
        List<Trend> trendList = new ArrayList<>();

        trendMap
                .entrySet()
                .stream()
                .forEachOrdered(a -> trendList.add(new Trend(a.getKey(), a.getValue())));

        return trendList;
    }
}

/**
 * A tend pojo class.
 */
class Trend {
    public String item;
    public int    count;

    public Trend(String i, int c) {
        item = i;
        count = c;
    }
}