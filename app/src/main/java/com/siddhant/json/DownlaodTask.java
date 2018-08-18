package com.siddhant.json;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownlaodTask extends AsyncTask<String,Void,String>{

    @Override
    protected String doInBackground(String... strings) {
        String result = "" ;
        HttpURLConnection connection=null;
        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            int data = reader.read();
            while (data != -1){
                char ch = (char)data;
                result += ch;
                data = reader.read();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

   @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
       try {
           JSONObject jsonObject = new JSONObject(result);
           String weatherInfo = jsonObject.getString("weather");
           JSONArray arr = new JSONArray(weatherInfo);
           JSONObject jsonPart = arr.getJSONObject(0);
           Log.i("Main",jsonPart.getString("main"));
         Log.i("Description",jsonPart.getString("description"));
           Log.i("Weather Info",weatherInfo);
       } catch (JSONException e) {
           Log.i("Info","Not Found");
       }
      // Log.i("Weather content",result);

    }
}
