package ticTacToe;

import java.util.Scanner;

public class GameMain {
	// Flag for active player
	private static Player currentPlayer = Player.X;


	public static void main(String[] args) {

		String winner = "";
		Scanner sc = new Scanner(System.in);
		// Objekt mit dem Namen 'eingabehilfe' wird erstellt (wird nur als
		// Eingabehilfe benutzt)
		Feld eingabehilfe = new Feld();
		// 'eingabehilfe' is filled and printed
		eingabehilfe.fuelleInt();
		eingabehilfe.ausgeben();
		System.out.println("\n\n");
		
		
		Feld spielfeld = new Feld();
		spielfeld.fuelleEmpty();

		System.out.println("Willkommen bei Tic Tac Toe! Viel Spaß!");
		// actual game
		do {
			spielfeld.ausgeben();
			// Check for draw
			if (WinningConditions.checkForDraw(spielfeld.getFeld())) {
				System.out.println("\nUnentschieden! Niemand gewinnt!");
				// exit game loop
				break;
			} else {
				System.out.print("\nSpieler " + currentPlayer
						+ " ist am Zug. Bitte gib die Zahl für das entsprechende Feld ein: ");

				try {
					// write selected cell
					spielfeld.setFeld(String.valueOf(currentPlayer), (sc.nextInt() - 1));

				} catch (Exception ex) {
					System.out.println("\nOh oh, ein Fehler ist aufgetreten! Fehler: " + ex.getMessage());
					switchCurrentPlayer();
					sc.next();
				}
				
				//check for win 
				 winner = WinningConditions.checkHorizontal(spielfeld.getFeld(), 0);
				if (winner != ""){
				System.out.println("Spieler gewinnt " + winner); 
				break;
				};
			}
			// SwitchPlayer
			switchCurrentPlayer();
		} while (true);
		// close scanner
		sc.close();
	}

	public static Player getCurrentPlayer() {
		return currentPlayer;
	}

	public static void switchCurrentPlayer() {
		if (currentPlayer == Player.X) {
			currentPlayer = Player.O;
		} else if (currentPlayer == Player.O) {
			currentPlayer = Player.X;
		}
	}
}