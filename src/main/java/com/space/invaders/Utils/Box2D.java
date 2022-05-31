package com.space.invaders.Utils;

import java.awt.Rectangle;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public abstract class Box2D {
	private int _width;
	private int _height;
	private Vector2D _coordinates;

	public Box2D(int x, int y, int width, int height) {
		this._width = width;
		this._height = height;

		this._coordinates = new Vector2D(x, y);
	}

	public int top() {
		return this._coordinates.y();
	}

	public int bottom() {
		return this._coordinates.y() + this._height;
	}

	public int left() {
		return this._coordinates.x();
	}

	public int right() {
		return this._coordinates.x() + this._width;
	}

	public int width() {
		return this._width;
	}

	public int height() {
		return this._height;
	}

	public Vector2D vector() {
		return this._coordinates;
	}

	public boolean hasCollidedWith(Box2D x) {
		boolean inMiddleX = (x.right() >= this.left()
				&& x.right() <= this.right())
				|| (x.left() >= this.left() && x.right() <= this.right());

		boolean inMiddleY =
				(x.bottom() >= this.top() && x.bottom() <= this.bottom())
						|| (x.top() >= this.top() && x.top() <= this.bottom());

		return inMiddleX && inMiddleY;
	}
}
