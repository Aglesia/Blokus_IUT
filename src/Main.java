import Model.*;
import View.*;
import Control.*;

/**
 * Classe principale, charge le programme et lance le jeu
 */
public class Main {

	/**
	 * Lanceur principale, ouvre le menu, charge/crée une partie et lance le jeu à partir de ce menu (ou le quitte)
	 * @param args Arguments envoyés au programme
	 */
	public static void main(String[] args) {
		boolean continuer = true;
		Menu menu = new Menu();
		while(continuer){
			Partie partie = null;
			int numero = menu.afficherMenu();
			switch(numero){
				case -1:
					partie = new Partie(menu);
					break;

				case -2:
					return;

				default:
					partie = EnregistrerEtCharger.ouvrir(numero).charger();
				break;
			}

			Fenetre fenetre = new Fenetre(partie, EnsemblePieces.pieces(), 1000, 700);

			while(partie.partieTerminee()==0)
				partie.jouer(fenetre);
			fenetre.maj(partie.getJoueurActuel());
			if(partie.partieTerminee()!=4)
				new AfficherGagnant(partie.partieEstGagnee());
			fenetre.dispose();
			if(partie.partieTerminee()>2)
				continuer = false;
		}
	}
}