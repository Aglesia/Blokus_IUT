package Control;

import Model.Menu;
import View.Bouton;
import View.AfficherEnregistrement;
import java.awt.event.*;
import javax.swing.JColorChooser;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * Gère tous les boutons du menu
 */
public class EvenementBoutonMenuEnregistrement implements ActionListener{
	/**
	 * Fenetre du menu
	 */
	private AfficherEnregistrement fenetre;

	/**
	 * Crée un évènement pour gérer les boutons du menu.
	 * Les autres objets du menus ne sont pas dynamiques
	 * @param fenetre Fenetre du menu
	 */
	public EvenementBoutonMenuEnregistrement(AfficherEnregistrement fenetre) {
		this.fenetre = fenetre;
	}

	/**
	 * Gère l'évènement du bouton de menu qui vient d'être pressé
	 * @param action Bouton sur lequel l'utilisateur a appuyé
	 */
	public void actionPerformed(ActionEvent action) {
		Bouton bouton = (Bouton)action.getSource();
		String nom = bouton.getNom();

		if(nom.equals("Enregistrer")){
			if(bouton.getText().equals("Remplacer")){
				if(JOptionPane.showConfirmDialog (null, "Êtes-vous sûr de vouloir écraser cette sauvegarde ?", "Remplacer une sauvegarde", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					fenetre.setValide();
			}
			else
				fenetre.setValide();
		}
		else if(nom.equals("Retour")){
			fenetre.setRetour();
		}

		else if(nom.equals("Gauche")){
			fenetre.slotPrecedent();
		}
		else if(nom.equals("Droite")){
			fenetre.slotSuivant();
		}

	}

}