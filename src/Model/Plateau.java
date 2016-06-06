package Model;

/**
 * Plateau contenant les différentes pièces placées.
 */
public class Plateau {

	/**
	 * Matrice des cases, Une case contient soit null, soit la piece qui y est placé
	 */
	private Piece[][] map;
	/**
	 * Taille (cases²) du damier
	 */
	private int taille;
	private Color couleurFond;

	/**
	 * Crée un nouveau damier vide de taille "taille"²
	 * @param taille Taille du damier, en case*case
	 * @param couleurFond Couleur de fond du damier
	 */
	public Plateau(int taille, Color couleurFond) {
		// TODO - implement Plateau.Plateau
		throw new UnsupportedOperationException();
	}

	/**
	 * Place une pièce sur le damier
	 * @param position Position de la pièce à placer
	 * @param piece Pièce à placer
	 */
	public void ajouterPiece(int[] position, Piece piece) {
		// TODO - implement Plateau.ajouterPiece
		throw new UnsupportedOperationException();
	}

	/**
	 * Indique quel joueur se trouve sur la case choisie
	 * @param position Case à regarder
	 */
	public Joueur getJoueurSurCase(int[] position) {
		// TODO - implement Plateau.getJoueurSurCase
		throw new UnsupportedOperationException();
	}

	/**
	 * Retourne la pièce qui se trouve sur la case choisie
	 * @param position Position de la case choisie
	 */
	public Piece getPieceSurCase(int[] position) {
		// TODO - implement Plateau.getPieceSurCase
		throw new UnsupportedOperationException();
	}

	/**
	 * retourne la couleur de la case choisie (Soit couleur de fond, soit couleur du joueur)
	 * @param position Adresse de la case choisie
	 */
	public Color getCouelurCase(int[] position) {
		// TODO - implement Plateau.getCouelurCase
		throw new UnsupportedOperationException();
	}

}