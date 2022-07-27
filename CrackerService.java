import java.io.IOException;
// import src.CrackerFactory;
// import src.Cracker;

import java.util.*;

public class CrackerService {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = (String)args[0];
        String email = (String)args[1];
        CrackerFactory crackerFactory = new CrackerFactory();
        Scanner sc = new Scanner(System.in);
        Cracker cracker = null;
        System.out.println("Veuiller choisir l'algo a utiliser");
        System.out.println("1\tAttack par Brute force\n2\tAttack par Dictionaire");
        int choix = sc.nextInt();

        switch(choix) {
            case 1: 
            cracker = crackerFactory.algo("BRUTE_FORCE");
            cracker.hack(url,email);
                break;
            
            case 2 :
            cracker = crackerFactory.algo("DICTIONNARY");
            cracker.hack(url,email);
                break;
            
            default : 
            System.out.println("choix Incorrect");
            sc.close();
    
    
        }


    }
}
