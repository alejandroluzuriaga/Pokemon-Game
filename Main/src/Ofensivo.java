public class Ofensivo extends Movimiento{
    
    public Ofensivo (String nombre) {
        switch (nombre){
            case "Barrido":
                this.nombre=nombre;
                this.tipo="Fuego";
                this.usos=0;
                this.usosMaximos=20;
                this.valor=7;
                this.usoEspecial=false;
            break;
            case "lanzasemen":
                this.nombre=nombre;
                this.tipo="Planta";
                this.usos=0;
                this.usosMaximos=25;
                this.valor=4;
                this.usoEspecial=true;
            break;
            case "aguabendita":
                this.nombre=nombre;
                this.tipo="Agua";
                this.usos=0;
                this.usosMaximos=25;
                this.valor=10;
                this.usoEspecial=true;
            break;
        }
    }

    @Override
    public void activar (Pookemon pok1, Pookemon pok2){
        if (this.usos<this.usosMaximos){
            pok2.setSaludActual((int)(pok2.getSaludActual() - Damage(pok1, pok2)));
            usos++;
        } 
    }

    private double Damage (Pookemon pookemon1, Pookemon pookemon2){
        double modEfecto;
        double x = Math.floor(Math.random()*(85-100+1)+100);
        double CH = Math.floor(Math.random()*(0-100+1)+100);
        if (CH<95){CH=1;}else{CH=1.5;}

        if (pookemon1.getTipo() == "Fuego"){
          if (pookemon2.getTipo() == "Fuego" || pookemon2.getTipo() =="Agua"){
              modEfecto = 0.5;
          } else if (pookemon2.getTipo() == "Planta"){
              modEfecto = 2;
          } else{
              modEfecto = 1;
          }
          
        } else if(pookemon1.getTipo() == "Agua"){
          if (pookemon2.getTipo() == "Agua" || pookemon2.getTipo() == "Planta"){
              modEfecto = 0.5;
          } else if (pookemon2.getTipo() == "Fuego"){
              modEfecto = 2;
          } else{
              modEfecto = 1;
          }
          
        } else if (pookemon1.getTipo() == "Planta"){
          if (pookemon2.getTipo() == "Fuego" || pookemon2.getTipo() == "Planta"){
              modEfecto = 0.5;
          } else if (pookemon2.getTipo() == "Agua"){
              modEfecto = 2;
          } else{
              modEfecto = 1;
          }
        } else{modEfecto = 1;}
        
        if (this.usoEspecial){
            return (((((2*pookemon1.getNivel()/5+2)*this.valor*pookemon1.getPoderEspecial()/pookemon2.getDefensaEspecial())/50)*2)*modEfecto*x/100)*CH;
        }else{
            return (((((2*pookemon1.getNivel()/5+2)*this.valor*pookemon1.getPoder()/pookemon2.getDefensa())/50)*2)*modEfecto*x/100)*CH;
        }
  }

}