package com.tripcomposer.restClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class TripRestClient {
	
	private static final String KEY = "$1$12309856$euBrWcjT767K2sP9MHcVS/";
	private static final String TRIPCOMPOSER_COUNTRIES_GET = "http://tripcomposer.net/rest/test/countries/get";

	public JSONArray getJsonCountries(){
		JSONArray jsonCountries = null;
			JSONObject output = null;
			JSONObject jsonObject = new JSONObject();
			jsonObject.append("key", KEY);
			jsonObject.append("echo", "test1234");
			System.out.println(jsonObject);

			try {
				URL url = new URL(TRIPCOMPOSER_COUNTRIES_GET);
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
				 jsonCountries = output.getJSONArray("countries");

			}
			
		return jsonCountries;
	}

}
