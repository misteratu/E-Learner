package MiniJeuGuillotine;
import java.io.IOException;

import org.json.simple.parser.ParseException;


/**
 * Classe représentant le modèle du jeu.
 */

public class Modele {
    private int nError; // Nombre d'erreurs
    private int nbQuestion; // Nombre de questions
    protected final static int nbFautesMax = 4; // Nombre maximum de fautes autorisées
    private int nbQuestionTot = 10; // Nombre total de questions
    Generateur generateur = new Generateur();
    private int numeroQuestion;
    
    /**
     * Constructeur de la classe Modele.
     * Initialise les attributs nError, nbQuestion, question et correctAnswer.
     */
    public Modele() {
    	
        nError = 0;
        nbQuestion = 1;
    }
    
    /**
     * Retourne le nombre d'erreurs.
     * @return Le nombre d'erreurs.
     */
    public int getNError() {
        return nError;
    }
    
    /**
     * Retourne le nombre de questions.
     * @return Le nombre de questions.
     */
    public int getNbQuestion() {
        return nbQuestion;
    }
    
    /**
     * Retourne la question en cours.
     * @return La question en cours.
     */
    public String getQuestion() {
    	String question = "coucou";
    	numeroQuestion = generateur.generateUniqueNumber();
    	try {
            QuestionsReponsesHistoire qrHistoire = new QuestionsReponsesHistoire();
            question = qrHistoire.getQuestionHistoire(numeroQuestion);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    	
    	return question;
    }
    
    /**
     * Retourne la réponse correcte.
     * @return La réponse correcte.
     */
    public String getCorrectAnswer() {
    	String reponse = "coucou";
    	try {
            QuestionsReponsesHistoire qrHistoire = new QuestionsReponsesHistoire();
            reponse = qrHistoire.getBonneReponseHistoire(numeroQuestion);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    	
    	return reponse;
    }
    
    /**
     * Incrémente le nombre de questions passée.
     */
    public void incrementNbQuestion() {
        nbQuestion++;
    }
    
    /**
     * Incrémente le nombre d'erreurs.
     */
    public void incrementNError() {
        nError++;
    }
    
    /**
     * Retourne le nombre total de questions.
     * @return Le nombre total de questions.
     */
    public int getNbQuestionTot() {
        return nbQuestionTot;
    }
}
