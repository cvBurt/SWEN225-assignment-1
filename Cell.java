import java.util.*;

import javax.swing.ImageIcon;

public class Cell {
	Boolean northNeighbour;
	Boolean eastNeighbour;
	Boolean southNeighbour;
	Boolean westNeighbour;
	String room;
	ImageIcon pic;
	char[] draw;
	boolean occupied;
	boolean isExit;
	Player player;
	ImageIcon exit;
	int x;
	int y;
	boolean redHighlight;
	boolean greenHighlight;

	public Cell(String room, char[] draw, ImageIcon pic) {
		this.draw = draw;
		if (draw[0] == 'a') { // allows neighbours in all directions
			this.northNeighbour = true;
			this.eastNeighbour = true;
			this.southNeighbour = true;
			this.westNeighbour = true;
		}
		else if (draw[0] == 'b') { // allows neighbour in south and right directions
			this.northNeighbour = false;
			this.eastNeighbour = true;
			this.southNeighbour = true;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'c') { // allows neighbours in down and left directions
			this.northNeighbour = false;
			this.eastNeighbour = false;
			this.southNeighbour = true;
			this.westNeighbour = true;
		}
		else if (draw[0] == 'd') { // allows neighbours in up and right directions
			this.northNeighbour = true;
			this.eastNeighbour = true;
			this.southNeighbour = false;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'e') { // allows neighbours in up and left directions
			this.northNeighbour = true;
			this.eastNeighbour = false;
			this.southNeighbour = false;
			this.westNeighbour = true;
		}
		else if (draw[0] == 'f') { // allows neighbours in up and down directions
			this.northNeighbour = true;
			this.eastNeighbour = false;
			this.southNeighbour = true;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'g'){ // allow neighbours in left and right directions
			this.northNeighbour = false;
			this.eastNeighbour = true;
			this.southNeighbour = false;
			this.westNeighbour = true;
		}
		else if (draw[0] == 'h'){ // allow neighbour only in the up direction
			this.northNeighbour = true;
			this.eastNeighbour = false;
			this.southNeighbour = false;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'i'){ // allows neighbour only in the right direction
			this.northNeighbour = false;
			this.eastNeighbour = true;
			this.southNeighbour = false;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'j'){ // allows neighbour only in the down direction
			this.northNeighbour = false;
			this.eastNeighbour = false;
			this.southNeighbour = true;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'k'){ // allows neighbour only in the left direction
			this.northNeighbour = false; 
			this.eastNeighbour = false;
			this.southNeighbour = false;
			this.westNeighbour = true;
		}
		else if (draw[0] == 'l'){ // doesn't allow neighbour in the right direction
			this.northNeighbour = true; 
			this.eastNeighbour = false;
			this.southNeighbour = true;
			this.westNeighbour = true;
		}
		else if (draw[0] == 'm'){ // doesn't allow neighbour in the left direction
			this.northNeighbour = true; 
			this.eastNeighbour = true;
			this.southNeighbour = true;
			this.westNeighbour = false;
		}
		else if (draw[0] == 'n'){ // doesn't allow neighbour in the up direction
			this.northNeighbour = false; 
			this.eastNeighbour = true;
			this.southNeighbour = true;
			this.westNeighbour = true;
		}
		else if (draw[0] == 'o'){ // doesn't allow neighbour in the down direction
			this.northNeighbour = true; 
			this.eastNeighbour = true;
			this.southNeighbour = false;
			this.westNeighbour = true;
		}
		this.pic = pic;
		this.room = room;
		this.occupied = false;
		this.redHighlight = false;
		this.greenHighlight = false;
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
	
	public ImageIcon getPic() {
		return pic;
	}
	
	public boolean hasPlayer() {
		return this.occupied;
	}

	public void setPlayer(Player player) {
		this.player = player;
		occupied = true;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void removePlayer() {
		occupied = false;
	}
	
	public void setExit(ImageIcon exit) {
		this.exit = exit;
		this.isExit = true;
	}
	
	public ImageIcon getExit() {
		return exit;
	}
	
	public void removeExit() {
		isExit = false;
	}
	
	public boolean isExit() {
		return this.isExit;
	}
	
	public void setPos(int row,int col) {
		this.x = col;
		this.y = row;
	}

	public int getX() {
		return y;
	}
	
	public int getY() {
		return x;
	}
	
	public boolean isRedHighlight() {
		return redHighlight;
	}
	
	public boolean isGreenHighlight() {
		return greenHighlight;
	}
	
	public void setRedHighLight() {
		redHighlight = true;
		greenHighlight = false;
	}
	
	public void setGreenHighlight() {
		greenHighlight = true;
		redHighlight = false;
	}
	
	public void removeHighlight() {
		greenHighlight = false;
		redHighlight = false;
	}
}