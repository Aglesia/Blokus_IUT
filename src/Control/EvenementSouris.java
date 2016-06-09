package Control;
import View.AfficherPlateau;
import java.awt.event.*;

public class EvenementSouris implements MouseListener{
	private AfficherPlateau plateau;
	private int[] position;

	public EvenementSouris(AfficherPlateau plateau, int[] position){
		this.plateau = plateau;
		this.position = position;
	}
	public void mouseClicked(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	/**
	 * Invoked when the mouse enters a component.
	 */
	public void mouseEntered(MouseEvent e){
	    plateau.afficherPlacementsPossibles(position);
	}
	/**
	 * Invoked when the mouse exits a component.
	 */
	public void mouseExited(MouseEvent e){
	}

	/**
	 * Change la position de la pièce liée à ce bouton
	 * @param      position  La position de la pièce liée
	 */
	public void setPosition(int[] position){
		this.position = position;
	}
}