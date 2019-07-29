
public class Cell {
	Cell northNeighbour;
	Cell eastNeighbour;
	Cell southNeighbour;
	Cell westNeighbour;
	String room;
	
	public Cell(Cell north, Cell east, Cell south, Cell west, String room) {
		this.northNeighbour = north;
		this.eastNeighbour = east;
		this.southNeighbour = south;
		this.westNeighbour = west;
		this.room = room;
	}

	public Cell getNorthNeighbour() {
		return northNeighbour;
	}

	public Cell getEastNeighbour() {
		return eastNeighbour;
	}

	public Cell getSouthNeighbour() {
		return southNeighbour;
	}

	public Cell getWestNeighbour() {
		return westNeighbour;
	}

	public String getRoom() {
		return room;
	}
	
}
