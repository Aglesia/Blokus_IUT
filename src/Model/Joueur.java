package Model;
import java.awt.Color;
import View.Fenetre;
import java.io.Serializable;

/**
 * Données d'un joueur, avec son nom, sa couleur, ses pièces, ses points.
 */
public class Joueur implements Serializable{

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
	 * Position de la case de départ
	 */
	private int[] positionDepart;
	/**
	 * Indique si le joueur a abandonné
	 */
	private boolean abandon;
	/**
	 * Indique si la dernière pièce placée est le carrée simple
	 */
	private boolean dernierePiecePlaceeEstLeCarreSimple;

	/**
	 * Crée un nouveau joueur avec un nom et une couleur
	 * @param nom Nom du joueur
	 * @param couleur Couleur du joueur et de ses pièces
	 * @param positionDepart Position de la première pièce que le joueur peut poser
	 */
	public Joueur(String nom, Color couleur, int[] positionDepart) {
		this.positionDepart = positionDepart;
		this.pieces = new Piece[1];
		pieces[0] = null;
		this.couleur = couleur;
		this.nom = nom;
		this.nombrePoints = 0;
		for(Piece piece : EnsemblePieces.pieces(this))
			this.ajouterPiece(piece);
		dernierePiecePlaceeEstLeCarreSimple = false;
	}

	/**
	 * Fait joueur le joueur
	 * @param      fenetre  La fenêtre sur laquelle on affiche les infos
	 * @param      partie La partie, utilisée par l'IA
	 * @return     True si le joueur a fini son tour (IA), false sinon (joueur normal)
	 */
	public boolean jouer(Fenetre fenetre, Partie partie){
		if(!this.abandon)
			fenetre.maj(this);
		return this.abandon;
	}

	/**
	 * Fait abandonner le joueur, il ne peut plus jouer de la partie
	 */
	public void abandonner(){
		this.abandon = true;
	}

	/**
	 * indique si le joueur a abandonné
	 */
	public boolean aAbandonne(){
		return this.abandon;
	}

	/**
	 * Retourne la position de la case de départ du joueur
	 */
	public int[] getPositionDepart(){
		return this.positionDepart;
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
		return this.nombrePoints+((dernierePiecePlaceeEstLeCarreSimple && this.nombrePoints==89)?20:((this.nombrePoints==89)?15:0));
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
			System.out.println("pièce posée : "+piece.getNumero()+" à ("+position[0]+", "+position[1]+")");
			plateau.ajouterPiece(position, piece);
			this.nombrePoints+=piece.getNombrePoints();
			dernierePiecePlaceeEstLeCarreSimple = (piece.getNombrePoints()==1);
		}
		else
			System.out.println("Piece non posée");
	}

	/**
	 * Indique si la pièce a été placée sur le plateau
	 * @param      numeroPiece  Numéro unique de la pièce
	 */
	public boolean pieceEstPlacee(int numeroPiece){
		boolean ret = true;
		for(int nbPieces=0; pieces[nbPieces]!=null; nbPieces++)
			if(pieces[nbPieces].getNumero()==numeroPiece)
				if(pieces[nbPieces].getPosition()[0]==-10 && pieces[nbPieces].getPosition()[1]==-10)
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