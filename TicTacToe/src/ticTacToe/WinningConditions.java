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

	public static String checkForWin(String[] field) {
		String winner = "";
		winner = checkHorizontal(field, 0);
		if (winner != "") {
			return winner;// = checkHorizontal(field, 0);
		}
		winner = checkHorizontal(field, 3);
		if (winner != "") {
			return winner; //winner = checkHorizontal(field, 3);
		}
		winner = checkHorizontal(field, 6);
		if (winner != "") {
			return winner;// = checkHorizontal(field, 6);
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

		return winner;
	}

	public static String checkHorizontal(String[] field, int offset) {
		String winner = "";
		String activeMarker = "";
		int markerCounter = 0;

		if (field[0 + offset] != " ") {
			activeMarker = field[0 + offset];
		}

		for (int cell = (0 + offset); cell < (3 + offset); cell++) {
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

	/*
	 * check for diagonal win (use stepsize 3 in the for-loop) 2 for loops (1
	 * top left to right bottom & 1 top right to left bottom)
	 */
	public static String checkDiagonal(String[] field) {
		String winner = "";
		String activeMarker = "";
		int markerCounter = 0;

		if (field[0] != " ") {
			activeMarker = field[0];
		}

		// top left to right bottom
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
		}

		else {
			// reset marker counter for 2nd for-loop (if first one detected no
			// win)
			markerCounter = 0;
		}

		// top right to left bottom
		// get marker from new position
		if (field[2] != " ") {
			activeMarker = field[2];
		}

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

		if (field[0 + offset] != " ") {
			activeMarker = field[0 + offset];
		}

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
