package java.space.invaders.Elements;

/**
 *
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Alien extends Element {
    private final Bomb _bomb;
    
    public Alien (String src, String bomb_src, int x, int y) {
        super(src, x, y);
        this._bomb = new Bomb(bomb_src, x, y);
    }
    
    public Bomb bomb () {
        return this._bomb;
    }
}
