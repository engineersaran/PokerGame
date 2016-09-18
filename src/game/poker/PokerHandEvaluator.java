package game.poker;

import game.card.Card;
import game.card.CardComparator;
import java.util.Collections;
import java.util.List;

/**
 * Class represents Poker hand evaluator
 *
 */
public class PokerHandEvaluator {
	
	
	/**
	 * Method to check poker hand is Flush or not
	 * 
	 * @param cardList Card list of player
	 * @return true/false
	 */
	public static boolean isFlush(List<Card> cardList) {

		// 5 cards of the same suit
		if (cardList.get(PokerConstants.ZERO).getSuit().getSuitValue() == cardList.get(PokerConstants.ONE).getSuit().getSuitValue()
				&& cardList.get(PokerConstants.ONE).getSuit().getSuitValue() == cardList.get(PokerConstants.TWO).getSuit().getSuitValue()
				&& cardList.get(PokerConstants.TWO).getSuit().getSuitValue() == cardList.get(PokerConstants.THREE).getSuit().getSuitValue()
				&& cardList.get(PokerConstants.THREE).getSuit().getSuitValue() == cardList.get(PokerConstants.FOUR).getSuit().getSuitValue()) {

			// Poker hand is Flush
			return true;
		}

		// Poker hand is not Flush
		return false;
	}

	
	/**
	 * Method to check poker hand is Straight or not
	 * 
	 * @param cardList Card list of player
	 * @return true/false
	 */
	public static boolean isStraight(List<Card> cardList) {

		/** result flag */
		boolean result = false;

		// Sorting the card list in ascending order
		Collections.sort(cardList, new CardComparator());

		// Check card list contains ACE
		if (cardList.get(PokerConstants.FOUR).getValue().getSuitValue() == PokerConstants.FOURTEEN) {

				if ((cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == PokerConstants.TWO && cardList.get(PokerConstants.ONE).getValue().getSuitValue() == PokerConstants.THREE
						&& cardList.get(PokerConstants.TWO).getValue().getSuitValue() == PokerConstants.FOUR && cardList.get(PokerConstants.THREE).getValue().getSuitValue() == PokerConstants.FIVE)
						|| (cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == PokerConstants.TEN && cardList.get(PokerConstants.ONE).getValue().getSuitValue() == PokerConstants.ELEVEN
								&& cardList.get(PokerConstants.TWO).getValue().getSuitValue() == PokerConstants.TWELVE && cardList.get(PokerConstants.THREE).getValue().getSuitValue() == PokerConstants.THIRTEEN)) {
	
					// Poker hand is Straight
					result = true;
	
				}
		}
		else {	// Check 5 cards with consecutive values present or not

			int suitValue = cardList.get(PokerConstants.ZERO).getValue().getSuitValue() + PokerConstants.ONE;

			for (int i = 1; i < 5; i++) {

				if (cardList.get(i).getValue().getSuitValue() != suitValue) {

					return result;		// Poker hand is not Straight
				}

				suitValue++;
			}
			
			// Poker hand is Straight
			result = true;
		}

		// Return the result
		return result;
	}

	/**
	 * Method to check poker hand is Full House or not
	 * 
	 * @param cardList Card list of player
	 * @return true/false
	 */
	public static boolean isFullHouse(List<Card> cardList) {
		
		// Sort the card list in ascending order
		Collections.sort(cardList, new CardComparator());

		// Check pattern of  [A, A, A, B, B] or [B, B, A, A, A]
		// 3 cards of the same value, with the remaining 2 cards forming a pair.
		if ((cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == cardList.get(PokerConstants.ONE).getValue().getSuitValue()
				&& cardList.get(PokerConstants.TWO).getValue().getSuitValue() == cardList.get(PokerConstants.THREE).getValue().getSuitValue() 
				&& cardList.get(PokerConstants.THREE).getValue().getSuitValue() == cardList.get(PokerConstants.FOUR).getValue().getSuitValue())
				|| (cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == cardList.get(PokerConstants.ONE).getValue().getSuitValue()
						&& cardList.get(PokerConstants.ONE).getValue().getSuitValue() == cardList.get(PokerConstants.TWO).getValue().getSuitValue() 
						&& cardList.get(PokerConstants.THREE).getValue().getSuitValue() == cardList.get(PokerConstants.FOUR).getValue().getSuitValue())) {

			// Poker hand is full house
			return true;
		}
		
		// Poker hand is not full house
		return false;
	}

	/**
	 * Method to check poker hand is Four of a kind or not
	 * 
	 * @param cardList Card list of player
	 * @return true/false
	 */
	public static boolean isFourOfaKind(List<Card> cardList) {

		// Sort the card list in ascending order
		Collections.sort(cardList, new CardComparator());

		// 4 cards with the same value.
		if ((cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == cardList.get(PokerConstants.ONE).getValue().getSuitValue()
				&& cardList.get(PokerConstants.ONE).getValue().getSuitValue() == cardList.get(PokerConstants.TWO).getValue().getSuitValue() 
				&& cardList.get(PokerConstants.TWO).getValue().getSuitValue() == cardList.get(PokerConstants.THREE).getValue().getSuitValue())
				|| (cardList.get(PokerConstants.ONE).getValue().getSuitValue() == cardList.get(PokerConstants.TWO).getValue().getSuitValue()
						&& cardList.get(PokerConstants.TWO).getValue().getSuitValue() == cardList.get(PokerConstants.THREE).getValue().getSuitValue() 
						&& cardList.get(PokerConstants.THREE).getValue().getSuitValue() == cardList.get(PokerConstants.FOUR).getValue().getSuitValue())) {

			// Poker hand is four of a kind
			return true;
		}

		// Poker hand is not four of a kind
		return false;
	}

	
	/**
	 * Method to check poker hand is Three of a kind or not
	 * 
	 * @param cardList Card list of player
	 * @return true/false
	 */
	public static boolean isThreeOfaKind(List<Card> cardList) {

		// Check card is not Full house or Four of a kind
		if (!(isFullHouse(cardList) || isFourOfaKind(cardList))) {

			// Sort the card list in ascending order
			Collections.sort(cardList, new CardComparator());

			// Three of the cards in the hand have the same value
			if ((cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == cardList.get(PokerConstants.ONE).getValue().getSuitValue()
					&& cardList.get(PokerConstants.ONE).getValue().getSuitValue() == cardList.get(PokerConstants.TWO).getValue().getSuitValue())
					|| (cardList.get(PokerConstants.ONE).getValue().getSuitValue() == cardList.get(PokerConstants.TWO).getValue().getSuitValue()
							&& cardList.get(PokerConstants.TWO).getValue().getSuitValue() == cardList.get(PokerConstants.THREE).getValue().getSuitValue())
					|| (cardList.get(PokerConstants.TWO).getValue().getSuitValue() == cardList.get(PokerConstants.THREE).getValue().getSuitValue()
							&& cardList.get(PokerConstants.THREE).getValue().getSuitValue() == cardList.get(PokerConstants.FOUR).getValue().getSuitValue())) {

				// Poker hand is three of a kind
				return true;
			}
		}
		
		// Poker hand is not three of a kind 
		return false;
	}
	
	
	
	/**
	 * Method to check poker hand is having 2 pairs
	 * 
	 * @param cardList Card list of player
	 * @return true/false
	 */
	public static boolean isTwoPairs(List<Card> cardList) {
		
		// Check poker hand is not Full house, four of a kind, three of a kind
		if(!(isFullHouse(cardList) || isFourOfaKind(cardList) || isThreeOfaKind(cardList))) {
			
			// Sort the card list in ascending order 
			Collections.sort(cardList, new CardComparator());
			
			// The hand contains 2 different pairs
			if ((cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == cardList.get(PokerConstants.ONE).getValue().getSuitValue()
					&& cardList.get(PokerConstants.TWO).getValue().getSuitValue() == cardList.get(PokerConstants.THREE).getValue().getSuitValue())
					|| (cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == cardList.get(PokerConstants.ONE).getValue().getSuitValue()
							&& cardList.get(PokerConstants.THREE).getValue().getSuitValue() == cardList.get(PokerConstants.FOUR).getValue().getSuitValue())
					|| (cardList.get(PokerConstants.ONE).getValue().getSuitValue() == cardList.get(PokerConstants.TWO).getValue().getSuitValue()
							&& cardList.get(PokerConstants.THREE).getValue().getSuitValue() == cardList.get(PokerConstants.FOUR).getValue().getSuitValue())) {
				
				// Poker hand is having 2 pairs
				return true;
			}
			
		}
		
		// Poker hand is not having 2 pairs
		return false;
	}
	

	/**
	 * Method to check poker hand is having a pair or not
	 * 
	 * @param cardList Card list of player
	 * @return true/false
	 */
	public static boolean isPair(List<Card> cardList) {
		
		// Check poker hand is not full house, four of a kind, three of a kind, 2 pairs
		if(!(isFullHouse(cardList) || isFourOfaKind(cardList) || isThreeOfaKind(cardList) || isTwoPairs(cardList) )) {
			
			// Sort the card list in ascending order
			Collections.sort(cardList, new CardComparator());
			
			//  2 of the 5 cards in the hand have the same value.
			if (cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == cardList.get(PokerConstants.ONE).getValue().getSuitValue()
					|| cardList.get(PokerConstants.ONE).getValue().getSuitValue() == cardList.get(PokerConstants.TWO).getValue().getSuitValue()
					|| cardList.get(PokerConstants.TWO).getValue().getSuitValue() == cardList.get(PokerConstants.THREE).getValue().getSuitValue()
					|| cardList.get(PokerConstants.THREE).getValue().getSuitValue() == cardList.get(PokerConstants.FOUR).getValue().getSuitValue()) {

				// Poker hand is having a pair
				return true;
			}
			
		}
		
		// Poker hand is not having a pair
		return false;
	}
}
