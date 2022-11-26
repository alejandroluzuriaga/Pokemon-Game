import Pookemon.*;
import Movimiento.*;
import Entrenador.*;

public class pruebitas {
    public static void main (String [ ] args) {
            Pokemon rattata = new Rattata(1, "Rattata");
            System.out.println(rattata.toString());

            Pokemon charmander = new Charmander(2, "Charmander");
            System.out.println(charmander.toString());

            Movimiento ofensivo = new Ofensivo("Barrido");
            System.out.println(ofensivo.toString());

            ofensivo.activar(rattata, charmander);
            System.out.println(ofensivo.toString());

            System.out.println(charmander.toString());


        }
}
