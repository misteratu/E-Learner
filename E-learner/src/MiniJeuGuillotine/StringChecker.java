package MiniJeuGuillotine;
/**
 * Implémentation de l'interface GameAnswerChecker pour les réponses de type chaîne de caractères.
 */
public class StringChecker implements GameAnswerChecker<String> {

    /**
     * Vérifie si la réponse de l'utilisateur correspond à la réponse correcte.
     *
     * @param userAnswer    La réponse de l'utilisateur.
     * @param correctAnswer La réponse correcte.
     * @return true si la réponse de l'utilisateur est correcte, false sinon.
     */
    public boolean checkAnswer(String userAnswer, String correctAnswer) {
        // Compare la réponse de l'utilisateur avec la réponse correcte
        return correctAnswer.equals(userAnswer);
    }
}
