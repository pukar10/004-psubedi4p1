
/**************************************************************************
 * @author Yutao Zhong and Jitin Krishnan
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: Card.java
 *
 * Description: Abstract Card class from which a card class specific to
 * any game can be constructed. This file SHOULD NOT be modified.
 * Each Card has a point and priority.
 * 
 ***************************************************************************/

public abstract class Card {
	
	enum Rank{
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}

	enum Suit{
		HEARTS, CLUBS, DIAMONDS, SPADES;
	}
	
	protected Rank rank;
	protected Suit suit;

	/**
	 * constructer for Card class, creates card rank, r, and suit ,s
	 * @param r = rank
	 *		  Holds an enum Rank
	 * @param s = suit
	 *	      Holds an enum Suit
	 */
	public Card(Rank r, Suit s){
		rank = r;
		suit = s;
	}

	/**
	 * return rank of card, implemented.
	 * @return rank
	 */
	public Rank getRank(){
		return rank;
	}

	/**
	 * return suit of card, implemented.
	 * @return suit
	 */
	public Suit getSuit(){
		return suit;
	}

	/**
	 * unimplemented method. Checks if two cards are equal, you choose what to compare.
	 * @param c
	 * 		  Checks c to see if it is equal to, whatever implementation added.
	 * @return
	 */
	public abstract boolean equals(Card c);
    
    abstract int getPoints();

	/**
	 * Returns a String version of the Card. Unimplemented.
	 * @return
	 */
	@Override
	public abstract String toString();

}
