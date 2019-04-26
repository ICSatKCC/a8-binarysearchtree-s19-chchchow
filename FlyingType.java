/**
* interface for Flying type Pokemon.
* Fails checkstyle because no methods.
* @author CHOW, CHI HUNG
* @since 2/14/2019
*/
public interface FlyingType {
   /** constants **/
   /** Type name String. */
   String FLYING_TYPE = new String("Flying");
   /** Type color String. */
   String FLYING_COLOR = new String("Lavender");
   /** Array of type fast attack names. */
   String[] FLYING_FAST_ATTACKS = {"Peck", "Wing Attack"};
   /** Array of type special attack names. */
   String[] FLYING_SPECIAL_ATTACKS = {"Aerial Ace", "Air Cutter", 
      "Drill Peck", "Hurricane"};
   /** Array of fast attack powers, coincides with name array. */
   int[] FLYING_FAST_ATK_POWER = {10, 9};
   /** Array of special attack powers, coincides with name array. */      
   int[] FLYING_SPECIAL_ATK_POWER = {30, 30, 40, 80};

}