package com.example.manejousuariosimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Declaración
    private Button btnC_Registrar, btnC_Mostrar, btnC_Listar;
    //Declaración

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicialización
        btnC_Registrar = findViewById(R.id.btnV_Registrar);
        btnC_Mostrar = findViewById(R.id.btnV_MostrarUsuario);
        btnC_Listar = findViewById(R.id.btnV_ListarUsuarios);
        //Inicialización

        metodoInit();
    }

    private void metodoInit() {
        btnC_Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegistrarUsuarioActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnC_Mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MostrarUsuarioActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnC_Listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListarUsuarioActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
