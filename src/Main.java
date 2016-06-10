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
		Partie partie = null;
		Menu menu = new Menu();
		switch(menu.afficherMenu()){
			case -1:
				partie = new Partie(menu);
				break;

			case -2:
				return;

			default:
			break;
		}

		Fenetre fenetre = new Fenetre(partie, EnsemblePieces.pieces());

		while(partie.partieEstGagnee()==null)
			partie.jouer(fenetre);
		fenetre.dispose();
		System.out.println("Félicitation à "+partie.partieEstGagnee().getNom()+", avec ses "+partie.partieEstGagnee().getNombrePoints()+" points !!!");
	}

}