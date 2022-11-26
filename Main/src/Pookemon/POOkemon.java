package Pookemon;

public class POOkemon {

    public static void main(String[] args) {
        Pokemon charmander1 = new Charmander(10, "chari");
  
        System.out.println(charmander1.toString());
        
               
        System.out.println((charmander1.evolucionar()).toString());
    }
}
