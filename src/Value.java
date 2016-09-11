/**
 *Enum class for Value of card
 */
public enum Value {

  /** Value of Card */
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  JACK(11),
  QUEEN(12),
  KING(13),
  ACE(14);
  
  /** Value of Card */
  private int suitValue;
  
  
  /**
   * Constructor for Value of Card
   * 
   * @param suitValue Value of Card
   */
	private Value (int suitValue) {
		
	    this.suitValue = suitValue;
	}
  
	/**
	 * Getter method for getting value of card
	 * 
	 * @return suitValue Value of card
	 */
	public int getSuitValue() {
		  
	    return suitValue;
	}
}
