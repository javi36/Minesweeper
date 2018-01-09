package minesweeper;

import java.util.Arrays;

public class Spielfeld {
	Zelle zellen = new Zelle();
	private String leer = "-";

	/*
	 * Initialisiert die Matrix (Spielfeld)
	 */
	Spielfeld(){
		
		makeSpielfeld();
	}
	/*
	 * Erstellt die erste Matrix
	 */
	public void makeSpielfeld() {
		System.out.print("\t \t MINESWEEPER!");
		System.out.println();
		System.out.println("\n Legende: ");
		System.out.print("\t \n * = Bombe \n ! = Flage \n - = leer \n T = aufdecken \n M = markieren");
		
		System.out.print("\n          ");
		for (int i = 1; i < zellen.spalte+1; i++) {
			System.out.print("  "+i + " ");
		//System.out.println("\n            1   2   3   4   5   6   7   8   9");
		}
		System.out.println();
		for (int x = 0; x < zellen.zeile+1; x++) {
            System.out.print("       "+x + " ");
            
            for (int y = 1; y < zellen.spalte+1; y++) {
            	zellen.spielfeld[y][x] = leer;
                    System.out.print("   "+ zellen.spielfeld[y][x]);
            }
                
            System.out.println();
        }
		System.out.println();//lücke
		System.out.println("Geben Sie ein Kommando ein: ");	
	}
	
	/*
	 * Erstellt die weitere Spielfelder mit 
	 * der richtige position der aufgedeckten Felder/Bomben/Flagen.
	 */
	public void updateSpielfeld(int zeichenSpalte, int zeichenZeile, String zeichen){
		System.out.print("\t \t MINESWEEPER!");
		System.out.println();
		System.out.print("\n          ");
		for (int i = 1; i < zellen.spalte+1; i++) {
			System.out.print("  "+i + " ");
		}
		System.out.println();
		for (int x = 0; x < zellen.zeile+1; x++) {
            System.out.print("       "+x + " ");
            
            for (int y = 1; y < zellen.spalte+1; y++) {
            	zellen.spielfeld[zeichenSpalte][zeichenZeile] = zeichen;
                 System.out.print("   "+ zellen.spielfeld[y][x]);
            }
                
            System.out.println();
        }
		System.out.println("Geben Sie ein Kommando ein: ");	
	}
	
	
	/*
	 * überprüft ob alle Zellen gesetzt sind. (d.H kein - vorhanden).
	 */
	public boolean checkAlleGesetzt(){
		int anzZellen = zellen.zeile+1 * zellen.spalte;
		int gesetzteZellenCounter = 0;
		for (int x = 0; x < zellen.zeile+1; x++) {
            for (int y = 1; y < zellen.spalte+1; y++) {
            	if (zellen.spielfeld[y][x] != leer) {
            		gesetzteZellenCounter++;
            	}
            }
		}
		if (gesetzteZellenCounter == anzZellen) {
			return true;
		}else{
			return false;
		}
		
	}
	/*
	 * zeigt alle Bomben an
	 */
	public void zeigeBomben(){
		System.out.print("\t \t MINESWEEPER!");
		System.out.println();
		System.out.print("\n          ");
		for (int i = 1; i < zellen.spalte+1; i++) {
			System.out.print("  "+i + " ");
		}
		System.out.println();
		for (int x = 0; x < zellen.zeile+1; x++) {
            System.out.print("       "+x + " ");
            
            for (int y = 1; y < zellen.spalte+1; y++) {
            	for (int bombe : zellen.bombenPos) {
					String bombePos = Integer.toString(bombe);
					String[] pos = bombePos.split("", 2);
					int spalte = Integer.parseInt(pos[0]);
					int zeile = Integer.parseInt(pos[1]);
					zellen.spielfeld[spalte][zeile] = "*";
				}
            	System.out.print("   "+ zellen.spielfeld[y][x]);    
            }     
            System.out.println();
        }
	}
	
	public String bombenNaehe(){
		int spalte = Spielplan.user.getSpalte();
		int zeile = Spielplan.user.getZeile();
		int[] bombenPos = zellen.bombenPos;
		String[] bomben = Arrays.toString(bombenPos).split("[\\[\\]]")[1].split(", ");//verwandelt der int array zu ein String array.
		
			if (zellen.checkGesetzt(spalte, zeile) == false) {
				int userEingabePos = Integer.parseInt(Spielplan.user.userEingabe);
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
			return "0";
	}
}
