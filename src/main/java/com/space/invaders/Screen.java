package com.space.invaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Screen extends JPanel implements Runnable {
	public Dimension dimension;

	private Thread _thread;
	private Game _game;

	public Screen(int lives, int width, int height) {
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		this.dimension = new Dimension(width, height);
		this._game = new Game(lives, this);

		this._thread = new Thread(this);
		this._thread.start();
	}

	public void run() {
		long before, timeDiff, sleep;

		before = System.currentTimeMillis();

		while (this._game.isPlaying()) {
			repaint();
			this._game.run();

			timeDiff = System.currentTimeMillis() - before;
			sleep = 18 - timeDiff;

			if (sleep < 0) {
				sleep = 2;
			}

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("Error while sleeping thread...");
			}

			before = System.currentTimeMillis();
		}

		onEnd();
	}

	@Override
	public void addNotify() {
		super.addNotify();
		this._game.init();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.dimension.width, this.dimension.height);

		this._game.paint(g);
		Toolkit.getDefaultToolkit().sync();
	}

	public void onEnd() {
		// Graphics g = this.getGraphics();
		// int width = this.dimension.width;
		// int height = this.dimension.height;

		// g.setColor(Color.BLACK);
		// g.fillRect(0, 0, width, height);
		// g.setColor(new Color(0, 32, 48));
		// g.fillRect(50, width / 2 - 30, width - 100, 50);
		// g.setColor(Color.white);
		// g.drawRect(50, width / 2 - 30, width - 100, 50);

		// Font estilo = new Font("Consolas", Font.BOLD, 14);
		// FontMetrics metrica = this.getFontMetrics(estilo);

		// g.setColor(Color.WHITE);
		// g.setFont(estilo);
		// g.drawString("Game Over",
		// (width - metrica.stringWidth("Game Over")) / 2, width /
		// 2);
	}
}
