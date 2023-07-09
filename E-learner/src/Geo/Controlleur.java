package Geo;
import java.io.IOException;

import org.json.simple.parser.ParseException;


public class Controlleur {

    ModeleQuizz modele; // Instance du modèle utilisé pour la gestion du jeu.

    int indexMatiere; // Index de la question dans la matière sélectionnée.
    boolean isFinish = false;

    /**
     * Constructeur de la classe Controlleur.
     * @param matiere la matière du quizz.
     * @param niveau le niveau du quizz.
     */
    public Controlleur(String matiere, String niveau) {
        super();
        modele = new ModeleQuizz(matiere, niveau, 10, 10);
        choixNumeroQuestion();
        modele.addToPreviousQ(indexMatiere);
    }

    /**
     * Méthode pour choisir le numéro de la question en fonction de la matière et du niveau.
     * Met à jour l'index de la matière.
     */
    public void choixNumeroQuestion() {
        Generateur generateur = new Generateur();
        generateur = new Generateur(1, 29);

        // Génération d'un numéro de question unique à partir du générateur
        indexMatiere = generateur.generateRandomNumber(modele.getToPreviousQ());
    }

    /**
     * Méthode pour effectuer la récupération des questions et réponses en fonction de la matière.
     * Met à jour les données du modèle.
     */
    public String[] recuperation() {
        // Initialisation des variables de question, réponse et autres réponses par défaut
        String question = "coucou";
        String reponse = "coucou";
        String[] autresReponses = new String[] {"Coucou", "Coucou", "Coucou"};

        try {
            QuestionsReponsesGeographieCartes qrHistoire = new QuestionsReponsesGeographieCartes();
            question = qrHistoire.getQuestionGeographieCartes(indexMatiere);
            reponse = qrHistoire.getBonneReponseGeographieCartes(indexMatiere);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Récupération de la question et des réponses possibles.
        String[]questionReponses = new String[] {question, reponse, autresReponses[0], autresReponses[1], autresReponses[2]};
        return questionReponses;
    }

    /**
     * Méthode pour exécuter l'action correspondant à un bouton cliqué.
     *
     * @param i Le numéro du bouton cliqué.
     */
    public void actionToDo(String ville) {
        // Vérification si le bouton cliqué est le bon bouton
        if (ville.equals(recuperation()[1])) {
            // Incrémentation du nombre de bonnes réponses
            modele.setCorrectAnswerNb(modele.getCorrectAnswerNb() + 1);

            modele.setCurrentQuestionNb(modele.getCurrentQuestionNb() + 1);
            choixNumeroQuestion();
            modele.addToPreviousQ(indexMatiere);

        } else {
            // Affichage du message "Faux"
        }

        // Incrémentation du nombre de questions courantes
        if (modele.getCurrentQuestionNb() + 1 > modele.getTotalQuestionNb()){
            System.out.println("Arret du jeu retour au menu");
            isFinish = true;

        }else {
            modele.setCurrentQuestionNb(modele.getCurrentQuestionNb() + 1);
        }
    }

    public boolean isFinish() {
        return isFinish;
    }

    public String requestQuestion() {
        String[] liste = recuperation();
        return liste[0];
    }

    public int requestNbBonneQuestion() {
        return modele.getCorrectAnswerNb();
    }

    public int requestNbQuestion() {
        return modele.getCurrentQuestionNb();
    }

}
