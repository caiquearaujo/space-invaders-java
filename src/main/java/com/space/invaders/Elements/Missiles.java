package com.space.invaders.Elements;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.space.invaders.Screen;
import com.space.invaders.Interfaces.Paintable;
import com.space.invaders.Utils.Vector2D;

public class Missiles implements Paintable {
	private List<Shot> _missiles;

	public Missiles() {
		this._missiles = new ArrayList<Shot>();
	}

	public void spawn(Vector2D vector) {
		if (this._missiles.size() >= 5) {
			return;
		}

		this._missiles.add(new Shot(vector.x(), vector.y()));
	}

	public void move() {
		Shot shot;

		for (int i = 0; i < this._missiles.size(); i++) {
			shot = this._missiles.get(i);

			if (shot.isVisible()) {
				shot.move();
				continue;
			}

			this._missiles.remove(i);
		}
	}

	public void paint(Graphics g, Screen screen) {
		Iterator<Shot> it = this._missiles.iterator();

		while (it.hasNext()) {
			it.next().paint(g, screen);
		}
	}
}
