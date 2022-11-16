public abstract class Movimiento {
    protected int valor, usos, usosMaximos;
    protected String nombre, tipo;
    protected boolean usoEspecial;
    

public abstract void activar(Pookemon pok1, Pookemon pok2);
}