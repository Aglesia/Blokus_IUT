package Model;

/**
 * Toutes les données d'une pièce sont incluses ici :
 * Sa position sur le plateau, sa matrice, son orientation et sa couleur (joueur à qui appartient la pièce)
 */
public class Piece {

	/**
	 * Position sur le plateau, de la case 0,0 de la matrice (en tenant compte de l'orientation).
	 * Le tableau contient deux cases ; Valeur en X, et valeur en Y. (0,0 indique une pièce hors plateau)
	 */
	private int[] position;
	/**
	 * Carte matricielle de la pièce.
	 * Le tableau à deux dimensions, de taille fixe 7*7, contient des nombres allant de 0 à 2 :
	 * - 0 = Case vide
	 * - 1 = Case valide pour coller une autre pièce
	 * - 2 = Case remplie par la couleur du joueur
	 * 
	 * Les premières et dernières lignes, ainsi que les premières et dernières colonnes ne peuvent prendre que les valeurs 0 ou 1.
	 */
	private int[][] map;
	/**
	 * Joueur auquel appartient la pièce
	 */
	private Joueur joueur;
	/**
	 * Orientation actuelle de la pièce (prise en compte dans le getter de la map)
	 * 0 = normal, 1 = 90°, 2 = 180°, 3 = 270°
	 * 4 = inversé, 5 = i90°, 6 = i180°, 7 = i270°
	 */
	private int orientation;
	/**
	 * Numéro de la pièce
	 */
	private int numero;

	/**
	 * Constructeur unique de la pièce, crée une pièce appartenant à un joueur, et ayant une matrice
	 * @param joueur Joueur auquel appartient cette nouvelle pièce
	 * @param map Matrice de 7*7 contenant les données de la pièce (les cases)
	 * @param numeroPiece Numéro de la pièce (la même que les 3 de la même forme, des autres couleurs)
	 */
	public Piece(Joueur joueur, int[][] map, int numeroPiece) {
		// TODO - implement Piece.Piece
		throw new UnsupportedOperationException();
	}

	/**
	 * Retourne la position de la pièce sous forme d'un tableau de deux cases (X; Y)
	 */
	public int[] getPosition() {
		return this.position;
	}

	/**
	 * Retourne la matrice de la pièce, en tenant compte de son orientation
	 */
	public int[][] getMap() {
		return this.map;
	}

	/**
	 * Retourne la couleur des cases colorées de la case
	 */
	public Color getColor() {
		// TODO - implement Piece.getColor
		throw new UnsupportedOperationException();
	}

	/**
	 * Modifie la position de la pièce (via un tableau de deux cases, X et Y)
	 * @param position Nouvelle position de la pièce (coin haut gauche, case 0,0 de la matrice)
	 */
	public void setPosition(int[][] position) {
		// TODO - implement Piece.setPosition
		throw new UnsupportedOperationException();
	}

	/**
	 * Tourne la pièce de +90°
	 */
	public void setOrientationDroite() {
		// TODO - implement Piece.setOrientationDroite
		throw new UnsupportedOperationException();
	}

	/**
	 * Indique si une autre pièce peut être posée à côté de celle-ci.
	 * Retourne faux si la pièce actuelle n'est pas placée
	 * @param position L'autre pièce à placer juste à côté
	 * @param Position Position de la seconde pièce
	 */
	public boolean piecePosable(Piece position, int[][] Position) {
		// TODO - implement Piece.piecePosable
		throw new UnsupportedOperationException();
	}

	/**
	 * retourne le nombre de points contenus dans la pièce
	 */
	public int getNombrePoint() {
		// TODO - implement Piece.getNombrePoint
		throw new UnsupportedOperationException();
	}

	/**
	 * Inverse le sens de la pièce sélectionnée
	 */
	public void inverserSens() {
		// TODO - implement Piece.inverserSens
		throw new UnsupportedOperationException();
	}

}