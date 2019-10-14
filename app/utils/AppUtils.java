package utils;

import java.util.Random;
import java.util.logging.Logger;

public  class AppUtils {
        private static Logger logger = Logger.getLogger("play");

    //generate random id to get different image
    public static int getRandomId() {
        logger.info("##### get Random id #####");

        int id = 0;
        Random random = new Random();
        //the last id of "https://picsum.photos/" is 1084
        id = (int) random.nextInt(1084);
        return id;
    }
}
