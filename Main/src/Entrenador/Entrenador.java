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
    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

    public Entrenador (String nombre, int identificador) {
        setNombre(nombre);
        setIdentificador(identificador);
        this.anadirPokemon(new Pokemon());
        this.anadirPokemon(new Pokemon());
        this.anadirPokemon(new Pokemon());
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
        if (this.pokemons.size()==1) {
            this.pokemonActivo=pokemons.get(0);
        }else{   
            System.out.println(this.getNombre() + ", elige el pokemon que quieres usar:");
            for (int i = 0; i < pokemons.size(); ++i)
            System.out.println("- Opción "+(i+1)+ ": " + this.pokemons.get(i).getNombre());
            
            Scanner pokemon = new Scanner(System.in);
            int opcion = pokemon.nextInt();
            this.pokemonActivo = pokemons.get(opcion-1);
        }
        System.out.println("El pokemon activo es:" + this.pokemonActivo.getNombre());
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }


    // OTROS MÉTODOS

    public Combate combatir (Entrenador otroEntrenador){
        // Entrenador turno;
        Combate combate = new Combate(this, otroEntrenador);
        this.setPokemonActivo();
        otroEntrenador.setPokemonActivo();        
        boolean sinPokemonsE1;
        boolean sinPokemonsE2;


        if (this.getPokemonActivo().getVelocidad() > otroEntrenador.getPokemonActivo().getVelocidad()){
            do{     
                this.elegirMovimiento(otroEntrenador);
                if(this.comprobarSaludPokemons()){otroEntrenador.elegirMovimiento(this);}
                combate.setNumRondas(combate.getNumRondas()+1);
                sinPokemonsE1 = this.comprobarSaludPokemons();
                sinPokemonsE2 = otroEntrenador.comprobarSaludPokemons();
                if (sinPokemonsE1 && sinPokemonsE2){
                    this.setPokemonActivo();
                    otroEntrenador.setPokemonActivo();
                }
            }while (sinPokemonsE1 && sinPokemonsE2);
        }else{
            do{
                otroEntrenador.elegirMovimiento(otroEntrenador);
                if (otroEntrenador.comprobarSaludPokemons()){this.elegirMovimiento(otroEntrenador);}
                combate.setNumRondas(combate.getNumRondas()+1);
                sinPokemonsE1 = this.comprobarSaludPokemons();
                sinPokemonsE2 = otroEntrenador.comprobarSaludPokemons();
                if (sinPokemonsE1 && sinPokemonsE2){
                    otroEntrenador.setPokemonActivo();
                    this.setPokemonActivo();
                }
            }while (sinPokemonsE1 && sinPokemonsE2);
        }

        if (sinPokemonsE1){
            combate.setGanador(this);
            System.out.println("El ganador es, " + this.getNombre());
            return combate;
        } else{
            combate.setGanador(otroEntrenador);
            System.out.println("El ganador es, " + otroEntrenador.getNombre());
            return combate;
        }
    } 

    private void abandono (){
        for (int i =0; i<this.pokemons.size(); ++i){
            this.pokemons.get(i).setSaludActual(0);
        }
    }

    public void anadirPokemon(Pokemon pokemon){
        if ((pokemons.size() < 3)){
                pokemons.add(pokemon);
        } else{
            System.out.println("Lista de pokemons llena");
        }
    }

    public void elegirMovimiento (Entrenador otroEntrenador){
        System.out.println(this.getNombre() + ", elige el movimiento que quieres usar:");
        for (int i = 0; i < this.pokemonActivo.getMovimientos().size(); ++i)
            System.out.println("- Opción " + (i+1) + ": " + this.pokemonActivo.getMovimientos().get(i).getNombre());
        
        System.out.println("- Opción 0: Abandonar combate");

        Scanner movimiento = new Scanner(System.in);
        int opcion = movimiento.nextInt();
        
        if (opcion!=0){
            this.pokemonActivo.getMovimientos().get(opcion-1).activar(this.pokemonActivo, otroEntrenador.pokemonActivo);
        }else {
            this.abandono();
        }
        System.out.println(this.getPokemonActivo().toString());
    }

    public boolean comprobarSaludPokemons () {
        int numeroPokemonsConVida=0;
        for (int i=0; i < this.pokemons.size(); ++i){
            if (this.pokemons.get(i).getSaludActual() > 0) {
                numeroPokemonsConVida++;
            }
        }
        return !(numeroPokemonsConVida==0);
    }

    @Override
    public String toString() {
        return "Entrenador{" +
        "\n Nombre: " + this.getNombre() + 
        "\n Identificador: " + this.getIdentificador() + 
        "\n Pokemons: " + 
        "\n \t" + this.pokemons.get(0).getNombre() +
        "\n \t" + this.pokemons.get(1).getNombre() +
        "\n \t" + this.pokemons.get(2).getNombre() +
        "}";
    }
}