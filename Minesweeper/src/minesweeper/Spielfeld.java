package minesweeper;

public class Spielfeld {

	Zelle zellen = new Zelle();
	public int spalte = 10;
	public int zeile = 9;
	public int anzBomben;

	 /*hahaha*/
	public void makeSpielfeld() {
		for (int i = 1; i < spalte+1; i++) {
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
	}
	
	public void zeichne(int spalte, int zeile, String zeichen){
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
	}
	
	
	
	
}



/*String[] pos = eingabe.split("", 2);
		int spalte = Integer.parseInt(pos[0]);
		int zeile = Integer.parseInt(pos[1]);
		
		for (int i = 0; i < this.zeile+1; i++) {
			System.out.print(" "+i+" ");
			
		}
		for (int i = 0; i < this.spalte+1; i++) {
			if (i == 0) {
				System.out.println(" ");
			}
			System.out.println(i);
			if (spalte == i ) {
				System.out.print(" * ");
			}
		}
		
		/*for (String string : pos) {
			System.out.println(string);
		}*/
		
