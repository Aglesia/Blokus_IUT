package Model;
import View.Fenetre;
import java.awt.Color;
import View.AfficherEnregistrement;
import java.io.Serializable;

/**
 * Gère la partie en cours, contient les différentes données de la partie et lance les différents tours
 */
public class Partie implements Serializable{

	/**
	 * Plateau de la partie, sur lequel il y a les pièces posées
	 */
	private Plateau plateau;
	/**
	 * Les différents joueurs de la partie
	 */
	private Joueur[] joueurs;
	/**
	 * Le menu de la partie, à savoir tous les paramètres entrés par les joueurs avant de lancer la partie (taille de la grille, couleurset noms des joueurs, nombre de joueurs...)
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
	 * Indique si la partie est finie ou à recommencer
	 */
	private int partieFinie;
	/**
	 * Fenêtre d'enregistrement si elle est ouverte
	 */
	private AfficherEnregistrement enregistrer;

	/**
	 * Crée une nouvelle partie, à partir des paramètres envoyés (le Menu)
	 * @param menu Paramètres de la partie, paramétrés depuis le menu principal
	 */
	public Partie(Menu menu) {
		this.plateau = new Plateau(menu.getTaille(), new Color(90, 90, 90));
		this.nbJoueurs = menu.getNombreJoueurs();
		this.partieFinie = 0;
		joueurs = new Joueur[4];
		this.menu = menu;
		for(int i=0; i<4; i++){
			int[] pos;
			switch(i){
				case 0:
					pos = new int[]{-1, -1};
				break;

				case 1:
					pos = new int[]{-1, plateau.getTaille()};
				break;

				case 2:
					pos = new int[]{plateau.getTaille(), plateau.getTaille()};
				break;

				default:
					pos = new int[]{plateau.getTaille(), -1};
				break;
			}
			if(i<nbJoueurs)
				joueurs[i] = new Joueur(menu.getNoms()[i], menu.getCouleurs()[i], pos);
			else
				joueurs[i] = new Bot(menu.getNoms()[i], menu.getCouleurs()[i], pos);
		}
		pieceSelectionee = null;
		joueurActuel = joueurs[3];
		this.piecePlacee = false;
		this.enregistrer = null;
	}

	/**
	 * Lance un nouveau tour :
	 *  - Prépare le nouveau tour
	 *  - Attend que la pièce ai été placée/le tour a été passé
	 */
	public void jouer(Fenetre fenetre) {
		if(this.enregistrer != null){
			System.out.println(enregistrer.getNumero());
			if(enregistrer.getNumero()==-2){
				enregistrer.dispose();
				enregistrer = null;
			}
			else if(enregistrer.getNumero()>-1){
				EnregistrerEtCharger.enregistrer(enregistrer.getNumero(), this);
				enregistrer.dispose();
				enregistrer = null;
			}

			try{
				Thread.sleep(10);
			} catch(InterruptedException e){
				System.out.println("Erreur au sleep de Partie.java");
			}
		}
		else{
			System.out.println("Tour suivant");
			this.preparerTourSuivant(fenetre);
			System.out.println("Joueur actuel = "+this.joueurActuel.getNom());
			this.piecePlacee = joueurActuel.jouer(fenetre, this);
			while(!piecePlacee){
				try{
					Thread.sleep(10);
				} catch(InterruptedException e){
					System.out.println("Erreur au sleep de Menu.java");
				}
			}
			// On regarde si la fenêtre de chargement est ouverte. Si oui, on annule le tour
			if(this.enregistrer!=null){
				// On annule la sélection de la pièce
				this.pieceSelectionee = null;
				this.piecePlacee = false;
				fenetre.maj(this.joueurActuel);

				// On remet le joueur précédent
				for(int i=0; i<4; i++)
					if(joueurs[i]==joueurActuel){
						if(i>0)
							joueurActuel = joueurs[i-1];
						else
							joueurActuel = joueurs[3];
						i=4;
					}
				// On met à jour l'affichage
				fenetre.getPanelPieces().viderGrille();
			}
			// On vérifie que le joueur peut encore jouer
			boolean resteDesPieces = false;
			for(Piece piece : joueurActuel.getPieces())
				if(piece != null)
					if(piece.getPosition()[0]==-10 && piece.getPosition()[1]==-10)
						resteDesPieces=true;
			if(!resteDesPieces)
				joueurActuel.abandonner();
			
			this.pieceSelectionee = null;
		}
	}

	/**
	 * Prépare le tour suivant :
	 *  - Met à jour l'affichage de la fenêtre
	 *  - Vide la pièce sélectionnée
	 *  - Met à 0 le tour actuel (pièce sélectionnée, etc...)
	 */
	public void preparerTourSuivant(Fenetre fenetre) {
		System.out.println("Nouveau tour");
		//On change de joueur
		for(int i=0; i<4; i++)
			if(joueurs[i]==joueurActuel){
				if(i<3)
					joueurActuel = joueurs[i+1];
				else
					joueurActuel = joueurs[0];
				i=4;
			}
		// On remet tout à 0
		this.pieceSelectionee = null;
		this.piecePlacee = false;
	}

	/**
	 * Retourne le joueur actuel
	 */
	public Joueur getJoueurActuel() {
		return this.joueurActuel;
	}

	/**
	 * Retourne la liste des joueurs qui ont gagné la partie si la partie est finie, ou null sinon
	 * Partie terminée quand :
	 *  - Plus personne ne peut placer de pièce
	 *  - Toutes les pièces ont été posées
	 */
	public Joueur[] partieEstGagnee() {
		Joueur gagnant = null;
		boolean gagne = true;
		for(int i=0; i<4; i++){
			if(joueurs[i]!=null){
				if(!joueurs[i].aAbandonne())
					gagne = false;
				if(gagnant==null)
					gagnant = joueurs[i];
				else if(gagnant.getNombrePoints()<joueurs[i].getNombrePoints())
					gagnant = joueurs[i];
			}
		}

		int nbGagnants = 0;
			for(int i=0; i<4; i++)
				if(joueurs[i].getNombrePoints()==gagnant.getNombrePoints())
					nbGagnants++;

		Joueur[] gagnants = new Joueur[nbGagnants];
		int temp = 0;
			for(int i=0; i<4; i++)
				if(joueurs[i].getNombrePoints()==gagnant.getNombrePoints())
					gagnants[temp++] = joueurs[i];

		return (gagne)?gagnants:null;
	}

	/**
	 * Indique si la partie est finie. Retourne 0 si non, 1 un joueur a gagné, 2 si le joueur recommence une nouvelle partie, 3 pour quitter
	 */
	public int partieTerminee(){
		if(this.partieEstGagnee()!=null)
			this.partieFinie = 1;
		return this.partieFinie;
	}

	/**
	 * Enregistre la partie si le joueur le veut
	 */
	public void enregistrer(){
		this.enregistrer = new AfficherEnregistrement();
		this.piecePlacee = true;
	}

	/**
	 * indique au Main qu'on doit recommencer une nouvelle partie
	 */
	public void recommencer(){
		this.partieFinie = 2;
	}

	/**
	 * Indique au Main qu'on veut quitter
	 */
	public void quitter(){
		this.partieFinie = 3;
	}

	/**
	 * Indique au Main qu'on veut quitter d'urgence
	 */
	public void quitterWarning(){
		this.partieFinie = 4;
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
	public Joueur[] getJoueurs() {
		return this.joueurs;
	}

	/**
	 * Indique que la pièce a été placée
	 */
	public void pieceEstPlacee() {
		this.piecePlacee = true;
	}

	/**
	 * Change la pièce qui est sélectionnée
	 */
	public void selectionnerPiece(Piece piece){
		this.pieceSelectionee = piece;
	}

	/**
	 * Retourne la pièce actuellement sélectionnée
	 */
	public Piece getPieceSelectionnee(){
		return this.pieceSelectionee;
	}

	/**
	 * retourne les paramètres de la partie
	 */
	public Menu getMenu() {
		return this.menu;
	}

}