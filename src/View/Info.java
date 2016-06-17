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
	private JLabel[][] piecesJoueurActuel;
	private JLabel joueurGagnant;
	private Partie partie;
	private Joueur joueurActuel;
	private AfficherPlateau plateau;
	private JLabel pointsJoueurs1;
	private JLabel pointsJoueurs2;
	private JLabel pointsJoueurs3;
	private JLabel pointsJoueurs4;

	/**
	 * Crée un nouveau panel d'infos, avec tous les objets graphiques nécessaires
	 * @param partie Partie en cours
	 * @param plateau Plateau graphique de la fenêtre, 
	 */
	public Info(Partie partie, AfficherPlateau plateau) {
		this.plateau = plateau;
		this.partie = partie;
		this.joueurs = partie.getJoueurs();
		nomJoueurActuel = new JLabel("Aucun joueur");
		nomJoueurActuel.setBackground(partie.getPlateau().getBackground());
		JPanel pieceJoueurActuel = new JPanel(new GridLayout(5, 5));
		piecesJoueurActuel = new JLabel[5][5];
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++){
				piecesJoueurActuel[i][j] = new JLabel("    ");
				piecesJoueurActuel[i][j].setOpaque(true);
				piecesJoueurActuel[i][j].setBackground(partie.getPlateau().getBackground());
				pieceJoueurActuel.add(piecesJoueurActuel[i][j]);
			}
		int nbJoueurs = 4;
		if(joueurs[3]==null)
			nbJoueurs = 3;
		if(joueurs[2]==null)
			nbJoueurs = 2;
		joueurGagnant = new JLabel("Personne ne gagne pour le moment");
		joueurGagnant.setBackground(partie.getPlateau().getBackground());

		// On crée les label des scores
		JLabel nomJoueurs1 = new JLabel(joueurs[0].getNom());
		JLabel nomJoueurs2 = new JLabel(joueurs[1].getNom());
		JLabel nomJoueurs3 = new JLabel(joueurs[2].getNom());
		JLabel nomJoueurs4 = new JLabel(joueurs[3].getNom());
		pointsJoueurs1 = new JLabel(joueurs[0].getNombrePoints()+" points");
		pointsJoueurs2 = new JLabel(joueurs[1].getNombrePoints()+" points");
		pointsJoueurs3 = new JLabel(joueurs[2].getNombrePoints()+" points");
		pointsJoueurs4 = new JLabel(joueurs[3].getNombrePoints()+" points");
		JPanel pointsJoueurs = new JPanel(new GridLayout(2, 4));
		pointsJoueurs.add(nomJoueurs1);
		pointsJoueurs.add(nomJoueurs2);
		pointsJoueurs.add(nomJoueurs3);
		pointsJoueurs.add(nomJoueurs4);
		pointsJoueurs.add(pointsJoueurs1);
		pointsJoueurs.add(pointsJoueurs2);
		pointsJoueurs.add(pointsJoueurs3);
		pointsJoueurs.add(pointsJoueurs4);
		pointsJoueurs.setBackground(partie.getPlateau().getBackground());

		// on met le texte en noir
		nomJoueurs1.setBackground(partie.getPlateau().getBackground());
		nomJoueurs2.setBackground(partie.getPlateau().getBackground());
		nomJoueurs3.setBackground(partie.getPlateau().getBackground());
		nomJoueurs4.setBackground(partie.getPlateau().getBackground());
		pointsJoueurs1.setBackground(partie.getPlateau().getBackground());
		pointsJoueurs2.setBackground(partie.getPlateau().getBackground());
		pointsJoueurs3.setBackground(partie.getPlateau().getBackground());
		pointsJoueurs4.setBackground(partie.getPlateau().getBackground());

		// On change la couleur de texte
		nomJoueurs1.setForeground(joueurs[0].getCouleur());
		nomJoueurs2.setForeground(joueurs[1].getCouleur());
		nomJoueurs3.setForeground(joueurs[2].getCouleur());
		nomJoueurs4.setForeground(joueurs[3].getCouleur());
		pointsJoueurs1.setForeground(joueurs[0].getCouleur());
		pointsJoueurs2.setForeground(joueurs[1].getCouleur());
		pointsJoueurs3.setForeground(joueurs[2].getCouleur());
		pointsJoueurs4.setForeground(joueurs[3].getCouleur());

		// On centre le texte
		nomJoueurs1.setHorizontalAlignment(SwingConstants.CENTER);
		nomJoueurs2.setHorizontalAlignment(SwingConstants.CENTER);
		nomJoueurs3.setHorizontalAlignment(SwingConstants.CENTER);
		nomJoueurs4.setHorizontalAlignment(SwingConstants.CENTER);
		pointsJoueurs1.setHorizontalAlignment(SwingConstants.CENTER);
		pointsJoueurs2.setHorizontalAlignment(SwingConstants.CENTER);
		pointsJoueurs3.setHorizontalAlignment(SwingConstants.CENTER);
		pointsJoueurs4.setHorizontalAlignment(SwingConstants.CENTER);

		// On crée les layouts
		this.setLayout(new BorderLayout());
		JPanel bas = new JPanel(new GridLayout(3, 0));
		this.setBackground(partie.getPlateau().getBackground());

		// On place les composants
		this.add(nomJoueurActuel);
		this.add(pieceJoueurActuel, BorderLayout.EAST);
		this.add(bas, BorderLayout.SOUTH);
		bas.add(joueurGagnant);
		bas.add(pointsJoueurs);
		bas.setBackground(partie.getPlateau().getBackground());
		nomJoueurActuel.setHorizontalAlignment(SwingConstants.CENTER);
		joueurGagnant.setHorizontalAlignment(SwingConstants.CENTER);
		nomJoueurActuel.setForeground(Color.WHITE);
		joueurGagnant.setForeground(Color.WHITE);
	}

	/**
	 * Met à jour l'affichage des infos, selon le joueur en cours
	 * @param joueurActuel Joueur qui commence son tour
	 */
	public void majJoueur(Joueur joueurActuel) {
		this.joueurActuel = joueurActuel;
		// On efface la pièce
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++)
				piecesJoueurActuel[i][j].setBackground(partie.getPlateau().getBackground());

		// On dessine la pièce
		if(partie.getPieceSelectionnee()!=null)
			for(int i=0; i<5; i++)
				for(int j=0; j<5; j++)
					if(partie.getPieceSelectionnee().getMap()[i+1][j+1]==3)
						piecesJoueurActuel[i][j].setBackground(joueurActuel.getCouleur());

		// On change le nom du joueur en cours
		this.nomJoueurActuel.setText(joueurActuel.getNom());

		// On met à jour les scores de tous les joueurs
		pointsJoueurs1.setText(joueurs[0].getNombrePoints()+" points");
		pointsJoueurs2.setText(joueurs[1].getNombrePoints()+" points");
		pointsJoueurs3.setText(joueurs[2].getNombrePoints()+" points");
		pointsJoueurs4.setText(joueurs[3].getNombrePoints()+" points");

		// On regarde qui a le meilleur score
		int meilleurScore = 0;
		boolean exEqo = true;
		Joueur joueurQuiGagne = null;
		for(Joueur joueur : this.joueurs){
			if(joueur!=null){
				if(joueur.getNombrePoints()>meilleurScore){
					meilleurScore = joueur.getNombrePoints();
					exEqo = false;
					joueurQuiGagne = joueur;
				}
				else if(joueur.getNombrePoints()==meilleurScore)
					exEqo = true;
			}
		}
		if(exEqo)
			joueurGagnant.setText("Personne ne gagne pour le moment");
		else
			joueurGagnant.setText(joueurQuiGagne.getNom()+" est en train de gagner, avec "+meilleurScore+" points");
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
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++){
				if(piece.getMap()[i+1][j+1]==3)
					piecesJoueurActuel[i][j].setBackground(piece.getJoueur().getCouleur());
				else
					piecesJoueurActuel[i][j].setBackground(partie.getPlateau().getBackground());
			}
	}

}