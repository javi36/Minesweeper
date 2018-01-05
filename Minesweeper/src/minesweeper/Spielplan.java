package minesweeper;

import java.io.IOException;
     
public class Spielplan {
	static int runde = 10;
	static Spielfeld myGame;
	static userKommando user = new userKommando();
	private static String userEingabe;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub 
		
		myGame = new Spielfeld();
		for (int i = 0; i < runde; i++) {
			userEingabe = user.eingabeUser();
			doSpielzug();
		}

	}

	private static void doSpielzug() throws IOException{
		user.kommando();
		
	}
	
	public void checkEnde(){
		
	}
	
	
	
	
}

/*
String userEingabe = spieler.kommando(myGame);
		int[] bombenPos = myGame.zellen.bombePos;
		String[] bomben = Arrays.toString(bombenPos).split("[\\[\\]]")[1].split(", ");
		System.out.println(Arrays.toString(bomben));

		for (String bombe : bomben) {
			if (userEingabe.equals(bombe)) {
				System.out.println("VERLOREN");
				myGame.setzeBombe(userEingabe);
			}
		}

*/