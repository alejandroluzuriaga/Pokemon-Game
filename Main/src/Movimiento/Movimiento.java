package Movimiento;
import Pookemon.*;

public abstract class Movimiento {
    protected int valor, usos, usosMaximos;
    protected String nombre, tipo;
    protected boolean usoEspecial;
    
    public String getNombre() {
        return nombre;
    }

    public abstract void activar(Pokemon pok1, Pokemon pok2);
    public abstract String toString();

}