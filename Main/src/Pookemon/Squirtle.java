package Pookemon;
import Movimiento.*;

public class Squirtle extends Pokemon {
    
    public Squirtle(int nivel, String nombre){
       
        this.setNombre(nombre);
        this.setSaludo("Lo que sube del cubata son los hielos");
        this.setTipo("Agua");
        this.setNivel(nivel);

        int valorBase = 1;     // para calcular los valores de poder, defensa, etc.   
        this.setPoder ((int) ((valorBase + nivel) * (Math.random()*10+1)));   // Le sumamos el nivel y multiplicamos por un valor aleatorio (entre 1 y 10)       
        this.setDefensa ((int) ((valorBase + nivel) * (Math.random()*10+1)));
        this.setVelocidad((int) ((valorBase + nivel) * (Math.random()*10+1)));        
        this.setSaludMax((int) ((valorBase + nivel) * (Math.random()*10+1)));       
        this.setSaludActual((int) ((valorBase + nivel) * (Math.random()*10+1)));   
        this.setPoderEspecial((int) ((valorBase + (nivel*1.5)) * (Math.random()*10+1)));
        this.setDefensaEspecial((int) ((valorBase + (nivel*1.5)) * (Math.random()*10+1)));

        Ofensivo ofensivo = new Ofensivo("aguabendita");
        ModificadorDefensa modificador_defensa = new ModificadorDefensa("Pocion_Defensa");
        ModificadorPoder modificador_Poder = new ModificadorPoder("Poder - 4");

        Movimiento[] Movs1 = {ofensivo, modificador_defensa, modificador_Poder};

        setMovimientos(Movs1);
    }

}
