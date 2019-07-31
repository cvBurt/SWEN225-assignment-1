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
		board = new Cell[24][25];
		char[] blank = {'a',' ',' ',' ',' '};
		char[] topLeftCorner = {'b','|', '¯', '|', ' '};
		char[] topRightCorner = {'c','¯','|', '¯',' '};
		char[] bottomLeftCorner = {'d','|', ' ', '¯', '¯'};
		char[] bottomRightCorner = {'e',' ', '|', '¯', '¯'};
		char[] rightEdge = {'f','|', ' ', '|', ' '};
		char[] leftEdge = {'f',' ', '|', ' ', '|'};
		char[] topEdge = {'g','¯', '¯', ' ', ' '};
		char[] bottomEdge = {'g',' ', ' ', '¯', '¯'};
	}

	public void draw() {
		for (int j = 0; j < 25; j++) {
			System.out.print("\n");
			for (int i = 0; i < 24; i++) {
				Cell cell = board[i][j];
				System.out.print(cell.getRoom());
			}
		}
	}
}
