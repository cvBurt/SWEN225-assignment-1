
public class Cell {
	Boolean northNeighbour;
	Boolean eastNeighbour;
	Boolean southNeighbour;
	Boolean westNeighbour;
	String room;
	char[] draw;

	public Cell(String room, char[] draw) {
		this.draw = draw;
		if (draw[0] == 'a') {
			this.northNeighbour = true;
			this.eastNeighbour = true;
			this.southNeighbour = true;
			this.westNeighbour = true;
		}
		else if (draw[0] == 'b') {
			this.northNeighbour = false;
			this.eastNeighbour = true;
			this.southNeighbour = true;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'c') {
			this.northNeighbour = false;
			this.eastNeighbour = false;
			this.southNeighbour = true;
			this.westNeighbour = true;
		}
		else if (draw[0] == 'd') {
			this.northNeighbour = true;
			this.eastNeighbour = true;
			this.southNeighbour = false;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'e') {
			this.northNeighbour = true;
			this.eastNeighbour = false;
			this.southNeighbour = false;
			this.westNeighbour = true;
		}
		else if (draw[0] == 'f') {
			this.northNeighbour = true;
			this.eastNeighbour = false;
			this.southNeighbour = true;
			this.westNeighbour = false;
		}
		else {
			this.northNeighbour = false;
			this.eastNeighbour = true;
			this.southNeighbour = false;
			this.westNeighbour = true;
		}
		this.room = room;
	}

	public Boolean getNorthNeighbour() {
		return northNeighbour;
	}

	public Boolean getEastNeighbour() {
		return eastNeighbour;
	}

	public Boolean getSouthNeighbour() {
		return southNeighbour;
	}

	public Boolean getWestNeighbour() {
		return westNeighbour;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getRoom() {
		return room;
	}

	public char[] getDraw() {
		return draw;
	}

}
