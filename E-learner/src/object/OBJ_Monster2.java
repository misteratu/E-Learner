package object;

import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * Classe Controleur pour importer l'image du monstre2
 */
public class OBJ_Monster2 extends SuperObject{

	public OBJ_Monster2() {

		name ="Monster2";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("./objects/orc_down_1.png"));
		}catch (IOException e) {
			e.printStackTrace();

		}
		collision = true;
	}
}
