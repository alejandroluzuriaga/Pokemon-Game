package Pookemon;
import java.util.ArrayList;

import Movimiento.*;

public class Charmander extends Pokemon {

    public Charmander(int nivel, String nombre){
       
        this.setNombre(nombre);
        this.setTipo("Fuego");
        this.setNivel(nivel);
        this.setSaludo("¡A quemar la universidad!");       
        this.crearValoresBase();

        Ofensivo ofensivo = new Ofensivo("Barrido");
        ModificadorDefensa modificador_defensa = new ModificadorDefensa("Escudo");
        ModificadorPoder modificador_Poder = new ModificadorPoder("Super Torta");

        ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
        movimientos.add(ofensivo);
        movimientos.add(modificador_defensa);
        movimientos.add(modificador_Poder);
        setMovimientos(movimientos);
    } 
}
