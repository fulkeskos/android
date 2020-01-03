package com.example.carritosuper.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.carritosuper.R;
import com.example.carritosuper.controladors.ConexionCliente;
import com.example.carritosuper.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {
    //me valio verga creo
    public static List<Usuario> listaUsuarios = new ArrayList<>();
    private TextView txtC_Usuario;
    private TextView txtC_Passwd;
    private Button btnC_IniciarSesion;
    private TextView txtC_UsuarioNuevo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtC_Usuario = findViewById(R.id.txtV_Usuario);
        txtC_Passwd = findViewById(R.id.txtV_passwd);
        btnC_IniciarSesion = findViewById(R.id.btnV_IniciarSesion);
        txtC_UsuarioNuevo = findViewById(R.id.txtV_UsuarioNuevo);

        //cambiar
        inicio();

    }

    private void inicio() {
        btnC_IniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = txtC_Usuario.getText().toString();
                String passwd = txtC_Passwd.getText().toString();
            if(!usuario.equals("")&& !passwd.equals("")) {

                ConexionCliente cl = new ConexionCliente();
                cl.execute("login," + usuario+";"+passwd);
                try {
                    String respu = cl.get();
                    System.out.println("respues del server login acti:" + respu);
                    if(!respu.equals("")){

                        Usuario u = new Usuario();
                        String[] cadenita = u.splitUsuario(respu);
                        u.setNombre(cadenita[0]);
                        u.setApellido(cadenita[1]);
                        u.setPasswd(cadenita[2]);
                        u.setCodF(cadenita[3]);

                        listaUsuarios.add(u);
                        Intent i = new Intent(getApplicationContext(), MenuCarroActivity.class);
                        startActivity(i);


                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        });
        txtC_UsuarioNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), VerficacionFamiliarActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    //clase para el server mover a otro archivo despues

}
