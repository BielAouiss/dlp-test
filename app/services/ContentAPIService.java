package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.ImageMap;

import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Singleton
public class ContentAPIService {


    //generate random id to get different image
    public int getRandomId(){
        int id=0;
        Random random = new Random();
        //the last id of "https://picsum.photos/" is 1084
        id=(int) random.nextInt(1084) ;
        return id;
    }

    public List<ImageMap> mapUrls(String givenUrl) throws IOException {

        // Connect to the URL using java's native library
        URL url = new URL(givenUrl);
        URLConnection request = url.openConnection();
        request.connect();
        //get request content
        InputStream in =((InputStream) request.getContent());
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
        }
        //create ObjectMapper using fasterxml
        ObjectMapper mapper = new ObjectMapper();

        //  convert JSON array to List of objects
        List<ImageMap> ppl2 = Arrays.asList(mapper.readValue(result.toString(), ImageMap[].class));
        List<ImageMap> listOfImages = ppl2.stream()                // convert list to stream
                .filter(image ->  Integer.parseInt(image.getId()) % 2 ==0)     // and get only Image with id muliple of 2
                .collect(Collectors.toList());


        //return the list of our object ImageMap
        return listOfImages;

    }

}
