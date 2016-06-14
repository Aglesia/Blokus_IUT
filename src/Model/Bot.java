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
		for(int p=0; p<21; p++)
			if(this.getPieces()[p].getPosition()[0]==-10 && this.getPieces()[p].getPosition()[1]==-10){
				for(int l=0; l<4; l++){
					this.getPieces()[p].setOrientationDroite();
					for(int i=-7; i<partie.getPlateau().getTaille(); i++)
						for(int j=-7; j<partie.getPlateau().getTaille(); j++)
							if(this.getPieces()[p].piecePosable(partie.getPlateau(), new int[]{i, j}))
								if(this.getPieces()[p].getNombrePoints()>nombrePointsMax){
									nombrePointsMax = this.getPieces()[p].getNombrePoints();
									pieceMax = this.getPieces()[p];
									positionMax = new int[]{i, j};
								}
				}
				this.getPieces()[p].inverserSens();
				for(int l=0; l<4; l++){
					this.getPieces()[p].setOrientationDroite();
					for(int i=-7; i<partie.getPlateau().getTaille(); i++)
						for(int j=-7; j<partie.getPlateau().getTaille(); j++)
							if(this.getPieces()[p].piecePosable(partie.getPlateau(), new int[]{i, j}))
								if(this.getPieces()[p].getNombrePoints()>nombrePointsMax){
									nombrePointsMax = this.getPieces()[p].getNombrePoints();
									pieceMax = this.getPieces()[p];
									positionMax = new int[]{i, j};
								}
				}
			}

		// On place la meilleur pièce si on peut
		if(pieceMax!=null){
			this.placerPiece(pieceMax, positionMax, partie.getPlateau());
			System.out.println("La pièce a été posée");
		}
		else{
			this.abandonner();
			System.out.println("Le bot a abandonné");
		}
		return true;
	}
}