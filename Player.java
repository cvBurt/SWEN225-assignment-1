import java.util.*;

public class Player {
	String name;
	List<Card> hand = new ArrayList<Card>();
	List<Card> checkList;
	
	
	public Player (String character, List<Card> hand) {
		this.name = character;
		this.hand = hand;
		this.checkList = hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public List<Card> getCheckList() {
		return checkList;
	}

	public void setCheckList(List<Card> checkList) {
		this.checkList = checkList;
	}
	
	

}
