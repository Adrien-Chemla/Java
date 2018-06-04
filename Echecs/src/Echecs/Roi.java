package Echecs;

import java.util.ArrayList;
import java.util.List;

public class Roi extends Piece {
	
	public static Roi BLANC = new Roi(Couleur.BLANC);
	public static Roi NOIR = new Roi(Couleur.NOIR);
	
	//récupération des données du constructeur
		public Roi (Couleur couleur) {
			super(couleur);
		}
		
		List<Coordonnees> deplacementsValides(Coordonnees origine) {
			//instance de liste
			final ArrayList<Coordonnees> result = new ArrayList<>();
			
			checkPosition(origine.getX() - 1, origine.getY() - 1, result);
			checkPosition(origine.getX() - 1, origine.getY()    , result);
			checkPosition(origine.getX() - 1, origine.getY() + 1, result);
			checkPosition(origine.getX()    , origine.getY() - 1, result);
			checkPosition(origine.getX()    , origine.getY() + 1, result);
			checkPosition(origine.getX() + 1, origine.getY() - 1, result);
			checkPosition(origine.getX() + 1, origine.getY()    , result);
			checkPosition(origine.getX() + 1, origine.getY() + 1, result);
			
			return result;
		}
		private void checkPosition(int x, int y, List<Coordonnees> result) {
			if(isInside(x,y)) {
				result.add(new Coordonnees(x,y));
			}
		}
}