package com.example.squlito;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Data extends SQLiteOpenHelper {

    private static String NOMBRE_BD = "BD_SQLit_o_BD";
    private static int VERSION_BD = 1;
    private static final String TABLA_USUARIO = "CREATE TABLE usuario(_id INTEGER PRIMARY KEY AUTOINCREMENT, _nom TEXT, _rut TEXT)";

    public Data( Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("upgrade!!");
    }
    public void insertarUsuario(Usuario u){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd != null){
            bd.execSQL("INSERT INTO usuario VALUES(NULL,"+u.getNombre()+","+u.getRut()+")");
        }
        bd.close();
    }
    public List<Usuario> getUsuarios(){
        List<Usuario> lu = new ArrayList<>();
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cur = bd.rawQuery("select * from usuario;",null);

        if (cur.moveToFirst()){
            do{
                //deberia colocar segun el nombre de la tabla pero por si las dudas;
                int id = cur.getInt(cur.getColumnIndex("_id"));
                String nom = cur.getString(cur.getColumnIndex("_nom"));
                String rut = cur.getString(cur.getColumnIndex("_rut"));

                Usuario usu = new Usuario(id,nom,rut);
                lu.add(usu);
            }while(cur.moveToNext());
        }

        return lu;
    }
}
