package object;

import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * Classe Controleur pour importer l'image du trésor
 */
public class OBJ_Chest extends SuperObject{

	public OBJ_Chest() {

		name ="Chest";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("./objects/chest.png"));
		}catch (IOException e) {
			e.printStackTrace();

		}
		collision = true;
	}
}
