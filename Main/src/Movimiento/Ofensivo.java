package Movimiento;

import Pookemon.*;

public class Ofensivo extends Movimiento {

    public Ofensivo(String nombre) { //Cambiar valores por unos más altos.
        switch (nombre) {
            case "Barrido":
                this.nombre = nombre;
                this.tipo = "Fuego";
                this.usos = 0;
                this.usosMaximos = 20;
                this.valor = 100;
                this.usoEspecial = false;
                break;
            case "BarridoEsp":
                this.nombre = nombre;
                this.tipo = "Fuego";
                this.usos = 0;
                this.usosMaximos = 20;
                this.valor = 7;
                this.usoEspecial = true;
                break;
            case "lanzasemen":
                this.nombre = nombre;
                this.tipo = "Planta";
                this.usos = 0;
                this.usosMaximos = 25;
                this.valor = 100;
                this.usoEspecial = false;
                break;
            case "lanzasemenEsp":
                this.nombre = nombre;
                this.tipo = "Planta";
                this.usos = 0;
                this.usosMaximos = 25;
                this.valor = 4;
                this.usoEspecial = true;
                break;
            case "aguabendita":
                this.nombre = nombre;
                this.tipo = "Agua";
                this.usos = 0;
                this.usosMaximos = 25;
                this.valor = 100;
                this.usoEspecial = false;
                break;
            case "aguabenditaEsp":
                this.nombre = nombre;
                this.tipo = "Agua";
                this.usos = 0;
                this.usosMaximos = 25;
                this.valor = 10;
                this.usoEspecial = true;
                break;
            case "culo":
                this.nombre = nombre;
                this.tipo = "Normal";
                this.usos = 0;
                this.usosMaximos = 25;
                this.valor = 10;
                this.usoEspecial = false;
                break;
            case "culoEsp":
                this.nombre = nombre;
                this.tipo = "Normal";
                this.usos = 0;
                this.usosMaximos = 25;
                this.valor = 10;
                this.usoEspecial = true;
                break;
        }
    }

    @Override
    public void activar(Pokemon pok1, Pokemon pok2) {
        if (this.usos < this.usosMaximos) {
            System.out.println();
            System.out.print("SALUD " + pok2.getNombre() + " = " + pok2.getSaludActual());
            
            int dano = (int)damage(pok1, pok2);
            pok2.setSaludActual((int)(pok2.getSaludActual() - dano));
            
            System.out.println("HP --> " + pok2.getSaludActual() + "HP (DAÑO hecho por "+ pok1.getNombre() +" - " + dano +")");
            
            usos++;
        }
    }

    private double damage(Pokemon pookemon1, Pokemon pookemon2) {
        double modEfecto;
        double x = Math.floor(Math.random() * (85 - 100 + 1) + 100);
        double CH = Math.floor(Math.random() * (0 - 100 + 1) + 100);
        if (CH < 95) {
            CH = 1;
        } else {
            CH = 1.5;
        }

        if (pookemon1.getTipo() == "Fuego") {
            if (pookemon2.getTipo() == "Fuego" || pookemon2.getTipo() == "Agua") {
                modEfecto = 0.5;
            } else if (pookemon2.getTipo() == "Planta") {
                modEfecto = 2;
            } else {
                modEfecto = 1;
            }

        } else if (pookemon1.getTipo() == "Agua") {
            if (pookemon2.getTipo() == "Agua" || pookemon2.getTipo() == "Planta") {
                modEfecto = 0.5;
            } else if (pookemon2.getTipo() == "Fuego") {
                modEfecto = 2;
            } else {
                modEfecto = 1;
            }

        } else if (pookemon1.getTipo() == "Planta") {
            if (pookemon2.getTipo() == "Fuego" || pookemon2.getTipo() == "Planta") {
                modEfecto = 0.5;
            } else if (pookemon2.getTipo() == "Agua") {
                modEfecto = 2;
            } else {
                modEfecto = 1;
            }
        } else {
            modEfecto = 1;
        }

        if (this.usoEspecial) {
            return (((((2 * pookemon1.getNivel() / 5 + 2) * this.valor * pookemon1.getPoderEspecial()/ pookemon2.getDefensaEspecial()) / 50) * 2) * modEfecto * x / 100) * CH;
        } else {
            return (((((2 * pookemon1.getNivel() / 5 + 2) * this.valor * pookemon1.getPoder() / pookemon2.getDefensa())/ 50) * 2) * modEfecto * x / 100) * CH;
        }
    }
}