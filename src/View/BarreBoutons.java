package View;
import java.awt.*;
import javax.swing.*;

import Model.Partie;
import Model.EnregistrerEtCharger;
import Control.EvenementBoutonBarre;

/**
 * Panel contenant tous les boutons de menu
 */
public class BarreBoutons extends JPanel{

	/**
	 * Bouton pour inverser le sens de la pièce
	 */
	private Bouton boutonInverser;
	/**
	 * Bouton permettant de tourner la pièce de 90°
	 */
	private Bouton boutonTourner;
	/**
	 * Permet d'ouvrir le menu d'enregistrement de la partie
	 */
	private Bouton boutonEnregistrer;
	/**
	 * Bouton permettant de remettre la partie à 0
	 */
	private Bouton boutonNouveau;
	/**
	 * Bouton permettant d'enregistrer très rapidement la partie dans le premier slot disponible, et de quitter le jeu (Quand le prof arrive)
	 */
	private Bouton boutonWarningProf;
	/**
	 * Bouton permettant de quitter le jeu (n'enregistre pas la partie)
	 */
	private Bouton boutonQuitter;

	/**
	 * Crée une barre de boutons de menu
	 * @param partie Partie actuelle
	 */
	public BarreBoutons(Partie partie) {
		EvenementBoutonBarre event = new EvenementBoutonBarre(partie);
		boutonInverser = new Bouton("Inverser", "I", null, event, null);
		boutonTourner = new Bouton("Tourner", "T", null, event, null);
		boutonEnregistrer = new Bouton("Enregistrer", "E", null, event, null);
		boutonNouveau = new Bouton("Nouveau", "N", null, event, null);
		boutonWarningProf = new Bouton("Warning", "W", null, event, null);
		boutonQuitter = new Bouton("Quitter", "Q", null, event, null);

		this.setLayout(new GridLayout(0, 6));
		this.add(boutonInverser);
		this.add(boutonTourner);
		this.add(boutonEnregistrer);
		this.add(boutonNouveau);
		this.add(boutonWarningProf);
		this.add(boutonQuitter);
	}

}