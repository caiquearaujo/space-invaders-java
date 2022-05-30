package com.space.invaders.Adapters;

import com.space.invaders.Elements.Player;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControllerAdapter extends KeyAdapter {
	private Player _player;

	public ControllerAdapter(Player player) {
		this._player = player;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
			this._player.stopWalk();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
			case KeyEvent.VK_LEFT:
				this._player.walkToLeft();
				return;
			case KeyEvent.VK_RIGHT:
				this._player.walkToRight();
				return;
			case KeyEvent.VK_Z:
				this._player.fire();
		}
	}
}
