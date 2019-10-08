package services;

import play.mvc.Result;

import javax.inject.Singleton;
import java.io.IOException;


@Singleton
public interface ShowImageService {
      Result showImage(String url) throws IOException;
}
