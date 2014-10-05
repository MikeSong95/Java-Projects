/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonkGame;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.io.IOException;

/**
 *
 * @author Michael
 */
public class MonkMovement extends KeyAdapter {
    
    Image MonkDown1 = Toolkit.getDefaultToolkit().createImage ("MonkDown1.png");
    TileMap tm = new TileMap();
    public MonkMovement() throws IOException {
        
    }
    
    public void getX (){
        tm.x += 5;
    }
    
}
