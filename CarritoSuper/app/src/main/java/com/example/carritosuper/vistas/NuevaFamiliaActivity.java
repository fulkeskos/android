package com.example.carritosuper.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carritosuper.R;
import com.example.carritosuper.controladors.ConexionCliente;
import com.example.carritosuper.model.Familia;
import com.example.carritosuper.vistas.LoginActivity;

import java.util.concurrent.ExecutionException;

public class NuevaFamiliaActivity extends AppCompatActivity {
    private TextView txtC_codigoFamilia;

    private TextView txtC_nuevoCodigoFamilia;
    private TextView txtC_nombreFamilia;
    private Button btnC_crearNuevaFamilia;
    private Button btnC_volverNuevaFamilia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_familia);

        txtC_codigoFamilia = findViewById(R.id.txtV_CodigoFamiliar_nuevaFamilia);
        txtC_nuevoCodigoFamilia = findViewById(R.id.txtV_CrearCodigo_nuevaFamilia);
        txtC_nombreFamilia = findViewById(R.id.txtV_NombreFamilia_nuevaFamilia);
        btnC_crearNuevaFamilia = findViewById(R.id.btnV_CrearFamilia_nuevaFamilia);
        btnC_volverNuevaFamilia = findViewById(R.id.btnV_Volver_nuevaFamilia);

        inite();
    }
    public void inite(){

        txtC_nuevoCodigoFamilia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Familia f = new Familia();
                String code = f.generarCodigo();
                txtC_codigoFamilia.setText(code);
            }
        });

        //incluir la una verificacion de grupo familiar ya existente yo creo que en el boton de creacion
        btnC_crearNuevaFamilia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigoF = txtC_codigoFamilia.getText().toString();
                if(!txtC_codigoFamilia.getText().toString().equals("") &&
                        !txtC_nombreFamilia.getText().toString().equals("")){
                    ConexionCliente cl = new ConexionCliente();
                    cl.execute("comprobarFamilia,"+codigoF);

                    try {
                        String respu = cl.get();
                        System.out.println("respuesta del server"+respu);
                        if(respu.equals("0")){
                            ConexionCliente clo = new ConexionCliente();
                            Familia f = new Familia();
                            f.setCodigo(txtC_codigoFamilia.getText().toString());
                            f.setNombre(txtC_nombreFamilia.getText().toString());
                            clo.execute("crearFamilia,"+f);
                            Toast t = Toast.makeText(getApplicationContext(),"Grupo Familiar Creado",Toast.LENGTH_SHORT);
                            t.show();
                            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(i);
                            finish();
                        }
                    } catch (ExecutionException e) {
                        System.out.println("error"+e);
                    } catch (InterruptedException e) {
                        System.out.println("error2"+e);
                    }

                    //enviar consulta al server y esperar la respuesta para la creacion.
                    //recordar enviar la orden al server
                    // luego mandar toast al respecto.

                    //mandar al servidor pero eso ver despues.
                }
            }
        });

        btnC_volverNuevaFamilia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
