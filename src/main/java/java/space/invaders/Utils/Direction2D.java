package java.space.invaders.Utils;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Direction2D {
	private final int _velocity;
	private int _dx;
	private int _dy;

	public Direction2D(int velocity) {
		this._velocity = velocity;

		this._dx = 0;
		this._dy = 0;
	}

	public void apply(Vector2D vector) {
		vector.move(this._velocity * this._dx,
			this._velocity * this._dy);
	}

	public int velocity() {
		return this._velocity;
	}

	public int dX() {
		return this._dx;
	}

	public int dY() {
		return this._dy;
	}

	public Direction2D toLeft() {
		this._dx = -1;
		return this;
	}

	public Direction2D toRight() {
		this._dx = 1;
		return this;
	}

	public Direction2D toUp() {
		this._dy = -1;
		return this;
	}

	public Direction2D toDown() {
		this._dy = 1;
		return this;
	}
}
