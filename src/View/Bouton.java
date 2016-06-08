package View;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Gère tous les boutons des menus, du plateau et des pièces
 */
public class Bouton extends JButton{

	/**
	 * Nom du bouton, utilisé par le programme
	 */
	private String nom;

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
	 * retourne le nom du bouton (Pas son texte affiché)
	 */
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom){
		this.nom = nom;
	}

}