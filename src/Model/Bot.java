package Model;
import java.awt.Color;
import View.Fenetre;

public class Bot extends Joueur{
	/**
	 * Crée un nouveau bot avec un nom et une couleur
	 * @param nom Nom du joueur
	 * @param couleur Couleur du joueur et de ses pièces
	 * @param positionDepart Position de la première pièce que le joueur peut poser
	 */
	public Bot(String nom, Color couleur, int[] positionDepart){
		super(nom, couleur, positionDepart);
	}

	/**
	 * Jouer en tant que BOT (IA), placer une pièce ou abandonner
	 * @param      fenetre  La fenêtre du jeu, non utilisé ici
	 * @param      partie   La partie en cours, utilisé par l'IA
	 *
	 * @return     toujours true pour indiquer que l'IA a joué
	 */
	public boolean jouer(Fenetre fenetre, Partie partie){
		// On regarde toutes les possibilités pour toutes les pièces, et on garde la meilleur pièce (en terme de points)
		int nombrePointsMax = 0;
		Piece pieceMax = null;
		int[] positionMax = new int[2];
		// On tente de récupérer la meilleur pièce
		for(int taille=5; taille>0; taille--){
			int nbPieces = 0;
			Piece[] piecesPossibles = new Piece[100];
			int[][] positionsPossibles = new int[100][2];
			for(int p=0; p<21; p++)
				// On regarde si la pièce est dispo et qu'elle fait bien la taille qu'on veut
				if(this.getPieces()[p].getPosition()[0]==-10 && this.getPieces()[p].getPosition()[1]==-10 && this.getPieces()[p].getNombrePoints()==taille){
					// On regarde si cette pièce est posable, dans le premier sens possible
					int i;
					for(i=0; i<4; i++){
						this.getPieces()[p].setOrientationDroite();
						for(int x=-6; x<partie.getPlateau().getTaille(); x++)
							for(int y=-6; y<partie.getPlateau().getTaille(); y++)
								if(this.getPieces()[p].piecePosable(partie.getPlateau(), new int[]{x, y}) && nbPieces<99){
									piecesPossibles[nbPieces] = this.getPieces()[p];
									positionsPossibles[nbPieces][0] = x;
									positionsPossibles[nbPieces++][1] = y;
									i=5;
								}
					}
					// Si on a pas trouvé de correspondance, on inverse le sens de la pièce
					if(i==4){
						this.getPieces()[p].inverserSens();
						for(i=0; i<4; i++){
							this.getPieces()[p].setOrientationDroite();
							for(int x=-6; x<partie.getPlateau().getTaille(); x++)
								for(int y=-6; y<partie.getPlateau().getTaille(); y++)
									if(this.getPieces()[p].piecePosable(partie.getPlateau(), new int[]{x, y}) && nbPieces<99){
										piecesPossibles[nbPieces] = this.getPieces()[p];
										positionsPossibles[nbPieces][0] = x;
										positionsPossibles[nbPieces++][1] = y;
										i=5;
									}
						}
					}
				}

				// Si des pièces ont été trouvées, on tente de les insérer
				if(nbPieces>0){
					taille = 0;
					int random = (int)(((double)Math.random())*((double)nbPieces));
					if(random == nbPieces)
						random--;
					pieceMax = piecesPossibles[random];
					positionMax = positionsPossibles[random];
				}
		}

		// On place la meilleur pièce si on peut
		if(pieceMax!=null){
			this.placerPiece(pieceMax, positionMax, partie.getPlateau());
			System.out.println("La pièce a été posée : "+pieceMax.getNumero()+" à ("+positionMax[0]+", "+positionMax[1]+")");
		}
		else{
			this.abandonner();
			System.out.println("Le bot a abandonné");
		}

		// On met à jour le plateau et on retourne qu'on a joué
		fenetre.maj(this);
		return true;
	}
}


// for(int l=0; l<4; l++){
// 	this.getPieces()[p].setOrientationDroite();
// 	for(int i=-7; i<partie.getPlateau().getTaille(); i++)
// 		for(int j=-7; j<partie.getPlateau().getTaille(); j++)
// 			if(this.getPieces()[p].piecePosable(partie.getPlateau(), new int[]{i, j}))
// 				if(this.getPieces()[p].getNombrePoints()>nombrePointsMax){
// 					nombrePointsMax = this.getPieces()[p].getNombrePoints();
// 					pieceMax = this.getPieces()[p];
// 					positionMax = new int[]{i, j};
// 				}
// }
// this.getPieces()[p].inverserSens();
// for(int l=0; l<4; l++){
// 	this.getPieces()[p].setOrientationDroite();
// 	for(int i=-7; i<partie.getPlateau().getTaille(); i++)
// 		for(int j=-7; j<partie.getPlateau().getTaille(); j++)
// 			if(this.getPieces()[p].piecePosable(partie.getPlateau(), new int[]{i, j}))
// 				if(this.getPieces()[p].getNombrePoints()>nombrePointsMax){
// 					nombrePointsMax = this.getPieces()[p].getNombrePoints();
// 					pieceMax = this.getPieces()[p];
// 					positionMax = new int[]{i, j};
// 				}
// }