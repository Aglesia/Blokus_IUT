package View;

import Model.*;

/**
 * Panel contenant toutes les infos du joueur actuel et des différents joueurs de la partie
 */
public class Info {

	/**
	 * Liste des joueurs, pour afficher leurs infos
	 */
	private Joueur[] joueurs;

	/**
	 * Crée un nouveau panel d'infos, avec tous les objets graphiques nécessaires
	 * @param joueurs Liste des joueurs
	 */
	public Info(Joueur[] joueurs) {
		// TODO - implement Info.Info
		throw new UnsupportedOperationException();
	}

	/**
	 * Met à jour l'affichage des infos, selon le joueur en cours
	 * @param joueurActuel Joueur qui commence son tour
	 */
	public void majJoueur(Joueur joueurActuel) {
		// TODO - implement Info.majJoueur
		throw new UnsupportedOperationException();
	}

	/**
	 * Met à jour l'affichage de la pièce actuellement sélectionnée
	 * Si null, affiche une pièce vide
	 * @param piece Pièce à afficher (null pour vider)
	 */
	public void afficherPieceSelectionnee(Piece piece) {
		// TODO - implement Info.afficherPieceSelectionnee
		throw new UnsupportedOperationException();
	}

}