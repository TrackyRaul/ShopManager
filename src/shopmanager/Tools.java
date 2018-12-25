package shopmanager;

import java.util.Scanner;

/**
 *
 * @author Raul Farkas
 */
public class Tools {

    /**
     * Chiedi l'input da parte dell'utente e ritornalo come stringa
     * 
     * @param prompt
     * @return
     */
    public static String input(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String input = sc.nextLine();
        
        
        
        return input;
    }
    
    /**
     * Stampa una stringa
     * 
     * @param stringa
     */
    public static void print(String stringa){
        System.out.print(stringa);
    }
    
    /**
     * Stampa la stringa e vai a capo
     * 
     * @param stringa
     */
    public static void println(String stringa){
        System.out.println(stringa);
    }
    
}
