package Movimiento;
import Pookemon.*;

public class ModificadorDefensa extends Movimiento {

    public ModificadorDefensa (String nombre) {
        switch (nombre){
            case "Escudo": //Sube defensa al emisor 
                this.nombre=nombre;
                this.usos=0;
                this.usosMaximos=10;
                this.valor=5;
            break;
            case "Envenenamiento": //Baja defensa del receptor
                this.nombre=nombre;
                this.usos=0;
                this.usosMaximos=15;
                this.valor=-5;
            break;
        }
    }

	@Override
	public void activar(Pokemon emisor, Pokemon receptor) {
		if (this.usos<this.usosMaximos){
            if (this.valor<0){
                System.out.print("DEFENSA " + receptor.getNombre() + " = " + receptor.getDefensa());
                receptor.setDefensa(receptor.getDefensa() + this.valor);
                System.out.println(" --> " + receptor.getDefensa());
            } else{
                System.out.print("DEFENSA " + emisor.getNombre() + " = " + emisor.getDefensa());
                emisor.setDefensa(emisor.getDefensa() + this.valor);
                System.out.println(" --> " + emisor.getDefensa());
            }
            usos++;
        }
	}
}