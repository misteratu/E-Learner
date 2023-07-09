package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Maths.GamePanel;
import Maths.KeyHandler;

/**
 * Classe Abstraite Modéle pour gérer le mpoement et
 * le positionnement du joueur
 * @author Dehmani Mohammed
 *
 */
public abstract class Player extends Entity {

	GamePanel gp;
	KeyHandler KeyH;
	public final int screenX;
	public final int screenY;
	int hasKey = 0;
	boolean hasSword = false;

	/**
	 * Constructeur de la classe Player
	 * @param gp
	 * @param KeyH
	 */
	public Player(GamePanel gp, KeyHandler KeyH) {

		this.gp = gp;
		this.KeyH = KeyH;

		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeigth / 2 - (gp.tileSize / 2);

		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 8;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;

		setDefaultValues();
		getPlayerImage();
	}

	/**
	 * Procédure pour définir les valeurs par défauts
	 */
	public void setDefaultValues() {

		worldX = gp.tileSize * 33;
		worldY = gp.tileSize * 7;
		speed = 4;
		direction = "down";
	}

	/**
	 * Procédure qui génére l'iage selon le mouement du joueur
	 */
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("./player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("./player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("./player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("./player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("./player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("./player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("./player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("./player/boy_right_2.png"));
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/**
	 * Procédure pour gérer le mouvement de joueur
	 */
	public void update() {
		if (KeyH.upPressed == true || KeyH.downPressed == true || KeyH.leftPressed == true
				|| KeyH.rightPressed == true) {
			if (KeyH.upPressed == true) {
				direction = "up";
			} else if (KeyH.downPressed == true) {
				direction = "down";
			} else if (KeyH.leftPressed == true) {
				direction = "left";
			} else if (KeyH.rightPressed == true) {
				direction = "right";

			}

			// Check Tile Collision
			collisionOn = false;
			gp.cChecker.checkTile(this);

			// Check Object collision
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);

			if (collisionOn == false) {
				switch (direction) {
					case "up":
						worldY -= speed;
						break;

					case "down":
						worldY += speed;
						break;

					case "left":
						worldX -= speed;
						break;

					case "right":
						worldX += speed;
						break;
				}
			}

			spriteCounter++;
			if (spriteCounter > 12) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}

	}

	/**
	 * procedure pour dessiner les updates du mouvement
	 * du joueur dans le jeu
	 * @param g2
	 */
	public void draw(Graphics2D g2) {

		BufferedImage image = null;

		switch (direction) {
			case "up":
				if (spriteNum == 1) {
					image = up1;
				}
				if (spriteNum == 2) {
					image = up2;
				}
				break;
			case "down":
				if (spriteNum == 1) {
					image = down1;
				}
				if (spriteNum == 2) {
					image = down2;
				}
				break;
			case "left":
				if (spriteNum == 1) {
					image = left1;
				}
				if (spriteNum == 2) {
					image = left2;
				}
				break;
			case "right":
				if (spriteNum == 1) {
					image = right1;
				}
				if (spriteNum == 2) {
					image = right2;
				}
				break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

	}

	/**
	 * procedure abstraite pour la gestion des objets dans le jeu
	 * @param i
	 */
	public abstract void pickUpObject(int i);
}
