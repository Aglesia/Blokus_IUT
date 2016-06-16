package View;
import java.awt.*;
import javax.swing.*;
import Model.Joueur;
import Model.Partie;
import Model.Piece;
import java.awt.event.*;


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
	 * Le panel regroupant toutes les infos de gauche
	 */
	private JPanel gauche;
	/**
	 * Panel contenant le panel de sélection des pièces
	 */
	private JPanel selectionPieces;

	/**
	 * Crée la fenêtre en plein écran, ainsi que tous les objets graphiques nécessaires.
	 * Assemble toute la fenêtre, les boutons, etc
	 * @param partie La partie créée
	 * @param pieces La liste des pièces pour la sélection. Les pièces contiennent leurs emplacements sur le "plateau" de sélection
	 * @param tailleX La taille de la fenêtre en pixel, sur l'axe X
	 * @param tailleY La taille de la fenêtre en pixel, sur l'axe Y
	 */
	public Fenetre(Partie partie, Piece[] pieces, int tailleX, int tailleY) {
		// On crée les différents composants de la fenêtre
		affichagePlateau = new AfficherPlateau(partie, this);
		affichageInfos = new Info(partie, affichagePlateau);
		affichageBoutons = new BarreBoutons(partie, affichageInfos);
		affichagePieces = new AfficherPieces(partie, affichageInfos);

		// On crée les layout et les panels associés
		JPanel fond = new JPanel();
		gauche = new JPanel(new BorderLayout());
		selectionPieces = new JPanel();
		fond.setBackground(partie.getPlateau().getBackground());
		gauche.setBackground(partie.getPlateau().getBackground());
		selectionPieces.setBackground(partie.getPlateau().getBackground());
		fond.setLayout(null);
		selectionPieces.setLayout(null);

		// On met en page les composants
		this.add(fond);
		fond.add(gauche);
		fond.add(affichagePlateau);
		gauche.add(affichageInfos, BorderLayout.NORTH);
		gauche.add(selectionPieces);
		gauche.add(affichageBoutons, BorderLayout.SOUTH);
		selectionPieces.add(affichagePieces);

		// On crée et initialise la fenêtre
		this.setSize(tailleX+getContentPane().getWidth(), tailleY+getContentPane().getHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BLOKUS");
		this.setIconImage((new ImageIcon("../data/images/iconeFenetre.png")).getImage());
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// On crée les pièces pour les mettre dans la fenêtre
		for(Piece piece : pieces)
			affichagePieces.ajouterPiece(piece, piece.getPosition());
		affichagePlateau.majPieces();
		affichagePieces.viderGrille();

		// On met à jour la taille des composants
		this.majTaille();

		// On crée son écouteur de mise à jour automatique de la taille des composants
		this.addComponentListener(new ComponentListener() {
			public void componentHidden(ComponentEvent e){}
			public void componentMoved(ComponentEvent e){}
			public void componentShown(ComponentEvent e){}
		    public void componentResized(ComponentEvent e) {
		        ((Fenetre)e.getSource()).majTaille();         
		    }
		});
	}

	public void majTaille(){
		// On laisse le temps à la fenêtre de se redimensionner
		try{
			Thread.sleep(50);
		} catch(InterruptedException e){
			System.out.println("Erreur au sleep de Partie.java");
		}
		// On met à jour les blocs dans la fenêtre
		int tailleX = this.getContentPane().getWidth();
		int tailleY = this.getContentPane().getHeight();
		int largeurGauche = ((int)(tailleY*0.5)>tailleX-tailleY)?(int)(tailleY*0.5):tailleX-tailleY;
		if(largeurGauche>tailleX/2)
			largeurGauche = tailleX/2;
		int taillePlateau = (tailleX-largeurGauche>tailleY)?tailleY:tailleX-largeurGauche;
		gauche.setBounds(0, 0, largeurGauche, tailleY);
		affichagePlateau.setBounds(largeurGauche, (tailleY-taillePlateau)/2, taillePlateau, taillePlateau);

		this.invalidate();
		this.validate();
		this.repaint();
		
		// On laisse le temps aux blocs de se placer
		try{
			Thread.sleep(50);
		} catch(InterruptedException e){
			System.out.println("Erreur au sleep de Partie.java");
		}
		
		// On met à jour le bloc de sélection de pièces
		tailleX = (int)this.selectionPieces.getSize().getWidth();
		tailleY = (int)this.selectionPieces.getSize().getHeight();

		// On calcul la taille d'un carré et on redimensionne la matrice
		int tailleCarree = (tailleY/17>tailleX/13)?tailleX/13:tailleY/17;
		this.affichagePieces.setBounds((tailleX-(tailleCarree*13))/2, (tailleY-(tailleCarree*17))/2, tailleCarree*13, tailleCarree*17);
		this.affichagePieces.revalidate();
		this.affichagePieces.repaint();

		// On met à jour les icones des boutons
		this.affichageBoutons.majTaille();

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
