package MiniJeuGuillotine;

/**
 * Vérificateur de réponse de jeu pour les réponses de type flottant.
 */
public class FloatChecker implements GameAnswerChecker<Float> {

    /**
     * Vérifie si la réponse de l'utilisateur correspond à la réponse correcte de type flottant.
     *
     * @param userAnswer    La réponse de l'utilisateur sous forme de chaîne de caractères.
     * @param correctAnswer La réponse correcte de type flottant.
     * @return true si la réponse de l'utilisateur correspond à la réponse correcte, sinon false.
     */
    public boolean checkAnswer(String userAnswer, Float correctAnswer) {
        try {
            Float userAnswerFloat = Float.valueOf(userAnswer);
            return correctAnswer.equals(userAnswerFloat);
        } catch (NumberFormatException e) {
            System.err.println("Erreur lors de la conversion de la réponse utilisateur en flottant: " + e.getMessage());
            return false;
        }
    }
}
