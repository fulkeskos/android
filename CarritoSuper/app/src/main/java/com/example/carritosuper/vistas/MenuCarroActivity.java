package com.example.carritosuper.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carritosuper.R;
import com.example.carritosuper.controladors.ConexionCliente;
import com.example.carritosuper.model.Carrito;
import com.example.carritosuper.model.ObjetoCarro;
import com.example.carritosuper.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MenuCarroActivity extends AppCompatActivity {
    private TextView txtC_nombreUsuario_menuCarro;
    private Spinner spinC_listaCarros_menuCarro;
    private ListView listC_listaObjetos_menuCarro;
    private Button btnC_nuevoCarro_menuCarro;
    private Button btnC_borrarCarro_menuCarro;
    private Button btnC_cerrarSesion_menuCarro;
    public static boolean estate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_carro);
        txtC_nombreUsuario_menuCarro = findViewById(R.id.txtV_nombreUsuario_menuCarro);
        spinC_listaCarros_menuCarro = findViewById(R.id.spinV_listaCarros_menuCarro);
        listC_listaObjetos_menuCarro = findViewById(R.id.listV_listaObjetos_MenuCarro);
        btnC_nuevoCarro_menuCarro = findViewById(R.id.btnV_agregarCarro_menuCarro);
        btnC_borrarCarro_menuCarro = findViewById(R.id.btnV_borrarCarro_menuCarro);
        btnC_cerrarSesion_menuCarro = findViewById(R.id.btnV_CerrarSesion_menuCarro);

        init();


    }

    public void init() {
        String nombreUsuarios = LoginActivity.listaUsuarios.get(0).toString();
        Usuario u = new Usuario();
        String[] textoNom = u.splitUsuario(nombreUsuarios);
        txtC_nombreUsuario_menuCarro.setText(textoNom[0]);

        List<String> lista = new ArrayList<>();
        Carrito car = new Carrito();


        ConexionCliente cl = new ConexionCliente();
        cl.execute("getCarro," + textoNom[3]);

        try {
            String respuestaCarro = cl.get();
            List li = car.splitNombreCarro(respuestaCarro);
            lista = li;
            System.out.println("asdasdasda..................................."+lista);
            estate = true;
        } catch (ExecutionException e) {
            System.out.println("error 1" + e);
        } catch (InterruptedException ex) {
            System.out.println("error2 " + ex);
        }

        ArrayAdapter<String> listaDeCarroAdap = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, lista);
        spinC_listaCarros_menuCarro.setAdapter(listaDeCarroAdap);
        //listC_listaObjetos_menuCarro.setAdapter(listaDeCarroAdap);


        spinC_listaCarros_menuCarro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(!estate){
                    estate = true;
                    return;
                }
                ObjetoCarro obc = new ObjetoCarro();
                List<String> listaObjetos = new ArrayList<>();

                String nomCarro = spinC_listaCarros_menuCarro.getSelectedItem().toString();
                ConexionCliente cli = new ConexionCliente();
                cli.execute("getObjCarro,"+nomCarro);
                try {
                    String respu = cli.get();
                    List lo = obc.splitNombreObjeto(respu);
                    listaObjetos = lo;

                    ArrayAdapter<String> listaObjetosAdap = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, listaObjetos);
                    listC_listaObjetos_menuCarro.setAdapter(listaObjetosAdap);

                } catch (ExecutionException e) {
                    System.out.println("error"+e);
                } catch (InterruptedException e) {
                    System.out.println("error"+e);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                System.out.println("nada de nada");
            }
        });

        btnC_borrarCarro_menuCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String carro = spinC_listaCarros_menuCarro.getSelectedItem().toString();
                ConexionCliente cl = new ConexionCliente();
                cl.execute("borrarCarro,"+carro);

                try {
                    String respu = cl.get();
                    System.out.println("respuesta server "+respu);
                    if(!respu.equals("")){
                        Toast t = Toast.makeText(getApplicationContext(),"carro borrado: "+carro,Toast.LENGTH_SHORT);
                        t.show();
                        init();
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        btnC_cerrarSesion_menuCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mejorar con una ventana de confirmacion
                LoginActivity.listaUsuarios.clear();
                estate = false;
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnC_nuevoCarro_menuCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),NuevoCarroActivity.class);
                startActivity(i);
                finish();
            }
        });
    }



}
