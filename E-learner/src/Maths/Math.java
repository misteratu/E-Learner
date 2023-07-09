package Maths;

import javax.swing.JFrame;

import entity.PlayerCE1;
import entity.PlayerCE2;
import entity.PlayerCM1;
import entity.PlayerCM2;
import entity.PlayerCP;

/**
 *
 * @author Dehmani Mohammed
 * Classe principale qui regroupe tous les élements du jeu
 *
 */

public class Math {

	/**
	 * Constructeur de classe qui lance le jeu selon le niveaux
	 * @param niveau
	 */
	public Math(String niveau) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Labrynthe");

		GamePanel gamePanel = new GamePanel();
		switch (niveau) {
			case "CP":
				gamePanel.player = new PlayerCP(gamePanel, gamePanel.KeyH);
				break;
			case "CE1":
				gamePanel.player = new PlayerCE1(gamePanel, gamePanel.KeyH);
				break;
			case "CE2":
				gamePanel.player = new PlayerCE2(gamePanel, gamePanel.KeyH);
				break;
			case "CM1":
				gamePanel.player = new PlayerCM1(gamePanel, gamePanel.KeyH);
				break;
			case "CM2":
				gamePanel.player = new PlayerCM2(gamePanel, gamePanel.KeyH);
				break;
			default:
				break;
		}

		window.add(gamePanel);

		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);
		gamePanel.setupGame();
		gamePanel.startGameThread();
	}

}