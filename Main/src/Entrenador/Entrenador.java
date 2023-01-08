package Entrenador;

import Pookemon.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

import GUI.*;
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
            System.out.println();
            System.out.println(this.getNombre() + ", elige el pokemon que quieres usar:");
            for (int i = 0; i < this.pokemons.size(); ++i){
                if (this.pokemons.get(i).getSaludActual()>0){
                    System.out.println("- Opción "+ (i+1) + ": " + this.pokemons.get(i).getNombre());
                }
            }
            
            System.out.print("Opción ");
            Scanner pokemon = new Scanner(System.in);
            int opcion = pokemon.nextInt();
            this.pokemonActivo = pokemons.get(opcion-1);
        }
        System.out.println();
        System.out.println("El pokemon activo de "+ this.getNombre() +" es " + this.pokemonActivo.getNombre());

    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }


    // OTROS MÉTODOS

    public Combate combatir (Entrenador otroEntrenador){
        System.out.println("-----------------------------------------------");
        System.out.println("---------------------COMBATE-------------------");
        System.out.println("-----------------------------------------------");
        Combate combate = new Combate(this, otroEntrenador);
        Entrenador entrenadorDesafiante = clonarEntrenador(this);
        Entrenador entrenadorDesafiado = clonarEntrenador(otroEntrenador);

        entrenadorDesafiante.setPokemonActivo();
        entrenadorDesafiado.setPokemonActivo();        
        boolean sinPokemonsE1;
        boolean sinPokemonsE2;


        if (entrenadorDesafiante.getPokemonActivo().getVelocidad() > entrenadorDesafiado.getPokemonActivo().getVelocidad()){
            System.out.println();
            System.out.println("El pokemon seleccionador por " + entrenadorDesafiante.getNombre() + " es más rápido, por tanto empieza el combate");
            do{
                entrenadorDesafiante.elegirMovimiento(entrenadorDesafiado);
                if(entrenadorDesafiante.comprobarSaludPokemons()){
                    entrenadorDesafiado.elegirMovimiento(entrenadorDesafiante);
                }
                combate.setNumRondas(combate.getNumRondas()+1);
                sinPokemonsE1 = entrenadorDesafiante.comprobarSaludPokemons();
                sinPokemonsE2 = entrenadorDesafiado.comprobarSaludPokemons();
                if (sinPokemonsE1 && sinPokemonsE2){
                    entrenadorDesafiante.setPokemonActivo();
                    entrenadorDesafiado.setPokemonActivo();
                }
            }while (sinPokemonsE1 && sinPokemonsE2);
        }else{
            System.out.println();
            System.out.println("El pokemon seleccionador por " + entrenadorDesafiado.getNombre() + " es más rápido, por tanto empieza el combate");
            do{
                entrenadorDesafiado.elegirMovimiento(entrenadorDesafiante);
                if (entrenadorDesafiado.comprobarSaludPokemons()){
                    entrenadorDesafiante.elegirMovimiento(entrenadorDesafiado);
                }
                combate.setNumRondas(combate.getNumRondas()+1);
                sinPokemonsE1 = entrenadorDesafiante.comprobarSaludPokemons();
                sinPokemonsE2 = entrenadorDesafiado.comprobarSaludPokemons();
                if (sinPokemonsE1 && sinPokemonsE2){
                    entrenadorDesafiado.setPokemonActivo();
                    entrenadorDesafiante.setPokemonActivo();
                }
            }while (sinPokemonsE1 && sinPokemonsE2);
        }

        if (sinPokemonsE1){
            combate.setGanador(this);
            System.out.println();
            System.out.println("Ha ganado, " + this.getNombre());
            combate.subirNivelPokemons();
            JOptionPane.showMessageDialog(null, "El combate ha terminado, ha ganado " + combate.getGanador().getNombre(), "Atención", JOptionPane.INFORMATION_MESSAGE);
            return combate;
        } else{
            combate.setGanador(otroEntrenador);
            System.out.println();
            System.out.println("Ha ganado, " + otroEntrenador.getNombre());
            combate.subirNivelPokemons();
            JOptionPane.showMessageDialog(null, "El combate ha terminado, ha ganado " + combate.getGanador().getNombre(), "Atención", JOptionPane.INFORMATION_MESSAGE);
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
                pokemon.setEntrenador(this);
        } else{
            System.out.println("Lista de pokemons llena");
        }
    }

    public void elegirMovimiento (Entrenador otroEntrenador){
        if(!(otroEntrenador.getPokemonActivo().getSaludActual()<=0) && !(this.getPokemonActivo().getSaludActual()<=0)){    
            System.out.println();
            System.out.println(this.getNombre()+ " (con pokemon activo " + this.getPokemonActivo().getNombre()+ "), elige el movimiento que quieras usar:");
            for (int i = 0; i < this.pokemonActivo.getMovimientos().size(); ++i)
                System.out.println("- Opción " + (i+1) + ": " + this.pokemonActivo.getMovimientos().get(i).getNombre() + " [" + this.pokemonActivo.getMovimientos().get(i).getUsos() + "/" + this.pokemonActivo.getMovimientos().get(i).getUsosMaximos()+"]");
            System.out.println("- Opción 0: Abandonar combate");
            
            System.out.print("Opción ");
            Scanner movimiento = new Scanner(System.in);
            int opcion = movimiento.nextInt();
            if (opcion!=0){
                this.pokemonActivo.getMovimientos().get(opcion-1).activar(this.pokemonActivo, otroEntrenador.pokemonActivo);
            }else {
                this.abandono();
            }
        }
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

    public Entrenador clonarEntrenador(Entrenador entrenadorOriginal){
        Entrenador entrenadorClon = new Entrenador(entrenadorOriginal.getNombre(), entrenadorOriginal.getIdentificador());

        ArrayList<Pokemon> pokemonsClon = new ArrayList<>();
        for (Pokemon pokemon : entrenadorOriginal.pokemons) {
            pokemonsClon.add(pokemon.clonarPokemon());
        }
        entrenadorClon.setPokemons(pokemonsClon);
        return entrenadorClon;
    }

    @Override
    public String toString() {
        String nombresPokemons="";
        for (Pokemon pokemon : pokemons) {
            nombresPokemons += "\t" + pokemon.getNombre();
        }
        return  nombre + "\t" + this.getIdentificador() + nombresPokemons;

    }
}
