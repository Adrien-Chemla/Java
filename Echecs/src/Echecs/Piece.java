package Echecs;

import java.util.List;

public abstract class Piece {
	
	private final Couleur couleur;
	
	protected Piece (Couleur couleur) {
		this.couleur = couleur;
	}
	
	//condition implicite de vérification des cases
	protected boolean isInside (int x, int y) {
		return ( x >= 0 && x < 8 && y >= 0 && y < 8);
	}
	
	abstract List<Coordonnees> deplacementsValides(Coordonnees origine);

	//accesseur couleur
	public Couleur getCouleur () {
		return couleur;
	}
}