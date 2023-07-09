package games;

/**
 * Mini jeu pour réviser la division
 * @author Dehmani Mohammed
 *
 */
public class DivisionGame extends MathGame {

	/**
	 * procedure pour generer les questions
	 */
	@Override
	protected void generateQuestion() {
		// Génère une question aléatoire
		int a = (int) (Math.random() * 100) + 1;
		int b = (int) (Math.random() * 10) + 1;
		Double correctAnswer = (double) a / b; // Stocke la réponse correcte dans une variable
		if ((correctAnswer * 1000) % 10 >= 5) {
			correctAnswer = (Math.round(correctAnswer * 100.0) / 100.0) - 0.01;
		}
		correctAnswer = Math.round(correctAnswer * 100.0) / 100.0;
		setText("What is " + a + " / " + b + "? ( à deux chiffre après la virgule");
		setAnswer(correctAnswer); // Stocke la réponse correcte dans la propriété "answer"
	}

	public static void main(String[] args) {
		new DivisionGame();
	}

}