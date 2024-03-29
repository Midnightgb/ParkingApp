package com.example.parkingapp.ui.parking;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.content.SharedPreferences;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.example.parkingapp.R;
import com.example.parkingapp.databinding.FragmentParkingBinding;
import com.example.parkingapp.utils.Config;
import com.example.parkingapp.utils.GlideImageLoader;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class ParkingFragment extends Fragment {

    private FragmentParkingBinding binding;
    AdapterListParking adapter;
    RecyclerView recyclerView;
    Context context;

    JSONArray pakings_array;
    Button btnAgregarParking, btnBackDetail, btnGetCar, btnBackGetCar;
    FloatingActionButton crearParking, btnGoToGetCar;
    EditText editText, field_plate;
    View root;
    String user_rol, user_id;
    TextView field_name_parking, field_address_parking, field_truck, field_pickup_truck, field_car, field_motorcycle, label_camera, labelPlate;
    WebSocket webSocket;

    ImageView imgGetCar, loaderTruck, btnBackCreateParking, btnBackEditParking;
    Config dataConfig;
    String ip_v4;

    ParkingFragment parkingFragment;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentParkingBinding.inflate(inflater, container, false);
        root = binding.getRoot();
        context = root.getContext();
        dataConfig = new Config(context);
        ip_v4 =  dataConfig.getIpV4();
        recyclerView = root.findViewById(R.id.recycler_view_parking_assigned);
        pakings_array = new JSONArray();
        parkingFragment = this;


        SharedPreferences archivo = context.getSharedPreferences("userParking", Context.MODE_PRIVATE);
        user_id = archivo.getString("id", null);
        user_rol = archivo.getString("rol", null);

        loaderTruck = root.findViewById(R.id.loaderTruck);
        Glide.with(context).asGif().load(R.drawable.loader_truck).into(loaderTruck);
        consumoParkings(context);
        editText = root.findViewById(R.id.fildSearchParking);
        crearParking = root.findViewById(R.id.btnCrearParking);
        btnAgregarParking = root.findViewById(R.id.btnAgregarParking);
        btnBackCreateParking = root.findViewById(R.id.btnBackCreateParking);
        btnBackEditParking = root.findViewById(R.id.btnBackEditParking);
        btnBackDetail = root.findViewById(R.id.btnBackDetail);
        field_plate = root.findViewById(R.id.field_plate);
        btnGetCar = root.findViewById(R.id.btnGetCar);
        btnGoToGetCar = root.findViewById(R.id.btnGoToGetCar);
        btnBackGetCar = root.findViewById(R.id.btnBackGetCar);
        label_camera = root.findViewById(R.id.labelNameCamera);
        labelPlate = root.findViewById(R.id.labelPlate);
        imgGetCar = root.findViewById(R.id.imgGetCar);
        if(user_rol.equalsIgnoreCase("seller")){
            crearParking.setVisibility(View.GONE);
        }


        String jsonString = "[{\"name\":\"John\"},{\"name\":\"Alice\"}]";
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            adapter = new AdapterListParking(jsonArray, root, context, this);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        field_name_parking = root.findViewById(R.id.field_name_parking);
        field_address_parking = root.findViewById(R.id.field_address_parking);
        field_truck = root.findViewById(R.id.field_truck);
        field_pickup_truck = root.findViewById(R.id.field_pickup_truck);
        field_car = root.findViewById(R.id.field_car);
        field_motorcycle = root.findViewById(R.id.field_motorcycle);
        crearParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchSection(root.findViewById(R.id.sesionCreateParking), root.findViewById(R.id.sesionListParking));
            }
        });

        btnBackCreateParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumoParkings(context);
                switchSection(root.findViewById(R.id.sesionListParking), root.findViewById(R.id.sesionCreateParking));
            }
        });

        btnGetCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plate = field_plate.getText().toString();
                labelPlate.setText(plate);

                if(plate.trim().isEmpty() || plate.trim().equalsIgnoreCase("")){
                    Toast.makeText(context,"Campo vacio de placa", Toast.LENGTH_LONG).show();
                }else{
                    webSocket.send(plate);
                    loaderTruck.setVisibility(View.VISIBLE);
                }
            }
        });
        btnGoToGetCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchSection(root.findViewById(R.id.sesionGetCar), root.findViewById(R.id.sesionListParking));
            }
        });

        btnBackGetCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchSection(root.findViewById(R.id.sesionListParking), root.findViewById(R.id.sesionGetCar));
            }
        });

        btnBackDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumoParkings(context);
                switchSection(root.findViewById(R.id.sesionListParking), root.findViewById(R.id.sesionDetailParking));
            }
        });
        btnBackEditParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumoParkings(context);
                switchSection(root.findViewById(R.id.sesionListParking), root.findViewById(R.id.sesionEditParking));
            }
        });


        btnAgregarParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumoAgregarParking();
            }

        });
        editText.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se utiliza en este caso
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No se utiliza en este caso
            }

            @Override
            public void afterTextChanged(Editable s) {
                filterParking( editText.getText().toString(),pakings_array);

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        closeFracment();
        binding = null;
    }



    public void consumoParkings(Context context){
        loaderTruck.setVisibility(View.VISIBLE);
        System.out.println("Iniciando consumo");

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "";
        if(user_rol.equalsIgnoreCase("admin")){
            String endpoint = "/parking/getParkings.php";
            url = dataConfig.getEndPoint(endpoint);

        }else{
            String endpoint = "/parking_seller/getParkingSeller.php?id="+user_id;
            url = dataConfig.getEndPoint(endpoint);
        }


        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());
                try {
                    pakings_array = response.getJSONArray("parkings");
                    adapter = new AdapterListParking(pakings_array, root, context, parkingFragment);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(adapter);
                    loaderTruck.setVisibility(View.GONE);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
                loaderTruck.setVisibility(View.GONE);
                Toast.makeText(context, "El servidor no da respuesta", Toast.LENGTH_LONG).show();
            }
        });

        queue.add(solicitud);
    }


    public void filterParking(String searchText, JSONArray parkings) {
        if (searchText == null || searchText.isEmpty()) {
            if(parkings == null){
                consumoParkings(context);
                adapter.updateData(parkings);
            }

        }

        JSONArray filteredParkings = new JSONArray();

        for (int i = 0; i < parkings.length(); i++) {
            try {
                JSONObject parking = parkings.getJSONObject(i);
                String nombre = parking.getString("name");

                if (nombre.toLowerCase().contains(searchText.toLowerCase())) {
                    filteredParkings.put(parking);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        adapter.updateData(filteredParkings);
    }
    public void switchSection(View section, View previousSection) {
        if (section.getVisibility() == View.GONE) {
            section.setVisibility(View.VISIBLE);
            previousSection.setVisibility(View.GONE);
        } else {
            section.setVisibility(View.GONE);
        }
    }
    public void closeFracment(){
        LinearLayout sesionEditParking = root.findViewById(R.id.sesionEditParking);
        LinearLayout sesionDetailParking =root.findViewById(R.id.sesionDetailParking);
        LinearLayout sesionListParking =root.findViewById(R.id.sesionListParking);
        LinearLayout sesionCreateParking =root.findViewById(R.id.sesionCreateParking);
        LinearLayout sesionGetCar = root.findViewById(R.id.sesionGetCar);
        sesionEditParking.setVisibility(View.GONE);
        sesionDetailParking.setVisibility(View.GONE);
        sesionCreateParking.setVisibility(View.GONE);
        sesionGetCar.setVisibility(View.GONE);
        sesionListParking.setVisibility(View.VISIBLE);
    }

    public void consumoAgregarParking(){
        loaderTruck.setVisibility(View.VISIBLE);
        System.out.println("Iniciando consumo");
         List<String> field_check =  check_fields();
         if (field_check != null){
            RequestQueue queue = Volley.newRequestQueue(context);
             String endpoint = "/parking/insertParking.php";
             String url = dataConfig.getEndPoint(endpoint);


            StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        System.out.println("El servidor POST responde OK");
                        JSONObject jsonObject = new JSONObject(response);
                        System.out.println(jsonObject.toString());
                        Toast.makeText(context, "Se agrego el parqueadero correctamente", Toast.LENGTH_LONG).show();
                        cleanFielCrete();
                        consumoParkings(context);
                        loaderTruck.setVisibility(View.GONE);
                    } catch (JSONException e) {
                        System.out.println("El servidor POST responde con un error:");
                        System.out.println(e.getMessage());
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println("El servidor POST responde con un error:");
                    System.out.println(error.getMessage());
                }
            }){
                protected Map<String, String> getParams(){
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("name", field_name_parking.getText().toString());
                    params.put("address", field_address_parking.getText().toString());
                    params.put("camioneta", field_pickup_truck.getText().toString());
                    params.put("camion", field_truck.getText().toString());
                    params.put("carro", field_car.getText().toString());
                    params.put("moto", field_motorcycle.getText().toString());
                    return params;
                }
            };

            queue.add(solicitud);
         }

    }

    public void cleanFielCrete(){
        field_name_parking.setText("");
        field_address_parking.setText("");
        field_pickup_truck.setText("");
        field_truck.setText("");
        field_car.setText("");
        field_motorcycle.setText("");
    }

    public List<String> check_fields() {
        List<String> list_fields_edit = new ArrayList<>();
        list_fields_edit.add(field_name_parking.getText().toString());
        list_fields_edit.add(field_address_parking.getText().toString());
        list_fields_edit.add(field_pickup_truck.getText().toString());
        list_fields_edit.add(field_truck.getText().toString());
        list_fields_edit.add(field_car.getText().toString());
        list_fields_edit.add(field_motorcycle.getText().toString());

        for (String field_edit : list_fields_edit) {
            if (field_edit == null || field_edit.trim().isEmpty()) {

                Toast.makeText(context, "Los campos estan vacios", Toast.LENGTH_LONG).show();
                return null;
            }
        }
        return list_fields_edit;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OkHttpClient client = new OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder().url("ws://"+ip_v4+"/ws/cliente_antonio").build();
        WebSocketListener listener = new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, okhttp3.Response response) {
                super.onOpen(webSocket, response);
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                super.onMessage(webSocket, text);
                System.out.println("se recibe un mensaje"+ text);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadCar(text);
                    }
                });
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                super.onClosed(webSocket, code, reason);
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, okhttp3.Response response) {
                super.onFailure(webSocket, t, response);
            }
        };
        webSocket = client.newWebSocket(request, listener);
    }

    public void loadCar(String text){
        if (text.contains(",")) {
            System.out.println("por aqui ----");
            String[] parts = text.split(",");
            if (parts.length >= 2) {
                System.out.println("por aqui");
                String name_camera = parts[0];
                System.out.println(name_camera);
                label_camera.setText(name_camera);
                String imageUrl = parts[1];
                System.out.println(imageUrl);
                GlideImageLoader.loadImageWithRotation(context, imageUrl, imgGetCar, 0);
                loaderTruck.setVisibility(View.GONE);
            }
        } else {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        }
    }
}
