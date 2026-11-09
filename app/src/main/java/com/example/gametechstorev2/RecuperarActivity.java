package com.example.gametechstorev2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RecuperarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        // Buscamos el botón de "Enviar Enlace"
        Button btnRecuperar = findViewById(R.id.btnRecuperar);

        // Lógica al darle clic
        btnRecuperar.setOnClickListener(v -> {
            Toast.makeText(this, "Enlace de recuperación enviado al correo", Toast.LENGTH_LONG).show();
            finish(); // Cierra esta pantalla y vuelve al Login
        });
    }
}