import Model.*;
import View.*;
import Control.*;

/**
 * Implémentation :
 *  - Classe Menu
 *  - Classe AfficherMenu
 *  - Classe AfficherChargement
 *  - Classe EvenementBoutonMenu
 *  - Classe Bouton
 *  - Méthode statique "partieExiste()"
 * 
 * Tests :
 *  - Création d'un menu et retour de tous les paramètres pour la création d'une partie
 *  - Création d'un menu de chargement et retour du numéro d'une partie à charger
 *  - Annulation des deux menus et arrêt du programme
 *  - Annulation du menu de chargement et réouverture de ce dernier (Plusieurs fois)
 */
public class TestMenu {
	private Menu menu;
	private int ret;

	/**
	 * Lance la procédure de test
	 */
	public TestMenu() {
		// On crée le menu et on récupère ses valeurs
		this.menu = new Menu();

		// On tente d'ouvrir la fenêtre
		this.ret = menu.afficherMenu();
		// Arrêt du programme
		if(ret == -2)
			System.out.println("L'utilisateur a quitté");
		// Création d'une partie
		else if(ret == -1)
			System.out.println("L'utilisateur crée une nouvelle partie");
		// Chargement d'une partie
		else
			System.out.println("Tentative de chargement de la partie numéro "+ret);
	}

	public Menu getMenu(){
		return this.menu;
	}

	public int getRet(){
		return this.ret;
	}

}