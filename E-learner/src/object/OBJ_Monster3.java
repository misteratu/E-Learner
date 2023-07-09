package object;

import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * Classe Controleur pour importer l'image du monstre3
 */
public class OBJ_Monster3 extends SuperObject{

	public OBJ_Monster3() {

		name ="Monster3";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("./objects/skeletonlord_phase2_down_1.png"));
		}catch (IOException e) {
			e.printStackTrace();

		}
		collision = true;
	}
}
