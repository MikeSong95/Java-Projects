/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonkGame;

import MainScreen1.MainScreen1;
import diablo3.Intro1;
import java.awt.Graphics;
import java.awt.Image;
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
public class EndCinematic extends JFrame {
    
    Image end = Toolkit.getDefaultToolkit().createImage("EndingCinematic.gif"); 
    InputStream endIn = new FileInputStream("EndMusic.wav");
    AudioStream endAs = new AudioStream (endIn);  
    InputStream bP = new FileInputStream("BubblePop.wav");
    AudioStream bPAs = new AudioStream (bP);    
    public EndCinematic () throws IOException{
        
        JFrame frame = new JFrame ("");
        setSize (800, 450);
        setTitle("You Win!");
        setResizable(false);
        setVisible (true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new AL ());
        AudioPlayer.player.start(endAs);
    }
    
    public class AL extends KeyAdapter  { //method to store pressed key
   
        public void keyPressed (KeyEvent e){ // stores pressed button
            int keyCode = e.getKeyCode(); // stores pressed button to "keyCode"    
            
            if (keyCode == e.VK_ENTER){
                    AudioPlayer.player.stop(endAs);
                    AudioPlayer.player.start (bPAs);
            }
        }   
    }
    
    public void paint (Graphics g){
         g.drawImage(end, 0, 0, this);
    }
    
    public static void main (String [] args) throws IOException{
        EndCinematic endC = new EndCinematic ();
    }
    
}
