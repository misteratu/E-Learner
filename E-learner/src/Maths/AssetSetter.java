package Maths;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Monster1;
import object.OBJ_Monster2;
import object.OBJ_Monster3;
import object.OBJ_Sword;

/*
 * Classe modéle qui gére la taille des objets dans la map
 */
public class AssetSetter {

	GamePanel gp;

	/**
	 * Constructeur de classe
	 * @param gp
	 */
	public AssetSetter(GamePanel gp) {
		this.gp =gp;
	}

	/**
	 * Procédure pour définir la taille des objets
	 * dans la map du jeu
	 */
	public void setObject() {

		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;

		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldX = 38 * gp.tileSize;
		gp.obj[1].worldY = 13 * gp.tileSize;

		gp.obj[2] = new OBJ_Door();
		gp.obj[2].worldX = 10 * gp.tileSize;
		gp.obj[2].worldY = 11 * gp.tileSize;

		gp.obj[3] = new OBJ_Chest();
		gp.obj[3].worldX = 10 * gp.tileSize;
		gp.obj[3].worldY = 7 * gp.tileSize;

		gp.obj[4] = new OBJ_Sword();
		gp.obj[4].worldX = 38 * gp.tileSize;
		gp.obj[4].worldY = 9 * gp.tileSize;

		gp.obj[5] = new OBJ_Monster1();
		gp.obj[5].worldX = 36 * gp.tileSize;
		gp.obj[5].worldY = 30 * gp.tileSize;

		gp.obj[6] = new OBJ_Monster2();
		gp.obj[6].worldX = 23 * gp.tileSize;
		gp.obj[6].worldY = 34 * gp.tileSize;

		gp.obj[7] = new OBJ_Monster3();
		gp.obj[7].worldX = 8 * gp.tileSize;
		gp.obj[7].worldY = 27 * gp.tileSize;
	}
}
