package Echecs;

import java.util.List;
import java.util.ArrayList;

public class Pion extends Piece {
	
	//création d'une instance de pion noir et blanc
	public static Pion BLANC = new Pion (Couleur.BLANC);
	public static Pion NOIR = new Pion (Couleur.NOIR);
	
	//récupération des données du constructeur
	public Pion (Couleur couleur) {
		super(couleur);
	}
	
	List<Coordonnees> deplacementsValides(Coordonnees origine) {
		//instance de liste
		final ArrayList<Coordonnees> result = new ArrayList<>();
		
		int lastY;
		int direction;
		
		//définition de la direction que le pion va prendre en fonction de sa couleur
		if(getCouleur() == Couleur.BLANC) {
			lastY = 0;
			direction = -1;
		} else {
			lastY = 7;
			direction = 1;
		}
		
		//si le pion n'est pas sur la dernière case
		if (origine.getY() != lastY) {
			
			//alors récupère la dernière valeur de la case utilisée et fait +1
			result.add(new Coordonnees (origine.getX(), origine.getY() + direction));
		}
		return result;
	}
}
