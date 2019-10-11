package services;

import play.mvc.Result;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.concurrent.CompletionStage;


@Singleton
public interface ShowImageService {
      Result showImage(String url) throws IOException;
}
