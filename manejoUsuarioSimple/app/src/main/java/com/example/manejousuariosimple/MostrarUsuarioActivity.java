package com.example.manejousuariosimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarUsuarioActivity extends AppCompatActivity {
    private Button btnC_Anterior, btnC_Siguiente;
    private TextView lblC_Anterior, lblC_Actual, lblC_Siguiente;
    private int usuActual = 0;
    private Usuario uu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuario);

        btnC_Anterior = findViewById(R.id.btnV_Anterior);
        btnC_Siguiente = findViewById(R.id.btnV_Siguiente);

        lblC_Anterior = findViewById(R.id.lblV_MostrarInicial);
        lblC_Actual = findViewById(R.id.lblV_MostrarActual);
        lblC_Siguiente = findViewById(R.id.lblV_MostrarSiguiente);

        if(!RegistrarUsuarioActivity.listaUsuarios.isEmpty()){
            lblC_Siguiente.setText(String.valueOf(RegistrarUsuarioActivity.listaUsuarios.size()));
            lblC_Anterior.setText("1");
            lblC_Actual.setText("1");
            uu = RegistrarUsuarioActivity.listaUsuarios.get(usuActual);
            metodoMostrarUsuarios(uu);
        }



        btnC_Anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuActual > 0){
                    usuActual--;
                    lblC_Actual.setText(String.valueOf(usuActual+1));
                    uu = RegistrarUsuarioActivity.listaUsuarios.get(usuActual);
                    metodoMostrarUsuarios(uu);
                }
            }
        });

        btnC_Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuActual < RegistrarUsuarioActivity.listaUsuarios.size()-1){
                    usuActual++;
                    lblC_Actual.setText(String.valueOf(usuActual+1));
                    uu = RegistrarUsuarioActivity.listaUsuarios.get(usuActual);
                    metodoMostrarUsuarios(uu);
                }
            }
        });

    }

    private void metodoMostrarUsuarios(Usuario uu) {
        System.out.println("Nom: "+uu.getNombre());
        System.out.println("Switch?:  "+uu.getSwt());
        System.out.println("Deporte: "+uu.getDeporte());
        System.out.println("Casado?: "+uu.getCasado());
        System.out.println("Sexo: "+uu.isSexo());
    }
}
