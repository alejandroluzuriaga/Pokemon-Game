package Pookemon;
import java.util.ArrayList;

import Movimiento.*;
public class Rattata extends Pokemon {
    
    public Rattata(int nivel, String nombre){
        this.setNombre(nombre);
        this.setTipo("Normal");
        this.setNivel(nivel);
        this.setSaludo("Mi bro de alcantarilla es el payaso de IT");
        this.crearValoresBase();

        Ofensivo ofensivo = new Ofensivo("Zumbido");
        ModificadorDefensa modificador_defensa = new ModificadorDefensa("Envenenamiento");
        ModificadorPoder modificador_Poder = new ModificadorPoder("Aliento Acido");

        ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
        movimientos.add(ofensivo);
        movimientos.add(modificador_defensa);
        movimientos.add(modificador_Poder);
        setMovimientos(movimientos);

    }
}
