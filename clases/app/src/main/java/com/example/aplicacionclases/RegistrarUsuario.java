package com.example.aplicacionclases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RegistrarUsuario extends AppCompatActivity {
    private Button btnC_RegistroVolver;
    private Button btnC_RegistroRegistrar;
    private EditText txtR_Nombre;
    private EditText txtR_Apellido;
    private EditText txtR_Rut;
    private EditText txtR_Edad;
    private RadioGroup rgR_genero;
    private RadioButton rdbtnR_genero;
    private Spinner spR_deporteFav;
    private TextView lblRegistrarPersonas;
    public static List<Persona> listaUsuarios = new ArrayList<>();
    Persona p = new Persona();
    private Button btnValidadorRut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        btnC_RegistroVolver = findViewById(R.id.btnRegistroVolver);
        btnC_RegistroRegistrar = findViewById(R.id.btnRegistroRegistrar);
        txtR_Nombre = findViewById(R.id.txtRegistroNombre);
        txtR_Apellido = findViewById(R.id.txtRegistroApellido);
        txtR_Edad = findViewById(R.id.txtRegistroEdad);
        txtR_Rut = findViewById(R.id.txtRegistroRut);
        rgR_genero = findViewById(R.id.rgRegistroGenero);
        spR_deporteFav = findViewById(R.id.spRegistroDeporte);
        lblRegistrarPersonas = findViewById(R.id.txtRegistroCantidadPersonas);
        lblRegistrarPersonas.setText(String.valueOf(listaUsuarios.size()));
        btnValidadorRut = findViewById(R.id.btnRutConfirmador);
        //notFocus();
        init();

    }

    private void init() {

        btnC_RegistroVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
                //swR_genero.isChecked();
            }
        });

        btnC_RegistroRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtR_Nombre.getText().toString().equals("") ||
                        !txtR_Apellido.getText().toString().equals("") ||
                        !txtR_Edad.getText().toString().equals("")) {

                    Persona p = new Persona();

                    p.setNombre(txtR_Nombre.getText().toString());
                    p.setApellido(txtR_Apellido.getText().toString());
                    p.setRut(txtR_Rut.getText().toString());
                    p.setEdad(Integer.parseInt(txtR_Edad.getText().toString()));
                    p.setDeporteFavorito(spR_deporteFav.getSelectedItem().toString());
                    int selectedId = rgR_genero.getCheckedRadioButtonId();
                    rdbtnR_genero = findViewById(selectedId);
                    p.setGenero(rdbtnR_genero.getText().toString());
                    System.out.println(p);


                    //depuracion piolichi
                    listaUsuarios.add(p);
                    vaciarCampos();

                }
                System.out.println("no ha ingresado datos");
                lblRegistrarPersonas.setText(String.valueOf(listaUsuarios.size()));

            }

        });
        btnValidadorRut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rut = txtR_Rut.getText().toString();
                if (!txtR_Rut.getText().toString().equals("") || listaUsuarios.size() != 0) {

                   for (Persona persona : listaUsuarios){

                       if (persona.getRut().equals(rut)){
                           System.out.println("existe " + rut);
                           txtR_Nombre.setText(persona.getNombre());
                           txtR_Apellido.setText(persona.getApellido());
                           txtR_Edad.setText(String.valueOf(persona.getEdad()));
                           Focus(false);
                       }
                       if(!persona.getRut().equals(rut)){
                           System.out.println("no existe");
                           Focus(true);
                       }
                   }

                }
            }
        });


    }

    private void vaciarCampos() {
        txtR_Nombre.setText(null);
        txtR_Apellido.setText(null);
        txtR_Rut.setText(null);
        txtR_Edad.setText(null);
        rdbtnR_genero.setChecked(false);
    }

    private void Focus(boolean vali) {
        txtR_Edad.setEnabled(vali);
        txtR_Apellido.setEnabled(vali);
        txtR_Nombre.setEnabled(vali);
        spR_deporteFav.setEnabled(vali);
    }
}
