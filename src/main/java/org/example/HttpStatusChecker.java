package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public static String getStatusImage(int code) throws Exception {
        String imageUrl = "https://http.cat/" + code + ".jpg";

        if (isImageAvailable(imageUrl)) {
            return imageUrl;
        } else {
            throw new Exception("Image for status code " + code + " not found");
        }
    }
    private static boolean isImageAvailable(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();

        return responseCode != 404;
    }
}
