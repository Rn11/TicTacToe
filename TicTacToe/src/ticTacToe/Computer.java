package ticTacToe;

import java.util.*;

public class Computer {
	public static int move(String[] spielfeld) {
		Random rn = new Random();
		ArrayList<Integer> freieFelder = new ArrayList<Integer>();
		for (int i = 0; i < spielfeld.length; i++) {

			if (spielfeld[i] == " ") {
				freieFelder.add(i);
			}
		}
		return freieFelder.get(rn.nextInt(freieFelder.size()));
	}
}
