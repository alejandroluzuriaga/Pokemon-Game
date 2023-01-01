package Mundo;

import java.util.ArrayList;
import Entrenador.*;
import Pookemon.*;
import GUI.*;

public class Mundo {
    private ArrayList<Entrenador> listaEntrenadores;
    private ArrayList<Pokemon> listaPokemons;

    public Mundo(){
        listaEntrenadores = new ArrayList<>();
        listaPokemons = new ArrayList<>();
        new VentanaInicio();
    }

}