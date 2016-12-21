package ticTacToe;

public class WinningConditions {
	// Pruefe auf Unentschieden (wenn alle Felder voll sind)
	public static Boolean checkForDraw(String[] field) {
		// flag fuer unentschieden
		boolean draw = false;
		// Integer um zu ermitteln, wie viele Zellen voll sind
		int cellStatusCounter = 0;
		// gehe durch alle Zellen
		for (int cell = 0; cell < 9; cell++) {
			// Wenn die Zelle nicht leer ist, inkrementiere den counter
			if (field[cell] != " ")
				cellStatusCounter++;
			// wenn cellStatusCounter == 9 ist, muessen alle Zellen voll sein
			if (cellStatusCounter == 9)
				draw = true;
			else
				draw = false;
		}
		return draw;
	}

	public static String checkForWin(String[] field) {
		String winner = "";
		// Liefere winner zurück, falls dieser nicht leer ist
		winner = checkHorizontal(field, 0);
		if (winner != "") {
			return winner;
		}
		winner = checkHorizontal(field, 3);
		if (winner != "") {
			return winner;
		}
		winner = checkHorizontal(field, 6);
		if (winner != "") {
			return winner;
		}
		winner = checkVertical(field, 0);
		if (winner != "") {
			return winner;
		}
		winner = checkVertical(field, 1);
		if (winner != "") {
			return winner;
		}
		winner = checkVertical(field, 2);
		if (winner != "") {
			return winner;
		}
		winner = checkDiagonal(field);
		if (checkDiagonal(field) != "") {
			return winner;
		}
		// Ansonsten liefere winner zurueck
		return winner;
	}

	public static String checkHorizontal(String[] field, int offset) {
		String winner = "";
		String activeMarker = "";
		int markerCounter = 0;

		// merke den Wert der ersten Zelle der Zeile
		activeMarker = field[0 + offset];

		for (int cell = (0 + offset); cell < (3 + offset); cell++) {
			// wenn Aktuelle Zelle nicht leer ist
			if (field[cell] != " " && field[cell] != null) {
				// und dem gemerkten Wert entspricht
				if (activeMarker == field[cell]) {
					// zaehle markerCounter hoch
					markerCounter++;
				}
			}
		}
		// wenn das Zeichen 3 mal gesehen wurde, ist der Gewinner
		// gleich dem gemerkten Zeichen
		if (markerCounter == 3) {
			winner = activeMarker;
		}
		return winner;
	}

	public static String checkDiagonal(String[] field) {
		String winner = "";
		String activeMarker = "";
		int markerCounter = 0;

		activeMarker = field[0];

		// oben links nach unten rechts
		for (int cell = 0; cell < 9; cell += 4) {
			if (field[cell] != " " && field[cell] != null) {
				if (activeMarker == field[cell]) {
					markerCounter++;
				}
			}
		}
		// if marker was three times the same, player (=marker) has won
		if (markerCounter == 3) {
			winner = activeMarker;
			return winner;
		} else {
			// reset marker counter for 2nd for-loop (if first one detected no
			// win)
			markerCounter = 0;
		}

		// top right to left bottom
		// get marker from new position
		activeMarker = field[2];

		for (int cell = 2; cell < 7; cell += 2) {

			if (field[cell] != " " && field[cell] != null) {
				if (activeMarker == field[cell]) {
					markerCounter++;
				}
			}
		}
		if (markerCounter == 3) {
			winner = activeMarker;
		}
		return winner;
	}

	public static String checkVertical(String[] field, int offset) {
		String winner = "";
		String activeMarker = "";
		int markerCounter = 0;

		activeMarker = field[0 + offset];

		for (int cell = (0 + offset); cell < (7 + offset); cell += 3) {
			if (field[cell] != " " && field[cell] != null) {
				if (activeMarker == field[cell]) {
					markerCounter++;
				}
			}
		}

		// if marker was three times the same, player (=marker) has won
		if (markerCounter == 3) {
			winner = activeMarker;
		}
		return winner;
	}
}
