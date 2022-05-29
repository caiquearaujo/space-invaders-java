package java.space.invaders.Utils;

/**
 *
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Coordinate {
    private int _x;
    private int _y;
    private int _dX;
    private int _dY;
    
    public Coordinate (int x, int y) {
        this._x = x;
        this._y = y;
        
        this._dX = 0;
        this._dY = 0;
    }
    
    public void apply (int x, int y) {
        this._x = x;
        this._y = y;
    }
    
    public void changeXDirection () {
        this._dX *= -1;
    }
    
    public void changeYDirection () {
        this._dY *= -1;
    }
    
    public int x () {
        return this._x;
    }
    
    public int y () {
        return this._y;
    }
    
    public int dX () {
        return this._dX;
    }
    
    public int dY () {
        return this._dY;
    }
}
