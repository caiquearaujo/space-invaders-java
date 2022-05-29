package java.space.invaders.Utils;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Draw {
	private final Box2D _box;
	private final Image _image;

	private boolean _visible;
	private boolean _dying;

	public Draw (Image image, int x, int y) {
		this._visible = true;
		this._dying = false;

		this._image = image;
		this._box = new Box2D(x, y, image.getWidth(null), image.getHeight(null));
	}

	public Box2D box () {
		return this._box;
	}

	public Image image () {
		return this._image;
	}

	public boolean isVisible () {
		return this._visible;
	}

	public void setVisibility (boolean visibility) {
		this._visible = visibility;
	}

	public boolean isDying () {
		return this._dying;
	}

	public void mustDie () {
		this._dying = true;
	}

	public void die () {
		this._visible = false;
	}

	public static Image load (String src) {
		ImageIcon image = new ImageIcon(src);
		return image.getImage();
	}
}
