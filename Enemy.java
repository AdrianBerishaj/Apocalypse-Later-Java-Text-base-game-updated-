
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
     String enemyType[] = {"Big mossy boi", "Colossal Forest Spider", "Forest Gremlin"};
     String enemyType2[] = {"Tribal Demon", "Kurtz's Underling", "Undead Dude"};
    String enemyType3[] = {"Tibal leader", "Kurtz's Follower", "The Darkness of Humanity"};
    
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
   
  
   
   public int bossOneSkills(int skillUse,int Elvl, int Ehealth, int Edmg, int Earmr)
   {
       int Bdmg = 0;
       String choice;
       switch (skillUse)
       {
           case 0:
               System.out.println("\n\tThe Minotaur enrages himself and charges straight toward you!");
               if(rand.nextInt(25)>7)
               {
                   System.out.println("\n\tYou managed to dodge his charge attack!");
               }
               else
               {
                   Bdmg = rand.nextInt(Edmg) + (Edmg/2);
                   System.out.println("\n\tThe Minotaur slams you and knocks you down! You took " + Bdmg + " damage!");
               }
               break;
           case 1:
               System.out.println("\n\tThe Minotaur looks like he's going for a powerful swing, looks risky to try dodging, but the choice is yours.\n\n\t"
                       + "Do you   1. Shield yourself from the attack    2. Take a risk and try dodging    (type 1 or 2 for decision)");
               while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       Bdmg = rand.nextInt(Edmg) ;
                       System.out.println("\n\tYou shield youself from his powerful blow, but still take " + Bdmg + " damage!");
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       if(rand.nextInt(40)>7)
                        {
                            System.out.println("\n\tYou managed to dodge his charge attack!");
                        }
                       else
                       {
                           Bdmg = ((rand.nextInt(Edmg) + (Edmg/2)));
                           System.out.println("\n\tYou couldn't dodge his attack! You took " + Bdmg + " damage!");
                       }
                       break;
                   }
                   else
                   {
                       System.out.println("\n\tPlease type either 1 or 2");
                   }
               }
               break;
       }
       return Bdmg;
   }
   
   public int bossTwoSkills(int skillUse,int Elvl, int Ehealth, int Edmg, int Earmr)
   {
       int Bdmg = 0;
       String choice;
       switch (skillUse)
       {
           case 0:
               System.out.println("\n\t");
               if(rand.nextInt(20)>7)
               {
                   System.out.println("\n\tArmstrongs moustache isnt as powerful as it seemed. You were able to withstand its power");
               }
               else
               {
                   Bdmg = ((rand.nextInt(Edmg) + (Edmg/2))*3);
                   System.out.println("\n\tYou can't Fathom his moustache, its overwhelming.  Almost as if it has its own Power level of its own. He laughs at you and says \"Ha! You think you are  a true man, FOOL!\". You are ashamed and take " + Bdmg + " damage due to your humiliation!");
               }
               break;
           case 1:
               System.out.println("\n\tArmstrong Begins to flex his muscles with every ounce of his being. Soon you realize that he is trying to make you worthless as a man but showing is Martial Prowess.  You have to try something or else its all over!!\n\n\t"
                       + "Do you   1. Flex along side him.    2. Try to curl into a ball and defend yourself      3. Cry   (type 1, 2, or 3 for decision)");
               while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       if(rand.nextInt(60)>10)
                        {
                            System.out.println("\n\tHe admires your strength but realizes his plans have been foiled.");
                        }
                       else
                       {
                           Bdmg = rand.nextInt(Edmg) + (Edmg/2);
                           System.out.println("\n\tHe scoffs at your puny muscles but admires the attempt. You took " + Bdmg + " damage!  You're lucky he admired you for a second or youd be dead");
                       }
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       Bdmg = ((rand.nextInt(Edmg) + (Edmg/2))) - Earmr;
                       System.out.println("\n\tYou curling into a ball seems to help you a bit because he takes some pity on you, you take " + Bdmg + " damage!");
                       break;
                   }
                   else if(choice.equals("3")){
                       if(rand.nextInt(9)>5){
                           System.out.println("\n\tSomehow that managed to work! It seems like a miracle, but you don't take any damage!");
                       }
                       else{
                           Bdmg = ((rand.nextInt(Edmg) + (Edmg))*3);
                           System.out.println("\n\tYou just stand there crying. What did you think would happen? You took " + Bdmg + " damage because you felt the most pathetic anyone's felt");
                       }
                   }
                   else
                       System.out.println("\n\tPlease choose a valid option!");
               }
               break;
       }
       return Bdmg;
   }
   
   public int bossThreeSkills(int skillUse,int Elvl, int Ehealth, int Edmg, int Earmr)
   {
       int Bdmg = 0;
       String choice;
       switch (skillUse)
       {
           case 0:
               System.out.println("Kurtz is reading what sounds like poem stanzas. What will you do? \n\n\t" + 
                       "1. Try to disrupt his incantations   2. Try to take this opportunity to attack him!     (type 1 or 2 for decision)");
               while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       if(rand.nextInt(25)>7) /////////////////////ERROR//////////////////
                        {
                            System.out.println("\n\tYou started shouting and Kurtz seems surprised.");
                        }
                       else
                       {
                           Bdmg = rand.nextInt(Edmg) + (Edmg/2);
                           System.out.println("\n\tYou try to disrupt him, but it seems like a wasted effort. Kurtz has inhuman Focus! A shadow surrounds you. It doesnt hurt you physically but you brain feels like its being broken into.  You take " + Bdmg + " damage!");
                       }
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       Bdmg = ((rand.nextInt(Edmg) + (Edmg/2))*3);
                       System.out.println("\n\tHe ignores your attack as it seems his incantation is complete!  You took " + Bdmg + " damage!");
                       break;
                   }
                   else
                       System.out.println("\n\tPlease choose a valid option!");
               }
               break;
           case 1:
               System.out.println("It seems as if the darkness is merging with Kurtz. This might be big trouble. How do you react? \n\n\t" + 
                       "1. Take a defensive stance!     2. Try to stop him by absorbing the Darkness yourself!     3. Stare at the monstrosity before you!      (type 1, 2, or 3 for decision)");
               while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       Bdmg = ((rand.nextInt(Edmg) + (Edmg/2))*3) - rand.nextInt(100);
                       System.out.println("\n\tYou have enough time to take a defensive stance and shield yourself from a powerful blow from his now huge fist,\n\t but still take " + Bdmg + " damage! They fall back out into individual girls after they hit you.");
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       if(rand.nextInt(25)>8){
                           System.out.println("\n\tYou are able to absorb the darkness yourself! Youre scared but soon realize that the darkness was already part of you");
                       }
                       else{
                           Bdmg = ((rand.nextInt(Edmg) + (Edmg/2))*3);
                           System.out.println("\n\tYou aren't quick enough to stop him from transforming! he kicks you away as hard as he can in his enlargened\n\t state before returning to the Kurtz you seem to know all too well . You took " + Bdmg + " damage!");
                       }
                       break;
                   }
                   else if(choice.equals("3"))
                   {
                       Bdmg = (rand.nextInt(Edmg)*4);
                       System.out.println("\n\tHe sees fear and judgement in your eyes, these are what Kurtz despises most!"
                               + "\n\t He brings his almighty fist down for one attack before all falling out back into his original form. You took " + Bdmg + " damage!");
                       break;
                   }
                   else
                       System.out.println("\n\tPlease choose a valid option!");
               }
               break;
       }
       return Bdmg;
   }
   
   
         
}
