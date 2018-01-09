package minesweeper;

import java.util.Arrays;
import java.util.Random;

public class Zelle {

	public int anzBomben = 10;
	private int anzFlagen = 89;
	public int[] bombenPos;
	public int[] flagenPos;
	private int zufaelligePos;
	public String[][] spielfeld;
	public int spalte = 9;
	public int zeile = 9;
	/*
	 * Initialisiert die Arrays
	 */
	Zelle(){ 
		bombenPos = new int[anzBomben];
		setBombe();
		flagenPos = new int[anzFlagen];
		spielfeld = new String[spalte+1][zeile+1];
	}
	
	/*
	 * Setzt zufällig immer unterschiedliche 
	 * bomben Positionen zwischen 10 und 99
	 */
	public void setBombe(){
		Random zufallsZahl = new Random();
		for (int i = 0; i < anzBomben; i++) {
			zufaelligePos = zufallsZahl.nextInt(100);
			while (zufaelligePos < 10) {
				zufaelligePos = zufallsZahl.nextInt(100);
			}
			for (int bombe : bombenPos) {
				while (bombe == zufaelligePos){
					zufaelligePos = zufallsZahl.nextInt(100);
				}
			}
			bombenPos[i] = zufaelligePos;
		}
	}
	
	/*
	 * überprüft ob die Position schon gesetzt wurde
	 */
	public boolean checkGesetzt(int zeichenSpalte, int zeichenZeile){
		String leer = "-";
		for (int x = 0; x < zeile+1; x++) {
            for (int y = 1; y < spalte+1; y++) {
            	if (spielfeld[zeichenSpalte][zeichenZeile] != leer) {
            		System.out.println("Position schon gesetzt");
					return true;
				}     
            }
        }
		return false;
	}
	
	
		
		
	
}
