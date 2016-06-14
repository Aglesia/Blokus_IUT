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
		while(continuer){
			Partie partie = null;
			Menu menu = new Menu();
			switch(menu.afficherMenu()){
				case -1:
					partie = new Partie(menu);
					break;

				case -2:
					return;

				default:
					partie = new Partie(menu); //// A REMPLACER !! ///////////
				break;
			}

			Fenetre fenetre = new Fenetre(partie, EnsemblePieces.pieces());

			while(partie.partieTerminee()==0)
				partie.jouer(fenetre);
			fenetre.dispose();
			new AfficherGagnant(partie.partieEstGagnee());
			if(partie.partieTerminee()==3)
				continuer = false;
		}
	}
}