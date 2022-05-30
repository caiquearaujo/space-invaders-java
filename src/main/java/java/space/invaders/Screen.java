package java.space.invaders;

import java.space.invaders.Elements.Alien;
import java.space.invaders.Elements.Aliens;
import java.space.invaders.Elements.Player;
import java.space.invaders.Elements.Shot;
import java.space.invaders.Gaming.Score;
import java.space.invaders.Utils.Vector2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Screen extends JPanel implements Runnable {
	public Dimension dimension;
	public Score score;
	public Aliens aliens;
	public Player player;

	private boolean _playing;
	private Thread _thread;

	public Screen (int lives, int width, int height) {
		this.setFocusable(true);
		this.setBackground(Color.BLACK);

		this.dimension = new Dimension(width, height);
		this.score = new Score(lives);

		this.init();
	}

	@Override
	public void addNotify() {
		super.addNotify();
		this.init();
	}

	private void init () {
		this.aliens = new Aliens(
			4,
			6,
			150,
			5
		);

		this.player = new Player(
			270,
			280,
			2
		);

		if ( this._thread == null || !this._playing ) {
			this._thread = new Thread(this);
			this._thread.start();
		}
	}

	public void onStart () {
		if ( this.aliens.size() <= 0 ) {
			this._playing = false;
			return;
		}

		this.player.act(this);
	}

	public void run () {
		long before, timeDiff, sleep;

		before = System.currentTimeMillis();

		while ( this._playing ) {
			repaint();
			onStart();

			timeDiff = System.currentTimeMillis() - before;
			sleep = 18 - timeDiff;

			if ( sleep < 0 ) {
				sleep = 2;
			}

			try {
				Thread.sleep(sleep);
			} catch ( InterruptedException e ) {
				System.out.println("Error while sleeping thread...");
			}

			before = System.currentTimeMillis();
		}

		onEnd();
	}

	@Override
	public void paint (Graphics g) {
		super.paint(g);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.dimension.width, this.dimension.height);
		g.setColor(Color.GREEN);

		if ( this._playing ) {
			g.drawLine(0, 290, this.dimension.width, 290);

			this.aliens.paint(g, this);
			this.player.paint(g, this);
			this.score.paint(g, this);
		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void onEnd () {
		Graphics g = this.getGraphics();
		int width = this.dimension.width;
		int height = this.dimension.height;

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setColor(new Color(0, 32, 48));
		g.fillRect(50, width/2 - 30, width-100, 50);
		g.setColor(Color.white);
		g.drawRect(50, width/2 - 30, width-100, 50);

		Font estilo = new Font("Consolas", Font.BOLD, 14);
		FontMetrics metrica = this.getFontMetrics(estilo);

		g.setColor(Color.WHITE);
		g.setFont(estilo);
		g.drawString("Game Over", (width - metrica.stringWidth("Game Over"))/2, width/2);
	}

	public void stop () {
		this._playing = false;
	}
}
