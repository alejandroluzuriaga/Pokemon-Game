import Mundo.*;
import Pookemon.Bulbasur;

public class Main{

    public static void main (String [] args){
        new Mundo();
        Bulbasur bul = new Bulbasur(1, "pepe");
        if(bul.getClass().getSimpleName().equals("Bulbasur")){
            System.out.println("pito");
        }
    }

}