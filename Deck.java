/**************************************************************************
 * @author Yutao Zhong and Jitin Krishnan
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: Deck.java
 *
 * Description: Class representing a deck of cards with basic functionalities
 * of shuffling, adding, dealing, etc.
 *
 * TASK: Comment using JavaDoc and show the Big-O runtime of each method.
 * Code on this file should NOT be modified.
 * 
 ***************************************************************************/

public class Deck<T extends Card> {

	private Hand<T> setOfCards;

	/**
	 * Creates a new empty hand which holds cards.
	 * initializes setOfCards.
	 */
	public Deck(){
		setOfCards = new Hand<T>();
	}

	/**
	 * adds a non-existing card to your deck and updates cardCount.
	 * runtime to add a card is O(1).
	 *
	 * @param c
	 *     the card you want to hadd to your hand.
	 * @return true if successful adds card and updates cardCount. False if card was already in deck.
	 */
	public boolean addCard(T c){
		if (hasCard(c)){
			return false;
		}else{
			setOfCards.addCard(c);
			return true;
		}
	}

	/**
	 * checks to see if your deck already has the card.
	 * runTime of hasCard is O(1)
	 *
	 * @param c
	 *     the card you are searching for in the deck.
	 * @return true if the card was found. False if the card was not found.
	 */
	public boolean hasCard(T c){
		if(setOfCards.indexOf(c) == -1){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * Randomly shuffles the deck.
	 * runTime of shuffle is o(n)
	 */
	public void shuffle() {
		for (int i = setOfCards.numCards()-1; i >= 0; i-- ) {
			int rand = (int)(Math.random()*(i+1));
	        T temp = setOfCards.getCard(i);
            	setOfCards.setCard(i, setOfCards.getCard(rand));
            	setOfCards.setCard(rand, temp);
	    }
	}

	/**
	 * returns the last card in the deck, removes it, and updates count.
	 * runTime is O(1)
	 *
	 * @return the last card in the deck.
	 */
	public T dealNextCard() {
		
		if(setOfCards.numCards()==0) return null;
		T temp = this.setOfCards.removeCard(setOfCards.numCards()-1);

		return temp;
	}

	/**
	 * checks to se if the deck is empty
	 *runTime is O(1)
	 *
	 * @return if true deck is empty, if false deck is not empty.
	 */
	public boolean isEmpty() {
		return this.setOfCards.numCards() == 0;
	}

	/**
	 * gets the number of cards in the deck.
	 *runTime is O(1)
	 *
	 * @return the number of cards in the deck.
	 */
	public int cardCount(){
		return this.setOfCards.numCards();
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("Deck ");
    		int numCards = cardCount();
    		if (numCards ==0){
    			sb.append("currently with no cards.");
    		}
    		else{
    			sb.append("with "+numCards+ " cards:\n");
    			sb.append(setOfCards.toString());
    		}
    		return sb.toString();
  	}

}
