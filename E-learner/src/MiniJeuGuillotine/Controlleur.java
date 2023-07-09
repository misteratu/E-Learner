package MiniJeuGuillotine;

/**
 * Contrôleur du jeu.
 */

public class Controlleur {
	
	private Scene scene;
	private Modele model;
	private String truth;

	private boolean isOk = true;
		
	
	public Controlleur(Scene scene) {
		
	    this.model = new Modele();
	    this.scene = scene;
	    truth = "Empty";
	}
	
	
	public void actionToDo(String answer) {
		if (model.getNbQuestion() < model.getNbQuestionTot() && model.getNError() < Modele.nbFautesMax) {
			// Crée un vérificateur de réponse de jeu pour les réponses de type chaîne de caractères
			GameAnswerChecker<String> answerChecker = new StringChecker();
		
			// Vérifie la réponse de l'utilisateur par rapport à la réponse correcte
			Boolean truthSocial = answerChecker.checkAnswer(answer, model.getCorrectAnswer());
		
			// Incrémente le nombre de questions posées dans le modèle
			model.incrementNbQuestion();
		
			if (!truthSocial) {
			// Incrémente le nombre d'erreurs dans le modèle
				model.incrementNError();
			                
			    // Met à jour la scène avec les données actuelles indiquant une réponse fausse
			    truth = "False";
			} else {
			    // Met à jour la scène avec les données actuelles indiquant une réponse correcte
			    truth = "True";
			                
			}
		}else{
			isOk = false;
		}
	}
	
	public int requestnError() {
		return model.getNError();
	}
	
	public String requestQuestion() {
		return model.getQuestion();
	}
	
	public String requestTruth() {
		return truth;
	}
	
	public int requestnNbQuestion() {
		return model.getNbQuestion();
	}

	public boolean isOk() {
		return isOk;
	}
}