package com.example.parkingapp.ui.vehicle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.parkingapp.R;
import com.example.parkingapp.databinding.FragmentVehicleBinding;
import com.example.parkingapp.utils.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.Locale;
public class VehicleFragment extends Fragment {

    private FragmentVehicleBinding binding;
    Context context;
    JSONArray listaVehiculos;
    Config dataConfig;
    RecyclerView recycler_view_vehicles;
    AdapterVehicles adapterVehicles;
    Button btn_charge,volver2,btn_back2,btn_Confirm_cheged,volver3;
    TextView name_parking,address_parking,Plate_vehicle2,date_entry2,durarion2,durariton,Plate_vehicle3,date_entry3,date_exit;
    private Handler handler;
    private  TextView timeNow;
    ImageView loaderTruck;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentVehicleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = root.getContext();
        dataConfig = new Config(context);
        btn_charge = binding.btnCharge;
        loaderTruck = binding.loaderTruck;
        Glide.with(context).asGif().load(R.drawable.loader_truck).into(loaderTruck);
        recycler_view_vehicles = binding.recyclerViewVehicles;
        name_parking = binding.nameParking;
        address_parking = binding.addressParking;
        Plate_vehicle2 = binding.PlateVehicle2;
        date_entry2 = binding.dateEntry2;
        volver2 = binding.volver2;
        btn_back2 = binding.btnBack2;
        btn_Confirm_cheged = binding.btnConfirmCheged;
        durarion2 = binding.durarion2;
        durariton = binding.durariton;
        timeNow = binding.timeNow;
        Plate_vehicle3 = binding.PlateVehicle3;
        date_entry3 = binding.dateEntry3;
        date_exit = binding.dateExit;
        volver3 = binding.volver3;


        handler = new Handler();

        // Iniciar el hilo de actualización
        startUpdateThread();
        SharedPreferences sharedPreferences = context.getSharedPreferences("userParking", Context.MODE_PRIVATE);

        String userid = sharedPreferences.getString("id", null);
        System.out.println("este es el id"+userid);


        String url = dataConfig.getEndPoint("/ticket/getTicketRol.php?id="+userid);
        listaVehiculos = new JSONArray();
        adapterVehicles = new AdapterVehicles(listaVehiculos, binding.getRoot());

        consumirApi(url);

        btn_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                buscarTicket();
                switchSection(binding.layoutResumeTicket, binding.layoutTicket);
            }
        });
        volver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchSection(binding.layoutTicket, binding.layoutResumeTicket);
            }
        });

        btn_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchSection(binding.layoutTicket, binding.layoutResumeTicket);
            }
        });

        btn_Confirm_cheged.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchSection(binding.layoutPayment, binding.layoutResumeTicket);
                buscarTicket();
            }
        });
        volver3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchSection(binding.layoutVehicles, binding.layoutPayment);
                listaVehiculos = new JSONArray();
                consumirApi(url);
            }
        });



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void startUpdateThread() {
        // Crear un  hilo
        Thread updateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {

                        final String currentTime = getCurrentTime();

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                timeNow.setText(currentTime);
                            }
                        });

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        // Iniciar el hilo
        updateThread.start();
    }

    private String getCurrentTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/Bogota"));
        return dateFormat.format(new Date());
    }

    public void consumirApi(String url){
        loaderTruck.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());

        StringRequest solicitud =  new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String status = jsonObject.getString("status");
                    System.out.println(jsonObject);
                    String message = jsonObject.getString("message");;
                    System.out.println(message);
                    System.out.println(status);
                    if(status.equals("true")){
                        JSONArray arreglo = jsonObject.getJSONArray("datos");
                        for(int i=0; i<arreglo.length();i++){
                            JSONObject ticket = arreglo.getJSONObject(i);
                            if(ticket.getString("status").equals("activo")){
                                listaVehiculos.put(ticket);
                            }
                        }
                        System.out.println("Hola"+listaVehiculos);

                        adapterVehicles = new AdapterVehicles(listaVehiculos, binding.getRoot());
                        recycler_view_vehicles.setLayoutManager(new LinearLayoutManager(context));
                        recycler_view_vehicles.setAdapter(adapterVehicles);
                        loaderTruck.setVisibility(View.GONE);
                    }else{
                        loaderTruck.setVisibility(View.GONE);
                        Toast.makeText(context.getApplicationContext(),message,Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);


                }
                loaderTruck.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor GET responde con un error:");
                System.out.println(error.getMessage());
                Toast.makeText(context.getApplicationContext(),"Error al crear al usuario",Toast.LENGTH_LONG).show();
            }
        });

        queue.add(solicitud);

    }

    public  void buscarTicket (){
        loaderTruck.setVisibility(View.VISIBLE);
        SharedPreferences id_ticket = context.getSharedPreferences("ticket", Context.MODE_PRIVATE);


        String id = id_ticket.getString("id", null);
        String url2 = dataConfig.getEndPoint("/ticket/insertTicketTotal.php");
        String url = dataConfig.getEndPoint("/ticket/getTicket.php?id="+id);
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
        Boolean respuesta =totalTicket(url2,id,fechaFormateada);


            RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());

            StringRequest solicitud =  new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String status = jsonObject.getString("status");

                        String message = jsonObject.getString("message");;

                        if(status.equals("true")){

                            JSONObject ticket = jsonObject.getJSONObject("datos");
                            if (binding.layoutResumeTicket.getVisibility() == View.VISIBLE) {
                                binding.NameParking2.setText(name_parking.getText());
                                binding.addressParking2.setText(address_parking.getText());
                                Plate_vehicle2.setText(ticket.getString("plate"));
                                date_entry2.setText(ticket.getString("entry_date"));
                                binding.total.setText(ticket.getString("total"));
                                durarion2.setText(durariton.getText());
                                loaderTruck.setVisibility(View.GONE);

                            } else if (binding.layoutPayment.getVisibility() == View.VISIBLE) {
                                cambiarEstadoTicket(id);
                                binding.NameParking3.setText(name_parking.getText());
                                Plate_vehicle3.setText(ticket.getString("plate"));
                                date_entry3.setText(ticket.getString("entry_date"));
                                binding.hours3.setText(durariton.getText());
                                binding.durarion3.setText(durariton.getText());
                                date_exit.setText(ticket.getString("exit_date"));
                                loaderTruck.setVisibility(View.GONE);

                            }


                        }else{
                            Toast.makeText(context.getApplicationContext(),message,Toast.LENGTH_LONG).show();
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
                    Toast.makeText(context.getApplicationContext(),"Error al crear al usuario",Toast.LENGTH_LONG).show();
                }
            });

            queue.add(solicitud);


    }
    public void switchSection(View section, View previousSection) {
        if (section.getVisibility() == View.GONE) {
            section.setVisibility(View.VISIBLE);
            previousSection.setVisibility(View.GONE);
        } else {
            section.setVisibility(View.GONE);
        }
    }

    public Boolean totalTicket(String url,String id,String date){
        loaderTruck.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        final Boolean[] respuesta = {false};
        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String status = jsonObject.getString("status");


                    if(status.equals("true")){
                        respuesta[0] = true;
                        loaderTruck.setVisibility(View.GONE);

                    }else{
                        respuesta[0] = false;
                        loaderTruck.setVisibility(View.GONE);

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
                Toast.makeText(context.getApplicationContext(),"Error al crear al usuario",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                params.put("date", date);
                return params;
            }
        }
                ;

        queue.add(solicitud);
        return respuesta[0];
    }

    public void cambiarEstadoTicket(String id){
        loaderTruck.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        String url = dataConfig.getEndPoint("/ticket/changeStatus.php");
        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String status = jsonObject.getString("status");
                    String message = jsonObject.getString("mesagge");;
                    if(status.equals("true")){
                        loaderTruck.setVisibility(View.GONE);
                        Toast.makeText(context.getApplicationContext(),message,Toast.LENGTH_LONG).show();
                    }else{
                        loaderTruck.setVisibility(View.GONE);
                        Toast.makeText(context.getApplicationContext(),message,Toast.LENGTH_LONG).show();
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
                Toast.makeText(context.getApplicationContext(),"Error al crear al usuario",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                params.put("status", "activo");
                return params;
            }
        }
                ;

        queue.add(solicitud);
    }
}