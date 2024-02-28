package com.example.parkingapp.ui.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
import com.example.parkingapp.R;
import com.example.parkingapp.databinding.FragmentUserBinding;
import com.example.parkingapp.ui.parking.AdapterListParking;
import com.example.parkingapp.utils.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserFragment extends Fragment {

    EditText etNombreS;
    EditText idUser;
    EditText etEmailS;
    EditText etpasswS;
    LinearLayout btnCreateUser ,layoutCreateUser,usersLayout;
    Spinner roles;
    Context context;
    Config dataConfig;
    Button btntoCreate;
    private FragmentUserBinding binding;
    String user_id,user_rol;
    JSONArray user_array;
    AdapterListUser adapter;
    View root;
    RecyclerView recyclerView;
    EditText editText;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentUserBinding.inflate(inflater, container, false);
        root = binding.getRoot();
        context = root.getContext();
        etNombreS = binding.etNombreS;
        etEmailS = binding.etEmailS;
        etpasswS = binding.etpasswS;
        btnCreateUser = binding.btnCreateUser;
        roles = binding.roles;
        idUser = binding.idUser;
        layoutCreateUser = binding.layoutCreateUser;
        dataConfig = new Config(context);
        editText = root.findViewById(R.id.fildSearchParking);
        SharedPreferences archivo = context.getSharedPreferences("userParking", Context.MODE_PRIVATE);
        user_id = archivo.getString("id", null);
        user_rol = archivo.getString("rol", null);
        recyclerView = root.findViewById(R.id.recycler_view_parking_assigned);
        user_array = new JSONArray();
        String jsonString = "[{\"name\":\"John\"},{\"name\":\"Alice\"}]";
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            adapter = new AdapterListUser(jsonArray, root, context);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        consumoParkings(context);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser(v);
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
                filterParking( editText.getText().toString(),user_array);

            }
        });
        return root;
    }

    public void filterParking(String searchText, JSONArray users) {
        if (searchText == null || searchText.isEmpty()) {
            if(users == null){
                consumoParkings(context);
                adapter.updateData(users);
            }

        }

        JSONArray filteredParkings = new JSONArray();

        for (int i = 0; i < users.length(); i++) {
            try {
                JSONObject parking = users.getJSONObject(i);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void createUser(View view){
        String etNombreSText = etNombreS.getText().toString();
        String etEmailSText = etEmailS.getText().toString();
        String etpasswSText = etpasswS.getText().toString();
        String rolesText = roles.getSelectedItem().toString();
        String idUserText = idUser.getText().toString();
        if (!etNombreSText.isEmpty() && !etEmailSText.isEmpty() && !etpasswSText.isEmpty()){
            String url = dataConfig.getEndPoint("/users/Insert.php") ;
            RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());

            StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String respuesta = jsonObject.getString("status");
                        System.out.println(jsonObject);
                        String message = jsonObject.getString("mesagge");;
                        if (respuesta.equals("true")) {
                            Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();
                            etNombreS.setText("");
                            etEmailS.setText("");
                            etpasswS.setText("");
                            idUser.setText("");

                        } else {
                            Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();


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
                    params.put("iduser", idUserText);
                    params.put("name", etNombreSText);
                    params.put("email", etEmailSText);
                    params.put("password", etpasswSText);
                    params.put("rol", rolesText);
                    return params;
                }
            };

            queue.add(solicitud);


        }else{
            Toast.makeText(context, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }
    }


    public void consumoParkings(Context context){
        System.out.println("Iniciando consumo");
        RequestQueue queue = Volley.newRequestQueue(context);
        String endpoint = "/users/getUsers.php?id="+user_id;
        String url = dataConfig.getEndPoint(endpoint);
        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());
                try {
                    user_array = response.getJSONArray("users");
                    adapter = new AdapterListUser(user_array, root, context);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(adapter);
//                    loaderTruck.setVisibility(View.GONE);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
//                loaderTruck.setVisibility(View.GONE);
                Toast.makeText(context, "El servidor no da respuesta", Toast.LENGTH_LONG).show();
            }
        });

        queue.add(solicitud);
    }
}