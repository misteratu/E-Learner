package games;

import java.util.Random;

/**
 * Mini jeu pour réviser la multiplication pour le niveau CE2
 * @author Dehmani Mohammed
 *
 */
public class MultiplicationCE2 extends MathGame {

	/**
	 * procedure pour generer les questions
	 */
	@Override
	protected void generateQuestion() {
		Random rand = new Random();
		int a = rand.nextInt(4) + 6;
		int b = (int) (Math.random() * 10);
		int question = a * b;
		setText(a + " * " + b + " = ");
		setAnswer(question);
	}

	public static void main(String[] args) {
		new MultiplicationCE2();
	}

}