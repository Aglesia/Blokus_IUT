package Control;

import Model.Partie;
import java.awt.event.*;
import View.*;

/**
 * Gère tous les boutons présents sur le plateau.
 * Un bouton correspond à une case.
 */
public class EvenementBoutonPlateau implements ActionListener{

	/**
	 * partie en cours, permet d'accéder au model
	 */
	private Partie partie;
	private Fenetre fenetre;

	/**
	 * Crée un évènement qui gèrera tous les boutons du plateau
	 * @param partie Partie en cours à utiliser
	 */
	public EvenementBoutonPlateau(Partie partie, Fenetre fenetre) {
		this.partie = partie;
		this.fenetre = fenetre;
	}

	/**
	 * Récupère la position du clic sur le plateau, grâce au nom du bouton
	 * @param action Bouton sur lequel l'utilisateur a appuyé
	 */
	public void actionPerformed(ActionEvent action) {
		int x = Integer.parseInt(((Bouton)action.getSource()).getNom().substring(0, ((Bouton)action.getSource()).getNom().indexOf("|")));
		int y = Integer.parseInt(((Bouton)action.getSource()).getNom().substring(((Bouton)action.getSource()).getNom().indexOf("|")+1));
		System.out.println("Bouton sélectionné : ("+x+", "+y+")");
		partie.getPieceSelectionnee().setPosition(new int[]{x, y});
		partie.getPieceSelectionnee().getJoueur().placerPiece(partie.getPieceSelectionnee(), new int[]{x, y}, partie.getPlateau());
		fenetre.getPanelPlateau().majPieces();
		fenetre.getPanelPieces().viderGrille();
		partie.pieceEstPlacee();
	}

}