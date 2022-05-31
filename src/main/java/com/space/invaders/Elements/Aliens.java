package com.space.invaders.Elements;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import com.space.invaders.Screen;
import com.space.invaders.Interfaces.Paintable;

public class Aliens implements Paintable {
	private ArrayList<Alien> _aliens;

	public Aliens(int rows, int columns, int startX, int startY) {
		this._aliens = new ArrayList<Alien>();

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				Alien el = new Alien(startX + 18 * c, startY + 18 * r);

				this._aliens.add(el);
			}
		}
	}

	public int size() {
		return this._aliens.size();
	}

	public void move() {
		Alien a;

		for (int i = 0; i < this._aliens.size(); i++) {
			a = this._aliens.get(i);

			if (a.isVisible()) {
				a.move();
				continue;
			}

			this._aliens.remove(i);
		}
	}

	public void explode(Alien alien) {
		alien.hide();
	}

	public ArrayList<Alien> get() {
		return this._aliens;
	}

	public void paint(Graphics g, Screen screen) {
		Iterator<Alien> it = this._aliens.iterator();

		while (it.hasNext()) {
			it.next().paint(g, screen);
		}
	}
}
