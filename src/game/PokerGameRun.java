package game;

import game.card.Card;
import game.card.Suit;
import game.card.Value;
import game.player.Player;
import game.poker.PokerHandRank;

/**
 *Main class which runs the Poker Game. 
 *
 */
public class PokerGameRun {
	
	public static void main(String[] args) {
		
		// Create player 1
		Player player1 = new Player();
		
		// Create 5 poker cards for player 1
		Card card11 = new Card(Suit.SPADES, Value.ACE);
		Card card12 = new Card(Suit.CLUBS, Value.THREE);
		Card card13 = new Card(Suit.CLUBS, Value.NINE);
		Card card14 = new Card(Suit.HEARTS, Value.FOUR);
		Card card15 = new Card(Suit.DIAMONDS, Value.KING);
		
		// Add 5 cards to player cardList
		player1.getCardInHand().add(card11);
		player1.getCardInHand().add(card12);
		player1.getCardInHand().add(card13);
		player1.getCardInHand().add(card14);
		player1.getCardInHand().add(card15);
		
		// Create player 1
		Player player2 = new Player();
		
		// Create 5 poker cards for player 1
		Card card21 = new Card(Suit.SPADES, Value.ACE);
		Card card22 = new Card(Suit.CLUBS, Value.ACE);
		Card card23 = new Card(Suit.CLUBS, Value.FIVE);
		Card card24 = new Card(Suit.DIAMONDS, Value.JACK);
		Card card25 = new Card(Suit.DIAMONDS, Value.TEN);
		
		// Add 5 cards to player cardList
		player2.getCardInHand().add(card21);
		player2.getCardInHand().add(card22);
		player2.getCardInHand().add(card23);
		player2.getCardInHand().add(card24);
		player2.getCardInHand().add(card25);
		
		
		PokerHandRank.checkPlayerHand(player1, player2);
		
	}
}
