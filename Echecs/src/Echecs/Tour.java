package Echecs;

import java.util.ArrayList;
import java.util.List;

public class Tour extends Piece {
	
	public static Tour BLANC = new Tour(Couleur.BLANC);
	public static Tour NOIR = new Tour(Couleur.NOIR);
	
	//récupération des données du constructeur
		public Tour (Couleur couleur) {
			super(couleur);
		}
		
		List<Coordonnees> deplacementsValides(Coordonnees origine) {
			//instance de liste
			final ArrayList<Coordonnees> result = new ArrayList<>();
			for(int n = 0; n < 8; n++) {
			
				checkPosition(origine.getX() + n, origine.getY()    , result);
				checkPosition(origine.getX() - n, origine.getY()    , result);
				checkPosition(origine.getX()    , origine.getY() - n, result);
				checkPosition(origine.getX()    , origine.getY() + n, result);
			
			}
			return result;
		}
		private void checkPosition(int x, int y, List<Coordonnees> result) {
			if(isInside(x,y)) {
				result.add(new Coordonnees(x,y));
			}
		}
}