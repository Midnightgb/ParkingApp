package com.example.parkingapp.ui.vehicle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.example.parkingapp.databinding.FragmentVehicleBinding;
import com.example.parkingapp.utils.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VehicleFragment extends Fragment {

    private FragmentVehicleBinding binding;
    Context context;
    JSONArray listaVehiculos;
    Config dataConfig;
    RecyclerView recycler_view_vehicles;
    AdapterVehicles adapterVehicles;
    Button btn_charge;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentVehicleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = root.getContext();
        dataConfig = new Config(context);
        btn_charge = binding.btnCharge;
        recycler_view_vehicles = binding.recyclerViewVehicles;
        SharedPreferences sharedPreferences = context.getSharedPreferences("ticket", Context.MODE_PRIVATE);

        String userid = sharedPreferences.getString("id", null);
        System.out.println("este es el id"+userid);
        SharedPreferences id_ticket = context.getSharedPreferences("userParking", Context.MODE_PRIVATE);

        String id = id_ticket.getString("id", null);
        System.out.println("este es el id"+id);
        String idticket =id;
        String url = dataConfig.getEndPoint("/ticket/getTicketRol.php?id="+userid);
        listaVehiculos = new JSONArray();
        adapterVehicles = new AdapterVehicles(listaVehiculos, binding.getRoot());
        consumirApi(url);

        btn_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = dataConfig.getEndPoint("/ticket/getTicket.php.php?id="+idticket);

                buscarTicket(url);
                switchSection(binding.layoutResumeTicket, binding.layoutTicket);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void consumirApi(String url){

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
                            if(ticket.getString("status").equals("inactivo")){
                                listaVehiculos.put(ticket);
                            }
                        }
                        System.out.println("Hola"+listaVehiculos);

                        adapterVehicles = new AdapterVehicles(listaVehiculos, binding.getRoot());
                        recycler_view_vehicles.setLayoutManager(new LinearLayoutManager(context));
                        recycler_view_vehicles.setAdapter(adapterVehicles);
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

    public  void buscarTicket (String url){
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
                        JSONObject ticket = jsonObject.getJSONObject("datos");
                        binding.NameParking2.setText(ticket.getString("name_parking"));
                        binding.addressParking2.setText(ticket.getString("address_parking"));
                        binding.Plate_vehicle2.setText(ticket.getString("plate_vehicle"));
                        binding.date_entry2.setText(ticket.getString("date_entry"));
                        binding.total.setText(ticket.getString("duration"));



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
}