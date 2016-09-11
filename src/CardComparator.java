import java.util.Comparator;


/**
 * Comparator class for sorting CardList based on value of card
 */
public class CardComparator implements Comparator<Card> {

	/**
	 * Compares its two arguments for order. 
	 * Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, 
	 * or greater than the second
	 * 
	 * @return negative integer, zero, or a positive integer
	 */
	@Override
	  public int compare(Card o1, Card o2) {
		
	    return ((Integer)o1.getValue().getSuitValue()).compareTo(o2.getValue().getSuitValue());
	  }
}
