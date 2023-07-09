package games;

/**
 * Mini jeu pour réviser les aires
 * @author Dehmani Mohammed
 *
 */
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class aireGame extends MathGame {

	@Override
	protected void generateQuestion() {
		int a = (int) (Math.random() * 10) + 1;
		int b = (int) (Math.random() * 10) + 1;
		int h = (int) (Math.random() * 10) + 1;

		// Génère un nombre aléatoire entre 1 et 7 inclus
		int randomNum = ThreadLocalRandom.current().nextInt(1, 8);
		switch (randomNum) {
			case 1:
				setText("Quelle est la surface d'un carré de coté " + a + " ?");
				setAnswer(a * a);
				break;
			case 2:
				setText("Quelle est la surface d'un cercle de rayon " + a + " ?");
				setAnswer(Math.round(Math.PI * a * a) * 100.0 / 100.0);
				break;
			case 3:
				setText("Quelle est la surface d'un rectangle de longueur " + a + "et de largeur" + b + " ?");
				setAnswer(a * b);
				break;
			case 4:
				setText("Quelle est la surface d'un triangle de base " + a + " et de hauteur " + h + " ?");
				setAnswer(a * h / 2);
				break;
			case 5:
				setText("Quelle est la surface d'un trapèze de bases " + a + " " + b + " et de hauteur " + h + " ?");
				setAnswer((a + b) * h / 2);
				break;
			case 6:
				setText("Quelle est la surface d'un losange de diamètres" + b + " " + a + " ?");
				setAnswer(a * b / 2);
				break;
			case 7:
				setText("Quelle est la surface d'un parallélogramme de base " + a + " et de hauteur " + h + " ?");
				setAnswer(a * h);
		}

	}

	public static void main(String[] args) {
		new aireGame();
	}
}
