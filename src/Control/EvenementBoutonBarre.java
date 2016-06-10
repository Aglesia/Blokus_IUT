package Control;

import Model.Partie;
import java.awt.event.*;
import View.Bouton;
import View.Info;

/**
 * Gère tous les boutons de la barre d'outils.
 * Gère aussi l'affichage des menus de sauvegarde et de chargement
 */
public class EvenementBoutonBarre implements ActionListener{

	/**
	 * partie en cours, permet de l'enregistrer ou de la recommencer
	 */
	private Partie partie;
	private Info info;

	/**
	 * Crée un nouvel évènement, qui gérera tous les boutons de la barre d'outils.
	 * @param partie Partie en cours
	 */
	public EvenementBoutonBarre(Partie partie, Info info) {
		this.partie = partie;
		this.info = info;
	}

	/**
	 * Gère l'évènement d'un bouton qui vient d'être pressé
	 * @param action Bouton sur lequel l'utilisateur a appuyé
	 */
	public void actionPerformed(ActionEvent action) {
		String nom = ((Bouton)action.getSource()).getNom();
		System.out.println("Bouton Barre Appuyé : "+nom);
		switch(nom){
			case "Inverser":
				if(partie.getPieceSelectionnee()!=null){
					partie.getPieceSelectionnee().inverserSens();
					info.afficherPieceSelectionnee(partie.getPieceSelectionnee());
				}
			break;

			case "Tourner":
				if(partie.getPieceSelectionnee()!=null){
					partie.getPieceSelectionnee().setOrientationDroite();
					info.afficherPieceSelectionnee(partie.getPieceSelectionnee());
				}
			break;

			case "Abandonner":
				partie.getJoueurActuel().abandonner();
				partie.pieceEstPlacee();
			break;

			default:
			break;
		}
	}

}