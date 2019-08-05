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
	private String winningClaim;
	private boolean wonFromAccu;
	
	public Cluedo (){
		board = new Board();
		players = new ArrayList<Player>();
		addCharacters();
		addWeapons();
		addRooms();
		Scanner sc = new Scanner(System.in);
		System.out.print("Hello, welcome to cluedo\n"
				+ "if at any time you need clarifiction on the\n"
				+ "rules type \"4\" for a list of the rules\n\n");
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
			Card character = characters.get(i);
			Cell startPos = board.getCell(character.getStartX(), character.getStartY());
			Player toAdd = new Player(character.getId(), startPos);
			startPos.setPlayer(character.getInitials());
			players.add(toAdd);
		}
		setSolution();
		List<Card> allCards = new ArrayList<Card>();
		allCards.addAll(characters);
		allCards.addAll(weapons);
		allCards.addAll(rooms);
		
		allCards.remove(murderer);
		allCards.remove(murderRoom);
		allCards.remove(murderWeapon);
		
		while(!allCards.isEmpty()) {
			for(Player player : players) {
				Collections.shuffle(allCards);
				player.addCardToHand(allCards.get(0));
				allCards.remove(0);
			}
		}
		
		System.out.println("Take turns noting down the cards that have been delt to each player. (keep them secret to you!!");
		for(Player player : players) {
			System.out.println(player.getName() + " when ready press 'y' to display your hand");
			if(sc.next().equalsIgnoreCase("y")) {
				System.out.println(player.showHand());
				System.out.println("(When ready press 'y' to hide your hand again");
				if(sc.next().equalsIgnoreCase("y")) System.out.flush();
			}
		}
		tick(sc);
	}
	
	/**
	 * main loop for running game, each loop turn (a tick)
	 * @param sc
	 */
	public void tick(Scanner sc) {
		int playerTurn = 0;
		while(true) {
			currentPlayer = players.get(playerTurn);
			if(!currentPlayer.getStatus()) {
				System.out.println("It is " + currentPlayer.getName() + "'s are you ready for your turn?(y/n)");
				board.draw();
				if(sc.next().equalsIgnoreCase("y")  ) {
					System.out.println("Do you want to roll the dice?(y/n)");
					if(sc.next().equalsIgnoreCase("y")) {
						int roll = rollDice();
						System.out.println("You rolled " + roll + "! whats your move?");
						if(sc.nextLine() != null) {
							applyMove(sc.nextLine(),sc, roll);
						}
					}
					if(!currentPlayer.getLocation().getRoom().equals("hallway")) {
						System.out.println("Would you like to make a suggestion or accusation?(please state)");
						if(sc.next().equalsIgnoreCase("suggestion")) {
							if(checkSuggestion(sc)) {
								break;
							}
						}
						else if(sc.next().equalsIgnoreCase("accusation")) {
							if(checkAccusation(sc)) {
								break;
							}
							System.out.println("=============================================================");
							System.out.println(currentPlayer.getName()+ " is now out of the game due to an incorrect accusation");
							currentPlayer.kill();
						}
					}
				}
			}
			playerTurn++;
			if(playerTurn == players.size()) playerTurn = 0;
		}
		if(wonFromAccu) System.out.println(currentPlayer.getName() + "won the game with the accusation: " + winningClaim);
		else System.out.println(currentPlayer.getName() + "won the game with the suggestion: " + winningClaim);
	}
	
	/**
	 * randomly selects a murderer, murderWeapon and murderRoom
	 * by shuffling the appropriate array list and getting the first element
	 * and removes them from the lists
	 */
	public void setSolution() {
		Collections.shuffle(characters);
		murderer = characters.get(0);
		
		Collections.shuffle(weapons);
		murderWeapon = weapons.get(0);
		
		Collections.shuffle(rooms);
		murderRoom = rooms.get(0);
	}
	
	/**
	 * generates the character array list which will be used to distribute cards later
	 */
	public void addCharacters() {
		characters = new ArrayList<Card>();
		characters.add(new Card("character","Miss Scarlet",7,24,new char[]{' ','M',' ',' ','S'}));
		characters.add(new Card("character","Colonel Mustard",0,17,new char[]{' ','C',' ',' ','M'}));
		characters.add(new Card("character","Mrs. White",9,0,new char[]{' ','M',' ',' ','W'}));
		characters.add(new Card("character","Mr. Green",14,0,new char[]{' ','M',' ',' ','G'}));
		characters.add(new Card("character","Mrs. Peacock",23,6,new char[]{' ','M',' ',' ','P'}));
		characters.add(new Card("character","Prof. Plum",23,19,new char[]{' ','P',' ',' ','P'}));
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
	
	/**
	 * generates to random integers between 1 and 6 and adds them together
	 * @return
	 */
	public int rollDice() {
		Random rand = new Random();
		return (rand.nextInt(6)+1) + (rand.nextInt(6)+1);
	}
	
	public void applyMove(String move, Scanner sc, int roll) {
		
	}
	
	/**
	 * checks whether the given suggestion is correct or not, making sure that the suggestion is done in
	 * the correct format at the same time
	 * @param sc
	 * @return
	 */
	public boolean checkSuggestion(Scanner sc) {
		System.out.println("(Please make the suggestion in the format \"Person,Weapon,Room\")");
		while(true) {
			if(sc.hasNextLine()) {
				String[] suggestion = sc.nextLine().split(",");
				if(isValidSuggestion(suggestion)) {
					if(murderer.getId().equalsIgnoreCase(suggestion[0])) {
						if(murderWeapon.getId().equalsIgnoreCase(suggestion[1])) {
							if(murderRoom.getId().equalsIgnoreCase(suggestion[2])) {
								winningClaim = Arrays.toString(suggestion);
								wonFromAccu = false;
								return true;
							}
							else {
								refuteRoom(suggestion[2], sc);
								break;
							}
						}
						else {
							refuteWeapon(suggestion[1], sc);
							break;
						}
					}
					else {
						refutePerson(suggestion[0], sc);
						break;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * checks whether the given accusation is correct or not, making sure that the accusation is done in
	 * the correct format at the same time
	 * @param sc
	 * @return
	 */
	public boolean checkAccusation(Scanner sc) {
		System.out.println("(Please make the accusation in the format \"Person,Weapon,Room\")");
		while(true) {
			String[] accusation = sc.nextLine().split(",");
			if(isValidAccusation(accusation)) {
				if(murderer.getId().equalsIgnoreCase(accusation[0])) {
					if(murderWeapon.getId().equalsIgnoreCase(accusation[1])) {
						if(murderRoom.getId().equalsIgnoreCase(accusation[2])) {
							winningClaim = Arrays.toString(accusation);
							wonFromAccu = true;
							return true;
						}
					}
				}
				break;
			}
		}
		return false;
	}
	
	public void checkForHelp(Scanner sc) {
		if(sc.nextInt() == 4) {
			
		}
	}
	
	/**
	 * finds which player can refute the suggested person
	 * @param suggestedPerson
	 */
	public void refutePerson(String suggestedPerson, Scanner sc) {
		Player canRefute = null;
		for(Player player : players) {
			if(player != currentPlayer) {
				for(Card card : player.getHand()) {
					if(card.getId().equalsIgnoreCase(suggestedPerson)){
						canRefute = player;
						break;
					}
				}
			}
		}
		System.out.println(canRefute.getName() + " can refute, type 'y' to see hand and let " + currentPlayer.getName() +
		" know what card you can refute secretly");
		if(sc.next().equalsIgnoreCase("y")) {
			System.out.println(canRefute.showHand());
			System.out.println("(press 'y' to hide your hand and start the next turn)");
			if(sc.next().equalsIgnoreCase("y")) {
				System.out.flush();
			}
		}
	}
	
	/**
	 * finds which player can refute the suggested Weapon
	 * @param suggestedPerson
	 */
	public void refuteWeapon(String suggestedWeapon, Scanner sc) {
		Player canRefute = null;
		for(Player player : players) {
			if(player != currentPlayer) {
				for(Card card : player.getHand()) {
					if(card.getId().equalsIgnoreCase(suggestedWeapon)){
						canRefute = player;
						break;
					}
				}
			}
		}
		System.out.println(canRefute.getName() + " can refute, type 'y' to see hand and let " + currentPlayer.getName() +
		" know what card you can refute secretly");
		if(sc.next().equalsIgnoreCase("y")) {
			System.out.println(canRefute.showHand());
			System.out.println("(press 'y' to hide your hand and start the next turn)");
			if(sc.next().equalsIgnoreCase("y")) {
				System.out.flush();
			}
		}
	}
	
	/**
	 * finds which player can refute the suggested Room
	 * @param suggestedPerson
	 */
	public void refuteRoom(String suggestedRoom, Scanner sc) {
		Player canRefute = null;
		for(Player player : players) {
			if(player != currentPlayer) {
				for(Card card : player.getHand()) {
					if(card.getId().equalsIgnoreCase(suggestedRoom)){
						canRefute = player;
						break;
					}
				}
			}
		}
		System.out.println(canRefute.getName() + " can refute, type 'y' to see hand and let " + currentPlayer.getName() +
		" know what card you can refute secretly");
		if(sc.next().equalsIgnoreCase("y")) {
			System.out.println(canRefute.showHand());
			System.out.println("(press 'y' to hide your hand and start the next turn)");
			if(sc.next().equalsIgnoreCase("y")) {
				System.out.flush();
			}
		}
	}
	
	/**
	 * checks that the provided suggestion is valid, each card suggested exits and that the room a person
	 * suggest is the room that they are in
	 * @param suggestion
	 * @return
	 */
	public boolean isValidSuggestion(String[] suggestion) {
		boolean validCharacter = false;
		boolean validWeapon = false;
		boolean validRoom = false;
		for(Card character: characters) {
			if(character.getId().equalsIgnoreCase(suggestion[0])) validCharacter = true;
		}
		if(!validCharacter) {
			System.out.println("The person you have suggested \"" + suggestion[0] +"\" does not exist");
			return false;
		}
		
		for(Card weapon: weapons) {
			if(weapon.getId().equalsIgnoreCase(suggestion[1])) validWeapon = true;
		}
		if(!validWeapon) {
			System.out.println("The weapon you have suggested \"" + suggestion[1] +"\" does not exist");
			return false;
		}
		
		for(Card room: rooms) {
			if(room.getId().equalsIgnoreCase(suggestion[2])) validRoom = true;
		}
		if(!validRoom) {
			System.out.println("The room you have suggested \"" + suggestion[2] +"\" does not exist");
			return false;
		}
		
		if(!suggestion[2].equalsIgnoreCase(currentPlayer.getLocation().getRoom())) {
			System.out.println("The room you have suggested \"" + suggestion[2] +"\" is not the room that you are currently in\n"
					+ "you are in " + currentPlayer.getLocation().getRoom());
			return false;
		}
		
		return true;
	}
	
	/**
	 * checks that the provided accusation is valid, each card suggested exits.
	 * @param suggestion
	 * @return
	 */
	public boolean isValidAccusation(String[] suggestion) {
		boolean validCharacter = false;
		boolean validWeapon = false;
		boolean validRoom = false;
		for(Card character: characters) {
			if(character.getId().equalsIgnoreCase(suggestion[0])) validCharacter = true;
		}
		if(!validCharacter) {
			System.out.println("The person you have suggested \"" + suggestion[0] +"\" does not exist");
			return false;
		}
		
		for(Card weapon: weapons) {
			if(weapon.getId().equalsIgnoreCase(suggestion[1])) validWeapon = true;
		}
		if(!validWeapon) {
			System.out.println("The weapon you have suggested \"" + suggestion[1] +"\" does not exist");
			return false;
		}
		
		for(Card room: rooms) {
			if(room.getId().equalsIgnoreCase(suggestion[2])) validRoom = true;
		}
		if(!validRoom) {
			System.out.println("The room you have suggested \"" + suggestion[2] +"\" does not exist");
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		new Cluedo();
	}
	
}
