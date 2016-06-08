package Model;
import java.awt.Color;

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
	 * - 2 = Case sur laquelle aucune pièce du même joueur ne peut venir se coller
	 * - 3 = Case remplie par la couleur du joueur
	 * 
	 * Les premières et dernières lignes, ainsi que les premières et dernières colonnes ne peuvent prendre que les valeurs 0 ou 1.
	 */
	private int[][] map;
	/**
	 * Joueur auquel appartient la pièce
	 */
	private Joueur joueur;
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
		this.numero = numeroPiece;
		this.map = map;
		this.joueur = joueur;
		this.position = new int[]{0, 0};
	}

	/**
	 * Retourne l'identifiant de la pièce (Toutes les pièces de la même forme ont la même, aucune autre sinon)
	 */
	public int getNumero(){
		return this.numero;
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
	 * Retourne le joueur à qui appartient la pièce
	 */
	public Joueur getJoueur(){
		return this.joueur;
	}

	/**
	 * Retourne la couleur des cases colorées de la case
	 */
	public Color getCouleur() {
		return this.joueur.getCouleur();
	}

	/**
	 * Modifie la position de la pièce (via un tableau de deux cases, X et Y)
	 * @param position Nouvelle position de la pièce (coin haut gauche, case 0,0 de la matrice)
	 */
	public void setPosition(int[] position) {
		this.position = position;
	}

	/**
	 * Tourne la pièce de +90°
	 */
	public void setOrientationDroite() {
		int[][] nouvelleMatrice = new int[7][7];
		for(int i=0; i<7; i++)
			for(int j=0; j<7; j++)
				nouvelleMatrice[i][j] = this.map[6-j][i];
		this.map = nouvelleMatrice;
	}

	/**
	 * Indique si la pièce peut être posée à cet emplacement, sur le plateau (touche une autre pièce amie par le coin, mais aucune par les bords)
	 * @param plateau L'autre pièce à placer juste à côté
	 * @param position Position de la seconde pièce
	 */
	public boolean piecePosable(Plateau plateau, int[] position) {
		boolean coinOK = false;
		boolean bordOK = true;
		Piece pieceTempon = null;
		for(int i=0; i<7; i++)
			for(int j=0; j<7; j++){
				// Si on est dans notre coin, on marque que c'est bon
				if(position[0]+i==joueur.getPositionDepart()[0] && position[1]+j==joueur.getPositionDepart()[1] && this.map[i][j]==1)
					coinOK = true;
				pieceTempon = plateau.getPieceSurCase(new int[]{i+position[0], j+position[1]});
				if(pieceTempon!=null){
					if(pieceTempon.getJoueur()==this.joueur && this.map[i][j]==1)
						coinOK = true;
					if((this.map[i][j]==2 && pieceTempon.getJoueur()==this.joueur) || this.map[i][j]==3)
						bordOK = false;
				}
				
			}
		// On vérifie que la pièce ne sort pas du plateau
		for(int i=0; i<7; i++)
			for(int j=0; j<7; j++)
				if((position[0]+i<0 || position[0]+i>=plateau.getTaille() || position[1]+j<0 || position[1]+j>=plateau.getTaille()) && this.map[i][j]==3)
					bordOK = false;
		if(coinOK && bordOK)
			System.out.println("Piece OK : ("+position[0]+"; "+position[1]+")");
		return (coinOK && bordOK);
	}

	/**
	 * retourne le nombre de points contenus dans la pièce
	 */
	public int getNombrePoints() {
		int ret = 0;
		for(int i=0; i<7; i++)
			for(int j=0; j<7; j++)
				if(this.map[i][j]==3)
					ret++;
		return ret;
	}

	/**
	 * Inverse le sens de la pièce sélectionnée sur l'axe X
	 */
	public void inverserSens() {
		int[][] nouvelleMatrice = new int[7][7];
		for(int i=0; i<7; i++)
			for(int j=0; j<7; j++)
				nouvelleMatrice[i][j] = this.map[i][6-j];
		this.map = nouvelleMatrice;
	}

}