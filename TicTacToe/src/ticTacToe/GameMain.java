package ticTacToe;

import java.util.Scanner;

public class GameMain {
	// Flag fuer aktiven Spieler
	private static Player currentPlayer = Player.X;
	static Feld eingabehilfe = new Feld();
	static Feld spielfeld = new Feld();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int modus = 0;
		boolean ki = false;
		String winner = "";

		// Objekt mit dem Namen 'eingabehilfe' wird erstellt (wird zur
		// Orientierung benutzt)
		// 'eingabehilfe' wird gefuellt und ausgegeben
		eingabehilfe.fuelleInt();
		eingabehilfe.ausgeben();
		System.out.println("\n");
		// Spielfeld wird mit " " gefuellt
		spielfeld.fuelleEmpty();

		System.out.println("Willkommen bei Tic Tac Toe! Viel Spass!");
		System.out.println("Waehlen sie die 1 um gegen einen Menschen zu spielen "
				+ "und waehlen sie eine 2 um gegen den Computer zu spielen.");

		while (modus == 0) {
			try {
				modus = sc.nextInt();
				if (modus == 1) {
					ki = false;
				} else if (modus == 2)
					ki = true;
			} catch (Exception ex) {
				System.out.println("\nUngueltige Eingabe, bitte geben Sie eine Zahl ein!");
				sc.next();
			}
		}

		// actual game
		do {
			spielfeld.ausgeben();
			// Check for draw
			if (WinningConditions.checkForDraw(spielfeld.getFeld())) {
				System.out.println("\nUnentschieden! Niemand gewinnt!");
				// exit game loop
				break;
			} else {
				if (!ki) {
					GameMain.eingabe();
				} else if (ki && currentPlayer == Player.X) {
					GameMain.eingabe();
				} else {
					spielfeld.setFeld(String.valueOf(currentPlayer), Computer.move(spielfeld.getFeld()));
					System.out.println();
				}
				// check for win
				winner = WinningConditions.checkForWin(spielfeld.getFeld());
				if (winner != "") {
					spielfeld.ausgeben();
					System.out.println("Spieler gewinnt " + winner);
					break;
				}
			}

			// SwitchPlayer
			switchCurrentPlayer();
		} while (true);
		// close scanner
		sc.close();
	}

	public static void eingabe() {
		System.out.print(
				"\nSpieler " + currentPlayer + " ist am Zug. Bitte gib die Zahl fuer "
						+ "das entsprechende Feld ein: ");
		try {
			// write selected cell
			spielfeld.setFeld(String.valueOf(currentPlayer), (sc.nextInt() - 1));

		} catch (Exception ex) {
			System.out.println("\nOh oh, ein Fehler ist aufgetreten! Fehler: " + ex.getMessage());
			switchCurrentPlayer();
			sc.next();
		}
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