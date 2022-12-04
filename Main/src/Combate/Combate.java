package Combate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Entrenador.*;

public class Combate {
    private String fecha;
    private int numRondas;
    private ArrayList<Entrenador> personajesInvolucrados = new ArrayList<Entrenador>();
    private Entrenador ganador;


    //CONSTRUCTOR

    public Combate (Entrenador entrenador1, Entrenador entrenador2){
        personajesInvolucrados.add(entrenador1);
        personajesInvolucrados.add(entrenador2);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu hh:mm a");
        setFecha(now.format(dtf));
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
}
