package se2xb3.io.web.handlers;

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

        // pass to next handler
        ctx.next();
    }
}
