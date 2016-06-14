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
	 * Bouton permettant au joueur d'abandonner
	 */
	private Bouton boutonAbandonner;

	/**
	 * Crée une barre de boutons de menu
	 * @param partie Partie actuelle
	 */
	public BarreBoutons(Partie partie, Info info) {
		EvenementBoutonBarre event = new EvenementBoutonBarre(partie, info);
		boutonInverser = new Bouton("Inverser", null, new ImageIcon("../data/images/inverser.png"), event, null);
		boutonTourner = new Bouton("Tourner", null, new ImageIcon("../data/images/rotation.png"), event, null);
		boutonEnregistrer = new Bouton("Enregistrer", null, new ImageIcon("../data/images/enregistrer.png"), event, null);
		boutonNouveau = new Bouton("Nouveau", null, new ImageIcon("../data/images/nouveau.png"), event, null);
		boutonWarningProf = new Bouton("Warning", null, new ImageIcon("../data/images/warning.png"), event, null);
		boutonAbandonner = new Bouton("Abandonner", null, new ImageIcon("../data/images/abandon.png"), event, null);
		boutonQuitter = new Bouton("Quitter", null, new ImageIcon("../data/images/quitter.png"), event, null);

		this.setLayout(new GridLayout(0, 7));
		this.add(boutonInverser);
		this.add(boutonTourner);
		this.add(boutonAbandonner);
		this.add(boutonEnregistrer);
		this.add(boutonNouveau);
		this.add(boutonWarningProf);
		this.add(boutonQuitter);

		// On met le fond d'écran aux boutons
		boutonInverser.setBackground(partie.getPlateau().getBackground());
		boutonTourner.setBackground(partie.getPlateau().getBackground());
		boutonAbandonner.setBackground(partie.getPlateau().getBackground());
		boutonEnregistrer.setBackground(partie.getPlateau().getBackground());
		boutonNouveau.setBackground(partie.getPlateau().getBackground());
		boutonWarningProf.setBackground(partie.getPlateau().getBackground());
		boutonQuitter.setBackground(partie.getPlateau().getBackground());
	}

}
