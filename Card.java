
public class Card {
	private String type;
	private String id;
	private int startX;
	private int startY;
	private char[] initials;
	
	public Card(String type, String id) {
		this.type = type;
		this.id = id;
	}
	
	public Card(String type, String id, int startX, int startY, char[] initials) {
		this.type = type;
		this.id = id;
		this.startX = startX;
		this.startY = startY;
		this.initials = initials;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public char[] getInitials() {
		return initials;
	}
}

