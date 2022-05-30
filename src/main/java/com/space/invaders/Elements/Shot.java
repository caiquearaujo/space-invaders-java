package com.space.invaders.Elements;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Shot extends Element {
	public static final String IMAGE_SRC = "src/images/shot.png";

	public Shot(int x, int y) {
		super(Shot.IMAGE_SRC, x, y);
		this.vector().apply(this.vector().x() + 6, this.vector().y() + 6);
	}

	public void move() {
		if (!this.isVisible()) {
			return;
		}

		if (this.bottom() < 0) {
			this.mustDie();
			return;
		}

		this.vector().moveY(-4);
	}
}
