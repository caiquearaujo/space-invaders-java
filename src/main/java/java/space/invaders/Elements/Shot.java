package java.space.invaders.Elements;

import java.space.invaders.Utils.Commons;

/**
 *
 * @author Caique Araujo <caique@piggly.com.br>
 */
public class Shot extends Element {
    public Shot (String src) {
        super(src, 0, 0);
    }
    
    public Shot (String src, int x, int y) {
        super(src, x, y);
     
        this.coordinates().apply(
            this.coordinates().x() + Commons.SHOT_HORIZONTAL_SPACING,
            this.coordinates().y() + Commons.SHOT_VERTICAL_SPACING
        );
    }
}
