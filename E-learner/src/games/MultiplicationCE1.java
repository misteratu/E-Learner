package games;

/**
 * Mini jeu pour réviser la multiplication pour le CE1
 * @author Dehmani Mohammed
 *
 */
public class MultiplicationCE1 extends MathGame {

	/**
	 * procedure pour generer les questions
	 */
	@Override
	protected void generateQuestion() {
		int a = (int) (Math.random() * 6);
		int b = (int) (Math.random() * 10);
		int question = a * b;
		setText(a + " * " + b + " = ");
		setAnswer(question);
	}

	public static void main(String[] args) {
		new MultiplicationCE1();
	}

}