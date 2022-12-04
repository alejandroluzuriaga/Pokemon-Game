package Mundo;
import Entrenador.*;
import Pookemon.*;


public class Mundo {
    public static void main (String [] args) {
        Entrenador E1 = new Entrenador("Antonio", 01);
        Entrenador E2 = new Entrenador("Jesús", 02);
        Bulbasur bulbasur = new Bulbasur(5, "Bul1");
        Charmander charmander = new Charmander(4, "Char1");
        E1.anadirPokemon(charmander);
        E2.anadirPokemon(bulbasur);
        E1.combatir(E2);
    }
}