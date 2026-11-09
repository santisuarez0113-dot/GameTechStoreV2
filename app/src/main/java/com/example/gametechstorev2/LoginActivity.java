package com.example.gametechstorev2;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView tvErrorCorreo, tvErrorPassword;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 1. Enlace de todos los elementos del XML
        EditText etCorreo = findViewById(R.id.etCorreo);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnHuella = findViewById(R.id.btnHuella);
        TextView tvOlvide = findViewById(R.id.tvOlvidePassword);

        tvErrorCorreo = findViewById(R.id.tvErrorCorreo);
        tvErrorPassword = findViewById(R.id.tvErrorPassword);

        // Inicializacion el vibrador
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        // 2. Lógica del botón Ingresar
        btnLogin.setOnClickListener(v -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }

            String correo = etCorreo.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();

            // se ocultan ambos mensajes antes de validar
            tvErrorCorreo.setVisibility(View.INVISIBLE);
            tvErrorPassword.setVisibility(View.INVISIBLE);

            boolean hayError = false;

            // Validacion del Correo
            if (correo.isEmpty()) {
                mostrarErrorCorreo("¡El correo es obligatorio!");
                hayError = true;
            } else if (!correo.contains("@") || !correo.contains(".")) {
                mostrarErrorCorreo("¡Correo inválido! Falta @ o punto (.)");
                hayError = true;
            }

            // Validacion de Contraseña
            if (pass.isEmpty()) {
                mostrarErrorPassword("¡La contraseña es obligatoria!");
                hayError = true;
            } else if (pass.length() < 4) {
                mostrarErrorPassword("¡La contraseña debe tener al menos 4 caracteres!");
                hayError = true;
            }

            // si se detecta un error se detiene la ejecucion
            if (hayError) {
                return;
            }

            // --- LÓGICA DE ROLES (Simulada) ---
            Intent intent;

            if (correo.equalsIgnoreCase("admin@gmail.com") && pass.equals("1234")) {
                // Es el Administrador
                intent = new Intent(LoginActivity.this, AdminActivity.class);
                startActivity(intent);
                finish();
            }
            else if (correo.equalsIgnoreCase("vendedor@gmail.com") && pass.equals("1234")) {
                //  el Vendedor
                intent = new Intent(LoginActivity.this, VendedorActivity.class);
                startActivity(intent);
                finish();
            }
            else if (correo.equalsIgnoreCase("david@gmail.com") && pass.equals("1234")) {
                //  el Comprador
                intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                // Si el correo no está registrado o la contraseña no es 1234
                mostrarErrorCorreo("Usuario no registrado o contraseña incorrecta");
            }
        });

        // 3. Lógica del botón Huella (Entra como Comprador por defecto)
        btnHuella.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        // 4. Lógica del texto como "¿Olvidaste tu contraseña?"
        tvOlvide.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RecuperarActivity.class);
            startActivity(intent);
        });
    }

    // Funciones para mostrar errores con animación y vibración
    private void mostrarErrorCorreo(String mensaje) {
        tvErrorCorreo.setText(mensaje);
        tvErrorCorreo.setVisibility(View.VISIBLE);
        animarYVibrar(tvErrorCorreo);
    }

    private void mostrarErrorPassword(String mensaje) {
        tvErrorPassword.setText(mensaje);
        tvErrorPassword.setVisibility(View.VISIBLE);
        animarYVibrar(tvErrorPassword);
    }

    private void animarYVibrar(View vista) {
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        vista.startAnimation(animacion);

        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(400, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(400);
            }
        }
    }
}