package games;

/**
 * Mini jeu pour réviser l'ordre
 * @author Dehmani Mohammed
 *
 */
public class plusGrandGame extends MathGame {

	/**
	 * procedure pour generer les questions
	 */
	@Override
	protected void generateQuestion() {

		// Formate le nombre avec deux chiffres après la virgule
		Double a = (Double) (Math.random() * 10000);
		a = Math.round(a * 100.0) / 100.0;

		Double b = (Double) (Math.random() * 10000);
		b = Math.round(b * 100.0) / 100.0;

		Double question = b;
		if (question > 0) {
			question = a;
		}
		setText("Quel nombre est plus grand " + a + " ou " + b + "? ");
		setAnswer(question);
	}

	public static void main(String[] args) {
		new plusGrandGame();
	}
}