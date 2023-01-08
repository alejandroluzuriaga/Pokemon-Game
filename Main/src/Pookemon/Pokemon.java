package Pookemon;

import java.util.ArrayList;
import Movimiento.*;
import Entrenador.*;

public class Pokemon {
    private String nombre, saludo, tipo;
    private Entrenador entrenador;
    private int poder, velocidad, saludMax, saludActual, poderEspecial, defensa, defensaEspecial, nivel;
    private ArrayList<Movimiento> movimientos;

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Entrenador getEntrenador() {
            return entrenador;
        }


    public String getSaludo() {
        return saludo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPoder() {
        return poder;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getSaludMax() {
        return saludMax;
    }

    public int getSaludActual() {
        return saludActual;
    }

    public int getPoderEspecial() {
        return poderEspecial;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public int getNivel() {
        return nivel;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPoder(int poder) {
        if (poder > 0) {
            this.poder = poder;
        } else {
            System.out.println("Valor no válido, debe ser superior a 0");
        }
    }

    public void setVelocidad(int velocidad) {
        if (velocidad > 0) {
            this.velocidad = velocidad;
        } else {
            System.out.println("Valor no válido, debe ser superior a 0");
        }
    }

    public void setSaludMax(int saludMax) {
        if (saludMax > 0) {
            this.saludMax = saludMax;
        } else {
            System.out.println("Valor no válido, debe ser superior a 0");
        }
    }

    public void setSaludActual(int saludActual) {
        this.saludActual = saludActual;
        // if (saludActual > 0) {
        //     this.saludActual = saludActual;
        // } else {
        //     System.out.println("Valor no válido, debe ser superior a 0");
        // }
    }

    public void setPoderEspecial(int poderEspecial) {
        if (poderEspecial > 0) {
            this.poderEspecial = poderEspecial;
        } else {
            System.out.println("Valor no válido, debe ser superior a 0");
        }
    }

    public void setDefensa(int defensa) {
        if (defensa > 0) {
            this.defensa = defensa;
        } else {
            System.out.println("Valor no válido, debe ser superior a 0");
        }
    }

    public void setDefensaEspecial(int defensaEspecial) {
        if (defensaEspecial > 0) {
            this.defensaEspecial = defensaEspecial;
        } else {
            System.out.println("Valor no válido, debe ser superior a 0");
        }
    }

    public void setNivel(int nivel) {
        if ((nivel > 0) && (nivel <= 250)) {
            this.nivel = nivel;
        } else {
            System.out.println("Valor no válido, debe ser superior a 1 e inferior a 250");
        }
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    // Otros métodos

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() +
                "\t" + nombre +
                "\t" + nivel +
                "\t" + tipo +
                "\t" + condicionExistenciaEntrenador() +
                "\t" + velocidad +
                "\t" + poder +
                "\t" + poderEspecial +
                "\t" + defensa + 
                "\t" + defensaEspecial +  
                "\t" + saludActual +
                "\t" + saludMax +
                "\t" + saludo
                ;
    }

    public String condicionExistenciaEntrenador (){
        if(entrenador==null){
            return "-";
        }else{
            return this.entrenador.getNombre();
        }
    }

    public void crearValoresBase (){
        this.setPoder ((int) ((nivel) * (Math.random()*10+6)));     
        this.setDefensa ((int) ((nivel) * (Math.random()*10+6)));
        this.setVelocidad((int) ((nivel) * (Math.random()*10+6)));        
        this.setSaludMax((int) ((nivel) * (Math.random()*10+6)));       
        this.setSaludActual((int) ((nivel) * (Math.random()*10+6)));   
        this.setPoderEspecial((int) (((nivel*1.5)) * (Math.random()*10+6)));
        this.setDefensaEspecial((int) (((nivel*1.5)) * (Math.random()*10+6)));
    }

    public Pokemon evolucionar() {
        switch (this.getClass().getSimpleName()){
            case "Charmander":
                if (this.nivel >= 3) {
                    return new Charmeleon(this.getNivel(), this.getNombre(), this);
                }
                break;
            case "Squirtle":
                if (this.nivel >= 3) {
                    return new Blastoise(this.getNivel(), this.getNombre(), this);
                }
                break;
            default: 
                return this;
        }
        return this;
    }

    public Pokemon clonarPokemon (){
        Pokemon pokemonClon = new Pokemon();
        pokemonClon.setNombre(this.getNombre());
        pokemonClon.setTipo(this.getTipo());
        pokemonClon.setEntrenador(this.getEntrenador());
        pokemonClon.setNivel(this.getNivel());
        pokemonClon.setSaludo(this.getSaludo());
        pokemonClon.setPoder(this.getPoder());
        pokemonClon.setPoderEspecial(this.getPoderEspecial());
        pokemonClon.setDefensa(this.getDefensa());
        pokemonClon.setDefensaEspecial(this.getDefensaEspecial());
        pokemonClon.setVelocidad(this.getVelocidad());
        pokemonClon.setSaludActual(this.getSaludMax());
        pokemonClon.setSaludMax(this.getSaludMax());
        pokemonClon.setMovimientos(this.getMovimientos());
        return pokemonClon;
    }
}
