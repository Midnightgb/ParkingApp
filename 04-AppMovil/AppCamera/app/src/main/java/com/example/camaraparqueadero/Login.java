package com.example.camaraparqueadero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText campo_nombre_camara;
    private EditText campo_url_servidor;
    private Button btn_crear_camara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campo_nombre_camara = findViewById(R.id.campo_nombre_camara);
        campo_url_servidor = findViewById(R.id.campo_url);
        btn_crear_camara = findViewById(R.id.btn_crear_camara);

        btn_crear_camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre_camara = campo_nombre_camara.getText().toString();
                String url_servidor = campo_url_servidor.getText().toString();
                cambiarActivity(nombre_camara, url_servidor );
            }
        });
        validarSesion();
    }


    public void cambiarActivity(String p_nombre_camara, String p_url_back){
        try {
            SharedPreferences archivo = getSharedPreferences("app_camara", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = archivo.edit();
            editor.putString("nombre_camara", p_nombre_camara);
            editor.putString("url_back", p_url_back);
            editor.apply();

            Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intencion);
            finish();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }

    public void validarSesion() {
        SharedPreferences archivo = getSharedPreferences("app_camara", Context.MODE_PRIVATE);
        String nombre_camara = archivo.getString("nombre_camara", null);
        String url_back = archivo.getString("url_back", null);

        if(nombre_camara != null && url_back != null ){
            Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intencion);
            finish();
        }
    }
}