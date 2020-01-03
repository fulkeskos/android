package com.example.carritosuper.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.carritosuper.R;
import com.example.carritosuper.vistas.LoginActivity;
import com.example.carritosuper.vistas.NuevaFamiliaActivity;
import com.example.carritosuper.vistas.NuevoUsuarioActivity;

public class VerficacionFamiliarActivity extends AppCompatActivity {

    private Button nuevoUsuario;
    private Button nuevaFamilia;
    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verficacion_familiar);

        nuevoUsuario = findViewById(R.id.btnV_NuevoUsuario_VerificacionFamilia);
        nuevaFamilia = findViewById(R.id.btnV_CrearFamilia_VerificacionFamilia);
        volver = findViewById(R.id.btnV_Volver_VerificacionFamilia);
        botones();
    }
    private void botones(){
        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NuevoUsuarioActivity.class);
                startActivity(i);
                finish();
            }
        });
        nuevaFamilia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NuevaFamiliaActivity.class);
                startActivity(i);
                finish();
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
