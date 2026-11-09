package com.example.gametechstorev2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class VendedorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor);

        Button btnAgregar = findViewById(R.id.btnAgregarProducto);

        btnAgregar.setOnClickListener(v -> {
            // Saltamos a la nueva pantalla
            Intent intent = new Intent(VendedorActivity.this, CrearProductoActivity.class);
            startActivity(intent);
        });
    }
}