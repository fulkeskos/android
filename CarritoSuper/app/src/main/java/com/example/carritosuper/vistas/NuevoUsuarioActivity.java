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
import com.example.carritosuper.model.Usuario;
import com.example.carritosuper.vistas.LoginActivity;

import java.util.concurrent.ExecutionException;

public class NuevoUsuarioActivity extends AppCompatActivity {
    private TextView txtC_CodigoFamiliar_NuevoUsuario;
    private TextView txtC_Nombre_NuevoUsuario;
    private TextView txtC_Apellido_NuevoUsuario;
    private TextView txtC_Passwd_NuevoUsuario;
    private Button btnC_Aceptar_NuevoUsuario;
    private Button btnC_Volver_NuevoUsuario;
    private Button btnC_ValidarCodigoFamiliar_NuevoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);

        txtC_CodigoFamiliar_NuevoUsuario = findViewById(R.id.txtV_CodigoFamiliar_NuevoUsuario);
        txtC_Nombre_NuevoUsuario = findViewById(R.id.txtV_Nombre_NuevoUsuario);
        txtC_Apellido_NuevoUsuario = findViewById(R.id.txtV_Apellido_NuevoUsuario);
        txtC_Passwd_NuevoUsuario = findViewById(R.id.txtV_Passwd_NuevoUsuario);
        btnC_Aceptar_NuevoUsuario = findViewById(R.id.btnV_Aceptar_NuevoUsuario);
        btnC_Volver_NuevoUsuario = findViewById(R.id.btnV_Volver_NuevoUsuario);
        btnC_ValidarCodigoFamiliar_NuevoUsuario = findViewById(R.id.txtV_ValidarCodigoFamiliar_NuevoUsuario);

        inite();
    }
    private void inite(){
        btnC_Aceptar_NuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtC_CodigoFamiliar_NuevoUsuario.getText().toString().equals("") &&
                    !txtC_Nombre_NuevoUsuario.getText().toString().equals("") &&
                    !txtC_Apellido_NuevoUsuario.getText().toString().equals("") &&
                    !txtC_Passwd_NuevoUsuario.getText().toString().equals("")){

                    String nombre = txtC_Nombre_NuevoUsuario.getText().toString();
                    String apellido = txtC_Apellido_NuevoUsuario.getText().toString();
                    String passwd = txtC_Passwd_NuevoUsuario.getText().toString();
                    String codf = txtC_CodigoFamiliar_NuevoUsuario.getText().toString();
                    Usuario u = new Usuario(nombre,apellido,passwd,codf);
                    //envio al server incluir la orden al principio

                    ConexionCliente cl = new ConexionCliente();
                    cl.execute("crearUsuario,"+u);

                    try {
                        String respu = cl.get();
                        System.out.println("respuesta del server"+respu);
                        if(respu.equals("usuarioCreado")){
                            Toast t = Toast.makeText(getApplicationContext(),"Usuario Creado",Toast.LENGTH_SHORT);
                            t.show();
                            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(i);
                            finish();
                        }
                    } catch (ExecutionException e) {
                        System.out.println("error 1"+e);
                    } catch (InterruptedException ex) {
                        System.out.println("error 2"+ex);
                    }

                }
            }
        });
        btnC_ValidarCodigoFamiliar_NuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigoF = txtC_CodigoFamiliar_NuevoUsuario.getText().toString();
                if(!txtC_CodigoFamiliar_NuevoUsuario.getText().toString().equals("")){
                    ConexionCliente cl = new ConexionCliente();
                    cl.execute("comprobarFamilia,"+codigoF);

                    try {
                        String respu = cl.get();
                        System.out.println("respuesta del server:"+respu);
                        if(!respu.equals("0")){
                            txtC_Nombre_NuevoUsuario.setEnabled(true);
                            txtC_Passwd_NuevoUsuario.setEnabled(true);
                            txtC_Apellido_NuevoUsuario.setEnabled(true);
                            btnC_Aceptar_NuevoUsuario.setEnabled(true);
                            Toast t = Toast.makeText(getApplicationContext(),"si existe la familia",Toast.LENGTH_LONG);
                            t.show();
                        }else{
                            Toast t = Toast.makeText(getApplicationContext(),"no existe codigo familiar",Toast.LENGTH_LONG);
                            t.show();
                        }

                    } catch (ExecutionException e) {
                        System.out.println("error1:"+e);
                    } catch (InterruptedException ex1) {
                        System.out.println("error2:"+ex1);
                    }

                }
            }
        });

        btnC_Volver_NuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                finish();

            }
        });
    }
}
