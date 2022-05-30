package com.space.invaders.Elements;

import java.awt.Graphics;
import com.space.invaders.Screen;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Player extends Element {
	public static final String IMAGE_SRC = "src/images/player.png";

	private final int _velocity;

	private Shot _shot;
	private int _direction;

	public Player(int x, int y, int velocity) {
		super(Player.IMAGE_SRC, x, y);

		this._velocity = velocity;
		this._direction = 0;

		this._shot = new Shot(-100, -100);
		this._shot.die();
	}

	public void fire() {
		if (this._shot.isVisible()) {
			return;
		}

		this._shot = new Shot(this.vector().x(), this.vector().y());
		this._shot.show();
	}

	public void walkToLeft() {
		this._direction = -1;
	}

	public void walkToRight() {
		this._direction = 1;
	}

	public void stopWalk() {
		this._direction = 0;
	}

	public void move() {
		this.vector().moveX(this._direction * this._velocity);
	}

	public void thresholdOnScreen(int minLimit, int maxLimit) {
		if (this.left() <= minLimit) {
			this.vector().applyX(minLimit);
		} else if (this.right() >= maxLimit) {
			this.vector().applyX(maxLimit - this.width());
		}
	}

	public void paint(Graphics g, Screen screen) {
		super.paint(g, screen);
		this._shot.paint(g, screen);
	}

	public Shot shot() {
		return this._shot;
	}
}
