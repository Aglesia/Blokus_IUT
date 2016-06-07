import Model.*;
import View.*;
import Control.*;

/**
 * Implémentation :
 *  - Plateau.java
 *  - Joueur.java
 *  - 
 * 
 * Tests :
 *  - Crée une nouvelle partie à partir des données du menu
 *  - Crée tous les joueurs de la partie
 *  - Crée le plateau de la partie
 */
public class TestPartie {
	private Partie partie;

	/**
	 * Lance la procédure de test
	 */
	public TestPartie(Menu menu) {
		// On affiche les paramètres de la partie
		System.out.println("Paramètres par défaut :\nNb joueurs : "+menu.getNombreJoueurs());
		System.out.println("Taille du plateau : "+menu.getTaille());
		String nomsJoueurs = "";
		String couleursJoueurs = "";
		for(int i=0; i<4; i++){
			nomsJoueurs+=i+" : "+menu.getNoms()[i]+"\n";
			couleursJoueurs+=i+" : "+menu.getCouleurs()[i].toString()+"\n";
		}
		System.out.println("\nNoms des joueurs :\n"+nomsJoueurs+"\nCouleurs :\n"+couleursJoueurs);

		this.partie = new Partie(menu);
	}

	public Partie getPartie(){
		return this.partie;
	}

}