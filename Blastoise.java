/**
* Blastoise Pokemon object class.
* Subclass of Charmeleon
* @author CHOW, CHI HUNG
* @since 2/19/2016
*/
public class Blastoise extends Wartortle {

   /** The minimum attack power for species. */ 
   static final int BASE_ATTACK_POWER = 186;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 222;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 158;
   
   /** Constructor with no name. */
   public Blastoise() {
      super("Blastoise", "Blastoise", 9, 1.60, 85.50, BASE_ATTACK_POWER, 
          BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Blastoise(String name) {
      super("Blastoise", name, 9, 1.60, 85.50, BASE_ATTACK_POWER, 
            BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
}
   
