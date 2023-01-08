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

        Ofensivo ofensivo = new Ofensivo("Viento");
        ModificadorDefensa modificador_defensa = new ModificadorDefensa("Envenenamiento");
        ModificadorPoder modificador_Poder = new ModificadorPoder("Grito Sonico");

        ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
        movimientos.add(ofensivo);
        movimientos.add(modificador_defensa);
        movimientos.add(modificador_Poder);
        setMovimientos(movimientos);
    }
}
