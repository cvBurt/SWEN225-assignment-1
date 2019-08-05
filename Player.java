import java.util.*;

public class Player {
	private String name;
	private List<Card> hand;
	private Cell location;
	private boolean dead;
	
	public Player (String character, Cell location) {
		this.name = character;
		this.hand = new ArrayList<Card>();
		this.dead = false;
		this.location = location;
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
	 * @return
	 */
	public void setLocation(Cell loc) {
		this.location = loc;
	}
	
	/**
	 * returns the current location of the player
	 * @return
	 */
	public Cell getLocation() {
		return location;
	}
	
	/**
	 * returns the playable state of the player
	 * @return
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
	 * return a string representation of the players hand
	 * @return
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
