package com.example.parkingapp.ui.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.parkingapp.MainActivity;
import com.example.parkingapp.R;
import com.example.parkingapp.utils.Tools;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    LinearLayout btnLogin;
    TextView tvForgotPassw;
    String etEmailText;
    String etPasswordText;
    Boolean emailValid = false;
    Context context;
    Tools request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassw);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgotPassw = findViewById(R.id.tvForgotPassw);
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
                    }
                }
            }
        });
    }
    public void authenticateUser(View view) {
        System.out.println("Autenticando usuario");
        if (emailValid && !etEmailText.isEmpty() && !etPasswordText.isEmpty()){
            String endpoint = "/GetUser.php";
            int method = Request.Method.POST;
            context = getApplicationContext();
            request = new Tools();
            JSONObject requestBody = new JSONObject();
            JSONObject userData = new JSONObject();
            try {
                requestBody.put("email", etEmailText);
                requestBody.put("password", etPasswordText);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        request.requestApi(context, endpoint, method, requestBody, new Tools.ApiCallback() {
                @Override
                public void onResponse(JSONObject response) {
                    System.out.println("El servidor responde OK");
                    System.out.println(response.toString());

                    Intent intention = new Intent(context, MainActivity.class);
                    startActivity(intention);
                }

                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println("El servidor responde con un error:");
                    System.out.println(error.getMessage());
                }
            });
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
}