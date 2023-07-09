package object;

import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * Classe Controleur pour importer l'image de la clé
 */
public class OBJ_Key extends SuperObject{

	public OBJ_Key() {

		name ="Key";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("./objects/key.png"));
		}catch (IOException e) {
			e.printStackTrace();

		}
		collision = true;
	}
}
