package com.au.iroqquois.terrible_messsanger.core.router;

public interface InternalRouter {

    String BASE_PATH = "localhost:8080/v1";

    interface Authentication {
        String BASE_PATH = InternalRouter.BASE_PATH + "/getToken";
    }
}
