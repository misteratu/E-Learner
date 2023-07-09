package VueControleur.MiniJeux.QuizzUtils;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class QuestionsReponsesSciences {

    JSONArray jsonArray;

    public QuestionsReponsesSciences() throws IOException, ParseException {
        JSONParser jsonP = new JSONParser();
        jsonArray = (JSONArray) jsonP.parse(new FileReader("src/VueControleur/MiniJeux/QuizzUtils/QRSciences.json"));

    }

    public String getQuestionSciences(int i) {

        JSONObject firstPerson = (JSONObject) jsonArray.get(i);
        String question = (String) firstPerson.get("question");
        return question;
    }

    public String getBonneReponseSciences(int i) {

        JSONObject firstPerson = (JSONObject) jsonArray.get(i);
        String bonnereponse = (String) firstPerson.get("bonnereponse");
        return bonnereponse;
    }

    public String[] getReponsesSciences(int i) {

        JSONObject firstPerson = (JSONObject) jsonArray.get(i);
        String reponse2 = (String) firstPerson.get("reponse2");
        String reponse3 = (String) firstPerson.get("reponse3");
        String reponse4 = (String) firstPerson.get("reponse4");
        String[] reponses = {reponse2, reponse3, reponse4};
        return reponses;
    }

}
