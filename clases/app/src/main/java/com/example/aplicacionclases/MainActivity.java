package com.example.aplicacionclases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnC_regitroUsuarios;
    private Button btnC_MostrarUsuario;
    private Button btnC_ListaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnC_ListaUsuarios = findViewById(R.id.btnVListarUsuario);
        btnC_regitroUsuarios = findViewById(R.id.btnVRegistro);
        btnC_MostrarUsuario = findViewById(R.id.btnVMostrarUsuario);

        init();


    }
    private void init(){
        btnC_regitroUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),RegistrarUsuario.class);
                startActivity(i);
                finish();
            }
        });
        btnC_ListaUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ListaActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

}
