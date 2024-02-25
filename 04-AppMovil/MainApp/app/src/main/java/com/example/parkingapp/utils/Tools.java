package com.example.parkingapp.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Tools {
    Config dataConfig;

    public void requestApi(Context context, String endpoint, int method, JSONObject requestBody, ApiCallback callback) {
        System.out.println("Iniciando consumo");
        RequestQueue queue = Volley.newRequestQueue(context);
        dataConfig = new Config(context);
        String url = dataConfig.getEndPoint(endpoint);
        JsonObjectRequest request = new JsonObjectRequest(method, url, requestBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());
                try {
                    System.out.println("El servidor responde OK");
                    System.out.println(response.toString());
                    System.out.println(response.getJSONArray("parkings").toString());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                callback.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
                callback.onErrorResponse(error);
            }
        });
        queue.add(request);
    }

    public interface ApiCallback {
        void onResponse(JSONObject response);
        void onErrorResponse(VolleyError error);
    }

}
