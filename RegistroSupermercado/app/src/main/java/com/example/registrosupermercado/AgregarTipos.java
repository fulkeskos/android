package com.example.registrosupermercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class AgregarTipos extends AppCompatActivity {
    ListView listaTipos;
    private Button btnVolver;
    private TextView txtAgregarTipo;
    private Button btnAgregarTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tipos);
        listaTipos = findViewById(R.id.ListViewTipos);
        btnVolver = findViewById(R.id.btnVolverVTipos);
        txtAgregarTipo = findViewById(R.id.txtNombreTipoNuevoV);
        btnAgregarTipo = findViewById(R.id.btnAgregarTipoV);

        //cambiar la lista de los tipos
        final ArrayAdapter<String> listaAdapterTipos = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MainActivity.tipos);
        listaTipos.setAdapter(listaAdapterTipos);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        btnAgregarTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtAgregarTipo.getText().toString().equals("")){
                    MainActivity.tipos.add(txtAgregarTipo.getText().toString());
                    listaTipos.setAdapter(listaAdapterTipos);
                    txtAgregarTipo.setText(null);

                }else{
                    System.out.println("no ha ingresado nada");
                }
            }
        });

    }
}
