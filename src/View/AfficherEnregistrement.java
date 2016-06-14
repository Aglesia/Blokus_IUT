package View;
import Control.EvenementBoutonMenuEnregistrement;
import Model.Menu;
import Model.EnregistrerEtCharger;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.*;

/**
 * Ouvre une fenêtre permettant de charger une partie
 */
public class AfficherEnregistrement extends JFrame{

	/**
	 * Boutons droite et gauche pour sélectionner les parties
	 */
	private Bouton gauche;
	private Bouton droite;
	/**
	 * Bouton de validation du choix de la partie à charger.
	 * Peut être verrouillé
	 */
	private Bouton valider;
	/**
	 * Numéro de la partie affichée actuellement
	 */
	private JLabel numeroPartie;
	/**
	 * Première ligne d'infos de la partie sélectionnée
	 */
	private JLabel infosPartie;
	/**
	 * Deuxième ligne d'infos de la partie sélectionnée
	 */
	private JLabel infosPartie2;
	/**
	 * Numéro de la partie
	 */
	private int numero;
	/**
	 * Indique si l'utilisateur a validé
	 */
	private boolean valide;

	/**
	 * Crée une fenêtre pour gérer le chargement d'une partie
	 * @param menu Menu à utiliser pour stocket les données de la fenêtre
	 */
	public AfficherEnregistrement() {
		// On crée les écouteurs
		EvenementBoutonMenuEnregistrement event = new EvenementBoutonMenuEnregistrement(this);
		Font police = new Font("Arial", Font.BOLD, 28);
		// On crée les boutons
		this.valider = new Bouton("Enregistrer", "Enregistrer", null, event, police);
		Bouton retour = new Bouton("Retour", "Retour", null, event, police);
		this.gauche = new Bouton("Gauche", "<--", null, event, police);
		this.droite = new Bouton("Droite", "-->", null, event, police);
		// On crée les JLabel
		this.numeroPartie = new JLabel("SLOT : 0");
		this.infosPartie = new JLabel();
		this.infosPartie2 = new JLabel("SLOT VIDE");
		this.numero = 0;
		this.valide = false;

		// On crée les layouts et les panels
		JPanel fond = new JPanel(new BorderLayout());
		JPanel infos = new JPanel(new GridLayout(3, 0));
		JPanel boutonsSuivantPrecedent = new JPanel(new GridLayout(0, 4));
		JPanel boutonsRetourOk = new JPanel(new GridLayout(0, 2));
		
		// On place les objets sur les panels
		fond.add(infos, BorderLayout.CENTER);
		infos.add(infosPartie);
		infos.add(infosPartie2);
		infos.add(boutonsSuivantPrecedent);
		boutonsSuivantPrecedent.add(gauche);
		boutonsSuivantPrecedent.add(new JLabel());
		boutonsSuivantPrecedent.add(new JLabel());
		boutonsSuivantPrecedent.add(droite);
		fond.add(numeroPartie, BorderLayout.NORTH);
		fond.add(boutonsRetourOk, BorderLayout.SOUTH);
		boutonsRetourOk.add(retour);
		boutonsRetourOk.add(valider);
		
		// On met en page les objets
		this.numeroPartie.setHorizontalAlignment(SwingConstants.CENTER);
		this.infosPartie.setHorizontalAlignment(SwingConstants.CENTER);
		this.infosPartie2.setHorizontalAlignment(SwingConstants.CENTER);
		this.numeroPartie.setFont(police);
		this.infosPartie.setFont(police);
		this.infosPartie2.setFont(police);

		// Si le slot 0 n'est pas disponible, on grise le bouton
		this.valider.setEnabled(!Model.EnregistrerEtCharger.partieExiste(0));
		majDescription();
		
		// On initialise la fenêtre et on l'affiche
		this.setSize(800, 600);
		this.add(fond);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Indique que l'utilisateur a appuyé sur "valider"
	 */
	public void setValide(){
		this.valide = true;
	}

	/**
	 * Indique que l'utilisateur a appuyé sur "Retour"
	 */
	public void setRetour(){
		this.numero = -2;
		this.valide = true;
	}

	/**
	 * Chage le slot par le suivant (va au dernier si besoin)
	 */
	public void slotPrecedent(){
		System.out.println("Slot précédent");
		this.numero--;
		if(this.numero<0)
			this.numero = 9;
		this.numeroPartie.setText("SLOT : "+numero);
		this.valider.setEnabled(!Model.EnregistrerEtCharger.partieExiste(this.numero));
		majDescription();
	}

	/**
	 * Change le slot par le suivant (revient au premier si besoin)
	 */
	public void slotSuivant(){
		System.out.println("Slot suivant");
		this.numero++;
		if(this.numero>9)
			this.numero = 0;
		this.numeroPartie.setText("SLOT : "+numero);
		this.valider.setEnabled(!Model.EnregistrerEtCharger.partieExiste(this.numero));
		majDescription();
	}

	/**
	 * Récupère le numéro entré par l'utilisateur (fonction bloquante)
	 */
	public int getNumero() {
		if(!this.valide)
			return -1;
		return this.numero;
	}

	/**
	 * Met à jour la description de la partie
	 */
	private void majDescription(){
		if(Model.EnregistrerEtCharger.partieExiste(this.numero)){
			EnregistrerEtCharger charge = new EnregistrerEtCharger(this.numero);
			this.infosPartie.setText(charge.toString().substring(0, charge.toString().indexOf("\n")));
			this.infosPartie2.setText(charge.toString().substring(charge.toString().indexOf("\n")));
		}
		else{
			this.infosPartie.setText("");
			this.infosPartie2.setText("SLOT VIDE");
		}
	}

}