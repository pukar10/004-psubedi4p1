/**************************************************************************
 * @author <INSERT YOUR NAME>
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 *
 * File Name: Player.java
 *
 * Description: is a Linked List Node. has link to next Player.
 *
 ***************************************************************************/
class Player <T extends Card> {

	// required fields
	private String name;
	private int points;
	private Hand<T> hand;
	private Player<T> next;

	/**
	 * Constructor for class player. initialize all variables and set name.
	 *
	 * @param name
	 *     name of the player
	 */
	public Player(String name){
		//constructor
		this.name = name;
		points = 0;
		hand = new Hand<>();
		next = null;
	}

	/**
	 * sets the next node to the @param p
	 *
	 * @param p
	 *     player you want to set as next
	 */
	public void setNext(Player<T> p){
		//set next player
		this.next = p;
	}

	/**
	 * returns the next Node which is a player.
	 *
	 * @return returns the next player.
	 */
	public Player<T> getNext(){
		//return next player
		return this.next;
	}

	/**
	 * checks if there is a next player.
	 *
	 * @return true if next != null, false if next == null.
	 */
	public boolean hasNext() {
		// whether there is a player after me
		return this.next != null;
	}

	/**
	 * returns the total points of all cards in the players hand.
	 *
	 * @return returns int of total points of all cards player has in hand.
	 */
	public int getPoints(){
		// return points of this player
		// determined by cards in hand
		int totalPoints = 0;
		for(int i = 0; i < hand.numCards(); i++){
			Card temp = hand.getCard(i);
			totalPoints += temp.getPoints();
		}
		points = totalPoints;
		return totalPoints;
	}

	/**
	 * return player name.
	 *
	 * @return the player name
	 */
	public String getName(){
		// return name of the player
		return this.name;
	}


	/**
	 * player adds a card to hand, not repeat, and updates points accordingly.
	 *
	 * @param c
	 *     card that is being received by player.
	 * @return returns false if hand already has card, true if doesn't.
	 */
	public boolean receiveCard(T c){
		// receive a card and add it to hand
		// return
		if (hand.indexOf(c) == -1) {
			System.out.println("Card not found");
			return false;
		}else{
			hand.addCard(c);
			getPoints();
			System.out.println("total points: "+getPoints());
			return true;
		}

	}

	/**
	 * checks if card c is in hand.
	 *
	 * @param c
	 *     card you want to check for.
	 * @return true if card c is in hand.
	 */
	public boolean hasCard(T c){
		// return checking: whether we have the card in hand
		return (hand.indexOf(c) != -1);
	}

	/**
	 * removes Card param c, from the hand and updates points.
	 *
	 * @param c
	 *     Card that you want to play/remove
	 * @return if card was found and removed or not. true, false respectively.
	 */
	public boolean playCard(T c){
		// give away one card from hand
		// return false if card not present
		if(this.hasCard(c)){
			hand.removeCard(c);
			getPoints();
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Removs card that the given index, exception handling is done at hand.removeCard so I didnt do it here.
	 *
	 * @param index
	 *     index of the desired card to play from your hand.
	 * @return the card at the given index.
	 */
	public T playCard(int index){
		// give away the card at index
		// throw RuntimeException for invalid index
		T temp = hand.removeCard(index);
		if(temp != null){
			return temp;
		}else{
			return temp;
		}
	}



	//---------------------------------------------------
	//example test code... edit this as much as you want!
	// you will need working CardSwitch and Hand classes to run the given code


	public String toString(){
		// Not required; edit for your own testing
		return "Player "+ name;
	}


	public static void main(String[] args) {
		CardSwitch card1 = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		CardSwitch card2 = new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES);
		CardSwitch card3 = new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS);
		Player<CardSwitch> player1 = new Player<>("Tom");
		Player<CardSwitch> player2 = new Player<>("Jerry");

		player1.receiveCard(card2);
		player1.receiveCard(card3);
		player2.receiveCard(card1);
		player1.setNext(player2);

		if (player1.getName().equals("Tom") && player1.getNext() == player2){
			System.out.println("Yay 1");
		}
		if (player1.hasCard(card2) == true && player1.getPoints() == 19){
			System.out.println("Yay 2");
		}
		if ((player2.hasNext()==false) && player1.playCard(0) == card2){
			System.out.println("Yay 3");
		}

	}


}