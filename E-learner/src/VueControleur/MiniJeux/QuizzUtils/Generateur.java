package VueControleur.MiniJeux.QuizzUtils;

import java.util.List;
import java.util.Random;

public class Generateur {
    private Random random;
    private int nbQuestion = 47;
    private int debut = 10;

    public Generateur() {
        random = new Random();
    }
    
    public Generateur(int debut, int nbQuestion) {
        random = new Random();
        this.nbQuestion = nbQuestion;
        this.debut = debut;
    }
    
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(nbQuestion - debut + 1) + debut;
    }
    
    public int generateRandomNumber(List<Integer> histoQ) {
        int randomNumber;
        do {
            randomNumber = random.nextInt(nbQuestion - debut + 1) + debut;
        } while (histoQ.contains(randomNumber));

        return randomNumber;
    }
}
