package Model;
import java.awt.Color;

/**
 * Données d'un joueur, avec son nom, sa couleur, ses pièces, ses points.
 */
public class Joueur {

	/**
	 * Les différentes pièces du joueur. La dernière pièce est toujours null
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
		this.pieces = new Piece[1];
		pieces[0] = null;
		this.couleur = couleur;
		this.nom = nom;
		this.nombrePoints = 0;
		for(Piece piece : EnsemblePieces.pieces(this))
			this.ajouterPiece(piece);
	}

	/**
	 * Ajoute une pièce au joueur
	 * @param piece Pièce à ajouter au joueur
	 */
	public void ajouterPiece(Piece piece) {
		System.out.println("piece "+piece.getNumero()+" ajoutée");
		int nbPieces = 0;
		for(nbPieces=0; pieces[nbPieces]!=null; nbPieces++);
		Piece[] nouvelles = new Piece[nbPieces+2];
		for(int i=0; i<nbPieces; i++)
			nouvelles[i] = pieces[i];
		nouvelles[nbPieces] = piece;
		nouvelles[nbPieces+1] = null;
		pieces = nouvelles;
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
	 * Place une pièce sur le plateau, et ajoute les points de la pièce, au joueur
	 * @param piece Pièce à placer
	 * @param position Indique la position sur le plateau où placer la pièce
	 * @param plateau Plateau sur lequel placer la pièce
	 */
	public void placerPiece(Piece piece, int[] position, Plateau plateau) {
		if(piece.piecePosable(plateau, position)){
			plateau.ajouterPiece(position, piece);
			this.nombrePoints+=piece.getNombrePoints();
		}
	}

	/**
	 * Indique si la pièce a été placée sur le plateau
	 * @param      numeroPiece  Numéro unique de la pièce
	 */
	public boolean pieceEstPlacee(int numeroPiece){
		boolean ret = true;
		for(int nbPieces=0; pieces[nbPieces]!=null; nbPieces++)
			if(pieces[nbPieces].getNumero()==numeroPiece)
				if(pieces[nbPieces].getPosition()[0]==0 && pieces[nbPieces].getPosition()[1]==0)
					ret = false;
		return ret;
	}

	/**
	 * Retourne la pièce qui a ce numéro
	 * @param      numeroPiece  Numéro unique de la pièce
	 */
	public Piece getPiece(int numeroPiece){
		Piece ret = null;
		for(int nbPieces=0; pieces[nbPieces]!=null; nbPieces++)
			if(pieces[nbPieces].getNumero()==numeroPiece)
				ret = pieces[nbPieces];
		return ret;
	}

}