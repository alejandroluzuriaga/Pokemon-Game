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
    
    public String toString() {
        return "Nombre = " + this.nombre + 
        "\n Valor = " + this.valor + 
        "\n Usos = " + this.usos + 
        "\n UsosMaximos = " + this.usosMaximos + 
        "\n Tipo =" + this.tipo + 
        "\n Es Especial = " + this.usoEspecial;
    };

}