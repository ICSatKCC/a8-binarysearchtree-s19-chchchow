/**
* Charizard Pokemon object class.
* Subclass of Charmeleon
* @author CHOW, CHI HUNG
* @since 2/19/2016
*/
public class Charizard extends Charmeleon implements FlyingType {

   /** The minimum attack power for species. */ 
   static final int BASE_ATTACK_POWER = 212;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 182;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 156;
   
   /** Constructor with no name. */
   public Charizard() {
      super("Charizard", "Charizard", 6, 1.7, 90.5, BASE_ATTACK_POWER, 
          BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Charizard(String name) {
      super("Charizard", name, 6, 1.7, 90.5, BASE_ATTACK_POWER, 
            BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
}
   
