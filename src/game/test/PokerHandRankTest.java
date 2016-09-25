package game.test;

import static org.junit.Assert.*;
import game.card.Card;
import game.card.Suit;
import game.card.Value;
import game.player.Player;
import game.poker.PokerHandRank;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class PokerHandRankTest {

	@Test
	public void testGetHighCardRank() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.TWO));
		cardList.add(new Card(Suit.SPADES, Value.FOUR));
		cardList.add(new Card(Suit.DIAMONDS, Value.SEVEN));
		cardList.add(new Card(Suit.CLUBS, Value.NINE));
		cardList.add(new Card(Suit.SPADES, Value.EIGHT));
		
		int rank = PokerHandRank.getHighCardRank(cardList);
		assertThat(rank, equalTo(369126));
	}
	
	@Test
	public void testGetStraightFlushRank() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.TWO));
		cardList.add(new Card(Suit.HEARTS, Value.THREE));
		cardList.add(new Card(Suit.HEARTS, Value.FOUR));
		cardList.add(new Card(Suit.HEARTS, Value.FIVE));
		cardList.add(new Card(Suit.HEARTS, Value.SIX));
		
		int rank = PokerHandRank.getStraightFlushRank(cardList);
		assertThat(rank, equalTo(8245044));
	}

	@Test
	public void testGetFourOfAKindRank() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.TWO));
		cardList.add(new Card(Suit.CLUBS, Value.TWO));
		cardList.add(new Card(Suit.DIAMONDS, Value.TWO));
		cardList.add(new Card(Suit.SPADES, Value.TWO));
		cardList.add(new Card(Suit.HEARTS, Value.SIX));
		
		int rank = PokerHandRank.getFourOfAKindRank(cardList);
		assertThat(rank, equalTo(7000002));
	}
	
	@Test
	public void testGetFullHouseRank() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.TWO));
		cardList.add(new Card(Suit.CLUBS, Value.TWO));
		cardList.add(new Card(Suit.DIAMONDS, Value.TWO));
		cardList.add(new Card(Suit.SPADES, Value.SIX));
		cardList.add(new Card(Suit.HEARTS, Value.SIX));
		
		int rank = PokerHandRank.getFullHouseRank(cardList);
		assertThat(rank, equalTo(6000002));
	}
	
	@Test
	public void testGetFlushRank() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.TWO));
		cardList.add(new Card(Suit.CLUBS, Value.EIGHT));
		cardList.add(new Card(Suit.CLUBS, Value.FIVE));
		cardList.add(new Card(Suit.CLUBS, Value.JACK));
		cardList.add(new Card(Suit.CLUBS, Value.NINE));
		
		int rank = PokerHandRank.getFlushRank(cardList);
		assertThat(rank, equalTo(5448912));
	}
	
	@Test
	public void testGetStraightRank() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.THREE));
		cardList.add(new Card(Suit.HEARTS, Value.SIX));
		cardList.add(new Card(Suit.SPADES, Value.FIVE));
		cardList.add(new Card(Suit.DIAMONDS, Value.FOUR));
		cardList.add(new Card(Suit.CLUBS, Value.SEVEN));
		
		int rank = PokerHandRank.getStraightRank(cardList);
		assertThat(rank, equalTo(4286415));
	}
	
	@Test
	public void testGetThreeOfAKindRank() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.THREE));
		cardList.add(new Card(Suit.HEARTS, Value.THREE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		cardList.add(new Card(Suit.DIAMONDS, Value.FOUR));
		cardList.add(new Card(Suit.CLUBS, Value.SEVEN));
		
		int rank = PokerHandRank.getThreeOfAKindRank(cardList);
		assertThat(rank, equalTo(3000003));
	}
	
	@Test
	public void testGetTwoPairsRank_01() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.TWO));
		cardList.add(new Card(Suit.HEARTS, Value.TWO));
		cardList.add(new Card(Suit.SPADES, Value.FOUR));
		cardList.add(new Card(Suit.DIAMONDS, Value.FOUR));
		cardList.add(new Card(Suit.CLUBS, Value.SEVEN));
		
		int rank = PokerHandRank.getTwoPairsRank(cardList);
		assertThat(rank, equalTo(2000819));
	}
	
	@Test
	public void testGetTwoPairsRank_02() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.TWO));
		cardList.add(new Card(Suit.HEARTS, Value.TWO));
		cardList.add(new Card(Suit.SPADES, Value.FOUR));
		cardList.add(new Card(Suit.DIAMONDS, Value.FOUR));
		cardList.add(new Card(Suit.CLUBS, Value.THREE));
		
		int rank = PokerHandRank.getTwoPairsRank(cardList);
		assertThat(rank, equalTo(2000815));
	}
	
	@Test
	public void testGetTwoPairsRank_03() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.SIX));
		cardList.add(new Card(Suit.HEARTS, Value.EIGHT));
		cardList.add(new Card(Suit.SPADES, Value.SIX));
		cardList.add(new Card(Suit.DIAMONDS, Value.EIGHT));
		cardList.add(new Card(Suit.CLUBS, Value.THREE));
		
		int rank = PokerHandRank.getTwoPairsRank(cardList);
		assertThat(rank, equalTo(2001655));
	}
	
	@Test
	public void testGetPairRank_01() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.TWO));
		cardList.add(new Card(Suit.HEARTS, Value.FIVE));
		cardList.add(new Card(Suit.SPADES, Value.FOUR));
		cardList.add(new Card(Suit.DIAMONDS, Value.TWO));
		cardList.add(new Card(Suit.CLUBS, Value.TEN));
		
		int rank = PokerHandRank.getPairRank(cardList);
		assertThat(rank, equalTo(1007522));
	}
	
	@Test
	public void testGetPairRank_02() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.TWO));
		cardList.add(new Card(Suit.HEARTS, Value.FIVE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		cardList.add(new Card(Suit.DIAMONDS, Value.SIX));
		cardList.add(new Card(Suit.CLUBS, Value.THREE));
		
		int rank = PokerHandRank.getPairRank(cardList);
		assertThat(rank, equalTo(1009480));
	}
	
	@Test
	public void testGetPairRank_03() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.TWO));
		cardList.add(new Card(Suit.HEARTS, Value.FIVE));
		cardList.add(new Card(Suit.SPADES, Value.SIX));
		cardList.add(new Card(Suit.DIAMONDS, Value.FIVE));
		cardList.add(new Card(Suit.CLUBS, Value.THREE));
		
		int rank = PokerHandRank.getPairRank(cardList);
		assertThat(rank, equalTo(1014940));
	}
	
	@Test
	public void testGetPairRank_04() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.SIX));
		cardList.add(new Card(Suit.HEARTS, Value.FIVE));
		cardList.add(new Card(Suit.SPADES, Value.SIX));
		cardList.add(new Card(Suit.DIAMONDS, Value.TWO));
		cardList.add(new Card(Suit.CLUBS, Value.THREE));
		
		int rank = PokerHandRank.getPairRank(cardList);
		assertThat(rank, equalTo(1017488));
	}
	
	@Test
	public void testCheckPlayerHand_01() {
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		List<Card> p1CardList = new ArrayList<Card>();
		p1CardList.add(new Card(Suit.HEARTS, Value.TWO));
		p1CardList.add(new Card(Suit.HEARTS, Value.THREE));
		p1CardList.add(new Card(Suit.HEARTS, Value.FOUR));
		p1CardList.add(new Card(Suit.HEARTS, Value.FIVE));
		p1CardList.add(new Card(Suit.HEARTS, Value.SIX));
		
		player1.setCardInHand(p1CardList);
		
		List<Card> p2CardList = new ArrayList<Card>();
		p2CardList.add(new Card(Suit.CLUBS, Value.THREE));
		p2CardList.add(new Card(Suit.CLUBS, Value.FOUR));
		p2CardList.add(new Card(Suit.CLUBS, Value.FIVE));
		p2CardList.add(new Card(Suit.CLUBS, Value.SIX));
		p2CardList.add(new Card(Suit.CLUBS, Value.SEVEN));
		
		player2.setCardInHand(p2CardList);
		
		PokerHandRank.checkPlayerHand(player1, player2);
		
		assertThat(player2.getRank()>player1.getRank(), equalTo(true));
		assertThat(player2.getDisplayHand(), equalTo("Straight flush"));
		assertThat(player1.getDisplayHand(), equalTo("Straight flush"));
	}
	
	@Test
	public void testCheckPlayerHand_02() {
		
		Player player1 = new Player();
		
		Player player2 = new Player();
		
		List<Card> p1CardList = new ArrayList<Card>();
		p1CardList.add(new Card(Suit.HEARTS, Value.SEVEN));
		p1CardList.add(new Card(Suit.HEARTS, Value.THREE));
		p1CardList.add(new Card(Suit.HEARTS, Value.FOUR));
		p1CardList.add(new Card(Suit.HEARTS, Value.FIVE));
		p1CardList.add(new Card(Suit.HEARTS, Value.SIX));
		
		player1.setCardInHand(p1CardList);
		
		List<Card> p2CardList = new ArrayList<Card>();
		p2CardList.add(new Card(Suit.CLUBS, Value.THREE));
		p2CardList.add(new Card(Suit.CLUBS, Value.FOUR));
		p2CardList.add(new Card(Suit.CLUBS, Value.FIVE));
		p2CardList.add(new Card(Suit.CLUBS, Value.SIX));
		p2CardList.add(new Card(Suit.CLUBS, Value.SEVEN));
		
		player2.setCardInHand(p2CardList);
		
		PokerHandRank.checkPlayerHand(player1, player2);
		
		assertThat(player2.getRank()==player1.getRank(), equalTo(true));
		assertThat(player2.getDisplayHand(), equalTo("Straight flush"));
		assertThat(player1.getDisplayHand(), equalTo("Straight flush"));
	}
	
	@Test
	public void testCheckPlayerHand_03() {
		
		Player player1 = new Player();
		
		Player player2 = new Player();
		
		List<Card> p1CardList = new ArrayList<Card>();
		p1CardList.add(new Card(Suit.HEARTS, Value.SEVEN));
		p1CardList.add(new Card(Suit.DIAMONDS, Value.SEVEN));
		p1CardList.add(new Card(Suit.CLUBS, Value.SEVEN));
		p1CardList.add(new Card(Suit.SPADES, Value.SEVEN));
		p1CardList.add(new Card(Suit.DIAMONDS, Value.SIX));
		
		player1.setCardInHand(p1CardList);
		
		List<Card> p2CardList = new ArrayList<Card>();
		p2CardList.add(new Card(Suit.DIAMONDS, Value.ACE));
		p2CardList.add(new Card(Suit.CLUBS, Value.ACE));
		p2CardList.add(new Card(Suit.SPADES, Value.ACE));
		p2CardList.add(new Card(Suit.HEARTS, Value.ACE));
		p2CardList.add(new Card(Suit.HEARTS, Value.TEN));
		
		player2.setCardInHand(p2CardList);
		
		PokerHandRank.checkPlayerHand(player1, player2);
		
		assertThat(player2.getRank() > player1.getRank(), equalTo(true));
		assertThat(player2.getDisplayHand(), equalTo("Four of a kind"));
		assertThat(player1.getDisplayHand(), equalTo("Four of a kind"));
	}
	
	@Test
	public void testCheckPlayerHand_04() {
		
		Player player1 = new Player();
		
		Player player2 = new Player();
		
		List<Card> p1CardList = new ArrayList<Card>();
		p1CardList.add(new Card(Suit.HEARTS, Value.ACE));
		p1CardList.add(new Card(Suit.DIAMONDS, Value.ACE));
		p1CardList.add(new Card(Suit.CLUBS, Value.ACE));
		p1CardList.add(new Card(Suit.SPADES, Value.SEVEN));
		p1CardList.add(new Card(Suit.DIAMONDS, Value.SEVEN));
		
		player1.setCardInHand(p1CardList);
		
		List<Card> p2CardList = new ArrayList<Card>();
		p2CardList.add(new Card(Suit.DIAMONDS, Value.KING));
		p2CardList.add(new Card(Suit.CLUBS, Value.KING));
		p2CardList.add(new Card(Suit.SPADES, Value.KING));
		p2CardList.add(new Card(Suit.HEARTS, Value.QUEEN));
		p2CardList.add(new Card(Suit.HEARTS, Value.QUEEN));
		
		player2.setCardInHand(p2CardList);
		
		PokerHandRank.checkPlayerHand(player1, player2);
		
		assertThat(player1.getRank() > player2.getRank(), equalTo(true));
		assertThat(player2.getDisplayHand(), equalTo("Full House"));
		assertThat(player1.getDisplayHand(), equalTo("Full House"));
	}
	
	@Test
	public void testCheckPlayerHand_05() {
		
		Player player1 = new Player();
		
		Player player2 = new Player();
		
		List<Card> p1CardList = new ArrayList<Card>();
		p1CardList.add(new Card(Suit.HEARTS, Value.THREE));
		p1CardList.add(new Card(Suit.HEARTS, Value.NINE));
		p1CardList.add(new Card(Suit.HEARTS, Value.ACE));
		p1CardList.add(new Card(Suit.HEARTS, Value.SIX));
		p1CardList.add(new Card(Suit.HEARTS, Value.FOUR));
		
		player1.setCardInHand(p1CardList);
		
		List<Card> p2CardList = new ArrayList<Card>();
		p2CardList.add(new Card(Suit.DIAMONDS, Value.KING));
		p2CardList.add(new Card(Suit.DIAMONDS, Value.JACK));
		p2CardList.add(new Card(Suit.DIAMONDS, Value.TWO));
		p2CardList.add(new Card(Suit.DIAMONDS, Value.FIVE));
		p2CardList.add(new Card(Suit.DIAMONDS, Value.EIGHT));
		
		player2.setCardInHand(p2CardList);
		
		PokerHandRank.checkPlayerHand(player1, player2);
		
		assertThat(player1.getRank() > player2.getRank(), equalTo(true));
		assertThat(player2.getDisplayHand(), equalTo("Flush"));
		assertThat(player1.getDisplayHand(), equalTo("Flush"));
	}
	
	@Test
	public void testCheckPlayerHand_06() {
		
		Player player1 = new Player();
		
		Player player2 = new Player();
		
		List<Card> p1CardList = new ArrayList<Card>();
		p1CardList.add(new Card(Suit.HEARTS, Value.ACE));
		p1CardList.add(new Card(Suit.CLUBS, Value.TWO));
		p1CardList.add(new Card(Suit.SPADES, Value.THREE));
		p1CardList.add(new Card(Suit.DIAMONDS, Value.FOUR));
		p1CardList.add(new Card(Suit.HEARTS, Value.FIVE));
		
		player1.setCardInHand(p1CardList);
		
		List<Card> p2CardList = new ArrayList<Card>();
		p2CardList.add(new Card(Suit.DIAMONDS, Value.KING));
		p2CardList.add(new Card(Suit.HEARTS, Value.JACK));
		p2CardList.add(new Card(Suit.SPADES, Value.TEN));
		p2CardList.add(new Card(Suit.CLUBS, Value.ACE));
		p2CardList.add(new Card(Suit.DIAMONDS, Value.QUEEN));
		
		player2.setCardInHand(p2CardList);
		
		PokerHandRank.checkPlayerHand(player1, player2);
		
		assertThat(player2.getRank() > player1.getRank(), equalTo(true));
		assertThat(player2.getDisplayHand(), equalTo("Straight"));
		assertThat(player1.getDisplayHand(), equalTo("Straight"));
	}
	
	@Test
	public void testCheckPlayerHand_07() {
		
		Player player1 = new Player();
		
		Player player2 = new Player();
		
		List<Card> p1CardList = new ArrayList<Card>();
		p1CardList.add(new Card(Suit.HEARTS, Value.ACE));
		p1CardList.add(new Card(Suit.CLUBS, Value.ACE));
		p1CardList.add(new Card(Suit.SPADES, Value.ACE));
		p1CardList.add(new Card(Suit.DIAMONDS, Value.FOUR));
		p1CardList.add(new Card(Suit.HEARTS, Value.FIVE));
		
		player1.setCardInHand(p1CardList);
		
		List<Card> p2CardList = new ArrayList<Card>();
		p2CardList.add(new Card(Suit.DIAMONDS, Value.KING));
		p2CardList.add(new Card(Suit.HEARTS, Value.KING));
		p2CardList.add(new Card(Suit.SPADES, Value.KING));
		p2CardList.add(new Card(Suit.CLUBS, Value.ACE));
		p2CardList.add(new Card(Suit.DIAMONDS, Value.QUEEN));
		
		player2.setCardInHand(p2CardList);
		
		PokerHandRank.checkPlayerHand(player1, player2);
		
		assertThat(player2.getRank() > player1.getRank(), equalTo(false));
		assertThat(player2.getDisplayHand(), equalTo("Three of a Kind"));
		assertThat(player1.getDisplayHand(), equalTo("Three of a Kind"));
	}
	
	@Test
	public void testCheckPlayerHand_08() {
		
		Player player1 = new Player();
		
		Player player2 = new Player();
		
		List<Card> p1CardList = new ArrayList<Card>();
		p1CardList.add(new Card(Suit.HEARTS, Value.ACE));
		p1CardList.add(new Card(Suit.CLUBS, Value.ACE));
		p1CardList.add(new Card(Suit.SPADES, Value.KING));
		p1CardList.add(new Card(Suit.DIAMONDS, Value.KING));
		p1CardList.add(new Card(Suit.HEARTS, Value.QUEEN));
		
		player1.setCardInHand(p1CardList);
		
		List<Card> p2CardList = new ArrayList<Card>();
		p2CardList.add(new Card(Suit.DIAMONDS, Value.QUEEN));
		p2CardList.add(new Card(Suit.HEARTS, Value.JACK));
		p2CardList.add(new Card(Suit.SPADES, Value.QUEEN));
		p2CardList.add(new Card(Suit.CLUBS, Value.JACK));
		p2CardList.add(new Card(Suit.DIAMONDS, Value.ACE));
		
		player2.setCardInHand(p2CardList);
		
		PokerHandRank.checkPlayerHand(player1, player2);
		
		assertThat(player2.getRank() > player1.getRank(), equalTo(false));
		assertThat(player2.getDisplayHand(), equalTo("Two Pairs"));
		assertThat(player1.getDisplayHand(), equalTo("Two Pairs"));
	}
	
	@Test
	public void testCheckPlayerHand_09() {
		
		Player player1 = new Player();
		
		Player player2 = new Player();
		
		List<Card> p1CardList = new ArrayList<Card>();
		p1CardList.add(new Card(Suit.HEARTS, Value.ACE));
		p1CardList.add(new Card(Suit.CLUBS, Value.ACE));
		p1CardList.add(new Card(Suit.SPADES, Value.KING));
		p1CardList.add(new Card(Suit.DIAMONDS, Value.TEN));
		p1CardList.add(new Card(Suit.HEARTS, Value.JACK));
		
		player1.setCardInHand(p1CardList);
		
		List<Card> p2CardList = new ArrayList<Card>();
		p2CardList.add(new Card(Suit.DIAMONDS, Value.ACE));
		p2CardList.add(new Card(Suit.HEARTS, Value.QUEEN));
		p2CardList.add(new Card(Suit.SPADES, Value.ACE));
		p2CardList.add(new Card(Suit.CLUBS, Value.TWO));
		p2CardList.add(new Card(Suit.DIAMONDS, Value.TEN));
		
		player2.setCardInHand(p2CardList);
		
		PokerHandRank.checkPlayerHand(player1, player2);
		
		assertThat(player2.getRank() > player1.getRank(), equalTo(false));
		assertThat(player2.getDisplayHand(), equalTo("Pair"));
		assertThat(player1.getDisplayHand(), equalTo("Pair"));
	}
	
	@Test
	public void testCheckPlayerHand_10() {
		
		Player player1 = new Player();
		
		Player player2 = new Player();
		
		List<Card> p1CardList = new ArrayList<Card>();
		p1CardList.add(new Card(Suit.HEARTS, Value.ACE));
		p1CardList.add(new Card(Suit.CLUBS, Value.THREE));
		p1CardList.add(new Card(Suit.SPADES, Value.JACK));
		p1CardList.add(new Card(Suit.DIAMONDS, Value.TEN));
		p1CardList.add(new Card(Suit.HEARTS, Value.FOUR));
		
		player1.setCardInHand(p1CardList);
		
		List<Card> p2CardList = new ArrayList<Card>();
		p2CardList.add(new Card(Suit.DIAMONDS, Value.THREE));
		p2CardList.add(new Card(Suit.HEARTS, Value.QUEEN));
		p2CardList.add(new Card(Suit.SPADES, Value.FOUR));
		p2CardList.add(new Card(Suit.CLUBS, Value.NINE));
		p2CardList.add(new Card(Suit.DIAMONDS, Value.ACE));
		
		player2.setCardInHand(p2CardList);
		
		PokerHandRank.checkPlayerHand(player1, player2);
		
		assertThat(player2.getRank() > player1.getRank(), equalTo(true));
		assertThat(player2.getDisplayHand(), equalTo("High Card"));
		assertThat(player1.getDisplayHand(), equalTo("High Card"));
	}
}
