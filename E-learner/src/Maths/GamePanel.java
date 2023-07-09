package Maths;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import entity.Player;
import tile.TileManager;
import object.SuperObject;

/*
 * Classe vue qui représente le game screen
 */
public class GamePanel extends JPanel implements Runnable {

	// Screen Settings
	final int originalTileSize = 16;
	final int scale = 3;

	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeigth = tileSize * maxScreenRow;

	// WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int maxWorldWidth = tileSize * maxWorldCol;
	public final int maxWorldHeight = tileSize * maxWorldRow;

	// FPS
	int FPS = 60;

	TileManager tileM = new TileManager(this);
	KeyHandler KeyH = new KeyHandler();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player;
	public SuperObject obj[] = new SuperObject[10];

	/**
	 * Constructeur de classe
	 */
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeigth));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(KeyH);
		this.setFocusable(true);

	}

	/**
	 * Importation des objets utilisés dans le jeu
	 */
	public void setupGame() {
		aSetter.setObject();

	}

	/**
	 * Procedure pour lancer le jeu
	 */
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	/**
	 * Procedure pour gérer le mouvement du joueur
	 */
	@Override
	public void run() {

		double drawInterval = 1000000000 / FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {

			// UPDATE: update information such as character position
			update();
			// DRAW: draw the session with the update information
			repaint();

			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;

				if (remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Procedure pour dessiner le mouvement du joueur
	 */
	public void update() {

		player.update();
	}

	/*
	 * Procédure pour dessiner la map du jeu
	 * @param g graphisque du jeu
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// Background
		tileM.draw(g2);

		// Object
		for (int i = 0; i< obj.length; i++) {
			if (obj[i] != null) {
				obj[i].draw(g2,  this);
			}
		}

		// Player
		player.draw(g2);

		g2.dispose();
	}
}
