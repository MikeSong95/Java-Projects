/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonkGame;

/**
 *
 * @author Michael
 */
public class EnemyAttacks {
    
    public EnemyAttacks (){
        super();
    }
    public int enemy1Attacks(){
        int damage = 1 + (int)(Math.random() * ((2 - 1) + 1));
        return damage;
    }
    
    public int enemy2Attacks (){
        int damage = 2 + (int)(Math.random() * ((3 - 2) + 2));
        return damage;
    }
    
    public int diabloAttacks (){
        int damage = 3 + (int)(Math.random() * ((6 - 3) + 3)); 
        return damage;
    }
}
