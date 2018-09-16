package tictactoe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
/*
 * to do:
 * move buttons into objects and list for ease of access
 * modulo the board instead of 100 if statements
 * add opponent/ai/2player option
 * clean up code
 */

public class TicTacToe {

	private JFrame frame;
	private String startGame = "X";
	private int xCounter, oCounter = 0;
	private int counter = 0;
	private int whosMove = -1;
	private JTextField tCountX;
	private JTextField tCount0;
	String[][] bu;
	JButton b1 = new JButton("");
	JButton b2 = new JButton("");
	JButton b3 = new JButton("");
	JButton b4 = new JButton("");
	JButton b5 = new JButton("");
	JButton b6 = new JButton("");
	JButton b7 = new JButton("");
	JButton b8 = new JButton("");
	JButton b9 = new JButton("");
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToe() {
		initialize();
	}
	
	//methods
	
	private void GameScore() {
		if (whosMove == -1) {
			throw new NullPointerException();
				
		}
		
		
		if (whosMove == 0) {
			
			tCountX.setText(Integer.toString(xCounter));
				
		} else {
			
			tCount0.setText(Integer.toString(oCounter));

		}
		
		resetMatrix();
	}
	
	private void resetMatrix() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				bu[i][j] = null;
			}
		}
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setText(null);
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setText(null);
		b3.setBackground(Color.LIGHT_GRAY);
		b3.setText(null);
		b4.setBackground(Color.LIGHT_GRAY);
		b4.setText(null);
		b5.setBackground(Color.LIGHT_GRAY);
		b5.setText(null);
		b6.setBackground(Color.LIGHT_GRAY);
		b6.setText(null);
		b7.setBackground(Color.LIGHT_GRAY);
		b7.setText(null);
		b8.setBackground(Color.LIGHT_GRAY);
		b8.setText(null);
		b9.setBackground(Color.LIGHT_GRAY);
		b9.setText(null);
		
	}
	
	private void aiMove() {
		int r1, r2;
		int[] bestMoveToMake = bestMove(bu);
		whosMove = 1;

		r1 = bestMoveToMake[0];
		r2 = bestMoveToMake[1];
		
		if (!checkFull()) {
			if (r1 == 0 && r2 == 0) {
				b1.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bu[r1][r2] = "X";
					b1.setForeground(Color.RED);
				} else {
					bu[r1][r2] = "0";
					b1.setForeground(Color.BLUE);
				}
			} else if (r1 == 0 && r2 == 1) {
				b2.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bu[r1][r2] = "X";
					b2.setForeground(Color.RED);
				} else {
					bu[r1][r2] = "0";
					b2.setForeground(Color.BLUE);
				}
			} else if (r1 == 0 && r2 == 2) {
				b3.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bu[r1][r2] = "X";
					b3.setForeground(Color.RED);
				} else {
					bu[r1][r2] = "0";
					b3.setForeground(Color.BLUE);
				}
			} else if (r1 == 1 && r2 == 0) {
				b4.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bu[r1][r2] = "X";
					b4.setForeground(Color.RED);
				} else {
					bu[r1][r2] = "0";
					b4.setForeground(Color.BLUE);
				}
			} else if (r1 == 1 && r2 == 1) {
				b5.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bu[r1][r2] = "X";
					b5.setForeground(Color.RED);
				} else {
					bu[r1][r2] = "0";
					b5.setForeground(Color.BLUE);
				}
			} else if (r1 == 1 && r2 == 2) {
				b6.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bu[r1][r2] = "X";
					b6.setForeground(Color.RED);
				} else {
					bu[r1][r2] = "0";
					b6.setForeground(Color.BLUE);
				}
			} else if (r1 == 2 && r2 == 0) {
				b7.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bu[r1][r2] = "X";
					b7.setForeground(Color.RED);
				} else {
					bu[r1][r2] = "0";
					b7.setForeground(Color.BLUE);
				}
			} else if (r1 == 2 && r2 == 1) {
				b8.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bu[r1][r2] = "X";
					b8.setForeground(Color.RED);
				} else {
					bu[r1][r2] = "0";
					b8.setForeground(Color.BLUE);
				}
			} else if (r2 == 2 && r2 == 2) {
				b9.setText(startGame);
				if (startGame.equalsIgnoreCase("X")) {
					bu[r1][r2] = "X";
					b9.setForeground(Color.RED);
				} else {
					bu[r1][r2] = "0";
					b9.setForeground(Color.BLUE);
				}
			}
			

			choosePlayer();
			if (WinningGame(bu)) {
				
				xCounter++;
				GameScore();
				JOptionPane.showMessageDialog(frame, "AI Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
	}
	
	
	private boolean checkFull() {
		boolean full;
		counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(bu[i][j] != null) {
					counter++;
				}
			}
		}
		
		if (counter >= 9) {
			resetMatrix();
			full = true;
		} else {
			counter = 0;
			full = false;
		}
		return full;
	}
	
	private void choosePlayer() {
		if (startGame.equalsIgnoreCase("X")) {
			startGame = "0";
		} else {
			startGame = "X";
		}
	}
	
	//needs to be improved upon heavily
	private boolean WinningGame(String[][] anArray) {
		boolean winningGame = false;
		String bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
		
		bt1 = anArray[0][0];
		bt2 = anArray[0][1];
		bt3 = anArray[0][2];
		
		bt4 = anArray[1][0];
		bt5 = anArray[1][1];
		bt6 = anArray[1][2];
		
		bt7 = anArray[2][0];
		bt8 = anArray[2][1];
		bt9 = anArray[2][2];
		
		
		if (bt1 == "X" && bt2 == "X" && bt3 == "X") {
			winningGame = true;
			
		} else if (bt4 == "X" && bt5 == "X" && bt6 == "X") {

			winningGame = true;
			
		} else if (bt7 == "X" && bt8 == "X" && bt9 == "X") {

			winningGame = true;
			
		} else if (bt1 == "X" && bt4 == "X" && bt7 == "X") {

			winningGame = true;
			
		} else if (bt2 == "X" && bt5 == "X" && bt8 == "X") {
			
			winningGame = true;
			
		} else if (bt3 == "X" && bt6 == "X" && bt9 == "X") {
			
			winningGame = true;
			
		} else if (bt7 == "X" && bt5 == "X" && bt3 == "X") {

			winningGame = true;
			
		} else if (bt1 == "X" && bt5 == "X" && bt9 == "X") {

			winningGame = true;
			
			//0 player
			
		} else if (bt1 == "0" && bt2 == "0" && bt3 == "0") {
			winningGame = true;
			
			
		} else if (bt4 == "0" && bt5 == "0" && bt6 == "0") {

			winningGame = true;
			
		} else if (bt7 == "0" && bt8 == "0" && bt9 == "0") {

			winningGame = true;
			
		} else if (bt1 == "0" && bt4 == "0" && bt7 == "0") {

			winningGame = true;
			
		} else if (bt2 == "0" && bt5 == "0" && bt8 == "0") {
		
			winningGame = true;
			
		} else if (bt3 == "0" && bt6 == "0" && bt9 == "0") {

			winningGame = true;
			
		} else if (bt7 == "0" && bt5 == "0" && bt3 == "0") {

			winningGame = true;
			
		} else if (bt1 == "0" && bt5 == "0" && bt9 == "0") {

			winningGame = true;

		} else if (checkFull()){
			JOptionPane.showMessageDialog(frame, "DRAW", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
			resetMatrix();
		}
		else {
			
		}
		return winningGame;
	}
		
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bu = new String[3][3];
		
		resetMatrix();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 5, 2, 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bu[0][0] == null) {
					b1.setText(startGame);
					whosMove = 0;
					if (startGame.equalsIgnoreCase("X")) {
						bu[0][0] = "X";
						b1.setForeground(Color.RED);
					} else {
						bu[0][0] = "0";
						b1.setForeground(Color.BLUE);
					}
					choosePlayer();
					if(WinningGame(bu)) {

						oCounter++;
						whosMove = 0;
						GameScore();
						JOptionPane.showMessageDialog(frame, "Player Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
						
					}
					aiMove();
				}
			}
		});
		b1.setFont(new Font("Carlito", Font.BOLD, 50));
		panel_1.add(b1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bu[0][1] == null) {
					b2.setText(startGame);
					whosMove = 0;
					if (startGame.equalsIgnoreCase("X")) {
						bu[0][1] = "X";
						b2.setForeground(Color.RED);
					} else {
						bu[0][1] = "0";
						b2.setForeground(Color.BLUE);
					}
					choosePlayer();
					if(WinningGame(bu)) {

						oCounter++;
						whosMove = 0;
						GameScore();
						JOptionPane.showMessageDialog(frame, "Player Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					}
					aiMove();
				}
			}
		});
		b2.setFont(new Font("Carlito", Font.BOLD, 50));
		panel_2.add(b2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bu[0][2] == null) {
					b3.setText(startGame);
					whosMove = 0;
					if (startGame.equalsIgnoreCase("X")) {
						bu[0][2] = "X";
						b3.setForeground(Color.RED);
					} else {
						bu[0][2] = "0";
						b3.setForeground(Color.BLUE);
					}
					choosePlayer();
					if(WinningGame(bu)) {

						oCounter++;
						whosMove = 0;
						GameScore();
						JOptionPane.showMessageDialog(frame, "Player Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					}
					aiMove();
				}
			}
		});
		b3.setFont(new Font("Carlito", Font.BOLD, 50));
		panel_3.add(b3, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPlayerX = new JLabel("USER");
		lblPlayerX.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerX.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		panel_4.add(lblPlayerX, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		tCountX = new JTextField();
		tCountX.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		tCountX.setHorizontalAlignment(SwingConstants.CENTER);
		tCountX.setText("0");
		panel_5.add(tCountX, BorderLayout.CENTER);
		tCountX.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bu[1][0] == null) {
					b4.setText(startGame);
					whosMove = 0;
					if (startGame.equalsIgnoreCase("X")) {
						bu[1][0] = "X";
						b4.setForeground(Color.RED);
					} else {
						bu[1][0] = "0";
						b4.setForeground(Color.BLUE);
					}
					choosePlayer();
					if(WinningGame(bu)) {

						oCounter++;
						whosMove = 0;
						GameScore();
						JOptionPane.showMessageDialog(frame, "Player Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
						
					}
					aiMove();
				}
			}
		});
		b4.setFont(new Font("Carlito", Font.BOLD, 50));
		panel_6.add(b4, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bu[1][1] == null) {
					b5.setText(startGame);
					whosMove = 0;
					if (startGame.equalsIgnoreCase("X")) {
						bu[1][1] = "X";
						b5.setForeground(Color.RED);
					} else {
						bu[1][1] = "0";
						b5.setForeground(Color.BLUE);
					}
					choosePlayer();
					if(WinningGame(bu)) {

						oCounter++;
						whosMove = 0;
						GameScore();
						JOptionPane.showMessageDialog(frame, "Player Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
						
					}
					aiMove();
				}
			}
		});
		b5.setFont(new Font("Carlito", Font.BOLD, 50));
		panel_7.add(b5, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
	
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bu[1][2] == null) {
					b6.setText(startGame);
					whosMove = 0;
					if (startGame.equalsIgnoreCase("X")) {
						bu[1][2] = "X";
						b6.setForeground(Color.RED);
					} else {
						bu[1][2] = "0";
						b6.setForeground(Color.BLUE);
					}
					choosePlayer();
					if(WinningGame(bu)) {

						oCounter++;
						whosMove = 0;
						GameScore();
						JOptionPane.showMessageDialog(frame, "Player Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					}
					aiMove();
				}
			}
		});
		b6.setFont(new Font("Carlito", Font.BOLD, 50));
		panel_8.add(b6, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPlayerO = new JLabel("AI");
		lblPlayerO.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerO.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		panel_9.add(lblPlayerO, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		tCount0 = new JTextField();
		tCount0.setText("0");
		tCount0.setHorizontalAlignment(SwingConstants.CENTER);
		tCount0.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		panel_10.add(tCount0, BorderLayout.CENTER);
		tCount0.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
	
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bu[2][0] == null) {
					b7.setText(startGame);
					whosMove = 0;
					if (startGame.equalsIgnoreCase("X")) {
						bu[2][0] = "X";
						b7.setForeground(Color.RED);
					} else {
						bu[2][0] = "0";
						b7.setForeground(Color.BLUE);
					}
					choosePlayer();
					if(WinningGame(bu)) {

						oCounter++;
						whosMove = 0;
						GameScore();
						JOptionPane.showMessageDialog(frame, "Player Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
						
					}
					aiMove();
				}
			}
		});
		b7.setFont(new Font("Carlito", Font.BOLD, 50));
		panel_11.add(b7, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
	
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bu[2][1] == null) {
					b8.setText(startGame);
					whosMove = 0;
					if (startGame.equalsIgnoreCase("X")) {
						bu[2][1] = "X";
						b8.setForeground(Color.RED);
					} else {
						bu[2][1] = "0";
						b8.setForeground(Color.BLUE);
					}
					choosePlayer();
					if(WinningGame(bu)) {

						oCounter++;
						whosMove = 0;
						GameScore();
						JOptionPane.showMessageDialog(frame, "Player Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
						
					}
					aiMove();
				}
			}
		});
		b8.setFont(new Font("Carlito", Font.BOLD, 50));
		panel_12.add(b8, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		

		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bu[2][2] == null) {
					b9.setText(startGame);
					whosMove = 0;
					if (startGame.equalsIgnoreCase("X")) {
						bu[2][2] = "X";
						b9.setForeground(Color.RED);
					} else {
						bu[2][2] = "0";
						b9.setForeground(Color.BLUE);
					}
					choosePlayer();
					if(WinningGame(bu)) {

						oCounter++;
						whosMove = 0;
						GameScore();
						JOptionPane.showMessageDialog(frame, "Player Wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					}
					aiMove();
				}
			}
		});
		b9.setFont(new Font("Carlito", Font.BOLD, 50));
		panel_13.add(b9, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetMatrix();
			}
		});
		reset.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		panel_14.add(reset, BorderLayout.CENTER);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("EXIT");
				if (JOptionPane.showConfirmDialog(frame, "Confirm to exit", "Tic Tac Toe", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
				
			}
		});
		exit.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		panel_15.add(exit, BorderLayout.CENTER);
	}

	
	public int[] bestMove(String[][] someArr) {
		int r1,r2;
		r1 = 100;
		r2 = 100;
		int availableMoves[][] = availableMoves(someArr);
		String temp;
		String copyArr[][] = someArr;
		
		int[] bestMoves;

		bestMoves = new int[2];
		
		for (int i = 0; i < someArr.length; i++) {
			for (int j = 0; j < someArr[0].length; j++) {
				if (availableMoves[i][j] == 1) {
					temp = someArr[i][j];
					copyArr[i][j] = startGame;
					
					if (WinningGame(copyArr) == true) {
						bestMoves[0] = i;
						bestMoves[1] = j;
						return bestMoves;
					} else {
						copyArr[i][j] = temp;
						r1 = (int) (Math.random() * 3);
						r2 = (int) (Math.random() * 3);
						
						while (someArr[r1][r2] != null && checkFull() != true) {
							r1 = (int) (Math.random() * 3);
							r2 = (int) (Math.random() * 3);
						}
						
						bestMoves[0] = r1;
						bestMoves[1] = r2;
					}
					copyArr[i][j] = temp;
				}
			}
		}
		
		bestMoves[0] = r1;
		bestMoves[1] = r2;
		
		return bestMoves;
		
	}
	
	public int[][] availableMoves(String[][] Arr) {
		int availableMoves[][];
		availableMoves = new int[Arr.length][Arr[0].length];
		
		
		for (int i = 0; i < Arr.length; i++) {
			for (int j = 0; j < Arr[0].length; j++) {
				if(Arr[i][j] == null) {
					availableMoves[i][j] = 1;
				} else {
					availableMoves[i][j] = 0;
				}
				
			}
		}
		
		return availableMoves;
	}
	
	
}
