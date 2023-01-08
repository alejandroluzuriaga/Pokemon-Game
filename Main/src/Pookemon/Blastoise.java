package Pookemon;

import java.util.ArrayList;
import Movimiento.*;

public class Blastoise extends Pokemon {
    
    public Blastoise(int nivel, String nombre){
       
        this.setNombre(nombre);
        this.setTipo("Agua");
        this.setNivel(nivel);
        this.setSaludo("Toma agua pa Murcia que hace mucha falta");
        this.crearValoresBase();
        setMovimientosPrivate();
    }
    
    public Blastoise(int nivel, String nombre, Pokemon pokemonSinEvolucionar){
        this.setNombre(nombre);
        this.setTipo("Agua");
        this.setNivel(nivel);
        this.setEntrenador(pokemonSinEvolucionar.getEntrenador());
        this.setSaludo("Toma agua pa Murcia que hace mucha falta");
        
        this.setPoder((int)(pokemonSinEvolucionar.getPoder() * 1.2));   
        this.setDefensa((int)(pokemonSinEvolucionar.getDefensa() * 1.2));
        this.setVelocidad((int)(pokemonSinEvolucionar.getVelocidad() * 1.2));        
        this.setSaludMax((int)(pokemonSinEvolucionar.getSaludMax() * 1.2));       
        this.setSaludActual((int)(pokemonSinEvolucionar.getSaludActual() * 1.2));   
        this.setPoderEspecial((int)(pokemonSinEvolucionar.getPoderEspecial() * 1.2));
        this.setDefensaEspecial((int)(pokemonSinEvolucionar.getDefensaEspecial() * 1.2));
        this.setEntrenador(pokemonSinEvolucionar.getEntrenador());
        this.getEntrenador().getPokemons().remove(pokemonSinEvolucionar);
        this.getEntrenador().getPokemons().add(this);
        setMovimientosPrivate();
    }
    
    private void setMovimientosPrivate () {
        Ofensivo ofensivo = new Ofensivo("Martillo");
        Ofensivo ofensivoEspecial = new Ofensivo("Martillo Especial");
        ModificadorDefensa modificador_defensa = new ModificadorDefensa("Escudo");
        ModificadorPoder modificador_Poder = new ModificadorPoder("Grito Sonico");

        ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
        movimientos.add(ofensivo);
        movimientos.add(ofensivoEspecial);
        movimientos.add(modificador_defensa);
        movimientos.add(modificador_Poder);
        setMovimientos(movimientos);
    }
}
