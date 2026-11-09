package com.example.gametechstorev2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // Buscamos el botón de cerrar sesión en el XML
        Button btnCerrar = findViewById(R.id.btnCerrarSesion);

        // Lógica del botón
        btnCerrar.setOnClickListener(v -> {
            // Volvemos al Login
            Intent intent = new Intent(PerfilActivity.this, LoginActivity.class);

            // ESTA ES LA LÍNEA MÁGICA: Limpia la memoria de navegación
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
            finish(); // Cerramos el perfil
        });
    }
}