package ticTacToe;
import java.util.*;

public class Computer {
	public static int move(String[] spielfeld) {
		Random rn = new Random();
		ArrayList<Integer> freieFelder = new ArrayList<Integer>();
		//Durchlaufe alle Felder des Spielfelds
		for (int i = 0; i < spielfeld.length; i++) {
			//wenn Spielfeld an Position 'i' frei ist
			if (spielfeld[i] == " ") {
				//füge den Wert vom aktuellen Index an die ArrayList
				freieFelder.add(i);
			}
		}
		//Gebe einen zufällig gewählten Wert aus der ArrayList zurück
		//hierfür wird eine Zufallszahl zwischen 0 und der Größe der ArrayList als Index ermittelt
		return freieFelder.get(rn.nextInt(freieFelder.size()));
	}
}