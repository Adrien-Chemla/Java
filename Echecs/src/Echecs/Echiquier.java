package Echecs;

import java.util.List;

public class Echiquier {
	
	//création de l'échiquier sous forme de tableau
	private Piece[][] plateau = {//new Piece[8][8]; // [y][x]
			{ Tour.NOIR, Cavalier.NOIR, Fou.NOIR, Roi.NOIR, Reine.NOIR, Fou.NOIR, Cavalier.NOIR, Tour.NOIR },
			{ Pion.NOIR, Pion.NOIR, Pion.NOIR, Pion.NOIR, Pion.NOIR, Pion.NOIR, Pion.NOIR, Pion.NOIR },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null },
			{ Pion.BLANC, Pion.BLANC, Pion.BLANC, Pion.BLANC, Pion.BLANC, Pion.BLANC, Pion.BLANC, Pion.BLANC },
			{ Tour.BLANC, Cavalier.BLANC, Fou.BLANC , Reine.BLANC, Roi.BLANC, Fou.BLANC , Cavalier.BLANC, Tour.BLANC }
	};
	
	public Piece getPieceEn(Coordonnees coords) {
		return plateau[coords.getY()][coords.getX()];
	}
	
	//gestion du déplacement des pieces
	public boolean moveTo(Coordonnees origine, Coordonnees destination) {
		final Piece pieceABouger = getPieceEn(origine);
		
		if (pieceABouger == null) {
			return false;
		}
                
                if ((origine.getX() == destination.getX()) &&(origine.getY() == destination.getY())){
                    return false;
                }
		if (plateau[destination.getY()][destination.getX()] instanceof Piece && (getPieceEn(origine).getCouleur() == getPieceEn(destination).getCouleur())) {
			return false;
		}
                
		List<Coordonnees> possibles = pieceABouger.deplacementsValides(origine);
		
		// for (int i = 0; i < possibles.size(); i++) { Coordonnees actual = possibles.get(i); ... }
		//vérification si le déplacement et valide ou non
		for(Coordonnees actual : possibles) {
			if (actual.equals(destination)) {
				// Le déplacement est valide
				plateau[destination.getY()][destination.getX()] = pieceABouger;
				plateau[origine.getY()][origine.getX()] = null;
				return true;
			}
		}
		return false;
	}
}
