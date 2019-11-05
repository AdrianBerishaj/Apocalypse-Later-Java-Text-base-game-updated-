
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrian
 */
public class Enemy {
     String enemyType[] = {"Skeley boi", "Lesser Imp", "(crappy) Mage"};
    String enemyType2[] = {"Big mossy boi", "Colossal Forest Spider", "Forest Gremlin"};
    String enemyType3[] = {"Sp00ky boi", "Zambie", "Ball of Bones"};
    String enemyType4[] = {"(high tier) Mage", "(not so good) Angel", "Gigantic Fist boi"};
    int lvl, enemyHealth, dmg, armr ;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    int[] enemyStats;
    int difficulty;
    public Enemy(int Elvl, int Ehealth, int Edmg, int Earmr)
    {
        lvl = Elvl;
        dmg = Edmg;
        armr = Earmr;
        enemyHealth = Ehealth;
        enemyStats = new int[]{lvl, enemyHealth, dmg, armr};
                     
    }
        
   public void getEnemy()
           {
               System.out.println("\n\n\tA " + enemyType[rand.nextInt(enemyType.length)] + " has appeared!");
           }
   public void getEnemy2()
           {
               System.out.println("\n\n\tA " + enemyType2[rand.nextInt(enemyType.length)] + " has appeared!");
           }
   public void getEnemy3()
           {
               System.out.println("\n\n\tA " + enemyType3[rand.nextInt(enemyType.length)] + " has appeared!");
           }
   public void getEnemy4()
           {
               System.out.println("\n\n\tA " + enemyType4[rand.nextInt(enemyType.length)] + " has appeared!");
           }
    
   public void showEnemyStats() // command "identify"
     {
         System.out.println("\n\tLEVEL: " +enemyStats[0] + "\n\tHP: " + enemyStats[1] + "\n\tATT: " + enemyStats[2] + "\n\tDEF: " );  
     }
   
   public void newEnemy() /// edit the stats for each enemy type
   {
       enemyStats[1] = rand.nextInt(16) + 25;
       enemyStats[2] = rand.nextInt(6) + 10;
       enemyStats[3] = rand.nextInt(8) + 5; 
   }      
    
   public void newEnemy2()
   {
       enemyStats[1] = rand.nextInt(16) + 35;
       enemyStats[2] = rand.nextInt(6) + 10;
       enemyStats[3] = rand.nextInt(8) + 5;
   }   

   public void newEnemy3()
   {
       enemyStats[1] = rand.nextInt(16) + 50;
       enemyStats[2] = rand.nextInt(6) + 10;
       enemyStats[3] = rand.nextInt(8) + 5;
   } 
   
   public void newEnemy4()
   {
       enemyStats[1] = rand.nextInt(16) + 75;
       enemyStats[2] = rand.nextInt(6) + 10;
       enemyStats[3] = rand.nextInt(8) + 5;
   }      
}
