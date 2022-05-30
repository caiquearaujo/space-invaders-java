package java.space.invaders.Elements;

import java.space.invaders.Screen;
import java.awt.Graphics;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Alien extends Element {
	public static final String IMAGE_SRC = "/src/images/alien.png";

	private final Bomb _bomb;

	public Alien(int x, int y) {
		super(Alien.IMAGE_SRC, x, y);
		this._bomb = new Bomb(this, x, y);
	}

	public boolean gotHit(Shot shot) {
		if (!(this.isVisible() && shot.isVisible())) {
			return false;
		}

		if (shot.hasCollidedWith(this)) {
			this.mustDie();
			shot.mustDie();
			return true;
		}

		return false;
	}

	public void paint(Graphics g, Screen screen) {
		super.paint(g, screen);
		this._bomb.paint(g, screen);
	}

	public Bomb bomb() {
		return this._bomb;
	}
}
