package games;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Mini jeu pour réviser les volumes géométriques
 * @author Dehmani Mohammed
 *
 */
public class volumeGame extends MathGame {

	/**
	 * procedure pour generer les questions
	 */
	@Override
	protected void generateQuestion() {
		int a = (int) (Math.random() * 50) + 1;
		int b = (int) (Math.random() * 50) + 1;
		int h = (int) (Math.random() * 50) + 1;

		// Génère un nombre aléatoire entre 1 et 7 inclus
		int randomNum = ThreadLocalRandom.current().nextInt(1, 8);

		double s;
		switch (randomNum) {
			case 1:
				setText("Quelle est le volume d'un cube de coté " + a + " ?");
				s = a * a * a;
				setAnswer(s);
				break;
			case 2:
				setText("Quelle est le volume d'un pyramyde de base carré de coté " + a + " et de hauteur " + h + " ?");
				s = a * a * h / 3;
				setAnswer(Math.round(s) * 100.0 / 100.0);
				break;
			case 3:
				setText("Quelle est le volume d'un pyramyde de base rectangle de longueur " + a + ", de largeur " + b
						+ " et de hauteur " + h + " ?");
				setAnswer(a * b * h);
				break;
			case 4:
				setText("Quelle est le volume d'un pyramyde de base triangle qui  est de base " + a + ", de hauteur " + b
						+ " et la hauteur du pyramide est  " + h + " ?");
				s = a * b * h / 6;
				setAnswer(Math.round(s) * 100.0 / 100.0);
				break;
			case 5:
				setText("Quelle est le volume d'une sphere de rayon " + a + " ?");
				s = 4 * Math.PI * a * a * a / 3;
				setAnswer(Math.round(s) * 100.0 / 100.0);
				break;
			case 6:
				setText("Quelle est le volume d'un cylindre de rayon " + a + " et de hauteur " + h + " ?");
				s = h * Math.PI * a * a;
				setAnswer(Math.round(s) * 100.0 / 100.0);
				break;
			case 7:
				setText("Quelle est le volume d'un cône de rayon " + a + " et de hauteur " + h + " ?");
				s = h * Math.PI * a * a / 3;
				setAnswer(Math.round(s) * 100.0 / 100.0);
				break;

		}

	}

	public static void main(String[] args) {
		new volumeGame();
	}
}
