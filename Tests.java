import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class Tests{

	@Test
	public void test01(){
		Card card = new Card("character","Miss Scarlet",7,24,new char[]{' ','M',' ',' ','S'});
		Card card2 = new Card("weapon", "Lead Pipe");
		assertTrue(card.getType().equals("character"));
		assertTrue(card.getId().equals("Miss Scarlet"));
		assertTrue(card.getInitials()[0] == ' ');
		assertTrue(card.getInitials()[1] == 'M');
		assertTrue(card.getInitials()[2] == ' ');
		assertTrue(card.getInitials()[3] == ' ');
		assertTrue(card.getInitials()[4] == 'S');
		assertTrue(card.getStartRow() == 7);
		assertTrue(card.getStartCol() == 24);
		assertTrue(card2.getType().equals("weapon"));
		assertTrue(card2.getId().equals("Lead Pipe"));
	}

	@Test
	public void test02() {
		char[] blank = {'a',' ',' ',' ',' '};
		Cell cell = new Cell("Hallway", blank);
		assertTrue(cell.getNorthNeighbour() == true);
		assertTrue(cell.getSouthNeighbour() == true);
		assertTrue(cell.getEastNeighbour() == true);
		assertTrue(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Hallway"));
	}

	@Test
	public void test03() {
		char[] blank = {'b',' ',' ',' ',' '};
		Cell cell = new Cell("Kitchen", blank);
		assertFalse(cell.getNorthNeighbour() == true);
		assertTrue(cell.getSouthNeighbour() == true);
		assertTrue(cell.getEastNeighbour() == true);
		assertFalse(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Kitchen"));
	}

	@Test
	public void test04() {
		char[] blank = {'c',' ',' ',' ',' '};
		Cell cell = new Cell("Billiard Room", blank);
		assertFalse(cell.getNorthNeighbour() == true);
		assertTrue(cell.getSouthNeighbour() == true);
		assertFalse(cell.getEastNeighbour() == true);
		assertTrue(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Billiard Room"));
		assertTrue(cell.getDraw().equals(blank));
	}

	@Test
	public void test05() {
		char[] blank = {'d',' ',' ',' ',' '};
		Cell cell = new Cell("Library", blank);
		cell.setRoom("Kitchen");
		assertTrue(cell.getNorthNeighbour() == true);
		assertFalse(cell.getSouthNeighbour() == true);
		assertTrue(cell.getEastNeighbour() == true);
		assertFalse(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Kitchen"));
	}

	@Test
	public void test06() {
		char[] blank = {'e',' ',' ',' ',' '};
		Cell cell = new Cell("Hallway", blank);
		char[] missScarlet = {' ','M',' ',' ','S'};
		cell.setPlayer(missScarlet);
		assertTrue(cell.getNorthNeighbour() == true);
		assertFalse(cell.getSouthNeighbour() == true);
		assertFalse(cell.getEastNeighbour() == true);
		assertTrue(cell.getWestNeighbour() == true);
		assertTrue(cell.getPlayerInit().equals(missScarlet));
		assertTrue(cell.getRoom().equals("Hallway"));
	}

	@Test
	public void test07() {
		char[] blank = {'f',' ',' ',' ',' '};
		Cell cell = new Cell("Billiard Room", blank);
		char[] missScarlet = {' ','M',' ',' ','S'};
		assertFalse(cell.hasPlayer());
		cell.setPlayer(missScarlet);
		assertTrue(cell.hasPlayer());
		cell.removePlayer();
		assertFalse(cell.hasPlayer());
		assertTrue(cell.getNorthNeighbour() == true);
		assertTrue(cell.getSouthNeighbour() == true);
		assertFalse(cell.getEastNeighbour() == true);
		assertFalse(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Billiard Room"));
	}

	@Test
	public void test08() {
		char[] blank = {'g',' ',' ',' ',' '};
		Cell cell = new Cell("Conservatory", blank);
		assertFalse(cell.getNorthNeighbour() == true);
		assertFalse(cell.getSouthNeighbour() == true);
		assertTrue(cell.getEastNeighbour() == true);
		assertTrue(cell.getWestNeighbour() == true);
		cell.setPos(5, 6);
		assertTrue(cell.getX() == 5);
		assertTrue(cell.getY() == 6);
		assertTrue(cell.getRoom().equals("Conservatory"));
	}

	@Test
	public void test09() {
		char[] blank = {'h',' ',' ',' ',' '};
		Cell cell = new Cell("Hallway", blank);
		assertTrue(cell.getNorthNeighbour() == true);
		assertFalse(cell.getSouthNeighbour() == true);
		assertFalse(cell.getEastNeighbour() == true);
		assertFalse(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Hallway"));
	}

	@Test
	public void test10() {
		char[] blank = {'i',' ',' ',' ',' '};
		Cell cell = new Cell("Hallway", blank);
		assertFalse(cell.getNorthNeighbour() == true);
		assertFalse(cell.getSouthNeighbour() == true);
		assertTrue(cell.getEastNeighbour() == true);
		assertFalse(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Hallway"));
	}

	@Test
	public void test11() {
		char[] blank = {'j',' ',' ',' ',' '};
		Cell cell = new Cell("Hallway", blank);
		assertFalse(cell.getNorthNeighbour() == true);
		assertTrue(cell.getSouthNeighbour() == true);
		assertFalse(cell.getEastNeighbour() == true);
		assertFalse(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Hallway"));
	}

	@Test
	public void test12() {
		char[] blank = {'k',' ',' ',' ',' '};
		Cell cell = new Cell("Hallway", blank);
		assertFalse(cell.getNorthNeighbour() == true);
		assertFalse(cell.getSouthNeighbour() == true);
		assertFalse(cell.getEastNeighbour() == true);
		assertTrue(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Hallway"));
	}

	@Test
	public void test13() {
		char[] blank = {'l',' ',' ',' ',' '};
		Cell cell = new Cell("Hallway", blank);
		assertTrue(cell.getNorthNeighbour() == true);
		assertTrue(cell.getSouthNeighbour() == true);
		assertFalse(cell.getEastNeighbour() == true);
		assertTrue(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Hallway"));
	}

	@Test
	public void test14() {
		char[] blank = {'m',' ',' ',' ',' '};
		Cell cell = new Cell("Hallway", blank);
		assertTrue(cell.getNorthNeighbour() == true);
		assertTrue(cell.getSouthNeighbour() == true);
		assertTrue(cell.getEastNeighbour() == true);
		assertFalse(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Hallway"));
	}

	@Test
	public void test15() {
		char[] blank = {'n',' ',' ',' ',' '};
		Cell cell = new Cell("Hallway", blank);
		assertFalse(cell.getNorthNeighbour() == true);
		assertTrue(cell.getSouthNeighbour() == true);
		assertTrue(cell.getEastNeighbour() == true);
		assertTrue(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Hallway"));
	}

	@Test
	public void test16() {
		char[] blank = {'0',' ',' ',' ',' '};
		Cell cell = new Cell("Hallway", blank);
		assertTrue(cell.getNorthNeighbour() == true);
		assertFalse(cell.getSouthNeighbour() == true);
		assertTrue(cell.getEastNeighbour() == true);
		assertTrue(cell.getWestNeighbour() == true);
		assertTrue(cell.getRoom().equals("Hallway"));
	}

	@Test
	public void test17() {
		String output = "\n" +
				"                 |⌈⌉|¯¯¯¯¯¯|⌈⌉|                 \n" +
				"                 |⌊⌋|      |⌊⌋|                 \n" +
				"|¯¯¯¯¯¯¯¯¯¯| |⌈⌉⌈⌉⌈⌉|      |⌈⌉⌈⌉⌈⌉| |¯¯¯¯¯¯¯¯¯¯|\n" +
				"|          | |⌊⌋⌊⌋⌊⌋|      |⌊⌋⌊⌋⌊⌋| |          |\n" +
				"|          |⌈⌉⌈⌉|¯¯¯        ¯¯¯|⌈⌉⌈⌉| Conser-  |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋| vatory   |\n" +
				"| Kitchen  |⌈⌉⌈⌉|              |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|          |\n" +
				"|          |⌈⌉⌈⌉|   Ball Room  |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|/        ¯¯\n" +
				"|          |⌈⌉⌈⌉/             / ⌈⌉⌈⌉⌈⌉|      |  \n" +
				"¯¯         |⌊⌋⌊⌋\\             \\ ⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯\n" +
				"  |        |⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|              |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"  ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| ¯¯\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯\\/¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|   \n" +
				"  | ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯¯¯¯¯¯¯¯|\n" +
				"  | ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |\n" +
				"|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉/          |\n" +
				"|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\\          |\n" +
				"|         ¯¯¯¯¯|⌈⌉⌈⌉|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉| Billiard |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|   Room   |\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|          |\n" +
				"|   Dining    / ⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|    Room     \\ ⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯\\/¯¯\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|¯¯¯\\/¯¯¯¯| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|         | \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉|¯          ¯|\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|        |⌊⌋⌊⌋|            |\n" +
				" |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|        |⌈⌉⌈⌉/   Library  |\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯⌊⌋⌊⌋\\            |\n" +
				"⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|            |\n" +
				"⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯          ¯¯\n" +
				"¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯\\  /¯¯¯|⌈⌉⌈⌉⌈⌉|        |  \n" +
				" |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯¯¯\n" +
				"|¯¯¯¯¯¯¯¯¯¯¯/|⌈⌉⌈⌉|          |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"|            |⌈⌉⌈⌉|         / ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯\n" +
				"|            |⌊⌋⌊⌋|         \\ ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|\\¯¯¯¯¯¯¯¯¯¯¯|\n" +
				"|   Lounge   |⌊⌋⌊⌋|   Hall   |⌊⌋⌊⌋|            |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|    Study   |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|            |\n" +
				"|          |¯|⌈⌉|¯|          |¯|⌈⌉|¯|          |\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯";
		Board board = new Board();
		assertEquals(board.toString(), output);
	}

	@Test
	public void test18() {
		String output = "\n" +
				"                 |⌈⌉|¯¯¯¯¯¯|⌈⌉|                 \n" +
				"                 |⌊⌋|      |⌊⌋|                 \n" +
				"|¯¯¯¯¯¯¯¯¯¯| |⌈⌉⌈⌉⌈⌉|      |⌈⌉⌈⌉⌈⌉| |¯¯¯¯¯¯¯¯¯¯|\n" +
				"|          | |⌊⌋⌊⌋⌊⌋|      |⌊⌋⌊⌋⌊⌋| |          |\n" +
				"|          |⌈⌉⌈⌉|¯¯¯        ¯¯¯|⌈⌉⌈⌉| Conser-  |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋| vatory   |\n" +
				"| Kitchen  |⌈⌉⌈⌉|              |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|          |\n" +
				"|          |⌈⌉⌈⌉|   Ball Room  |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|/        ¯¯\n" +
				"|          |⌈⌉⌈⌉/             / ⌈⌉⌈⌉⌈⌉|      |  \n" +
				"¯¯         |⌊⌋⌊⌋\\             \\ ⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯\n" +
				"  |        |⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|              |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"  ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| ¯¯\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯\\/¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|   \n" +
				"  | ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯¯¯¯¯¯¯¯|\n" +
				"  | ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |\n" +
				"|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉/          |\n" +
				"|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\\          |\n" +
				"|         ¯¯¯¯¯|⌈⌉⌈⌉|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉| Billiard |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|   Room   |\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|          |\n" +
				"|   Dining    / ⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|    Room     \\ ⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯\\/¯¯\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|¯¯¯\\/¯¯¯¯| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|         | \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉|¯          ¯|\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|        |⌊⌋⌊⌋|            |\n" +
				" |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|        |⌈⌉⌈⌉/   Library  |\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯⌊⌋⌊⌋\\            |\n" +
				"⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|            |\n" +
				"⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯          ¯¯\n" +
				"¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯\\  /¯¯¯|⌈⌉⌈⌉⌈⌉|        |  \n" +
				" |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯¯¯\n" +
				"|¯¯¯¯¯¯¯¯¯¯¯/|⌈⌉⌈⌉|          |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"|            |⌈⌉⌈⌉|         / ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯\n" +
				"|            |⌊⌋⌊⌋|         \\ ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|\\¯¯¯¯¯¯¯¯¯¯¯|\n" +
				"|   Lounge   |⌊⌋⌊⌋|   Hall   |⌊⌋⌊⌋|            |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|    Study   |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|            |\n" +
				"|          |¯|M |¯|          |¯|⌈⌉|¯|          |\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯ | S| ¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯";
		Board board = new Board();
		Player missScarlet = new Player("Miss Scarlet", board.getCell(7, 24), new char[]{' ','M',' ',' ','S'});
		Cell cell = board.getCell(7, 24);
		cell.setPlayer(missScarlet.getPlayerInitials());
		assertEquals(board.toString(), output);
	}

	@Test
	public void test19() {
		String output = "\n" +
				"                 |⌈⌉|¯¯¯¯¯¯|⌈⌉|                 \n" +
				"                 |⌊⌋|      |⌊⌋|                 \n" +
				"|¯¯¯¯¯¯¯¯¯¯| |⌈⌉⌈⌉⌈⌉|      |⌈⌉⌈⌉⌈⌉| |¯¯¯¯¯¯¯¯¯¯|\n" +
				"|          | |⌊⌋⌊⌋⌊⌋|      |⌊⌋⌊⌋⌊⌋| |          |\n" +
				"|          |⌈⌉⌈⌉|¯¯¯        ¯¯¯|⌈⌉⌈⌉| Conser-  |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋| vatory   |\n" +
				"| Kitchen  |⌈⌉⌈⌉|              |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|          |\n" +
				"|          |⌈⌉⌈⌉|   Ball Room  |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|/        ¯¯\n" +
				"|          |⌈⌉⌈⌉/             / ⌈⌉⌈⌉⌈⌉|      |  \n" +
				"¯¯         |⌊⌋⌊⌋\\             \\ ⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯\n" +
				"  |        |⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|              |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"  ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| ¯¯\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯\\/¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|   \n" +
				"  | ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯¯¯¯¯¯¯¯|\n" +
				"  | ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |\n" +
				"|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉/          |\n" +
				"|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\\          |\n" +
				"|         ¯¯¯¯¯|⌈⌉⌈⌉|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉| Billiard |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|   Room   |\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|          |\n" +
				"|   Dining    / ⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|    Room     \\ ⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯\\/¯¯\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|¯¯¯\\/¯¯¯¯| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|         | \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉|¯          ¯|\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|        |⌊⌋⌊⌋|            |\n" +
				" |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|        |⌈⌉⌈⌉/   Library  |\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯⌊⌋⌊⌋\\            |\n" +
				"⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉M ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|            |\n" +
				"⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋ S⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯          ¯¯\n" +
				"¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯\\  /¯¯¯|⌈⌉⌈⌉⌈⌉|        |  \n" +
				" |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯¯¯\n" +
				"|¯¯¯¯¯¯¯¯¯¯¯/|⌈⌉⌈⌉|          |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"|            |⌈⌉⌈⌉|         / ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯\n" +
				"|            |⌊⌋⌊⌋|         \\ ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|\\¯¯¯¯¯¯¯¯¯¯¯|\n" +
				"|   Lounge   |⌊⌋⌊⌋|   Hall   |⌊⌋⌊⌋|            |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|    Study   |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|            |\n" +
				"|          |¯|⌈⌉|¯|          |¯|⌈⌉|¯|          |\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯";
		Board board = new Board();
		String[] move = {"n","e","e","s","w"};
		Player missScarlet = new Player("Miss Scarlet", board.getCell(6, 17), new char[]{' ','M',' ',' ','S'});
		Cell cell = board.getCell(6, 17);
		cell.setPlayer(missScarlet.getPlayerInitials());
		Cluedo cluedo = new Cluedo(missScarlet, board);
		cluedo.applyMove(move, 5);
		assertEquals(board.toString(), output);
	}

	@Test
	public void test20() {
		String output = "\n" +
				"                 |⌈⌉|¯¯¯¯¯¯|⌈⌉|                 \n" +
				"                 |⌊⌋|      |⌊⌋|                 \n" +
				"|¯¯¯¯¯¯¯¯¯¯| |⌈⌉⌈⌉⌈⌉|      |⌈⌉⌈⌉⌈⌉| |¯¯¯¯¯¯¯¯¯¯|\n" +
				"|          | |⌊⌋⌊⌋⌊⌋|      |⌊⌋⌊⌋⌊⌋| |          |\n" +
				"|          |⌈⌉⌈⌉|¯¯¯        ¯¯¯|⌈⌉⌈⌉| Conser-  |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋| vatory   |\n" +
				"| Kitchen  |⌈⌉⌈⌉|              |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|          |\n" +
				"|          |⌈⌉⌈⌉|   Ball Room  |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|/        ¯¯\n" +
				"|          |⌈⌉⌈⌉/             / ⌈⌉⌈⌉⌈⌉|      |  \n" +
				"¯¯         |⌊⌋⌊⌋\\             \\ ⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯\n" +
				"  |        |⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|              |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"  ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| ¯¯\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯\\/¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|   \n" +
				"  | ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯¯¯¯¯¯¯¯|\n" +
				"  | ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |\n" +
				"|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉/          |\n" +
				"|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\\          |\n" +
				"|         ¯¯¯¯¯|⌈⌉⌈⌉|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉| Billiard |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|   Room   |\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|          |\n" +
				"|   Dining    / ⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|    Room     \\ ⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯\\/¯¯\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|¯¯¯\\/¯¯¯¯| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|         | \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉|¯          ¯|\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|        |⌊⌋⌊⌋|            |\n" +
				" |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|        |⌈⌉⌈⌉/   Library  |\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯⌊⌋⌊⌋\\            |\n" +
				"⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉M ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|            |\n" +
				"⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋ S⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯          ¯¯\n" +
				"¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯\\  /¯¯¯|⌈⌉⌈⌉⌈⌉|        |  \n" +
				" |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯¯¯\n" +
				"|¯¯¯¯¯¯¯¯¯¯¯/|⌈⌉⌈⌉|          |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"|            |⌈⌉⌈⌉|         / ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯\n" +
				"|            |⌊⌋⌊⌋|         \\ ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|\\¯¯¯¯¯¯¯¯¯¯¯|\n" +
				"|   Lounge   |⌊⌋⌊⌋|   Hall   |⌊⌋⌊⌋|            |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|    Study   |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|            |\n" +
				"|          |¯|⌈⌉|¯|          |¯|⌈⌉|¯|          |\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯";
		Board board = new Board();
		String[] move = {"s","w","s"};
		Player missScarlet = new Player("Miss Scarlet", board.getCell(6, 17), new char[]{' ','M',' ',' ','S'});
		Cell cell = board.getCell(6, 17);
		cell.setPlayer(missScarlet.getPlayerInitials());
		Cluedo cluedo = new Cluedo(missScarlet, board);
		cluedo.applyMove(move, 3);
		assertEquals(board.toString(), output);
	}

	@Test
	public void test21() {
		String output = "\n" +
				"                 |⌈⌉|¯¯¯¯¯¯|⌈⌉|                 \n" +
				"                 |⌊⌋|      |⌊⌋|                 \n" +
				"|¯¯¯¯¯¯¯¯¯¯| |⌈⌉⌈⌉⌈⌉|      |⌈⌉⌈⌉⌈⌉| |¯¯¯¯¯¯¯¯¯¯|\n" +
				"|          | |⌊⌋⌊⌋⌊⌋|      |⌊⌋⌊⌋⌊⌋| |          |\n" +
				"|          |⌈⌉⌈⌉|¯¯¯        ¯¯¯|⌈⌉⌈⌉| Conser-  |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋| vatory   |\n" +
				"| Kitchen  |⌈⌉⌈⌉|              |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|          |\n" +
				"|          |⌈⌉⌈⌉|   Ball Room  |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|/        ¯¯\n" +
				"|          |⌈⌉⌈⌉/             / ⌈⌉⌈⌉⌈⌉|      |  \n" +
				"¯¯         |⌊⌋⌊⌋\\             \\ ⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯\n" +
				"  |        |⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|              |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"  ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| ¯¯\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯\\/¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|   \n" +
				"  | ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯¯¯¯¯¯¯¯|\n" +
				"  | ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |\n" +
				"|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉/          |\n" +
				"|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\\          |\n" +
				"|         ¯¯¯¯¯|⌈⌉⌈⌉|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉| Billiard |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|   Room   |\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|          |\n" +
				"|   Dining    / ⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|    Room     \\ ⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯\\/¯¯\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|¯¯¯\\/¯¯¯¯| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|         | \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉|¯          ¯|\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|        |⌊⌋⌊⌋|            |\n" +
				" |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|        |⌈⌉⌈⌉/   Library  |\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯⌊⌋⌊⌋\\            |\n" +
				"⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉M ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|            |\n" +
				"⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋ S⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯          ¯¯\n" +
				"¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯\\  /¯¯¯|⌈⌉⌈⌉⌈⌉|        |  \n" +
				" |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯¯¯\n" +
				"|¯¯¯¯¯¯¯¯¯¯¯/|⌈⌉⌈⌉|          |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"|            |⌈⌉⌈⌉|         / ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯\n" +
				"|            |⌊⌋⌊⌋|         \\ ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|\\¯¯¯¯¯¯¯¯¯¯¯|\n" +
				"|   Lounge   |⌊⌋⌊⌋|   Hall   |⌊⌋⌊⌋|            |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|    Study   |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|            |\n" +
				"|          |¯|⌈⌉|¯|          |¯|⌈⌉|¯|          |\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯";
		Board board = new Board();
		String[] move = {"s","w","e"};
		Player missScarlet = new Player("Miss Scarlet", board.getCell(6, 17), new char[]{' ','M',' ',' ','S'});
		Cell cell = board.getCell(6, 17);
		cell.setPlayer(missScarlet.getPlayerInitials());
		Cluedo cluedo = new Cluedo(missScarlet, board);
		cluedo.applyMove(move, 3);
		assertEquals(board.toString(), output);
	}

	@Test
	public void test22() {
		String output = "\n" +
				"                 |⌈⌉|¯¯¯¯¯¯|⌈⌉|                 \n" +
				"                 |⌊⌋|      |⌊⌋|                 \n" +
				"|¯¯¯¯¯¯¯¯¯¯| |⌈⌉⌈⌉⌈⌉|      |⌈⌉⌈⌉⌈⌉| |¯¯¯¯¯¯¯¯¯¯|\n" +
				"|          | |⌊⌋⌊⌋⌊⌋|      |⌊⌋⌊⌋⌊⌋| |          |\n" +
				"|          |⌈⌉⌈⌉|¯¯¯        ¯¯¯|⌈⌉⌈⌉| Conser-  |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋| vatory   |\n" +
				"| Kitchen  |⌈⌉⌈⌉|              |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|          |\n" +
				"|          |⌈⌉⌈⌉|   Ball Room  |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|/        ¯¯\n" +
				"|          |⌈⌉⌈⌉/             / ⌈⌉⌈⌉⌈⌉|      |  \n" +
				"¯¯         |⌊⌋⌊⌋\\             \\ ⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯\n" +
				"  |        |⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|              |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"  ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| ¯¯\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯\\/¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|   \n" +
				"  | ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯¯¯¯¯¯¯¯|\n" +
				"  | ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |\n" +
				"|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉/          |\n" +
				"|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\\          |\n" +
				"|         ¯¯¯¯¯|⌈⌉⌈⌉|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉| Billiard |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|   Room   |\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|          |\n" +
				"|   Dining    / ⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|    Room     \\ ⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯\\/¯¯\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|¯¯¯\\/¯¯¯¯| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|         | \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉|¯          ¯|\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|        |⌊⌋⌊⌋|            |\n" +
				" |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|        |⌈⌉⌈⌉/   Library  |\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯⌊⌋⌊⌋\\            |\n" +
				"⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉M ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|            |\n" +
				"⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋ S⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯          ¯¯\n" +
				"¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯\\  /¯¯¯|⌈⌉⌈⌉⌈⌉|        |  \n" +
				" |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯¯¯\n" +
				"|¯¯¯¯¯¯¯¯¯¯¯/|⌈⌉⌈⌉|          |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"|            |⌈⌉⌈⌉|         / ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯\n" +
				"|            |⌊⌋⌊⌋|         \\ ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|\\¯¯¯¯¯¯¯¯¯¯¯|\n" +
				"|   Lounge   |⌊⌋⌊⌋|   Hall   |⌊⌋⌊⌋|            |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|    Study   |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|            |\n" +
				"|          |¯|⌈⌉|¯|          |¯|⌈⌉|¯|          |\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯";
		Board board = new Board();
		String[] move = {"s","w","w","w"};
		Player missScarlet = new Player("Miss Scarlet", board.getCell(6, 17), new char[]{' ','M',' ',' ','S'});
		Cell cell = board.getCell(6, 17);
		cell.setPlayer(missScarlet.getPlayerInitials());
		Cluedo cluedo = new Cluedo(missScarlet, board);
		cluedo.applyMove(move, 3);
		assertEquals(board.toString(), output);
	}

	@Test
	public void test23() {
		String output = "\n" +
				"                 |⌈⌉|¯¯¯¯¯¯|⌈⌉|                 \n" +
				"                 |⌊⌋|      |⌊⌋|                 \n" +
				"|¯¯¯¯¯¯¯¯¯¯| |⌈⌉⌈⌉⌈⌉|      |⌈⌉⌈⌉⌈⌉| |¯¯¯¯¯¯¯¯¯¯|\n" +
				"|          | |⌊⌋⌊⌋⌊⌋|      |⌊⌋⌊⌋⌊⌋| |          |\n" +
				"|          |⌈⌉⌈⌉|¯¯¯        ¯¯¯|⌈⌉⌈⌉| Conser-  |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋| vatory   |\n" +
				"| Kitchen  |⌈⌉⌈⌉|              |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|          |\n" +
				"|          |⌈⌉⌈⌉|   Ball Room  |⌈⌉⌈⌉|          |\n" +
				"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|/        ¯¯\n" +
				"|          |⌈⌉⌈⌉/             / ⌈⌉⌈⌉⌈⌉|      |  \n" +
				"¯¯         |⌊⌋⌊⌋\\             \\ ⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯\n" +
				"  |        |⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|              |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"  ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| ¯¯\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯\\/¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|   \n" +
				"  | ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯¯¯¯¯¯¯¯|\n" +
				"  | ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |\n" +
				"|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉/          |\n" +
				"|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\\          |\n" +
				"|         ¯¯¯¯¯|⌈⌉⌈⌉|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉| Billiard |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|   Room   |\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|          |\n" +
				"|   Dining    / ⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
				"|    Room     \\ ⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯\\/¯¯\n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|¯¯¯\\/¯¯¯¯| \n" +
				"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|         | \n" +
				"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉|¯          ¯|\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|        |⌊⌋⌊⌋|            |\n" +
				" |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|        |⌈⌉⌈⌉/   Library  |\n" +
				"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯⌊⌋⌊⌋\\            |\n" +
				"⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉M ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|            |\n" +
				"⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋ S⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯          ¯¯\n" +
				"¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯\\  /¯¯¯|⌈⌉⌈⌉⌈⌉|        |  \n" +
				" |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯¯¯\n" +
				"|¯¯¯¯¯¯¯¯¯¯¯/|⌈⌉⌈⌉|          |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
				"|            |⌈⌉⌈⌉|         / ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯\n" +
				"|            |⌊⌋⌊⌋|         \\ ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|\\¯¯¯¯¯¯¯¯¯¯¯|\n" +
				"|   Lounge   |⌊⌋⌊⌋|   Hall   |⌊⌋⌊⌋|            |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|    Study   |\n" +
				"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
				"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|            |\n" +
				"|          |¯|⌈⌉|¯|          |¯|⌈⌉|¯|          |\n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯";
		Board board = new Board();
		String[] move = {"s","w","w","w"};
		Player missScarlet = new Player("Miss Scarlet", board.getCell(6, 17), new char[]{' ','M',' ',' ','S'});
		Cell cell = board.getCell(6, 17);
		cell.setPlayer(missScarlet.getPlayerInitials());
		Cluedo cluedo = new Cluedo(missScarlet, board);
		cluedo.applyMove(move, 5);
		assertEquals(board.toString(), output);
	}

	@Test
	public void test24() {
		Board board = new Board();
		Player missScarlet = new Player("Miss Scarlet", board.getCell(7, 24), new char[]{' ','M',' ',' ','S'});
		assertEquals(missScarlet.getName(), "Miss Scarlet");
		missScarlet.kill();
		assertTrue(missScarlet.getStatus());
		missScarlet.addCardToHand(new Card("character","Miss Scarlet",7,24,new char[]{' ','M',' ',' ','S'}));
		missScarlet.addCardToHand(new Card("character","Colonel Mustard",0,17,new char[]{' ','C',' ',' ','M'}));
		missScarlet.addCardToHand(new Card("character","Mrs. White",9,0,new char[]{' ','M',' ',' ','W'}));
		assertEquals(missScarlet.getHand().size(), 3);
		assertEquals(missScarlet.showHand(), "Miss Scarlet, Colonel Mustard, Mrs. White.");
	}

	@Test
	public void test25() {
		Board board = new Board();
		Player missScarlet = new Player("Miss Scarlet", board.getCell(6, 17), new char[]{' ','M',' ',' ','S'});
		Cell cell = board.getCell(6, 17);
		cell.setPlayer(missScarlet.getPlayerInitials());
		Cluedo cluedo = new Cluedo(missScarlet, board);
		cluedo.addCharacters();
		cluedo.addRooms();
		cluedo.addWeapons();
		assertEquals(cluedo.getCharacters().size(), 6);
		assertEquals(cluedo.getRooms().size(), 9);
		assertEquals(cluedo.getWeapons().size(), 6);
	}

	@Test
	public void test26() {
		String[] suggestion = {"Colonel Mustard", "Lead Pipe", "Dining Room"};
		Board board = new Board();
		Player missScarlet = new Player("Miss Scarlet", board.getCell(1, 14), new char[]{' ','M',' ',' ','S'});
		Cell cell = board.getCell(1, 14);
		cell.setPlayer(missScarlet.getPlayerInitials());
		Cluedo cluedo = new Cluedo(missScarlet, board);
		cluedo.addCharacters();
		cluedo.addRooms();
		cluedo.addWeapons();
		assertTrue(cluedo.isValidSuggestion(suggestion));
	}

	@Test
	public void test27() {
		String[] suggestion = {"Colonel Mustard", "Lead Pipe", "Ball room"};
		Board board = new Board();
		Player missScarlet = new Player("Miss Scarlet", board.getCell(1, 14), new char[]{' ','M',' ',' ','S'});
		Cell cell = board.getCell(1, 14);
		cell.setPlayer(missScarlet.getPlayerInitials());
		Cluedo cluedo = new Cluedo(missScarlet, board);
		cluedo.addCharacters();
		cluedo.addRooms();
		cluedo.addWeapons();
		assertFalse(cluedo.isValidSuggestion(suggestion));
	}

	@Test
	public void test28() {
		String[] suggestion = {"Colonel Mustard", "Lead Pipe", "Ball room"};
		Board board = new Board();
		Player missScarlet = new Player("Miss Scarlet", board.getCell(1, 14), new char[]{' ','M',' ',' ','S'});
		Cell cell = board.getCell(1, 14);
		cell.setPlayer(missScarlet.getPlayerInitials());
		Cluedo cluedo = new Cluedo(missScarlet, board);
		cluedo.addCharacters();
		cluedo.addRooms();
		cluedo.addWeapons();
		assertTrue(cluedo.isValidAccusation(suggestion));
	}

	@Test
	public void test29() {
		String[] suggestion = {"Colone Mustard", "Lead Pipe", "Ball room"};
		Board board = new Board();
		Player missScarlet = new Player("Miss Scarlet", board.getCell(1, 14), new char[]{' ','M',' ',' ','S'});
		Cell cell = board.getCell(1, 14);
		cell.setPlayer(missScarlet.getPlayerInitials());
		Cluedo cluedo = new Cluedo(missScarlet, board);
		cluedo.addCharacters();
		cluedo.addRooms();
		cluedo.addWeapons();
		assertFalse(cluedo.isValidAccusation(suggestion));
	}

	@Test
	public void test30() {
		String output = "\n" +
			"                 |⌈⌉|¯¯¯¯¯¯|⌈⌉|                 \n" +
			"                 |⌊⌋|      |⌊⌋|                 \n" +
			"|¯¯¯¯¯¯¯¯¯¯| |⌈⌉⌈⌉⌈⌉|      |⌈⌉⌈⌉⌈⌉| |¯¯¯¯¯¯¯¯¯¯|\n" +
			"|          | |⌊⌋⌊⌋⌊⌋|      |⌊⌋⌊⌋⌊⌋| |          |\n" +
			"|          |⌈⌉⌈⌉|¯¯¯        ¯¯¯|⌈⌉⌈⌉| Conser-  |\n" +
			"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋| vatory   |\n" +
			"| Kitchen  |⌈⌉⌈⌉|              |⌈⌉⌈⌉|          |\n" +
			"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|          |\n" +
			"|          |⌈⌉⌈⌉|   Ball Room  |⌈⌉⌈⌉|          |\n" +
			"|          |⌊⌋⌊⌋|              |⌊⌋⌊⌋|/        ¯¯\n" +
			"|          |⌈⌉⌈⌉/             / ⌈⌉⌈⌉⌈⌉|      |  \n" +
			"¯¯         |⌊⌋⌊⌋\\             \\ ⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯\n" +
			"  |        |⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
			"¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|              |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
			"  ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|              |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| ¯¯\n" +
			"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯\\/¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|   \n" +
			"  | ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯¯¯¯¯¯¯¯|\n" +
			"  | ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋|          |\n" +
			"|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉/          |\n" +
			"|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\\          |\n" +
			"|         ¯¯¯¯¯|⌈⌉⌈⌉|¯¯¯¯¯¯¯¯|⌈⌉⌈⌉⌈⌉| Billiard |\n" +
			"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|   Room   |\n" +
			"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
			"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|          |\n" +
			"|   Dining    / ⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|          |\n" +
			"|    Room     \\ ⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯\\/¯¯\n" +
			"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉| \n" +
			"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
			"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉⌈⌉|¯¯¯\\/¯¯¯¯| \n" +
			"|              |⌊⌋⌊⌋|        |⌊⌋⌊⌋⌊⌋|         | \n" +
			"|              |⌈⌉⌈⌉|        |⌈⌉⌈⌉|¯          ¯|\n" +
			"¯¯¯¯¯¯¯¯¯¯¯¯\\/¯¯⌊⌋⌊⌋|        |⌊⌋⌊⌋|            |\n" +
			" |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|        |⌈⌉⌈⌉/   Library  |\n" +
			"¯¯⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯⌊⌋⌊⌋\\            |\n" +
			"⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉M ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|            |\n" +
			"⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋ S⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋¯¯          ¯¯\n" +
			"¯|⌈⌉⌈⌉⌈⌉C ⌈⌉⌈⌉⌈⌉⌈⌉|¯¯¯\\  /¯¯¯|⌈⌉⌈⌉⌈⌉|        |  \n" +
			" |⌊⌋⌊⌋⌊⌋ M⌊⌋⌊⌋⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋¯¯¯¯¯¯¯¯¯¯¯¯\n" +
			"|¯¯¯¯¯¯¯¯¯¯¯/|⌈⌉⌈⌉|          |⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉\n" +
			"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋\n" +
			"|            |⌈⌉⌈⌉|         / ⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉⌈⌉|¯\n" +
			"|            |⌊⌋⌊⌋|         \\ ⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋⌊⌋| \n" +
			"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|\\¯¯¯¯¯¯¯¯¯¯¯|\n" +
			"|   Lounge   |⌊⌋⌊⌋|   Hall   |⌊⌋⌊⌋|            |\n" +
			"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
			"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|    Study   |\n" +
			"|            |⌈⌉⌈⌉|          |⌈⌉⌈⌉|            |\n" +
			"|            |⌊⌋⌊⌋|          |⌊⌋⌊⌋|            |\n" +
			"|          |¯|⌈⌉|¯|          |¯|⌈⌉|¯|          |\n" +
			"¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯ |⌊⌋| ¯¯¯¯¯¯¯¯¯¯¯¯";
	Board board = new Board();
	String[] move = {"s","w","w","w"};
	Player colonelMustard = new Player("Colonel Mustard", board.getCell(4, 18), new char[] {' ', 'C', ' ', ' ', 'M'});
	Player missScarlet = new Player("Miss Scarlet", board.getCell(6, 17), new char[]{' ','M',' ',' ','S'});
	Cell cell = board.getCell(6, 17);
	cell.setPlayer(missScarlet.getPlayerInitials());
	cell = board.getCell(4, 18);
	cell.setPlayer(colonelMustard.getPlayerInitials());
	Cluedo cluedo = new Cluedo(missScarlet, board);
	cluedo.applyMove(move, 4);
	assertEquals(board.toString(), output);
	}
}