package Entrenador;
import Pookemon.*;
import Combate.*;

public class Entrenador {
    private String nombre;
    private int identificador;
    private Pokemon pokemonActivo;
    private int turno;
    private Pokemon[] pokemons = new Pokemon[3];

    // CONSTRUCTORES
    public Entrenador(String nombre, int identificador, Pokemon[] pokemons) {
        setNombre(nombre);
        setIdentificador(identificador);
        setPokemons(pokemons);
    }

    // GETTERS & SETTERS

    public String getNombre() {
        return nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public Pokemon getPokemonActivo() {
        return pokemonActivo;
    }

    public int getTurno() {
        return turno;
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        }
    }

    public void setIdentificador(int identificador) {
        if (identificador >= 0) {
            this.identificador = identificador;
        } else {
            System.out.println("El identificador tiene que ser un valor positivo");
        }
    }

    public void setPokemonActivo(Pokemon pokemonActivo) {
        this.pokemonActivo = pokemonActivo;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setPokemons(Pokemon[] pokemons) {
        boolean Null = false;
        for (Pokemon i : pokemons) {
            if (i == null) {
                Null = true;
            }
        }
        if (!Null) {
            this.pokemons = pokemons;
        } else {
            System.out.println("El array no tiene 3 pokemons");
        }
    }

    // OTROS MÉTODOS

    //Crear objeto combate
        //Set atributos fecha, personajes_involucrados
        //Turno del entrenador con pokemon mas rapido
    //WHILE (pokemons con vida, y abandono = false)
        //Entrenador elige pokemon
        //Entrenador elige movimiento
        //Cambia turno
    //END WHILE
    //Set atributos nRondas, Ganador

    public Combate combatir (Entrenador otroEntrenador){
        // Entrenador turno;
        
        Combate combate = new Combate(this, otroEntrenador);
        
        while 

            //

        
        return combate;
    }

    private Pokemon elegir(){

        return 
    }

    private void turno(){
        //menu pokemon a elegir
        //menu movimiento a elegir

    }

    public String toString() {
        return "Entrenador{" +
        "\n Nombre: " + 
        this.getNombre() + 
        "\n Identificador: " + 
        this.getIdentificador() + 
        "\n Pokemons: " + 
        "\n \t" + this.pokemons[0].getNombre() +
        "\n \t" + this.pokemons[1].getNombre() +
        "\n \t" + this.pokemons[2].getNombre() +
        "}";
    }
}
