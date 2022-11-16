public class ModificadorDefensa extends Movimiento {

    public ModificadorDefensa (String nombre) {
        switch (nombre){
            case "aumentoEmisor":
                this.nombre=nombre;
                this.usos=0;
                this.usosMaximos=10;
                this.valor=5;
            break;
            case "decrementoReceptor":
                this.nombre=nombre;
                this.usos=0;
                this.usosMaximos=15;
                this.valor=-5;
            break;
        }
    }

	@Override
	public void activar(Pookemon emisor, Pookemon receptor) {
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