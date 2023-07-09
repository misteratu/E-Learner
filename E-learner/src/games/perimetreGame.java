package games;


import java.util.concurrent.ThreadLocalRandom;

/**
 * Mini jeu pour réviser les périmetres
 * @author Dehmani Mohammed
 *
 */
public class perimetreGame extends MathGame {

	/**
	 * procedure pour generer les questions
	 */
	@Override
	protected void generateQuestion() {
		int a = (int) (Math.random() * 50) + 1;
		int b = (int) (Math.random() * 50) + 1;
		int c = (int) (Math.random() * 50) + 1;
		int d = (int) (Math.random() * 50) + 1;

		// Génère un nombre aléatoire entre 1 et 6 inclus
		int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
		switch (randomNum) {
			case 1:
				setText("Quelle est le périmètre d'un carré de coté " + a + " ?");
				setAnswer(4 * a);
				break;
			case 2:
				setText("Quelle est le périmètre d'un cercle de rayon " + a + " ?");
				setAnswer(Math.round(2 * Math.PI * a) * 100.0 / 100.0);
				break;
			case 3:
				setText("Quelle est le périmètre d'un rectangle de longueur " + a + "et de largeur" + b + " ?");
				setAnswer(2 * (a + b));
				break;
			case 4:
				setText("Quelle est le périmètre d'un triangle de faces " + a + " " + b + " " + c + " ?");
				setAnswer(a + b + c);
				break;
			case 5:
				setText("Quelle est le périmètre d'un trapèze de faces " + a + " " + b + " " + c + " " + d + " ?");
				setAnswer(a + b + c + d);
				break;
			case 6:
				setText("Quelle est le périmètre d'un polygone régulier de " + b + " cotés" + a + " ?");
				setAnswer(a * b);
				break;
		}

	}

	public static void main(String[] args) {
		new perimetreGame();
	}
}
