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
	 * Plateau du model
	 */
	private Plateau plateau;

	/**
	 * Crée un plateau graphique et tous les boutons nécessaires à son bon fonctionnement
	 * @param partie Partie en cours, pour avoir la taille du plateau, le plateau lui-même et les autres paramètres de la partie
	 * @param plateau
	 */
	public AfficherPlateau(Partie partie) {
		matriceBouton = new Bouton[partie.getPlateau().getTaille()][partie.getPlateau().getTaille()];
		this.plateau = partie.getPlateau();
		this.setBackground(this.plateau.getBackground());
		this.setLayout(new GridLayout(partie.getPlateau().getTaille(), partie.getPlateau().getTaille()));
		EvenementBoutonPlateau event = new EvenementBoutonPlateau(partie);
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
		// TODO - implement AfficherPlateau.majPieces
		throw new UnsupportedOperationException();
	}

	/**
	 * Met à jour et affiche les positions possibles pour le placement de la pièce
	 * @param pieceSelectionee
	 */
	public void majPositions(Piece pieceSelectionee) {
		// TODO - implement AfficherPlateau.majPositions
		throw new UnsupportedOperationException();
	}

}