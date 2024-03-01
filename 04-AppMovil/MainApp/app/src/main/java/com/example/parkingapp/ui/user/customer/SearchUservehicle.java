package com.example.parkingapp.ui.user.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.parkingapp.R;
import com.example.parkingapp.ui.authentication.LoginActivity;
import com.example.parkingapp.utils.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class SearchUservehicle extends AppCompatActivity {
    EditText plateGetVehicle;
    Button btnGetDetailVehicle, btnBackGetVehiclePlate;
    Config dataConfig;

    TextView statusTiket, date_entry, plate_vehicle, category_vehicle, nameOwer, timeNow;
    LinearLayout layoutGetVehicleDetail, layoutGetVehiclePlate;
    Boolean isUpdateThreadRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_uservehicle);
        btnGetDetailVehicle = findViewById(R.id.btnGetDetailVehicle);
        plateGetVehicle = findViewById(R.id.plateGetVehicle);
        layoutGetVehicleDetail = findViewById(R.id.layoutGetVehicleDetail);
        layoutGetVehiclePlate = findViewById(R.id.layoutGetVehiclePlate);
        btnBackGetVehiclePlate = findViewById(R.id.btnBackGetVehiclePlate);
        dataConfig = new Config(getApplicationContext());

        statusTiket = findViewById(R.id.statusTiket);
        date_entry = findViewById(R.id.date_entry);
        plate_vehicle = findViewById(R.id.plate_vehicle);
        category_vehicle = findViewById(R.id.category_vehicle);
        nameOwer = findViewById(R.id.nameOwer);
        timeNow = findViewById(R.id.timeNow);
        startUpdateThread();
        btnGetDetailVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plate_input = plateGetVehicle.getText().toString();
                if(plate_input.trim().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Debes ingresar una placa", Toast.LENGTH_LONG).show();
                }else{
                    buscarTicket(plate_input);
                }

            }
        });

        btnBackGetVehiclePlate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backLogin();
            }
        });
    }




    public void buscarTicket(String plate){
//        loaderTruck.setVisibility(View.VISIBLE);
        String url = dataConfig.getEndPoint("/vehicle/getVehicleTiket.php?plate="+plate);
        Date fechaActu = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActu);

        TimeZone timeZoneColombia = TimeZone.getTimeZone("America/Bogota");
        calendar.setTimeZone(timeZoneColombia);

        Date fechaActual = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZoneColombia);


        String fechaFormateada = sdf.format(fechaActual);

        System.out.println("Fecha actual:"+fechaFormateada);

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest solicitud =  new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String status = jsonObject.getString("status");

                    String message = jsonObject.getString("message");;

                    if(status.equals("true")){
                        JSONArray data = jsonObject.getJSONArray("datos");
                        JSONObject data_vehicle = data.getJSONObject(0);
                        String plate = data_vehicle.getString("plate");
                        String name_owner = data_vehicle.getString("name_owner");
                        String category = data_vehicle.getString("category");
                        String entry_date = data_vehicle.getString("entry_date");
                        String status_tiket = data_vehicle.getString("status");
                        plate_vehicle.setText(plate);
                        date_entry.setText(entry_date);
                        nameOwer.setText(name_owner);
                        category_vehicle.setText(category);
                        statusTiket.setText(status_tiket);
                        layoutGetVehiclePlate.setVisibility(View.GONE);
                        layoutGetVehicleDetail.setVisibility(View.VISIBLE);

                    }else{
                        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                        backLogin();
                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor GET responde con un error:");
                System.out.println(error.getMessage());
                Toast.makeText(getApplicationContext(),"Error al cargar la informacion",Toast.LENGTH_LONG).show();
                backLogin();

            }
        });

        queue.add(solicitud);
    }

    public void backLogin(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private String getCurrentTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/Bogota"));
        return dateFormat.format(new Date());
    }

    protected void onDestroy() {
        super.onDestroy();
        // Detener el hilo cuando la actividad se destruye
        stopUpdateThread();
    }

    private void stopUpdateThread() {
        isUpdateThreadRunning = false;
    }

    private void startUpdateThread() {
        isUpdateThreadRunning = true;
        Thread updateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isUpdateThreadRunning) {
                    try {
                        final String currentTime = getCurrentTime();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                timeNow.setText(currentTime);
                            }
                        });
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        updateThread.start();
    }

}