import Model.*;
import View.*;
import Control.*;

/**
 * Implémentation :
 *  - Fenetre.java
 *  - 
 * 
 * Tests :
 *  - Crée une nouvelle fenêtre avec les pièces placées pour lé sélection
 */
public class TestFenetre {
	private Partie partie;

	/**
	 * Lance la procédure de test
	 */
	public TestFenetre(Partie partie) {
		// On crée la fenêtre
		Fenetre fenetre = new Fenetre(partie, EnsemblePieces.pieces());
	}

}