package com.example.carritosuper.controladors;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConexionServidor extends Thread {
    protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private String host;
    private int puerto;


    private String comando;
    public static String resp;

    public ConexionServidor(String comando) {
        this.puerto = 4000;
        this.host = "192.168.18.3";
        this.comando = comando;
    }


    public void run() {
        try {
            //cambiar a datos desde otro lado
            sk = new Socket(this.host,this.puerto);
            dos = new DataOutputStream(sk.getOutputStream());
            dis = new DataInputStream(sk.getInputStream());

            //mover esto
            dos.writeUTF(this.comando);

            String respuesta = "";
            respuesta = dis.readUTF();

            System.out.println("servidor: "+respuesta);

            setResp(respuesta);


            //System.out.println(this.resp);

        } catch (IOException ex) {
            System.out.println("error cliente: " + ex);
        } finally {
            try {
                dis.close();
                dos.close();
                sk.close();
            } catch (IOException ex) {
                System.out.println("error al cerrar: " + ex);
            }

        }
    }

    public static void setResp(String resp) {
        ConexionServidor.resp = resp;
    }

    @Override
    public String toString() {
        return "String del final: "+resp;
    }
}