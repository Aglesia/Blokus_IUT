package Control;

import Model.Menu;
import View.Bouton;
import View.AfficherMenu;
import java.awt.event.*;
import javax.swing.JColorChooser;
import java.awt.Color;

/**
 * Gère tous les boutons du menu
 */
public class EvenementBoutonMenu implements ActionListener{

	/**
	 * Menu dans lequel enregistrer les différents paramètres
	 */
	private Menu menu;
	/**
	 * Fenetre du menu
	 */
	private AfficherMenu fenetre;

	/**
	 * Crée un évènement pour gérer les boutons du menu.
	 * Les autres objets du menus ne sont pas dynamiques
	 * @param menu    Menu à utiliser et à paramétrer
	 * @param fenetre Fenetre du menu
	 */
	public EvenementBoutonMenu(Menu menu, AfficherMenu fenetre) {
		this.menu = menu;
		this.fenetre = fenetre;
	}

	/**
	 * Gère l'évènement du bouton de menu qui vient d'être pressé
	 * @param action Bouton sur lequel l'utilisateur a appuyé
	 */
	public void actionPerformed(ActionEvent action) {
		Bouton bouton = (Bouton)action.getSource();
		String nom = bouton.getNom();

		// Boutons quitter/continuer/charger
		if(nom.equals("Quitter")){
			menu.setMenuChargementFerme(-2);
			menu.setMenuFerme();
		}
		else if(nom.equals("Valider")){
			menu.setMenuChargementFerme(-1);
			menu.setMenuFerme();
		}
		else if(nom.equals("Charger")){
			menu.afficherChargementPartie();
		}

		// Boutons de changement de couleur
		else if(nom.equals("Couleur1")){
			JColorChooser model = fenetre.changerCouleur(1);
			Color nouvelleCouleur = model.showDialog(fenetre, "Choix d'une couleur", model.getColor());
			if(nouvelleCouleur!=null)
				model.setColor(nouvelleCouleur);
		}
		else if(nom.equals("Couleur2")){
			JColorChooser model = fenetre.changerCouleur(2);
			Color nouvelleCouleur = model.showDialog(fenetre, "Choix d'une couleur", model.getColor());
			if(nouvelleCouleur!=null)
				model.setColor(nouvelleCouleur);
		}
		else if(nom.equals("Couleur3")){
			JColorChooser model = fenetre.changerCouleur(3);
			Color nouvelleCouleur = model.showDialog(fenetre, "Choix d'une couleur", model.getColor());
			if(nouvelleCouleur!=null)
				model.setColor(nouvelleCouleur);
		}
		else if(nom.equals("Couleur4")){
			JColorChooser model = fenetre.changerCouleur(4);
			Color nouvelleCouleur = model.showDialog(fenetre, "Choix d'une couleur", model.getColor());
			if(nouvelleCouleur!=null)
				model.setColor(nouvelleCouleur);
		}

	}

}