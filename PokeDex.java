import java.util.*; 
/**
 * ICS 211 Assignment 8 PokeDex.
 * @author CHOW, CHI HUNG
 * @since 4/22/2019
 */
public class PokeDex {

 /** 
   * main method.
   * @param args not used
   */
   public static void main(String[] args) {
   
      String sTemp = ""; 
      Scanner reader = new Scanner(System.in);
      int x = 0;
      boolean endLoop = false; 
   
      while (!endLoop) {
         System.out.println("---HELLO,WELCOME---");
         System.out.println("Please enter the number of your choice:");
         System.out.println("1. Catch Pokemon");
         System.out.println("2. Trade Pokemon.");
         System.out.println("3. Print Pokedex");
         System.out.println("0. Exit the program");
         System.out.println("What would you like to do? ");   
         sTemp = reader.nextLine();
         sTemp = sTemp.trim();
         switch (sTemp) {
            case "0": 
               endLoop = true;
               System.out.println("Good bye!");
               break;
            case "1":  
                     //
               break; 
            case "2": 
               //
               break;   
            case "3": 
               //
               break;      
            default: //not a valid menu entry
               System.out.println("\n****Invalid menu choice.****");
               System.out.println("Please enter a 0, 1, or 2\n");
               break;   
         }
      }     
   
   
   
   
   }


}