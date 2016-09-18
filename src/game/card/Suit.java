package game.card;

/**
 * Enum class for Suit of card
 */
public enum Suit {
	
	/** Card suit types */
	HEARTS(1), CLUBS(2), DIAMONDS(3), SPADES(4);

	/** Value of card suit */
	private int suitValue;

	/**
	 * Constructor of Suit
	 * 
	 * @param suitValue Suit value of Card
	 */
	private Suit(int suitValue) {
		
		this.suitValue = suitValue;
	}

	/**
	 * Getter method of SuitValue
	 * 
	 * @return suitValue Suit value of Card
	 */
	public int getSuitValue() {
		
		return suitValue;
	}
}
