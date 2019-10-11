package controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import play.cache.NamedCache;
import play.cache.SyncCacheApi;
import play.libs.ws.*;
import play.mvc.Controller;
import play.mvc.Result;
import services.ContentAPIService;
import services.ServiceFactory;
import services.ShowImageService;
import services.TypeOfService;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;

import play.api.libs.ws.ahc.AhcWSResponse;
import play.api.libs.ws.ahc.cache.CacheableHttpResponseBodyPart;
import play.api.libs.ws.ahc.cache.CacheableHttpResponseHeaders;
import play.api.libs.ws.ahc.cache.CacheableHttpResponseStatus;
import play.shaded.ahc.io.netty.handler.codec.http.DefaultHttpHeaders;
import play.shaded.ahc.org.asynchttpclient.Response;
import play.shaded.ahc.org.asynchttpclient.uri.Uri;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller implements WSBodyReadables, WSBodyWritables {


    boolean testAll = true;
    @Inject
    private ContentAPIService contentAPIService;

    private final Config config;
    @NamedCache("session-cache")
    SyncCacheApi cache;
    public static  WSClient wsClient;


    @Inject
    public HomeController(Config config, SyncCacheApi cache, WSClient wsClient) {
        this.config = config;
        this.cache = cache;
        this.wsClient = wsClient;
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }


   /* public Result testUrlCache() throws IOException {
        //get service Type
        ShowImageService showImageService = ServiceFactory.get(TypeOfService.ONEIMAGE);
        WSRequest request = wsClient.url("https://picsum.photos/200/300");

        WSRequest complexRequest =
                request .setFollowRedirects(true)
                        .addHeader("headerKey", "headerValue")
                        .setRequestTimeout(Duration.of(1000, ChronoUnit.MILLIS))
                        ;


        final CompletionStage<WSResponse> responseThreePromise =
                request
                        .get()
                        .thenCompose(responseOne -> System.out.println(wsClient.url(responseOne.getBody()).get()))
                        .thenCompose(responseTwo -> wsClient.url(responseTwo.getBody()).get());

        System.out.println("///////***--"+ responseThreePromise.toString());

        return showImageService.showImage("");

    }*/


    /**
     * This is where the test will be coded
     *
     * @return Result
     */
    public Result test() throws IOException {
        //get service Type
        ShowImageService showImageService = ServiceFactory.get(TypeOfService.ONEIMAGE);

        String url = "";


        //generating a random id from service and assigning it to the url
        int id = contentAPIService.getRandomId();

        //check if cache containing an old value of imgurl
        if (cache.get("imgUrl") == null) {
            //the complete url with new id
            this.cache.set("imgUrl", id, this.config.getInt("randomImg.cache"));
        }
        //we get the value of the id stored in the cache
        else {
            id = (cache.get("imgUrl"));
        }
        url = config.getString("imgUrl") + id + "/200/300";

        //return the view using the factory method
        return showImageService.showImage(url);

    }


    public Result testMultiple() throws IOException {
        //call service ContentAPIService to get images from json service and create views
        ShowImageService showImageService = ServiceFactory.get(TypeOfService.ALLIMAGE);
        return showImageService.showImage(config.getString("multipleImg.url"));

    }


    //when we refresh the application show another service : at first we show all images, when we refresh we show on image with caching
    public Result randomService() throws IOException {
        if (testAll) {
            testAll = false;
            return testMultiple();
        } else {
            testAll = true;
            return test();
        }


    }






}