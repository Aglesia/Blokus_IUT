package View;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Control.EvenementSouris;

/**
 * Gère tous les boutons des menus, du plateau et des pièces
 */
public class Bouton extends JButton{

	/**
	 * Nom du bouton, utilisé par le programme
	 */
	private String nom;
	/**
	 * Gestion des évènements de la souris
	 */
	private EvenementSouris mouse;

	/**
	 * Crée un bouton avec ses différents paramètres
	 * @param nom Nom du bouton, n'est pas affiché mais utilisé par le programme
	 * @param texte Texte affiché sur le bouton
	 * @param image Icône à afficher sur le bouton
	 * @param listener Ecouteur à placer sur le bouton
	 * @param police Police à utiliser sur le texte du bouton
	 * @param mouse Gère les évènements de la souris
	 */
	public Bouton(String nom, String texte, ImageIcon image, ActionListener listener, Font police, EvenementSouris mouse) {
		this.nom = nom;
		
		// On y associe le texte
		if(texte != null)
			this.setText(texte);
		
		// On y associe l'image
		if(image != null)
			this.setIcon(image);
		
		// On y associe l'évènement
		if(listener != null)
			this.addActionListener(listener);

		if(police != null)
			this.setFont(police);

		// On associe l'évènement souris
		this.mouse = mouse;
		this.addMouseListener(mouse);
	}

	/**
	 * Crée un bouton avec ses différents paramètres
	 * @param nom Nom du bouton, n'est pas affiché mais utilisé par le programme
	 * @param texte Texte affiché sur le bouton
	 * @param image Icône à afficher sur le bouton
	 * @param listener Ecouteur à placer sur le bouton
	 * @param police Police à utiliser sur le texte du bouton
	 */
	public Bouton(String nom, String texte, ImageIcon image, ActionListener listener, Font police) {
		this.nom = nom;
		
		// On y associe le texte
		if(texte != null)
			this.setText(texte);
		
		// On y associe l'image
		if(image != null)
			this.setIcon(image);
		
		// On y associe l'évènement
		if(listener != null)
			this.addActionListener(listener);

		if(police != null)
			this.setFont(police);
	}

	/**
	 * Définit la position de la pièce à placer si on clique sur ce bouton (utilisé par AfficherPlateau)
	 * @param      position  La position de la pièce associée
	 */
	public void setPositionSourisListener(int[] position){
		if(this.mouse != null)
			this.mouse.setPosition(position);
	}

	/**
	 * retourne le nom du bouton (Pas son texte affiché)
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Change le nom du bouton
	 */
	public void setNom(String nom){
		this.nom = nom;
	}

	/**
	 * récupère la position de la pièce à placer si on clique sur ce bouton (utilisé par AfficherPlateau)
	 */
	public int[] getPosition(){
		int x = Integer.parseInt(this.getNom().substring(0, this.getNom().indexOf("|")));
		int y = Integer.parseInt(this.getNom().substring(this.getNom().indexOf("|")+1));
		return new int[]{x, y};
	}

}