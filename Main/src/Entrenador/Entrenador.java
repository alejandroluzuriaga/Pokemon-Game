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

    public Entrenador (String nombre, int identificador) {
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
        boolean salud1;
        boolean salud2;


        if (this.getPokemonActivo().getVelocidad()>otroEntrenador.getPokemonActivo().getVelocidad()){
            do{
                salud1 = this.pokemons.get(0).getSaludActual()>0 && this.pokemons.get(1).getSaludActual()>0 && this.pokemons.get(2).getSaludActual()>0;
                salud2 = otroEntrenador.pokemons.get(0).getSaludActual()>0 && otroEntrenador.pokemons.get(1).getSaludActual()>0 && otroEntrenador.pokemons.get(2).getSaludActual()>0;
                this.turno(otroEntrenador);
                otroEntrenador.turno(this);
                combate.setNumRondas(combate.getNumRondas()+1);
            }while (salud1 || salud2);
            
        }else{
            do{
                salud1 = this.pokemons.get(0).getSaludActual()>0 && this.pokemons.get(1).getSaludActual()>0 && this.pokemons.get(2).getSaludActual()>0;
                salud2 = otroEntrenador.pokemons.get(0).getSaludActual()>0 && otroEntrenador.pokemons.get(1).getSaludActual()>0 && otroEntrenador.pokemons.get(2).getSaludActual()>0;
                otroEntrenador.turno(this);
                this.turno(otroEntrenador);
                combate.setNumRondas(combate.getNumRondas()+1);
            }while (salud1 || salud2);
        }

        if (salud1){
                combate.setGanador(this);
                return combate;
            }else{
                combate.setGanador(otroEntrenador);
                return combate;

            }
    }

    private void turno(Entrenador otroEntrenador){
        this.setPokemonActivo();
        this.elegirMovimiento(otroEntrenador);
        
    }

    private void abandono (){
        // System.out.println(this.nombre + ", ¿Quieres seguir peleando?");
        // Scanner keyboard = new Scanner(System.in);
        // String opcion = keyboard.next();
        // keyboard.close();
        for (int i =0; i<this.pokemons.size(); ++i){
        this.pokemons.get(i).setSaludActual(0);        
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

    public void elegirMovimiento (Entrenador otroEntrenador){
        System.out.println("Elije el movimiento que quieres usar:");
        for (int i = 0; i < this.pokemonActivo.getMovimientos().size(); ++i)
            System.out.println("- Opción: " + (i+1) + " " + this.pokemonActivo.getMovimientos().get(i).getNombre());
            System.out.println("- Opción: 0 Abandonar combate");

        Scanner pokemon = new Scanner(System.in);
        int opcion = pokemon.nextInt();
        if (opcion!=0){
            this.pokemonActivo.getMovimientos().get(opcion).activar(this.pokemonActivo, otroEntrenador.pokemonActivo);
        }else {
            this.abandono();
        }
        pokemon.close();
        }
}