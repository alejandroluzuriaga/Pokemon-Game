package GUI;

import javax.swing.*;
import Pookemon.*;

public class BotonPokemonDisponible extends JButton {
    private Pokemon pokemon;

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
