/**
 * ICS 211 Assignment 8 PokeNode.
 * @author CHOW, CHI HUNG
 * @since 4/22/2019
 * @param <T> The datatype held in Nodes.
*/
public class PokeTree<T extends java.lang.Comparable<Pokemon>> {

  /** Root node instance variable. */
   private PokeNode<Pokemon> root = null;

  /** Empty PokeTree constructor. */
   public PokeTree() {
   }
   
   /**
   *calling the private recursive add method with root.
   *@param p the pokemon added
   */
   public void add(Pokemon p) {
      root = add(root, p);
   }
   
   /**
   *Recursive add method.
   *make a new node and put Pokemon p in it with numCaught = 1 
   *increment numCaught if Pokemon p already is in the tree
   *@param n the root node
   *@param p the pokemon
   *@return n the node
   */
   private PokeNode add(PokeNode n, Pokemon p) {
   
   
   
   
   }
   
   /**
   * Public wrapper method that calles recursive method with root.
   * @param searchKey the search key.
   * @return the matching data.
   */
   public Pokemon get(Pokemon searchKey) {
      return this.get(root, searchKey);
   }
     
     /**
   * Recursive methog to get an item from the tree.
   * @param n The root node.
   * @param searchKey the search key.
   * @return the matching data.
   * @throws PokemonException if not found
   */
   private Pokemon get(PokeNode<Pokemon> n, Pokemon searchKey) {
      if (n == null) {
         throw new PokemonException("MIA");
      } 
      else {
         if (searchKey.compareTo(n.getPokeData()) == 0) {
            return n.getPokeData();
         }
         else if (searchKey.compareTo(n.getPokeData()) < 0) {
            return this.get(n.getLChild(), searchKey);
         }
         else {
            return this.get(n.getRChild(), searchKey);
         }
      }
   }  
   
   private void printPokeTree(PokeNode root){
      if(root != null){
         System.out.println("  " + root.addPokemon( ).toString() + "\nCaught: "+root.getNumCaught( ) );
         printPokeTree(root.getLChild());
         printPokeTree(root.getRChild());
      }
   }
}