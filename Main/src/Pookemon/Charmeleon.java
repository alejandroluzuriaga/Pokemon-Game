package Pookemon;
import Movimiento.*;
public class Charmeleon extends Pokemon {
    
    // Constructor para crear Charmeleon como evolucion
    public Charmeleon(int nivel, String nombre, Pokemon pokemonSinEvolucionar){
       
        this.setNombre(nombre);
        this.setSaludo("DRACARYSSSSSSSS"); 
        this.setTipo("Fuego");
        this.setNivel(nivel);
        
        // Usamos el Pokemon anterior a la evolucion para incrementar sus "poderes"  
        this.setPoder ((int) (pokemonSinEvolucionar.getPoder() * 1.2));   // Le sumamos el nivel y multiplicamos por un valor aleatorio (entre 1 y 10)       
        this.setDefensa ((int) (pokemonSinEvolucionar.getDefensa() * 1.2));
        this.setVelocidad((int) (pokemonSinEvolucionar.getVelocidad() * 1.2));        
        this.setSaludMax((int) (pokemonSinEvolucionar.getSaludMax() * 1.2));       
        this.setSaludActual((int) (pokemonSinEvolucionar.getSaludActual() * 1.2));   
        this.setPoderEspecial((int) (pokemonSinEvolucionar.getPoderEspecial() * 1.2));
        this.setDefensaEspecial((int) (pokemonSinEvolucionar.getDefensaEspecial() * 1.2));
    }
        
        // Constructor para crear Charmeleon desde 0
        public Charmeleon(int nivel, String nombre){
       
        this.setNombre(nombre);
        this.setSaludo("DRACARYSSSSSSSS"); 
        this.setTipo("Fuego");
        this.setNivel(nivel);
        
        int valorBase = 2;     // para calcular los valores de poder, defensa, etc.   
        this.setPoder ((int) ((valorBase + nivel) * (Math.random()*10+1)));   
        this.setDefensa ((int) ((valorBase + nivel) * (Math.random()*10+1)));
        this.setVelocidad((int) ((valorBase + nivel) * (Math.random()*10+1)));        
        this.setSaludMax((int) ((valorBase + nivel) * (Math.random()*10+1)));       
        this.setSaludActual((int) ((valorBase + nivel) * (Math.random()*10+1)));   
        this.setPoderEspecial((int) ((valorBase + (nivel*1.5)) * (Math.random()*10+1)));
        this.setDefensaEspecial((int) ((valorBase + (nivel*1.5)) * (Math.random()*10+1)));

        Ofensivo ofensivo = new Ofensivo("Barrido");
        Ofensivo ofensivoEspecial = new Ofensivo("BarridoEsp"); //Como es evolución, se le añade un ataqueEspecial
        ModificadorDefensa modificador_defensa = new ModificadorDefensa("Pocion_Defensa");
        ModificadorPoder modificador_Poder = new ModificadorPoder("Poder +8 TAPOTENTE");

        Movimiento[] Movs1 = {ofensivo, ofensivoEspecial, modificador_defensa, modificador_Poder};

        setMovimientos(Movs1);
    }
    
}
