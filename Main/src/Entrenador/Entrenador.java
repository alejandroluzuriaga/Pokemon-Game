package Entrenador;

import Pookemon.*;
import java.util.Scanner;
import Combate.*;
import java.util.ArrayList;

public class Entrenador {
    private String nombre;
    private int identificador;
    private Pokemon pokemonActivo;
    private int turno;
    private ArrayList<Pokemon> pokemons;

      public Entrenador(String nombre, int identificador) {
        setNombre(nombre);
        setIdentificador(identificador);
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

    public ArrayList<Pokemon> getPokemons() {
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

    public void setPokemonActivo() {
            System.out.println("Elije el pokemon que quieres usar:");
            for (int i = 0; i < pokemons.size(); ++i)
                System.out.println("- Opción: "+(i+1)+ " " + this.pokemons.get(i).getNombre());
            
            Scanner pokemon = new Scanner(System.in);
            int opcion = pokemon.nextInt();
            this.pokemonActivo = pokemons.get(opcion-1);
            pokemon.close();
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
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
        this.setPokemonActivo();
        otroEntrenador.setPokemonActivo();
        
        if (this.getPokemonActivo().getVelocidad()>otroEntrenador.getPokemonActivo().getVelocidad()){
            do{
                this.turno();
                otroEntrenador.turno();
                combate.setNumRondas(combate.getNumRondas()+1);
            }while (true);
        }else{
            do{
                otroEntrenador.turno();
                this.turno();
                combate.setNumRondas(combate.getNumRondas()+1);
            }while (true);
        }
    }

    private void turno(){
        this.setPokemonActivo();

        
        //menu pokemon a elegir
        //menu movimiento a elegir
            }
    }

    public String toString() {
        return "Entrenador{" +
        "\n Nombre: " + 
        this.getNombre() + 
        "\n Identificador: " + 
        this.getIdentificador() + 
        "\n Pokemons: " + 
        "\n \t" + this.pokemons.get(0).getNombre() +
        "\n \t" + this.pokemons.get(1).getNombre() +
        "\n \t" + this.pokemons.get(2).getNombre() +
        "}";
    }

    public void anadirPokemon(Pokemon pokemon){
        if ((pokemons.size() < 3)){
                pokemons.add(pokemon);
        } else{
            System.out.println("Lista de pokemons llena");
        }
    }

    public void elegirMovimiento (){
        Scanner keyboard = new Scanner (System.in);
            int opcion2 = 0;
            do {
                System.out.println("Elija el movimiento");
                System.out.println("Opción 1: Ofensivo");
                System.out.println("Opción 2: Modificar poder");
                System.out.println("Opción 3: Modificar defensa");
                System.out.println("Opción 4: Cambiar pokemon activo");
            opcion2 = keyboard.nextInt();
        }
    }

}
