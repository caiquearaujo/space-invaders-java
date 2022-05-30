package com.space.invaders.Utils;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import com.space.invaders.Screen;
import com.space.invaders.Interfaces.Paintable;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public abstract class Draw extends Box2D implements Paintable {
	private final Image _image;

	private boolean _visible;
	private boolean _dying;

	public Draw(Image image, int x, int y) {
		super(x, y, image.getWidth(null), image.getHeight(null));

		this._visible = true;
		this._dying = false;

		this._image = image;
	}

	public Image image() {
		return this._image;
	}

	public boolean isVisible() {
		return this._visible;
	}

	public void show() {
		this._visible = true;
	}

	public void hide() {
		this._visible = false;
	}

	public boolean isDying() {
		return this._dying;
	}

	public void mustDie() {
		this._dying = true;
	}

	public void die() {
		this._visible = false;
	}

	public boolean gotHitBy(Draw draw) {
		if (!this.isVisible() || !draw.isVisible()) {
			return false;
		}

		return draw.hasCollidedWith(this);
	}

	public void paint(Graphics g, Screen screen) {
		if (this._visible) {
			g.drawImage(this._image, this.vector().x(), this.vector().y(),
					screen);
		}

		if (this._dying) {
			this.die();
		}
	}

	public static Image load(String src) {
		ImageIcon image = new ImageIcon(src);
		return image.getImage();
	}
}
