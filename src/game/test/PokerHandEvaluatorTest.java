package game.test;

import game.card.Card;
import game.card.Suit;
import game.card.Value;
import game.poker.PokerHandEvaluator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PokerHandEvaluatorTest {
	
	@Test
	public void testIsFlush_01() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.FIVE));
		cardList.add(new Card(Suit.CLUBS, Value.THREE));
		cardList.add(new Card(Suit.CLUBS, Value.KING));
		cardList.add(new Card(Suit.CLUBS, Value.JACK));
		cardList.add(new Card(Suit.CLUBS, Value.SEVEN));
		
		boolean result = PokerHandEvaluator.isFlush(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsFlush_02() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.FIVE));
		cardList.add(new Card(Suit.CLUBS, Value.THREE));
		cardList.add(new Card(Suit.CLUBS, Value.KING));
		cardList.add(new Card(Suit.CLUBS, Value.JACK));
		cardList.add(new Card(Suit.SPADES, Value.SEVEN));
		
		boolean result = PokerHandEvaluator.isFlush(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsStraight_01() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.SPADES, Value.ACE));
		cardList.add(new Card(Suit.CLUBS, Value.QUEEN));
		cardList.add(new Card(Suit.DIAMONDS, Value.JACK));
		cardList.add(new Card(Suit.HEARTS, Value.KING));
		cardList.add(new Card(Suit.SPADES, Value.TEN));
		
		boolean result = PokerHandEvaluator.isStraight(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsStraight_02() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.DIAMONDS, Value.FOUR));
		cardList.add(new Card(Suit.SPADES, Value.TWO));
		cardList.add(new Card(Suit.CLUBS, Value.ACE));
		cardList.add(new Card(Suit.HEARTS, Value.FIVE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		
		boolean result = PokerHandEvaluator.isStraight(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsStraight_03() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.SPADES, Value.FOUR));
		cardList.add(new Card(Suit.HEARTS, Value.TWO));
		cardList.add(new Card(Suit.DIAMONDS, Value.SIX));
		cardList.add(new Card(Suit.CLUBS, Value.FIVE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		
		boolean result = PokerHandEvaluator.isStraight(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsStraight_04() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.FOUR));
		cardList.add(new Card(Suit.HEARTS, Value.TWO));
		cardList.add(new Card(Suit.DIAMONDS, Value.SEVEN));
		cardList.add(new Card(Suit.CLUBS, Value.FIVE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		
		boolean result = PokerHandEvaluator.isStraight(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsFullHouse_01() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.FOUR));
		cardList.add(new Card(Suit.SPADES, Value.FOUR));
		cardList.add(new Card(Suit.HEARTS, Value.FOUR));
		cardList.add(new Card(Suit.DIAMONDS, Value.THREE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		
		boolean result = PokerHandEvaluator.isFullHouse(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsFullHouse_02() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.ACE));
		cardList.add(new Card(Suit.DIAMONDS, Value.JACK));
		cardList.add(new Card(Suit.CLUBS, Value.JACK));
		cardList.add(new Card(Suit.SPADES, Value.JACK));
		
		boolean result = PokerHandEvaluator.isFullHouse(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsFullHouse_03() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.SPADES, Value.ACE));
		cardList.add(new Card(Suit.CLUBS, Value.QUEEN));
		cardList.add(new Card(Suit.DIAMONDS, Value.JACK));
		cardList.add(new Card(Suit.HEARTS, Value.KING));
		cardList.add(new Card(Suit.SPADES, Value.TEN));
		
		boolean result = PokerHandEvaluator.isFullHouse(cardList);
		assertThat(result, is(false));
		
	}

	@Test
	public void testIsFourOfAKind_01() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.ACE));
		cardList.add(new Card(Suit.DIAMONDS, Value.ACE));
		cardList.add(new Card(Suit.CLUBS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.JACK));
		
		boolean result = PokerHandEvaluator.isFourOfaKind(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsFourOfAKind_02() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.ACE));
		cardList.add(new Card(Suit.DIAMONDS, Value.KING));
		cardList.add(new Card(Suit.CLUBS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.JACK));
		
		boolean result = PokerHandEvaluator.isFourOfaKind(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsThreeOfAKind_01() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.ACE));
		cardList.add(new Card(Suit.DIAMONDS, Value.KING));
		cardList.add(new Card(Suit.CLUBS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.JACK));
		
		boolean result = PokerHandEvaluator.isThreeOfaKind(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsThreeOfAKind_02() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		cardList.add(new Card(Suit.DIAMONDS, Value.JACK));
		cardList.add(new Card(Suit.CLUBS, Value.JACK));
		cardList.add(new Card(Suit.SPADES, Value.JACK));
		
		boolean result = PokerHandEvaluator.isThreeOfaKind(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsThreeOfAKind_03() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.ACE));
		cardList.add(new Card(Suit.DIAMONDS, Value.ACE));
		cardList.add(new Card(Suit.CLUBS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.KING));
		
		boolean result = PokerHandEvaluator.isThreeOfaKind(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsThreeOfAKind_04() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.THREE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		cardList.add(new Card(Suit.DIAMONDS, Value.JACK));
		cardList.add(new Card(Suit.CLUBS, Value.JACK));
		cardList.add(new Card(Suit.SPADES, Value.JACK));
		
		boolean result = PokerHandEvaluator.isThreeOfaKind(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsThreeOfAKind_05() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		cardList.add(new Card(Suit.DIAMONDS, Value.FIVE));
		cardList.add(new Card(Suit.CLUBS, Value.QUEEN));
		cardList.add(new Card(Suit.SPADES, Value.JACK));
		
		boolean result = PokerHandEvaluator.isThreeOfaKind(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsTwoPairs_01() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.THREE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		cardList.add(new Card(Suit.DIAMONDS, Value.JACK));
		cardList.add(new Card(Suit.CLUBS, Value.JACK));
		cardList.add(new Card(Suit.SPADES, Value.JACK));
		
		boolean result = PokerHandEvaluator.isTwoPairs(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsTwoPairs_02() {
	
	List<Card> cardList = new ArrayList<Card>();
	cardList.add(new Card(Suit.HEARTS, Value.THREE));
	cardList.add(new Card(Suit.SPADES, Value.THREE));
	cardList.add(new Card(Suit.DIAMONDS, Value.THREE));
	cardList.add(new Card(Suit.CLUBS, Value.THREE));
	cardList.add(new Card(Suit.SPADES, Value.JACK));
	
	boolean result = PokerHandEvaluator.isTwoPairs(cardList);
	assertThat(result, is(false));
	}
	
	@Test
	public void testIsTwoPairs_03() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.NINE));
		cardList.add(new Card(Suit.SPADES, Value.SIX));
		cardList.add(new Card(Suit.DIAMONDS, Value.EIGHT));
		cardList.add(new Card(Suit.CLUBS, Value.EIGHT));
		cardList.add(new Card(Suit.SPADES, Value.EIGHT));
		
		boolean result = PokerHandEvaluator.isTwoPairs(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsTwoPairs_04() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.NINE));
		cardList.add(new Card(Suit.SPADES, Value.NINE));
		cardList.add(new Card(Suit.DIAMONDS, Value.THREE));
		cardList.add(new Card(Suit.CLUBS, Value.FOUR));
		cardList.add(new Card(Suit.SPADES, Value.KING));
		
		boolean result = PokerHandEvaluator.isTwoPairs(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsTwoPairs_05() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.NINE));
		cardList.add(new Card(Suit.SPADES, Value.NINE));
		cardList.add(new Card(Suit.DIAMONDS, Value.THREE));
		cardList.add(new Card(Suit.CLUBS, Value.THREE));
		cardList.add(new Card(Suit.SPADES, Value.KING));
		
		boolean result = PokerHandEvaluator.isTwoPairs(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsTwoPairs_06() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.TWO));
		cardList.add(new Card(Suit.SPADES, Value.EIGHT));
		cardList.add(new Card(Suit.DIAMONDS, Value.TEN));
		cardList.add(new Card(Suit.CLUBS, Value.EIGHT));
		cardList.add(new Card(Suit.SPADES, Value.TEN));
		
		boolean result = PokerHandEvaluator.isTwoPairs(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsTwoPairs_07() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.THREE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		cardList.add(new Card(Suit.DIAMONDS, Value.ACE));
		cardList.add(new Card(Suit.CLUBS, Value.SEVEN));
		cardList.add(new Card(Suit.SPADES, Value.SEVEN));
		
		boolean result = PokerHandEvaluator.isTwoPairs(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsPair_01() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.THREE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		cardList.add(new Card(Suit.DIAMONDS, Value.ACE));
		cardList.add(new Card(Suit.CLUBS, Value.SEVEN));
		cardList.add(new Card(Suit.SPADES, Value.SEVEN));
		
		boolean result = PokerHandEvaluator.isPair(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsPair_02() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.FIVE));
		cardList.add(new Card(Suit.SPADES, Value.KING));
		cardList.add(new Card(Suit.DIAMONDS, Value.TEN));
		cardList.add(new Card(Suit.CLUBS, Value.TEN));
		cardList.add(new Card(Suit.SPADES, Value.TEN));
		
		boolean result = PokerHandEvaluator.isPair(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsPair_03() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.HEARTS, Value.NINE));
		cardList.add(new Card(Suit.SPADES, Value.NINE));
		cardList.add(new Card(Suit.DIAMONDS, Value.NINE));
		cardList.add(new Card(Suit.CLUBS, Value.NINE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		
		boolean result = PokerHandEvaluator.isPair(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsPair_04() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.SIX));
		cardList.add(new Card(Suit.SPADES, Value.QUEEN));
		cardList.add(new Card(Suit.HEARTS, Value.QUEEN));
		cardList.add(new Card(Suit.DIAMONDS, Value.QUEEN));
		cardList.add(new Card(Suit.SPADES, Value.SIX));
		
		boolean result = PokerHandEvaluator.isPair(cardList);
		assertThat(result, is(false));
		
	}
	
	@Test
	public void testIsPair_05() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.SIX));
		cardList.add(new Card(Suit.SPADES, Value.SIX));
		cardList.add(new Card(Suit.HEARTS, Value.QUEEN));
		cardList.add(new Card(Suit.DIAMONDS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.TEN));
		
		boolean result = PokerHandEvaluator.isPair(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsPair_06() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.THREE));
		cardList.add(new Card(Suit.HEARTS, Value.THREE));
		cardList.add(new Card(Suit.DIAMONDS, Value.SEVEN));
		cardList.add(new Card(Suit.SPADES, Value.FOUR));
		
		boolean result = PokerHandEvaluator.isPair(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsPair_07() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.FIVE));
		cardList.add(new Card(Suit.SPADES, Value.KING));
		cardList.add(new Card(Suit.HEARTS, Value.EIGHT));
		cardList.add(new Card(Suit.DIAMONDS, Value.EIGHT));
		cardList.add(new Card(Suit.SPADES, Value.NINE));
		
		boolean result = PokerHandEvaluator.isPair(cardList);
		assertThat(result, is(true));
		
	}
	
	@Test
	public void testIsPair_08() {
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.CLUBS, Value.EIGHT));
		cardList.add(new Card(Suit.SPADES, Value.TWO));
		cardList.add(new Card(Suit.HEARTS, Value.FOUR));
		cardList.add(new Card(Suit.DIAMONDS, Value.ACE));
		cardList.add(new Card(Suit.SPADES, Value.ACE));
		
		boolean result = PokerHandEvaluator.isPair(cardList);
		assertThat(result, is(true));
	}
}
