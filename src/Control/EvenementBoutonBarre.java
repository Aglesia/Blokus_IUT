package Control;

import Model.Partie;
import java.awt.event.*;

/**
 * Gère tous les boutons de la barre d'outils.
 * Gère aussi l'affichage des menus de sauvegarde et de chargement
 */
public class EvenementBoutonBarre implements ActionListener{

	/**
	 * partie en cours, permet de l'enregistrer ou de la recommencer
	 */
	private Partie partie;

	/**
	 * Crée un nouvel évènement, qui gérera tous les boutons de la barre d'outils.
	 * @param partie Partie en cours
	 */
	public EvenementBoutonBarre(Partie partie) {
		// TODO - implement EvenementBoutonBarre.EvenementBoutonBarre
		throw new UnsupportedOperationException();
	}

	/**
	 * Gère l'évènement d'un bouton qui vient d'être pressé
	 * @param action Bouton sur lequel l'utilisateur a appuyé
	 */
	public void actionPerformed(ActionEvent action) {
		// TODO - implement EvenementBoutonBarre.actionPerformed
		throw new UnsupportedOperationException();
	}

}