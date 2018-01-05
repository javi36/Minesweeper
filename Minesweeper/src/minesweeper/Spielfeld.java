package minesweeper;

public class Spielfeld {

	Zelle zellen = new Zelle();
	private String[][] boardgame;
	public int spalte = 9;
	public int zeile = 9;
	public int anzBomben;
	 
	Spielfeld(){
		boardgame = new String[spalte+1][zeile+1];
		makeSpielfeld();
		
	}
	
	
	
	public void makeSpielfeld() {
		System.out.println("\n Legende: ");
		System.out.print("\t \n * = Bombe \n + = Flage \n - = leer");
		
		System.out.print("\n          ");
		for (int i = 1; i < spalte+1; i++) {
			System.out.print("  "+i + " ");
		//System.out.println("\n            1   2   3   4   5   6   7   8   9");
		}
		System.out.println();
		for (int i = 0; i < zeile+1; i++) {
            System.out.print("       "+i + " ");
            
            for (int a = 1; a < spalte+1; a++) {
            	 boardgame[a][i] = "-";
                    System.out.print("   "+ boardgame[a][i]);
            }
                
            System.out.println();
        }
		System.out.println();//lücke
		
		System.out.println("Geben Sie ein Kommando ein: ");	
		zellen.setBombe();
	}
	
	public void zeichne(int zeichenSpalte, int zeichenZeile, String zeichen){
		System.out.print("\n          ");
		for (int i = 1; i < this.spalte+1; i++) {
			System.out.print("  "+i + " ");
		}
		System.out.println();
		for (int i = 0; i < this.zeile+1; i++) {
            System.out.print("       "+i + " ");
            
            for (int a = 1; a < this.spalte+1; a++) {
            	 boardgame[zeichenSpalte][zeichenZeile] = zeichen;
                 System.out.print("   "+ boardgame[a][i]);
            }
                
            System.out.println();
        }
		
		System.out.println();//lücke
		System.out.println("\t Legende: ");
		System.out.println("\t \n * = Bombe \n + = Flage");
	}
	
}
/*
 * for (int i = 1; i < spalte+1; i++) {
			if (i == 0){ 
				System.out.print(i+" ");
			}
			else System.out.print(" "+i+" ");
		}
		for (int i = 0; i < zeile+1; i++) {
			if (i == 0) {
				System.out.println("");
			}
			System.out.println(i);
		}
		System.out.println("Geben Sie ein Kommando ein: ");	
		zellen.setBombe();
 */


/*
 for (int i = 1; i < this.spalte+1; i++) {
			if (i == 0){
				System.out.print(i+" ");
			}
			else System.out.print(" "+i+" ");
		}
		for (int i = 0; i < this.zeile+1; i++) {
			if (i == 0) {
				System.out.println("");
			}
			System.out.println(i);
			if (i == zeile) {
				System.out.println("/t"+spalte+zeichen);
			}
		}
	
 * 
 * 
 */
		
