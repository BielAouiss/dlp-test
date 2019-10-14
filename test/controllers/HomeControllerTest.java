package controllers;


import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;
import play.twirl.api.Content;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

public class HomeControllerTest extends WithApplication {

    private static final String ONE_IMAGE_TEST = "https://picsum.photos/id/20/250/400";
    private static final String MuLTIPLE_IMAGE_TEST = "https://picsum.photos/id/56/250/400";
    private static final String MuLTIPLE_IMAGE_TEST_ANOTHER = "https://picsum.photos/id/89/250/400";


    private List<String> listOfUrls = Arrays.asList(ONE_IMAGE_TEST, MuLTIPLE_IMAGE_TEST,MuLTIPLE_IMAGE_TEST_ANOTHER);

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    ////Tests for One Image

    @Test
    public void testShowOneImage() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/test");
        Result result = route(app, request);
        assertNotNull(result);
        assertEquals(OK, result.status());
    }


    @Test
    public void renderOneImage() {
        Content html = views.html.random.render(Arrays.asList(ONE_IMAGE_TEST));
        assertEquals("text/html", html.contentType());

    }


    ////Tests for Multiple Images
    @Test
    public void testShowMultipleImages() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/testMultiple");
        Result result = route(app, request);
        assertNotNull(result);
        assertEquals(OK, result.status());
    }



    @Test
    public void renderTemplateMultipleImages() {
        Content html = views.html.random.render(listOfUrls);
        assertEquals("text/html", html.contentType());

    }






    }
