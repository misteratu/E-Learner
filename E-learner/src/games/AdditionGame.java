package games;

/**
 * Mini jeu pour réviser l'addition
 * @author Dehmani Mohammed
 *
 */
public class AdditionGame extends MathGame {

	/**
	 * procedure pour generer le questions
	 */
	@Override
	protected void generateQuestion() {
		int a = (int) (Math.random() * 10);
		int b = (int) (Math.random() * 10);
		int question = a + b;
		setText(a + " + " + b + " = ");
		setAnswer(question);
	}

	public static void main(String[] args) {
		new AdditionGame();
	}
}