package MiniJeuGuillotine;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe représentant la scène du jeu.
 */
public class Scene extends JPanel {
	
	// Image du fond.
	private ImageIcon icoFond; 
	private Image imgFond;
	
	// Image de la guillotine.
	private ImageIcon icoguillotine;
	private Image imgguillotine;
	
	// Image de la validation de la réponse.
	private ImageIcon icoRetour;
	private Image imgRetour;
	
	// Affichage de la zone de texte pour rentrer la réponse.
	JTextField textfield = new JTextField();
	
	// Affichage du bouton pour valider la réponse.
	JButton button = new JButton("Valider");
	
	private int xfond;
	
	
	Vue vue;
	
	public Scene(Vue vue) {
		this.vue = vue;
	}


	/**
	 * Constructeur de la classe Scene.
	 * Crée une instance de la scène du jeu avec les éléments graphiques nécessaires.
	 *
	 * @param etat         L'état de la scène, représentant l'image de la guillotine.
	 * @param question     La question à afficher sur la scène.
	 * @param truth        La vérité associée à la question (vide, vrai ou faux).
	 * @param nbQuestion   Le numéro de la question en cours.
	 */
	public Scene(Controlleur controlleur, Vue vue) {
	    super();
	    
	    int etat = controlleur.requestnError();
	    String question = controlleur.requestQuestion();
	    String truth = controlleur.requestTruth();
	    int nbQuestion = controlleur.requestnNbQuestion();
	    
	    
	    
	    this.vue = vue;

	    // Initialisation des variables et des images de fond
	    this.xfond = -50;
	    icoFond = new ImageIcon(getClass().getResource("guillotine/fond2.png"));
	    this.imgFond = this.icoFond.getImage();

	    // Ajout du label pour afficher le numéro de la question
	    JLabel questionLabel = new JLabel("Question " + nbQuestion + "/10");
	    questionLabel.setFont(new Font("Serif", Font.BOLD, 20));
	    questionLabel.setBounds(775, 10, 400, 30);
	    this.add(questionLabel);

	    // Chargement de l'image de la guillotine en fonction de l'état
	    changePaintComponent(etat);
	    this.imgguillotine = this.icoguillotine.getImage();

	    // Affichage de la vérité associée à la question
	    displayTruth(truth);
	    this.imgRetour = this.icoRetour.getImage();

	    // Configuration du champ de texte
	    textfield.setBounds(400, 245 + imgguillotine.getHeight(null), 150, 20);
	    if (nbQuestion >= 10) {
	        textfield.setEditable(false);
	    }
	    this.setLayout(null);
	    this.add(textfield);

	    // Configuration du bouton
	    button.setBounds(400 + textfield.getWidth(), 245 + imgguillotine.getHeight(null), 100, 20);
	    this.add(button);

	    // Gestion de la question affichée
	    handleQuestion(question);

	    // Ajout d'un ActionListener au bouton pour gérer les clics
	    button.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	controlleur.actionToDo(handleButtonClick());
	        	vue.updateScene();
	        }
	    });
	}

	
	/**
	 * Redéfinition de la méthode paintComponent pour dessiner les éléments graphiques de la scène.
	 *
	 * @param g L'objet Graphics utilisé pour dessiner.
	 */
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics g2 = (Graphics2D) g;

	    // Dessin de l'image de fond
	    g2.drawImage(this.imgFond, this.xfond, 0, null);

	    // Dessin de l'image de la guillotine
	    g2.drawImage(this.imgguillotine, 400, 200, null);

	    // Dessin de l'image de retour
	    g2.drawImage(this.imgRetour, 800, 500, null);
	}

	
	/**
	 * Change l'état de l'image de la guillotine en fonction de l'état donné.
	 *
	 * @param etat Le nouvel état de l'image de la guillotine.
	 */
	public void changePaintComponent(int etat) {
	    if (etat == 0) {
	        icoguillotine = new ImageIcon(getClass().getResource("guillotine/Guillotine0.png"));
	    } else if (etat == 1) {
	        icoguillotine = new ImageIcon(getClass().getResource("guillotine/Guillotine1.png"));
	    } else if (etat == 2) {
	        icoguillotine = new ImageIcon(getClass().getResource("guillotine/Guillotine2.png"));
	    } else if (etat == 3) {
	        icoguillotine = new ImageIcon(getClass().getResource("guillotine/Guillotine3.png"));
	    } else {
	        icoguillotine = new ImageIcon(getClass().getResource("guillotine/Guillotine4.png"));
	    }
	}


	/**
	 * Affiche l'image correspondant à la vérité sociale de la réponse précédente.
	 *
	 * @param truth La vérité sociale de la réponse précédente ("Empty", "True" ou "False").
	 */
	public void displayTruth(String truth) {
		if (truth.equals("Empty")) {
			icoRetour = new ImageIcon(getClass().getResource("guillotine/Vide.png"));
		} else if (truth.equals("True")) {
			icoRetour = new ImageIcon(getClass().getResource("guillotine/Vrai.png"));
		} else {
			icoRetour = new ImageIcon(getClass().getResource("guillotine/Faux.png"));
		}
	}

	/**
	 * Gère l'action du clic sur le bouton.
	 *
	 * @return Le texte contenu dans le champ de texte.
	 */
	public String handleButtonClick() {
	    // Récupération du texte du champ de texte
	    String text = textfield.getText();
	    
	    // Retourne le texte
	    return text;
	}

	/**
	 * Gère l'affichage de la question en découpant le texte en lignes.
	 *
	 * @param question La question à afficher.
	 */
	public void handleQuestion(String question) {
	    // Définition de la taille maximale d'une ligne de texte
	    int lineSize = 32;

	    // Découper la chaîne de caractères en portions de taille `lineSize` en coupant sur un espace
	    List<String> lines = new ArrayList<>();
	    int startIndex = 0;
	    while (startIndex < question.length()) {
	        int endIndex = Math.min(startIndex + lineSize, question.length());

	        // Trouver la dernière occurrence d'un espace dans la portion pour éviter de couper les mots
	        while (endIndex < question.length() && question.charAt(endIndex) != ' ') {
	            endIndex--;
	        }

	        // Ajouter la portion de texte à la liste des lignes
	        lines.add(question.substring(startIndex, endIndex));

	        // Mettre à jour l'index de début pour la prochaine portion
	        startIndex = endIndex + 1;
	    }

	    // Afficher les lignes de texte sur des JLabel et les positionner sur le panel
	    int yPos = 50; // Position verticale initiale
	    for (String line : lines) {
	        JLabel questionLabel = new JLabel(line);
	        questionLabel.setFont(new Font("Serif", Font.BOLD, 20));
	        
	        // Positionner horizontalement les JLabel au centre de la fenêtre
	        int xPos = (950 - 10 * line.length()) / 2;
	        questionLabel.setBounds(xPos, yPos, 400, 30);

	        // Ajouter le JLabel au panel
	        this.add(questionLabel);

	        // Mettre à jour la position verticale pour la prochaine ligne
	        yPos += 30; // Ajuster cette valeur pour modifier l'espacement vertical entre les lignes
	    }
	}

}
		
