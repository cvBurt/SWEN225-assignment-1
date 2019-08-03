import java.util.*;

public class Player {
	private String name;
	private List<Card> hand;
	private Cell location;
	
	public Player (String character) {
		this.name = character;
		this.hand = new ArrayList<Card>();
	}

	public String getName() {
		return name;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void addCardToHand(Card card) {
		this.hand.add(card);
	}
	
	public void setLocation(Cell loc) {
		this.location = loc;
	}
	
	public Cell getLocation() {
		return location;
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
