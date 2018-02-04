/**************************************************************************
 * @author <INSERT YOUR NAME>
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: CardSwitch.java
 *
 * Description: CardSwitch class that extends Card. Can compare cards, get points from cards and toString (SUIT,RANK)
 * 
 ***************************************************************************/

public class CardSwitch extends Card{

	// TO DO: fill the code below and add JavaDoc


	/**
     * Constructor that Creates a card for the game switch
     *
	 * @param r
	 *     Rank
	 * @param s
	 *     Suit
	 */
	public CardSwitch(Rank r, Suit s){
        // constructor to create card for the game Switch
        super(r ,s);
	}

    /**
     * returns true if Card is of same Rank and Suit
     *
     * @param anotherCard
     *     Card you want to compare
     * @return
     *     true or false if they have same Rank and Suit
     */
    public boolean equals(Card anotherCard){
		// checks if two cards equals  and returns a boolean
		if(this.getRank() == anotherCard.getRank() && this.getSuit() == anotherCard.getSuit()) {
            return true;
        } else {
            return false;
        }
	}

    /**
     * returns points of a card, in int.
     *
     * @return
     *     Returns an int value representing points, calculated from Card.Rank
     */
    public int getPoints(){
	    // return points of the card
        if(super.getRank() == Rank.ACE){
            return 1;
        }
        if(super.getRank() == Rank.TWO){
            return 2;
        }
        if(super.getRank() == Rank.THREE){
            return 3;
        }
        if(super.getRank() == Rank.FOUR){
            return 4;
        }
        if(super.getRank() == Rank.FIVE)
            return 5;
        if(super.getRank() == Rank.SIX)
            return 6;
        if(super.getRank() == Rank.SEVEN)
            return 7;
        if(super.getRank() == Rank.EIGHT)
            return 8;
        if(super.getRank() == Rank.NINE)
            return 9;
        if(super.getRank() == Rank.TEN)
            return 10;
        if(super.getRank() == Rank.JACK)
            return 10;
        if(super.getRank() == Rank.QUEEN) {
            return 10;
        }
        if(super.getRank() == Rank.KING) {
            return 10;
        }
        return 0;
    }

    /**
     * @return String representation of the Card, in form (Rank,Suit) in all CAPS, no Spaces.
     */
    @Override
	public String toString(){
		// convert card to string consisting of as "(rank,suit)"
		// see examples below for format
        return ("("+this.getRank().toString().toUpperCase()+","+this.getSuit().toString().toUpperCase()+")");
	}
	
	//----------------------------------------------------
	//example test code... edit this as much as you want!
	public static void main(String[] args) {
		CardSwitch card = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		
		if (card.getRank().equals(Card.Rank.ACE)){
			System.out.println("Yay 1");
		}
		
		if (card.toString().equals("(ACE,SPADES)")){
			System.out.println("Yay 2");
		}

		if (card.getPoints()==1){
			System.out.println("Yay 3");
		}
	}

}