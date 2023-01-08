package Pookemon;
import java.util.ArrayList;

import Movimiento.*;

public class Bulbasur extends Pokemon {
    
    public Bulbasur(int nivel, String nombre){
       
        this.setNombre(nombre);
        this.setTipo("Planta");
        this.setNivel(nivel);
        this.setSaludo("¿Quieres un briconsejo de jardinería?");
        this.crearValoresBase();

        Ofensivo ofensivo = new Ofensivo("lanzasemen");
        ModificadorDefensa modificador_defensa = new ModificadorDefensa("Latigoa");
        ModificadorPoder modificador_Poder = new ModificadorPoder("Poder - 4");

        ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
        movimientos.add(ofensivo);
        movimientos.add(modificador_defensa);
        movimientos.add(modificador_Poder);
        setMovimientos(movimientos);
    }
}
