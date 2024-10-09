package org.example;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void askStatus() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter HTTP status code:");
        String input = scanner.nextLine();

        try {
            int statusCode = Integer.parseInt(input);

            try {
                HttpStatusImageDownloader.downloadStatusImage(statusCode);
            } catch (Exception e) {
                System.out.println("There is no image for HTTP status " + statusCode);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
        }
    }
}
