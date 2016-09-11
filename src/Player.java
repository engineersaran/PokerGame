import java.util.ArrayList;
import java.util.List;

/**
 * Class represents Player of Poker card game
 */
public class Player {

	/** card list in hand */
	private List<Card> cardInHand = new ArrayList<Card>();
	
	/** Rank of player */
	private int rank = 0;

	/**
	 * Getter method for providing card list in player hand
	 * 
	 * @return cardInHand Card list
	 */
	public List<Card> getCardInHand() {
		
		return cardInHand;
	}

	/**
	 * Setter method for setting card list of player hand
	 * 
	 * @param cardInHand Card list
	 */
	public void setCardInHand(List<Card> cardInHand) {
		
		this.cardInHand = cardInHand;
	}

	/**
	 * Getter method for player's rank
	 * 
	 * @return rank Player's rank
	 */
	public int getRank() {
		
		return rank;
	}

	/**
	 * Setter method for player's rank set
	 * 
	 * @param rank Player's rank
	 */
	public void setRank(int rank) {
		
		this.rank = rank;
	}

}
