package games;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Mini jeu pour réviser les différentes formes géométriques
 * @author Dehmani Mohammed
 *
 */
public class MiniJeuGeometrie extends JFrame implements ActionListener {
	private JLabel questionLabel;
	private JTextField answerField;
	private JButton submitButton;
	private JLabel scoreLabel;
	private JLabel healthLabel;
	private int score = 0;
	private int health = 100;
	private String answer;

	/**
	 * Constructeur pour gérer la vue des mini jeux
	 */
	public MiniJeuGeometrie() {
		// Crée la fenêtre
		setTitle("Mini Jeu Geometrie");
		setSize(800, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Ajoute les éléments à la fenêtre
		JPanel panel = new JPanel();
		questionLabel = new JLabel();
		panel.add(questionLabel);
		answerField = new JTextField(40);
		panel.add(answerField);
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		panel.add(submitButton);
		scoreLabel = new JLabel("Score: " + score);
		healthLabel = new JLabel("Health: " + health);
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.add(scoreLabel, BorderLayout.WEST);
		northPanel.add(healthLabel, BorderLayout.EAST);
		add(northPanel, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);

		// Centrer la fenêtre sur l'écran
		setLocationRelativeTo(null);

		// Affiche la première question
		generateQuestion();

		// Affiche la fenêtre
		setVisible(true);
	}

	/*
	 * Procedure pour gérer le déroulement du mini jeu
	 */
	public void actionPerformed(ActionEvent e) {
		String answer = getAnswer();
		if (answer.equalsIgnoreCase(this.answer)) {
			score += 20;
		} else {
			health -= 20;
		}
		scoreLabel.setText("Score: " + score);
		healthLabel.setText("Health: " + health);
		answerField.setText("");
		if (score >= 100 || health <= 0) {
			dispose();
			if (score >= 100) {
				JOptionPane.showMessageDialog(this, "Félicitation, Vous avez gagné");
			} else {
				JOptionPane.showMessageDialog(this, "Révisez votre cours puis réessayez");
				restart();
			}
		} else {
			generateQuestion();
		}
	}

	/**
	 * Procedure pour savoir la bonne réponse
	 * @param endValue
	 */
	protected void setAnswer(String endValue) {
		this.answer = endValue;
	}

	/**
	 * fonction pour récuperer la réponse du joueur
	 * @return réponse du joueur
	 */
	private String getAnswer() {
		// Récupère la réponse de l'utilisateur
		return answerField.getText();
	}
	/**
	 * Procédure pour afficher la question
	 * @param string
	 */
	public void setText(String string) {
		questionLabel.setText(string);
	}

	/**
	 * procedure pour rejouer en cas d'echec
	 */
	public void restart() {
		score = 0;
		health = 100;
		scoreLabel.setText("Score: " + score);
		healthLabel.setText("Health: " + health);
		generateQuestion();
		setVisible(true);
	}

	/**
	 * procedure pour generer le questions
	 */
	protected void generateQuestion() {

		// Génère un nombre aléatoire entre 1 et 7 inclus
		int randomNum = ThreadLocalRandom.current().nextInt(1, 8);

		// Utilise le nombre aléatoire pour choisir une forme géométrique
		String question;
		switch (randomNum) {
			case 1:
				question = "Quelle est la forme géométrique qui a quatre côtés de même longueur et quatre angles droits ?"; // carré
				setAnswer("carré");
				break;
			case 2:
				question = "Quelle est la forme géométrique qui a deux côtés de même longueur et deux angles droits ?"; // rectangle
				setAnswer("rectangle");
				break;
			case 3:
				question = "Quelle est la forme géométrique qui a une base circulaire et une face qui ressemble à un cercle aplati ?"; // cylindre
				setAnswer("cylindre");
				break;
			case 4:
				question = "Quelle est la forme géométrique qui a une base carrée et quatre faces triangulaires ?"; // pyramide
				setAnswer("pyramide");
				break;
			case 5:
				question = "Quelle est la forme géométrique qui a six faces carrées ?"; // cube
				setAnswer("cube");
				break;
			case 6:
				question = "Quelle est la forme géométrique qui a une base circulaire et une face qui ressemble à un triangle ?"; // cône
				setAnswer("cône");
				break;
			case 7:
				question = "Quelle est la forme géométrique qui est parfaitement ronde et a une surface lisse et courbe ?"; // boule
				setAnswer("boule");
				break;
			default:
				question = "Erreur: forme géométrique non reconnue.";
				break;
		}
		setText(question);

	}

	public static void main(String[] args) {
		new MiniJeuGeometrie();
	}

}