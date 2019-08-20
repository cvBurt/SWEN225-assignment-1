
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUI extends JFrame {

	private String setPlayer = "";
	private Map<String,String> playerList = new HashMap<String,String>();
	private Cluedo game;
	private Board boardObj;
	private JLabel botlb1;
	private JTextField botlb2;
	private JLabel[][] drawBoard;
	private JFrame gameFrame;
	private String accusedCharacter = "";
	private String suggestedWeapon ="";
	private String suggestedRoom = "";
	private int selectPlayerCount;
	private String[] currentMove;


	public GUI(Cluedo game, Board board){
		this.game = game;
		this.boardObj = board;
		this.drawBoard = new JLabel[24][25];
		mainMenu();
	}

	/**
	 * sets up GUI for the main menu of cluedo
	 */
	public void mainMenu() {
		JFrame mainMenu = new JFrame("Cluedo");
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.setPreferredSize(new Dimension(600,450));
		mainMenu.setResizable(false);

		JPanel panel = new JPanel();

		panel.setBackground(new Color(155, 215, 235));

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel.add(Box.createRigidArea(new Dimension(0,60)));

		JLabel title = new JLabel("Welcome to Cluedo\n");
		title.setFont(new Font(title.getFont().getName(),title.getFont().getStyle(), 50));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(title);

		panel.add(Box.createRigidArea(new Dimension(0,60)));

		JButton start = new JButton("Start");
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setFont(new Font(title.getFont().getName(),title.getFont().getStyle(), 25));
		start.setMaximumSize(new Dimension(150, 40));
		start.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
				String inp = JOptionPane.showInputDialog(panel,"Please enter the amount of players (3-6)");
				try {
					int noPlayers = Integer.parseInt(inp);
					if(noPlayers < 3 || noPlayers>6) {
						JOptionPane.showMessageDialog(panel, "You must enter a valid number between 3-6", "Bad Number",JOptionPane.ERROR_MESSAGE);
					}
					else {
						JPanel playerSelect = new JPanel();
						ButtonGroup btnGrp = new ButtonGroup();
						playerSelect.setLayout(new GridLayout(8,1));
						//playerSelect.setResizable(false);

						playerSelect.add(new JLabel("Player's Name"));

						JTextField playerName = new JTextField();
						playerSelect.add(playerName);

						JRadioButton missScar = new JRadioButton("Miss Scarlet");
						btnGrp.add(missScar);
						missScar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								setPlayer = "Miss Scarlet";
							}
						});
						playerSelect.add(missScar);

						JRadioButton colMust = new JRadioButton("Col. Mustard");
						btnGrp.add(colMust);
						colMust.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								setPlayer = "Colonel Mustard";
							}
						});
						playerSelect.add(colMust);

						JRadioButton mrsWhite = new JRadioButton("Mrs. White");
						btnGrp.add(mrsWhite);
						mrsWhite.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								setPlayer = "Mrs. White";
							}
						});
						playerSelect.add(mrsWhite);

						JRadioButton mrGreen = new JRadioButton("Mr. Green");
						btnGrp.add(mrGreen);
						mrGreen.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								setPlayer = "Mr. Green";
							}
						});
						playerSelect.add(mrGreen);

						JRadioButton mrsPea = new JRadioButton("Mrs. Peacock");
						btnGrp.add(mrsPea);
						mrsPea.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								setPlayer = "Mrs. Peacock";
							}
						});
						playerSelect.add(mrsPea);

						JRadioButton profPlum = new JRadioButton("Prof. Plum");
						btnGrp.add(profPlum);
						profPlum.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								setPlayer = "Prof. Plum";
							}
						});
						playerSelect.add(profPlum);

						playerName.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								if(btnGrp.getSelection() != null) {
									if(selectPlayerCount != noPlayers) {
										if(playerList.putIfAbsent(playerName.getText(),setPlayer) == null && !playerName.getText().equals("")) {
											btnGrp.getSelection().setEnabled(false);
											btnGrp.clearSelection();
											selectPlayerCount++;
											playerName.setText("");
										}
										else{
										JOptionPane.showMessageDialog(playerName, "You cant have the same name as someone else",
												"Bad Name",JOptionPane.ERROR_MESSAGE);
										}
									}
									if(selectPlayerCount == noPlayers) {
										playerSelect.setVisible(false);
										mainMenu.setVisible(false);
								    	mainMenu.dispose();
								    	game.setup(playerList);
									}
								}
							 }
						});
						playerSelect.setVisible(true);
						JOptionPane.showMessageDialog(panel, playerSelect, "Player Select", JOptionPane.PLAIN_MESSAGE);
						playerList.clear();
						selectPlayerCount = 0;
					}
				}
				catch(NumberFormatException error){
					JOptionPane.showMessageDialog(panel, "You must enter a valid number between 3-6", "Bad Number",JOptionPane.ERROR_MESSAGE);
				}
		    }
		});
		panel.add(start);


		panel.add(Box.createRigidArea(new Dimension(0,10)));

		JButton rules = new JButton("Rules");
		rules.setAlignmentX(Component.CENTER_ALIGNMENT);
		rules.setFont(new Font(title.getFont().getName(),title.getFont().getStyle(), 25));
		rules.setMaximumSize(new Dimension(150, 40));
		rules.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	JOptionPane.showMessageDialog(panel, Cluedo.checkForHelp(), "Rules", JOptionPane.PLAIN_MESSAGE);
		    }
		});
		panel.add(rules);

		panel.add(Box.createRigidArea(new Dimension(0,10)));

		JButton exit = new JButton("Quit");
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		exit.setFont(new Font(title.getFont().getName(),title.getFont().getStyle(), 25));
		exit.setMaximumSize(new Dimension(150, 40));
		exit.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	mainMenu.setVisible(false);
		    	mainMenu.dispose();
		    	System.exit(0);
		    }
		});

		panel.add(exit);

		mainMenu.add(panel);

		mainMenu.pack();
		mainMenu.setVisible(true);
	}


	/**
	 * set up GUI for the actual game of cluedo and controls it
	 */
	public void playGame() {
		gameFrame = new JFrame("Cluedo");

		Color back = new Color(224, 180, 94);
		Border black = BorderFactory.createLineBorder(Color.BLACK);

		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setPreferredSize(new Dimension(770,710));
		gameFrame.setLayout(new BorderLayout());
		gameFrame.setResizable(false);

		JMenuBar menu = new JMenuBar();
		menu.setPreferredSize(new Dimension(gameFrame.getWidth(),30));
		JMenuItem file = new JMenuItem("File");
		JMenuItem game = new JMenuItem("Game");
		menu.add(file);
		menu.add(game);
		gameFrame.add(menu, BorderLayout.PAGE_START);


		JPanel leftSide = new JPanel();
		leftSide.setBorder(black);
		leftSide.setPreferredSize(new Dimension(100,0));
		leftSide.setBackground(back);
		gameFrame.add(leftSide, BorderLayout.LINE_START);

		JPanel boardDisplay = new JPanel(new GridLayout(25,24));
		Cell[][] board = boardObj.getBoardArray();
		ImageIcon cellPic;
		JLabel label;
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 24; j++) {
				if (board[j][i].occupied) {
					cellPic = board[j][i].getPlayer().getImage();
				}
				else {
					cellPic = board[j][i].getPic();
				}
				label = new JLabel();
				label.setIcon(cellPic);
				if (board[j][i].occupied) {
					label.setToolTipText(board[j][i].getPlayer().dispName());
				}
				Border border = BorderFactory.createLineBorder(boardDisplay.getBackground(), 1);
				label.setBorder(border);
				boardDisplay.add(label);
				drawBoard[j][i] = label;
			}
		}
		boardDisplay.setBorder(black);
		gameFrame.add(boardDisplay, BorderLayout.CENTER);

		boardDisplay.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
		  });

		JPanel rightSide = new JPanel();
		rightSide.setBorder(black);
		rightSide.setPreferredSize(new Dimension(100,0));
		rightSide.setBackground(back);
		gameFrame.add(rightSide, BorderLayout.LINE_END);

		JPanel botDisp = new JPanel();
		botDisp.setLayout(new GridLayout(2,1));

		botlb1 = new JLabel();
		botlb1.setFont(new Font(botlb1.getFont().getName(),botlb1.getFont().getStyle(), 18));
		botlb1.setHorizontalAlignment(SwingConstants.CENTER);
		botDisp.add(botlb1);

		botlb2 = new JTextField();
		botDisp.add(botlb2);

		botDisp.setPreferredSize(new Dimension(gameFrame.getWidth(),100));
		gameFrame.add(botDisp, BorderLayout.PAGE_END);

		gameFrame.pack();
		gameFrame.setVisible(true);
	}

	/**
	 * Shows the hand of the specified player
	 * @param player
	 */
	public void showHand(Player player) {
		JPanel dispHand = new JPanel();
		List<Card> hand = player.getHand();

		GridLayout grid = new GridLayout(1,hand.size());
		dispHand.setLayout(grid);
		for(Card card : hand) {
			dispHand.add(new JLabel(card.getCardImg()));
		}
		JOptionPane.showMessageDialog(gameFrame,"Press 'OK' to show "+player.dispName()+"'s hand","Displaying Hand", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(gameFrame, dispHand, player.dispName()+"'s hand", JOptionPane.PLAIN_MESSAGE);
	}


	public String playTurn(Player currPlayer, int roll) {
		JPanel doMove = new JPanel();
		doMove.add(new JLabel(currPlayer.dispName()+" rolled a "+roll+"!!"));
		return botlb2.getText();

	}



	public void updateBoard() {
		Cell[][] board = boardObj.getBoardArray();
		ImageIcon cellPic;
		JLabel label;
		Border redBorder = BorderFactory.createLineBorder(Color.RED, 1);
		Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 1);
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 24; j++) {
				label = drawBoard[j][i];
				if (board[j][i].occupied) {
					cellPic = board[j][i].getPlayer().getImage();
				}
				else {
					cellPic = board[j][i].getPic();
				}
				label.setIcon(cellPic);
				if (board[j][i].occupied) {
					label.setToolTipText(board[j][i].getPlayer().dispName());
				}
				if(board[j][i].isGreenHighlight()) {
					label.setBorder(greenBorder);
				}
				else if(board[j][i].isRedHighlight()) {
					label.setBorder(redBorder);
				}

				drawBoard[j][i] = label;
			}
		}
	}

	public void deathNotice(Player player) {
		botlb1.setText("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		botlb2.setText(player.dispName()+" was removed from the game due to a false accusation");
		botlb3.setText("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}

	/**
	 * asks current player if they would like to make a suggestion
	 * @param currPlayer
	 * @return true if yes, false if no
	 */
	public boolean askToSuggest(Player currPlayer) {
		int confirm = JOptionPane.showConfirmDialog(gameFrame, "Would "+currPlayer.dispName()+" like to make a suggestion?" ,
				"Make Suggestion?", JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) return true;
		return false;
	}

	/**
	 * asks current player if they would like to make an accusation
	 * @param currPlayer
	 * @return true if yes, false if no
	 */
	public boolean askToAccuse(Player currPlayer) {
		int confirm = JOptionPane.showConfirmDialog(gameFrame, "Would "+currPlayer.dispName()+" like to make an accusation?" ,
				"Make Accusation?", JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) return true;
		return false;
	}

	/**
	 * collects the currents players suggestion
	 * @param currPlayer
	 * @return whether or not the suggestion is true
	 */
	public boolean makeSuggestion(Player currPlayer) {
		String[] suggest = new String[3];
		accusedCharacter = "";

		JPanel characterSelect = new JPanel();
		ButtonGroup btnGrp = new ButtonGroup();
		GridLayout grid = new GridLayout(4,game.getCharacters().size()/4);
		characterSelect.setLayout(grid);
		for(Card character : game.getCharacters()) {
			JRadioButton charBtn = new JRadioButton(character.getId());
			btnGrp.add(charBtn);
			charBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accusedCharacter = character.getId();
				}
			});
			characterSelect.add(charBtn);
		}
		int check = JOptionPane.showConfirmDialog(gameFrame, characterSelect, currPlayer.dispName()+" Suggest Character", JOptionPane.OK_CANCEL_OPTION);
		if(check == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(gameFrame, "You can't cancel a suggestion", currPlayer.dispName()+" Suggest Character", JOptionPane.PLAIN_MESSAGE);
			return makeSuggestion(currPlayer);
		}
		if(accusedCharacter.equals("")) {
			JOptionPane.showMessageDialog(gameFrame, "You must select a character", currPlayer.dispName()+" Suggest Character", JOptionPane.PLAIN_MESSAGE);
			return makeSuggestion(currPlayer);
		}
		suggest[0] = accusedCharacter;

		suggestedWeapon = "";

		JPanel weaponSelect = new JPanel();
		btnGrp = new ButtonGroup();
		grid = new GridLayout(4,game.getWeapons().size()/4);
		weaponSelect.setLayout(grid);
		for(Card weapon : game.getWeapons()) {
			JRadioButton weaponBtn = new JRadioButton(weapon.getId());
			btnGrp.add(weaponBtn);
			weaponBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					suggestedWeapon = weapon.getId();
				}
			});
			weaponSelect.add(weaponBtn);
		}
		check = JOptionPane.showConfirmDialog(gameFrame, weaponSelect, currPlayer.dispName()+" Suggest Weapon", JOptionPane.OK_CANCEL_OPTION);
		if(check == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(gameFrame, "You can't cancel a suggestion", currPlayer.dispName()+" Suggest Weapon", JOptionPane.PLAIN_MESSAGE);
			return makeSuggestion(currPlayer);
		}
		if(suggestedWeapon.equals("")) {
			JOptionPane.showMessageDialog(gameFrame, "You must select a wepaon", currPlayer.dispName()+" Suggest Weapon", JOptionPane.PLAIN_MESSAGE);
			return makeSuggestion(currPlayer);
		}
		suggest[1] = suggestedWeapon;

		suggestedRoom = "";

		JPanel roomSelect = new JPanel();
		btnGrp = new ButtonGroup();
		grid = new GridLayout(4,game.getRooms().size()/4);
		roomSelect.setLayout(grid);
		for(Card room : game.getRooms()) {
			JRadioButton roomBtn = new JRadioButton(room.getId());
			btnGrp.add(roomBtn);
			roomBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					suggestedRoom = room.getId();
				}
			});
			roomSelect.add(roomBtn);
		}
		check = JOptionPane.showConfirmDialog(gameFrame, roomSelect, currPlayer.dispName()+" Suggest Room", JOptionPane.OK_CANCEL_OPTION);
		if(check == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(gameFrame, "You can't cancel a suggestion", currPlayer.dispName()+" Suggest Room", JOptionPane.PLAIN_MESSAGE);
			return makeSuggestion(currPlayer);
		}
		if(suggestedRoom.equals("")) {
			JOptionPane.showMessageDialog(gameFrame, "You must select a room", currPlayer.dispName()+" Suggest Room", JOptionPane.PLAIN_MESSAGE);
			return makeSuggestion(currPlayer);
		}
		suggest[2] = suggestedRoom;

		return game.checkSuggestion(suggest);
	}

	/**
	 * collects the currents players accusation
	 * @param currPlayer
	 * @return whether or not the accusation is true
	 */
	public boolean makeAccusation(Player currPlayer) {
		String[] accuse = new String[3];

		accusedCharacter = "";

		JPanel characterSelect = new JPanel();
		ButtonGroup btnGrp = new ButtonGroup();
		GridLayout grid = new GridLayout(4,game.getCharacters().size()/4);
		characterSelect.setLayout(grid);
		for(Card character : game.getCharacters()) {
			JRadioButton charBtn = new JRadioButton(character.getId());
			btnGrp.add(charBtn);
			charBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accusedCharacter = character.getId();
				}
			});
			characterSelect.add(charBtn);
		}
		int check = JOptionPane.showConfirmDialog(gameFrame, characterSelect, currPlayer.dispName()+" Accuse Character", JOptionPane.OK_CANCEL_OPTION);
		if(check == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(gameFrame, "You can't cancel an Accusation", currPlayer.dispName()+" Accuse Character", JOptionPane.PLAIN_MESSAGE);
			return makeAccusation(currPlayer);
		}
		if(accusedCharacter.equals("")) {
			JOptionPane.showMessageDialog(gameFrame, "You must select a character", currPlayer.dispName()+" Accuse Character", JOptionPane.PLAIN_MESSAGE);
			return makeAccusation(currPlayer);
		}
		accuse[0] = accusedCharacter;

		suggestedWeapon = "";

		JPanel weaponSelect = new JPanel();
		btnGrp = new ButtonGroup();
		grid = new GridLayout(4,game.getWeapons().size()/4);
		weaponSelect.setLayout(grid);
		for(Card weapon : game.getWeapons()) {
			JRadioButton weaponBtn = new JRadioButton(weapon.getId());
			btnGrp.add(weaponBtn);
			weaponBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					suggestedWeapon = weapon.getId();
				}
			});
			weaponSelect.add(weaponBtn);
		}
		check = JOptionPane.showConfirmDialog(gameFrame, weaponSelect, currPlayer.dispName()+" Accuse Weapon", JOptionPane.OK_CANCEL_OPTION);
		if(check == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(gameFrame, "You can't cancel an accusation", currPlayer.dispName()+" Accuse Weapon", JOptionPane.PLAIN_MESSAGE);
			return makeAccusation(currPlayer);
		}
		if(suggestedWeapon.equals("")) {
			JOptionPane.showMessageDialog(gameFrame, "You must select a weapon", currPlayer.dispName()+" Accuse Weapon", JOptionPane.PLAIN_MESSAGE);
			return makeAccusation(currPlayer);
		}
		accuse[1] = suggestedWeapon;

		suggestedRoom = "";

		JPanel roomSelect = new JPanel();
		btnGrp = new ButtonGroup();
		grid = new GridLayout(4,game.getRooms().size()/4);
		roomSelect.setLayout(grid);
		for(Card room : game.getRooms()) {
			JRadioButton roomBtn = new JRadioButton(room.getId());
			btnGrp.add(roomBtn);
			roomBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					suggestedRoom = room.getId();
				}
			});
			roomSelect.add(roomBtn);
		}
		check = JOptionPane.showConfirmDialog(gameFrame, roomSelect, currPlayer.dispName()+" Accuse Room", JOptionPane.OK_CANCEL_OPTION);
		if(check == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(gameFrame, "You can't cancel an accusation", currPlayer.dispName()+" Accuse Room", JOptionPane.PLAIN_MESSAGE);
			return makeAccusation(currPlayer);
		}
		if(suggestedRoom.equals("")) {
			JOptionPane.showMessageDialog(gameFrame, "You must select a room", currPlayer.dispName()+" Accuse Room", JOptionPane.PLAIN_MESSAGE);
			return makeAccusation(currPlayer);
		}
		accuse[2] = suggestedRoom;

		return game.checkAccusation(accuse);
	}

	public boolean moveComplete() {
		return moveEntered;
	}

	public void setHighlighted(Set<Cell> highlight) {
		this.highlightedCell = highlight;
	}

}
