package com.jovan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlReader {

    public static void main (String[] args) throws Exception {
        URL aUrl = new URL("https://www.google.com");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(aUrl.openStream())
        );

        String inputLine = "";
        while ((inputLine = reader.readLine()) != null) {
            System.out.println(inputLine);
        }
        reader.close();

    }
}
