package Echecs;

//gestion des coordonnees sous forme d'axe x et y
class Coordonnees {
	private final int x;
	private final int y;
	
	public Coordonnees(int x, int y) { 
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
	public boolean equals(Object obj) {
		if (obj instanceof Coordonnees) {
			final Coordonnees coords = (Coordonnees) obj;
			return this.x == coords.x && this.y == coords.y;
		} else {
			return false;
		}
	}
	
}