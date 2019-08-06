
public class Card {
	private String type;
	private String id;
	private int startRow;
	private int startCol;
	private char[] initials;

	public Card(String type, String id) {
		this.type = type;
		this.id = id;
	}

	public Card(String type, String id, int startRow, int startCol, char[] initials) {
		this.type = type;
		this.id = id;
		this.startRow = startRow;
		this.startCol = startCol;
		this.initials = initials;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getStartCol() {
		return startCol;
	}

	public char[] getInitials() {
		return initials;
	}
}
