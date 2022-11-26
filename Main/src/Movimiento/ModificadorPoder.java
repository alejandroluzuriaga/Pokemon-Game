package Movimiento;
import Pookemon.*;

public class ModificadorPoder extends Movimiento{
    
    public ModificadorPoder (String nombre) {
        switch (nombre){
            case "Poder + 2":
                this.nombre=nombre;
                usos=0;
                usosMaximos=15;
                valor=2;
            break;
            case "Poder - 4":
                this.nombre=nombre;
                usos=0;
                usosMaximos=20;
                valor=-4;
            break;
            case "Poder +8 TAPOTENTE":
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
            if (valor<0){
                receptor.setPoder(receptor.getPoder()+valor);
            } else{
                emisor.setPoder(emisor.getPoder()+valor);
            }
            usos++;
        } 
    }

    @Override
  public String toString(){ //CAMBIAR
    return ("{"+
        " Valor = "+this.valor + " Usos = "+this.usos+" UsosMaximos = "+this.usosMaximos+" Nombre = "+this.nombre+" Tipo ="+this.tipo+" Es Especial = "+this.usoEspecial+ "}");
    }
}