package Echecs;

import java.util.ArrayList;
import java.util.List;

public class Cavalier extends Piece {
	
	public static Cavalier BLANC = new Cavalier(Couleur.BLANC);
	public static Cavalier NOIR = new Cavalier(Couleur.NOIR);
	
	//récupération des données du constructeur
		public Cavalier (Couleur couleur) {
			super(couleur);
		}
		
/*  
				- y
				-
				-
				-
	 x		  " - " 
	 - - - - - - + + + + + +
			  " + "
				+
				+
				+
				+
*/
		
		
		
		List<Coordonnees> deplacementsValides(Coordonnees origine) {
			//instance de liste
			final ArrayList<Coordonnees> result = new ArrayList<>();
			
			checkPosition(origine.getX() - 2, origine.getY() - 1, result); /* x2 gauche + x1 haut */
			checkPosition(origine.getX() - 2, origine.getY() + 1, result); /* x2 gauche + x1 bas */
			checkPosition(origine.getX() - 1, origine.getY() - 2, result); /* x1 gauche + x2 haut */
			checkPosition(origine.getX() + 1, origine.getY() - 2, result); /* x1 droite + x2 haut */
			checkPosition(origine.getX() + 2, origine.getY() - 1, result); /* x2 droite + x1 haut */
			checkPosition(origine.getX() + 2, origine.getY() + 1, result); /* x2 droite + x1 bas */
			checkPosition(origine.getX() - 1, origine.getY() + 2, result); /* x1 gauche + x2 bas */
			checkPosition(origine.getX() + 1, origine.getY() + 2, result); /* x1 droite + x2 bas */
			
			return result;
		}
		private void checkPosition(int x, int y, List<Coordonnees> result) {
			if(isInside(x,y)) {
				result.add(new Coordonnees(x,y));
			}
		}
}