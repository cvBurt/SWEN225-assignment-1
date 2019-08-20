import java.util.*;

import javax.swing.ImageIcon;

public class Player implements Comparable{
	private String name;
	private String characterName;
	private List<Card> hand;
	private Cell location;
	private boolean dead;
	private String prevRoundRoom;
	private ImageIcon image;
	private ImageIcon roomImage;
	private int id;
	private boolean inRoom;

	public Player (String player, Cell location, String character, ImageIcon image, ImageIcon roomImage, int id) {
		this.name = player;
		this.characterName = character;
		this.hand = new ArrayList<Card>();
		this.dead = false;
		this.location = location;
		this.prevRoundRoom = location.getRoom();
		this.image = image;
		this.roomImage = roomImage;
		this.id = id;
		this.inRoom = false;
	}


	public String getName() {
		return name;
	}

	/**
	 * returns the characterName of this player
	 * @return
	 */
	public String getcharacterName() {
		return characterName;
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
	 * returns the image of the player
	 * @return the image of this player
	 */
	public ImageIcon getImage() {
		if(inRoom) {
			return roomImage;
		}
		return image;
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
	
	/**
	 * used for displaying name in the GUI
	 * @return
	 */
	public String dispName() {
		return this.name +" ("+this.characterName+")";
	}


	@Override
	public int compareTo(Object o) {
		Player other = (Player) o;
		if(this.id < other.id) return -1;
		else if(this.id > other.id) return 1;
		return 0;
	}
	
	public void toggleRoom() {
		inRoom = !inRoom;
	}
	
}