package java.space.invaders.Elements;

/**
 *
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Bomb extends Element {
    private boolean _destroyed;
    
    public Bomb (String src, int x, int y) {
        super(src, x, y);
        this._destroyed = false;
    }
    
    public boolean isDestroyed () {
        return this._destroyed;
    }
    
    public void destroy () {
        this._destroyed = true;
    }
}