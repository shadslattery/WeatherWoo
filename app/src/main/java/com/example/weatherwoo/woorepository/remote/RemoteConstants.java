package com.example.weatherwoo.woorepository.remote;

public class RemoteConstants {

    /*business rules which are to be applied on classes and/or fields (properties) of the class.
     * Rules that will never change, fields that always must stay the same*/

   public static final String BASE_URL = "https://api.darksky.net";
    public static final String WOO_PATH = "/forecast/{apiKey}/{longitude},{latitude}?exclude=[minutely,alerts,flags]";

}
