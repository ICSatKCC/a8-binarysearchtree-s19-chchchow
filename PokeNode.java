/**
 * ICS 211 Assignment 8 PokeNode.
 * @author CHOW, CHI HUNG
 * @since 4/20/2019
 * @param <E> The datatype held in Nodes.
 */
public class PokeNode<E> {
	// data fields
  /** Data held in Node. */
   private Pokemon pokeData;
   /**Number of caught pokemon.*/
   private int numCaught;
   /** Link to left child Node. */
   private PokeNode lChild;
   /** Link to right child Node. */
   private PokeNode rChild; 
   
   
	/**
	 * Constructor.
	 * @param pokeData The address of the object that is stored by the node
    * @param numCaught The number of caught pokemon. 
	 * @param lChild The address of the left child
	 * @param rChild The address of the right child
	 */
   public PokeNode(Pokemon pokeData, int numCaught, PokeNode lChild, 
          PokeNode rChild) {
      pokeData = new Squirtle();
      numCaught = 1;
      lChild = null;
      rChild = null;
   }   
   
	/**
	 * Automatically called by println() or print() method.
	 * 
	 * @return the item's string
	 */
   public String toString() {
      String display = pokeData.toString();
      return display;
   }

   /**
   * Get method for pokeData.
   * @return pokeData
   */
   public Pokemon getPokeData() {
      return pokeData;
   }
   
   /**
   * Get method for numCaught.
   * @return numCaught
   */
   public int getNumCaught() {
      return numCaught;
   }
   
   /**
   * Get method for lChild.
   * @return lChild
   */
   public PokeNode getLChild() {
      return lChild;
   }
   
   /**
   * Get method for rChild.
   * @return rChild
   */
   public PokeNode getRChild() {
      return rChild;
   }

   /**
	* This method will increment the numCaught in a node.
   */
   public void increaseNumCaught() {
      numCaught++;
   }
   
   /**
   * This method will decrement numCaught in a given node.
   * @throws PokemonException if numCaught becomes < 1
   */
   public void decreaseNumCaught() throws PokemonException {
      if (numCaught < 1) {
         throw new PokemonException("No pokemon caught");
      } else {
         numCaught--;
      }
   }
   
  /**
  * This method will set newLNode as the left child of a node.
  * @param newLChild set to LChild.
  */
   public void setLChild(PokeNode newLChild) {
      lChild = newLChild;
   }
  /**
  * This method will set newRNode as the right child of a node.
  * @param newRChild set to rChild.
  */
   public void setRChild(PokeNode newRChild) {
      rChild = newRChild;
   }
   
   
   
   
   
} // end of class