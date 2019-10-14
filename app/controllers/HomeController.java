package controllers;


import com.google.inject.Inject;
import com.typesafe.config.Config;
import play.cache.NamedCache;
import play.cache.SyncCacheApi;
import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSBodyWritables;
import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;
import services.ContentAPIService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 * <p>
 * author: Bilel
 */
public class HomeController extends Controller implements WSBodyReadables, WSBodyWritables {


    public static WSClient wsClient;
    private final Config config;
    @NamedCache("session-cache")
    SyncCacheApi cache;
    @Inject
    private ContentAPIService contentAPIService;
    private Logger logger = Logger.getLogger("play");


    @Inject
    public HomeController(Config config, SyncCacheApi cache, WSClient wsClient) {
        this.config = config;
        this.cache = cache;
        this.wsClient = wsClient;
    }


    public Result index() {
        this.logger.info("##### Home Screen #####");
        return ok(views.html.index.render());
    }


    /*
     * when we refresh the application show another service :
     * at first we show all images,
     * when we refresh we show on image with caching
     */
    public Result randomService() {


        this.logger.info("##### Opening Random Service ######");


        String uri = request().uri();

        if (uri.equals("/test"))  // if we pass localhost:9000/test

            return ok(views.html.random.render(Arrays.asList(contentAPIService.getUrlWithCache(cache, config))));

        else if (uri.equals("/testMultiple")) // if we pass localhost:9000/testMultiple
            return ok(views.html.random.render(contentAPIService.mapUrls(this.config.getString("multipleImg.url"))));

        else if (uri.equals("/randomService")) {  // generating random url
            Random random = new Random();
            boolean testRandom = random.nextBoolean();  //generating random boolean
            if (testRandom) {
                this.logger.info("##### Redirect From /randomService to /test ######");
                return redirect("/test");  //redirect to test to show one image
            } else {
                this.logger.info("##### Redirect From /randomService to /testMultiple ######");
                return redirect("/testMultiple"); //redirect to testMultiple to show all images with id == 2
            }
        }

        return ok(views.html.index.render());
    }


}