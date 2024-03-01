package com.example.parkingapp.ui.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.parkingapp.MainActivity;
import com.example.parkingapp.R;
import com.example.parkingapp.ui.user.customer.SearchUservehicle;
import com.example.parkingapp.utils.Config;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    LinearLayout btnLogin;
    TextView tvForgotPassw, tvLogin;
    String etEmailText, etPasswordText;
    Boolean emailValid = false;
    Context context;

    Config dataConfig;
    boolean loginButtonActive = false;
    ProgressBar loadingIndicator;

    Button btnGetVehicle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = getApplicationContext();
        dataConfig = new Config(context);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassw);
        btnLogin = findViewById(R.id.btnLogin);
        tvLogin = findViewById(R.id.tvLogin);
        tvForgotPassw = findViewById(R.id.tvForgotPassw);
        loadingIndicator = findViewById(R.id.loadingIndicator);
        btnGetVehicle = findViewById(R.id.btnGetVehicle);
        etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // El EditText etEmail tiene el foco
                    etEmail.setBackgroundResource(R.drawable.status_acti);
                    etEmail.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.primary));
                } else {
                    // El EditText etEmail ha perdido el foco
                    etEmailText = etEmail.getText().toString();
                    if (!etEmailText.isEmpty()) {
                        // El EditText etEmail no está vacío
                        emailValid = validateEmail(etEmailText);
                        if (!emailValid) {
                            // El correo no es válido
                            etEmail.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.red));
                            etEmail.setBackgroundResource(R.drawable.status_error);
                        } else {
                            // El correo es válido
                            etEmail.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.green));
                            etEmail.setBackgroundResource(R.drawable.status_success);
                            etPasswordText = etPassword.getText().toString();
                            if (!etEmailText.isEmpty() && !etPasswordText.isEmpty()){
                                btnLogin.setBackgroundResource(R.drawable.btn_active);
                            }else{
                                btnLogin.setBackgroundResource(R.drawable.btn_inactive);
                            }
                        }
                    } else {
                        etEmail.setCompoundDrawablesWithIntrinsicBounds(R.drawable.sms_icon, 0, 0, 0);
                        etEmail.setBackgroundResource(R.drawable.status_default);
                    }
                }
            }
        });
        etEmail.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                     etEmailText = etEmail.getText().toString();
                     if (!etEmailText.isEmpty()) {
                          emailValid = validateEmail(etEmailText);
                          if (!emailValid) {
                            etEmail.setCompoundDrawablesWithIntrinsicBounds(R.drawable.sms_icon, 0, 0, 0);
                            etEmail.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.red));
                            etEmail.setBackgroundResource(R.drawable.status_error);
                          } else {
                            etEmail.setCompoundDrawablesWithIntrinsicBounds(R.drawable.sms_icon, 0, 0, 0);
                            etEmail.setBackgroundResource(R.drawable.status_success);
                            etEmail.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.green));
                            etPasswordText = etPassword.getText().toString();
                            if (!etEmailText.isEmpty() && !etPasswordText.isEmpty()){
                                 btnLogin.setBackgroundResource(R.drawable.btn_active);
                            }else{
                                 btnLogin.setBackgroundResource(R.drawable.btn_inactive);
                            }
                          }
                     } else {
                          etEmail.setCompoundDrawablesWithIntrinsicBounds(R.drawable.sms_icon, 0, 0, 0);
                          etEmail.setBackgroundResource(R.drawable.status_default);
                     }
               }
           });
        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            // El EditText etPassword tiene el foco
                            etPassword.setBackgroundResource(R.drawable.status_acti);
                            etPassword.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.primary));
                        } else {
                            // El EditText etPassword ha perdido el foco
                            etPasswordText = etPassword.getText().toString();
                            if (!etPasswordText.isEmpty()) {
                                // El EditText etPassword no está vacío
                                etPassword.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.green));
                                etPassword.setBackgroundResource(R.drawable.status_success);
                                emailValid = validateEmail(etEmailText);
                                if (emailValid) {
                                    if (!etEmailText.isEmpty() && !etPasswordText.isEmpty()) {
                                        btnLogin.setBackgroundResource(R.drawable.btn_active);
                                    } else {
                                        btnLogin.setBackgroundResource(R.drawable.btn_inactive);
                                    }
                                }
                            } else {
                                etPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock_icon, 0, 0, 0);
                                etPassword.setBackgroundResource(R.drawable.status_default);
                            }
                        }
                    }
                });
        btnGetVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchUservehicle.class);
                startActivity(intent);
                finish();
            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                etPasswordText = etPassword.getText().toString();
                if (!etPasswordText.isEmpty()) {
                    emailValid = validateEmail(etEmailText);
                    if (emailValid){
                        if (!etEmailText.isEmpty() && !etPasswordText.isEmpty()){
                            btnLogin.setBackgroundResource(R.drawable.btn_active);
                        }else{
                            btnLogin.setBackgroundResource(R.drawable.btn_inactive);
                        }
                    }
                } else {
                    etPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock_icon, 0, 0, 0);
                    etPassword.setBackgroundResource(R.drawable.status_default);
                    btnLogin.setBackgroundResource(R.drawable.btn_inactive);
                }
            }
        });
    }
    public void authenticateUser(View view) {
        if (loginButtonActive) {
            System.out.println("Ya se ha enviado una petición de autenticación");
            return;
        }
        if (emailValid && !etEmailText.isEmpty() && !etPasswordText.isEmpty()) {
            System.out.println("Enviando petición de autenticación");
            String endpoint = "/users/getUser.php";
            String url = dataConfig.getEndPoint(endpoint);
            RequestQueue queue = Volley.newRequestQueue(context);
            System.out.println("URL: " + url);
            alternateLoaderVisibility();
            StringRequest request =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject datos = new JSONObject(response);
                        System.out.println("Respuesta del servidor: " + datos.toString());
                        if (datos.getBoolean("status")) {
                            if (datos.getJSONObject("datos").getString("status").equals("inactivo")){
                                Toast.makeText(context, "Usuario inactivo. Contacte soporte.", Toast.LENGTH_LONG).show();
                                etEmail.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.red));
                                etEmail.setBackgroundResource(R.drawable.status_error);
                                alternateLoaderVisibility();
                                return;
                            }
                            if (datos.getJSONObject("datos").getString("password").equals("OK")) {
                                System.out.println("Usuario autenticado");
                                SharedPreferences preferences = getSharedPreferences("userParking", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("id", datos.getJSONObject("datos").getString("id"));
                                editor.putString("name", datos.getJSONObject("datos").getString("name"));
                                editor.putString("rol", datos.getJSONObject("datos").getString("rol"));
                                editor.putString("email", etEmailText);
                                editor.apply();
                                Intent intention = new Intent(context, MainActivity.class);
                                startActivity(intention);
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        alternateLoaderVisibility();
                                    }
                                }, 2000); // 2000 ms = 2s
                            } else {
                                Toast.makeText(context, "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                                etPassword.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.red));
                                etPassword.setBackgroundResource(R.drawable.status_error);
                                alternateLoaderVisibility();
                            }
                        }else {
                            Toast.makeText(context, datos.getString("message"), Toast.LENGTH_LONG).show();
                            etEmail.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.red));
                            etEmail.setBackgroundResource(R.drawable.status_error);
                            alternateLoaderVisibility();
                        }
                    } catch (JSONException e) {
                        alternateLoaderVisibility();
                        throw new RuntimeException(e);
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    alternateLoaderVisibility();
                    System.out.println("El servidor POST responde con un error:");
                    System.out.println(error.getMessage());
                }
            }){
                protected Map<String, String> getParams(){
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("email", etEmailText);
                    params.put("validatePass", etPasswordText);
                    return params;
                }
            };
            queue.add(request);
        }
    }
    public void forgotPassword(View view) {
        System.out.println("Olvidé mi contraseña");
        context = getApplicationContext();
        Intent intention = new Intent(context, ForgotPasswordActivity.class);
        startActivity(intention);
    }

    public boolean validateEmail(String email) {
        return email.contains("@");
    }

    public void alternateLoaderVisibility() {
        if (loadingIndicator.getVisibility() == View.VISIBLE) {
            loginButtonActive = false;
            loadingIndicator.setVisibility(View.GONE);
            tvLogin.setVisibility(View.VISIBLE);
            System.out.println("Ocultando indicador de carga");
            System.out.println("Habilitando botón de login");
            System.out.println("Mostrando texto de login");
            System.out.println("LoginButtonActive: " + loginButtonActive);
        } else {
            loginButtonActive = true;
            loadingIndicator.setVisibility(View.VISIBLE);
            tvLogin.setVisibility(View.GONE);
            System.out.println("Mostrando indicador de carga");
            System.out.println("Deshabilitando botón de login");
            System.out.println("Ocultando texto de login");
            System.out.println("LoginButtonActive: " + loginButtonActive);
        }
    }
}