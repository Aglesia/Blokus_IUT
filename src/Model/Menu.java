package Model;
import View.*;
import java.awt.Color;
import java.io.Serializable;

/**
 * Stocke les différents paramètres de la partie, et affiche un menu permettant de les modifier
 */
public class Menu implements Serializable{

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
	 * Fenêtre de chargement, si elle existe
	 */
	private AfficherChargement fenetreChargement;

	/**
	 * Crée un nouveau menu avec des valeurs par défaut
	 */
	public Menu() {
		this.nombreJoueurs = 4;
		this.couleurs = new Color[4];
		this.noms = new String[4];
		this.tailleGrille = 20;
		this.menuAffiche = false;
		this.chargementAffiche = false;
		this.valeurChargement = -2;
		for(int i=0; i<4; i++)
			noms[i] = new String("Joueur "+(i+1));
		this.couleurs[0] = Color.RED;
		this.couleurs[1] = Color.GREEN;
		this.couleurs[2] = Color.BLUE;
		this.couleurs[3] = Color.YELLOW;
	}

	/**
	 * Affiche un menu permettant de modifier les paramètres de la partie, ou de charger une partie déjà existante
	 * @return -1 si le menu est à utiliser, un nombre >= 0 si une partie est à charger, -2 si on doit quitter
	 */
	public int afficherMenu() {
		AfficherMenu fenetreMenu = new AfficherMenu(this);
		this.menuAffiche = true;
		while(menuEstOuvert()){
			if(fenetreChargementEstOuverte()){
				while(fenetreChargementEstOuverte());
				fenetreChargement.dispose();
				fenetreChargement = null;
			}
		}
		// On récupère les paramètres
		this.couleurs[0] = fenetreMenu.getCouleurJoueur(1);
		this.couleurs[1] = fenetreMenu.getCouleurJoueur(2);
		this.couleurs[2] = fenetreMenu.getCouleurJoueur(3);
		this.couleurs[3] = fenetreMenu.getCouleurJoueur(4);

		this.noms[0] = fenetreMenu.getNomJoueur(1);
		this.noms[1] = fenetreMenu.getNomJoueur(2);
		this.noms[2] = fenetreMenu.getNomJoueur(3);
		this.noms[3] = fenetreMenu.getNomJoueur(4);

		this.nombreJoueurs = fenetreMenu.getNbJoueurs();
		this.tailleGrille = fenetreMenu.getTaillePlateau();

		fenetreMenu.dispose();
		return this.valeurChargement;
	}

	/**
	 * Indique si la fenêtre de menu est ouverte
	 */
	private boolean menuEstOuvert(){
		try{
			Thread.sleep(10);
		} catch(InterruptedException e){
			System.out.println("Erreur au sleep de Menu.java");
		} finally {
			return this.menuAffiche;
		}
	}

	/**
	 * Indique si la fenêtre de chargement d'une partie est ouverte
	 */
	private boolean fenetreChargementEstOuverte(){
		try{
			Thread.sleep(10);
		} catch(InterruptedException e){
			System.out.println("Erreur au sleep de Menu.java");
		} finally {
			return this.chargementAffiche;
		}
	}

	/**
	 * Ouvre un menu permettant de charger une partie existante. Ne fait rien si elle est déjà ouverte
	 * @return Le numéro de la partie à charger.
	 * -1 si le joueur a annulé ou que la fenêtre est déjà ouverte
	 */
	public void afficherChargementPartie() {
		if(!this.chargementAffiche){
			this.fenetreChargement = new AfficherChargement(this);
			this.chargementAffiche = true;
		}
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
		return this.couleurs;
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
		return this.tailleGrille;
	}

	/**
	 * Indique que la fenêtre de menu a été fermée, et ferme la genêtre graphique
	 * Uniquement si la fenêtre de chargement n'est pas ouverte
	 */
	public void setMenuFerme() {
		if(!this.chargementAffiche)
			this.menuAffiche = false;
	}

	/**
	 * Indique que la fenêtre de chargement a été fermée et ferme la fenêtre graphique
	 * @param valeur Numéro de la partie à charger
	 * -1 si aucune partie n'est à charger (l'utilisateur a annulé)
	 */
	public void setMenuChargementFerme(int valeur) {
		this.valeurChargement = valeur;
		this.chargementAffiche = false;
	}

}