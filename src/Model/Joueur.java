package Model;

/**
 * Données d'un joueur, avec son nom, sa couleur, ses pièces, ses points.
 */
public class Joueur {

	/**
	 * Les différentes pièces du joueur
	 */
	private Piece[] pieces;
	/**
	 * La couleur des pièces du joueur
	 */
	private Color couleur;
	/**
	 * Le nom du joueur
	 */
	private String nom;
	/**
	 * Le nombre de points du joueur
	 */
	private int nombrePoints;

	/**
	 * Crée un nouveau joueur avec un nom et une couleur
	 * @param nom Nom du joueur
	 * @param couleur Couleur du joueur et de ses pièces
	 */
	public Joueur(String nom, Color couleur) {
		// TODO - implement Joueur.Joueur
		throw new UnsupportedOperationException();
	}

	/**
	 * Ajoute une pièce au joueur
	 * @param piece Pièce à ajouter au joueur
	 */
	public void ajouterPiece(Piece piece) {
		// TODO - implement Joueur.ajouterPiece
		throw new UnsupportedOperationException();
	}

	/**
	 * Retourne le nombre de points qu'a le joueur
	 */
	public int getNombrePoints() {
		return this.nombrePoints;
	}

	/**
	 * Retourne le nom du joueur
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne la couleur du joueur
	 */
	public Color getCouleur() {
		return this.couleur;
	}

	/**
	 * Retourne la liste des pièces du joueur
	 */
	public Piece[] getPieces() {
		return this.pieces;
	}

	/**
	 * Place une pièce sur le plateau, et retire les points de la pièce, au joueur
	 * @param piece Pièce à placer
	 * @param position Indique la position sur le plateau où placer la pièce
	 */
	public void placerPiece(Piece piece, int[][] position) {
		// TODO - implement Joueur.placerPiece
		throw new UnsupportedOperationException();
	}

}