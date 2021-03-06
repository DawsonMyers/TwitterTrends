package se2xb3.data.models;

import java.util.HashMap;

/**
 * @author Dawson
 * @version 1.0
 * @since 2/23/2017
 */
public class Place {
    public long id;
    public String  type, url, place_type, name, full_name, country_code, country;
    public BoundingBox bounding_box;
    public Place() {}

}

class BoundingBox{
    public String  type;
    public int[][] coordinates;
    public HashMap<String, Object> attributes;
}