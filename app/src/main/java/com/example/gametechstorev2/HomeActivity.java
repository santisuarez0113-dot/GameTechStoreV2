package com.example.gametechstorev2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 1. Enlazamos los elementos visuales
        TextView saludo = findViewById(R.id.saludoGamer);
        EditText buscador = findViewById(R.id.buscador);
        TextView tituloDestacados = findViewById(R.id.tituloDestacados);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);

        // 2. Navegación por clics en los textos
        saludo.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, PerfilActivity.class);
            startActivity(intent);
        });

        buscador.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CarritoActivity.class);
            startActivity(intent);
        });

        tituloDestacados.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CarritoActivity.class);
            startActivity(intent);
        });

        // 3. Navegación con la Barra Inferior (Bottom Navigation)
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_carrito) {
                Intent intent = new Intent(HomeActivity.this, CarritoActivity.class);
                startActivity(intent);
                return true;
            } else if (id == R.id.nav_perfil) {
                Intent intent = new Intent(HomeActivity.this, PerfilActivity.class);
                startActivity(intent);
                return true;
            }

            // Si tocan "Inicio", no hacemos nada porque ya estamos en el Home
            return id == R.id.nav_inicio;
        });
    }
}