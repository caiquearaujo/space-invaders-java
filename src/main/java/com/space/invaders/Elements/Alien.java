package com.space.invaders.Elements;

import java.awt.Graphics;
import com.space.invaders.Screen;
import com.space.invaders.Utils.Direction2D;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Alien extends Element {
	public static final String IMAGE_SRC = "src/images/alien.png";

	private final Direction2D _direction;
	// private final Bomb _bomb;

	public Alien(int x, int y) {
		super(Alien.IMAGE_SRC, x, y);
		this._direction = new Direction2D(1);

		this._direction.toRight();
		// this._bomb = new Bomb(this, x, y);
	}

	public void move() {
		if (!this.isVisible()) {
			return;
		}

		if (this.left() <= 0 || this.right() >= 356) {
			if (this._direction.dX() < 1) {
				this._direction.toRight();
			} else {
				this._direction.toLeft();
			}

			this.vector().moveY(15);
		}

		this.vector()
				.moveX(this._direction.dX() * this._direction.velocity());
	}

	public void paint(Graphics g, Screen screen) {
		super.paint(g, screen);
		// this._bomb.paint(g, screen);
	}

	// public Bomb bomb() {
	// // return this._bomb;
	// }
}
