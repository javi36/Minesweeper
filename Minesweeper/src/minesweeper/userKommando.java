package minesweeper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class userKommando {
	Scanner scan = new Scanner(System.in);
	String userEingabe;
	private boolean spielEnde = false;
	private boolean isFlageGesetzt = false;
	
	public String eingabeUser(){
		userEingabe = scan.nextLine();
		return userEingabe;
	}
	
public String kommando() throws IOException{
	
	
		switch (userEingabe) { 
		case "M":
			System.out.print("Geben sie jetzt die gewünschte Position (nur zahlen): ");
			userEingabe = scan.nextLine();
			markieren();
			break;

		case "T":
			System.out.print("Geben sie jetzt die gewünschte Position (nur zahlen): ");
			userEingabe = scan.nextLine();
			aufdecken();
			break;
		}
		return userEingabe;
	}
	
	public void aufdecken(){
		String[] pos = userEingabe.split("", 2);
		int spalte = Integer.parseInt(pos[0]);
		int zeile = Integer.parseInt(pos[1]);
	
		int[] bombenPos = Spielplan.myGame.zellen.bombePos;
		String[] bomben = Arrays.toString(bombenPos).split("[\\[\\]]")[1].split(", ");
		System.out.println(Arrays.toString(bomben)); //kontrolle
		
		for (String bombe : bomben) {
			if (userEingabe.equals(bombe)) {
				System.out.println("VERLOREN");
				Spielplan.myGame.zeichne(spalte, zeile, "*");
				spielEnde = true;
			}
			
		}
		if (spielEnde == false) {
			Spielplan.myGame.zeichne(spalte, zeile, "0");
			
		}
		//System.out.println(Arrays.toString(bomben));

		
		
	}

	public void markieren(){
		String[] pos = userEingabe.split("", 2);
		int spalte = Integer.parseInt(pos[0]);
		int zeile = Integer.parseInt(pos[1]);
		
		int[] flagenPos = Spielplan.myGame.zellen.flagenPos;
		String[] flagen = Arrays.toString(flagenPos).split("[\\[\\]]")[1].split(", ");
		
		for (String flage : flagen) {
			if (userEingabe.equals(flage)) {
				System.out.println("Flage wurde schon gesetzt");
				isFlageGesetzt = true;
			}	
		}
		
		if (isFlageGesetzt == false) {
			Spielplan.myGame.zeichne(spalte, zeile, "+");
		}
	}
}
