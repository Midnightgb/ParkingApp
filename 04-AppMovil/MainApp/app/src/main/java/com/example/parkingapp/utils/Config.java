package com.example.parkingapp.utils;

import android.content.Context;
import android.content.res.Resources;

import com.example.parkingapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    String apiHost;
    String ip_v4;

    public Config(Context context){
        Resources res = context.getResources();
        InputStream inputStream = res.openRawResource(R.raw.config);

        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            ip_v4 = properties.getProperty("ip_v4");
            apiHost = properties.getProperty("api_host");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEndPoint(String endpoint){
        endpoint = endpoint.replaceFirst("/", "");
        return apiHost+"/"+endpoint;
    }

    public String getIpV4(){
        return ip_v4;
    }
}
