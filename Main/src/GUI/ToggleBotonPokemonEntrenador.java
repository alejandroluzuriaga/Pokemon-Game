package GUI;

import javax.swing.*;
import Entrenador.*;
import Pookemon.*;

public class ToggleBotonPokemonEntrenador extends JToggleButton {
    private Pokemon pokemon;
    private Entrenador entrenador;

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }
    
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}
