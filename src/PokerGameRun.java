public class PokerGameRun {
	
	public static void main(String[] args) {
		
		Card card1 = new Card(Suit.SPADES, Value.ACE);
		Card card2 = new Card(Suit.SPADES, Value.ACE);
		Card card3 = new Card(Suit.SPADES, Value.ACE);
		Card card4 = new Card(Suit.SPADES, Value.FOUR);
		Card card5 = new Card(Suit.SPADES, Value.FOUR);
		
		Player player1 = new Player();
		player1.getCardInHand().add(card1);
		player1.getCardInHand().add(card2);
		player1.getCardInHand().add(card3);
		player1.getCardInHand().add(card4);
		player1.getCardInHand().add(card5);
		
		System.out.println(PokerHandEvaluator.isFlush(player1.getCardInHand()));
		System.out.println(PokerHandEvaluator.isStraight(player1.getCardInHand()));
		System.out.println(PokerHandEvaluator.isFullHouse(player1.getCardInHand()));
	}
}
