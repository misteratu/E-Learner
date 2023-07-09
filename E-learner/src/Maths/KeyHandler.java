package Maths;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Dehmani Mohammed
 * Classe Controleur qui gére le mouvement du joueur
 *
 */
public class KeyHandler implements KeyListener {

	public boolean upPressed ;
	public boolean downPressed;
	public boolean leftPressed;
	public boolean rightPressed;


	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Procédure qui gére l'action qui se produit lorsque le
	 * joueur appuie sur le clavier
	 * @param e boutton de clavier appuyé
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();

		if (code == KeyEvent.VK_UP) {
			upPressed = true;
		}
		if (code == KeyEvent.VK_DOWN) {
			downPressed = true;
		}
		if (code == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if (code == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}

	}

	/**
	 * Procédure qui gére l'action qui se produit lorsque le
	 * joueur lache le clavier
	 * @param e boutton de clavier laché
	 */
	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();

		if (code == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}

	}

	public void stopPlayer() {
		this.upPressed = false;
		this.downPressed = false;
		this.leftPressed = false;
		this.rightPressed = false;
	}

}
