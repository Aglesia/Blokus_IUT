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
	private AfficherPlateau affichagePlateau;
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
		affichagePlateau = new AfficherPlateau(partie, this);
		affichageInfos = new Info(partie, affichagePlateau);
		affichageBoutons = new BarreBoutons(partie, affichageInfos);
		affichagePieces = new AfficherPieces(partie, affichageInfos);
		
		// On crée les layout et les panels associés
		JPanel fond = new JPanel(new BorderLayout());
		JPanel gauche = new JPanel(new BorderLayout());
		
		// On met en page les composants
		this.add(fond);
		fond.add(gauche, BorderLayout.WEST);
		fond.add(affichagePlateau);
		gauche.add(affichageInfos, BorderLayout.NORTH);
		gauche.add(affichagePieces);
		gauche.add(affichageBoutons, BorderLayout.SOUTH);
		
		// On crée et initialise la fenêtre
		this.setSize(945, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BLOKUS");
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// On crée les pièces pour les mettre dans la fenêtre
		for(Piece piece : pieces)
			affichagePieces.ajouterPiece(piece, piece.getPosition());
		affichagePlateau.majPieces();
		affichagePieces.viderGrille();
	}

	public Info getPanelInfo(){
		return this.affichageInfos;
	}

	public AfficherPlateau getPanelPlateau(){
		return this.affichagePlateau;
	}

	public BarreBoutons getPanelBoutons(){
		return this.affichageBoutons;
	}

	public AfficherPieces getPanelPieces(){
		return this.affichagePieces;
	}

	/**
	 * Met à jour la couleur et le nom du joueur actuel.
	 * (A VIRER !!!) Easter Egg : Si le nom est "XXXX" , afficher une image spécifique à la place de la couleur
	 * @param joueur Joueur à qui est le tour
	 */
	public void maj(Joueur joueur) {		
		affichageInfos.majJoueur(joueur);
		affichagePieces.viderGrille();
		affichagePieces.majPieces(joueur);
		affichagePlateau.majPieces();
	}

}