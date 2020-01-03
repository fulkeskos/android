package com.example.aplicacionclases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListaActivity extends AppCompatActivity {
    ListView listaPersonas;
    private Button btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listaPersonas = findViewById(R.id.ListViewVlista);
        btnvolver = findViewById(R.id.btnVolverVListar);

        ArrayAdapter<Persona> listaAdapterPersonas = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,RegistrarUsuario.listaUsuarios);
        listaPersonas.setAdapter(listaAdapterPersonas);
        //pensaba en un metodo init pero si es un solo boton bue

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}
