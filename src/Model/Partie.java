package Model;
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
		for(int i=0; i<nbJoueurs; i++){
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
			joueurs[i] = new Joueur(menu.getNoms()[i], menu.getCouleurs()[i], pos);
		}
		for(int i=nbJoueurs; i<4; i++)
			joueurs[i] = null;
		pieceSelectionee = null;
		joueurActuel = joueurs[0];
		this.piecePlacee = false;
	}

	/**
	 * Lance un nouveau tour :
	 *  - Prépare le nouveau tour
	 *  - Vide la pièce sélectionnée
	 *  - Attend qu'une pièce ai été sélectionnée
	 *  - Calcul toutes positions possibles pour cette pièce
	 *         - Si aucune position n'est possible, saute le tour du joueur
	 *  - Attend que la pièce ai été placée
	 *  - Regarde si un joueur a gagné
	 */
	public void jouer() {
		System.out.println("Partie.jouer non implémenté");
	}

	/**
	 * Prépare le tour suivant :
	 *  - Affiche les points de tous les joueurs
	 *  - Met à jour l'affichage du plateau
	 *  - Change le joueur, et indique le nouveau joueur actuel
	 *  - Active les pièces du joueur actuel et désactive les autres
	 *  - Met à jour l'affichage des pièces
	 */
	public void preparerTourSuivant() {
		System.out.println("Partie.preparerTourSuivant non implémenté");
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
		System.out.println("Partie.partieEstGagnee non implémenté");
		return null;
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