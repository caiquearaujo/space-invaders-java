package java.space.invaders.Controllers;

import java.space.invaders.Elements.Player;
import java.space.invaders.Utils.Direction2D;
import java.awt.event.KeyEvent;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class PlayerController {
	private final Player _player;
	private final Direction2D _direction;

	public PlayerController(Player player, int velocity) {
		this._player = player;
		this._direction = new Direction2D(velocity);
	}

	public void onActing(int min, int max) {
		this._direction.apply(this._player.vector());

		int x = this._player.vector().x();

		if (x <= min) {
			this._player.vector().applyX(min);
		} else if (x >= max) {
			this._player.vector().applyX(max);
		}
	}

	public void onMove(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_LEFT -> this._direction.toLeft();
		case KeyEvent.VK_RIGHT -> this._direction.toRight();
		}
	}
}
