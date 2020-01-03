package com.example.carritosuper.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carritosuper.R;
import com.example.carritosuper.controladors.ConexionCliente;
import com.example.carritosuper.model.ObjetoCarro;
import com.example.carritosuper.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class NuevoCarroActivity extends AppCompatActivity {
    private TextView txtC_nombreObjeto_nuevoCarro;
    private Button btnC_agregarObjeto_nuevoCarro;
    private ListView listV_objetosListas_nuevoCarro;
    private Button btnC_volver_nuevoCarro;
    private Button btnC_crearCarro_nuevoCarro;
    private TextView txtC_nomNuevoCarro_nuevoCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_carro);
        txtC_nombreObjeto_nuevoCarro = findViewById(R.id.txtV_nombreObjeto_nuevoCarro);
        btnC_agregarObjeto_nuevoCarro = findViewById(R.id.btnV_agregarObjeto_nuevoCarro);
        listV_objetosListas_nuevoCarro = findViewById(R.id.listV_listaObjetos_nuevoCarro);
        btnC_volver_nuevoCarro = findViewById(R.id.btnV_volver_nuevoCarro);
        btnC_crearCarro_nuevoCarro = findViewById(R.id.btnV_crearNuevoCarro_nuevoCarro);
        txtC_nomNuevoCarro_nuevoCarro = findViewById(R.id.txtV_nombreNuevoCarro_nuevoCarro);

        inite();

    }

    public void inite() {
        btnC_volver_nuevoCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuCarroActivity.class);
                MenuCarroActivity.estate = true;
                startActivity(i);
                finish();
            }
        });
        btnC_crearCarro_nuevoCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("nose que pasa aca");
                String nombreCarro = txtC_nomNuevoCarro_nuevoCarro.getText().toString();
                System.out.println("depuracion nombre carro: " + nombreCarro);
                if (!nombreCarro.equals("")) {
                    ConexionCliente cl = new ConexionCliente();
                    cl.execute("comprobarNombreCarro," + nombreCarro);

                    try {
                        String respus = cl.get();


                        if (respus.equals("0")) {

                            ConexionCliente clo = new ConexionCliente();
                            String nombreUsuarios = LoginActivity.listaUsuarios.get(0).toString();
                            Usuario u = new Usuario();
                            String[] textoNom = u.splitUsuario(nombreUsuarios);

                            clo.execute("crearCarro," + nombreCarro + ";" + textoNom[3] + ";" + "1");
                            txtC_nombreObjeto_nuevoCarro.setEnabled(true);
                            btnC_agregarObjeto_nuevoCarro.setEnabled(true);
                            txtC_nomNuevoCarro_nuevoCarro.setEnabled(false);
                        }

                    } catch (ExecutionException e) {
                        System.out.println("error" + e);
                    } catch (InterruptedException ex) {
                        System.out.println("error" + ex);
                    }
                }
            }
        });
        btnC_agregarObjeto_nuevoCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreObjeto = txtC_nombreObjeto_nuevoCarro.getText().toString();
                String nombreCarro = txtC_nomNuevoCarro_nuevoCarro.getText().toString();
                ConexionCliente cl = new ConexionCliente();
                System.out.println("agregarObjCarro," + nombreObjeto + ";" + nombreCarro);
                cl.execute("agregarObjCarro,"+nombreObjeto+";"+nombreCarro+"");

                try {
                    String respu = cl.get();
                    if (!respu.equals("")) {
                        Toast t = Toast.makeText(getApplicationContext(), "Objeto Agregado", Toast.LENGTH_SHORT);
                        t.show();
                        inite();
                        listas(nombreCarro);

                        txtC_nombreObjeto_nuevoCarro.setText("");
                    }
                } catch (ExecutionException e) {
                    System.out.println("error" + e);
                } catch (InterruptedException e) {
                    System.out.println("error" + e);
                }

            }
        });

    }

    private void listas(String nomCarro) {
        ObjetoCarro obc = new ObjetoCarro();
        List<String> listaObjetos = new ArrayList<>();

//        String nombre = spinC_listaCarros_menuCarro.getSelectedItem().toString();
        ConexionCliente cli = new ConexionCliente();
        cli.execute("getObjCarro,"+nomCarro);
        try {
            String respu = cli.get();
            List lo = obc.splitNombreObjeto(respu);
            listaObjetos = lo;

            ArrayAdapter<String> listaObjetosAdap = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, listaObjetos);
            listV_objetosListas_nuevoCarro.setAdapter(listaObjetosAdap);

        } catch (ExecutionException e) {
            System.out.println("error"+e);
        } catch (InterruptedException e) {
            System.out.println("error"+e);
        }
    }

    public void refreshListView() {
        ArrayAdapter<String> listAdapter;
        // listAdapter = new ListAdapter(getApplicationContext());
        //setListAdapter(listAdapter); }
    }
}