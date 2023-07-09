package games;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Mini jeu pour réviser la somme et la sustraction des durée
 * @author Dehmani Mohammed
 *
 */
public class sommeDureeGame extends JFrame implements ActionListener {
	private JLabel questionLabel;
	private JTextField answerField;
	private JButton submitButton;
	private JLabel scoreLabel;
	private JLabel healthLabel;
	private int score = 0;
	private int health = 100;
	private int answer;
	private boolean gameOver = false;

	/**
	 * Constructeur pour gérer la vue des mini jeux
	 */
	public sommeDureeGame() {
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
		int answer = getAnswer();
		if (answer == this.answer) {
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
	protected void setAnswer(int endValue) {
		this.answer = endValue;
	}

	/**
	 * fonction pour récuperer la réponse du joueur
	 * @return réponse du joueur
	 */
	private int getAnswer() {
		// Récupère la réponse de l'utilisateur
		String answer = answerField.getText();
		String[] tableau = answer.split("-");
		int s = ((Integer.parseInt(tableau[0]) * 24) + Integer.parseInt(tableau[1])) * 3600
				+ Integer.parseInt(tableau[2]) * 60 + Integer.parseInt(tableau[3]);
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

		int j1 = (int) (Math.random() * 10);
		int j2 = (int) (Math.random() * j1);
		int h1 = (int) (Math.random() * 23);
		int h2 = (int) (Math.random() * 23);
		int min1 = (int) (Math.random() * 59);
		int min2 = (int) (Math.random() * 59);
		int s1 = (int) (Math.random() * 59);
		int s2 = (int) (Math.random() * 59);

		int randomNum = ThreadLocalRandom.current().nextInt(1, 3);
		switch (randomNum) {
			case 1:
				setText(j1 + " jours " + h1 + " h " + min1 + " min " + s1 + " s " + " + " + j2 + " jours " + h2 + " h "
						+ min2 + " min " + s2 + " s = \n (j-h-min_s)");
				setAnswer((((j1 * 24) + h1) * 3600 + min1 * 60 + s1) + (((j2 * 24) + h2) * 3600 + min2 * 60 + s2));
				break;
			case 2:
				setText(j1 + " jours " + h1 + " h " + min1 + " min " + s1 + " s " + " - " + j2 + " jours " + h2 + " h "
						+ min2 + " min " + s2 + " s = \n (j-h-min_s)");
				setAnswer((((j1 * 24) + h1) * 3600 + min1 * 60 + s1) - (((j2 * 24) + h2) * 3600 + min2 * 60 + s2));
				break;
		}

	}

	public static void main(String[] args) {
		new sommeDureeGame();
	}

}