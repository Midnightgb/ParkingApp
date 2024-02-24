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
                    etEmail.setBackgroundResource(R.drawable.status_default);
                    etEmail.setCompoundDrawablesWithIntrinsicBounds(R.drawable.sms_icon, 0, 0, 0);
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
}