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
	private int markierenCounter = -1;
	
	/*
	 * gibt die Eingabe des Users zurück
	 */
	public String eingabeUser(){
		userEingabe = scan.nextLine();
		return userEingabe;
	}
	/*
	 * gibt die Spalte zurück
	 */
	public int getSpalte(){
		String[] pos = userEingabe.split("", 2);
		int spalte = Integer.parseInt(pos[0]);
		return spalte;
	}
	/*
	 * gibt die Zeile zurück
	 */
	public int getZeile(){
		String[] pos = userEingabe.split("", 2);
		int zeile = Integer.parseInt(pos[1]);
		return zeile;
	}
	/*
	 * lässt kommando auswählen mit unterschiedlichen Handlungen
	 */
	public String kommando() throws IOException{
		switch (userEingabe) { 
		case "M":
			System.out.print("Geben sie jetzt die gewünschte Position (10-99): ");
			userEingabe = scan.nextLine();
			markierenCounter++;
			markieren();
			break;

		case "T":
			System.out.print("Geben sie jetzt die gewünschte Position (10-99): ");
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
		System.out.println(Arrays.toString(bomben)); //kontrolle
		
		for (String bombe : bomben) {
			if (userEingabe.equals(bombe)) {
				System.out.println("VERLOREN");
				Spielplan.myGame.zeigeBomben();
				spielEnde = true;	
			}
		}
		if (spielEnde == false) {
			if (Spielplan.myGame.checkGesetzt(spalte, zeile) == false) {
				Spielplan.myGame.zeichne(spalte, zeile, "0");
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
			Spielplan.myGame.zellen.flagenPos[markierenCounter] = pos;//fügt die markiert Flage im flagenPos array.
			if (Spielplan.myGame.checkGesetzt(spalte, zeile) == false) {
				Spielplan.myGame.zeichne(spalte, zeile, "!");
			}	
		}
	}
}
