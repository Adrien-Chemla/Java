package Echecs;

import java.util.ArrayList;
import java.util.List;

public class Fou extends Piece {
	
	public static Fou BLANC = new Fou(Couleur.BLANC);
	public static Fou NOIR = new Fou(Couleur.NOIR);
	
	//récupération des données du constructeur
		public Fou (Couleur couleur) {
			super(couleur);
		}
		
		List<Coordonnees> deplacementsValides(Coordonnees origine) {
			//instance de liste
			final ArrayList<Coordonnees> result = new ArrayList<>();
                        
                        for (int i = 0; i<8; i++){
                            checkPosition(origine.getX() - i, origine.getY() - i, result);
                            checkPosition(origine.getX() - i, origine.getY() + i, result);
                            checkPosition(origine.getX() + i, origine.getY() - i, result);
                            checkPosition(origine.getX() + i, origine.getY() + i, result);
                        }
			
			return result;
		}
		private void checkPosition(int x, int y, List<Coordonnees> result) {
			if(isInside(x,y)) {
				result.add(new Coordonnees(x,y));
			}
		}
}