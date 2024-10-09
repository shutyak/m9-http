package org.example;

public class Main {
    public static void main(String[] args) {

        try {
            HttpStatusImageDownloader.downloadStatusImage(200);
            HttpStatusImageDownloader.downloadStatusImage(404);
            HttpStatusImageDownloader.downloadStatusImage(10000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}