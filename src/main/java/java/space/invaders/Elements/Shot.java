package java.space.invaders.Elements;

/**
 *
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Shot extends Element {
	public Shot (String src) {
		super(src, 0, 0);
	}

	public Shot (
		String src,
		int x,
		int y,
		int horizontalSpacing,
		int verticalSpacing
	) {
		super(src, x, y);

		this.box().coord().apply(
			this.box().coord().x() + horizontalSpacing,
			this.box().coord().y() + verticalSpacing);
	}
}
