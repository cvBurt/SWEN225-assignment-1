import java.util.*;

import javax.swing.ImageIcon;

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
	private GUI display;

	/**
	 * constructor used for testing purposes
	 * @param startingPlayer
	 * @param board
	 */
	public Cluedo (Player startingPlayer, Board board) {
		this.currentPlayer = startingPlayer;
		this.board = board;
	}

	/**
	 * normal constructor
	 */
	public Cluedo (){
		players = new ArrayList<Player>();
		addCharacters();
		addWeapons();
		addRooms();
		board = new Board();
		display = new GUI(this,board);
	}

	/**
	 * Sets up the start of the game by distinguishing the amount of players
	 * randomly generating a solution
	 * and then distributing the cards amongst the players
	 */
	public void setup(Map<String,String> playerList) {
		for(String player : playerList.keySet()) {
			for(int i=0; i<characters.size(); i++) {
				Card character = characters.get(i);
				if(character.getId().equals(playerList.get(player))) {
					Cell startPos = board.getCell(character.getStartRow(), character.getStartCol());
					Player toAdd = new Player(player, startPos, playerList.get(player), character.getImg(), character.getRoomImg(),i);
					startPos.setPlayer(toAdd);
					players.add(toAdd);
					break;
				}
			}
		}
		Collections.sort(players);
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
				if(allCards.isEmpty()) break;
			}
		}

		display.playGame();
		for(Player player : players) {
			display.showHand(player);
		}
		//display.playTurn(currentPlayer, 50);

		tick();
	}

	/**
	 * main loop for running game, each loop turn (a tick)
	 * @param sc
	 */
	public void tick() {
		int playerTurn = 0;
		//while(true) {
			System.out.println("looped");
			currentPlayer = players.get(playerTurn);
			if(!currentPlayer.getStatus()) {
				if(!currentPlayer.getLocation().getRoom().equals("Hallway")) {
					exitRoom();

				}
				display.playTurn(currentPlayer,rollDice());
//				while(!display.moveComplete()) {
//					System.out.println("check");
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
				if(!currentPlayer.getLocation().getRoom().equals("Hallway")) {
					if(display.askToSuggest(currentPlayer)) {
							if(display.makeSuggestion(currentPlayer)) {
									//break;
							}
					}
					if(display.askToAccuse(currentPlayer)) {
							if(display.makeAccusation(currentPlayer)) {
								//break;
							}
							enterRoom("None",currentPlayer);
							display.deathNotice(currentPlayer);
							currentPlayer.kill();
					}
				}
			}
			playerTurn++;
			if(playerTurn == players.size()) playerTurn = 0;
		//}
		if(wonFromAccu) System.out.println(currentPlayer.getName() + " won the game with the accusation: " + winningClaim);
		else System.out.println(currentPlayer.getName() + " won the game with the suggestion: " + winningClaim);
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
		characters.add(new Card("character","Miss Scarlet",7,24, new ImageIcon(getClass().getResource("Scarlet.png")),new ImageIcon(getClass().getResource("MissScarletCard.png")), new ImageIcon(getClass().getResource("ScarletRoom.png"))));
		characters.add(new Card("character","Colonel Mustard",0,17, new ImageIcon(getClass().getResource("Mustard.png")),new ImageIcon(getClass().getResource("ColMustardCard.png")), new ImageIcon(getClass().getResource("MustardRoom.png"))));
		characters.add(new Card("character","Mrs. White",9,0, new ImageIcon(getClass().getResource("White.png")),new ImageIcon(getClass().getResource("MrsWhiteCard.png")), new ImageIcon(getClass().getResource("WhiteRoom.png"))));
		characters.add(new Card("character","Mr. Green",14,0, new ImageIcon(getClass().getResource("Green.png")),new ImageIcon(getClass().getResource("MrGreenCard.png")), new ImageIcon(getClass().getResource("GreenRoom.png"))));
		characters.add(new Card("character","Mrs. Peacock",23,6, new ImageIcon(getClass().getResource("Peacock.png")),new ImageIcon(getClass().getResource("MrsPeacockCard.png")), new ImageIcon(getClass().getResource("PeacockRoom.png"))));
		characters.add(new Card("character","Prof. Plum",23,19, new ImageIcon(getClass().getResource("Plum.png")),new ImageIcon(getClass().getResource("ProfPlumCard.png")), new ImageIcon(getClass().getResource("PlumRoom.png"))));
	}

	/**
	 * generates the weapons array list which will be used to distribute cards later
	 */
	public void addWeapons() {
		weapons = new ArrayList<Card>();
		weapons.add(new Card("weapon","Candelstick",new ImageIcon(getClass().getResource("candelstick.png"))));
		weapons.add(new Card("weapon","Dagger",new ImageIcon(getClass().getResource("dagger.png"))));
		weapons.add(new Card("weapon","Lead Pipe",new ImageIcon(getClass().getResource("leadPipe.png"))));
		weapons.add(new Card("weapon","Revolver",new ImageIcon(getClass().getResource("revolver.png"))));
		weapons.add(new Card("weapon","Rope",new ImageIcon(getClass().getResource("rope.png"))));
		weapons.add(new Card("weapon","Wrench",new ImageIcon(getClass().getResource("wrench.png"))));
	}

	/**
	 * generates the rooms array list which will be used to distribute cards later
	 */
	public void addRooms() {
		rooms = new ArrayList<Card>();
		rooms.add(new Card("room","Kitchen",new ImageIcon(getClass().getResource("kitchen.png"))));
		rooms.add(new Card("room","Ball Room",new ImageIcon(getClass().getResource("ballroom.png"))));
		rooms.add(new Card("room","Conservatory",new ImageIcon(getClass().getResource("conservatory.png"))));
		rooms.add(new Card("room","Dining Room",new ImageIcon(getClass().getResource("dinning.png"))));
		rooms.add(new Card("room","Billiard Room",new ImageIcon(getClass().getResource("billiard.png"))));
		rooms.add(new Card("room","Library",new ImageIcon(getClass().getResource("library.png"))));
		rooms.add(new Card("room","Lounge",new ImageIcon(getClass().getResource("lounge.png"))));
		rooms.add(new Card("room","Hall",new ImageIcon(getClass().getResource("hall.png"))));
		rooms.add(new Card("room","Study",new ImageIcon(getClass().getResource("study.png"))));
	}

	/**
	 * generates to random integers between 1 and 6 and adds them together
	 * @return
	 */
	public int rollDice() {
		Random rand = new Random();
		return (rand.nextInt(6)+1) + (rand.nextInt(6)+1);
	}

	/**
	 * displays options for exiting room and moves player to selected exit
	 * @param sc
	 */
	public void exitRoom() {
		System.out.println(currentPlayer.getLocation().getRoom());
		Cell[] exits = board.roomDoors.get(currentPlayer.getLocation().getRoom());
		int numExits = exits.length;
		int input;
		while(true) {
			input = 0;
			if(input > -1 && input < numExits) {
				currentPlayer.toggleRoom();
				exits[input].removePlayer();
				currentPlayer.getLocation().removePlayer();
				currentPlayer.setLocation(exits[input]);
				break;
			}
		}
		for(int i=0; i<numExits; i++) {
			exits[i].removeExit();
		}
		display.updateBoard();
	}

	/**
	 * makes the given player enter the room putting them in the first available display
	 * spot for that room
	 * @param room
	 * @param playerToEnter
	 */
	public void enterRoom(String room, Player playerToEnter) {
		Cell[] store = board.roomStore.get(room);
		for(int i=0; i<store.length; i++) {
			if(!store[i].hasPlayer()) {
				if(playerToEnter.getLocation().getRoom().equals("Hallway")) {
					playerToEnter.toggleRoom();
				}
				store[i].setPlayer(playerToEnter);
				playerToEnter.getLocation().removePlayer();
				playerToEnter.setLocation(store[i]);
				break;
			}
		}
		display.updateBoard();
	}

	/**
	 * makes sure that the given move is a valid one, ie follows correct format
	 * @param sc
	 * @param roll
	 */
//	public void validateMove(String[] move, int roll) {
//		List<String> validMoves = new ArrayList<String>(Arrays.asList("n","e","s","w"));
//		while(true) {
//				boolean validMove = true;
//				for(int i=0; i <move.length; i++) {
//					String character = move[i];
//					if(!validMoves.contains(character.toLowerCase())) {
//						validMove = false;
//					}
//				}
//				if(validMove) {
//					if(applyMove(move,roll)) {
//						board.draw();
//						break;
//					}
//				}
//				else {
//				}
//		}
//	}

	/**
	 * applies the given move to the current character, checking along the way if it is valid
	 * (doesn't go through walls, over other people, visit the same square twice in one move)
	 * return player to starting cell of move if move is invalid
	 * @param move
	 * @param roll
	 * @return with move was successful or not
	 */
	public boolean highLightMove(String[] move) {
		Cell proposedLoc = null;
		Cell currentLoc = currentPlayer.getLocation();
		Cell originLoc = currentPlayer.getLocation();
		String prevRoundRoom = currentPlayer.getPrevRoundRoom();
		Set<Cell> visited = new HashSet<Cell>();
		for(int i=0; i<move.length; i++) {
			visited.add(currentLoc);
			if(move[i].equals("n")) {
				if(currentLoc.getNorthNeighbour()) {
					proposedLoc = board.getCell(currentLoc.getX(),currentLoc.getY()-1);
					if(!prevRoundRoom.equals("Hallway") && prevRoundRoom.equals(proposedLoc.getRoom())){
						break;
					}
					if(visited.contains(proposedLoc)) {
						break;
					}
					if(proposedLoc.hasPlayer()) {
						break;
					}
					if(proposedLoc.getSouthNeighbour()) {
						currentLoc = proposedLoc;
						if(!currentLoc.getRoom().equals("Hallway")) {
							//enterRoom(currentLoc.getRoom(), currentPlayer);
							highlightGreen(visited);
							return true;
						}
					}
					else {
						break;
					}

				}
			}
			else if(move[i].equals("s")) {
				if(currentLoc.getSouthNeighbour()) {
					proposedLoc = board.getCell(currentLoc.getX(),currentLoc.getY()+1);
					if(!prevRoundRoom.equals("Hallway") && prevRoundRoom.equals(proposedLoc.getRoom())){
						break;
					}
					if(visited.contains(proposedLoc)) {
						break;
					}
					if(proposedLoc.hasPlayer()) {
						break;
					}
					if(proposedLoc.getNorthNeighbour()) {
						currentLoc = proposedLoc;
						if(!currentLoc.getRoom().equals("Hallway")) {
							//enterRoom(currentLoc.getRoom(), currentPlayer);
							highlightGreen(visited);
							return true;
						}
					}
					else {
						break;
					}

				}
			}
			else if(move[i].equals("w")) {
				if(currentLoc.getWestNeighbour()) {
					proposedLoc = board.getCell(currentLoc.getX()-1,currentLoc.getY());
					if(!prevRoundRoom.equals("Hallway") && prevRoundRoom.equals(proposedLoc.getRoom())){
						break;
					}
					if(visited.contains(proposedLoc)) {
						break;
					}
					if(proposedLoc.hasPlayer()) {
						break;
					}
					if(proposedLoc.getEastNeighbour()) {
						currentLoc = proposedLoc;
						if(!currentLoc.getRoom().equals("Hallway")) {
							//enterRoom(currentLoc.getRoom(), currentPlayer);
							highlightGreen(visited);
							return true;
						}
					}
					else {
						break;
					}

				}
			}
			else if(move[i].equals("e")) {
				if(currentLoc.getEastNeighbour()) {
					proposedLoc = board.getCell(currentLoc.getX()+1,currentLoc.getY());
					if(!prevRoundRoom.equals("Hallway") && prevRoundRoom.equals(proposedLoc.getRoom())){
						break;
					}
					if(visited.contains(proposedLoc)) {
						break;
					}
					if(proposedLoc.hasPlayer()) {
						break;
					}
					if(proposedLoc.getWestNeighbour()) {
						currentLoc = proposedLoc;
						if(!currentLoc.getRoom().equals("Hallway")) {
							//enterRoom(currentLoc.getRoom(),currentPlayer);
							highlightGreen(visited);
							return true;
						}
					}
					else {
						break;
					}
				}
			}
			else {
				break;
			}
		}
		highlightRed(visited);
		return false;
	}

	public void highlightRed(Set<Cell> highlight) {
		for(Cell cell : highlight) {
			cell.setRedHighLight();
		}
		display.setHighlighted(highlight);
		display.updateBoard();
	}

	public void highlightGreen(Set<Cell> highlight) {
		for(Cell cell : highlight) {
			cell.setGreenHighlight();
		}
		display.setHighlighted(highlight);
		display.updateBoard();
	}


	/**
	 * checks whether the given suggestion is correct or not, making sure that the suggestion is done in
	 * the correct format at the same time
	 * @param sc
	 * @return
	 */
	public boolean checkSuggestion(String[] suggestion) {
		if(!suggestion[0].equalsIgnoreCase(currentPlayer.getcharacterName())) {
			for(Player player : this.players) {
				if(player.getcharacterName().equalsIgnoreCase(suggestion[0])) {
					for(Card room : rooms) {
						if(room.getId().equalsIgnoreCase(suggestion[2]))
						enterRoom(room.getId(),player);
					}
				}
			}
		}
		if(murderer.getId().equalsIgnoreCase(suggestion[0])) {
			if(murderWeapon.getId().equalsIgnoreCase(suggestion[1])) {
				if(murderRoom.getId().equalsIgnoreCase(suggestion[2])) {
					winningClaim = Arrays.toString(suggestion);
					wonFromAccu = false;
					return true;
				}
				else {
					refuteRoom(suggestion[2]);
				}
			}
			else {
				refuteWeapon(suggestion[1]);
			}
		}
		else {
			refutePerson(suggestion[0]);
		}
		return false;
	}

	/**
	 * checks whether the given accusation is correct or not, making sure that the accusation is done in
	 * the correct format at the same time
	 * @param sc
	 * @return if accusation is true or false
	 */
	public boolean checkAccusation(String[] accusation) {
		if(murderer.getId().equalsIgnoreCase(accusation[0])) {
			if(murderWeapon.getId().equalsIgnoreCase(accusation[1])) {
				if(murderRoom.getId().equalsIgnoreCase(accusation[2])) {
					winningClaim = Arrays.toString(accusation);
					wonFromAccu = true;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * print a list of rules when a user requests them
	 * @param sc
	 */
	public static String checkForHelp() {
			return  "Every character, weapon and room is represented by a card in the game. Before the game starts, one\n" +
					"character, one weapon, and one room card are selected at random by the program. This selection represents\n" +
					"the murder circumstances, i.e., the solution that players need to figure out during game play.\n" +
					"The remaining weapon, room and character cards are then randomly distributed to the players.\n" +
					"Some players may end up with more cards than others. At the start of the game, each player is asked\n" +
					"to look at their hand, while the other players look away. As the only other time a player's cards are\n"+
					"when a suggestion is made, each player should take note of what they have."+
					"\n" +
					"Players then take it in turns to roll from 2-12 and type the direction the player wants to move\n" +
					"in, equal to the total rolled. Diagonal movement is not allowed and no space may be used\n" +
					"twice during one turn. When a player enters a room, they do not need to use any remaining moves\n" +
					"they have left. They may then hypothesise about the murder circumstances by making a suggestion\n" +
					"which comprises the room they are in, a character and a weapon. This is typed in the fashion of (character),(weapon),(room).\n" +
					"If the character and weapon named in the suggestion are not in that room yet, they are now moved into the room.\n" +
					"When a suggestion is made, the program checks, in a clockwise fashion, starting from the current player,\n" +
					"for players who can refute the suggestion. A suggestion is refuted by producing a card that matches one of\n" +
					"the named murder circumstances (as such a card cannot be in the solution envelope). A refutation\n" +
					"has all the other players look away from the screen while the player shows the card which matches. If a player has\n" +
					"multiple refutation cards, it is their choice which one they pick. If no player can produce a refutation, the named\n" +
					"murder circumstances are a potential solution candidate that may or may not be used to make an accusation\n" +
					"later on (by any player).\n" +
					"\n" +
					"An accusation comprises a character, a weapon, and a room (which can be any room, not just the\n" +
					"one the player making the accusation may be in). It is typed in the exact same way as a suggestion.\n" +
					"If the accusation made by a player exactly matches the actual murder circumstances (the program checks\n" +
					"if the accusation and solution match) the player wins, otherwise the player is excluded from making\n" +
					"further suggestions or accusations. This means the player will continue to refute suggestions by others\n" +
					"but cannot win the game anymore.\n" ;
	}

	/**
	 * finds which player can refute the suggested person
	 * @param suggestedPerson
	 */
	public void refutePerson(String suggestedPerson) {
		Player canRefute = null;
		for(Player player : players) {
			for(Card card : player.getHand()) {
				if(card.getId().equalsIgnoreCase(suggestedPerson)){
					canRefute = player;
					break;
				}
			}
		}
	}

	/**
	 * finds which player can refute the suggested Weapon
	 * @param suggestedPerson
	 */
	public void refuteWeapon(String suggestedWeapon) {
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
	}

	/**
	 * finds which player can refute the suggested Room
	 * @param suggestedPerson
	 */
	public void refuteRoom(String suggestedRoom) {
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
	}

	/**
	 * returns all characters for testing purposes
	 * @return
	 */
	public List<Card> getCharacters() {
		return characters;
	}

	/**
	 * returns all characters for testing purposes
	 * @return
	 */
	public List<Card> getWeapons() {
		return weapons;
	}

	/**
	 * returns all characters for testing purposes
	 * @return
	 */
	public List<Card> getRooms() {
		return rooms;
	}

	public static void main(String[] args) {
		new Cluedo();
	}
}
