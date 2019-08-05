import java.util.*;

public class Cell {
	Boolean northNeighbour;
	Boolean eastNeighbour;
	Boolean southNeighbour;
	Boolean westNeighbour;
	String room;
	char[] draw;
	boolean occupied;
	char[] player;

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
		else if (draw[0] == 'g'){
			this.northNeighbour = false;
			this.eastNeighbour = true;
			this.southNeighbour = false;
			this.westNeighbour = true;
		}
		else if (draw[0] == 'h'){
			this.northNeighbour = true;
			this.eastNeighbour = false;
			this.southNeighbour = false;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'i'){
			this.northNeighbour = false;
			this.eastNeighbour = true;
			this.southNeighbour = false;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'j'){
			this.northNeighbour = false;
			this.eastNeighbour = false;
			this.southNeighbour = true;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'k'){
			this.northNeighbour = false;
			this.eastNeighbour = false;
			this.southNeighbour = false;
			this.westNeighbour = true;
		}
		this.room = room;
		this.occupied = false;
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
	
	public boolean hasPlayer() {
		return this.occupied;
	}

	public void setPlayer(char[] player) {
		this.player = player;
		occupied = true;
	}
	
	public char[] getPlayerInit() {
		return player;
	}
	
	public void removePlayer() {
		occupied = false;
	}
}