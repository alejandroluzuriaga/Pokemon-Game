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
        return "Pokemon{" +
                "\t\n nombre: " + nombre +
                "\t\n Nivel: " + nivel +
                "\t\n Tipo: " + tipo +
                "\t\n Entrenador: " + entrenador.getNombre() +
                "\t\n Saludo: " + saludo + 
                "\t\n Velocidad: " + velocidad +
                "\t\n Poder: " + poder +
                "\t\n PoderEspecial: " + poderEspecial +
                "\t\n Defensa: " + defensa + 
                "\t\n DefensaEspecial: " + defensaEspecial +  
                "\t\n SaludActual: " + saludActual +
                "\t\n SaludMax: " + saludMax + 
                '}';
    }

    public Pokemon evolucionar() {
        String opcion = this.getClass().getSimpleName();
        switch (opcion){
            case "Charmander":
                if (this.nivel >= 10) {
                    System.out.println("");
                    System.out.println("****CHARMANDER EVOLUCIONA A CHARMELEON****");
                    System.out.println("");
                    return new Charmeleon(11, "Charmeleon1", this);
                    
                } else {
                    System.out.println("No tienes suficiente nivel para evolucionar. Te quedas con el que estás");
                    return this;
                }
                
            case "Squirtle":
                if (this.nivel >= 10) {
                    System.out.println("");
                    System.out.println("****SQUIRTLE EVOLUCIONA A BLASTOISE****");
                    System.out.println("");
                    return new Blastoise(11, "Blastoise1", this);
                } else {
                    System.out.println("No tienes suficiente nivel para evolucionar. Te quedas con el que estás");
                    return this;
                }

            default: 
                System.out.println("No existe evolución para ese Pokemon. Te quedas con el que estás");
                return this;
        }
    }
}
