package Control;
import View.AfficherPlateau;
import java.awt.event.*;

/**
 * Affiche une prévisualisation du placement de la pièce quand la souris passe sur une nouvelle case
 */
public class EvenementSouris implements MouseListener{
	private AfficherPlateau plateau;
	private int[] position;

	/**
	 * Crée un évènement souris, permettant la prévisualisation du placement de la pièce
	 * @param      plateau   Le plateau sur lequel placer la pièce
	 * @param      position  La position de la case à vérifier (x et y)
	 */
	public EvenementSouris(AfficherPlateau plateau, int[] position){
		this.plateau = plateau;
		this.position = position;
	}
	public void mouseClicked(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	/**
	 * Met à jour l'affichage de la position de la pièce, quand la souris rentre dans une nouvelle case
	 */
	public void mouseEntered(MouseEvent e){
	    plateau.afficherPlacementsPossibles(position);
	}

	/**
	 * Change la position de la pièce liée à ce bouton
	 * @param      position  La position de la pièce liée
	 */
	public void setPosition(int[] position){
		this.position = position;
	}
}