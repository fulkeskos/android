package com.example.manejousuariosimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RegistrarUsuarioActivity extends AppCompatActivity {
    //Declaración
        public static List<Usuario> listaUsuarios = new ArrayList<>();
        private Button btnC_Registrar, btnC_MostrarUsuario, btnC_ListarUsuario, btnC_Volver;
        private EditText txtC_Nombre, txtC_Rut;
        private Switch swtC_Algo;
        private Spinner spnC_Deportes;
        private CheckBox checkC_Casado;
        private RadioButton rbtnC_Hombre, rbtnC_Mujer;
        private TextView lblC_MostrarCantidadRegistros;
    //Declaración

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        //Inicialización
        btnC_Registrar = findViewById(R.id.btnV_RegistrarRegistro);
        btnC_MostrarUsuario = findViewById(R.id.btnV_MostrarUsuRegistro);
        btnC_ListarUsuario = findViewById(R.id.btnV_ListarUsuRegistros);
        btnC_Volver = findViewById(R.id.btnV_VolverDesdeRegistro);

        txtC_Nombre = findViewById(R.id.txtV_nombreRegistro);
        txtC_Rut = findViewById(R.id.txtV_RutRegistro);

        swtC_Algo = findViewById(R.id.swtV_Algo);
        spnC_Deportes = findViewById(R.id.spnV_Derporte);
        checkC_Casado = findViewById(R.id.chekV_Casado);
        rbtnC_Hombre = findViewById(R.id.rbtnV_Hombre);
        rbtnC_Mujer = findViewById(R.id.rbtnV_Mujer);

        lblC_MostrarCantidadRegistros = findViewById(R.id.lblV_CantidadRegistros);
        //Inicialización

        metodoInit();


    }

    private void metodoInit() {
        btnC_Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtC_Nombre.getText().toString().equals("") || txtC_Rut.getText().toString() != ""){

                }


                String nombre, rut, swt, deporte, casado = "NO casado";
                boolean sexo = true;

                nombre = txtC_Nombre.getText().toString();
                rut = txtC_Rut.getText().toString();

                if(swtC_Algo.isChecked()){
                    swt = "Chequeado";
                }else{
                    swt = "NOOOOOOOOO Chequeado";
                }

                deporte = spnC_Deportes.getSelectedItem().toString();

                if(checkC_Casado.isChecked()){
                    casado = "Casado";
                }

                if(rbtnC_Hombre.isChecked()){
                    sexo = true;
                }else if(rbtnC_Mujer.isChecked()){
                    sexo = false;
                }

                System.out.println("Nombre: "+nombre+" Rut: "+rut);
                System.out.println("Switch?:  "+swt);
                System.out.println("Deporte: "+deporte);
                System.out.println("Casado?: "+casado);
                System.out.println("Sexo: "+sexo);

                Usuario u = new Usuario(nombre,rut,swt,deporte,casado,sexo);
                listaUsuarios.add(u);

                lblC_MostrarCantidadRegistros.setText(String.valueOf(listaUsuarios.size()));

            }
        });

        btnC_Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
