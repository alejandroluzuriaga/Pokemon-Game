package GUI;

import javax.swing.*;
import Pookemon.*;

public class BotonPokemon extends JToggleButton {
    private Pokemon pokemon;

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
