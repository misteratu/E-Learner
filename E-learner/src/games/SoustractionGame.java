package games;

/**
 * Mini jeu pour réviser la soustraction
 * @author Dehmani Mohammed
 *
 */
public class SoustractionGame extends MathGame {

	/**
	 * procedure pour generer les questions
	 */
	@Override
	protected void generateQuestion() {
		int a = (int) (Math.random() * 100);
		int b = (int) (Math.random() * 100);
		while (b > a) {
			b = (int) (Math.random() * 100);
		}
		int question = a - b;
		setText(a + " - " + b + " = ");
		setAnswer(question);
	}

	public static void main(String[] args) {
		new SoustractionGame();
	}
}