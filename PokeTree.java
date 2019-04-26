/**
 * ICS 211 Assignment 8 PokeTree.
 * @author CHOW, CHI HUNG
 * @since 4/22/2019
 * @param <T> The datatype held in Nodes.
*/
public class PokeTree<T extends java.lang.Comparable<Pokemon>> {

  /** Root n instance variable. */
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
   *make a new n and put Pokemon p in it with numCaught = 1 
   *increment numCaught if Pokemon p already is in the tree
   *@param n the root n
   *@param p the pokemon
   *@return n the n
   */
   private PokeNode add(PokeNode<Pokemon> n, Pokemon p) {
   
      if (n == null)
      {
         return new PokeNode<Pokemon>(p, 0, null, null);
      }
         //Otherwise duplicate the n and throw an exception.
      else if (p.compareTo(n.getPokeData()) == 0)
      {
         throw new PokemonException("Duplicate items is not allowed!!!");      
      }
      else if (p.compareTo(n.getPokeData()) < 0)
      {
         n.setLChild(this.add(n.getLChild(), p));
         return n;
      }
      else
      {
         n.setRChild(this.add(n.getRChild(), p));
         return n;
      }
   }
         
   /**
   * called automatically by println/print method.
   * 
   * @return an inorder String of the tree
   */
   public String toString() {
      return this.inOrder(root);
   }
	

   /**
   * inOrder display of ns, with newline between each n.
   * 
   * @param n The root of the tree/subtree
   * @return an inorder String of the tree
   */
   private String inOrder(PokeNode<Pokemon> n) {
      String displayNodes = "";
      if (n != null) {
         displayNodes = displayNodes 
            + this.inOrder(n.getLChild());
         displayNodes = displayNodes + n.toString() + "\n";
         displayNodes = displayNodes 
            + this.inOrder(n.getRChild());
      }
      return displayNodes;
   }
   
   /**
   * Pre-Order traversal of tree.
   * 
   * @return String representation of preOrder
   */
   public String preOrder() {
      return this.preOrder(root);
   }

  /**
   * Recursive preOrder traversal of tree.
   * 
   * @param n The root of the tree/subtree
   * @return a preOrder String of the tree
   */
   private String preOrder(PokeNode<Pokemon> n) {
      String displayNodes = "";
      if (n != null) {
         displayNodes = displayNodes + n.toString() + "\n";
         displayNodes = displayNodes
            + this.preOrder(n.getLChild());
         displayNodes = displayNodes 
            + this.preOrder(n.getRChild());
      }
      return displayNodes;
   }

  /**
   * Post-Order traversal of tree.
   * 
   * @return a postOrder String of the tree
   */
   public String postOrder() {
      return this.postOrder(root);
   }

  /**
   * Recursive postOrder traversal of tree.
   * To display ns, with newline between each n
   * 
   * @param n The root of the tree/subtree
   * @return a post-Order String of the tree
   */
   private String postOrder(PokeNode<Pokemon> n) {
      String displayNodes = "";
      if (n != null) {
         displayNodes = displayNodes + this.postOrder(n.getLChild());
         displayNodes = displayNodes + this.postOrder(n.getRChild());
         displayNodes = displayNodes + n + "\n";
      }
      return displayNodes;
   }
   
   /**
   * Public wrapper method that calles recursive method with root.
   * @param searchKey1 the search key.
   * @return the matching data.
   */
   public Pokemon get(Pokemon searchKey1) {
      return this.get(root, searchKey1);
   }
     
   /**
   * Recursive methog to get an item from the tree.
   * @param n The root n.
   * @param searchKey2 the search key.
   * @return the matching data.
   * @throws PokemonException if not found
   */
   private Pokemon get(PokeNode<Pokemon> n, Pokemon searchKey2) {
      if (n == null) {
         throw new PokemonException("No duplicated item allowed");
      } 
      else {
         if (searchKey2.compareTo(n.getPokeData()) == 0) {
            return n.getPokeData();
         }
         else if (searchKey2.compareTo(n.getPokeData()) < 0) {
            return this.get(n.getLChild(), searchKey2);
         }
         else {
            return this.get(n.getRChild(), searchKey2);
         }
      }
   }  

   /**
   * Removes an item from the tree.
   * 
   * @param searchKey3 An object storing the key to remove.
   */
   public void remove(Pokemon searchKey3) {
      root = this.remove(root, searchKey3);
   }
	
	/**
   * Recursively removes an item from the tree.   
   * 
   * @param n The root of the tree/subtree
   * @param searchKey4 An object storing only the key to remove.
   * @return root of current subtree.
   * @throws PokemonException if item not found in tree.
   */
   private PokeNode<Pokemon> remove(PokeNode<Pokemon> n, Pokemon searchKey4) {
     //throws pokemon exception if no item found.
      if (n == null) {
         throw new PokemonException("Item does not exist!!!");
      }
       //If the key is less than root, move to left side
      else if (searchKey4.compareTo(n.getPokeData()) < 0) {
         n.setLChild(this.remove(n.getLChild(), searchKey4));
         return n;
      }
      //If the search key is greater than root, move to the right 
      else if (searchKey4.compareTo(n.getPokeData()) > 0) {
         n.setRChild(this.remove(n.getRChild(), searchKey4));
         return n;
      }
      //If identical key is found, remove 
      else {
         n = this.remove(n);
         return n;
      }
   }
	
  /**
   * Helper method that takes a node out of tree.
   * 
   * @param n The node to remove
   * @return The node that replaces removed node or null.
   */
   private PokeNode<Pokemon> remove(PokeNode<Pokemon> n)
   {
      //If the n is a leaf, return null.
      if (n.getLChild() == null && n.getRChild() == null) {
         return null;
       //If n has a single left child node, return to left child node.
      } else if (n.getRChild() == null) {
         return n.getLChild();
      
      //If n has a single right child node, return to right child node.
      } else if (n.getLChild() == null) {
         return n.getRChild();
      } else {
      // if the node has two child nodes
         Pokemon treeBig = this.getTreeBig(n.getLChild());
         // replace the node's item with this item
         n.setPokeData(treeBig);
         // delete the rightmost node in the left subtree
         n.setLChild(this.removeTreeBig(n.getLChild()));
         return n;
      }
   }
  /**
   * Returns the item with the largest search key in the (sub)tree.
   * Helper method for removing interior nodes.
   * @param n The root of the tree/subtree
   * @return The data item with largest key
   */
   private Pokemon getTreeBig(PokeNode<Pokemon> n) {
      // if no right child, then this node contains the largest item
      if (n.getRChild() == null) {
         return n.getPokeData();
      
      // if not, keep looking on the right
      } else {
         return this.getTreeBig(n.getRChild());
      }
   }
   
	/**
   * Removes the node with the largest search key.
   * Helper method for removing interior nodes.
   * Remove the node formerly occupied by item with largest search key.
   * To be called after item is moved to new node location.
   * 
   * @param n The root of the tree/subtree
   * @return root of (sub)tree with node removed.
   */
   private PokeNode<Pokemon> removeTreeBig(PokeNode<Pokemon> n) {
      //No right child, largest node found, replace with node to the left.
      if (n.getRChild() == null) {
         return n.getLChild();
       // if not, keep looking on the right
      } else {
         n.setRChild(this.removeTreeBig(n.getRChild()));
         return n;
      }
   }
   
   
}