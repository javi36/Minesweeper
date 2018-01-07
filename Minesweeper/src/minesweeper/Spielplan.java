package minesweeper;

import java.io.IOException;
import java.util.Arrays;
     
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
			if (isEnde() == true) {
				break;
			}
			checkWin();
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
		//TODO: diese methode manuell testen!
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
	
	public static String bombenNaehe(){
		int spalte = user.getSpalte();
		int zeile = user.getZeile();
		int[] bombenPos = myGame.zellen.bombenPos;
		String[] bomben = Arrays.toString(bombenPos).split("[\\[\\]]")[1].split(", ");//verwandelt der int array zu ein String array.
		
			if (Spielplan.myGame.checkGesetzt(spalte, zeile) == false) {
				int userEingabePos = Integer.parseInt(user.userEingabe);
				int anzBombeNaeheCounter = 0;
				for (String bombe : bomben) {
					int bombePos = Integer.parseInt(bombe);
					if (userEingabePos+1 == bombePos){
						anzBombeNaeheCounter++;
					}else if(userEingabePos+10 == bombePos) {
						anzBombeNaeheCounter++;
					}else if(userEingabePos+9 == bombePos ) {
						anzBombeNaeheCounter++;
					}else if(userEingabePos+11 == bombePos ) {
						anzBombeNaeheCounter++;
					}else if(userEingabePos-1 == bombePos ) {
						anzBombeNaeheCounter++;
					}else if(userEingabePos-10 == bombePos ) {
						anzBombeNaeheCounter++;
					}else if(userEingabePos-9 == bombePos) {
						anzBombeNaeheCounter++;
					}else if(userEingabePos-11 == bombePos) {
						anzBombeNaeheCounter++;
					}
				}
				if (anzBombeNaeheCounter != 0) {
					return Integer.toString(anzBombeNaeheCounter);
				}else{
					return Integer.toString(anzBombeNaeheCounter);
				}
			}
			return null;
		
	}
	
	/*
	 * �berpr�ft ob die gegebene Position ein 0 hat und �ffnet alle 0 wo in der n�he sind.
	 * TODO alle nachbar Zellen wo keine bombe in der n�he haben �ffnen.
	 */
	public void alleNachbarOeffnen(int zeichenSpalte, int zeichenZeile){
		for (int x = 0; x < myGame.zeile+1; x++) {
            for (int y = 1; y < myGame.spalte+1; y++) {
            	if (myGame.spielfeld[zeichenSpalte][zeichenZeile] == "0") {
            		if (bombenNaehe().equals("0")) {
            								}
            	}
            }
		}
	}
}