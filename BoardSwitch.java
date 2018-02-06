/**************************************************************************
 * @author <INSERT YOUR NAME>
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: BoardSwitch.java
 *
 * Description: Class for the game SWITCH, it will control the game. Chnage turns, add players get current player
 * get deck, and find the winner.
 * 
 ***************************************************************************/
public class BoardSwitch<T extends Card> extends Board<T>{
	
	// TO DO: add your implementation and JavaDoc
    private Deck myDeck;
    /**
     * Constructor for the BoardSwitch class. sets deck and initially makes numPlayers 0.
     *
     * @param deck
     *    the deck you want the board to use.
     */
    public BoardSwitch(Deck<T> deck){
		//constructor
		//start with zero players
        super(deck);
        super.numPlayer = 0;
	}

    /**
     * returns the current player on the board.
     *
     * @return the current player from the super class Board.
     */
    @Override
	public Player<T> getCurrentPlayer() {
		// return the current player
		// O(1)
        return super.currentPlayer;
	}

    /**
     * returns number of players on the board.
     *
     * @return returns the numPlayers from the board super class.
     */
    @Override
	public int getNumPlayers() {
		// return how many players 
		// O(1)
        return super.numPlayer;
	}

    /**
     * returns the deck in board class.
     *
     * @return deck in board class
     */
    @Override
	public Deck<T> getDeck(){
		//return the current deck
		// O(1)
        return super.deck;
	}

    /**
     * Moves the current player in board to the next player.
     *
     * @return false if we could not change turns. True if changeTurn was successful.
     */
    @Override
	public boolean changeTurn() {
		// move the current player to the next one in the linked list
		// return false if cannot change
		// O(1)
        if(super.currentPlayer.getNext() == null){
            return false;
        }else{
            super.currentPlayer = super.currentPlayer.getNext();
            return true;
        }
	}

    /**
     * inserts another player behind the current player by seeing how many people are playing than cycling through
     * them until we get behind current player and we insert there.
     *
     * @param x
     *     player that you want to insert behind current player.
     */
    @Override
	public void addPlayer(Player<T> x) {
		// add another player in the linked list
		// should add to the left of currentPlayer
		// O(N)
        if(super.numPlayer == 0) {
            super.currentPlayer = x;
            super.currentPlayer.setNext(x);
            super.numPlayer++;
            return;
        }
        if(super.numPlayer == 1){
            super.currentPlayer.setNext(x);
            x.setNext(super.currentPlayer);
            super.numPlayer++;
            return;
        }
        else{
            Player temp = super.currentPlayer;
            for(int i = 1; i < super.numPlayer; i++){
                temp = temp.getNext();
            }
            temp.setNext(x);
            x.setNext(super.currentPlayer);
            super.numPlayer++;
            return;
        }
	}

    /**
     * tempPlayerIterator just cycles through the circular linked list checking the points.
     * max holds the highest player points.
     * tempWinner will be the Player that is returned as the winner.
     * zero players no winner.
     * 1 player return the only person playing.
     *
     * @return cycles through the circular linked list and returns the player with the highest points.
     */
    public Player<T> findWinner(){
		// return the player with the highest point
		// O(N)
        Player tempPlayerIterator = super.currentPlayer;
        int max = 0;
        Player tempWinner = null;

        if(super.numPlayer == 0){
            return null;
        }
        if(super.numPlayer == 1){
            return super.currentPlayer;
        }else{
            for(int i = 0; i <= super.numPlayer; i++){
                if(tempPlayerIterator.getPoints() > max){
                    tempWinner = tempPlayerIterator;
                }
            }
            return tempWinner;
        }
	}

	//-----------------------------------------------------
	// example test code... edit this as much as you want!
	// you will need working CardSwitch, Hand, Player, Deck and PlaySwitch classes to run the given code
	
	public static void main(String[] args) {
		Deck<CardSwitch> deck = new Deck<CardSwitch>();
		PlaySwitch.init_deck(deck);
			
		BoardSwitch<CardSwitch> myBoard = new BoardSwitch<CardSwitch>(deck);
		Player<CardSwitch> player1 = new Player<CardSwitch>("Tom");
		Player<CardSwitch> player2 = new Player<CardSwitch>("Jerry");

		myBoard.addPlayer(player1);
//		System.out.println(myBoard.getNumPlayers());
		
		if (myBoard.getNumPlayers() ==1  && myBoard.getCurrentPlayer() == player1
			&& player1.getNext() == player1){
			System.out.println("Yay 1");
		}

		myBoard.addPlayer(player2);
//		System.out.println(myBoard.getNumPlayers());

		if (myBoard.getNumPlayers() == 2  && myBoard.getCurrentPlayer() == player1
			&& (myBoard.changeTurn()==true) && myBoard.getCurrentPlayer() == player2){
			System.out.println("Yay 2");
		}
		
		player1.receiveCard(new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES));
		System.out.println(player1.toString());
		player1.receiveCard(new CardSwitch(Card.Rank.JACK, Card.Suit.CLUBS));
		player2.receiveCard(new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS));
		player2.receiveCard(new CardSwitch(Card.Rank.THREE, Card.Suit.SPADES));

		if (player1.getNext() == player2 && player2.getNext() == player1
			&& myBoard.findWinner() == player2){
			System.out.println("Yay 3");
		}
		
	
	}
	

}
