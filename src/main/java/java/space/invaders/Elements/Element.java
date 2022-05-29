package java.space.invaders.Elements;

import java.space.invaders.Utils.Draw;

/**
 *
 * @author Caique Araujo <caique@piggly.com.br>
 */
public abstract class Element extends Draw {
	public Element (String src, int x, int y) {
		super(Draw.load(src), x, y);
	}
}
