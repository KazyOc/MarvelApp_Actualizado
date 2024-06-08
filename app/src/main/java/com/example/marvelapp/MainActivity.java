package com.example.marvelapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn_cerrar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_cerrar = findViewById(R.id.btn_cerrar);

        sharedPreferences = getSharedPreferences(Login.dataUser, Login.modo_private);
        editor= sharedPreferences.edit();
        btn_cerrar.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                editor.remove("usuario");
                editor.apply();
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}