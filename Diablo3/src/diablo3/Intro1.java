/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diablo3;

import MainScreen1.MainScreen1;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Michael
 */
public class Intro1 extends JFrame {
    
    // Images and music
    Image Intro1 = Toolkit.getDefaultToolkit().createImage("Opening Cinematic 3.gif");
    Image cursor_image = Toolkit.getDefaultToolkit().createImage("Cursor_(Diablo_I).png");
    
    InputStream in = new FileInputStream("OpeningCinematicSound.wav");
    AudioStream as = new AudioStream(in);         
    
    public Intro1 () throws IOException{
        
        // Creates the frame, adds a key listener, sets the cursor, and starts the music
        addKeyListener (new AL());
        JFrame frame = new JFrame ("Diablo 3");
        setVisible (true);
        setSize (800,600);
        setResizable (false);
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursor_image, new Point (0,0), "My Cursor");
        setCursor(cursor);
        AudioPlayer.player.start(as);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  
     public class AL extends KeyAdapter  { //method to store pressed key
   
        public void keyPressed (KeyEvent e){ // stores pressed button
            int keyCode = e.getKeyCode(); // stores pressed button to "keyCode"    
                 
            if (keyCode == e.VK_ENTER){
                try {
                    setVisible(false); //
                    dispose(); //Destroy the JFrame object     
                    MainScreen1 menu1 = new MainScreen1 ();
                    AudioPlayer.player.stop(as);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Intro1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Intro1.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        }   
    }

    // Plays gif image (opening cinematic)
    public void paint (Graphics g) {
         g.drawImage(Intro1,0,20,this);
     }
    
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        Intro1 i = new Intro1();
    }
}
