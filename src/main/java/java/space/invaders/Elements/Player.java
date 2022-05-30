/*
 * Click
 * nbfs://nbhost/SystemFileSystem/Templates/Licenses/license
 * -default.txt to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.
 * java to edit this template
 */
package java.space.invaders.Elements;

import java.space.invaders.Screen;
import java.space.invaders.Controllers.PlayerController;
import java.space.invaders.Interfaces.Actable;
import java.awt.Graphics;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Player extends Element implements Actable {
	public static final String IMAGE_SRC = "/src/images/player.png";

	public final PlayerController controller;
	private final Shot _shot;

	public Player(int x, int y, int velocity) {
		super(Player.IMAGE_SRC, x, y);
		this.controller = new PlayerController(this, velocity);
		this._shot = new Shot();
	}

	public void act(Screen screen) {
		this.controller.onActing(2, screen.dimension.width - 2);
		this._shot.act(screen);
	}

	public void paint(Graphics g, Screen screen) {
		super.paint(g, screen);
		this._shot.paint(g, screen);

		if (this.isDying()) {
			screen.stop();
		}
	}

	public Shot shot() {
		return this._shot;
	}
}
