package com.example.gametechstorev2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button btnUsuarios = findViewById(R.id.btnGestionUsuarios);
        Button btnProductos = findViewById(R.id.btnGestionProductos);
        Button btnCerrar = findViewById(R.id.btnCerrarSesionAdmin);

        // Este botón nos lleva a la nueva pantalla de Gestión de Usuarios
        btnUsuarios.setOnClickListener(v -> {
            Intent intent = new Intent(AdminActivity.this, GestionUsuariosActivity.class);
            startActivity(intent);
        });

        btnProductos.setOnClickListener(v -> {
            Toast.makeText(this, "Listado global de productos...", Toast.LENGTH_SHORT).show();
        });

        btnCerrar.setOnClickListener(v -> {
            Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}