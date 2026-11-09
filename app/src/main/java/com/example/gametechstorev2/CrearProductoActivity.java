package com.example.gametechstorev2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CrearProductoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);

        // Buscamos el botón de guardar
        Button btnGuardar = findViewById(R.id.btnGuardarProd);

        // Lógica al darle clic
        btnGuardar.setOnClickListener(v -> {
            // Mostramos el mensaje de éxito
            Toast.makeText(this, "¡Producto guardado exitosamente!", Toast.LENGTH_SHORT).show();

            // TRUCO DE PRUEBA: Saltamos al panel del administrador
            Intent intent = new Intent(CrearProductoActivity.this, AdminActivity.class);
            startActivity(intent);
            finish(); // Cerramos el formulario
        });
    }
}