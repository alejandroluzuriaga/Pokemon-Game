package GUI;

import javax.swing.*;
import Pookemon.*;

public class BotonPokemon extends JButton {
    private Pokemon pokemon;

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
