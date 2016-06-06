package View;

import Model.*;

/**
 * Gère l'affichage du plateau et de toutes les pièces placées.
 * Chaque case contient un bouton, qui change de couleur et s'active ou se désactive entre chaque tour/évènement de sélection de pièce
 */
public class AfficherPlateau {

	/**
	 * Matrice de boutons, qui rempli le plateau de boutons
	 */
	private JButton[][] matriceBouton;
	/**
	 * Plateau du model
	 */
	private Plateau plateau;

	/**
	 * Met à jour les boutons à activer sur le plateau
	 */
	public void majPieces() {
		// TODO - implement AfficherPlateau.majPieces
		throw new UnsupportedOperationException();
	}

	/**
	 * Crée un plateau graphique et tous les boutons nécessaires à son bon fonctionnement
	 * @param partie Partie en cours, pour avoir la taille du plateau, le plateau lui-même et les autres paramètres de la partie
	 * @param plateau
	 */
	public AfficherPlateau(Partie partie) {
		// TODO - implement AfficherPlateau.AfficherPlateau
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