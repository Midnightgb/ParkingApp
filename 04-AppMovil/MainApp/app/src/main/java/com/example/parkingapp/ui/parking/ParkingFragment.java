package com.example.parkingapp.ui.parking;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
import com.example.parkingapp.R;
import com.example.parkingapp.databinding.FragmentParkingBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class ParkingFragment extends Fragment {

    private FragmentParkingBinding binding;
    AdapterListParking adapter;
    RecyclerView recyclerView;
    Context context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentParkingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = root.getContext();
        recyclerView = root.findViewById(R.id.recycler_view_parking_assigned);
//        consumoParkings(context);

        EditText editText = root.findViewById(R.id.fildSearchParking);;

        editText.addTextChangedListener(new TextWatcher() {
            private final long DELAY = 1000; // Tiempo de espera en milisegundos
            private long lastTextEditTime = 0;

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
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastTextEditTime > DELAY) {
                    //filterParking();
                }
                lastTextEditTime = currentTime;
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



//    public void consumoParkings(Context context){
//        System.out.println("Iniciando consumo");
//
//        //RequestQueue queue = Volley.newRequestQueue(context);
//        String url = "http://192.168.1.1/api-php/parking/getParkings.php";
//
//        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                System.out.println("El servidor responde OK");
//                System.out.println(response.toString());
//                try {
//                    adapter = new AdapterListParking(response.getJSONArray("parkings"));
//                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
//                    recyclerView.setAdapter(adapter);
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                System.out.println("El servidor responde con un error:");
//                System.out.println(error.getMessage());
//            }
//        });
//
//        queue.add(solicitud);
//    }

    public void filterParking(String searchText, JSONArray parkings) {
        if (parkings == null || searchText.isEmpty() ) {

            return;
        }


        for (int i = 0; i < parkings.length(); i++) {
            try {
                JSONObject parking = parkings.getJSONObject(i);

                String nombre = parking.getString("nombre");

                if (nombre.toLowerCase().contains(searchText.toLowerCase())) {

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        adapter = new AdapterListParking(parkings);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }

}
