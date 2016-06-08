package Control;

import Model.Partie;
import java.awt.event.*;
import View.Bouton;
import View.Info;
import View.AfficherPieces;

/**
 * Gère tous les évènements des boutons de sélection des pièces
 */
public class EvenementBoutonSelectionPiece implements ActionListener{

	/**
	 * partie en cours, permet d'accéder au model
	 */
	private Partie partie;
	private Info infos;
	private AfficherPieces pieces;

	/**
	 * Crée un gestionnaire d'évènement pour tous les boutons de sélection des pièces
	 * @param partie Partie en cours à utiliser
	 */
	public EvenementBoutonSelectionPiece(Partie partie, AfficherPieces pieces, Info infos) {
		this.partie = partie;
		this.infos = infos;
		this.pieces = pieces;
	}

	/**
	 * Gère la sélection de la pièce à partir du nom du bouton qui vient d'être pressé
	 * @param action Bouton sur lequel l'utilisateur a appuyé
	 */
	public void actionPerformed(ActionEvent action) {
		int numero = Integer.parseInt(((Bouton)action.getSource()).getNom());
		System.out.println("La pièce "+numero+" est sélectionnée");
		partie.selectionnerPiece(partie.getJoueurActuel().getPiece(numero));
		infos.afficherPieceSelectionnee(partie.getJoueurActuel().getPiece(numero));
	}

}