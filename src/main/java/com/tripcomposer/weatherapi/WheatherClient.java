package com.tripcomposer.weatherapi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ESER on 19.04.2017.
 */
public class WheatherClient {
   // http://api.openweathermap.org/data/2.5/weather?q=Boguslav,ua&appid=dc24d3bd640d9fc35fda1e5cf3811a8c
    public static void main(String[]args){
        System.out.println(getJsonCountries().toString());
    }
   // private static final String KEY = "$1$12309856$euBrWcjT767K2sP9MHcVS/";
    private static final String OPEN_WEATHER_MAP = "http://api.openweathermap.org/data/2.5/weather?q=Boguslav,ua&appid=dc24d3bd640d9fc35fda1e5cf3811a8c";

    public static JSONArray getJsonCountries(){
        JSONArray jsonCountries = null;
        JSONObject output = null;
        JSONObject jsonObject = new JSONObject();
    ///    jsonObject.append("key", KEY);
    //    jsonObject.append("echo", "test1234");
        System.out.println(jsonObject);

        try {
            URL url = new URL(OPEN_WEATHER_MAP);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            OutputStreamWriter out = new OutputStreamWriter(
                    connection.getOutputStream());
            out.write(jsonObject.toString());
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String outputString;
            while ((outputString = in.readLine()) != null) {
                System.out.println(outputString);
                output = new JSONObject(outputString);
            }
            System.out
                    .println("\nREST Service Invoked Successfully..");

            in.close();
        } catch (Exception e) {
            System.out.println("\nError while calling Tripcomposer REST Service");
            System.out.println(e);
        }
        if (output != null) {
            jsonCountries = output.getJSONArray("weather");

        }

        return jsonCountries;
    }

}
