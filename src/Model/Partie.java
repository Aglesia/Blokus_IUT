package Model;
import View.Fenetre;
import java.awt.Color;

/**
 * Gère la partie en cours, contient les différentes données de la partie et lance les différents tours
 */
public class Partie {

	/**
	 * Plateau de la partie, sur lequel il y a les pièces posées
	 */
	private Plateau plateau;
	/**
	 * Les différents joueurs de la partie
	 */
	private Joueur[] joueurs;
	/**
	 * Le menu de la partie, à savoir tous les paramètres entrés par les joueurs avant de lancer la partie (taille de la grille, couleurset noms des joueurs, nombre de joueurs...)
	 */
	private Menu menu;
	/**
	 * Numéro du joueur en cours
	 */
	private Joueur joueurActuel;
	/**
	 * Pièce actuellement sélectionnée pour être placée sur la grille
	 */
	private Piece pieceSelectionee;
	/**
	 * Indique le nombre de joueurs dans cette partie
	 */
	private int nbJoueurs;
	/**
	 * Indique si la pièce en cours a été placée
	 */
	private boolean piecePlacee;

	/**
	 * Crée une nouvelle partie, à partir des paramètres envoyés (le Menu)
	 * @param menu Paramètres de la partie, paramétrés depuis le menu principal
	 */
	public Partie(Menu menu) {
		this.plateau = new Plateau(menu.getTaille(), new Color(42, 42, 42));
		this.nbJoueurs = menu.getNombreJoueurs();
		joueurs = new Joueur[4];
		this.menu = menu;
		for(int i=0; i<4; i++){
			int[] pos;
			switch(i){
				case 0:
					pos = new int[]{-1, -1};
				break;

				case 1:
					pos = new int[]{-1, plateau.getTaille()};
				break;

				case 2:
					pos = new int[]{plateau.getTaille(), plateau.getTaille()};
				break;

				default:
					pos = new int[]{plateau.getTaille(), -1};
				break;
			}
			if(i<nbJoueurs)
				joueurs[i] = new Joueur(menu.getNoms()[i], menu.getCouleurs()[i], pos);
			else
				joueurs[i] = new Bot(menu.getNoms()[i], menu.getCouleurs()[i], pos);
		}
		pieceSelectionee = null;
		joueurActuel = joueurs[nbJoueurs-1];
		this.piecePlacee = false;
	}

	/**
	 * Lance un nouveau tour :
	 *  - Prépare le nouveau tour
	 *  - Attend que la pièce ai été placée/le tour a été passé
	 */
	public void jouer(Fenetre fenetre) {
		System.out.println("Tour suivant");
		this.preparerTourSuivant(fenetre);
		this.piecePlacee = joueurActuel.jouer(fenetre, this);
		while(!piecePlacee){
			try{
				Thread.sleep(10);
			} catch(InterruptedException e){
				System.out.println("Erreur au sleep de Menu.java");
			}
		}
		// On vérifie que le joueur peut encore jouer
		boolean resteDesPieces = false;
		for(Piece piece : joueurActuel.getPieces())
			if(piece != null)
				if(piece.getPosition()[0]==-10 && piece.getPosition()[1]==-10)
					resteDesPieces=true;
		if(!resteDesPieces)
			joueurActuel.abandonner();
		
		this.pieceSelectionee = null;
	}

	/**
	 * Prépare le tour suivant :
	 *  - Met à jour l'affichage de la fenêtre
	 *  - Vide la pièce sélectionnée
	 *  - Met à 0 le tour actuel (pièce sélectionnée, etc...)
	 */
	public void preparerTourSuivant(Fenetre fenetre) {
		System.out.println("Nouveau tour");
		//On change de joueur
		for(int i=0; i<4; i++)
			if(joueurs[i]==joueurActuel){
				if(i<3)
					joueurActuel = joueurs[i+1];
				else
					joueurActuel = joueurs[0];
				i=4;
			}
		// On remet tout à 0
		this.pieceSelectionee = null;
		this.piecePlacee = false;
	}

	/**
	 * Retourne le joueur actuel
	 */
	public Joueur getJoueurActuel() {
		return this.joueurActuel;
	}

	/**
	 * Retourne le joueur qui a gagné la partie si la partie est finie, ou null sinon
	 * Partie terminée quand :
	 *  - Plus personne ne peut placer de pièce
	 *  - Toutes les pièces ont été posées
	 */
	public Joueur partieEstGagnee() {
		Joueur gagnant = null;
		boolean gagne = true;
		for(int i=0; i<4; i++){
			if(joueurs[i]!=null){
				if(!joueurs[i].aAbandonne())
					gagne = false;
				if(gagnant==null)
					gagnant = joueurs[i];
				else if(gagnant.getNombrePoints()<joueurs[i].getNombrePoints())
					gagnant = joueurs[i];
			}
		}

		return (gagne)?gagnant:null;
	}

	/**
	 * Retourne le plateau du jeu
	 */
	public Plateau getPlateau() {
		return this.plateau;
	}

	/**
	 * Retourne la liste des joueurs
	 */
	public Joueur[] getJoueurs() {
		return this.joueurs;
	}

	/**
	 * Indique que la pièce a été placée
	 */
	public void pieceEstPlacee() {
		this.piecePlacee = true;
	}

	/**
	 * Change la pièce qui est sélectionnée
	 */
	public void selectionnerPiece(Piece piece){
		this.pieceSelectionee = piece;
	}

	/**
	 * Retourne la pièce actuellement sélectionnée
	 */
	public Piece getPieceSelectionnee(){
		return this.pieceSelectionee;
	}

	/**
	 * retourne les paramètres de la partie
	 */
	public Menu getMenu() {
		return this.menu;
	}

}