package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.typesafe.config.Config;
import controllers.HomeController;
import entities.ImageMap;
import play.cache.SyncCacheApi;
import utils.AppUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;


public class ContentAPIService {

    private static List<String> listOfUrls = new ArrayList<String>();
    private JsonNode imagesAsJson;
    private ObjectMapper objectMapper = new ObjectMapper();
    private ImageMap[] images = {};
    private Logger logger = Logger.getLogger("play");




    public List<String> mapUrls(String url) {

        logger.info("##### Getting list of urls with id = 2 from api #####");

        HomeController.wsClient.url(url).get().thenApply(files -> {
            this.imagesAsJson = files.asJson();



            // trying to map the jsonNode to an array of our object ImageMap
            try {
                logger.info("##### Mapping images with ObjectMapper #####");
                this.images = this.objectMapper.treeToValue(imagesAsJson, ImageMap[].class);
            } catch (JsonProcessingException e) {
                logger.info("##### Error while Mapping images using Object Mapper #####");
                e.printStackTrace();
            }


            //using filter to getting the images with id mutliple of 2
            //and set the result in this.listOfUrls
            Arrays.stream(this.images)
                    .filter(img -> Integer.parseInt(img.getId()) % 2 == 0)
                    .forEach(img -> this.listOfUrls.add(img.getDownload_url()));

            return this.listOfUrls;
        });

        return this.listOfUrls;

    }


    public String getUrlWithCache(SyncCacheApi cache, Config config) {
        String url = "";
        //generating a random id from service and assigning it to the url
        int id = AppUtils.getRandomId();
        //check if cache containing an old value of imgurl
        if (cache.get("imgUrl") == null) {
            //the complete url with new id
            cache.set("imgUrl", id, config.getInt("randomImg.cache"));
        }
        //we get the value of the id stored in the cache
        else {
            id = (cache.get("imgUrl"));
        }
        url = config.getString("imgUrl") + id + "/200/300";

        //return the view using the factory method
        this.logger.info("##### Returning One Url with cache #####");
        // return showImageService.showImage(url);
        return url;

    }


}
