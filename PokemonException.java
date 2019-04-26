/**
* Exception for Pokemon class.
* @author CHOW, CHI HUNG 
* @since 11/18/2018
*/
public class PokemonException extends RuntimeException {

  /**
  * Constructor. 
  * @param newMessage The error message to be sent.
  */
   public PokemonException(String newMessage) {
      super(newMessage);
   }
}