package VueControleur.Menus;



import Modele.ModeleMenu;
import VueControleur.MiniJeux.Quizz;
import MiniJeuGuillotine.*;

import java.awt.*;
import java.util.Arrays;

public class Test {
    public String convertToHTML(String entry){
        int i = 1;
        String[] splitted = entry.split(" ");
        String retour = "<html>";
        while(i < splitted.length){
            if(i % 8 != 0){
                retour = retour + " " + splitted[i-1];
            } else {
                retour = retour + " <br/> " + splitted[i-1];
            }
            i++;
        }
        retour = retour +  "</html>";
        return retour;
    }


    public static void main(String[] args) {

        Test test = new Test();
        };
    }

