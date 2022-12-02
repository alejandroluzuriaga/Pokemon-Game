package Pookemon;
import Movimiento.*;

public class Charmander extends Pokemon {

    public Charmander(int nivel, String nombre){
       
        this.setNombre(nombre);
        this.setSaludo("¡A quemar la universidad!");       
        this.setTipo("Fuego");
        this.setNivel(nivel);
        
        int valorBase = 1;     // para calcular los valores de poder, defensa, etc.   
        this.setPoder ((int) ((valorBase + nivel) * (Math.random()*10+1)));   // Le sumamos el nivel y multiplicamos por un valor aleatorio (entre 1 y 10)       
        this.setDefensa ((int) ((valorBase + nivel) * (Math.random()*10+1)));
        this.setVelocidad((int) ((valorBase + nivel) * (Math.random()*10+1)));        
        this.setSaludMax((int) ((valorBase + nivel) * (Math.random()*10+1)));       
        this.setSaludActual((int) ((valorBase + nivel) * (Math.random()*10+1)));   
        this.setPoderEspecial((int) ((valorBase + (nivel*1.5)) * (Math.random()*10+1)));
        this.setDefensaEspecial((int) ((valorBase + (nivel*1.5)) * (Math.random()*10+1)));

        Ofensivo ofensivo = new Ofensivo("Barrido");
        ModificadorDefensa modificador_defensa = new ModificadorDefensa("Pocion_Defensa");
        ModificadorPoder modificador_Poder = new ModificadorPoder("Poder +8 TAPOTENTE");

        Movimiento[] Movs1 = {ofensivo, modificador_defensa, modificador_Poder};

        setMovimientos(Movs1);
    } 
}
