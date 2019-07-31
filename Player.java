import java.util.*;

public class Player {
	String name;
	List<Card> hand;
	Cell location;
	
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
}
