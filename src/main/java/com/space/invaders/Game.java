package com.space.invaders;

import com.space.invaders.Adapters.ControllerAdapter;
import com.space.invaders.Elements.Player;
import java.awt.Color;
import java.awt.Graphics;

public class Game implements Runnable {
	public Player player;

	private boolean _playing;
	private Screen _screen;

	public Game(int lives, Screen screen) {
		this._screen = screen;
		this.init();
	}

	public void init() {
		this.player = new Player(270, 280, 2);

		this._screen.addKeyListener(new ControllerAdapter(this.player));
		this.start();
	}

	public void run() {
		this.player.move();
		this.player.thresholdOnScreen(2, this._screen.dimension.width - 12);

		if (this.player.isDying()) {
			this.stop();
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawLine(0, 290, this._screen.dimension.width, 290);

		this.player.paint(g, this._screen);
		// this.score.paint(g, this);
	}

	public void start() {
		this._playing = true;
	}

	public boolean isPlaying() {
		return this._playing;
	}

	public void stop() {
		this._playing = false;
	}
}
