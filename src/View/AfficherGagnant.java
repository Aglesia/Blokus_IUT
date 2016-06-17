package View;
import java.awt.*;
import javax.swing.*;
import Model.Joueur;

/**
 * Fenêtre affichant les noms des gagnants, avec leur score
 */
public class AfficherGagnant extends JFrame{
	/**
	 * Crée la fenêtre et affiche les noms des gagnants et le score
	 * @param      joueurs  Liste des joueurs gagnants
	 */
	public AfficherGagnant(Joueur[] joueurs){
		String ligne = "Bravo à tous, vous n'êtes pas cappable de gagner une partie ;)";
		if(joueurs!=null){
			ligne = "Félicitation à ";
			switch(joueurs.length){
				case 1:
					ligne += joueurs[0].getNom()+", avec tes ";
					break;

				case 2:
					ligne += joueurs[0].getNom()+" et ";
					ligne += joueurs[1].getNom();
					ligne += ", avec vos ";
					break;

				case 3:
					ligne += joueurs[0].getNom()+", ";
					ligne += joueurs[1].getNom()+" et ";
					ligne += joueurs[2].getNom();
					ligne += ", avec vos ";
					break;

				default :
					ligne += "tout le monde, avec vos ";
			}
			ligne += joueurs[0].getNombrePoints()+" points !!!";
		}

		JOptionPane.showMessageDialog(this, ligne);
	}
}