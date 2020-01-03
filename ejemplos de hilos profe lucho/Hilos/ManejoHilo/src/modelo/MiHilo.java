package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis_
 */

// crear una clase normal que se llame MiHilo [O el nombre que quieran]
public class MiHilo implements Runnable{ //Implementar de la interface Runnable

    @Override
    public void run() {//Este metodo lo pide de forma automática al momento de impementar de Runnable
        int cont = 0;//variable INT con nombre cont (contador) iniciado en 0
        while (true) {//Ciclo infinito
            System.out.println("Nombre N° ["+cont+"]");//Imprimo el contador
            cont++;
            try {
                Thread.sleep(1000);//Este metodo sirve para dormir el hilo en ejecucion 
                // El tiempo se debe poner en milisegundos
            } catch (InterruptedException ex) {//Catch necesario al momento de llamar a Thread.sleep(1000);
                Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
