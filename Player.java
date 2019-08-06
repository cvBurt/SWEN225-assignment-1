import java.util.*;

public class Player {
	private String name;
	private List<Card> hand;
	private Cell location;
	private boolean dead;
	private String prevRoundRoom;
	private char[] initials;
	
	public Player (String character, Cell location, char[] initials) {
		this.name = character;
		this.hand = new ArrayList<Card>();
		this.dead = false;
		this.location = location;
		this.prevRoundRoom = location.getRoom();
		this.initials = initials;
	}

	/**
	 * returns the name of this player
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns the hand of this player
	 * @return
	 */
	public List<Card> getHand() {
		return hand;
	}

	/**
	 * adds a card to the hand of the player
	 * @param card
	 */
	public void addCardToHand(Card card) {
		this.hand.add(card);
	}
	
	/**
	 * sets the current location of the player
	 */
	public void setLocation(Cell loc) {
		this.location = loc;
	}
	
	/**
	 * returns the current location of the player
	 * @return the current location of this player
	 */
	public Cell getLocation() {
		return location;
	}
	
	/**
	 * returns the playable state of the player
	 * @return the status of this player
	 */
	public boolean getStatus() {
		return dead;
	}
	
	/**
	 * sets this player to be 'dead'
	 */
	public void kill() {
		dead = true;
	}
	
	/**
	 * return the room that this player was in for the previous round
	 * @return
	 */
	public String getPrevRoundRoom() {
		return prevRoundRoom;
	}

	/**
	 * sets the room that this player was in for the previous round
	 * @param prevRoundRoom
	 */
	public void setPrevRoundRoom(String prevRoundRoom) {
		this.prevRoundRoom = prevRoundRoom;
	}
	
	/**
	 * return the char[] that displays this players initials
	 * @return
	 */
	public char[] getPlayerInitials() {
		return this.initials;
	}

	/**
	 * return a string representation of the players hand
	 * @return a the players hand as a string
	 */
	public String showHand() {
		StringBuilder toReturn = new StringBuilder();
		int i;
		for(i=0; i<hand.size()-1; i++) {
			toReturn.append(hand.get(i).getId() +", ");
		}
		toReturn.append(hand.get(i).getId() +".");
		return toReturn.toString();
	}
}
