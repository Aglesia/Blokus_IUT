package Model;
import java.awt.Color;

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
		this.taille = taille;
		map = new Piece[taille][taille];
		for(int i=0; i<taille; i++)
			for(int j=0; j<taille; j++)
				map[i][j] = null;
		this.couleurFond = couleurFond;
	}

	/**
	 * Place une pièce sur le damier
	 * @param position Position de la pièce à placer
	 * @param piece Pièce à placer
	 */
	public void ajouterPiece(int[] position, Piece piece) {
		if(position[0]<-1||position[0]>=this.taille||position[1]<-1||position[1]>=this.taille)
			return;
		piece.setPosition(position);
		int[][] map = piece.getMap();
		for(int i=position[0]; i<position[0]+7; i++)
			for(int j=position[1]; j<position[1]+7; j++)
				if(i>=0 && i<this.taille && j>=0 && j<this.taille)
					if(map[i][j]==3)
						this.map[i][j] = piece;
	}

	/**
	 * Indique quel joueur se trouve sur la case choisie
	 * @param position Case à regarder
	 */
	public Joueur getJoueurSurCase(int[] position) {
		if(position[0]<0||position[0]>=this.taille||position[1]<0||position[1]>=this.taille)
			return null;
		if(this.map[position[0]][position[1]]==null)
			return null;
		return this.map[position[0]][position[1]].getJoueur();
	}

	/**
	 * Retourne la pièce qui se trouve sur la case choisie
	 * @param position Position de la case choisie
	 */
	public Piece getPieceSurCase(int[] position) {
		if(position[0]<0||position[0]>=this.taille||position[1]<0||position[1]>=this.taille)
			return null;
		return this.map[position[0]][position[1]];
	}

	/**
	 * retourne la couleur de la case choisie (Soit couleur de fond, soit couleur du joueur)
	 * @param position Adresse de la case choisie
	 */
	public Color getCouleurCase(int[] position) {
		if(position[0]<0||position[0]>=this.taille||position[1]<0||position[1]>=this.taille)
			return this.couleurFond;
		if(this.map[position[0]][position[1]]==null)
			return this.couleurFond;
		return this.map[position[0]][position[1]].getCouleur();
	}

}