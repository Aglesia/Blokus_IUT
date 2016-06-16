package View;
import Model.Menu;
import Control.EvenementBoutonMenu;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Component;
import javax.swing.*;

/**
 * Affiche une fenêtre de menu
 */
public class AfficherMenu extends JFrame{

	/**
	 * Sélection du nombre de joueurs
	 */
	private SpinnerNumberModel nbJoueurs;
	/**
	 * Sélection de la taille du plateau
	 */
	private SpinnerNumberModel taillePlateau;
	/**
	 * Sélection de la couleur du joueur 1
	 */
	private JColorChooser couleurJ1;
	/**
	 * Sélection de la couleur du joueur 2
	 */
	private JColorChooser couleurJ2;
	/**
	 * Sélection de la couleur du joueur 3
	 */
	private JColorChooser couleurJ3;
	/**
	 * Sélection de la couleur du joueur 4
	 */
	private JColorChooser couleurJ4;
	/**
	 * Sélection du nom du joueur 1
	 */
	private JTextField nom1;
	/**
	 * Sélection du nom du joueur 2
	 */
	private JTextField nom2;
	/**
	 * Sélection du nom du joueur 3
	 */
	private JTextField nom3;
	/**
	 * Sélection du nom du joueur 4
	 */
	private JTextField nom4;

	/**
	 * Crée la fenêtre permettant de gérer les menu et les différents paramètres de la partie à créer
	 * @param menu Menu à modifier
	 */
	public AfficherMenu(Menu menu) {
		// On crée les écouteurs
		EvenementBoutonMenu event = new EvenementBoutonMenu(menu, this);
		Font police = new Font("Arial", Font.BOLD, 28);
		// On crée les boutons
		Bouton valider = new Bouton("Valider", "Créer partie", null, event, police);
		Bouton quitter = new Bouton("Quitter", "Quitter le jeu", null, event, police);
		Bouton charger = new Bouton("Charger", "Charger partie", null, event, police);
		// On crée les JSpinner
		nbJoueurs = new SpinnerNumberModel(menu.getNombreJoueurs(), 0, 4, 1);
		taillePlateau = new SpinnerNumberModel(menu.getTaille(), 17, 25, 1);
		JSpinner nombreJoueurs = new JSpinner(nbJoueurs);
		JSpinner tailleDuPlateau = new JSpinner(taillePlateau);
		nombreJoueurs.setFont(police);
		tailleDuPlateau.setFont(police);
		// On crée les JTextField
		nom1 = new JTextField(menu.getNoms()[0]);
		nom2 = new JTextField(menu.getNoms()[1]);
		nom3 = new JTextField(menu.getNoms()[2]);
		nom4 = new JTextField(menu.getNoms()[3]);
		nom1.setFont(police);
		nom2.setFont(police);
		nom3.setFont(police);
		nom4.setFont(police);
		// On crée les JColorChooser
		couleurJ1 = new JColorChooser(menu.getCouleurs()[0]);
		couleurJ2 = new JColorChooser(menu.getCouleurs()[1]);
		couleurJ3 = new JColorChooser(menu.getCouleurs()[2]);
		couleurJ4 = new JColorChooser(menu.getCouleurs()[3]);

		// On applique un Dark theme
		Color couleurFond = new Color(69, 69, 69);
		Color couleurTexte = new Color(242, 242, 242);
		valider.setBackground(couleurFond);
		valider.setForeground(couleurTexte);
		quitter.setBackground(couleurFond);
		quitter.setForeground(couleurTexte);
		charger.setBackground(couleurFond);
		charger.setForeground(couleurTexte);
		nombreJoueurs.setBackground(couleurFond);
		nombreJoueurs.setForeground(couleurTexte);
		tailleDuPlateau.setBackground(couleurFond);
		tailleDuPlateau.setForeground(couleurTexte);
		nom1.setBackground(couleurFond);
		nom1.setForeground(couleurTexte);
		nom2.setBackground(couleurFond);
		nom2.setForeground(couleurTexte);
		nom3.setBackground(couleurFond);
		nom3.setForeground(couleurTexte);
		nom4.setBackground(couleurFond);
		nom4.setForeground(couleurTexte);
		nom1.setHorizontalAlignment(JLabel.CENTER);
		nom2.setHorizontalAlignment(JLabel.CENTER);
		nom3.setHorizontalAlignment(JLabel.CENTER);
		nom4.setHorizontalAlignment(JLabel.CENTER);

		int n = nombreJoueurs.getComponentCount();
	    for (int i=0; i<n; i++)
	    {
	        Component c = nombreJoueurs.getComponent(i);
            c.setForeground(couleurTexte);
            c.setBackground(couleurFond);
	    }

	    n = tailleDuPlateau.getComponentCount();
	    for (int i=0; i<n; i++)
	    {
	        Component c = tailleDuPlateau.getComponent(i);
            c.setForeground(couleurTexte);
            c.setBackground(couleurFond);
	    }

		// On crée la fenêtre
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setBackground(couleurFond);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// On crée les panels
		JPanel fond = new JPanel(new BorderLayout());
		JPanel boutons = new JPanel(new BorderLayout());
		JPanel boutonsBas = new JPanel(new GridLayout(0, 2));
		JPanel haut = new JPanel(new GridLayout(0, 2));

		fond.setBackground(couleurFond);
		fond.setForeground(couleurTexte);
		boutons.setBackground(couleurFond);
		boutons.setForeground(couleurTexte);
		boutonsBas.setBackground(couleurFond);
		boutonsBas.setForeground(couleurTexte);
		haut.setBackground(couleurFond);
		haut.setForeground(couleurTexte);

		// On remplie les panels
		fond.add(haut, BorderLayout.CENTER);
		fond.add(boutons, BorderLayout.SOUTH);
		boutons.add(charger, BorderLayout.NORTH);
		boutons.add(boutonsBas, BorderLayout.CENTER);
		boutonsBas.add(quitter);
		boutonsBas.add(valider);
		JComponent temp = new JLabel("Nombre de joueurs : ");
		temp.setBackground(couleurFond);
		temp.setForeground(couleurTexte);
		temp.setFont(police);
		haut.add(temp);
		haut.add(nombreJoueurs);
		temp = new JLabel("Taille du plateau : ");
		temp.setBackground(couleurFond);
		temp.setForeground(couleurTexte);
		temp.setFont(police);
		haut.add(temp);
		haut.add(tailleDuPlateau);
		temp = new JLabel("Nom joueur 1");
		temp.setBackground(couleurFond);
		temp.setForeground(couleurTexte);
		temp.setFont(police);
		haut.add(temp);
		haut.add(nom1);
		temp = new JLabel("Nom joueur 2");
		temp.setBackground(couleurFond);
		temp.setForeground(couleurTexte);
		temp.setFont(police);
		haut.add(temp);
		haut.add(nom2);
		temp = new JLabel("Nom joueur 3");
		temp.setBackground(couleurFond);
		temp.setForeground(couleurTexte);
		temp.setFont(police);
		haut.add(temp);
		haut.add(nom3);
		temp = new JLabel("Nom joueur 4");
		temp.setBackground(couleurFond);
		temp.setForeground(couleurTexte);
		temp.setFont(police);
		haut.add(temp);
		haut.add(nom4);
		temp = new JLabel("Couleur joueur 1");
		temp.setBackground(couleurFond);
		temp.setForeground(couleurTexte);
		temp.setFont(police);
		haut.add(temp);
		temp = new Bouton("Couleur1", "Changer Couleur", null, event, police);
		temp.setBackground(couleurFond);
		temp.setForeground(couleurJ1.getColor());
		temp.setFont(police);
		haut.add(temp);
		temp = new JLabel("Couleur joueur 2");
		temp.setBackground(couleurFond);
		temp.setForeground(couleurTexte);
		temp.setFont(police);
		haut.add(temp);
		temp = new Bouton("Couleur2", "Changer Couleur", null, event, police);
		temp.setBackground(couleurFond);
		temp.setForeground(couleurJ2.getColor());
		temp.setFont(police);
		haut.add(temp);
		temp = new JLabel("Couleur joueur 3");
		temp.setBackground(couleurFond);
		temp.setForeground(couleurTexte);
		temp.setFont(police);
		haut.add(temp);
		temp = new Bouton("Couleur3", "Changer Couleur", null, event, police);
		temp.setBackground(couleurFond);
		temp.setForeground(couleurJ3.getColor());
		temp.setFont(police);
		haut.add(temp);
		temp = new JLabel("Couleur joueur 4");
		temp.setBackground(couleurFond);
		temp.setForeground(couleurTexte);
		temp.setFont(police);
		haut.add(temp);
		temp = new Bouton("Couleur4", "Changer Couleur", null, event, police);
		temp.setBackground(couleurFond);
		temp.setForeground(couleurJ4.getColor());
		temp.setFont(police);
		haut.add(temp);
		this.add(fond);
	}

	/**
	 * Retourne un colorChooser pour y changer la couleur
	 * @param      numero  Le numéro du joueur qui change sa couleur
	 */
	public JColorChooser changerCouleur(int numero){
		switch(numero){
			case 1:
				return this.couleurJ1;

			case 2:
				return this.couleurJ2;

			case 3:
				return this.couleurJ3;

			case 4:
				return this.couleurJ4;

			default:
				return null;
		}
	}

	/**
	 * Retourne la couleur du joueur sélectionné
	 * @param numero Numéro du joueur
	 */
	public Color getCouleurJoueur(int numero) {
		switch(numero){
			case 1:
				return this.couleurJ1.getColor();

			case 2:
				return this.couleurJ2.getColor();

			case 3:
				return this.couleurJ3.getColor();

			case 4:
				return this.couleurJ4.getColor();

			default:
				return null;
		}
	}

	/**
	 * Retourne le nombre de joueurs
	 */
	public int getNbJoueurs() {
		return this.nbJoueurs.getNumber().intValue();
	}

	/**
	 * Retourne le nom du joueur sélectionné
	 * @param numero Numéro du joueur
	 */
	public String getNomJoueur(int numero) {
		switch(numero){
			case 1:
				return this.nom1.getText();

			case 2:
				return this.nom2.getText();

			case 3:
				return this.nom3.getText();

			case 4:
				return this.nom4.getText();

			default:
				return null;
		}
	}

	/**
	 * Retourne la taille du plateau
	 */
	public int getTaillePlateau() {
		return this.taillePlateau.getNumber().intValue();
	}

}