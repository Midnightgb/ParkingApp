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
    LinearLayout sectionInputEmail;
    LinearLayout llEmail;
    LinearLayout btnSendCode;
    EditText etEmail;
    ImageView btnBack;
    Context context;
    //section code helper
    LinearLayout sectionInputCode;
    LinearLayout btnConfirmCode;//this is the confirm code button
    LinearLayout llResendCode;//this is the resend code button
    TextView tvUserEmail;//this is the user email displayed in the code helper
    TextView timerResendCode;//this is the timer displayed in how much time left to be able to resend the code
    EditText firstDigit;//When the user types the first digit of the code it will automatically focus on the second digit otherwise if the user deletes the first digit it will focus on the first digit
    EditText secondDigit;//When the user types the second digit of the code it will automatically focus on the third digit otherwise if the user deletes the second digit it will focus on the first digit
    EditText thirdDigit;//When the user types the third digit of the code it will automatically focus on the fourth digit otherwise if the user deletes the third digit it will focus on the second digit
    EditText fourthDigit;//When the user types the fourth digit of the code it will enable the confirm code button otherwise if the user deletes the fourth digit it will focus on the third digit
    //onclick functions to add "sendCode" , "goBack", "confirmCode"
    Boolean isEmailValid = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        context = getApplicationContext();
        sectionInputEmail = findViewById(R.id.sectionInputEmail);
        sectionInputCode = findViewById(R.id.sectionInputCode);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            if (sectionInputCode.getVisibility() == View.VISIBLE) {
                System.out.println("Go back to input email");
                sectionInputCode.setVisibility(View.GONE);
                sectionInputEmail.setVisibility(View.VISIBLE);
            } else {
                System.out.println("Go back to login");
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });

        llEmail = findViewById(R.id.llEmail);
        etEmail = findViewById(R.id.etEmail);

        btnSendCode = findViewById(R.id.btnContinue);
        btnSendCode.setOnClickListener(v -> {
            if (isEmailValid) {
                System.out.println("Sending code to email");
                System.out.println("Email: " + etEmail.getText().toString());
                sectionInputEmail.setVisibility(View.GONE);
                sectionInputCode.setVisibility(View.VISIBLE);
            }
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
                    btnSendCode.setBackgroundResource(R.drawable.btn_inactive);
                    isEmailValid = false;
                } else {
                    if (validateEmail(etEmail.getText().toString())) {
                        llEmail.setBackgroundResource(R.drawable.status_success);
                        btnSendCode.setBackgroundResource(R.drawable.btn_active);
                        isEmailValid = true;
                    } else {
                        btnSendCode.setBackgroundResource(R.drawable.btn_inactive);
                        llEmail.setBackgroundResource(R.drawable.status_error);
                        isEmailValid = false;
                    }
                }
            }
        });
    }
    public boolean validateEmail(String email) {
        return email.contains("@");
    }
}