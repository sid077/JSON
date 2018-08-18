package com.siddhant.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        String result = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownlaodTask task = new DownlaodTask();
        try {
            task.execute("http://dataservice.accuweather.com/forecasts/v1/daily/1day/locationKey?apikey=London&language=en-us&details=true&metric=true").get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
