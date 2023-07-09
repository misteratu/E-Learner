package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Maths.GamePanel;

import java.awt.Rectangle;

/**
 * Classe vu pour les objets utilisés
 * @author Dehmani Mohammed
 *
 */
public class SuperObject {

	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX;
	public int solidAreaDefaultY;

	/**
	 * Proccédure draw utilisé pour dessiner les objets 
	 * dans la map correctement
	 * @param g2
	 * @param gp
	 */
	public void draw(Graphics2D g2, GamePanel gp) {

		int screenX = worldX + gp.player.screenX - gp.player.worldX;
		int screenY = worldY + gp.player.screenY - gp.player.worldY;

		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
	}

}
