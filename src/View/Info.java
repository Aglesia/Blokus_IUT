package View;
import java.awt.*;
import javax.swing.*;

import Model.*;

/**
 * Panel contenant toutes les infos du joueur actuel et des différents joueurs de la partie
 */
public class Info extends JPanel{

	/**
	 * Liste des joueurs, pour afficher leurs infos
	 */
	private Joueur[] joueurs;
	private JLabel nomJoueurActuel;
	private JLabel couleurJoueurActuel;
	private JLabel pieceJoueurActuel;
	private JLabel nombreJoueurs;
	private JLabel joueurGagnant;

	/**
	 * Crée un nouveau panel d'infos, avec tous les objets graphiques nécessaires
	 * @param joueurs Liste des joueurs
	 */
	public Info(Joueur[] joueurs) {
		this.joueurs = joueurs;
		nomJoueurActuel = new JLabel("Aucun joueur");
		couleurJoueurActuel = new JLabel();
		pieceJoueurActuel = new JLabel();
		int nbJoueurs = 4;
		if(joueurs[3]==null)
			nbJoueurs = 3;
		if(joueurs[2]==null)
			nbJoueurs = 2;
		nombreJoueurs = new JLabel(nbJoueurs+" joueurs");
		joueurGagnant = new JLabel("Personne ne gagne pour le moment");

		// On crée les layouts
		this.setLayout(new BorderLayout());
		JPanel bas = new JPanel(new GridLayout(2, 0));

		// On place les composants
		this.add(nomJoueurActuel);
		this.add(couleurJoueurActuel, BorderLayout.WEST);
		this.add(pieceJoueurActuel, BorderLayout.EAST);
		this.add(bas, BorderLayout.SOUTH);
		bas.add(nombreJoueurs);
		bas.add(joueurGagnant);
	}

	/**
	 * Met à jour l'affichage des infos, selon le joueur en cours
	 * @param joueurActuel Joueur qui commence son tour
	 */
	public void majJoueur(Joueur joueurActuel) {
		// TODO - implement Info.majJoueur
		throw new UnsupportedOperationException();
	}

	/**
	 * Met à jour l'affichage de la pièce actuellement sélectionnée
	 * Si null, affiche une pièce vide
	 * @param piece Pièce à afficher (null pour vider)
	 */
	public void afficherPieceSelectionnee(Piece piece) {
		// TODO - implement Info.afficherPieceSelectionnee
		throw new UnsupportedOperationException();
	}

}