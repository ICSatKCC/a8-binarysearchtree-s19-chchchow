import java.util.Random;
/**
* Squirtle Pokemon object class.
* One type Water implements one type interfaces
* Parent class to Charmaleon 
* @author CHOW, CHI HUNG
* @since 2/12/2019
*/

public class Squirtle extends Pokemon implements WaterType {
   
   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 112;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 142;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 88;
   /** Empty String for one type species, hint from review partner.*/
   static final String SECOND_TYPE = "";

   
   /** Indicator for fast attack type. */
   protected boolean fastIsWater = true;
   /** Indicator for special attack type. */
   protected boolean specialIsWater = true;

   
   /**
   * Constructor with no name.
   * uses Pokemon superclass constructor
   * attacks must be set after contruction of Pokemon Object
   * because of dependence on type interface
   */
   public Squirtle() {
      super("Squirtle", "Squirtle", 7, WATER_COLOR, 0.5, 9.0, 
         WATER_TYPE, SECOND_TYPE, BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
      //pick Attacks after construct
      chooseFastAttack();
      chooseSpecialAttack();
   }
   /**
   * Constructor with name.
   * uses Pokemon superclass constructor
   * attacks must be set after contruction of Pokemon Object
   * because of dependence on type interface
   * @param name The user-defined name.
   */
   public Squirtle(String name) {
      super("Squirtle", name, 7, WATER_COLOR, 0.5, 9.0, 
         WATER_TYPE, SECOND_TYPE, BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      //pick Attacks
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /** 
   * Constructor with species and name for subclasses.
   * This allows subclass specific name, number, height, weight, and basePowers 
   * to pass through to Pokemon superclass constructor
   *@param species The Pokemon's species.
   *@param name The optional user-given name.
   *@param num The Pokedex number for this species.
   *@param ht The height of this Pokemon.
   *@param wt The weight of this Pokemon. 
   *@param baseAttackPwr The low limit of Attack Power for species.
   *@param baseDefensePwr The low limit of Defense Power for species.
   *@param baseStaminaPwr The low limit of Stamina Power for speices. 
   */
   protected Squirtle(String species, String name, int num, 
       double ht, double wt, int baseAttackPwr, int baseDefensePwr, 
       int baseStaminaPwr) {
       
      super(species, name, num, WATER_COLOR, ht, wt, WATER_TYPE, WATER_TYPE, 
         baseAttackPwr, baseDefensePwr, baseStaminaPwr);
      //pick Attacks
      //can happen here because all subclasses are same types as Bulbasaur
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   /**
   * Grass|Poison-type specific fast attack chooser.
   * Randomly picks whether attack type is grass or poison
   * Randomly picks an attack from type attack arrays
   */
   protected void chooseFastAttack() {
      //randomly choose to get grass or poison attack
      Random randGen = new Random();
      int index;
      //set attack type boolean
      fastIsWater = randGen.nextBoolean();
      
      index = randGen.nextInt(WATER_FAST_ATTACKS.length);
      fastAttack = WATER_FAST_ATTACKS[index];
      fastAttackPower = WATER_FAST_ATK_POWER[index];
   
   }
   
  /**
   * Grass|Poison-type specific special attack chooser.
   * Randomly picks whether attack type is grass or poison
   * Randomly picks an attack from type interface attack arrays
   */
   protected void chooseSpecialAttack() {
      //randomly choose to get grass or poison attack
      Random randGen = new Random();
      int index;
      //set type choice boolean
      specialIsWater = randGen.nextBoolean();
      
      index = randGen.nextInt(WATER_SPECIAL_ATTACKS.length);
      specialAttack = WATER_SPECIAL_ATTACKS[index];
      specialAttackPower = WATER_SPECIAL_ATK_POWER[index];
   }
   
   /**
   * Game-play fast attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * Calls beAttacked method on attacked victim.
   *
   * @param victim the Pokemon being attacked
   * @return String explaining attack and effectiveness
   */
   public String performFastAttack(Pokemon victim) {
      
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;      
      s = name + " performed " + fastAttack + " on " + victim.getSpecies();
      
      if (vType.equals("Ground") || vType.equals("Rock") 
             || vType.equals("Fire")) {
            
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;
      } else if (vType.equals("Water") || vType.equals("Grass") 
             || vType.equals("Dragon")) { 
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (specialAttackPower + 2) * modifier;  
             
      victim.beAttacked((int) damage);
      return s;
   }
   
  /**
   * Game-play special attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * uses Damage formula from here: 
   * http://bulbapedia.bulbagarden.net/wiki/Damage
   * Calls beAttacked method on attacked victim.
   * @param victim the Pokemon being attacked.
   * @return String explaining attack and effectiveness.
   */
   public String performSpecialAttack(Pokemon victim) {
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;       
      s = name + " performed " + specialAttack + " on " + victim.getSpecies();
      
      if (vType.equals("Ground") || vType.equals("Rock") 
             || vType.equals("Fire")) {
            
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;
      } else if (vType.equals("Water") || vType.equals("Grass") 
             || vType.equals("Dragon")) { 
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
      damage = (((2 * level) + 10) / damageDivisor) 
          * attackPower * (specialAttackPower + 2) * modifier;
     
      victim.beAttacked((int) damage);
      return s;
   }
   
   /**
   * Reduces Pokemon's HP by damage/defensePower.
   * Doesn't allow HP to go less than 0
   * Implementation of "fainting" not done here
   * @param damage Hit points to take off HP
   */
   protected void beAttacked(int damage) {
      //part of bulbapedia damage formula
      damage = damage / defensePower;
      
      if (hP > damage) {
         hP = hP - damage;
      } else {
         hP = 0; //"Pokemon fainted"
      }
   }
   
}     


