package se2xb3.config;

import static org.aeonbits.owner.Config.*;

/**
 * @author Dawson
 * @version 1.0
 * @since 4/3/2017
 */
@Sources("clsspath:.")
public interface AppConfig {

    @Key("hostname")
    @DefaultValue("dawsonmyers.ca")
    String hostname();

    @Key("http.rest.trends.refreshrate")
    @DefaultValue("150")
    int trendRefreshRate();
}