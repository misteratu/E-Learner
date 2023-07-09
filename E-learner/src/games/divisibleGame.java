package games;

import java.util.Random;

/**
 * Mini jeu pour réviser la divisibilité
 * @author Dehmani Mohammed
 *
 */
public class divisibleGame extends MathGame {

	/**
	 * procedure pour generer les questions
	 */
	@Override
	protected void generateQuestion() {
		int[] tableau = { 2, 3, 4, 5, 10 };
		Random rand = new Random();
		int num = (int) (Math.random() * 1000);

		// Choix aléatoire d'un diviseur entre 2 et 5
		int divisor = rand.nextInt(tableau.length);

		setText("Est-ce que " + num + " est divisible par " + tableau[divisor] + "? "
				+ "Répond 1 si divisible, 0 sinon");
		int answer = 0;
		if (num % tableau[divisor] == 0) {
			answer = 1;
		}
		setAnswer(answer); // Réponse 1 si divisible, 0 sinon

	}

	public static void main(String[] args) {
		new divisibleGame();
	}
}
