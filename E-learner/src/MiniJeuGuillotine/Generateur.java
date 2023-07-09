package MiniJeuGuillotine;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Generateur {
    private Set<Integer> generatedNumbers;
    private Random random;
    private int nbQuestion = 47;

    public Generateur() {
        generatedNumbers = new HashSet<>();
        random = new Random();
    }
    
    public Generateur(int nbQuestion) {
        generatedNumbers = new HashSet<>();
        random = new Random();
        this.nbQuestion = nbQuestion;
    }

    public int generateUniqueNumber() {
        int number;
        do {
            number = random.nextInt(nbQuestion); // Génère un entier aléatoire entre 0 et 46 inclus
        } while (generatedNumbers.contains(number));

        generatedNumbers.add(number);
        return number;
    }
}
