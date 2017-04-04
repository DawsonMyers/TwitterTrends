package se2xb3.io.web.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.MutableHeaders;

/**
 * Add CORS headers for cross-site REST requests.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/27/2017
 */
public class CORSHandler implements Handler {
    private static final String _CLASS_NAME  = CORSHandler.class.getSimpleName();
    private final static Logger log          = LoggerFactory.getLogger(_CLASS_NAME);
    private              long   requestCount = 0;
    /**
     * Handle requests by adding the CORS headers to each request that is processed. Then, continue
     * to the next handler in the chain without sending the response.
     *
     * @param ctx the response context
     * @throws Exception an exception
     */
    @Override
    public void handle(Context ctx) throws Exception {
        MutableHeaders headers = ctx.getResponse().getHeaders();
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, " +
                "accept");
        headers.set("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        requestCount++;
        if (requestCount % 100 == 0) {
            log.info("Request count = " + requestCount);
        }
        // pass to next handler
        ctx.next();
    }
}
