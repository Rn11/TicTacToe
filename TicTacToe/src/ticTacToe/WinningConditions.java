package ticTacToe;

public class WinningConditions {

	// Check for draw (if all fields are set)
	public static Boolean checkForDraw(String[] field) {
		// flag for draw
		boolean draw = false;
		// integer to count how many cells are written
		int cellStatusCounter = 0;

		// go through all cells
		for (int cell = 0; cell < 9; cell++) {

			// if current cell is not empty, increment counter by 1
			if (field[cell] != " ") {
				cellStatusCounter++;
			}
			// if counter is 9, all fields are full so the game is draw
			if (cellStatusCounter == 9) {
				draw = true;
			} else {
				draw = false;
			}
		}
		return draw;
	}

	public static String checkForWin(String _winner) {

		String winner = "";
		return winner;
	}

	public static String checkHorizontal(String[] field, int offset) {
		String winner = "";
		String activeMarker = "";
		int markerCounter = 0;

		activeMarker = field[0 + offset];

		for (int cell = 0; cell < 3; cell++) {

			if ((field[cell] != " " && field[cell] != null) && (field[cell] == "X" || field[cell] == "O")
					&& activeMarker != " ") {
				if ((cell + offset) != (3 + offset) && activeMarker == field[cell]) {
					activeMarker = field[cell];
					markerCounter++;
				}
			}
		}
		if (markerCounter == 3) {
			winner = activeMarker;
		}

		return winner;
	}

	/*
	 * check for diagonal win (use stepsize 4 in the for-loop) 2 for loops (1
	 * top left to right bottom & 1 top right to left bottom)
	 */
	public static String checkDiagonal(String[] field) {
		String winner = "";
		String activeMarker = "";
		int markerCounter = 0;

		activeMarker = field[0];

		// top left to right bottom
		for (int cell = 0; cell < 9; cell += 2) {

			if ((field[cell] != " " && field[cell] != null) && (field[cell] == "X" || field[cell] == "O")
					&& activeMarker != " ") {
				if (activeMarker == field[cell]) {
					activeMarker = field[cell];
					markerCounter++;
				}
			}
		}

		// if marker was three times the same, player (=marker) has won
		if (markerCounter == 3) {
			winner = activeMarker;
		}

		else {
			// reset marker counter for 2nd for-loop (if first one detected no
			// win)
			markerCounter = 0;
		}

		// top right to left bottom
		// get marker from new position
		activeMarker = field[2];
		for (int cell = 2; cell < 7; cell += 2) {

			if ((field[cell] != " " && field[cell] != null) && (field[cell] == "X" || field[cell] == "O")
					&& activeMarker != " ") {
				if (activeMarker == field[cell]) {
					activeMarker = field[cell];
					markerCounter++;
				}
			}
		}

		if (markerCounter == 3) {
			winner = activeMarker;
		}

		return winner;
	}
}
