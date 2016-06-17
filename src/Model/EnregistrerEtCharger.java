package Model;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * Permet d'enregistrer et de charger une partie.
 * Les méthodes statiques permettent d'enregistrer une partie, ou d'en ouvrir une.
 * Le reste de la classe est l'objet qui contient toutes les infos de la partie, et qui est enregistré dans un fichier binaire.
 * Pour charger une partie, il faut l'ouvrir via la méthode statique, puis la charger via la méthode de l'objet.
 */
public class EnregistrerEtCharger implements Serializable{

	/**
	 * Partie à charger
	 */
	private Partie partie;

	/**
	 * Permet d'enregistrer la partie en cours, pour la reprendre plus tard.
	 * @param numero Numéro sous lequel enregistrer la partie
	 * @param partie Partie en cours
	 */
	public static void enregistrer(int numero, Partie partie) {
		EnregistrerEtCharger objet = new EnregistrerEtCharger(partie);
		ObjectOutputStream fichier = null;
		try{
			fichier = new ObjectOutputStream(new FileOutputStream("../data/saves/"+numero+".save"));
			fichier.writeObject(objet);
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				if (fichier != null) {
					fichier.flush();
					fichier.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Ouvre une partie enregistrée et retour son objet EnregistrerEtCharger. Peut retourner null si la partie n'est pas trouvée
	 * @param      numero  Le numéro de la partie à charger
	 */
	public static EnregistrerEtCharger ouvrir(int numero){
		EnregistrerEtCharger objet = null;
		ObjectInputStream fichier = null;
		try{
			fichier = new ObjectInputStream(new FileInputStream("../data/saves/"+numero+".save"));
			objet = (EnregistrerEtCharger)fichier.readObject();
		} catch(FileNotFoundException e){
			fichier = null;
		} catch(ClassNotFoundException e){
			System.out.println("Le fichier de sauvegarde n'est pas valide");
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				if (fichier != null)
					fichier.close();
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
		return objet;
	}

	/**
	 * Crée un objet EnregistrerEtCharger, permettant ensuite de charger la partie qu'il contient, ou d'afficher les infos de cette dernière
	 * @param partie Partie chargée, à mettre dans l'objet
	 */
	public EnregistrerEtCharger(Partie partie) {
		this.partie = partie;
	}

	/**
	 * Place la partie ouverte en tant que partie en cours (Charge la partie)
	 */
	public Partie charger() {
		return this.partie;
	}

	/**
	 * Formate un texte permettant de visualiser les infos générales de la partie ouverte
	 *  - Nombre de joueurs et taille du plateau
	 *  - Noms, couleurs et points des joueurs
	 */
	public String toString() {
		Menu menu = this.partie.getMenu();
		int meilleur = 0;
		for(int i=0; i<4; i++)
			if(this.partie.getJoueurs()[i].getNombrePoints()>meilleur)
				meilleur = this.partie.getJoueurs()[i].getNombrePoints();
		return menu.getNombreJoueurs()+" joueurs, plateau de "+menu.getTaille()+"*"+menu.getTaille()+"\nNombre de points du meilleur joueur : "+meilleur;
	}

	/**
	 * Indique si une partie existe à l'emplacement choisi
	 * @param numero Emplacement à vérifier
	 */
	public static boolean partieExiste(int numero) {
		return (EnregistrerEtCharger.ouvrir(numero)!=null);
	}

}