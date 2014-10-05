/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainScreen1;

import DemonHunterGame.DemonHunter;
import MonkGame.MonkStart;
import MonkGame.Mouse;
import MonkGame.TileMap;
import WizardGame.Wizard;
import diablo3.Intro1;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Michael
 */
public class MainScreen1 extends JFrame{
    
    int yesMonk = 0;
    
    Image menu = Toolkit.getDefaultToolkit().createImage("Diablo 3 Menu.png");
    Image monkImage = Toolkit.getDefaultToolkit().createImage("MonkImage.png");
    Image demonImage = Toolkit.getDefaultToolkit().createImage("DemonHunterImage.png");
    Image loadScreen1 = Toolkit.getDefaultToolkit().createImage("MonkLoadScreen.png");
    Image loadScreen2 = Toolkit.getDefaultToolkit().createImage("MonkLoadScreen2.png");
    Image loadScreen3 = Toolkit.getDefaultToolkit().createImage("MonkLoadScreen3.png");
    Image loadScreen4 = Toolkit.getDefaultToolkit().createImage("MonkLoadScreen4.png");

    ImageIcon monkImg = new ImageIcon("MonkImage.png");
    ImageIcon play = new ImageIcon("PlayButton.png");
    ImageIcon option = new ImageIcon("OptionButton.png");
    ImageIcon dH = new ImageIcon("DemonHunter.png");
    ImageIcon w = new ImageIcon("Wizard.png");
    ImageIcon m = new ImageIcon("Monk.png");
    ImageIcon dhVid = new ImageIcon("DemonHunterVid.gif");
    ImageIcon mVid = new ImageIcon("MonkVid.gif");
    ImageIcon wVid = new ImageIcon("WizardVid.gif");
    ImageIcon o = new ImageIcon ("OkButton.png");
    ImageIcon c = new ImageIcon ("CancelButton.png");
    Image cursor_image = Toolkit.getDefaultToolkit().createImage("Cursor_(Diablo_I).png");
    JButton playButton = new JButton (play);
    JButton optionButton = new JButton (option);
    JButton demonHunter = new JButton (dH);
    JButton wizard = new JButton (w);
    JButton monk = new JButton (m);
    JButton ok = new JButton (o);
    JButton cancel = new JButton (c);
    int load1 = 0;
    int load2 = 0;
    int load3 = 0;
    int load4 = 0;
    int hey = 1;
    int yesDemon = 0;
    int yesWizard = 0;
    String charName;
    InputStream in;
    InputStream menuMusic = new FileInputStream ("MenuMusic1.wav");
    public AudioStream mM;
    AudioStream as;   
    Box b = new Box(BoxLayout.Y_AXIS); 
    Box a = new Box(BoxLayout.Y_AXIS);
    
    JLabel cYC = new JLabel ("Choose Your Character:");
    JLabel MonkImg = new JLabel();
    
    // Creates frame
    JFrame mainScreen = new JFrame();
    
    public MainScreen1 () throws FileNotFoundException, IOException{   
        try {
            this.mM = new AudioStream (menuMusic);
            this.in = new FileInputStream("MonkTheme.wav");
            AudioPlayer.player.start (mM);
            a.setLocation(1280, 0);
            addKeyListener(new GameAL());
            setVisible (true);
            setTitle ("Diablo 3");
            setSize (1280, 820);
            setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            
            //Custom cursor
            Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursor_image, new Point (0,0), "My Cursor");
            setCursor(cursor);
            
            // Adds buttons
            b.add(optionButton);
            optionButton.setMargin(new Insets (0,0,0,0)); // Removes grey background
            optionButton.addActionListener(new MainScreen1.OptionButtonListener() ); // Adds event handler      
            b.add(playButton);
            playButton.setMargin(new Insets (0,0,0,0));
            playButton.addActionListener(new MainScreen1.AL ());
            getContentPane().add(b);
        } catch (IOException ex) {
            Logger.getLogger(MainScreen1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
  
    public class OptionButtonListener implements ActionListener {
        //@Override
        JTextArea instructions = new JTextArea ();
        public void actionPerformed (ActionEvent e){
            JFrame options = new JFrame("Options");
            options.setVisible (true);
            options.setResizable(false);
            options.setSize(500, 500);
            options.add(instructions);
            instructions.setEditable(false);
            instructions.setText("");
            instructions.append("Hey, how's it going." + "\n");
            instructions.append("" + "\n");
            instructions.append("HOW TO PLAY:" + "\n");            
            instructions.append("Move with the WASD keys." + "\n");
            instructions.append("Attack with the COMMA key." + "\n");
            instructions.append("Change your attack with the M key and the PERIOD key." + "\n");
            instructions.append("" + "\n");
            instructions.append("Pro tip: Some attacks do more damage than others, but use more mana." + "\n");
            instructions.append("" + "\n");
            instructions.append("Please be reasonable." + "\n");  
            
        }
    }
    
    public class AL implements ActionListener { // "Play" button clicked
        @Override
        public void actionPerformed (ActionEvent e){
               playButton.setVisible (false); 
               optionButton.setVisible (false);
               
               // Monk button
               b.add(monk);
               monk.setOpaque(false);
               monk.setMargin(new Insets (0,0,0,0));
               monk.setBorderPainted(false);
               monk.setRolloverIcon(mVid);
               monk.addActionListener (new MonkAL ());
               
               // Demon Hunter button
               b.add(demonHunter);
               demonHunter.setOpaque(false);
               demonHunter.setMargin(new Insets (0,0,0,0));
               demonHunter.setBorderPainted(false);
               demonHunter.setRolloverIcon(dhVid);
               demonHunter.addActionListener (new DemonAL ());
               
               b.add(wizard);
               wizard.setBorderPainted(false);
               wizard.setOpaque(false);
               wizard.setMargin(new Insets (0,0,0,0));
               wizard.setRolloverIcon(wVid);
               wizard.addActionListener(new WizardAL ());
                        
        }  
    }       
    
    public class DemonAL extends KeyAdapter implements ActionListener{
        public void actionPerformed (ActionEvent e){
            monk.setVisible (false);
            wizard.setVisible(false);
            demonHunter.setVisible(false);
            //MonkImg.setIcon(monkImg);
            getContentPane().remove(b);
            getContentPane().add(a);
            
            
            ok.setMargin(new Insets(0,0,0,0));
            if (hey == 1){
                ok.addActionListener (new DemonOK());
            }
            //a.add(cancel);
            cancel.setMargin(new Insets(0,0,0,0));
            cancel.addActionListener (new CancelAL());
            //b.add(cancel);
            //cancel.setMargin(new Insets(0,0,0,0));
            //b.add(MonkImg);
            //AudioPlayer.player.stop(mM);
            //AudioPlayer.player.start (in);
            
            hey = 0;
            yesDemon = 1;
            repaint ();
            a.add(ok);
            //a.add(cancel);
            ok.setVisible(true);
            //cancel.setVisible(true);
        }
    }
    // If Monk button is pressed
    public class MonkAL extends KeyAdapter implements ActionListener{
       
        public void actionPerformed (ActionEvent e){
            //addKeyListener (new AL());
            monk.setVisible (false);
            wizard.setVisible(false);
            demonHunter.setVisible(false);
            //MonkImg.setIcon(monkImg);
            getContentPane().remove(b);
            getContentPane().add(a);
            
            
            ok.setMargin(new Insets(0,0,0,0));
            if (hey == 1){
                ok.addActionListener (new MonkOk());
            }
            //a.add(cancel);
            cancel.setMargin(new Insets(0,0,0,0));
            cancel.addActionListener (new CancelAL());
            //b.add(cancel);
            //cancel.setMargin(new Insets(0,0,0,0));
            //b.add(MonkImg);
            //AudioPlayer.player.stop(mM);
            //AudioPlayer.player.start (in);
            hey = 0;
            yesMonk = 1;
            repaint ();
            a.add(ok);
            //a.add(cancel);
            ok.setVisible(true);
            //cancel.setVisible(true);
            
        }
    }
    public class WizardAL extends KeyAdapter implements ActionListener{
       
        public void actionPerformed (ActionEvent e){
            //addKeyListener (new AL());
            monk.setVisible (false);
            wizard.setVisible(false);
            demonHunter.setVisible(false);
            //MonkImg.setIcon(monkImg);
            getContentPane().remove(b);
            getContentPane().add(a);
            
            
            ok.setMargin(new Insets(0,0,0,0));
            if (hey == 1){
                ok.addActionListener (new WizardOk());
            }
            //a.add(cancel);
            cancel.setMargin(new Insets(0,0,0,0));
            cancel.addActionListener (new CancelAL());
            //b.add(cancel);
            //cancel.setMargin(new Insets(0,0,0,0));
            //b.add(MonkImg);
            //AudioPlayer.player.stop(mM);
            //AudioPlayer.player.start (in);
            hey = 0;
            yesWizard = 1;
            repaint ();
            a.add(ok);
            //a.add(cancel);
            ok.setVisible(true);
            //cancel.setVisible(true);
            
        }
    }
    public class CancelAL extends KeyAdapter implements ActionListener{
        public void actionPerformed (ActionEvent e){
            monk.setVisible (true);
            wizard.setVisible (true);
            demonHunter.setVisible(true);
            getContentPane().remove(a);
            getContentPane().add(b);
            yesMonk = 0;
            yesDemon = 0;
            ok.removeKeyListener(new MonkOk());
            ok.removeKeyListener (new DemonOK());
            ok.setVisible(false);
            cancel.setVisible(false);
            //AudioPlayer.player.stop(in);
            AudioPlayer.player.start(mM);
            hey ++;
            repaint();
        }
    }
    public class MonkOk extends KeyAdapter implements ActionListener{
        
        public void actionPerformed (ActionEvent e){
            try {
                ok.setVisible(false);
                cancel.setVisible(false);
            
                
                AudioPlayer.player.stop(mM);
                dispose();          
                TileMap tm = new TileMap ();
                
                    
                    //Mouse m = new Mouse ();
            } catch (IOException ex) {
                Logger.getLogger(MainScreen1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
        }
    }
    public class WizardOk extends KeyAdapter implements ActionListener{
        
        public void actionPerformed (ActionEvent e){
            try {
                ok.setVisible(false);
                cancel.setVisible(false);
                
                AudioPlayer.player.stop(mM);
                dispose();          
                Wizard w = new Wizard ();                
                    //Mouse m = new Mouse ();
            } catch (IOException ex) {
                Logger.getLogger(MainScreen1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
        }
    }
    public class GameAL extends KeyAdapter  {
        public void actionPerformed ( KeyEvent e) throws IOException{
            int keyCode = e.getKeyCode(); // stores pressed button to "keyCode"    

            if (keyCode == KeyEvent.VK_ENTER){
                
                    dispose(); //Destroy the JFrame object     
                    AudioPlayer.player.stop(as);
                    if (yesMonk == 1){
                        TileMap tm = new TileMap ();
                    }
                    if (yesDemon == 1){
                        DemonHunter d = new DemonHunter();
                    }
              
            }
          
        }

        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    public class DemonOK extends KeyAdapter implements ActionListener{
        
        public void actionPerformed (ActionEvent e){

            AudioPlayer.player.stop(mM);
            dispose();          
            try {
                DemonHunter d = new DemonHunter ();
                //Mouse m = new Mouse ();
            } catch (IOException ex) {
                Logger.getLogger(MainScreen1.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    }
    public void monkStuff () throws IOException{
        TileMap tm = new TileMap ();       
    }
    @Override
    public void paint (Graphics g){
        super.paint(g);
        g.drawImage(menu,0,14,this);
        if (yesMonk == 1 || yesDemon == 1 || yesWizard == 1){
            g.drawImage(loadScreen4,0,14,this);
        }
         
        //if (load1 == 1){
            //g.drawImage(loadScreen4,0,14,this);
            //delay (100000000);
        //}
                    
    }
    public void delay (int howLong){
        for (int i = 0; i <= howLong ; i ++){
            double garbage = Math.PI * Math.PI + Math.sin(Math.PI);
        }
    }
}
