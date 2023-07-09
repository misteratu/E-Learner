package entity;

import javax.swing.JOptionPane;

import Maths.GamePanel;
import Maths.KeyHandler;
import games.aireGame;
import games.divisibleGame;
import games.perimetreGame;

/**
 * Classe Controleur qui gére la recontre des monstres
 * pour le niveau CM1
 * @author Dehmani Mohammed
 *
 */
public class PlayerCM1 extends Player {

	public PlayerCM1(GamePanel gp, KeyHandler KeyH) {
		super(gp, KeyH);
	}

	/**
	 * Procedure pour la gestion des objets selon le niveau
	 * @param i indice de l'objet
	 */
	@Override
	public void pickUpObject(int i) {

		if (i != 999) {
			String objectName = gp.obj[i].name;

			switch (objectName) {
				case "Key":
					hasKey++;
					gp.obj[i] = null;
					System.out.println("key: " + hasKey);
					break;
				case "Door":
					if (hasKey > 0) {
						gp.obj[i] = null;
						hasKey--;
					}
					System.out.println("key: " + hasKey);
					break;
				case "Chest":
					if (hasKey > 0) {
						gp.obj[i] = null;
						hasKey--;
					}
					JOptionPane.showMessageDialog(gp, "Très bien, vous maitrisez le programme de CP ");
					System.exit(0);
					break;
				case "Sword":
					gp.obj[i] = null;
					hasSword = true;
					System.out.println("Player can fight with monsters");
					break;
				case "Monster1":
					KeyH.stopPlayer();
					if (hasSword = true) {
						new perimetreGame();
						gp.obj[i] = null;
					}
					break;
				case "Monster2":
					KeyH.stopPlayer();
					if (hasSword = true) {
						new divisibleGame();
						gp.obj[i] = null;
					}
					break;
				case "Monster3":
					KeyH.stopPlayer();
					if (hasSword = true) {
						new aireGame();
						gp.obj[i] = null;
					}
					break;
			}
		}
	}

}
