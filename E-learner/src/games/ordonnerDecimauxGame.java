package games;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Mini jeu pour réviser l'ordre des plusieurs grands nombres décimaux
 * @author Dehmani Mohammed
 *
 */
public class ordonnerDecimauxGame extends JFrame implements ActionListener {
	private JLabel questionLabel;
	private JTextField answerField;
	private JButton submitButton;
	private JLabel scoreLabel;
	private JLabel healthLabel;
	private int score = 0;
	private int health = 100;

	/**
	 * Constructeur pour gérer la vue des mini jeux
	 */
	public ordonnerDecimauxGame() {
		// Crée la fenêtre
		setTitle("Mini Jeu Geometrie");
		setSize(700, 150);
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
		boolean answer = getAnswer();
		if (answer == true) {
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
				JOptionPane.showMessageDialog(this, "Félicitation," + " Vous avez gagné");
			} else {
				JOptionPane.showMessageDialog(this, "Révisez votre" + " " + "cours puis réessayez");
				restart();
			}
		} else {
			generateQuestion();
		}
	}

	/**
	 * fonction pour récuperer la réponse du joueur
	 * @return réponse du joueur
	 */
	private boolean getAnswer() {
		// Récupère la réponse de l'utilisateur
		String answer = answerField.getText();
		String[] tableau = answer.split("<");
		boolean s = true;
		if (tableau.length != 7) {
			s = false;
		} else {
			for (int i = 0; i < tableau.length - 1; i++) {
				if (Double.parseDouble(tableau[i]) >Double.parseDouble(tableau[i + 1])) {
					s = false;
				}
			}
		}
		return s;
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

		Double a = (Double) (Math.random() * 10);
		a = Math.round(a * 100.0) / 100.0;
		Double b = (Double) (Math.random() * 10);
		b = Math.round(b * 100.0) / 100.0;
		Double c = (Double) (Math.random() * 10);
		c = Math.round(c * 100.0) / 100.0;
		Double d = (Double) (Math.random() * 10);
		d = Math.round(d * 100.0) / 100.0;
		Double e = (Double) (Math.random() * 10);
		e = Math.round(e * 100.0) / 100.0;
		Double f = (Double) (Math.random() * 10);
		f = Math.round(f * 100.0) / 100.0;
		Double g = (Double) (Math.random() * 10);
		g = Math.round(g * 100.0) / 100.0;
		setText("ordonner les decimaux suivant avec " + "ordre croissant : " + a + " " + b + " " + c + " " + d + " " + e
				+ " " + f + " " + " " + g + " a<b<c..");

	}

	public static void main(String[] args) {
		new ordonnerDecimauxGame();
	}

}