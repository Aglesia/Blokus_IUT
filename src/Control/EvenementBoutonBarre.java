package Control;

import Model.Partie;
import java.awt.event.*;
import View.Bouton;
import View.Info;
import javax.swing.JOptionPane;
import Model.EnregistrerEtCharger;

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
				if(JOptionPane.showConfirmDialog (null, "Êtes-vous sûr de vouloir passer votre tour ? Celà vous empèche de jouer jusqu'à la fin de la partie !!", "Passer son tour", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					partie.getJoueurActuel().abandonner();
					partie.pieceEstPlacee();
				}
			break;

			case "Nouveau":
				partie.recommencer();
				partie.pieceEstPlacee();
			break;

			case "Quitter":
				partie.quitterWarning();
				partie.pieceEstPlacee();
			break;

			case "Enregistrer":
				partie.enregistrer();
			break;

			case "Warning":
				for(int i=0; i<10; i++)
					if(!EnregistrerEtCharger.partieExiste(i)){
						EnregistrerEtCharger.enregistrer(i, partie);
						i = 10;
					}
				partie.quitterWarning();
				partie.pieceEstPlacee();
			break;

			default:
			break;
		}
	}

}