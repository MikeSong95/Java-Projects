/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonkGame;

import java.awt.Button;
import java.awt.Cursor;
import java.awt.DisplayMode;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Michael
 */
public final class MonkStart extends JPanel{
    
    private int ix, iy;
    Image map = Toolkit.getDefaultToolkit().createImage ("map.png");
    ImageIcon FoT = new ImageIcon ("FistOfThunder.png");
    ImageIcon m = new ImageIcon ("map.png");
    JButton mSkill1 = new JButton (FoT);
    JLabel mp = new JLabel (m);  
    Image cursor_image = Toolkit.getDefaultToolkit().createImage("Cursor_(Diablo_I).png");
    Image cursor_sword = Toolkit.getDefaultToolkit().createImage("");
    Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursor_image, new Point (0,0), "My Cursor");
    Cursor cursorSword = Toolkit.getDefaultToolkit().createCustomCursor(cursor_sword, new Point (0,0), "My Cursor");
    
    JFrame frame = new JFrame ("Diablo 3");

   

    public MonkStart () throws IOException{
        mSkill1.setMargin(new Insets(0,0,0,0));
        frame.setSize (901,714);
        frame.setVisible (true);
        frame.setDefaultCloseOperation (frame.EXIT_ON_CLOSE);
    }
    
  
}
