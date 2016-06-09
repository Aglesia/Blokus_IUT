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
	private JLabel[][] piecesJoueurActuel;
	private JLabel nombreJoueurs;
	private JLabel joueurGagnant;
	private Partie partie;
	private Joueur joueurActuel;
	private AfficherPlateau plateau;

	/**
	 * Crée un nouveau panel d'infos, avec tous les objets graphiques nécessaires
	 * @param joueurs Liste des joueurs
	 */
	public Info(Partie partie, AfficherPlateau plateau) {
		this.plateau = plateau;
		this.partie = partie;
		this.joueurs = partie.getJoueurs();
		nomJoueurActuel = new JLabel("Aucun joueur");
		couleurJoueurActuel = new JLabel();
		JPanel pieceJoueurActuel = new JPanel(new GridLayout(7, 7));
		piecesJoueurActuel = new JLabel[7][7];
		for(int i=0; i<7; i++)
			for(int j=0; j<7; j++){
				piecesJoueurActuel[i][j] = new JLabel("    ");
				piecesJoueurActuel[i][j].setOpaque(true);
				pieceJoueurActuel.add(piecesJoueurActuel[i][j]);
			}
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
		nomJoueurActuel.setHorizontalAlignment(SwingConstants.CENTER);
	}

	/**
	 * Met à jour l'affichage des infos, selon le joueur en cours
	 * @param joueurActuel Joueur qui commence son tour
	 */
	public void majJoueur(Joueur joueurActuel) {
		this.joueurActuel = joueurActuel;
		// On efface la pièce
		for(int i=0; i<7; i++)
			for(int j=0; j<7; j++)
				piecesJoueurActuel[i][j].setBackground(Color.BLACK);

		// On dessine la pièce
		if(partie.getPieceSelectionnee()!=null)
			for(int i=0; i<7; i++)
				for(int j=0; j<7; j++)
					if(partie.getPieceSelectionnee().getMap()[i][j]==3)
						piecesJoueurActuel[i][j].setBackground(joueurActuel.getCouleur());

		// On change le nom du joueur en cours
		this.nomJoueurActuel.setText(joueurActuel.getNom());
		this.couleurJoueurActuel.setBackground(joueurActuel.getCouleur());

		// On regarde qui a le meilleur score
	}

	/**
	 * Met à jour l'affichage de la pièce actuellement sélectionnée
	 * Si null, affiche une pièce vide
	 * @param piece Pièce à afficher (null pour vider)
	 */
	public void afficherPieceSelectionnee(Piece piece) {
		System.out.println("Pièce sélectionnée : "+piece.getNumero());
		plateau.majPositions(piece);
		// On dessine la pièce
		for(int i=0; i<7; i++)
			for(int j=0; j<7; j++){
				if(piece.getMap()[i][j]==3)
					piecesJoueurActuel[i][j].setBackground(piece.getJoueur().getCouleur());
				else
					piecesJoueurActuel[i][j].setBackground(Color.BLACK);
			}
	}

}