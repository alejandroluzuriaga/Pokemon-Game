package Combate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.*;

import Entrenador.*;
import Pookemon.*;

public class Combate {
    private String fecha;
    private int numRondas;
    private ArrayList<Entrenador> personajesInvolucrados = new ArrayList<Entrenador>();
    private Entrenador ganador;

    private int random = (int) Math.floor(Math.random()*1000+1);
    private File ruta= new File("./src/Combates/Combate_" + random + ".txt");


    //CONSTRUCTOR

    public Combate (Entrenador entrenador1, Entrenador entrenador2){
        personajesInvolucrados.add(entrenador1);
        personajesInvolucrados.add(entrenador2);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu hh:mm a");
        setFecha(now.format(dtf));
    }

    public void subirNivelPokemons(){
        for (Pokemon pokemon : ganador.getPokemons()) {
            pokemon.setNivel(pokemon.getNivel()+3);
        }
    }

    //SETTERS Y GETTERS

    public String getFecha() {
        return fecha;
    }

    public int getNumRondas() {
        return numRondas;
    }
    
    public ArrayList<Entrenador> getPersonajesInvolucrados() {
        return personajesInvolucrados;
    }

    public Entrenador getGanador() {
        return ganador;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNumRondas(int numRondas) {
        this.numRondas = numRondas;
    }

    public void setPersonajesInvolucrados(ArrayList<Entrenador> personajesInvolucrados) {
        this.personajesInvolucrados = personajesInvolucrados;
    }

    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }

    
    public void escribirFicheroCombate (){
        try{
            BufferedWriter combate = new BufferedWriter(new FileWriter(ruta));

            combate.write("*********** COMBATE Nº" + random + " ***********");
            combate.newLine();
            combate.newLine();

            combate.write("******** DATOS DEL COMBATE ********");
            combate.newLine();
            combate.write("FECHA: " + this.fecha.toString());
            combate.newLine();
            combate.write("Numero de rondas: " + this.numRondas);
            combate.newLine(); 
            combate.newLine();

            combate.write("*********** PERSONAJES INVOLUCRADOS ***********");
            combate.newLine();
            combate.write("Entrenador desafiante: " + this.personajesInvolucrados.get(0).getNombre());
            combate.newLine();
            combate.write("Pokemons de este entrenador: ");

            for (int i = 0; i < (this.personajesInvolucrados.get(0).getPokemons().size()); i++) {
                combate.write(this.personajesInvolucrados.get(0).getPokemons().get(i).getNombre() + " ");
            }
            
            combate.newLine();
            combate.newLine();
            combate.write("Entrenador desafiado: " + this.personajesInvolucrados.get(1).getNombre());
            combate.newLine();
            combate.write("Pokemons de este entrenador: ");

            for (int i = 0; i < (this.personajesInvolucrados.get(1).getPokemons().size()); i++) {
                combate.write(this.personajesInvolucrados.get(1).getPokemons().get(i).getNombre()+ " ");
            }
            combate.newLine();
            combate.newLine();

            combate.write("*********** GANADOR DEL COMBATE ***********");
            combate.newLine();
            combate.write("El ganador del combate ha sido: " + this.getGanador().getNombre());
            combate.newLine();
            combate.write("¡¡SE LLEVA UN APLAUSO Y UN APROBADO EN POO!!");  
    


            combate.close();
        } catch (IOException n) {
            n.printStackTrace();
        }
    }

}
