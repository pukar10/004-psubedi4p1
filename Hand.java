import javax.swing.text.JTextComponent;
import java.lang.reflect.Array;

/**************************************************************************
 * @author <INSERT YOUR NAME>
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: Hand.java
 *
 * Description: holds array of Cards. T = any subclass of Cards. represends a Hand of cards.
 * 				Works like an arraylist.
 *
 * 			    DYNAMIC ARRAYLIST!
 * 
 ***************************************************************************/

public class Hand<T extends Card>{

	// TO DO: add your implementation and JavaDoc

	private T[] cards;
	private T[] cardsTemp;
	private int numCards;

	/**
	 * constructor that creates Empty Hand created with size 5
	 */
	@SuppressWarnings("unchecked")
	public Hand(){
		// constructor
		// initial size of cards must be no greater than 5
		cards = (T[]) new Card[5];
	}
	
	public int numCards(){
		// return the number of cards
		// O(1)
		return this.numCards;
	}


	/**
	 * returns card from given index
	 *
	 * @param index
	 *     location in index you want to get card from
	 * @return returns card at selected index
	 */
	public T getCard(int index){
		// return card at index 
		// throw RuntimeException for invalid index
		// O(1)
		T temp;
		if(index > cards.length || index < 0){
			throw new RuntimeException();
		}
		if(cards[index] != null){
			//numCards--;
			temp = cards[index];
			//cards[index] = null;
			return temp;
		}else{
			throw new RuntimeException();
		}
	}

	/**
	 * sets the card at @param index to @param c
	 *
	 * @param index
	 *     index of the card you want to change
	 * @param c
	 *     what the index will now be set too.
	 */
	public void setCard(int index, T c){
		// change the card at index to be c	
		// throw RuntimeException for invalid index
		// O(1)
		try{
			cards[index] = c;
		}catch(RuntimeException e){
			System.out.println("invalid index: setCard ");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * adds a card to your hand. If your hand is full it will increase the size and add the card to that.
	 *
	 * @param c
	 *     the card you want to add to your hand.
	 */
	@SuppressWarnings("unchecked")
	public void addCard(T c){
		// add card c at the end 
		// O(N)
		if(cards.length == numCards){
			T[] temp = (T[]) new Card[cards.length+5];
			for(int i = 0; i < cards.length; i++){
				temp[i] = cards[i];
			}
			cards = temp;
			for(int i = 0; i < cards.length; i++){
				if(cards[i] == null){
					cards[i] = c;
					numCards++;
					return;
				}
			}
		}else{
			for(int i = 0; i < cards.length; i++){
				if(cards[i] == null){
					cards[i] = c;
					numCards++;
					return;
				}
			}
		}
	}


	/**
	 * return int index of the card given.
	 *
	 * @param c
	 *     Card that you want to find
	 * @return returns the index of the @param c. if not found returns -1.
	 */
	public int indexOf(T c){
		 // find the index of a given card c, 
		 // returns -1 if not found	
		 // O(N)
		int count = 0;
		if(c != null){
			for(Card x : cards){
				if(x != null && x.equals(c)){
					return count;
				}
				count++;
			}
		}else{
			return -1;
		}
		return -1;
	}


	/**
	 * Removes the card at the given @param index;
	 * runTime is O(1)
	 *
	 * @param index
	 *     index of the card you want to remove.
	 * @return returns the card that was just removed.
	 */
	public T removeCard(int index){
		// remove the card at index, 
		// throw RuntimeException for invalid index
		// O(N)
		try{
			T temp = cards[index];
			cards[index] = null;
			for(int i = index; i <= numCards+1; i++){
				cards[index] = cards[index+1];
			}
			numCards--;
			return temp;
		}catch(RuntimeException e){
			System.out.println("Invalid index: removeCard Hand.java");
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * looks for @param c, if found it removes the first instance and finishes. true if c found false if not.
	 *
	 * @param c
	 *     Card that you want removed
	 * @return returns true if removed, false if not found
	 */
	public boolean removeCard(T c){
		// remove card c, 
		// returns false if no such card
		// O(N)
		int index = 0;
		Card temp;
		for(Card x : cards){
			if(x.equals(c)){
				temp = cards[index];
				cards[index] = null;
				numCards--;
				return true;
			}else{
				index++;
			}
		}
		return false;
	}
	
	
  
	// --------------------------------------------------------
	// example test code... edit this as much as you want!
	// you will need a working CardSwitch class to run the given code


	// Not required, update for your testing purpose
	@Override
	public String toString(){
		// return string representation of hand
		// update if you want to include information for all cards in hand
		return "Hand with "+numCards+" cards";
		
		
  	}


	public static void main(String[] args) {
	
		CardSwitch card1 = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		CardSwitch card2 = new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES);
		CardSwitch card3 = new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS);
		
		
		Hand<CardSwitch> myHand = new Hand<CardSwitch>();
		myHand.addCard(card1);
		myHand.addCard(card2);

		//myHand[0] = card1 (ACE, SPADES)
		//myHand[1] = card2 (JACK, SPADES)
		//myHand.numCards = 2
		
		if ((myHand.numCards() == 2) && (myHand.getCard(0).equals(card1))){
			System.out.println("Yay 1");
		}
		
		myHand.addCard(card3);


		if ( card2.equals(myHand.removeCard(1)) && myHand.getCard(1).equals(card3)){
			System.out.println("Yay 2");
		}

		//myHand[0] = card1 (ACE, SPADES)
		//myHand[1] = card3 (NINE, Hearts)

		if ((myHand.indexOf(card1)==0) && (myHand.indexOf(card2) == -1 )){
			System.out.println("Yay 3");
		}

	}


}