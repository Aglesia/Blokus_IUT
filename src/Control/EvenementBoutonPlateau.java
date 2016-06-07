package Control;

import Model.Partie;
import java.awt.event.*;

/**
 * Gère tous les boutons présents sur le plateau.
 * Un bouton correspond à une case.
 */
public class EvenementBoutonPlateau implements ActionListener{

	/**
	 * partie en cours, permet d'accéder au model
	 */
	private Partie partie;

	/**
	 * Crée un évènement qui gèrera tous les boutons du plateau
	 * @param partie Partie en cours à utiliser
	 */
	public EvenementBoutonPlateau(Partie partie) {
		// TODO - implement EvenementBoutonPlateau.EvenementBoutonPlateau
		throw new UnsupportedOperationException();
	}

	/**
	 * Récupère la position du clic sur le plateau, grâce au nom du bouton
	 * @param action Bouton sur lequel l'utilisateur a appuyé
	 */
	public void actionPerformed(ActionEvent action) {
		// TODO - implement EvenementBoutonPlateau.actionPerformed
		throw new UnsupportedOperationException();
	}

}