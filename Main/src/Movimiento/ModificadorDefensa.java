package Movimiento;
import Pookemon.*;

public class ModificadorDefensa extends Movimiento {

    public ModificadorDefensa (String nombre) {
        switch (nombre){
            case "Pocion_Defensa": //Sube defensa al emisor
                this.nombre=nombre;
                this.usos=0;
                this.usosMaximos=10;
                this.valor=5;
            break;
            case "Latigo": //Baja defensa del receptor
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
                receptor.setDefensa(receptor.getDefensa()+this.valor);
            } else{
                emisor.setDefensa(emisor.getDefensa()+this.valor);
            }
            usos++;
        }
	}
}