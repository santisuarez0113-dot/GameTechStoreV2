package com.example.gametechstorev2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Button btnCarrito = findViewById(R.id.btnAgregarCarrito);
        btnCarrito.setOnClickListener(v -> {
            // Al agregar, nos vamos al carrito
            Intent intent = new Intent(DetalleActivity.this, CarritoActivity.class);
            startActivity(intent);
            finish();
        });
    }
}