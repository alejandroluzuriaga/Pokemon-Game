package Combate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Entrenador.*;

public class Combate {
    private String fecha;
    private int numRondas;
    private Entrenador[] personajesInvolucrados = new Entrenador[2];
    private Entrenador ganador;

    //CONSTRUCTORES

    public Combate(Entrenador entrenador1, Entrenador entrenador2){
        personajesInvolucrados[0] = entrenador1;
        personajesInvolucrados[1] = entrenador2;
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
    
    public Entrenador[] getPersonajesInvolucrados() {
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

    public void setPersonajesInvolucrados(Entrenador[] personajesInvolucrados) {
        this.personajesInvolucrados = personajesInvolucrados;
    }

    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }

    

}
