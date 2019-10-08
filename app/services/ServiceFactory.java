package services;

public abstract class ServiceFactory {
    public static ShowImageService get(TypeOfService type) {
        ShowImageService service = null;
        switch (type) {
            case ALLIMAGE:
                service = new ShowAllImages();
                break;
            case ONEIMAGE:
                service = new ShowOneImage();
                break;

        }
        return service;
    }

}
