/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DemonHunterGame;

import MonkGame.EndCinematic;
import MonkGame.EnemyAttacks;
import MonkGame.TileMap;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Michael
 */
public class DemonHunter extends JFrame {

    DEnemyAttacks e = new DEnemyAttacks();
    int drawPotions = 0;
    public int x = 500;
    public int y = 500;
    int collected1 = 0;
    int collected2 = 0;
    int potionsX = 0;
    int potionsY = 0;
    int potions2X = 0;
    int potions2Y = 0;
    public int enemyX = 700;
    public int enemyY = 700;
    public int enemy2X = 300;
    public int enemy2Y = 250;
    public int diabloX = 600;
    public int diabloY = 600;
    boolean attack = false;
    boolean enemy2Alive = true;
    int enemiesLeft = 2;
    int spikeTrapX, spikeTrapY;
    int selected = 1;
    private Image[][] tiles;
    private LinkedList sprites;
    //private Sprite player;
    String eDir = "l";
    ArrayList lines = new ArrayList();
    int width = 0;
    int height = 0;
    int health = 100;
    int playerDamage = 0;
    String dir = "d";
    String e2Dir = "d";
    int enemyHealth = 10;
    int enemy2Health = 10;
    int diabloHealth = 40;
    int enemy1 = 1;
    int enemy2 = 1;
    int mana = 0;
    boolean hitOrMiss = false;
    boolean spikeTrap = false;
    int diabloYN = 0;
    //Box c = new Box(BoxLayout.Y_AXIS); 
    Image map = Toolkit.getDefaultToolkit().createImage("Map.png");
    Image monk = Toolkit.getDefaultToolkit().createImage("MonkDown1.png");
    ImageIcon m = new ImageIcon("Monk.png");
    InputStream in = new FileInputStream("Two Steps From Hell - Nemesis [Extended Remix].wav");
    AudioStream as = new AudioStream(in);
    InputStream dMusic = new FileInputStream("DeathMusic.wav");
    AudioStream dAS = new AudioStream(dMusic); 
    InputStream fBAttack = new FileInputStream("FireBombAttack.wav");
    AudioStream fireBombAttack = new AudioStream(fBAttack);
    Thread Enemy;
    Thread Enemy2;
    Thread DiabloThread;
    Image cursor_image = Toolkit.getDefaultToolkit().createImage("Cursor_(Diablo_I).png");
    //Making lots of transparent images ********************************************************************************//
    ImageIcon originalIcon = new ImageIcon("DemonHunterDown.png");
    ImageIcon demonUp = new ImageIcon("DemonHunterUp.png");
    ImageIcon demonLeft = new ImageIcon("DemonHunterLeft.png");
    ImageIcon demonRight = new ImageIcon("DemonHunterRight.png");
    ImageIcon demonDead = new ImageIcon("DemonHunterDead.png");
    ImageIcon fireBombLeft = new ImageIcon("FireBomb.png");
    ImageIcon fireBombRight = new ImageIcon("FireBombRight.png");
    ImageIcon hashmalumRight = new ImageIcon("Enemy2Right.png");
    ImageIcon hashmalumLeft = new ImageIcon("Enemy2Left.png");
    ImageIcon fistOfThunderU = new ImageIcon("ThrowingKnivesUnselected.png");
    ImageIcon fistOfThunderS = new ImageIcon("ThrowingKnivesSelected.png");
    ImageIcon blastU = new ImageIcon("SpikeTrapUnselected.png");
    ImageIcon blastS = new ImageIcon("SpikeTrapSelected.png");
    ImageIcon monkSuperS = new ImageIcon("SuperArrowSelected.png");
    ImageIcon monkSuperU = new ImageIcon("SuperArrowUnselected.png");
    ImageIcon bloodForManaU = new ImageIcon("BloodForManaUnselected.png");
    ImageIcon bloodForManaS = new ImageIcon("BloodForManaSelected.png");
    ImageIcon healthBarFull = new ImageIcon("HealthBar100.png");
    ImageIcon healthBarEmpty = new ImageIcon("HealthBar0.png");
    ImageIcon healthBarDamaged1 = new ImageIcon("HealthBarDamaged1.png");
    ImageIcon healthBarDamaged2 = new ImageIcon("HealthBarDamaged2.png");
    ImageIcon healthBarDamaged3 = new ImageIcon("HealthBarDamaged3.png");
    ImageIcon healthBarDamaged4 = new ImageIcon("HealthBarDamaged4.png");
    ImageIcon healthBarDamaged5 = new ImageIcon("HealthBarDamaged5.png");
    ImageIcon healthBarDamaged6 = new ImageIcon("HealthBarDamaged6.png");
    ImageIcon healthBarDamaged7 = new ImageIcon("HealthBarDamaged7.png");
    ImageIcon healthBarDamaged8 = new ImageIcon("HealthBarDamaged8.png");
    ImageIcon healthBarDamaged9 = new ImageIcon("HealthBarDamaged9.png");
    ImageIcon healthBarDamaged10 = new ImageIcon("HealthBarDamaged10.png");
    ImageIcon healthBarDamaged11 = new ImageIcon("HealthBarDamaged11.png");
    ImageIcon healthBarDamaged12 = new ImageIcon("HealthBarDamaged12.png");
    ImageIcon healthBarDamaged13 = new ImageIcon("HealthBarDamaged13.png");
    ImageIcon healthBarDamaged14 = new ImageIcon("HealthBarDamaged14.png");
    ImageIcon healthBarDamaged15 = new ImageIcon("HealthBarDamaged15.png");
    ImageIcon healthBarDamaged16 = new ImageIcon("HealthBarDamaged16.png");
    ImageIcon ManaFull = new ImageIcon("ManaFull.png");
    ImageIcon ManaEmpty = new ImageIcon("ManaEmpty.png");
    ImageIcon Mana1 = new ImageIcon("Mana1.png");
    ImageIcon Mana2 = new ImageIcon("Mana2.png");
    ImageIcon Mana3 = new ImageIcon("Mana3.png");
    ImageIcon Mana4 = new ImageIcon("Mana4.png");
    ImageIcon Mana5 = new ImageIcon("Mana5.png");
    ImageIcon Mana6 = new ImageIcon("Mana6.png");
    ImageIcon Mana7 = new ImageIcon("Mana7.png");
    ImageIcon Mana8 = new ImageIcon("Mana8.png");
    ImageIcon Mana9 = new ImageIcon("Mana9.png");
    ImageIcon Mana10 = new ImageIcon("Mana10.png");
    ImageIcon Mana11 = new ImageIcon("Mana11.png");
    ImageIcon Mana12 = new ImageIcon("Mana12.png");
    ImageIcon Mana13 = new ImageIcon("Mana13.png");
    ImageIcon Mana14 = new ImageIcon("Mana14.png");
    ImageIcon Mana15 = new ImageIcon("Mana15.png");
    ImageIcon Mana16 = new ImageIcon("Mana16.png");
    ImageIcon Mana17 = new ImageIcon("Mana17.png");
    ImageIcon Mana18 = new ImageIcon("Mana18.png");
    ImageIcon Miss = new ImageIcon("Miss!.png");
    ImageIcon spikes = new ImageIcon("SpikeTrap.png");
    ImageIcon Diablo = new ImageIcon("Demon.png");
    ImageIcon HealthPotion = new ImageIcon("HealthPotion.png");
    ImageIcon ManaPotion = new ImageIcon("ManaPotion.png");
    ImageIcon deathMessage = new ImageIcon ("DeathMessage.png");
    ImageFilter filter = new RGBImageFilter() {
        int transparentColor = Color.white.getRGB() | 0xFF000000;

        public final int filterRGB(int x, int y, int rgb) {
            if ((rgb | 0xFF000000) == transparentColor) {
                return 0x00FFFFFF & rgb;
            } else {
                return rgb;
            }
        }
    };
    ImageProducer deathMessageT = new FilteredImageSource(deathMessage.getImage().getSource(), filter);
    ImageProducer filteredImgProd = new FilteredImageSource(originalIcon.getImage().getSource(), filter);
    ImageProducer mUpT = new FilteredImageSource(demonUp.getImage().getSource(), filter);
    ImageProducer mLeftT = new FilteredImageSource(demonLeft.getImage().getSource(), filter);
    ImageProducer mRightT = new FilteredImageSource(demonRight.getImage().getSource(), filter);
    ImageProducer fLeftT = new FilteredImageSource(fireBombLeft.getImage().getSource(), filter);
    ImageProducer fRightT = new FilteredImageSource(fireBombRight.getImage().getSource(), filter);
    ImageProducer hLeftT = new FilteredImageSource(hashmalumLeft.getImage().getSource(), filter);
    ImageProducer hRightT = new FilteredImageSource(hashmalumRight.getImage().getSource(), filter);
    ImageProducer mDeadT = new FilteredImageSource(demonDead.getImage().getSource(), filter);
    ImageProducer MissT = new FilteredImageSource(Miss.getImage().getSource(), filter);
    ImageProducer HealthPotionT = new FilteredImageSource(HealthPotion.getImage().getSource(), filter);
    ImageProducer ManaPotionT = new FilteredImageSource(ManaPotion.getImage().getSource(), filter);
    ImageProducer spikesT = new FilteredImageSource(spikes.getImage().getSource(), filter);
    ImageProducer DiabloT = new FilteredImageSource(Diablo.getImage().getSource(), filter);
    ImageProducer FoTUT = new FilteredImageSource(fistOfThunderU.getImage().getSource(), filter);
    ImageProducer FoTST = new FilteredImageSource(fistOfThunderS.getImage().getSource(), filter);
    ImageProducer blastUT = new FilteredImageSource(blastU.getImage().getSource(), filter);
    ImageProducer blastST = new FilteredImageSource(blastS.getImage().getSource(), filter);
    ImageProducer superST = new FilteredImageSource(monkSuperS.getImage().getSource(), filter);
    ImageProducer superUT = new FilteredImageSource(monkSuperU.getImage().getSource(), filter);
    ImageProducer bloodForManaUT = new FilteredImageSource(bloodForManaU.getImage().getSource(), filter);
    ImageProducer bloodForManaST = new FilteredImageSource(bloodForManaS.getImage().getSource(), filter);
    ImageProducer healthBarFullT = new FilteredImageSource(healthBarFull.getImage().getSource(), filter);
    ImageProducer healthBarEmptyT = new FilteredImageSource(healthBarEmpty.getImage().getSource(), filter);
    ImageProducer healthBarDamaged1T = new FilteredImageSource(healthBarDamaged1.getImage().getSource(), filter);
    ImageProducer healthBarDamaged2T = new FilteredImageSource(healthBarDamaged2.getImage().getSource(), filter);
    ImageProducer healthBarDamaged3T = new FilteredImageSource(healthBarDamaged3.getImage().getSource(), filter);
    ImageProducer healthBarDamaged4T = new FilteredImageSource(healthBarDamaged4.getImage().getSource(), filter);
    ImageProducer healthBarDamaged5T = new FilteredImageSource(healthBarDamaged5.getImage().getSource(), filter);
    ImageProducer healthBarDamaged6T = new FilteredImageSource(healthBarDamaged6.getImage().getSource(), filter);
    ImageProducer healthBarDamaged7T = new FilteredImageSource(healthBarDamaged7.getImage().getSource(), filter);
    ImageProducer healthBarDamaged8T = new FilteredImageSource(healthBarDamaged8.getImage().getSource(), filter);
    ImageProducer healthBarDamaged9T = new FilteredImageSource(healthBarDamaged9.getImage().getSource(), filter);
    ImageProducer healthBarDamaged10T = new FilteredImageSource(healthBarDamaged10.getImage().getSource(), filter);
    ImageProducer healthBarDamaged11T = new FilteredImageSource(healthBarDamaged11.getImage().getSource(), filter);
    ImageProducer healthBarDamaged12T = new FilteredImageSource(healthBarDamaged12.getImage().getSource(), filter);
    ImageProducer healthBarDamaged13T = new FilteredImageSource(healthBarDamaged13.getImage().getSource(), filter);
    ImageProducer healthBarDamaged14T = new FilteredImageSource(healthBarDamaged14.getImage().getSource(), filter);
    ImageProducer healthBarDamaged15T = new FilteredImageSource(healthBarDamaged15.getImage().getSource(), filter);
    ImageProducer healthBarDamaged16T = new FilteredImageSource(healthBarDamaged16.getImage().getSource(), filter);
    ImageProducer Mana1T = new FilteredImageSource(Mana1.getImage().getSource(), filter);
    ImageProducer Mana2T = new FilteredImageSource(Mana2.getImage().getSource(), filter);
    ImageProducer Mana3T = new FilteredImageSource(Mana3.getImage().getSource(), filter);
    ImageProducer Mana4T = new FilteredImageSource(Mana4.getImage().getSource(), filter);
    ImageProducer Mana5T = new FilteredImageSource(Mana5.getImage().getSource(), filter);
    ImageProducer Mana6T = new FilteredImageSource(Mana6.getImage().getSource(), filter);
    ImageProducer Mana7T = new FilteredImageSource(Mana7.getImage().getSource(), filter);
    ImageProducer Mana8T = new FilteredImageSource(Mana8.getImage().getSource(), filter);
    ImageProducer Mana9T = new FilteredImageSource(Mana9.getImage().getSource(), filter);
    ImageProducer Mana10T = new FilteredImageSource(Mana10.getImage().getSource(), filter);
    ImageProducer Mana11T = new FilteredImageSource(Mana11.getImage().getSource(), filter);
    ImageProducer Mana12T = new FilteredImageSource(Mana12.getImage().getSource(), filter);
    ImageProducer Mana13T = new FilteredImageSource(Mana13.getImage().getSource(), filter);
    ImageProducer Mana14T = new FilteredImageSource(Mana14.getImage().getSource(), filter);
    ImageProducer Mana15T = new FilteredImageSource(Mana15.getImage().getSource(), filter);
    ImageProducer Mana16T = new FilteredImageSource(Mana16.getImage().getSource(), filter);
    ImageProducer Mana17T = new FilteredImageSource(Mana17.getImage().getSource(), filter);
    ImageProducer Mana18T = new FilteredImageSource(Mana18.getImage().getSource(), filter);
    ImageProducer ManaFullT = new FilteredImageSource(ManaFull.getImage().getSource(), filter);
    ImageProducer ManaEmptyT = new FilteredImageSource(ManaEmpty.getImage().getSource(), filter);
    Image manaPotion = Toolkit.getDefaultToolkit().createImage(ManaPotionT);
    Image healthPotion = Toolkit.getDefaultToolkit().createImage(HealthPotionT);
    Image hBarFull = Toolkit.getDefaultToolkit().createImage(healthBarFullT);
    Image hBarEmpty = Toolkit.getDefaultToolkit().createImage(healthBarEmptyT);
    Image hBarDamaged1 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged1T);
    Image hBarDamaged2 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged2T);
    Image hBarDamaged3 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged3T);
    Image hBarDamaged4 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged4T);
    Image hBarDamaged5 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged5T);
    Image hBarDamaged6 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged6T);
    Image hBarDamaged7 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged7T);
    Image hBarDamaged8 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged8T);
    Image hBarDamaged9 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged9T);
    Image hBarDamaged10 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged10T);
    Image hBarDamaged11 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged11T);
    Image hBarDamaged12 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged12T);
    Image hBarDamaged13 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged13T);
    Image hBarDamaged14 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged14T);
    Image hBarDamaged15 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged15T);
    Image hBarDamaged16 = Toolkit.getDefaultToolkit().createImage(healthBarDamaged16T);
    Image SpikeTrap = Toolkit.getDefaultToolkit().createImage(spikesT);
    Image miss = Toolkit.getDefaultToolkit().createImage(MissT);
    Image MFull = Toolkit.getDefaultToolkit().createImage(ManaFullT);
    Image MEmpty = Toolkit.getDefaultToolkit().createImage(ManaEmptyT);
    Image M1 = Toolkit.getDefaultToolkit().createImage(Mana1T);
    Image M2 = Toolkit.getDefaultToolkit().createImage(Mana2T);
    Image M3 = Toolkit.getDefaultToolkit().createImage(Mana3T);
    Image M4 = Toolkit.getDefaultToolkit().createImage(Mana4T);
    Image M5 = Toolkit.getDefaultToolkit().createImage(Mana5T);
    Image M6 = Toolkit.getDefaultToolkit().createImage(Mana6T);
    Image M7 = Toolkit.getDefaultToolkit().createImage(Mana7T);
    Image M8 = Toolkit.getDefaultToolkit().createImage(Mana8T);
    Image M9 = Toolkit.getDefaultToolkit().createImage(Mana9T);
    Image M10 = Toolkit.getDefaultToolkit().createImage(Mana10T);
    Image M11 = Toolkit.getDefaultToolkit().createImage(Mana11T);
    Image M12 = Toolkit.getDefaultToolkit().createImage(Mana12T);
    Image M13 = Toolkit.getDefaultToolkit().createImage(Mana13T);
    Image M14 = Toolkit.getDefaultToolkit().createImage(Mana14T);
    Image M15 = Toolkit.getDefaultToolkit().createImage(Mana15T);
    Image M16 = Toolkit.getDefaultToolkit().createImage(Mana16T);
    Image M17 = Toolkit.getDefaultToolkit().createImage(Mana17T);
    Image M18 = Toolkit.getDefaultToolkit().createImage(Mana18T);
    Image transparentImg = Toolkit.getDefaultToolkit().createImage(filteredImgProd);
    Image mUp = Toolkit.getDefaultToolkit().createImage(mUpT);
    Image mLeft = Toolkit.getDefaultToolkit().createImage(mLeftT);
    Image mRight = Toolkit.getDefaultToolkit().createImage(mRightT);
    Image mDead = Toolkit.getDefaultToolkit().createImage(mDeadT);
    Image fotU = Toolkit.getDefaultToolkit().createImage(FoTUT);
    Image fotS = Toolkit.getDefaultToolkit().createImage(FoTST);
    Image bU = Toolkit.getDefaultToolkit().createImage(blastUT);
    Image bS = Toolkit.getDefaultToolkit().createImage(blastST);
    Image msS = Toolkit.getDefaultToolkit().createImage(superST);
    Image msU = Toolkit.getDefaultToolkit().createImage(superUT);
    Image bFMS = Toolkit.getDefaultToolkit().createImage(bloodForManaST);
    Image bFMU = Toolkit.getDefaultToolkit().createImage(bloodForManaUT);
    Image fLeft = Toolkit.getDefaultToolkit().createImage(fLeftT);
    Image fRight = Toolkit.getDefaultToolkit().createImage(fRightT);
    Image hLeft = Toolkit.getDefaultToolkit().createImage(hLeftT);
    Image hRight = Toolkit.getDefaultToolkit().createImage(hRightT);
    Image diablo = Toolkit.getDefaultToolkit().createImage(DiabloT);
    Image DeathMessage = Toolkit.getDefaultToolkit().createImage(deathMessageT);
    //********************************************************************************************************************//
    JFrame gameMap = new JFrame("Diablo 3");

    public DemonHunter() throws IOException {

        addKeyListener(new AL());

        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursor_image, new Point(0, 0), "My Cursor");
        setCursor(cursor);

        setTitle("Diablo 3");
        setVisible(true);
        setSize(1117, 850);
        AudioPlayer.player.start(as);
        setResizable(false);
        //c.add(mSkill1);
        //c.addKeyListener(new AL ());
        //mSkill1.addActionListener(null);
        //mSkill1.setMargin(new Insets(0,0,0,0));
        //getContentPane().add(c);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Enemy = new DemonHunter.Enemy();
        Enemy2 = new DemonHunter.Enemy2();
        //DiabloThread = new DemonHunter.DiabloThread();
        Enemy.start();
        Enemy2.start();
        DiabloThread.start();
        //DiabloThread = null;
    }

    /**
     *
     */
    public class AL extends KeyAdapter { //method to store pressed key

        @Override
        public void keyPressed(KeyEvent e) { // stores pressed button
            int keyCode = e.getKeyCode(); // stores pressed button to "keyCode"    

            if (keyCode == KeyEvent.VK_D) {
                x += 10;
                attack = false;
                dir = "r";
                repaint();
            } else if (keyCode == KeyEvent.VK_W) {
                y -= 10;
                dir = "u";
                attack = false;
                repaint();
            } else if (keyCode == KeyEvent.VK_A) {
                x -= 10;
                dir = "l";
                attack = false;
                repaint();
            } else if (keyCode == KeyEvent.VK_S) {
                y += 10;
                dir = "d";
                attack = false;
                repaint();
            } else if (keyCode == KeyEvent.VK_COMMA) {
                if (selected == 1) {
                    if (mana < 99) {
                        if (x + 22 > enemyX && x - 22 < enemyX && y + 22 > enemyY && y - 22 < enemyY) {
                            enemyHealth -= 1;
                        }
                        if (x + 22 > enemy2X && x - 22 < enemy2X && y + 22 > enemy2Y && y - 22 < enemy2Y) {
                            enemy2Health -= 1;
                        }
                        if (x + 22 > diabloX + 69 && x - 22 < diabloX + 69 && y + 22 > diabloY + 179 && y - 22 < diabloY + 179) {
                            diabloHealth -= 2;
                        }

                    }
                } else if (selected == 2) {
                    spikeTrap = true;
                    spikeTrapX = x;
                    spikeTrapY = y;
                } else if (selected == 3) {
                    if (mana <= 16) {
                        if (x + 22 > enemyX && x - 22 < enemyX && y + 22 > enemyY && y - 22 < enemyY) {
                            enemyHealth -= 5;
                        }
                        if (x + 22 > enemy2X && x - 22 < enemy2X && y + 22 > enemy2Y && y - 22 < enemy2Y) {
                            enemy2Health -= 5;
                        }
                        mana += 5;
                        if (x + 22 > diabloX + 69 && x - 22 < diabloX + 69 && y + 22 > diabloY + 179 && y - 22 < diabloY + 179) {
                            diabloHealth -= 5;
                        }
                    }
                }

                attack = true;

                repaint();
            } else if (keyCode == KeyEvent.VK_M) {
                if (selected > 1) {
                    selected -= 1;
                } else {
                    selected = 3;
                }
                repaint();
            } else if (keyCode == KeyEvent.VK_PERIOD) {
                if (selected < 3) {
                    selected += 1;
                } else {
                    selected = 1;
                }
                repaint();
            }
        }
    }

    public class Enemy extends Thread {

        public void run() {
            while (Enemy != null) {
                if (enemyX > x + 17 && enemyY > y + 17) { //enemy is top right
                    enemyX -= 1;
                    enemyY -= 1;
                    eDir = "l";
                    repaint();
                    delay(600000);
                } else if (enemyX > x + 17 && enemyY < y - 17) { //enemy is bottom right
                    enemyX -= 1;
                    enemyY += 1;
                    eDir = "l";
                    repaint();
                    delay(600000);
                } else if (enemyX < x - 17 && enemyY > y + 17) { //enemy is top left
                    enemyX += 1;
                    enemyY -= 1;
                    eDir = "r";
                    repaint();
                    delay(600000);
                } else if (enemyX < x - 17 && enemyY < y - 17) { //enemy is bottom left
                    enemyX += 1;
                    enemyY += 1;
                    eDir = "r";
                    repaint();
                    delay(600000);
                } else if (enemyX < x - 17) { //enemy is to the left
                    enemyX += 1;
                    eDir = "r";
                    repaint();
                    delay(600000);

                } else if (enemyY < y - 17) { //enemy is above
                    enemyY += 1;
                    repaint();
                    delay(600000);
                } else if (enemyX > x + 17) { //enemy is to tht right
                    enemyX -= 1;
                    eDir = "l";
                    repaint();
                    delay(600000);
                } else if (enemyY > y + 17) { //enemy is below
                    enemyY -= 1;
                    repaint();
                    delay(600000);
                }
                if (enemyHealth > 0) {
                    if (enemyX + 21 > x && enemyX - 21 < x && enemyY + 21 > y && enemyY - 21 < y) {
                        delay(10000000);
                        double damage = 0 + (int) (Math.random() * ((5 - 0) + 1));
                        int pDamage = 0;
                        if (damage == 2) {
                            if (enemy1 == 1) {
                                pDamage = e.enemy1Attacks();
                            } else if (enemy1 == 2) {
                                pDamage = e.enemy2Attacks();
                            }
                            playerDamage += pDamage;
                            hitOrMiss = false;
                            repaint();
                        } else {
                            hitOrMiss = true;
                            repaint();
                        }
                    }
                    if (enemyX + 21 > spikeTrapX && enemyX - 21 < spikeTrapX && enemyY + 21 > spikeTrapY && enemyY - 21 < spikeTrapY) {
                        enemyHealth -= 3;
                        repaint();
                    }
                }
            }

        }
    }

    public class Enemy2 extends Thread {

        public void run() {

            while (Enemy2 != null) {

                if (enemy2X > x + 18 && enemy2Y > y + 18) { //enemy is top right
                    enemy2X -= 2;
                    enemy2Y -= 2;
                    e2Dir = "l";
                    repaint();
                    delay(1000000);
                } else if (enemy2X > x + 18 && enemy2Y < y - 18) { //enemy is bottom right
                    enemy2X -= 1;
                    enemy2Y += 1;
                    e2Dir = "l";
                    repaint();
                    delay(1000000);
                } else if (enemy2X < x - 18 && enemy2Y > y + 18) { //enemy is top left
                    enemy2X += 2;
                    enemy2Y -= 2;
                    e2Dir = "r";
                    repaint();
                    delay(1000000);
                } else if (enemy2X < x - 18 && enemy2Y < y - 18) { //enemy is bottom left
                    enemy2X += 2;
                    enemy2Y += 2;
                    e2Dir = "r";
                    repaint();
                    delay(1000000);
                } else if (enemy2X < x - 18) { //enemy is to the left
                    enemy2X += 2;
                    e2Dir = "r";
                    repaint();
                    delay(1000000);

                } else if (enemy2Y < y - 18) { //enemy is above
                    enemy2Y += 2;
                    repaint();
                    delay(1000000);
                } else if (enemy2X > x + 18) { //enemy is to tht right
                    enemy2X -= 2;
                    e2Dir = "l";
                    repaint();
                    delay(1000000);
                } else if (enemy2Y > y + 18) { //enemy is below
                    enemy2Y -= 2;
                    repaint();
                    delay(1000000);
                }
                if (enemy2Health > 0) {
                    if (enemy2X + 21 > x && enemy2X - 21 < x && enemy2Y + 21 > y && enemy2Y - 21 < y) {
                        delay(10000000);
                        double damage = 0 + (int) (Math.random() * ((5 - 0) + 1));
                        int pDamage = 0;
                        if (damage == 2) {
                            if (enemy2 == 1) {
                                pDamage = e.enemy1Attacks();
                            } else if (enemy2 == 2) {
                                pDamage = e.enemy2Attacks();
                            }
                            playerDamage += pDamage;
                            hitOrMiss = false;
                            repaint();
                        }
                    }
                    if (enemy2X + 21 > spikeTrapX && enemy2X - 21 < spikeTrapX && enemy2Y + 21 > spikeTrapY && enemy2Y - 21 < spikeTrapY) {
                        enemy2Health -= 3;
                        repaint();
                    }
                }
            }
        }
    }

    /*public class DiabloThread extends Thread {

        public void run() {

            while (DiabloThread != null) {

                if (diabloX + 69 > x + 18 && diabloY + 179 > y + 18) { //enemy is top right
                    diabloX -= 3;
                    diabloY -= 3;
                    e2Dir = "l";
                    repaint();
                    delay(1000000);
                } else if (diabloX + 69 > x + 18 && diabloY + 179 < y - 18) { //enemy is bottom right
                    diabloX -= 1;
                    diabloY += 1;
                    e2Dir = "l";
                    repaint();
                    delay(1000000);
                } else if (diabloX + 69 < x - 18 && diabloY + 179 > y + 18) { //enemy is top left
                    diabloX += 2;
                    diabloY -= 2;
                    e2Dir = "r";
                    repaint();
                    delay(1000000);
                } else if (diabloX + 69 < x - 18 && diabloY + 179 < y - 18) { //enemy is bottom left
                    diabloX += 2;
                    diabloY += 2;
                    e2Dir = "r";
                    repaint();
                    delay(1000000);
                } else if (diabloX + 69 < x - 18) { //enemy is to the left
                    diabloX += 2;
                    e2Dir = "r";
                    repaint();
                    delay(1000000);

                } else if (diabloY + 179 < y - 18) { //enemy is above
                    diabloY += 2;
                    repaint();
                    delay(1000000);
                } else if (diabloX + 69 > x + 18) { //enemy is to tht right
                    diabloX -= 2;
                    e2Dir = "l";
                    repaint();
                    delay(1000000);
                } else if (diabloY + 179 > y + 18) { //enemy is below
                    diabloY -= 2;
                    repaint();
                    delay(1000000);
                }
                if (diabloHealth > 0) {
                    if (diabloX + 69 > x  && diabloX < x && diabloY + 179  < y  && diabloY + 193 > y ) {
                        System.out.println("Diablo!!!!!1!!!");
                        delay(10000000);
                        double damage = 0 + (int) (Math.random() * ((5 - 0) + 1));
                        int pDamage = 0;
                        if (damage == 2) {
                            pDamage = e.diabloAttacks();
                            playerDamage += pDamage;
                            hitOrMiss = false;
                            repaint();
                        } else {
                            hitOrMiss = true;
                            repaint();
                        }
                    }
                    if (diabloX + 69 > spikeTrapX + 18 && diabloX + 69 < spikeTrapX + 18 && diabloY + 179 > spikeTrapY + 18 && diabloY + 179 < spikeTrapY - 18) {
                        diabloHealth -= 3;
                        repaint();
                    }
                }
            }
        }
    }*/

    public void delay(int howLong) {
        for (int i = 0; i <= howLong; i++) {
            double garbage = Math.PI * Math.PI + Math.sin(Math.PI);
        }
    }

    public void paint(Graphics g) {

        //super.paint(g);
        int move;

        g.drawImage(map, 0, 0, this);

        if (selected == 1) {
            g.drawImage(fotS, hBarFull.getWidth(this) + 5, 780, this);
            g.drawImage(bU, fotS.getWidth(this) + hBarFull.getWidth(this) + 5, 780, this);
            g.drawImage(msU, (fotS.getWidth(this) * 2) + hBarFull.getWidth(this) + 5, 780, this);
        } else if (selected == 2) {
            g.drawImage(fotU, hBarFull.getWidth(this) + 5, 780, this);
            g.drawImage(bS, fotS.getWidth(this) + hBarFull.getWidth(this) + 5, 780, this);
            g.drawImage(msU, (fotS.getWidth(this) * 2) + hBarFull.getWidth(this) + 5, 780, this);
        } else if (selected == 3) {
            g.drawImage(fotU, hBarFull.getWidth(this) + 5, 780, this);
            g.drawImage(bU, fotS.getWidth(this) + hBarFull.getWidth(this) + 5, 780, this);
            g.drawImage(msS, (fotS.getWidth(this) * 2) + hBarFull.getWidth(this) + 5, 780, this);
        }


        /*if (hitOrMiss = false){
         g.drawImage (miss, x,y - ( mUp.getHeight(this) / 2),this);
         }*/

        if (playerDamage <= 0) {
            g.drawImage(hBarFull, 0, 735, this);
        } else if (playerDamage == 1) {
            g.drawImage(hBarDamaged1, 0, 735, this);
        } else if (playerDamage == 2) {
            g.drawImage(hBarDamaged2, 0, 735, this);
        } else if (playerDamage == 3) {
            g.drawImage(hBarDamaged3, 0, 735, this);
        } else if (playerDamage == 4) {
            g.drawImage(hBarDamaged4, 0, 735, this);
        } else if (playerDamage == 5) {
            g.drawImage(hBarDamaged5, 0, 735, this);
        } else if (playerDamage == 6) {
            g.drawImage(hBarDamaged6, 0, 735, this);
        } else if (playerDamage == 7) {
            g.drawImage(hBarDamaged7, 0, 735, this);
        } else if (playerDamage == 8) {
            g.drawImage(hBarDamaged8, 0, 735, this);
        } else if (playerDamage == 9) {
            g.drawImage(hBarDamaged9, 0, 735, this);
        } else if (playerDamage == 10) {
            g.drawImage(hBarDamaged10, 0, 735, this);
        } else if (playerDamage == 11) {
            g.drawImage(hBarDamaged11, 0, 735, this);
        } else if (playerDamage == 12) {
            g.drawImage(hBarDamaged12, 0, 735, this);
        } else if (playerDamage == 13) {
            g.drawImage(hBarDamaged13, 0, 735, this);
        } else if (playerDamage == 14) {
            g.drawImage(hBarDamaged14, 0, 735, this);
        } else if (playerDamage == 15) {
            g.drawImage(hBarDamaged15, 0, 735, this);
        } else if (playerDamage == 16) {
            g.drawImage(hBarDamaged16, 0, 735, this);
        } else if (playerDamage > 16) {
            g.drawImage(hBarEmpty, 0, 735, this);
            g.drawImage(mDead, x, y, this);
            g.drawImage(DeathMessage, 300,200, this);
            removeKeyListener(new AL());
            gameMap.removeAll();
            AudioPlayer.player.stop(as);
            AudioPlayer.player.start(dAS);
            Enemy = null;
            Enemy2 = null;
            //DiabloThread = null;
        }

        if (mana <= 0) {
            g.drawImage(MFull, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 1) {
            g.drawImage(M1, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 2) {
            g.drawImage(M2, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 3) {
            g.drawImage(M3, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 4) {
            g.drawImage(M4, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 5) {
            g.drawImage(M5, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 6) {
            g.drawImage(M6, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 7) {
            g.drawImage(M7, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 8) {
            g.drawImage(M8, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 9) {
            g.drawImage(M9, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 10) {
            g.drawImage(M10, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 11) {
            g.drawImage(M11, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 12) {
            g.drawImage(M12, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 13) {
            g.drawImage(M14, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 14) {
            g.drawImage(M14, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 15) {
            g.drawImage(M15, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 16) {
            g.drawImage(M16, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 17) {
            g.drawImage(M17, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana == 18) {
            g.drawImage(M18, 1117 - MFull.getWidth(this), 735, this);
        } else if (mana > 18) {
            g.drawImage(MEmpty, 1117 - MFull.getWidth(this), 735, this);
        }

        if (playerDamage <= 16) {
            if (enemyHealth > 0) {
                if (enemy1 == 1) {
                    if (eDir.equals("l")) {
                        g.drawImage(fLeft, enemyX, enemyY, this);
                    } else if (eDir.equals("r")) {
                        g.drawImage(fRight, enemyX, enemyY, this);
                    }
                } else if (enemy1 == 2) {
                    if (eDir.equals("l")) {
                        g.drawImage(hLeft, enemyX, enemyY, this);
                    } else if (eDir.equals("r")) {
                        g.drawImage(hRight, enemyX, enemyY, this);
                    }
                }
            } else {
                ////enemiesLeft -= 1;

                if (enemy1 < 3) {
                    enemyX = 340;
                    enemyY = 266;
                    enemy1++;
                    diabloYN++;
                }
                //playerDamage += 2;

                if (enemy1 == 3) {
                    potionsX = enemyX;
                    potionsY = enemyY;
                    drawPotions = 1;
                    Enemy = null;
                }
                enemyHealth = 22;

            }


            if (enemy2Health > 0) {
                if (enemy2 == 1) {
                    if (e2Dir.equals("l")) {
                        g.drawImage(fLeft, enemy2X, enemy2Y, this);
                    } else if (e2Dir.equals("r")) {
                        g.drawImage(fRight, enemy2X, enemy2Y, this);
                    }
                } else if (enemy2 == 2) {
                    if (e2Dir.equals("l")) {
                        g.drawImage(hLeft, enemy2X, enemy2Y, this);
                    } else if (e2Dir.equals("r")) {
                        g.drawImage(hRight, enemy2X, enemy2Y, this);
                    }
                }

            } else {

                if (enemy2 < 3) {
                    enemy2X = 675;
                    enemy2Y = 444;
                    enemy2Health = 22;
                    enemy2++;
                    diabloYN++;
                }
                if (enemy2 == 3) {
                    potions2X = enemy2X;
                    potions2Y = enemy2Y;
                    drawPotions = 1;
                    //Enemy2 = null;
                }

            }


        }
        if (spikeTrap = true) {
            g.drawImage(SpikeTrap, spikeTrapX, spikeTrapY, this);
        }



        if (diabloYN == 4) {
            diabloHealth = - 9;
            if (diabloHealth > 0) {
                g.drawImage(diablo, diabloX, diabloY, this);
            } else {
                try {
                    AudioPlayer.player.stop(as);
                    dispose();
                    EndCinematic ec = new EndCinematic();
                } catch (IOException ex) {
                    Logger.getLogger(TileMap.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        if (playerDamage <= 16) {
            if (dir.equals("d")) {
                g.drawImage(transparentImg, x, y, this);
            } else if (dir.equals("u")) {
                g.drawImage(mUp, x, y, this);
            } else if (dir.equals("l")) {
                g.drawImage(mLeft, x, y, this);
            } else if (dir.equals("r")) {
                g.drawImage(mRight, x, y, this);
            }
        }


        if (x == potionsX && y + 10 > potionsY && y - 10 < potionsY) {

            if (collected1 != 1) {
                if (playerDamage - 2 > -1) {
                    playerDamage -= 2;
                } else {
                    playerDamage = 0;
                }
                if (mana - 4 > - 1) {
                    mana -= 4;
                } else {
                    mana = 0;
                }
                repaint();
                collected1 = 1;
            }
        }
        if (x - 10 < potions2X && x + 10 > potions2X && y + 10 > potions2Y && y - 10 < potions2Y) {

            if (collected2 != 1) {
                if (playerDamage - 2 > -1) {
                    playerDamage -= 2;
                } else {
                    playerDamage = 0;
                }
                if (mana - 4 > - 1) {
                    mana -= 4;
                } else {
                    mana = 0;
                }
                repaint();
                collected2 = 1;
            }
        }

        if (drawPotions == 1) {
            if (enemy2 == 3) {
                if (collected2 == 0) {
                    g.drawImage(manaPotion, potions2X, potions2Y, this);
                    g.drawImage(healthPotion, potions2X + 15, potions2Y, this);
                }
            }
            if (enemy1 == 3) {// enemy2's potions drops
                if (collected1 == 0) {
                    g.drawImage(manaPotion, potionsX, potionsY, this);
                    g.drawImage(healthPotion, potionsX + 15, potionsY, this);
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        DemonHunter d = new DemonHunter();
        //Enemies e = new Enemies ();
    }
}
