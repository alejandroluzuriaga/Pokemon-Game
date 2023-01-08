package Pookemon;
import java.util.ArrayList;

import Movimiento.*;

public class Squirtle extends Pokemon {
    
    public Squirtle(int nivel, String nombre){
       
        this.setNombre(nombre);
        this.setTipo("Agua");
        this.setNivel(nivel);
        this.setSaludo("Lo que sube del cubata son los hielos");
        this.crearValoresBase();

        Ofensivo ofensivo = new Ofensivo("aguabendita");
        ModificadorDefensa modificador_defensa = new ModificadorDefensa("Pocion_Defensa");
        ModificadorPoder modificador_Poder = new ModificadorPoder("Poder - 4");

        ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
        movimientos.add(ofensivo);
        movimientos.add(modificador_defensa);
        movimientos.add(modificador_Poder);
        setMovimientos(movimientos);
    }

}
