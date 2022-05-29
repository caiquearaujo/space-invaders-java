package java.space.invaders.Utils;

import java.awt.Image;

/**
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Draw {
    private final Coordinate _coordinates;
    private final Image _image;
    
    private boolean _visible;
    private boolean _dying;
    
    public Draw (Image image) {
        this._visible = true;
        this._dying = false;
        
        this._image = image;
        this._coordinates = new Coordinate(0, 0);
    }
    
    public Coordinate coordinates () {
        return this._coordinates;
    }
    
    public Image image () {
        return this._image;
    }
    
    public boolean isVisible () {
        return this._visible;
    }
    
    public void setVisibility (boolean visibility) {
        this._visible = visibility;
    }
    
    public boolean isDying () {
        return this._dying;
    }
    
    public void mustDie () {
        this._dying = true;
    }
    
    public void die () {
        this._visible = false;
    }
}
