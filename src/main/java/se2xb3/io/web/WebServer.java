package se2xb3.io.web;

import ratpack.handling.Chain;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;
import se2xb3.io.IOController;
import se2xb3.io.web.handlers.CORSHandler;
import se2xb3.io.web.handlers.TrendHandler;

/**
 * The a class that contains a web server that both serves static files for a AngularJs web app and
 * provides REST endpoints to get trends data as JSON encoded strings.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/26/2017
 */
public class WebServer implements Runnable {
    private IOController ioController;

    public WebServer()             {}
    public WebServer(IOController io) {ioController = io;}




    /**
     * This method is called in another thread via executer service. It starts the server, configures
     * the base directory by finding the folder containing the marker file (.ratpack) and sets it
     * to the root for the web server. It then configures the handler chain with the following:
     * <ol>
     *     <li>
     *         <b>{@code .files(f -> f.dir(""))}</b> <br>
     *             Set the root directory to be served statically
     *
     *     </li>
     *     <li>
     *         <b><code>.all(new CORSHandler())</code></b> <br>
     *             Configuring all requests to first go through the {@link CORSHandler}
     *         which adds the following headers to all requests:
     *         <ul>
     *             <li>
     *                 headers.set("Access-Control-Allow-Origin", "*");
     *             </li>
     *             <li>
     *                 headers.set("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept");
     *             </li>
     *             <li>
     *                 headers.set("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
     *             </li>
     *         </ul>
     *         This is required so that cross-origin REST requests can be made. Otherwise the client
     *         browser would block the request for security reasons.
     *     </li>
     *
     *     <li>
     *         <b>{@code .prefix("", nested -> nested.fileSystem("", Chain::files))}</b> <br>
     *          Configure all files and folders (recursively) to be served at the web server root.
     *     </li>
     *     <li>
     *         <b>{@code .path("", ctx  -> ctx.render(ctx.file("index.html")))}</b> <br>
     *          This path handler handles requests with an empty path (i.e. example.com) and serves
     *          the <code>index.html</code> file which bootstraps the AngularJs web app.
     *     </li>
     *     <li>
     *         <b><code>.path("trends/:type?/:count?", new TrendHandler(ioController)))</code></b> <br>
     *          All REST request matching the path patter <b><code>trends/:type?/:count?</code></b>
     *          are delegated to the {@link TrendHandler}. The optional query parameter for the
     *          <code>trends</code> REST resource are <b><code>:type?</code></b> and
     *          <b><code>:count?</code></b> (a prefix of '<b>:</b>' indicates a parameter and a
     *          suffix of '<b>?</b>' means it's optional). Request can be made in the following ways:
     *          <ul>
     *              <li>
     *                  <b>trends/{count}</b> <br>
     *                      Type parameter is empty. The response will include the top
     *                      <b>count</b> overall word, hashtag, and user mentions as a JSON array
     *                      containing 3 arrays (one for each trend). If the the request is just
     *                      <code>trends/</code> without the <b>count</b> parameter empty, then the a
     *                      default value of 10 is used.
     *              </li>
     *              <li>
     *                  <b>trends/{type}/{count}</b> <br>
     *                      The response will include the top <b>count</b> (an integer value) trends
     *                      of the type <b>type</b>. Where <b>type</b> is either overall word,
     *                      hashtag, or user mentions as a JSON array. If the the request is just
     *                      <i><code>trends/{type}/</code></i> without the <b>count</b> parameter
     *                      empty, then the a default value of 10 is used.
     *              </li>
     *          </ul>
     *     </li>
     * </ol>
     *
     */
    @Override
    public void run() {
        try {
            RatpackServer
                    .start(server -> {
                server.serverConfig(serverConfigBuilder -> serverConfigBuilder
                        .baseDir(BaseDir.find())
                        .env()
                        .sysProps())
                      .handlers(chain -> chain
                              // statically serves all files in the dir containing the .ratpack file
                              .files(f -> f.dir(""))
                              // apply the CORS handler to all request to allo cross-site REST requests
                              .all(new CORSHandler())
                              // statically serves all files in the dir containing the .ratpack file
                              .prefix("", nested -> nested.fileSystem("", Chain::files))
                              .path("", ctx -> ctx.render(ctx.file("index.html")))
                              .path("docs", ctx -> ctx.render(ctx.file("docs/index.html")))
//                                        .files(f -> f.dir("dist").indexFiles("index.html"))
                              // delegate all trend/* REST requests to the trend handler
                              // the :type?/:count? path tokens are optional
                              // default path /trends will get a response with the top ten of the
                              // all, hashtag, and user mention trends
                        .path("trends/:type?/:count?", new TrendHandler(ioController)));
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Shutdown the web server.
     */
    public void shutdown() {

    }
}
