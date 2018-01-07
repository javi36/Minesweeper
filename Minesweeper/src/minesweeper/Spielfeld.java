package minesweeper;

public class Spielfeld {

	Zelle zellen = new Zelle();
	public String[][] spielfeld;
	public int spalte = 9;
	public int zeile = 9;
	private String leer = "-";
	
	/*
	 * Initialisiert die Matrix (Spielfeld)
	 */
	Spielfeld(){
		spielfeld = new String[spalte+1][zeile+1];
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
		for (int i = 1; i < spalte+1; i++) {
			System.out.print("  "+i + " ");
		//System.out.println("\n            1   2   3   4   5   6   7   8   9");
		}
		System.out.println();
		for (int x = 0; x < zeile+1; x++) {
            System.out.print("       "+x + " ");
            
            for (int y = 1; y < spalte+1; y++) {
            	spielfeld[y][x] = leer;
                    System.out.print("   "+ spielfeld[y][x]);
            }
                
            System.out.println();
        }
		System.out.println();//lücke
		System.out.println("Geben Sie ein Kommando ein: ");	
		zellen.setBombe();
	}
	
	/*
	 * Erstellt die weitere Spielfelder mit 
	 * der richtige position der aufgedeckten Felder/Bomben/Flagen.
	 */
	public void zeichne(int zeichenSpalte, int zeichenZeile, String zeichen){
		System.out.print("\t \t MINESWEEPER!");
		System.out.println();
		System.out.print("\n          ");
		for (int i = 1; i < this.spalte+1; i++) {
			System.out.print("  "+i + " ");
		}
		System.out.println();
		for (int x = 0; x < this.zeile+1; x++) {
            System.out.print("       "+x + " ");
            
            for (int y = 1; y < this.spalte+1; y++) {
            	spielfeld[zeichenSpalte][zeichenZeile] = zeichen;
                 System.out.print("   "+ spielfeld[y][x]);
            }
                
            System.out.println();
            
        }
		System.out.println("Geben Sie ein Kommando ein: ");	
	}
	/*
	 * überprüft ob die Position schon gesetzt wurde
	 */
	public boolean checkGesetzt(int zeichenSpalte, int zeichenZeile){
		for (int x = 0; x < this.zeile+1; x++) {
            for (int y = 1; y < this.spalte+1; y++) {
            	if (spielfeld[zeichenSpalte][zeichenZeile] != leer) {
            		System.out.println("Position schon gesetzt");
            		System.out.println("Geben Sie ein Kommando ein: ");	
					return true;
				}     
            }
        }
		return false;
	}
	
	/*
	 * überprüft ob alle Zellen gesetzt sind. (d.H kein - vorhanden).
	 */
	public boolean checkAlleGesetzt(){
		int anzZellen = zeile+1 * spalte;
		int gesetzteZellenCounter = 0;
		for (int x = 0; x < this.zeile+1; x++) {
            for (int y = 1; y < this.spalte+1; y++) {
            	if (spielfeld[y][x] != leer) {
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
		for (int i = 1; i < this.spalte+1; i++) {
			System.out.print("  "+i + " ");
		}
		System.out.println();
		for (int x = 0; x < this.zeile+1; x++) {
            System.out.print("       "+x + " ");
            
            for (int y = 1; y < this.spalte+1; y++) {
            	for (int bombe : zellen.bombenPos) {
					String bombePos = Integer.toString(bombe);
					String[] pos = bombePos.split("", 2);
					int spalte = Integer.parseInt(pos[0]);
					int zeile = Integer.parseInt(pos[1]);
					spielfeld[spalte][zeile] = "*";
				}
            	System.out.print("   "+ spielfeld[y][x]);    
            }     
            System.out.println();
        }
	}
	
}
