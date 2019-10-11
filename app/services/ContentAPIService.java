package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.HomeController;
import controllers.ImageMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;


public class ContentAPIService {

    private JsonNode imagesAsJson;
    private ObjectMapper objectMapper = new ObjectMapper();
    private ImageMap[] images = {};
    private static List<ImageMap> listOfImageMap = new ArrayList<ImageMap>();

    private Logger logger = Logger.getLogger("play");

    //generate random id to get different image
    public int getRandomId() {
        logger.info("## get Random id ##");

        int id = 0;
        Random random = new Random();
        //the last id of "https://picsum.photos/" is 1084
        id = (int) random.nextInt(1084);
        return id;
    }


    public List<ImageMap> mapUrls2(String url) {

        HomeController.wsClient.url(url).get().thenApply(files -> {
            this.imagesAsJson = files.asJson();


            try {
                this.images = this.objectMapper.treeToValue(imagesAsJson, ImageMap[].class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


            Arrays.stream(this.images).filter(img -> Integer.parseInt(img.getId()) % 2 == 0).forEach(img -> this.listOfImageMap.add(img));


            listOfImageMap.forEach(img -> System.out.println(img.getId() + "IDDDDD"));

            return this.listOfImageMap;
        });

        return this.listOfImageMap;

    }


}
