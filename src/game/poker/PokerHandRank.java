package game.poker;

import game.card.Card;
import game.card.CardComparator;
import game.player.Player;

import java.util.Collections;
import java.util.List;


/**
 * Poker Hand Rank Class
 * Class which actually assigns rank for player's poker cards.
 * Also decides, which player is winner
 */
public class PokerHandRank {

	
	
	/**
	 * Method to get the value of high card
	 * 
	 * @param cardList Card list of player
	 * @return rank return the value of high card
	 */
	public static int getHighCardRank(List<Card> cardList) {
		
		// rank of high card
		int rank = 0;
		
		// Sorting the card list in ascending order
		Collections.sort(cardList, new CardComparator());
		
		rank = cardList.get(PokerConstants.ZERO).getValue().getSuitValue() 
				+ PokerConstants.FOURTEEN*cardList.get(PokerConstants.ONE).getValue().getSuitValue()
				+ PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.TWO).getValue().getSuitValue() 
				+ PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.THREE).getValue().getSuitValue()
				+ PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.FOUR).getValue().getSuitValue();
		
		// return value of high card
		return rank;
		
	}
	
	/**
	 * Method to get rank of Straight Flush
	 * 
	 * @param cardList Card list of player
	 * @return rank of STRAIGHT_FLUSH + High Card Rank
	 */
	public static int getStraightFlushRank(List<Card> cardList) {
		
		// return the Straight Flush rank
		return PokerConstants.STRAIGHT_FLUSH + getHighCardRank(cardList);
	}
	
	
	
	/**
	 * Method to get Four of a kind rank
	 * 
	 * @param cardList Card list of player
	 * @return rank of Four of a kind + value of the 4 cards
	 */
	public static int getFourOfAKindRank(List<Card> cardList) {
		
		// Sorting the card list in ascending order
		Collections.sort(cardList, new CardComparator());
		
		// return Four of a kind rank
		return PokerConstants.FOUR_OF_A_KIND + cardList.get(PokerConstants.TWO).getValue().getSuitValue();
		
	}
	
	
	/**
	 * Method to get Full House rank
	 * 
	 * @param cardList Card list of player
	 * @return rank of Full House + value of the 3 cards
	 */
	public static int getFullHouseRank(List<Card> cardList) {
		
		// Sorting the card list in ascending order
		Collections.sort(cardList, new CardComparator());
		
		// return Full House rank
		return PokerConstants.FULL_HOUSE + cardList.get(PokerConstants.TWO).getValue().getSuitValue();
		
	} 	
	
	/**
	 * Method to get Flush rank
	 * 
	 * @param cardList Card list of player
	 * @return rank of Flush + High Card Rank
	 */
	public static int getFlushRank(List<Card> cardList) {
		
		// return Flush rank
		return PokerConstants.FLUSH + getHighCardRank(cardList);
		
	} 	
	
	/**
	 * Method to get Straight rank
	 * 
	 * @param cardList Card list of player
	 * @return rank of Straight + High Card Rank
	 */
	public static int getStraightRank(List<Card> cardList) {
		
		// return Straight rank
		return PokerConstants.STRAIGHT + getHighCardRank(cardList);
		
	} 
	
	/**
	 * Method to get Three of a Kind rank
	 * 
	 * @param cardList Card list of player
	 * @return rank of Three of a Kind +  value of the 3 cards
	 */
	public static int getThreeOfAKindRank(List<Card> cardList) {
		
		// Sorting the card list in ascending order
		Collections.sort(cardList, new CardComparator());
		
		// return Three of a kind rank
		return PokerConstants.THREE_OF_A_KIND + cardList.get(PokerConstants.TWO).getValue().getSuitValue();
		
	} 
	
	/**
	 * Method to get Two Pairs rank
	 * 
	 * @param cardList Card list of player
	 * @return rank of TWO Pairs
	 */
	public static int getTwoPairsRank(List<Card> cardList) {
		
		// rank of 2 pairs
		int rank = 0;
		
		// Sorting the card list in ascending order
		Collections.sort(cardList, new CardComparator());
		
		// if X,X,Y,Y,Z
		if(cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == cardList.get(PokerConstants.ONE).getValue().getSuitValue()
					&& cardList.get(PokerConstants.TWO).getValue().getSuitValue() == cardList.get(PokerConstants.THREE).getValue().getSuitValue()) {
			
			rank = PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.THREE).getValue().getSuitValue()
					+  PokerConstants.FOURTEEN*cardList.get(PokerConstants.ONE).getValue().getSuitValue()
					+ cardList.get(PokerConstants.FOUR).getValue().getSuitValue();
		}
		// if X,X,Z,Y,Y
		else if (cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == cardList.get(PokerConstants.ONE).getValue().getSuitValue()
				&& cardList.get(PokerConstants.THREE).getValue().getSuitValue() == cardList.get(PokerConstants.FOUR).getValue().getSuitValue()) {
			
			rank = PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.THREE).getValue().getSuitValue()
					+  PokerConstants.FOURTEEN*cardList.get(PokerConstants.ONE).getValue().getSuitValue()
					+ cardList.get(PokerConstants.TWO).getValue().getSuitValue();
			
		}
		// if Z,X,X,Y,Y
		else {
			
			rank = PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.THREE).getValue().getSuitValue()
					+  PokerConstants.FOURTEEN*cardList.get(PokerConstants.TWO).getValue().getSuitValue()
					+ cardList.get(PokerConstants.ZERO).getValue().getSuitValue();
			
		}
		
		// return Two pairs rank
		return PokerConstants.TWO_PAIRS + rank;
	} 
	
	/**
	 * Method to get one Pair rank
	 * 
	 * @param cardList Card list of player
	 * @return rank of TWO Pairs
	 */
	public static int getPairRank(List<Card> cardList) {
		
		// rank of one pair
		int rank = 0;
		
		// Sorting the card list in ascending order
		Collections.sort(cardList, new CardComparator());
		
		// if X,X,A,B,C
		if(cardList.get(PokerConstants.ZERO).getValue().getSuitValue() == cardList.get(PokerConstants.ONE).getValue().getSuitValue()) {
			
			rank = PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.ZERO).getValue().getSuitValue()
					+ cardList.get(PokerConstants.TWO).getValue().getSuitValue() + PokerConstants.FOURTEEN*cardList.get(PokerConstants.THREE).getValue().getSuitValue()
					+ PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.FOUR).getValue().getSuitValue();
		}
		// if A,X,X,B,C
		else if(cardList.get(PokerConstants.ONE).getValue().getSuitValue() == cardList.get(PokerConstants.TWO).getValue().getSuitValue()) {
			
			rank = PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.ONE).getValue().getSuitValue()
					+ cardList.get(PokerConstants.ZERO).getValue().getSuitValue() + PokerConstants.FOURTEEN*cardList.get(PokerConstants.THREE).getValue().getSuitValue()
					+ PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.FOUR).getValue().getSuitValue();
		}
		// if A,B,X,X,C
		else if(cardList.get(PokerConstants.TWO).getValue().getSuitValue() == cardList.get(PokerConstants.THREE).getValue().getSuitValue()) {
			
			rank = PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.TWO).getValue().getSuitValue()
					+ cardList.get(PokerConstants.ZERO).getValue().getSuitValue() + PokerConstants.FOURTEEN*cardList.get(PokerConstants.ONE).getValue().getSuitValue()
					+ PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.FOUR).getValue().getSuitValue();
		}
		// if A,B,C,X,X
		else {
			
			rank = PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.THREE).getValue().getSuitValue()
					+ cardList.get(PokerConstants.ZERO).getValue().getSuitValue() + PokerConstants.FOURTEEN*cardList.get(PokerConstants.ONE).getValue().getSuitValue()
					+ PokerConstants.FOURTEEN*PokerConstants.FOURTEEN*cardList.get(PokerConstants.TWO).getValue().getSuitValue();
		}
		
		// return Pair Rank
		return PokerConstants.PAIR + rank;
	}
	
	
	/**
	 * Method to check both player hands strengths and display who is the winner
	 * 
	 * @param player1 Player 1
	 * @param player2 Player 2
	 */
	public static void checkPlayerHand(Player player1, Player player2) {
		
		
		// Player 1 hand strength check
		// is Straight Flush?
		if(PokerHandEvaluator.isFlush(player1.getCardInHand()) && PokerHandEvaluator.isStraight(player1.getCardInHand())) {
			
			player1.setRank(getStraightFlushRank(player1.getCardInHand()));
			player1.setDisplayHand("Straight flush");
		}
		// is Four of a kind?
		else if(PokerHandEvaluator.isFourOfaKind(player1.getCardInHand())) {
			
			player1.setRank(getFourOfAKindRank(player1.getCardInHand()));
			player1.setDisplayHand("Four of a kind");
		}
		// is Full House?
		else if(PokerHandEvaluator.isFullHouse(player1.getCardInHand())) {
			
			player1.setRank(getFullHouseRank(player1.getCardInHand()));
			player1.setDisplayHand("Full House");
		}
		// is Flush?
		else if(PokerHandEvaluator.isFlush(player1.getCardInHand())) {
			
			player1.setRank(getFlushRank(player1.getCardInHand()));
			player1.setDisplayHand("Flush");
		}
		// is Straight?
		else if(PokerHandEvaluator.isStraight(player1.getCardInHand())) {
			
			player1.setRank(getStraightRank(player1.getCardInHand()));
			player1.setDisplayHand("Straight");
		}
		// is Three of a Kind?
		else if(PokerHandEvaluator.isThreeOfaKind(player1.getCardInHand())) {
			
			player1.setRank(getThreeOfAKindRank(player1.getCardInHand()));
			player1.setDisplayHand("Three of a Kind");
		}
		// is Two Pairs?
		else if(PokerHandEvaluator.isTwoPairs(player1.getCardInHand())) {
			
			player1.setRank(getTwoPairsRank(player1.getCardInHand()));
			player1.setDisplayHand("Two Pairs");
		}
		// is Pair?
		else if(PokerHandEvaluator.isPair(player1.getCardInHand())) {
			
			player1.setRank(getPairRank(player1.getCardInHand()));
			player1.setDisplayHand("Pair");
		}
		else {
			
			// High Card
			player1.setRank(getHighCardRank(player1.getCardInHand()));
			player1.setDisplayHand("High Card");
		}
		
		// Player 2 hand strength check
		// is Straight Flush?
		if(PokerHandEvaluator.isFlush(player2.getCardInHand()) && PokerHandEvaluator.isStraight(player2.getCardInHand())) {
			
			player2.setRank(getStraightFlushRank(player2.getCardInHand()));
			player2.setDisplayHand("Straight flush");
		}
		// is Four of a kind?
		else if(PokerHandEvaluator.isFourOfaKind(player2.getCardInHand())) {
			
			player2.setRank(getFourOfAKindRank(player2.getCardInHand()));
			player2.setDisplayHand("Four of a kind");
		}
		// is Full House?
		else if(PokerHandEvaluator.isFullHouse(player2.getCardInHand())) {
			
			player2.setRank(getFullHouseRank(player2.getCardInHand()));
			player2.setDisplayHand("Full House");
			
		}
		// is Flush?
		else if(PokerHandEvaluator.isFlush(player2.getCardInHand())) {
			
			player2.setRank(getFlushRank(player2.getCardInHand()));
			player2.setDisplayHand("Flush");
			
		}
		// is Straight?
		else if(PokerHandEvaluator.isStraight(player2.getCardInHand())) {
			
			player2.setRank(getStraightRank(player2.getCardInHand()));
			player2.setDisplayHand("Straight");
			
		}
		// is Three of a Kind?
		else if(PokerHandEvaluator.isThreeOfaKind(player2.getCardInHand())) {
			
			player2.setRank(getThreeOfAKindRank(player2.getCardInHand()));
			player2.setDisplayHand("Three of a Kind");
		}
		// is Two Pairs?
		else if(PokerHandEvaluator.isTwoPairs(player2.getCardInHand())) {
			
			player2.setRank(getTwoPairsRank(player2.getCardInHand()));
			player2.setDisplayHand("Two Pairs");
		}
		// is Pair?
		else if(PokerHandEvaluator.isPair(player2.getCardInHand())) {
			
			player2.setRank(getPairRank(player2.getCardInHand()));
			player2.setDisplayHand("Pair");
		}
		else {
			
			// High Card
			player2.setRank(getHighCardRank(player2.getCardInHand()));
			player2.setDisplayHand("High Card");
		}
		
		
		System.out.println("\n*********************************************************\n");
		
		if(player1.getRank() > player2.getRank()) {
			
			System.out.println("\t Player1 wins, Hurray !!!!, Lets Party");
			System.out.println("\t Win by: "+player1.getDisplayHand());
			System.out.println("\t Score: "+player1.getRank());
			System.out.println("\n\tPlayer2");
			System.out.println("\t lost by: "+player2.getDisplayHand());
			System.out.println("\t Score: "+player2.getRank());
		}
		else if(player2.getRank() > player1.getRank()) {
			
			System.out.println("\t Player2 wins, Hurray !!!!, Lets Party");
			System.out.println("\t Win by: "+player2.getDisplayHand());
			System.out.println("\t Score: "+player2.getRank());
			System.out.println("\n\tPlayer1");
			System.out.println("\t lost by: "+player1.getDisplayHand());
			System.out.println("\t Score: "+player1.getRank());
		}
		else {
			
			System.out.println("\t Player1 ties with Player 2");
			System.out.println("\n\tPlayer1");
			System.out.println("\t Player1 Card: "+player1.getDisplayHand());
			System.out.println("\t Score: "+player1.getRank());
			System.out.println("\n\tPlayer2");
			System.out.println("\t Player2 Card: "+player2.getDisplayHand());
			System.out.println("\t Score: "+player2.getRank());
			
		}
		
		System.out.println("\n*********************************************************\n");
	}
	
}
