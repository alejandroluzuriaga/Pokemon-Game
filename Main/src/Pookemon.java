public class Pookemon {
    private String nombre, tipo;
    private int velocidad, saludMax, saludActual, poder, poderEspecial, defensa, defensaEspecial, nivel;
    private Movimiento movimientos[];

    public String getNombre() {
        return nombre;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }
    public int getSaludMax() {
        return saludMax;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDefensa() {
        return defensa;
    }
    
    public int getSaludActual() {
        return saludActual;
    }

    public void setSaludActual(int saludActual) {
        this.saludActual = saludActual;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public void setPoderEspecial(int poderEspecial) {
        this.poderEspecial = poderEspecial;
    }

    public int getPoder() {
        return poder;
    }
    public int getPoderEspecial() {
        return poderEspecial;
    }
    
    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public int getNivel() {
        return nivel;
    }
    public int getVelocidad() {
        return velocidad;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
}