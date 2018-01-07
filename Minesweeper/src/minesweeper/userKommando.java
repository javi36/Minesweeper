package minesweeper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class userKommando {
	Scanner scan = new Scanner(System.in);
	private String userEingabe;
	public boolean spielEnde = false;
	private boolean isFlageGesetzt = false;
	private int spalte, zeile;
	public int markierenCounter = -1;
	
	/*
	 * gibt die Eingabe des Users zur�ck
	 */
	public String eingabeUser(){
		userEingabe = scan.nextLine();
		return userEingabe;
	}
	/*
	 * gibt die Spalte zur�ck
	 */
	public int getSpalte(){
		String[] pos = userEingabe.split("", 2);
		int spalte = Integer.parseInt(pos[0]);
		return spalte;
	}
	/*
	 * gibt die Zeile zur�ck
	 */
	public int getZeile(){
		String[] pos = userEingabe.split("", 2);
		int zeile = Integer.parseInt(pos[1]);
		return zeile;
	}
	/*
	 * l�sst kommando ausw�hlen mit unterschiedlichen Handlungen
	 */
	public String kommando() throws IOException{
		switch (userEingabe) { 
		case "M":
			System.out.print("Geben sie jetzt die gew�nschte Position (10-99): ");
			userEingabe = scan.nextLine();
			markierenCounter++;
			markieren();
			break;

		case "T":
			System.out.print("Geben sie jetzt die gew�nschte Position (10-99): ");
			userEingabe = scan.nextLine();
			aufdecken();
			break;
		}
		return userEingabe;
	}
	
	/*
	 * deckt eine Zelle auf.
	 */
	public void aufdecken(){
		spalte = getSpalte();
		zeile = getZeile();
		int[] bombenPos = Spielplan.myGame.zellen.bombenPos;
		String[] bomben = Arrays.toString(bombenPos).split("[\\[\\]]")[1].split(", ");//verwandelt der int array zu ein String array.
		System.out.println("Bomben Position: "+Arrays.toString(bomben)); //kontrolle
		
		for (String bombe : bomben) {
			if (userEingabe.equals(bombe)) {
				System.out.println("VERLOREN");
				Spielplan.myGame.zeigeBomben();
				spielEnde = true;	
			}
			
		}
		// TODO Beheben: Zeichnet 2 mal der Spielfeld wenn eine bombe in der n�he ist. 
		// TODO restlichen Algorithmus beenden.
		if (spielEnde == false) {
			if (Spielplan.myGame.checkGesetzt(spalte, zeile) == false) {
				Spielplan.myGame.zeichne(spalte, zeile, "0");
				int userEingabePos = Integer.parseInt(userEingabe);
				for (String bombe : bomben) {
					int bombePos = Integer.parseInt(bombe);
					if (userEingabePos+1 == bombePos || userEingabePos+10 == bombePos || 
							userEingabePos+9 == bombePos || userEingabePos+11 == bombePos ||
							userEingabePos-1 == bombePos || userEingabePos-10 == bombePos || 
							userEingabePos-9 == bombePos || userEingabePos-11 == bombePos ) {
						Spielplan.myGame.zeichne(spalte, zeile, "1");
					}else{
						//Spielplan.myGame.zeichne(spalte, zeile, "0");
					}
				}
				//Spielplan.myGame.zeichne(spalte, zeile, "0");
			}
		}
	}
	/*
	 * markiert eine Zelle
	 */
	public void markieren(){
		spalte = getSpalte();
		zeile = getZeile();
		int pos = spalte * 10 + zeile;
		
		int[] flagenPos = Spielplan.myGame.zellen.flagenPos;
		String[] flagen = Arrays.toString(flagenPos).split("[\\[\\]]")[1].split(", ");
		
		for (String flage : flagen) {
			if (userEingabe.equals(flage)) {
				System.out.println("Flage wurde schon gesetzt");
				isFlageGesetzt = true;
			}	
		}
		if (isFlageGesetzt == false) {
			Spielplan.myGame.zellen.flagenPos[markierenCounter] = pos;//f�gt die markiert Flage im flagenPos array.
			if (Spielplan.myGame.checkGesetzt(spalte, zeile) == false) {
				Spielplan.myGame.zeichne(spalte, zeile, "!");
			}	
		}
	}
}
