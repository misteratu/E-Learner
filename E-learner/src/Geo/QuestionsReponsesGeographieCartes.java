package Geo;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class QuestionsReponsesGeographieCartes {

    JSONArray jsonArray;

    public QuestionsReponsesGeographieCartes() throws IOException, ParseException {
        JSONParser jsonP = new JSONParser();
        jsonArray = (JSONArray) jsonP.parse(new FileReader("src/Geo/QRGeographieCartes.json"));

    }

    public String getQuestionGeographieCartes(int i) {

        JSONObject firstPerson = (JSONObject) jsonArray.get(i);
        String question = (String) firstPerson.get("question");
        return question;
    }

    public String getBonneReponseGeographieCartes(int i) {

        JSONObject firstPerson = (JSONObject) jsonArray.get(i);
        String bonnereponse = (String) firstPerson.get("bonnereponse");
        return bonnereponse;
    }

    public String[] getReponsesGeographieCartes(int i) {

        JSONObject firstPerson = (JSONObject) jsonArray.get(i);
        String reponse2 = (String) firstPerson.get("reponse2");
        String reponse3 = (String) firstPerson.get("reponse3");
        String reponse4 = (String) firstPerson.get("reponse4");
        String[] reponses = {reponse2, reponse3, reponse4};
        return reponses;
    }

}
