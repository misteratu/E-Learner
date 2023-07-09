package games;

/**
 * Mini jeu pour réviser la conversion des unités
 * @author Dehmani Mohammed
 *
 */
public class JeuDeConversion extends MathGame {

	/**
	 * procedure pour generer les questions
	 */
	@Override
	protected void generateQuestion() {
		// Génère un nombre aléatoire pour choisir la grandeur à convertir
		int grandeur = (int) (Math.random() * 4);

		// Génère un nombre aléatoire pour choisir les unités de départ et d'arrivée
		int startUnit = (int) (Math.random() * 3);
		int endUnit = (int) (Math.random() * 3);

		// Génère une valeur aléatoire pour la grandeur de départ
		int startValue = (int) (Math.random() * 100);

		// Convertit la valeur de départ dans l'unité d'arrivée
		double endValue = convert(startValue, startUnit, endUnit, grandeur);

		// Affiche la question à l'utilisateur
		String question = "Convertir " + startValue + " " + getUnitName(startUnit, grandeur) + " en "
				+ getUnitName(endUnit, grandeur) + ".";
		setText(question);

		// Enregistre la réponse pour vérification ultérieure
		setAnswer(endValue);
	}

	// Méthode pour convertir une grandeur d'une unité à une autre
	private double convert(double value, int startUnit, int endUnit, int grandeur) {
		switch (grandeur) {
			case 0: // Longueur
				double[] conversionFactorsLength = { 1.0, 100.0, 1000.0 };
				return value * conversionFactorsLength[endUnit] / conversionFactorsLength[startUnit];

			case 1: // Masse
				double[] conversionFactorsMass = { 1.0, 1000.0, 1000000.0 };
				return value * conversionFactorsMass[endUnit] / conversionFactorsMass[startUnit];

			case 2: // Durée
				double[] conversionFactorsTime = { 1.0, 60.0, 3600.0 };
				return value * conversionFactorsTime[startUnit] / conversionFactorsTime[endUnit];

			case 3: // Prix
				double[] conversionFactorsPrice = { 1.0, 100.0, 10000.0 };
				return value * conversionFactorsPrice[endUnit] / conversionFactorsPrice[startUnit];

			default:
				return 0.0;
		}
	}

	// Méthode pour obtenir le nom d'une unité à partir de son index et de la
	// grandeur
	private String getUnitName(int unitIndex, int grandeur) {
		switch (grandeur) {
			case 0: // Longueur
				String[] unitNamesLength = { "mètre", "centimètre", "millimètre" };
				return unitNamesLength[unitIndex];

			case 1: // Masse
				String[] unitNamesMass = { "kilogramme", "gramme", "milligramme" };
				return unitNamesMass[unitIndex];

			case 2: // Durée
				String[] unitNamesTime = { "seconde", "minute", "heure" };
				return unitNamesTime[unitIndex];

			case 3: // Prix
				String[] unitNamesPrice = { "euro", "centime", "millième d'euro" };
				return unitNamesPrice[unitIndex];

			default:
				return "";
		}
	}

	public static void main(String[] args) {
		new JeuDeConversion();
	}
}
