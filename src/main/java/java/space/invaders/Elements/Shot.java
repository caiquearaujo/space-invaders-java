package java.space.invaders.Elements;

import java.space.invaders.Screen;
import java.space.invaders.Interfaces.Actable;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Shot extends Element implements Actable {
	public static final String IMAGE_SRC = "/src/images/player-shot.png";

	public Shot() {
		super(Shot.IMAGE_SRC, 0, 0);
	}

	public Shot(String src, int x, int y, int horizontalSpacing,
			int verticalSpacing) {
		super(Shot.IMAGE_SRC, x, y);

		this.vector().apply(this.vector().x() + horizontalSpacing,
				this.vector().y() + verticalSpacing);
	}

	public void act(Screen screen) {
		this.actMoviment();
	}

	public void actMoviment() {
		if (!this.isVisible()) {
			return;
		}

		if (this.bottom() < 0) {
			this.mustDie();
			return;
		}

		this.vector().applyY(this.vector().y() - 4);
	}
}
