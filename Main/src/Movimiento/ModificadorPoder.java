package Movimiento;
import Pookemon.*;

public class ModificadorPoder extends Movimiento{
    
    public ModificadorPoder (String nombre) {
        switch (nombre){
            case "Aliento Acido": 
                this.nombre=nombre;
                usos=0;
                usosMaximos=15;
                valor=2;
            break;
            case "Grito Sonico":
                this.nombre=nombre;
                usos=0;
                usosMaximos=20;
                valor=-4;
            break;
            case "Super Torta":
                this.nombre=nombre;
                usos=0;
                usosMaximos=20;
                valor=8;
            break;
        }
    }

    @Override
    public void activar(Pokemon emisor, Pokemon receptor){
        if (usos<usosMaximos){
            System.out.println();
            
            if (valor<0){
                System.out.print("PODER " + receptor.getNombre() + " = " + receptor.getPoder());
                receptor.setPoder(receptor.getPoder() + valor);
                System.out.println(" --> " + receptor.getPoder());
            } else{
                System.out.print("PODER " + emisor.getNombre() + " = " + emisor.getPoder());
                emisor.setPoder(emisor.getPoder() + valor);
                System.out.println(" --> " + emisor.getPoder());
            }
            usos++;
        } 
    }

}