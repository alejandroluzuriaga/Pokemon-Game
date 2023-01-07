package Mundo;

import java.util.ArrayList;

import Combate.*;
import Entrenador.*;
import Pookemon.*;
import GUI.*;

public class Mundo {
    public static Mundo iMundo;

    private ArrayList<Entrenador> listaEntrenadores;
    private ArrayList<Pokemon> listaPokemons;
    private ArrayList<Combate> combates;

    public Mundo(){
        iMundo=this;
        listaEntrenadores = new ArrayList<>();
        listaPokemons = new ArrayList<>();
        new VentanaInicio();
    }

    public ArrayList<Pokemon> getListaPokemons() {
        return listaPokemons;
    }

    public ArrayList<Entrenador> getListaEntrenadores() {
        return listaEntrenadores;
    }

    public ArrayList<Combate> getCombates(){
        return combates;
    }
}