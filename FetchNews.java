package com.example.NewsApi.services;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FetchNews {

    public ArrayList<String> ftechApi() {
        ArrayList<String> ar = new ArrayList<>();
        try {
            URL url = new URL("https://newsapi.org/v2/top-headlines?country=in&apiKey=bfa4bc058f6b4f39bbc8c5928eed03f0");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode(); //Get the response code

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String s = "";
                Scanner scanner = new Scanner(url.openStream());
                //all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    s += scanner.nextLine();
                }
                scanner.close();
                System.out.println(s);
                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();  //jsonparser is  a class
                JSONObject data_obj = (JSONObject) parse.parse(s);

                JSONArray arr = (JSONArray) data_obj.get("articles");//Get the required data using its key

                // FileWriter fstream = new FileWriter("C:\\Users\\RAHUL MALI\\Desktop\\apiFetch.txt");
                //BufferedWriter out = new BufferedWriter(fstream);

                // out.write("Status: " + data_obj.get("status")+"\n");
                //out.write("Total Result: " + data_obj.get("totalResults")+"\n");

                for (int i = 0; i < arr.size(); i++) {
                    JSONObject new_obj = (JSONObject) arr.get(i);
                    System.out.println("Title: " + new_obj.get("title"));
                    ar.add((String) new_obj.get("title"));
                    //print in txt file
                    //  out.write("Title: " + new_obj.get("title")+"\n");
                }
                //out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     return ar;
    }
}