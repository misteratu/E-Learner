package MiniJeuGuillotine;
/**
 * Interface générique pour vérifier les réponses de jeu.
 *
 * @param <T> Le type de la réponse correcte.
 */
public interface GameAnswerChecker<T> {

    /**
     * Vérifie si la réponse de l'utilisateur correspond à la réponse correcte.
     *
     * @param userAnswer    La réponse de l'utilisateur sous forme de chaîne de caractères.
     * @param correctAnswer La réponse correcte de type générique T.
     * @return true si la réponse de l'utilisateur correspond à la réponse correcte, sinon false.
     */
    boolean checkAnswer(String userAnswer, T correctAnswer);
}
