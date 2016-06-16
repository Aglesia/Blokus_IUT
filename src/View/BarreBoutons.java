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
	 * icone du bouton pour inverser le sens de la pièce
	 */
	private Image imageInverser;
	/**
	 * icone du bouton permettant de tourner la pièce de 90°
	 */
	private Image imageTourner;
	/**
	 * icone du bermet d'ouvrir le menu d'enregistrement de la partie
	 */
	private Image imageEnregistrer;
	/**
	 * icone du bouton permettant de remettre la partie à 0
	 */
	private Image imageNouveau;
	/**
	 * icone du bouton permettant d'enregistrer très rapidement la partie dans le premier slot disponible, et de quitter le jeu (Quand le prof arrive)
	 */
	private Image imageWarningProf;
	/**
	 * icone du bouton permettant de quitter le jeu (n'enregistre pas la partie)
	 */
	private Image imageQuitter;
	/**
	 * icone du bouton permettant au joueur d'abandonner
	 */
	private Image imageAbandonner;

	/**
	 * Crée une barre de boutons de menu
	 * @param partie Partie actuelle
	 */
	public BarreBoutons(Partie partie, Info info) {
		EvenementBoutonBarre event = new EvenementBoutonBarre(partie, info);
		boutonInverser = new Bouton("Inverser", null, new ImageIcon("../Ressources/inverser.png"), event, null);
		boutonTourner = new Bouton("Tourner", null, new ImageIcon("../Ressources/rotation.png"), event, null);
		boutonEnregistrer = new Bouton("Enregistrer", null, new ImageIcon("../Ressources/enregistrer.png"), event, null);
		boutonNouveau = new Bouton("Nouveau", null, new ImageIcon("../Ressources/nouveau.png"), event, null);
		boutonWarningProf = new Bouton("Warning", null, new ImageIcon("../Ressources/warning.png"), event, null);
		boutonAbandonner = new Bouton("Abandonner", null, new ImageIcon("../Ressources/abandon.png"), event, null);
		boutonQuitter = new Bouton("Quitter", null, new ImageIcon("../Ressources/quitter.png"), event, null);

		imageInverser = (new ImageIcon("../Ressources/inverser.png")).getImage();
		imageTourner = (new ImageIcon("../Ressources/rotation.png")).getImage();
		imageEnregistrer = (new ImageIcon("../Ressources/enregistrer.png")).getImage();
		imageNouveau = (new ImageIcon("../Ressources/nouveau.png")).getImage();
		imageWarningProf = (new ImageIcon("../Ressources/warning.png")).getImage();
		imageAbandonner = (new ImageIcon("../Ressources/abandon.png")).getImage();
		imageQuitter = (new ImageIcon("../Ressources/quitter.png")).getImage();

		this.setLayout(new GridLayout(0, 7));
		this.setBackground(partie.getPlateau().getBackground());
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

	/**
	 * Redimensionne les icones des boutons selon la taille des boutons
	 */
	public void majTaille(){
		int taille = (boutonInverser.getWidth()<boutonInverser.getHeight())?boutonInverser.getWidth():boutonInverser.getHeight();
		taille-=4;


		boutonInverser.setIcon(new ImageIcon(imageInverser.getScaledInstance(taille, taille, Image.SCALE_SMOOTH)));
		boutonTourner.setIcon(new ImageIcon(imageTourner.getScaledInstance(taille, taille, Image.SCALE_SMOOTH)));
		boutonAbandonner.setIcon(new ImageIcon(imageAbandonner.getScaledInstance(taille, taille, Image.SCALE_SMOOTH)));
		boutonEnregistrer.setIcon(new ImageIcon(imageEnregistrer.getScaledInstance(taille, taille, Image.SCALE_SMOOTH)));
		boutonNouveau.setIcon(new ImageIcon(imageNouveau.getScaledInstance(taille, taille, Image.SCALE_SMOOTH)));
		boutonWarningProf.setIcon(new ImageIcon(imageWarningProf.getScaledInstance(taille, taille, Image.SCALE_SMOOTH)));
		boutonQuitter.setIcon(new ImageIcon(imageQuitter.getScaledInstance(taille, taille, Image.SCALE_SMOOTH)));
	}

}
