package com.example.squlito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnC_insertar;
    private Button btnC_Listar;
    private TextView txtC_Mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnC_insertar= findViewById(R.id.btnV_insertar);
        btnC_Listar= findViewById(R.id.btnV_listar);
        txtC_Mostrar= findViewById(R.id.txtV_MostrarTotalRegistros);


        init();
    }

    private void init() {
        btnC_insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data d = new Data(getApplicationContext());
                Usuario u = new Usuario( 1,"uwu","21-1");
                d.insertarUsuario(u);

            }
        });
        btnC_Listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Data d = new Data(getApplicationContext());
               List<Usuario> listaUsu = d.getUsuarios();
               txtC_Mostrar.setText("N°: "+String.valueOf(listaUsu.size()));

               for(Usuario u : listaUsu){
                   System.out.println("==============");
                   System.out.println("ID: "+u.getId());
                   System.out.println("nombre: "+u.getNombre());
                   System.out.println("Rut: "+u.getNombre());
               }
            }
        });
    }


}
