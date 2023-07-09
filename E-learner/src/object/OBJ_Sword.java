package object;

import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * Classe Controleur pour importer l'image de l'épée
 */
public class OBJ_Sword extends SuperObject{

	public OBJ_Sword() {

		name ="Sword";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("./objects/sword_normal.png"));
		}catch (IOException e) {
			e.printStackTrace();

		}
		collision = true;
	}
}