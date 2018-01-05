package minesweeper;

import java.io.IOException;
     
public class Spielplan {
	
	static Spielfeld myGame;
	static userKommando user = new userKommando();
	private static String userEingabe;
	private static boolean spielLaueft = true;
	
	/*
	 * Erstellt ein neuen Spielfeld und startet das Spiel.
	 */
	public static void main(String[] args) throws IOException {
		myGame = new Spielfeld();
		while(spielLaueft == true){
			checkWin();
			if (isEnde() == true) {
				break;
			}
			userEingabe = user.eingabeUser();
			doSpielzug();	
		}

	}
	/*
	 * R�ft kommando auf. 
	 * TODO: Fehlt der Algorithmus.
	 */
	private static void doSpielzug() throws IOException{
		user.kommando();
		
	}
	/*
	 * �berpr�ft ob der spielbeendet ist und
	 *  gibt entsprechend true oder false zur�ck.
	 */
	private static boolean isEnde(){
		if (user.spielEnde == true) {
			return true;
		}else{
			return false;
		}
	}
	/*
	 * �berpr�ft ob man das Spiel gewonnen hat. 
	 */
	private static void checkWin(){
		//TODO: �berpr�fung ob alle anderen Felder aufgedeckt sind und dann hat man gewonnen.
		int bombenCounter = 0;
		int[] bombenPos = myGame.zellen.bombenPos;
		int[] flagenPos = myGame.zellen.flagenPos;
		for (int flagePos : flagenPos) {
			for (int bombePos : bombenPos) {
				if (flagePos == bombePos) {
					bombenCounter++;
					user.spielEnde = true;
				}
			}
		}
		if (bombenCounter == myGame.zellen.anzBomben) {
			user.spielEnde = true;
			System.out.println("GEWONNEN!!!");
		}else{
			user.spielEnde = false;
		}
			
	}	
}