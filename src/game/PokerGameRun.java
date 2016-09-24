package game;

import game.card.Card;
import game.card.Suit;
import game.card.Value;
import game.player.Player;
import game.poker.PokerHandRank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *Main class which runs the Poker Game. 
 *
 */
public class PokerGameRun {
	
	/** Unique poker cards of player1 from user */
	private Set<String> player1Cards = new HashSet<String>();
	
	/** Unique poker cards of player2 from user */
	private	Set<String> player2Cards = new HashSet<String>();
	
	/** player 1 */
	private Player player1 = null;
	
	/** player 2 */
	private Player player2 = null;
	
	/**
	 * Method to display Poker Game introduction
	 */
	private void displayIntro(){
		
		System.out.println("*****************************************************************");
		System.out.println("\t\tWelcome to Poker Game");
		System.out.println("*****************************************************************");
		
		System.out.println("Please find the information below for how to play poker game\n");
		System.out.println("Available Suits are:\n");
		System.out.println("Clubs: C");
		System.out.println("Diamond: D");
		System.out.println("Hearts: H");
		System.out.println("Spades: S");
		
		System.out.println("\nAvailable Cards for each suits are:\n");
		System.out.println("2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A \n");
		
		System.out.println("Input format, for example, 'Hearts of 2' means 2:H");
		System.out.println("Duplicates card values from suit is not allowed");
		System.out.println("*****************************************************************\n");
	}
	
	/**
	 * Input method for player 1 poker cards
	 * 
	 * @param scanner Scanner to read command line input
	 */
	private void getPlayer1(Scanner scanner) {
		
		System.out.println("Player 1:\n");
		System.out.println("Enter Poker card1");
		player1Cards.add(scanner.next());
		System.out.println("Enter Poker card2");
		player1Cards.add(scanner.next());
		System.out.println("Enter Poker card3");
		player1Cards.add(scanner.next());
		System.out.println("Enter Poker card4");
		player1Cards.add(scanner.next());
		System.out.println("Enter Poker card5");
		player1Cards.add(scanner.next());
		
		// size is less than 5, then duplicate card values
		if(5!=player1Cards.size()) {
			
			System.out.println("Duplicates card values");
			player1Cards.removeAll(player1Cards);
			getPlayer1(scanner);
		}
		
	}
	
	/**
	 * Input method for player 2 poker cards
	 * 
	 * @param scanner Scanner to read command line input
	 */
	private  void getPlayer2(Scanner scanner) {
		
		System.out.println("\nPlayer 2:\n");
		System.out.println("Enter Poker card1");
		player2Cards.add(scanner.next());
		System.out.println("Enter Poker card2");
		player2Cards.add(scanner.next());
		System.out.println("Enter Poker card3");
		player2Cards.add(scanner.next());
		System.out.println("Enter Poker card4");
		player2Cards.add(scanner.next());
		System.out.println("Enter Poker card5");
		player2Cards.add(scanner.next());
		
		// size is less than 5, then duplicate card values
		if(5!=player2Cards.size()) {
			
			System.out.println("Duplicates card values");
			player1Cards.removeAll(player2Cards);
			getPlayer2(scanner);
		}
		
	}
	
	private void createPlayer1() {
		
		// creating player 1
		player1 = new Player();
		
		for (String str : player1Cards) {
			
			String[] pokerCard = str.split(":");
			
			player1.getCardInHand().add(new Card(getSuit(pokerCard[1]), getValue(pokerCard[0])));
		}
		
	}
	
	private void createPlayer2() {
		
		// creating player 1
		player2 = new Player();
		
		for (String str : player2Cards) {
			
			String[] pokerCard = str.split(":");
			
			player2.getCardInHand().add(new Card(getSuit(pokerCard[1]), getValue(pokerCard[0])));
		}
		
	}
	
	/**
	 * Display the winner of Poker Game
	 */
	private void displayWinner() {
		
		// Decide Who is winner
		PokerHandRank.checkPlayerHand(player1, player2);
		
	}
	
	/**
	 * Getter method for Suit based on input value
	 * 
	 * @param suit input suit from user
	 * @return suitValue Suit of Card
	 */
	public Suit getSuit(String suit) {
		
		// Suits
		Suit suitValue = null;
		
		switch (suit) {
		
		case "H":
			suitValue = Suit.HEARTS;
			break;
			
		case "C":
			suitValue = Suit.CLUBS;
			break;
			
		case "S":
			suitValue = Suit.SPADES;
			break;
			
		case "D":
			suitValue = Suit.DIAMONDS;
			break;
			
		default:
			break;
		}
		
		// return the suit value
		return suitValue;
	}
	
	/**
	 * Getter method for Value based on user input
	 * 
	 * @param value Card Value from input
	 * @return cardValue Value of card
	 */
	public Value getValue(String value) {
		
		Value cardValue = null;
		
		switch (value) {
		
		case "2":
			
			cardValue = Value.TWO;
			break;
			
		case "3":
			cardValue = Value.THREE;
			break;
			
		case "4":
			cardValue = Value.FOUR;
			break;

		case "5":
			cardValue = Value.FIVE;
			break;
			
		case "6":
			cardValue = Value.SIX;
			break;
			
		case "7":
			cardValue = Value.SEVEN;
			break;
			
		case "8":
			cardValue = Value.EIGHT;
			break;
			
		case "9":
			cardValue = Value.NINE;
			break;
		
		case "10":
			cardValue = Value.TEN;
			break;
			
		case "J":
			cardValue = Value.JACK;
			break;
			
		case "Q":
			cardValue = Value.QUEEN;
			break;
			
		case "K":
			cardValue = Value.KING;
			break;
			
		case "A":
			cardValue = Value.ACE;
			break;

		default:
			break;
		}
		
		
		return cardValue;
		
	}
	
	public static void main(String[] args) {
		
		// Scanner to read user Input
		Scanner scanner = new Scanner(System.in);
		
		PokerGameRun gameRun = new PokerGameRun();
		
		// Game introduction
		gameRun.displayIntro();
		
		// Player 1 card input from user
		gameRun.getPlayer1(scanner);
		
		// Player 2 card input from user
		gameRun.getPlayer2(scanner);
		
		// close the scanner object
		scanner.close();
		
		// Poker Game starts
		gameRun.createPlayer1();
		gameRun.createPlayer2();
		
		// Display the winner
		gameRun.displayWinner();
		
	}
}
