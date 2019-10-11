package services;

import play.mvc.Result;

import java.io.IOException;

import static play.mvc.Results.ok;


public class ShowAllImages implements ShowImageService {



    private ContentAPIService contentAPIService = new ContentAPIService();


    @Override
    public Result showImage(String url) throws IOException {

        return ok(views.html.showAllImgsView.render(contentAPIService.mapUrls2(url)));

    }




}
