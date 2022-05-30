package java.space.invaders.Elements;

import java.space.invaders.Screen;
import java.space.invaders.Interfaces.Actable;
import java.util.Random;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Bomb extends Element implements Actable {
	public static final String IMAGE_SRC = "/src/images/alien-bomb.png";

	private Alien _parent;
	private boolean _destroyed;

	public Bomb(Alien parent, int x, int y) {
		super(Bomb.IMAGE_SRC, x, y);
		this._destroyed = false;
		this._parent = parent;
	}

	public void act(Screen screen) {
		this.actLaunching(screen);
		this.actCollision(screen);
		this.actMoviment(screen);
	}

	private void actLaunching(Screen screen) {
		if (this.isVisible() || new Random().nextInt(15) != 5) {
			return;
		}

		this.vector().copy(this._parent.vector());
		this.show();
	}

	private void actCollision(Screen screen) {
		if (!screen.player.isVisible() || !this.isVisible()) {
			return;
		}

		if (this.hasCollidedWith(screen.player)) {
			if (screen.score.hasLife()) {
				screen.score.decreaseLife();
			} else {
				screen.player.mustDie();
			}

			this.hide();
		}
	}

	private void actMoviment(Screen screen) {
		if (!this.isVisible()) {
			return;
		}

		this.vector().moveY(1);

		if (this.bottom() >= screen.dimension.height) {
			this.hide();
		}
	}

	public boolean isDestroyed() {
		return this._destroyed;
	}

	public void destroy() {
		this._destroyed = true;
	}
}
