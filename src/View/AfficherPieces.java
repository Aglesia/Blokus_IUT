package View;
import java.awt.*;
import javax.swing.*;
import Control.EvenementBoutonSelectionPiece;

import Model.*;

/**
 * Panel contenant les pièces à placer, sous forme de grille de boutons
 */
public class AfficherPieces extends JPanel{

	/**
	 * Matrice de boutons, représentant les pièces à placer
	 */
	private Bouton[][] grilleBoutonsPieces;
	private EvenementBoutonSelectionPiece evenementPieces;

	/**
	 * Crée un panel qui affichera les pièces à placer, ainsi que tous les objets graphiques nécessaires
	 */
	public AfficherPieces(Partie partie, Info info) {
		grilleBoutonsPieces = new Bouton[17][13];
		evenementPieces = new EvenementBoutonSelectionPiece(partie, this, info);
		this.setPreferredSize(new Dimension(25*13, 25*17));
	}

	/**
	 * Met à jour la liste des pièces à afficher selon le joueur (Retire les pièces déjà placées
	 * @param joueur Joueur actuellement en train de jouer
	 */
	public void majPieces(Joueur joueur) {
		// Pour tous les boutons présents, on active uniquement ceux dont les pièces ne sont pas placées
		for(int i=0; i<17; i++)
			for(int j=0; j<13; j++)
				if(grilleBoutonsPieces[i][j]!=null){
					if(!joueur.pieceEstPlacee(Integer.parseInt(grilleBoutonsPieces[i][j].getNom()))){
						grilleBoutonsPieces[i][j].setEnabled(true);
						grilleBoutonsPieces[i][j].setBackground(joueur.getCouleur());
						grilleBoutonsPieces[i][j].setVisible(true);
					}
				}
	}

	/**
	 * Désactive la grille de sélection de pièces
	 */
	public void viderGrille(){
		for(int i=0; i<17; i++)
			for(int j=0; j<13; j++){
				if(grilleBoutonsPieces[i][j]!=null){
					grilleBoutonsPieces[i][j].setEnabled(false);
					grilleBoutonsPieces[i][j].setVisible(false);
				}
			}
	}

	/**
	 * Ajoute une pièce et sa position dans la matrice
	 * @param piece Model de pièce à ajouter
	 * @param position Position de la pièce sur la grille
	 */
	public void ajouterPiece(Piece piece, int[] position) {
		// On crée des boutons à tous les emplacements de la pièce
		for(int i=0; i<7; i++)
			for(int j=0; j<7; j++)
				if(position[1]+i<17 && position[0]+j<13)
					if(piece.getMap()[i][j]==3){
						grilleBoutonsPieces[i+position[1]][j+position[0]] = new Bouton(piece.getNumero()+"", null, null, evenementPieces, null);
						grilleBoutonsPieces[i+position[1]][j+position[0]].setPreferredSize(new Dimension(25, 25));
					}

		// On met à jour l'affichage en remplaçant les emplacements vides par des JLabel
		this.removeAll();
		this.setLayout(new GridLayout(17, 13));
		for(int i=0; i<17; i++)
			for(int j=0; j<13; j++){
				if(grilleBoutonsPieces[i][j]==null)
					this.add(new JLabel());
				else
					this.add(grilleBoutonsPieces[i][j]);
			}
	}

}