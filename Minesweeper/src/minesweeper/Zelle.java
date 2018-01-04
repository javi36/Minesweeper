package minesweeper;

import java.util.Random;

public class Zelle {

	public boolean isBombe;
	public int anzBomben = 10;
	int[] bombePos = new int[anzBomben];
	int[] flagenPos = new int[0];
	int zufaelligePos;
	public boolean isFlage;
	public boolean isAufgedeckt;
	
	
	Zelle(){ 
		 
	}

	
	public void setBombe(){
	
		Random zufallsZahl = new Random();
		
		for (int i = 0; i < anzBomben; i++) {
			zufaelligePos = zufallsZahl.nextInt(101);
			if (zufaelligePos == 0) {
				zufaelligePos = zufaelligePos+1;
			}
			bombePos[i] = zufaelligePos;
			isBombe = true;
		}
	}
}