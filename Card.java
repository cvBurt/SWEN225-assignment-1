import javax.swing.ImageIcon;

public class Card {
	private String type;
	private String id;
	private int startRow;
	private int startCol;
	private ImageIcon img;
	private ImageIcon card;
	private ImageIcon roomImg;

	public Card(String type, String id, ImageIcon card) {
		this.type = type;
		this.id = id;
		this.card = card;
	}

	public Card(String type, String id, int startRow, int startCol, ImageIcon img, ImageIcon card, ImageIcon roomImg) {
		this.type = type;
		this.id = id;
		this.startRow = startRow;
		this.startCol = startCol;
		this.img = img;
		this.card = card;
		this.roomImg = roomImg;
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

	public ImageIcon getImg() {
		return img;
	}
	public ImageIcon getCardImg() {
		return card;
	}

	public ImageIcon getRoomImg() {
		return roomImg;
	}
}

