package View;
import java.awt.*;
import javax.swing.*;

import Model.*;

/**
 * Fenêtre contenant tous les objets graphiques de la partie en cours
 */
public class Fenetre extends JFrame{

	/**
	 * Panel contenant la sélection des pièces
	 */
	private AfficherPieces affichagePieces;
	/**
	 * Panel contenant les pièces placées
	 */
	private AfficherPlateau affchagePlateau;
	/**
	 * Panel contenant les boutons de menu
	 */
	private BarreBoutons affichageBoutons;
	/**
	 * Panel contenant les infos de la partie en cours
	 */
	private Info affichageInfos;

	/**
	 * Crée la fenêtre en plein écran, ainsi que tous les objets graphiques nécessaires.
	 * Assemble toute la fenêtre, les boutons, etc
	 */
	public Fenetre() {
		// TODO - implement Fenetre.Fenetre
		throw new UnsupportedOperationException();
	}

	/**
	 * Met à jour la couleur et le nom du joueur actuel.
	 * (A VIRER !!!) Easter Egg : Si le nom est "XXXX" , afficher une image spécifique à la place de la couleur
	 * @param joueur Joueur à qui est le tour
	 */
	public void maj(Joueur joueur) {
		// TODO - implement Fenetre.maj
		throw new UnsupportedOperationException();
	}

}