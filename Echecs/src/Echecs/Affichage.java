package Echecs;

import java.util.Scanner;

public class Affichage {

		public static void main (String[] args) {
			final Echiquier echiquier = new Echiquier();
			while(true) {
			
				//affichage des pieces et leurs types
				System.out.println("   1  2  3  4  5  6  7  8  ");
				System.out.println(" +-----------------------+");
				for (int y = 0; y < 8; y++) {
				
					String line = (y+1) + "|";
				
					for (int x = 0; x < 8; x++) {
						final Piece piece = echiquier.getPieceEn(new Coordonnees(x,y));
						String representation = (piece == null) ? "--" : asString(piece);
						line = line + " " + representation;
					}
				
					System.out.println(line);
				}
			
				Scanner sc = new Scanner(System.in);
			
				System.out.println("\nSélectionnez l'emplacement de la pièce à deplacer (colonne puis ligne) : ");
                                int abscisseOri = sc.nextInt() - 1;
				int ordonneeOri = sc.nextInt() - 1;
			
				System.out.println("Où voulez-vous la déplacer ? (colonne puis ligne) : ");
				int abscisseDesti = sc.nextInt() - 1;
				int ordonneeDesti = sc.nextInt() - 1;
				
			
				Coordonnees coordOri = new Coordonnees(abscisseOri,ordonneeOri);
				Coordonnees coordDesti = new Coordonnees(abscisseDesti,ordonneeDesti);
			
				echiquier.moveTo(coordOri,coordDesti);
			}
		}
		
		private static String asString(Piece piece) {
			String p;
			String c = asString(piece.getCouleur());
			
			//gestion des instances de pieces
			if (piece instanceof Pion) {
				p = "P";
			} else if (piece instanceof Roi) {
				p = "K";
			} else if(piece instanceof Tour) {
				p = "T";
			} else if(piece instanceof Reine) {
				p = "Q";
			} else if(piece instanceof Cavalier) {
				p = "C";
			} else if(piece instanceof Fou) {
				p = "F";
			} else {
				return null;
			}
			return p + c;
		}
		
		//gestion des couleurs des instances de pieces
		private static String asString(Couleur couleur) {
			return couleur == Couleur.BLANC ? "b" : "n";
		}
}
