package MiniJeuGuillotine;
/**
 * Classe pour vérifier les réponses de jeu de type entier.
 */
public class IntChecker implements GameAnswerChecker<Integer> {

    /**
     * Vérifie si la réponse de l'utilisateur correspond à la réponse attendue de type entier.
     *
     * @param userAnswer    La réponse de l'utilisateur sous forme de chaîne de caractères.
     * @param correctAnswer La réponse correcte de type entier.
     * @return true si la réponse de l'utilisateur correspond à la réponse correcte, sinon false.
     */
    public boolean checkAnswer(String userAnswer, Integer correctAnswer) {
        try {
            // Convertir la réponse de l'utilisateur en entier
            Integer userAnswerInt = Integer.valueOf(userAnswer);

            // Vérifier si la réponse de l'utilisateur correspond à la réponse correcte
            return correctAnswer.equals(userAnswerInt);
        } catch (NumberFormatException e) {
            // Gérer l'exception si la conversion de la réponse de l'utilisateur en entier échoue
            System.err.println("Erreur lors de la conversion de la réponse utilisateur en entier: " + e.getMessage());
            return false;
        }
    }
}
