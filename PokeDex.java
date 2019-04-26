import java.util.*; 
/**
 * ICS 211 Assignment 8 PokeDex.
 * @author CHOW, CHI HUNG
 * @since 4/22/2019
 */
public class PokeDex {

 /** 
   * main method.
   * driver class.
   * @param args not used
   */
   public static void main(String[] args) {
   
      String sTemp = ""; 
      Scanner reader = new Scanner(System.in);
      int x = 0;
      boolean endLoop = false; 
      
      PokeTree<Pokemon> pTree = new PokeTree<Pokemon>();
   
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
               pTree.add(makePokemon());
               break; 
            case "2": 
               pTree.remove(makePokemon());
               break;   
            case "3": 
               System.out.println("inorder:\n" + pTree.toString());                  
               break;      
            default: //not a valid menu entry
               System.out.println("\n****Invalid menu choice.****");
               System.out.println("Please enter a 0, 1, or 2\n");
               break;   
         }
      }     
   
   }
   /**
   * make pokemon static.
   * for choosing pokemon in option 1 & 2.
   *@return null
   */
   public static Pokemon makePokemon() {
      Scanner scan = new Scanner(System.in);
      String name = "";
      boolean endLoop2 = false; 
      while (!endLoop2) { 
         System.out.println("Please choose your own pokemon:");
         System.out.println("1.Bulbasaur");
         System.out.println("2.Ivysaur");
         System.out.println("3.Venusaur");
         System.out.println("4.Charmander");
         System.out.println("5.Charmeleon");
         System.out.println("6.Charizard");
         System.out.println("7.Squirtle");
         System.out.println("8.Wartortle");
         System.out.println("9.Blastoise");
         System.out.println("Please choose from 1-9:");
         String species = scan.nextLine();
         species = species.trim();
         System.out.println("Press enter or type in a name for your pokemon.");
         name = scan.nextLine();
         switch (species) {
            case "1":
               if (name.length() > 0) {
                  Pokemon a = new Bulbasaur(name);
                  return a;
               } 
               else {
                  Pokemon b = new Bulbasaur();
                  return b;
               }
            case "2":
               if (name.length() > 0) {
                  Pokemon c = new Ivysaur(name);
                  return c;
               } else {
                  Pokemon d = new Ivysaur();
                  return d;
               }
            case "3":
               if (name.length() > 0) {
                  Pokemon e = new Venusaur(name);
                  return e;
               } else {
                  Pokemon f = new Venusaur();
                  return f;
               }
            case "4":
               if (name.length() > 0) {
                  Pokemon g = new Charmander(name);
                  return g;
               } else {
                  Pokemon h = new Charmander();
                  return h;
               }
            case "5":
               if (name.length() > 0) {
                  Pokemon i = new Charmeleon(name);
                  return i;
               } else {
                  Pokemon j = new Charmeleon();
                  return j;
               }
            case "6":
               if (name.length() > 0) {
                  Pokemon k = new Charizard(name);
                  return k;
               } else {
                  Pokemon l = new Charizard();
                  return l;
               }
            case "7":
               if (name.length() > 0) {
                  Pokemon m = new Squirtle(name);
                  return m;
               } else {
                  Pokemon n = new Squirtle();
                  return n;
               }            
            case "8":
               if (name.length() > 0) {
                  Pokemon o = new Wartortle(name);
                  return o;
               } else {
                  Pokemon p = new Wartortle();
                  return p;
               }          
            case "9":
               if (name.length() > 0) {
                  Pokemon q = new Blastoise(name);
                  return q;
               } else {
                  Pokemon r = new Blastoise();
                  return r;
               }
            default: //not a valid menu entry
               System.out.println("\n****Invalid menu choice.****");
               System.out.println("No sufficient species selection");
               System.out.println("Please only select from 1~9");
         }   
      }
      System.out.println("****You have chosen and made your own pokemon****");
      return null; 
   } //end make pokemon. 

}