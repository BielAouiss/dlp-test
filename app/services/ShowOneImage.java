package services;

import play.mvc.Result;
import static play.mvc.Results.ok;

public class ShowOneImage implements ShowImageService {
    @Override
    public Result showImage(String url) {
        return ok(views.html.hello.render(url));
    }
}
