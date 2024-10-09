package org.example;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) throws Exception {
        try {
            String imageUrl = HttpStatusChecker.getStatusImage(code);

            saveImage(imageUrl, code);

        } catch (Exception e) {
            throw new Exception("Error: Unable to download image for status code " + code + ". " + e.getMessage());
        }
    }
    private static void saveImage(String imageUrl, int code) throws IOException {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (InputStream in = connection.getInputStream();
             FileOutputStream out = new FileOutputStream(code + ".jpg")) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
