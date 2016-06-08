package View;
import java.awt.*;
import javax.swing.*;
import Model.Joueur;
import Model.Partie;
import Model.Piece;

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
	 * @param partie La partie créée
	 * @param pieces La liste des pièces pour la sélection. Les pièces contiennent leurs emplacements sur le "plateau" de sélection
	 */
	public Fenetre(Partie partie, Piece[] pieces) {
		// On crée les différents composants de la fenêtre
		AfficherPlateau affichagePlateau = new AfficherPlateau(partie);
		Info barreDInfos = new Info(partie, affichagePlateau);
		BarreBoutons barreDeBoutons = new BarreBoutons(partie, barreDInfos);
		AfficherPieces affichagePieces = new AfficherPieces(partie, barreDInfos);
		
		// On crée les layout et les panels associés
		JPanel fond = new JPanel(new BorderLayout());
		JPanel gauche = new JPanel(new BorderLayout());
		
		// On met en page les composants
		this.add(fond);
		fond.add(gauche, BorderLayout.WEST);
		fond.add(affichagePlateau);
		gauche.add(barreDInfos, BorderLayout.NORTH);
		gauche.add(affichagePieces);
		gauche.add(barreDeBoutons, BorderLayout.SOUTH);
		
		// On crée et initialise la fenêtre
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BLOKUS");
		this.setVisible(true);

		// On crée les pièces pour les mettre dans la fenêtre
		for(Piece piece : pieces)
			affichagePieces.ajouterPiece(piece, piece.getPosition());

		// On affiche le premier joueur
		barreDInfos.majJoueur(partie.getJoueurActuel());
		affichagePieces.majPieces(partie.getJoueurActuel());
		affichagePlateau.majPieces();
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