package game.card;

/**
 * Class represents Card which contains Suit and Value
 */
public class Card {
	
	/** Card Suit */
	private Suit suit;
	
	/** Card Value */
	private Value value;
	
	/**
	 * Card Constructor 
	 * 
	 * @param suit Suit of card 
	 * @param value Value of card
	 */
	public Card(Suit suit, Value value) {
		
		this.suit = suit;
		this.value = value;
	}
	
	/**
	 * Getter method for Suit of card
	 * 
	 * @return Suit Suit of card
	 */
	public Suit getSuit() {
		
		return suit;
	}

	/**
	 * Getter method for Value of Card
	 * 
	 * @return Value Value of Card
	 */
	public Value getValue() {
		
		return value;
	}

	@Override
	public String toString() {
		
		return value.name()+" of "+suit.name();
	}
}
