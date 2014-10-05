/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WizardGame;

import DemonHunterGame.*;

/**
 *
 * @author Michael
 */
public class WEnemyAttacks {
   
    public WEnemyAttacks (){
        super();
    }
    public int enemy1Attacks(){
        int damage = 1 + (int)(Math.random() * ((3 - 1) + 1));
        return damage;
    }
    
    public int enemy2Attacks (){
        int damage = 2 + (int)(Math.random() * ((4 - 2) + 2));
        return damage;
    }
    
    public int diabloAttacks (){
        int damage = 4 + (int)(Math.random() * ((5 - 4) + 4)); 
        return damage;
    }
}
