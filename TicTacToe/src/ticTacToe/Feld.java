package ticTacToe;

public class Feld {
	private String[] feld = new String[9];

	// Standardkonstruktor
	public Feld() {
	}

	// return current value of the array cell
	public String getFeld(int index) {
		return feld[index];
	}

	// return whole array
	public String[] getFeld() {
		return feld;
	}

	// write to array
	public void setFeld(String val, int index) {
		// only write if cell is empty OR cell is NULL
		try {
			if (getFeld(index) == " " || getFeld(index) == null) {
				this.feld[index] = val;
			} else {
				GameMain.switchCurrentPlayer();
			}
		} catch (Exception ex) {
			System.out.println("\nOh oh, ein Fehler ist aufgetreten! Fehler: " + ex.getMessage());
		}
	}

	// befuelle das spielfeld-array (zu testzwecken bzw. damit man ein
	// gefuelltes array ausgeben kann)
	public void fuelleInt() {
		for (int f = 0; f < 9; f++) {
			setFeld(String.valueOf(f + 1), f);
		}
	}

	public void fuelleEmpty() {
		for (int f = 0; f < 9; f++) {
			setFeld(" ", f);
		}
	}

	// Feld wird ausgegeben
	public void ausgeben() {
		System.out.println();
		for (int zelle = 0; zelle < 9; zelle++) {
			if (zelle % 3 == 0 && zelle != 0) {
				System.out.println();
				System.out.print("-----------");
				System.out.println();
				System.out.print(getFeld(zelle) + " | ");
			} else {
				System.out.print(getFeld(zelle) + " | ");
			}
		}
	}
}
