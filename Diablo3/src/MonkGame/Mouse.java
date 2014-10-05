/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonkGame;

import java.awt.MouseInfo;
import MonkGame.TileMap;
import java.io.IOException;
/**
 *
 * @author Michael
 */
public class Mouse {
    TileMap tm = new TileMap();
    public Mouse() throws IOException{
        
        while (true){
            int mouseX = MouseInfo.getPointerInfo().getLocation().x;
            
            if (mouseX < tm.x){
                System.out.println("left");
            }
        }
    }
    
}
