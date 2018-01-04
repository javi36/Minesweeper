package minesweeper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
     
public class Spielplan {
	static int runde = 10;
	static Spielfeld myGame = new Spielfeld();
	static Scanner scan = new Scanner(System.in);
	static String userEingabe;
	private boolean spielEnde;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub 

		myGame.makeSpielfeld();

		for (int i = 0; i < runde; i++) {
			userEingabe = eingabeUser();
		}

	}

	private void doSpielzug() {

	}
	private static String eingabeUser(){
		userEingabe = scan.nextLine();
		return userEingabe;
		
	}
	public void checkEnde() throws IOException {
		
	}
	
	public String kommando() throws IOException{
		
		switch (userEingabe) { 
		case "M":
			System.out.print("Geben sie jetzt die gewünschte Position (nur zahlen): ");
			markieren();
			break;

		case "T":
			System.out.print("Geben sie jetzt die gewünschte Position (nur zahlen): ");
			aufdecken();
			break;
		}
		return userEingabe;
	}
	
	public void aufdecken(){
		String[] pos = userEingabe.split("", 2);
		int zeile = Integer.parseInt(pos[0]);
		int spalte = Integer.parseInt(pos[1]);
	
		int[] bombenPos = myGame.zellen.bombePos;
		String[] bomben = Arrays.toString(bombenPos).split("[\\[\\]]")[1].split(", ");
		for (String bombe : bomben) {
			if (userEingabe.equals(bombe)) {
				System.out.println("VERLOREN");
				spielEnde = true;
			}
			
		}
		if (spielEnde = false) {
			myGame.zeichne(spalte, zeile, "+");
		}
		//System.out.println(Arrays.toString(bomben));

		
		
	}

	public void markieren(){
		String[] pos = userEingabe.split("", 2);
		int zeile = Integer.parseInt(pos[0]);
		int spalte = Integer.parseInt(pos[1]);
		
		int[] flagenPos = myGame.zellen.flagenPos;
		String[] flagen = Arrays.toString(flagenPos).split("[\\[\\]]")[1].split(", ");
		
		for (String flage : flagen) {
			if (userEingabe.equals(flage)) {
				System.out.println("Flage wurde shcon gesetzt");
			}
			
		}
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