package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(HttpStatusChecker.getStatusImage(200)); // https://http.cat/200.jpg
            System.out.println(HttpStatusChecker.getStatusImage(10000)); // Викидає Exception
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}