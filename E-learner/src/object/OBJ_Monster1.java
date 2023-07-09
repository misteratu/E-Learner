package object;

import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * Classe Controleur pour importer l'image du monstre1
 */
public class OBJ_Monster1 extends SuperObject{

	public OBJ_Monster1() {

		name ="Monster1";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("./objects/bat_down_2.png"));
		}catch (IOException e) {
			e.printStackTrace();

		}
		collision = true;
	}
}
