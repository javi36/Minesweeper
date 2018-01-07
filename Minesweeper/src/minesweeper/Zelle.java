package minesweeper;

import java.util.Random;

public class Zelle {

	public int anzBomben = 10;
	private int anzFlagen = 89;
	public int[] bombenPos;
	public int[] flagenPos;
	private int zufaelligePos;
	
	/*
	 * Initialisiert die Arrays
	 */
	Zelle(){ 
		bombenPos = new int[anzBomben];
		flagenPos = new int[anzFlagen];
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
}
