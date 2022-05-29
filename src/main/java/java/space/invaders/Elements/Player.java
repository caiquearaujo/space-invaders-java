/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java.space.invaders.Elements;

import java.space.invaders.Utils.Commons;
import java.awt.event.KeyEvent;

/**
 *
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Player extends Element {
    private final int _playerWidth;
    
    public Player (String src, String bomb_src, int x, int y) {
        super(src, x, y);
        this._playerWidth = this.image().getWidth(null);
    }
    
    public void act ()
    {
        this.coordinates().moveX(this.coordinates().dX());
        
        int x = this.coordinates().x();
        int y = this.coordinates().y();
        
        if ( x <= Commons.DIRECTION_SIZE) {
            this.coordinates().apply(Commons.DIRECTION_SIZE, y);
        } else if ( x >= Commons.SCREEN_WIDTH - (Commons.DIRECTION_SIZE * this._playerWidth) ) {
            this.coordinates().apply(Commons.SCREEN_WIDTH - (Commons.DIRECTION_SIZE * this._playerWidth), y);
        }
    }
    
    public void onMove (KeyEvent e, int size) {
        int key = e.getKeyCode();
        
        switch(key) {
            case KeyEvent.VK_LEFT -> this.coordinates().applyDirection(Commons.DIRECTION_SIZE*-1, 0);
            case KeyEvent.VK_RIGHT -> this.coordinates().applyDirection(Commons.DIRECTION_SIZE, 0);
        }
    }
}
