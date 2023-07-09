package games;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Mini jeu pour réviser les differents opération pour des grands nombres
 * @author Dehmani Mohammed
 *
 */
public class bossCE2 extends MathGame {

	/**
	 * procedure pour generer le questions
	 */
	@Override
	protected void generateQuestion() {
		Double a = (Double) (Math.random() * 1000);
		a = Math.round(a * 100.0) / 100.0;
		Double b = (Double) (Math.random() * 1000);
		b = Math.round(b * 100.0) / 100.0;

		// Génère un nombre aléatoire entre 1 et 4 inclus
		int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
		Double question;
		switch (randomNum) {
			case 1:
				question = a + b;
				setText(a + " + " + b + " = ");
				setAnswer(question);
				break;
			case 2:
				while (b > a) {
					b = (Double) (Math.random() * 1000);
					b = Math.round(b * 100.0) / 100.0;
				}
				question = a - b;
				setText(a + " - " + b + " = ");
				setAnswer(question);
				break;
			case 3:
				question = a * b;
				setText(a + " * " + b + " = ");
				setAnswer(question);
				break;
			case 4:
				b = (Double) (Math.random() * 100);
				b = Math.round(b * 100.0) / 100.0;
				question = a / b;
				if ((question * 1000) % 10 >= 5) {
					question = (Math.round(question * 100.0) / 100.0) - 0.01;
				}
				question = Math.round(question * 100.0) / 100.0;
				setText("A deux chiffres après la virgule" + a + " / " + b + " = ");
				setAnswer(question);
				break;
			default:
				break;
		}

	}

	public static void main(String[] args) {
		new bossCE2();
	}
}
