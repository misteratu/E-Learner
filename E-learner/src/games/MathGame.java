package games;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Classe qui regroupe la vue des mini jeu de math et son déoulement
 * @author Dehmani Mohammed
 *
 */
public abstract class MathGame extends JFrame implements ActionListener {
	private JLabel questionLabel;
	private JTextField answerField;
	private JButton submitButton;
	private JLabel scoreLabel;
	private JLabel healthLabel;
	private int score = 0;
	private int health = 100;
	private double answer;
	private boolean gameOver = false;

	/**
	 * Constructeur pour gérer la vue des mini jeux
	 */
	public MathGame() {
		// Crée la fenêtre
		setTitle("Math Game");
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
		Double answer = getAnswer();
		if (answer == this.answer) { // Compare la réponse de l'utilisateur à la réponse correcte
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
	protected void setAnswer(double endValue) {
		this.answer = endValue;
	}

	/**
	 * fonction pour récuperer la réponse du joueur
	 * @return réponse du joueur
	 * @throws NumberFormatException
	 */
	private Double getAnswer() throws NumberFormatException {
		// Récupère la réponse de l'utilisateur
		String input = answerField.getText();
		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException e) {
			// Si la saisie n'est pas un nombre, affiche un message d'erreur
			JOptionPane.showMessageDialog(this, "Veuillez saisir un nombre valide.");
			throw e; // lance une exception pour signaler l'erreur
		}
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
	 * procedure abstraite pour generer le questions
	 * selon le mini jeu
	 */
	protected abstract void generateQuestion();
}