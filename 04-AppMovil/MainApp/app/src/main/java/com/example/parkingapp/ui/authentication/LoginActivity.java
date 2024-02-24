package com.example.parkingapp.ui.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.parkingapp.R;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    LinearLayout btnLogin;
    TextView tvForgotPassw;
    String etEmailText;
    String etPasswordText;

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
                    etEmailText = etEmail.getText().toString();

                    if (!etEmailText.isEmpty()) {
                        // El EditText etEmail ha perdido el foco y no está vacío
                        //etEmail.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.black));
                        if (!validateEmail(etEmailText)) {
                            System.out.println("Correo inválido");
                            etEmail.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.red));
                            etEmail.setBackgroundResource(R.drawable.status_error);
                        } else {
                            System.out.println("Correo válido");
                            etEmail.getCompoundDrawables()[0].setTint(ContextCompat.getColor(getApplicationContext(), R.color.green));
                            etEmail.setBackgroundResource(R.drawable.status_success);

                            if (!etEmailText.isEmpty() && !etPasswordText.isEmpty()){
                                btnLogin.setBackgroundResource(R.drawable.btn_active);
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
                    etPassword.setBackgroundResource(R.drawable.status_default);
                    etPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock_icon, 0, 0, 0);
                }
            }
        });
    }
    public void authenticateUser(View view) {
        System.out.println("Autenticando usuario");
    }
    public void forgotPassword(View view) {
        System.out.println("Olvidé mi contraseña");
    }

    public boolean validateEmail(String email) {
        return email.contains("@");
    }
}