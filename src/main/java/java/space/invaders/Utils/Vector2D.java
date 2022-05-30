package java.space.invaders.Utils;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Vector2D {
	private int _x;
	private int _y;

	public Vector2D() {
		this.apply(0, 0);
	}

	public Vector2D(int x, int y) {
		this.apply(x, y);
	}

	public int x() {
		return this._x;
	}

	public int y() {
		return this._y;
	}

	public Vector2D move(int incrementX, int incrementY) {
		this.moveX(incrementX).moveY(incrementY);
		return this;
	}

	public Vector2D moveX(int increment) {
		this._x += increment;
		return this;
	}

	public Vector2D moveY(int increment) {
		this._y += increment;
		return this;
	}

	public Vector2D copy(Vector2D vector) {
		this._x = vector.x();
		this._y = vector.y();
		return this;
	}

	public void apply(int x, int y) {
		this.applyX(x).applyY(y);
	}

	public Vector2D applyX(int x) {
		this._x = x;
		return this;
	}

	public Vector2D applyY(int y) {
		this._y = y;
		return this;
	}
}
