package com.example.carritosuper.controladors;

import android.os.AsyncTask;
//dominio del fulvio
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConexionCliente extends AsyncTask<String,Void,String> {
    private static final int puerto = 4000;
    private static final String host = "192.168.18.3";
    protected DataOutputStream dos;
    protected DataInputStream dis;
    @Override
    protected void onPreExecute(){
        System.out.println("orden enviada del cliente :");
    }
    @Override
    protected String doInBackground(String... comandos) {

        String coma = comandos[0];

        try {
            Socket sk = new Socket(host,puerto);

            //orden al server
            dos = new DataOutputStream(sk.getOutputStream());
            dos.writeUTF(coma);
            System.out.println("Comandos enviados: "+coma);

            dis = new DataInputStream(sk.getInputStream());
            String respuesta = dis.readUTF();
            System.out.println("comandos recibidos del server: "+respuesta);
            sk.close();
            return respuesta;
        } catch (IOException e) {
            System.out.println("error "+e);
        }
        return "nada de nada prro";
    }


}
