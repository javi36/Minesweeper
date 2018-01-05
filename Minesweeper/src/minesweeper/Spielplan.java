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
	 * Rüft kommando auf. 
	 * TODO: Fehlt der Algorithmus.
	 */
	private static void doSpielzug() throws IOException{
		user.kommando();
		
	}
	/*
	 * Überprüft ob der spielbeendet ist und
	 *  gibt entsprechend true oder false zurück.
	 */
	private static boolean isEnde(){
		if (user.spielEnde == true) {
			return true;
		}else{
			return false;
		}
	}
	/*
	 * Überprüft ob man das Spiel gewonnen hat. 
	 */
	private static void checkWin(){
		//TODO: überprüfung ob alle anderen Felder aufgedeckt sind und dann hat man gewonnen.
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