package com.example.registrosupermercado;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnRegistrarC;
    private TextView nombreProductoC;
    private TextView cantidadProductoC;
    private TextView precioProductoC;
    private Spinner spinTipoProductoC;
    private Button btnAgregarTiposC;
    private TextView listaCantidadProductoC;
    private Button listarConsolaC;
    public static List<Producto> listaproductos = new ArrayList<>();
    public static ArrayList<String> tipos = new ArrayList<>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrarC = findViewById(R.id.btnRegistrarProductoV);
        nombreProductoC = findViewById(R.id.txtNombreProductoV);
        cantidadProductoC = findViewById(R.id.txtCantidadProductosV);
        precioProductoC = findViewById(R.id.txtPrecioProductoV);
        spinTipoProductoC = findViewById(R.id.spinTipoProductosV);
        btnAgregarTiposC = findViewById(R.id.btnAgregarTiposV);
        listaCantidadProductoC = findViewById(R.id.txtListaCantidadProductosV);
        listaCantidadProductoC.setText(String.valueOf(listaproductos.size()));
        listarConsolaC = findViewById(R.id.btnListarConsolaV);


        inicio();

    }

    private void inicio() {

        btnRegistrarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, tipo;
                int cantidad, precio;

                if(!nombreProductoC.getText().toString().equals("") && !cantidadProductoC.getText().toString().equals("0") && !precioProductoC.getText().toString().equals("0") && !spinTipoProductoC.getSelectedItem().toString().equals("")){
                    nombre = nombreProductoC.getText().toString();
                    cantidad = Integer.valueOf(cantidadProductoC.getText().toString());
                    precio = Integer.valueOf(precioProductoC.getText().toString());
                    tipo = spinTipoProductoC.getSelectedItem().toString();
                    Producto p = new Producto(nombre,cantidad,precio,tipo);
                    listaproductos.add(p);
                    listaCantidadProductoC.setText(String.valueOf(listaproductos.size()));
                    vaciarCampos();
                }
            }
        });


        btnAgregarTiposC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombreProductoC.getText().toString().equals("") || cantidadProductoC.getText().toString().equals("0") || precioProductoC.getText().toString().equals("0")){
                    Intent i = new Intent(getApplicationContext(), AgregarTipos.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"borrar datos primero!",Toast.LENGTH_SHORT).show();
                }

            }
        });
        listarConsolaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listaproductos.size() != 0){
                    for(Producto producto : listaproductos){
                        System.out.println(producto);
                    }
                }
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,tipos);
        spinTipoProductoC.setAdapter(adapter);

    }

    private void vaciarCampos(){
        nombreProductoC.setText(null);
        cantidadProductoC.setText(null);
        precioProductoC.setText(null);

    }

}
