import java.util.*;

public class Cluedo {
	private List<Player> players;
	private List<Card> characters;
	private List<Card> weapons;
	private List<Card> rooms;
	private Card murderWeapon;
	private Card murderer;
	private Card murderRoom;
	private Board board;
	private Player currentPlayer;
	
	public Cluedo (){
		board = new Board();
		players = new ArrayList<Player>();
		addCharacters();
		addWeapons();
		addRooms();
		Scanner sc = new Scanner(System.in);
		System.out.print("Hello, welcome to cluedo\n"
				+ "if at any time you need clarifiction on the\n"
				+ "rules type '4' for a list of the rules\n\n");
		setup(sc);
	}
	
	/**
	 * Sets up the start of the game by distinguishing the amount of players
	 * randomly generating a solution
	 * and then distributing the cards amongst the players
	 */
	public void setup(Scanner sc) {
		System.out.println("How many players are palying?\nEnter a number between 3-6:");
		int noPlayers;
		while(true) {
			if(sc.hasNext()) {
				noPlayers = sc.nextInt();
				if(noPlayers >= 3 && noPlayers <= 6) break;
				else {
					System.out.println("Please enter a number between 3-6:");
				}
			}	
		}
		for(int i=0; i<noPlayers; i++) {
			Player toAdd = new Player(characters.get(i).getId());
			players.add(toAdd);
		}
		setSolution();
		List<Card> allCards = new ArrayList<Card>();
		allCards.addAll(characters);
		allCards.addAll(weapons);
		allCards.addAll(rooms);
		
		while(!allCards.isEmpty()) {
			for(Player player : players) {
				Collections.shuffle(allCards);
				player.addCardToHand(allCards.get(0));
				allCards.remove(0);
			}
		}
		//board.draw();
		tick(sc);
	}
	
	/**
	 * main loop for running game, each loop turn (a tick)
	 * @param sc
	 */
	public void tick(Scanner sc) {
		int playerTurn = 0;
		while(true) {
			//board.draw();
			currentPlayer = players.get(0);
			System.out.println("It is " + currentPlayer.getName() + "'s turn press enter to roll the dice");
			
			
			playerTurn++;
			if(playerTurn == players.size()) playerTurn = 0;
		}
	}
	
	/**
	 * randomly selects a murderer, murderWeapon and murderRoom
	 * by shuffling the appropriate array list and getting the first element
	 * and removes them from the lists
	 */
	public void setSolution() {
		Collections.shuffle(characters);
		murderer = characters.get(0);
		characters.remove(0);
		
		Collections.shuffle(weapons);
		murderWeapon = weapons.get(0);
		weapons.remove(0);
		
		Collections.shuffle(rooms);
		murderRoom = rooms.get(0);
		rooms.remove(0);
	}
	
	/**
	 * generates the character array list which will be used to distribute cards later
	 */
	public void addCharacters() {
		characters = new ArrayList<Card>();
		characters.add(new Card("character","Miss Scarlet"));
		characters.add(new Card("character","Colonel Mustard"));
		characters.add(new Card("character","Mrs. White"));
		characters.add(new Card("character","Mr. Green"));
		characters.add(new Card("character","Mrs. Peacock"));
		characters.add(new Card("character","Prof. Plum"));
	}
	
	/**
	 * generates the weapons array list which will be used to distribute cards later
	 */
	public void addWeapons() {
		weapons = new ArrayList<Card>();
		weapons.add(new Card("weapon","Candelstick"));
		weapons.add(new Card("weapon","Dagger"));
		weapons.add(new Card("weapon","Lead Pipe"));
		weapons.add(new Card("weapon","Revolver"));
		weapons.add(new Card("weapon","Rope"));
		weapons.add(new Card("weapon","Spanner"));
	}
	
	/**
	 * generates the rooms array list which will be used to distribute cards later
	 */
	public void addRooms() {
		rooms = new ArrayList<Card>();
		rooms.add(new Card("room","Kitchen"));
		rooms.add(new Card("room","Ball Room"));
		rooms.add(new Card("room","Conservatory"));
		rooms.add(new Card("room","Dining Room"));
		rooms.add(new Card("room","Billiard Room"));
		rooms.add(new Card("room","Library"));
		rooms.add(new Card("room","Lounge"));
		rooms.add(new Card("room","Hall"));
		rooms.add(new Card("room","Study"));
	}
	
	
	public void checkForHelp(Scanner sc) {
		if(sc.nextInt() == 4) {
			//System.out.print();
		}
	}
	
	public static void main(String[] args) {
		new Cluedo();
	}
	
}
