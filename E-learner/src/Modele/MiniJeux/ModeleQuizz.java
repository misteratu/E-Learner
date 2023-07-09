package Modele.MiniJeux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModeleQuizz {

    /**
     * Nombre maximal de questions par Quizz
     */
    public final int maxQuestions = 100;

    /**
     * Nombre de réponses correctes lors de la session
     */
    private int correctAnswerNb;
    /**
     * Index représentant l'identifiant (dans le json) des questions précédentes
     */
    private List<Integer> previousQuestions;
    /**
     * Nombre de questions total dans la session
     */
    private int totalQuestionNb;
    /**
     * numéro de la question actuelle
     */
    private int currentQuestionNb;
    /**
     * Niveau du Quizz parmis CP,CE1,CE2,CM1,CM2
     */
    private String level;
    /**
     * Matière du Quizz à choisir parmis Math,Fr,Sc,Hi,Geo
     */

    private String matiere;
    /**
     * Temps par question
     */

    private double timePerQuestion;

    public ModeleQuizz(String matiere, String level, int totalQuestionNb, double timePerQuestion) {
        this.correctAnswerNb = 0;
        this.previousQuestions = new ArrayList<>();
        this.totalQuestionNb = totalQuestionNb;
        this.currentQuestionNb = currentQuestionNb;
        this.level = level;
        this.matiere = matiere;
        this.timePerQuestion = timePerQuestion;
    }

    public int getCorrectAnswerNb() {
        return correctAnswerNb;
    }

    public void setCorrectAnswerNb(int correctAnswerNb) {
        this.correctAnswerNb = correctAnswerNb;
    }

    public int getTotalQuestionNb() {
        return totalQuestionNb;
    }

    public void setTotalQuestionNb(int totalQuestionNb) {
        this.totalQuestionNb = totalQuestionNb;
    }

    public int getCurrentQuestionNb() {
        return currentQuestionNb;
    }

    public void setCurrentQuestionNb(int currentQuestionNb) {
        this.currentQuestionNb = currentQuestionNb;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMatiere() {
        return matiere;
    }

    public double getTimePerQuestion() {
        return timePerQuestion;
    }

    public void setTimePerQuestion(double timePerQuestion) {
        this.timePerQuestion = timePerQuestion;
    }

    public void addToPreviousQ(int a){
        this.previousQuestions.add(a);
    }

    public List<Integer> getToPreviousQ(){
        return  this.previousQuestions;
    }

}
