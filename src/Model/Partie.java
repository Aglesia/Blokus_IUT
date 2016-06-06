package Model;

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
	 * Le menu de la partie, à savoir tous les paramètres entrés par les joueurs avant de ancer la partie (taille de la grille, couleurset noms des joueurs, nombre de joueurs...)
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
	 * @param joueurs Paramètres de la partie, paramétrés depuis le menu principal
	 */
	public Partie(Menu joueurs) {
		// TODO - implement Partie.Partie
		throw new UnsupportedOperationException();
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
		// TODO - implement Partie.jouer
		throw new UnsupportedOperationException();
	}

	/**
	 * Prépare le tour suivant :
	 *  - Affiche les points de tous les joueurs
	 *  - Met à jour l'affichage du plateau
	 *  - Change le joueur, et indique le nouveau joueur actuel
	 *  - Active les pièces du joueur actuel et désactive les autres
	 *  - Met à jour l'affichage des pièces
	 */
	public void préparerTourSuivant() {
		// TODO - implement Partie.préparerTourSuivant
		throw new UnsupportedOperationException();
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
		// TODO - implement Partie.partieEstGagnee
		throw new UnsupportedOperationException();
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
	public Joueur[] getjoueurs() {
		return this.joueurs;
	}

	/**
	 * Indique que la pièce a été placée
	 */
	public void pieceEstPlacee() {
		// TODO - implement Partie.pieceEstPlacee
		throw new UnsupportedOperationException();
	}

	/**
	 * retourne les paramètres de la partie
	 */
	public Menu getMenu() {
		return this.menu;
	}

}