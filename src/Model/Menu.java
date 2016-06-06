package Model;

/**
 * Stocke les différents paramètres de la partie, et affiche un menu permettant de les modifier
 */
public class Menu {

	/**
	 * Nombre de joueurs pour cette partie
	 */
	private int nombreJoueurs;
	/**
	 * Couleurs en hexa des différents joueurs
	 */
	private Color[] couleurs;
	/**
	 * Noms des différents joueurs
	 */
	private String[] noms;
	/**
	 * Taille de la grille
	 */
	private int tailleGrille;
	/**
	 * Indique si la fenêtre du menu est ouverte
	 */
	private boolean menuAffiche;
	/**
	 * Indique su une fenêtre de chargement d'une partie existante est ouverte
	 */
	private boolean chargementAffiche;
	/**
	 * Contient le numéro de la partie à charger si l'utilisateur charge une partie
	 */
	private int valeurChargement;

	/**
	 * Crée un nouveau menu avec des valeurs par défaut
	 */
	public Menu() {
		// TODO - implement Menu.Menu
		throw new UnsupportedOperationException();
	}

	/**
	 * Affiche un menu permettant de modifier les paramètres de la partie, ou de charger une partie déjà existante
	 * @return -1 si le menu est à utiliser, un nombre >= 0 si une partie est à charger,  -2 si on doit quitter
	 */
	public int afficherMenu() {
		// TODO - implement Menu.afficherMenu
		throw new UnsupportedOperationException();
	}

	/**
	 * Ouvre un menu permettant de charger une partie existante. Ne fait rien si elle est déjà ouverte
	 * @return Le numéro de la partie à charger.
	 * -1 si le joueur a annulé
	 */
	public int afficherChargementPartie() {
		// TODO - implement Menu.afficherChargementPartie
		throw new UnsupportedOperationException();
	}

	/**
	 * retourne le nombre de joueurs
	 */
	public int getNombreJoueurs() {
		return this.nombreJoueurs;
	}

	/**
	 * Retourne les couleurs des joueurs
	 */
	public Color[] getCouleurs() {
		// TODO - implement Menu.getCouleurs
		throw new UnsupportedOperationException();
	}

	/**
	 * Retourne les noms des joueurs
	 */
	public String[] getNoms() {
		return this.noms;
	}

	/**
	 * retourne la taille de la grille
	 */
	public int getTaille() {
		// TODO - implement Menu.getTaille
		throw new UnsupportedOperationException();
	}

	/**
	 * Indique que la fenêtre de menu a été fermée, et ferme la genêtre graphique
	 * Uniquement si la fenêtre de chargement n'est pas ouverte
	 */
	public void setMenuFerme() {
		// TODO - implement Menu.setMenuFerme
		throw new UnsupportedOperationException();
	}

	/**
	 * Indique que la fenêtre de chargement a été fermée et ferme la fenêtre graphique
	 * @param valeur Numéro de la partie à charger
	 * -1 si aucune partie n'est à charger (l'utilisateur a annulé)
	 */
	public void setMenuChargementFerme(int valeur) {
		// TODO - implement Menu.setMenuChargementFerme
		throw new UnsupportedOperationException();
	}

}