package Model;
import java.awt.Color;
import View.Fenetre;

public class Bot extends Joueur{
	/**
	 * Crée un nouveau bot avec un nom et une couleur
	 * @param nom Nom du joueur
	 * @param couleur Couleur du joueur et de ses pièces
	 * @param positionDepart Position de la première pièce que le joueur peut poser
	 */
	public Bot(String nom, Color couleur, int[] positionDepart){
		super(nom, couleur, positionDepart);
	}

	/**
	 * Jouer en tant que BOT (IA), placer une pièce ou abandonner
	 * @param      fenetre  La fenêtre du jeu, non utilisé ici
	 * @param      partie   La partie en cours, utilisé par l'IA
	 *
	 * @return     toujours true pour indiquer que l'IA a joué
	 */
	public boolean jouer(Fenetre fenetre, Partie partie){
		// On fait abandonner le joueur pour éviter les bugs tant que la méthode n'est pas faite
		this.abandonner();
		return true;
	}
}