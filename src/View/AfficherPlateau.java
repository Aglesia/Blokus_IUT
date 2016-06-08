package View;
import java.awt.*;
import javax.swing.*;
import Control.EvenementBoutonPlateau;

import Model.*;

/**
 * Gère l'affichage du plateau et de toutes les pièces placées.
 * Chaque case contient un bouton, qui change de couleur et s'active ou se désactive entre chaque tour/évènement de sélection de pièce
 */
public class AfficherPlateau extends JPanel{

	/**
	 * Matrice de boutons, qui rempli le plateau de boutons
	 */
	private Bouton[][] matriceBouton;
	/**
	 * Ensemble des positions possibles pour les pièces
	 */
	private int[][][] positionsPossibles;
	/**
	 * Plateau du model
	 */
	private Plateau plateau;

	/**
	 * Crée un plateau graphique et tous les boutons nécessaires à son bon fonctionnement
	 * @param partie Partie en cours, pour avoir la taille du plateau, le plateau lui-même et les autres paramètres de la partie
	 * @param plateau
	 */
	public AfficherPlateau(Partie partie, Fenetre fenetre) {
		matriceBouton = new Bouton[partie.getPlateau().getTaille()][partie.getPlateau().getTaille()];
		this.plateau = partie.getPlateau();
		this.setBackground(this.plateau.getBackground());
		this.setLayout(new GridLayout(partie.getPlateau().getTaille(), partie.getPlateau().getTaille()));
		EvenementBoutonPlateau event = new EvenementBoutonPlateau(partie, fenetre);
		for(int i=0; i<partie.getPlateau().getTaille(); i++)
			for(int j=0; j<partie.getPlateau().getTaille(); j++){
				matriceBouton[i][j] = new Bouton(i+"|"+j, null, null, event, null);
				matriceBouton[i][j].setBackground(this.plateau.getBackground());
				this.add(matriceBouton[i][j]);
			}
	}

	/**
	 * Met à jour les boutons à activer sur le plateau
	 */
	public void majPieces() {
		for(int i=0; i<this.plateau.getTaille(); i++)
			for(int j=0; j<this.plateau.getTaille(); j++){
				if(this.plateau.getPieceSurCase(new int[]{i, j})!=null)
					this.matriceBouton[i][j].setBackground(this.plateau.getPieceSurCase(new int[]{i, j}).getCouleur());
				else
					this.matriceBouton[i][j].setBackground(this.plateau.getBackground());
				this.matriceBouton[i][j].setEnabled(false);
			}
	}

	/**
	 * Met à jour et affiche les positions possibles pour le placement de la pièce
	 * @param pieceSelectionee
	 */
	public void majPositions(Piece pieceSelectionee){
		this.majPieces();
		this.positionsPossibles = new int[plateau.getTaille()][plateau.getTaille()][2];
		for(int i=0; i<this.plateau.getTaille(); i++)
			for(int j=0; j<this.plateau.getTaille(); j++){
				positionsPossibles[i][j][0] = -1;
				positionsPossibles[i][j][1] = -1;
				matriceBouton[i][j].setEnabled(false);
			}
		// On met à jour toutes les positions possibles
		for(int i=-6; i<this.plateau.getTaille(); i++)
			for(int j=-6; j<this.plateau.getTaille(); j++)
				if(pieceSelectionee.piecePosable(plateau, new int[]{i, j})){
					// On pointe toutes les cases vers cette pièce, et on les active
					for(int k=0; k<7; k++)
						for(int l=0; l<7; l++){
							if(pieceSelectionee.getMap()[k][l]==3 && (i+k)>=0 && (j+l)>=0 && (i+k)<plateau.getTaille() && (j+l)<plateau.getTaille()){
								matriceBouton[i+k][j+l].setNom(i+"|"+j);
								matriceBouton[i+k][j+l].setEnabled(true);
								matriceBouton[i+k][j+l].setBackground(pieceSelectionee.getJoueur().getCouleur());
							}
						}
				}
	}

}