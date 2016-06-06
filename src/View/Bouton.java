package View;

/**
 * Gère tous les boutons des menus, du plateau et des pièces
 */
public class Bouton {

	/**
	 * Crée un bouton avec ses différents paramètres
	 * @param nom Nom du bouton, n'est pas affiché mais utilisé par le programme
	 * @param texte Texte affiché sur le bouton
	 * @param image Icône à afficher sur le bouton
	 * @param listener Ecouteur à placer sur le bouton
	 * @param police Police à utiliser sur le texte du bouton
	 */
	public Bouton(String nom, String texte, ImageIcon image, ActionListener listener, Font police) {
		// TODO - implement Bouton.Bouton
		throw new UnsupportedOperationException();
	}

	/**
	 * retourne le nom du bouton (Pas son texte affiché)
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Nom du bouton, utilisé par le programme
	 */
	private String nom;

}