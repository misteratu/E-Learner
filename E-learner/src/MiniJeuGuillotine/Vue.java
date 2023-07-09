package MiniJeuGuillotine;
import VueControleur.Menus.Menus;

import javax.swing.JFrame;

/**
 * Classe représentant la vue principale de l'application.
 */
public class Vue extends JFrame{
	
    private JFrame fenetre;
    Scene scene;
    Controlleur controlleur;

	/**
     * Construit un objet Vue pour le jeu de la guillotine.
     * Initialise la fenêtre principale du jeu avec ses paramètres.
     */
    public Vue() {
        fenetre = new JFrame("Jeu de la guillotine");
        
        // Définition de l'opération à effectuer lorsque la fenêtre est fermée
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Définition de la taille de la fenêtre en pixels (largeur x hauteur)
        fenetre.setSize(950, 700);
        
        // Positionnement de la fenêtre au centre de l'écran
        fenetre.setLocationRelativeTo(null);
        
        scene = new Scene(this);
    	this.controlleur = new Controlleur(scene);
    	this.updateScene();
    }

    /**
     * Retourne la fenêtre principale de l'application.
     *
     * @return La fenêtre principale de l'application.
     */
    public JFrame getFenetre() {
        return fenetre;
    }
    
    /**
	 * Met à jour la scène du jeu avec de nouvelles données.
	 *
	 */
	public void updateScene() {


	    // Crée une nouvelle instance de la scène avec les nouvelles données
	    scene = new Scene(controlleur, this);

	    // Définit la scène comme contenu de la fenêtre principale
	    fenetre.setContentPane(scene);

	    // Rend la fenêtre principale visible
	    fenetre.setVisible(true);
		if(controlleur.isOk() == false){
			this.dispose();
			Menus example = new Menus(false);
		}

	}
}
