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
	 * �berpr�ft ob alle anderen Felder aufgedeckt sind und die bomben markiert sind.
	 */
	private static void checkWin(){
		//TODO: 
		int anzMarkiertenBomben = 0;
		int anzFlagen = user.markierenCounter+1;
		int anzBomben = myGame.zellen.anzBomben;
		int[] bombenPos = myGame.zellen.bombenPos;
		int[] flagenPos = myGame.zellen.flagenPos;
		
		for (int bombePos : bombenPos) {
			for (int flagePos : flagenPos) {
				if (flagePos == bombePos) {
					anzMarkiertenBomben++;
					user.spielEnde = true;
				}
			}
		}
		if (anzMarkiertenBomben == anzBomben && 
				anzFlagen == anzBomben && 
				myGame.checkAlleGesetzt() == true) {
			user.spielEnde = true;
			System.out.println("GEWONNEN!!!");
		}else{
			user.spielEnde = false;
		}
			
	}	
}