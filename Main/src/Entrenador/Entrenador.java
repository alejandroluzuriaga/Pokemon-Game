package Entrenador;
import java.util.Scanner;
import Pookemon.*;

public class Entrenador {
    private String nombre;
    private int identificador;
    private Pokemon pokemonActivo;
    private int turno;
    //habria que poner los tres pokemons en un array de tipo Pokemon
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;

    //CONSTRUCTORES
    public Entrenador () {

    }
    public Entrenador (String nomb, int ident, Pokemon pok1, Pokemon pok2, Pokemon pok3) {
        //NOMBRE
        if (nomb == null) {
            this.nombre = "";
        }
        else {
            this.nombre = nomb;
        } 
        //IDENTIFICADOR
        if (ident >= 0) {
            this.identificador = ident;
        }
        //POKEMONS
        this.pokemon1 = pok1;
        this.pokemon2 = pok2;
        this.pokemon3 = pok3;
    }

    //GET Y SET
    public String getNombre () {
        return nombre;
    }
    public int getIdentificador () {
        return identificador;
    }
    public Pokemon getPokemonActivo () {
        return pokemonActivo;
    } 
    public int getTurno () {
        return turno;
    }
    public Pokemon getPokemon1 () {
        return pokemon1;
    }
    public Pokemon getPokemon2 () {
        return pokemon2;
    }
    public Pokemon getPokemon3 () {
        return pokemon3;
    }
    public void setNombre (String nomb) {
        if (nomb == null) {
            this.nombre = "";
            System.out.println("El valor del nombre es nulo");
        }
        else {
            this.nombre = nomb;
            System.out.println("Nombre asignado correctamente");
        }
    }
    public void setIdentificador (int ident) {
        if (ident >= 0) {
            this.identificador = ident;
        } 
    }
    public void setPokemonActivo (Pokemon pok) {
        this.pokemonActivo = pok;
    }
    public void setTurno (int turno) {
        this.turno = turno;
    }
    public void setPokemon1 (Pokemon pokemon) {
        this.pokemon1 = pokemon;
    }
    public void setPokemon2 (Pokemon pokemon) {
        this.pokemon2 = pokemon;
    }
    public void setPokemon3 (Pokemon pokemon) {
        this.pokemon3 = pokemon;
    }

    //MENUS
    public int menu2 () {
        Scanner keyboard = new Scanner (System.in);
        int opcion2 = 0;
        do {
            System.out.println("Elija el movimiento");
            System.out.println("Opción 1: Ofensivo");
            System.out.println("Opción 2: Modificar poder");
            System.out.println("Opción 3: Modificar defensa");
            System.out.println("Opción 4: Cambiar pokemon activo");
            opcion2 = keyboard.nextInt();
        } while ((opcion2 != 1) && (opcion2 != 2) && (opcion2 != 3) && (opcion2 != 4));
        //keyboard.close();
        return opcion2;
    }
    public int menu1 () {
        Scanner keyboard = new Scanner (System.in);
        int opcion2 = 0;
        do {
            System.out.println("Elija un pokemon");
            System.out.println("Opción 1: Charmander");
            System.out.println("Opción 2: Charmeleon");
            System.out.println("Opción 3: Squirtle");
            System.out.println("Opción 4: Blastoise");
            System.out.println("Opción 5: Bulbasur");
            System.out.println("Opción 6: Rattata");
            System.out.println("Opción 7: Ninguno");
            opcion2 = keyboard.nextInt();
        } while ((opcion2 != 1) && (opcion2 != 2) && (opcion2 != 3) && (opcion2 != 4) && (opcion2 != 5) && (opcion2 != 6) && (opcion2 != 7));
        //keyboard.close();
        return opcion2;
    }

    //RESTO MÉTODOS
    public Entrenador muestraTurno (Entrenador entrenador2) {
        this.pokemonActivo = this.pokemon1;
        entrenador2.pokemonActivo = entrenador2.pokemon1;
        if ((this.pokemonActivo.getVelocidad()) >= (entrenador2.pokemonActivo.getVelocidad())) {
            System.out.println("El turno es del entrenador número " + this.identificador);
            System.out.println("El pokemon activo es: " + this.pokemonActivo.toString());
            return this;
        }
        else {
            System.out.println("El turno es del entrenador número " + entrenador2.identificador);
            System.out.println("El pokemon activo es: " + entrenador2.pokemonActivo.toString());
            return entrenador2;
        }
    }
    public void combateFinal (Pokemon pok1, Pokemon pok2, Entrenador entrenador2) {
        Entrenador entrenadorCombate = muestraTurno (entrenador2);
        
        //pokemons activos
        pok1 = this.pokemonActivo;
        pok2 = entrenador2.pokemonActivo;

        //guardo los pokemons para luego poder reiniciarlos
        Pokemon pok1Otro = this.getPokemon1();
        Pokemon pok2Otro = this.getPokemon2();
        Pokemon pok3Otro = this.getPokemon3();
        
        Pokemon pok4Otro = entrenador2.getPokemon1();
        Pokemon pok5Otro = entrenador2.getPokemon2();
        Pokemon pok6Otro = entrenador2.getPokemon3();
        do {
            combate(pok1, pok2, entrenador2);
        }
        while (((this.pokemon1.getSaludActual() > 0) && (this.pokemon2.getSaludActual() > 0) && (this.pokemon3.getSaludActual() > 0)) || ((entrenador2.pokemon1.getSaludActual() > 0) && (entrenador2.pokemon2.getSaludActual() > 0) && (entrenador2.pokemon3.getSaludActual() > 0))); 
        // se repite hasta que un entrenador tenga todos sus pokemon derrotados
        if ((this.pokemon1.getSaludActual() > 0) || (this.pokemon2.getSaludActual() > 0) || (this.pokemon3.getSaludActual() > 0)) {
            System.out.println("El ganador del combate es: " + this.toString() );
        }
        if ((entrenador2.pokemon1.getSaludActual() > 0) || (entrenador2.pokemon2.getSaludActual() > 0) || (entrenador2.pokemon3.getSaludActual() > 0)) {
            System.out.println("El ganador del combate es: " + entrenador2.toString() );
        }
        //recuperan estado original y suben un nivel. si alcanzan cierto nivel evolucionan
        this.pokemon1 = pok1Otro;
        pok1Otro.subirNivel();
        System.out.println((pok1Otro.evolucionar()).toString());
        this.pokemon2 = pok2Otro;
        pok2Otro.subirNivel();
        System.out.println((pok2Otro.evolucionar()).toString());
        this.pokemon3 = pok3Otro;
        pok3Otro.subirNivel();
        System.out.println((pok3Otro.evolucionar()).toString());
        entrenador2.pokemon1 = pok4Otro;
        pok4Otro.subirNivel();
        System.out.println((pok4Otro.evolucionar()).toString());
        entrenador2.pokemon2 = pok5Otro;
        pok5Otro.subirNivel();
        System.out.println((pok5Otro.evolucionar()).toString());
        entrenador2.pokemon3 = pok6Otro;
        pok6Otro.subirNivel();
        System.out.println((pok6Otro.evolucionar()).toString());
    }
    public void combate (Pokemon pokemon1, Pokemon pokemon2, Entrenador entrenador2) {
        while ((pokemon1.getSaludActual() > 0) && (pokemon2.getSaludActual() > 0)) {
			System.out.println("Pokemons que combaten:");
			System.out.println(pokemon1.toString());
			System.out.println(pokemon2.toString());
            if (pokemon1.getVelocidad() >= pokemon2.getVelocidad()) {
                System.out.println("Turno de ataque para " + pokemon1.getNombre());
                int opcion = this.menu2(); //elige el tipo de movimiento
                this.haceMovimiento(opcion); //hace el movimiento dependiendo del elegido
                if (pokemon2.getSaludActual() <= 0) {
                    System.out.println(pokemon2.getNombre() + "ha sido derrotado");
                }
            }
            else {
                System.out.println("Turno de ataque para " + pokemon2.getNombre());
                int opcion2 = this.menu2(); //elige el tipo de movimiento
                entrenador2.haceMovimiento(opcion2); //hace el movimiento dependiendo del elegido
                if (pokemon1.getSaludActual() <= 0) {
                    System.out.println(pokemon1.getNombre() + "ha sido derrotado");
                }
            }
		}
		System.out.println("FIN DEL COMBATE");
	}
    public void haceMovimiento (int opcion) {
        switch (opcion) {
            case 1:
                //llamar a movimiento ofensivo
                break;
        
            case 2:
                //llamar a modificar poder
                break;
        
            case 3:
                //llamar a modificar defensa
                break;
        
            case 4:
                //cambiar pokemon activo
                break;
    
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    public Pokemon elegirPokemons () {
        int opcion = menu1();
        switch (opcion) {
            case 1:
                return new Charmander (60, "chari");
            case 2:
                return new Charmeleon (20, "charm");
            case 3:
                return new Squirtle (90, "squirty");
            case 4:
                return new Bulbasur (20, "bulbasy");
            case 5:
                return new Blastoise (60, "blasty");
            case 6:
                return new Rattata (100, "ratt");
            default:
                return new Pokemon();
        }
    }
    public String toString() {
        return """
               Entrenador{
                nombre: """ + " " + this.getNombre() + "\n identificador: " + this.getIdentificador() + "\n tiene los pokemons: " + this.pokemon1.getNombre() + ", " + this.pokemon2.getNombre() + ", " + this.pokemon3.getNombre() + '}';
    }
}
