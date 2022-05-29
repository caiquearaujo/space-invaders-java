/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java.space.invaders.Elements;

import java.space.invaders.Controllers.PlayerController;

/**
 *
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Player extends Element {
	public final PlayerController controller;

	public Player (String src, int x, int y, int velocity) {
		super(src, x, y);
		this.controller = new PlayerController(this, velocity);
	}
}
