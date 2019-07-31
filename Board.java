import java.util.*;

public class Board {
	Cell board[][];
	String murderWeapon;
	String murderer;
	String murderRoom;

	public Board () {
		constructBoard();
	}

	public void constructBoard() {
		board = new Cell[48][50];
		String string = "";
		Cell cell;
		for (int column = 0; column < 48; column++) {
			if ((column >= 0 && column <= 17) || column >= 30) {
				string = " ";
			}
			else if (column == 20 || column == 27) {
				string = "|";
			}
			else if (column > 20 && column < 27) {
				string = "¯";
			}
			else {
				string = "X";
			}
			cell = new Cell(string);
			board[column][0] = cell;
		}

		for (int column = 0; column < 48; column++) {
			if ((column >= 0 && column <= 17) || column >= 30 || (column > 20 && column < 27)) {
				string = " ";
			}
			else if (column == 20 || column == 27) {
				string = "|";
			}
			else {
				string = "X";
			}
			cell = new Cell(string);
			board[column][1] = cell;
		}

		for (int column = 0; column < 48; column++) {
			if (column == 12 || column == 13 || column == 34 || column == 35 || (column > 20 && column < 27)) {
				string = " ";
			}
			else if ((column > 0 && column < 11) ||(column > 36 && column < 47)) {
				string = "¯";
			}
			else if (column == 0 || column == 11 || column == 20 || column == 27 || column == 36 || column == 47) {
				string = "|";
			}
			else {
				string = "X";
			}
			cell = new Cell(string);
			board[column][2] = cell;
		}

		for (int column = 0; column < 48; column++) {
			if ((column > 0 && column < 11) || (column > 36 && column < 47) || column == 12 || column == 13 || column == 34 || column == 35 || (column > 20 && column < 27)) {
				string = " ";
			}
			else if (column == 0 || column == 11 || column == 20 || column == 27 || column == 36 || column == 47) {
				string = "|";
			}
			else {
				string = "X";
			}
			cell = new Cell(string);
			board[column][3] = cell;
		}

		for (int column = 0; column < 48; column++) {
			if (column == 0 || column == 11 || column == 16 || column == 31 || column == 36 || column == 47) {
				string = "|";
			}
			else if ((column > 0 && column < 11) || (column > 36 && column < 47) || (column > 20 && column < 27)) {
				string = " ";
			}
			else if (column > 16 & column < 31) {
				string = "¯";	
			} 
			else {
				string = "X";
			}
			cell = new Cell(string);
			board[column][4] = cell;
		}
		
		for (int column = 0; column < 48; column++) {
			if (column == 0 || column == 11 || column == 16 || column == 31 || column == 36 || column == 47) {
				string = "|";
			}
			else if ((column > 0 && column < 11) || (column > 36 && column < 47) || (column > 16 && column < 31)) {
				string = " ";
			}
			else {
				string = "X";
			}
			cell = new Cell(string);
			board[column][5] = cell;
			board[column][6] = cell;
			board[column][7] = cell;
			board[column][8] = cell;
			board[column][9] = cell;
		}
		
		for (int column = 0; column < 48; column++) {
			if (column == 0 || column == 11 || column == 36 || column == 45) {
				string = "|";
			}
			else if ((column > 0 && column < 11) || (column > 36 && column < 45) || (column >= 16 && column <= 31)) {
				string = " ";
			}
			else if (column == 46 || column == 47) {
				string = "¯";	
			} 
			else {
				string = "X";
			}
			cell = new Cell(string);
			board[column][10] = cell;
		}
		for (int column = 0; column < 48; column++) {
			if (column == 0 || column == 11 || column == 36 || column == 45) {
				string = "|";
			}
			else if ((column > 0 && column < 11) || (column > 36 && column < 48) || (column >= 16 && column <= 31)) {
				string = " ";
			}
			else {
				string = "X";
			}
			cell = new Cell(string);
			board[column][11] = cell;
		}

	}

	public void draw() {
		for (int j = 0; j < 50; j++) {
			System.out.print("\n");
			for (int i = 0; i < 48; i++) {
				Cell cell = board[i][j];
				System.out.print(cell.getRoom());
			}
		}
	}
}
