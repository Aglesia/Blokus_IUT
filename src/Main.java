import Model.Partie;

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
		TestMenu test1 = new TestMenu();
		if(test1.getRet()==-1){
			TestPartie test2 = new TestPartie(test1.getMenu());
			partie = test2.getPartie();
		}

		else if(test1.getRet()!=-2){
			TestChargement test3 = new TestChargement(test1.getRet());
			partie = test3.getPartie();
		}

		TestFenetre test4 = new TestFenetre(partie);
	}

}