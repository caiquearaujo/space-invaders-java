package com.space.invaders;

import javax.swing.JFrame;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class SpaceInvaders extends JFrame {
	public SpaceInvaders() {
		this.add(new Screen(3, 358, 350));

		this.setTitle("Space Invaders");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(358, 350);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		new SpaceInvaders();
	}
}
