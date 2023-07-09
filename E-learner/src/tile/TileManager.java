package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import javax.imageio.ImageIO;

import Maths.GamePanel;

/**
 * Classe Modéle pour la gestion de la map
 * @author Dehmani Mohammed
 *
 */
public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];

	/**
	 * Constructeur qui import le design de la map
	 * @param gp
	 */
	public TileManager (GamePanel gp) {

		this.gp = gp;

		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

		getTileImage();
		loadMap("./maps/world01.txt");
	}

	/**
	 * Procédure d'importation des difféent élement qui constitue
	 * le monde du jeu avec précision de collision
	 */
	public void getTileImage() {
		try {

			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("./tiles/grass.png"));

			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("./tiles/wall.png"));
			tile[1].collision = true;

			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("./tiles/water.png"));
			tile[2].collision = true;

			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("./tiles/earth.png"));

			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("./tiles/arbre.png"));
			tile[4].collision = true;

			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("./tiles/sand.png"));

		} catch(IOException e) {
			e.printStackTrace();

		}

	}

	/**
	 * Procédure pour importer un fihier texte et le 
	 * convertir en un design de map
	 * @param filePath
	 */
	public void loadMap(String filePath) {

		try {

			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;

			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

				String line = br.readLine();

				while (col < gp.maxWorldCol)  {

					String number[] = line.split(" ");
					int num = Integer.parseInt(number[col]);

					mapTileNum[col][row] = num;
					col ++;

				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch(Exception e) {

		}
	}

	/**
	 * Procédure qui déssine le modéle du monde de jeu (map)
	 * @param g2
	 */
	public void draw (Graphics2D g2) {

		int worldCol = 0;
		int worldRow =0;


		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

			int tileNum = mapTileNum[worldCol][worldRow];

			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX + gp.player.screenX - gp.player.worldX;
			int screenY = worldY + gp.player.screenY - gp.player.worldY;

			if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
					worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
					worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
					worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}

			worldCol++;

			if (worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}


		}

	}
}
