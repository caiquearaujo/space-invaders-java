package java.space.invaders.Gaming;

import java.space.invaders.Interfaces.Paintable;
import java.space.invaders.Screen;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Score implements Paintable {
	private int _kills;
	private int _lives;

	public Score(int lives) {
		this._kills = 0;
		this._lives = lives;
	}

	public Score increaseKill() {
		this._kills++;
		return this;
	}

	public Score decreaseLife() {
		this._lives--;
		return this;
	}

	public boolean hasLife() {
		return this._lives > 0;
	}

	public void paint(Graphics g, Screen screen) {
		Font style = new Font("Consolas", Font.BOLD, 12);
		FontMetrics metrics = screen.getFontMetrics(style);

		String score = "SCORE " + this._kills;
		String lives = "LIVES " + this._lives;

		// Lifes
		g.setColor(Color.white);
		g.setFont(style);
		g.drawString(lives, 10, 20);

		// Score
		g.setColor(Color.white);
		g.setFont(style);
		g.drawString(score,
			10 + metrics.stringWidth(lives) + 10, 20);
	}
}
