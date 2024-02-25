package com.example.parkingapp.ui.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.parkingapp.MainActivity;
import com.example.parkingapp.R;

public class ForgotPasswordActivity extends AppCompatActivity {
    LinearLayout llEmail;//llEmail is visible
    LinearLayout btnContinue;//btnContinue is visible
    TextView textHelperEmail;//textHelperEmail is visible
    EditText etEmail;

    ImageView btnBack;

    
    Context context;
    
    //section code helper
    LinearLayout llCode;//llCode is gone
    LinearLayout textLlCode;//textLlCode is gone
    LinearLayout btnConfirmCode;//btnConfirmCode is gone
    LinearLayout llResendCode;

    TextView tvUserEmail;
    TextView timerResendCode;

    EditText firstDigit;
    EditText secondDigit;
    EditText thirdDigit;
    EditText fourthDigit;

    //onclick functions to add "sendCode" , "goBack", "confirmCode"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        llEmail = findViewById(R.id.llEmail);
        btnBack = findViewById(R.id.btnBack);
        etEmail = findViewById(R.id.etEmail);
        btnContinue = findViewById(R.id.btnContinue);
        context = getApplicationContext();

        btnContinue.setOnClickListener(v -> {
            System.out.println("Email: " + etEmail.getText().toString());
            Intent intention = new Intent(context, ResetPasswordActivity.class);
            startActivity(intention);
        });

        btnBack.setOnClickListener(v -> {
            Intent intention = new Intent(context, LoginActivity.class);
            startActivity(intention);
        });

        etEmail.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                llEmail.setBackgroundResource(R.drawable.status_acti);
            } else {
                llEmail.setBackgroundResource(R.drawable.border_gray);
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
                if (etEmail.getText().toString().isEmpty()) {
                    llEmail.setBackgroundResource(R.drawable.border_gray);
                    btnContinue.setBackgroundResource(R.drawable.btn_inactive);
                } else {
                    if (validateEmail(etEmail.getText().toString())) {
                        llEmail.setBackgroundResource(R.drawable.status_success);
                        btnContinue.setBackgroundResource(R.drawable.btn_active);
                    } else {
                        btnContinue.setBackgroundResource(R.drawable.btn_inactive);
                        llEmail.setBackgroundResource(R.drawable.status_error);
                    }
                }
            }
        });
    }
    public boolean validateEmail(String email) {
        return email.contains("@");
    }
}