package com.example.parkingapp.utils;

import android.content.Context;
import android.content.res.Resources;

import com.example.parkingapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    String apiHost;

    public Config(Context context){
        Resources res = context.getResources();
        InputStream inputStream = res.openRawResource(R.raw.config);

        try {
            Properties properties = new Properties();
            properties.load(inputStream);

            apiHost = properties.getProperty("api_host");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEndPoint(String endpoint){
        endpoint = endpoint.replaceFirst("/", "");
        return apiHost+"/"+endpoint;
    }
}
