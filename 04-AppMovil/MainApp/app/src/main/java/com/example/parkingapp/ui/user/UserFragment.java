package com.example.parkingapp.ui.user;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.parkingapp.databinding.FragmentUserBinding;
import com.example.parkingapp.utils.Config;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserFragment extends Fragment {

    EditText etNombreS;
    EditText idUser;
    EditText etEmailS;
    EditText etpasswS;
    LinearLayout btnCreateUser;
    Spinner roles;
    Context context;
    Config dataConfig;
    private FragmentUserBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentUserBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = root.getContext();
        etNombreS = binding.etNombreS;
        etEmailS = binding.etEmailS;
        etpasswS = binding.etpasswS;
        btnCreateUser = binding.btnCreateUser;
        roles = binding.roles;
        idUser = binding.idUser;
        dataConfig = new Config(context);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser(v);
            }
        });


        return root;
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
                        String message = message = jsonObject.getString("mesagge");;
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
            }
                    ;

            queue.add(solicitud);


        }else{
            Toast.makeText(context, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }
    }
}