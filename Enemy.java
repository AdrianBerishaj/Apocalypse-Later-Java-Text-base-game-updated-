
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
                       Bdmg = ((rand.nextInt(Edmg) + (Edmg/2))*3) ;
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
                           Bdmg = ((rand.nextInt(Edmg) + (Edmg/2))*3);
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
   
   public int bossTwoSkills(int skillUse, int pSTR, int pCON, int pINT, int pCHA, int eSTR, int eINT)
   {
       int Bdmg = 0;
       String choice;
       switch (skillUse)
       {
           case 0:
               System.out.println("\n\tHacker Girl whips out her laptop and starts to furiously type on the keyboard! You try to figure out what she's doing!");
               if(rand.nextInt(pINT)>7)
               {
                   System.out.println("\n\tYou were smart enough to realize that she is just furiously typing nothing but incoherent letters! You tell her as such and she just glares at you before putting her laptop away.");
               }
               else
               {
                   Bdmg = ((rand.nextInt(eSTR) + (eINT/2))*3);
                   System.out.println("\n\tYou can't figure out what she's doing! She laughs at you and says \"Ha! Your puny brain is no match for my superior intellect!\". You are ashamed and take " + Bdmg + " damage due to your humiliation!");
               }
               break;
           case 1:
               System.out.println("\n\tHacker Girl stares at a tree with an odd sense of purpose. Soon you realize that she is hacking into the world itself! You can't believe what you're seeing and rationalize that it shouldn't be possible unless you are in some sort of game! You need to try and stop her!\n\n\t"
                       + "Do you   1. Try to talk her out of doing anything.    2. Try to curl into a ball and defend yourself      3. Brace yourself for what she's about to do   (type 1, 2, or 3 for decision)");
               while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       if(rand.nextInt(pCHA)>7)
                        {
                            System.out.println("\n\tYou were able to distract her enough for long enough that her hacking attempt fails! Whew!");
                        }
                       else
                       {
                           Bdmg = rand.nextInt(eSTR) + (eINT/2);
                           System.out.println("\n\tYour attempt to stall her fails! She is still able to complete her hack, but it seems to do a little less damage because of what you did. You took " + Bdmg + " damage!");
                       }
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       Bdmg = ((rand.nextInt(eSTR) + (eINT/2))*3) - pSTR - pCON;
                       System.out.println("\n\tYou curling into a ball seems to help you a bit with her changing your health value somehow, but you still take " + Bdmg + " damage!");
                       break;
                   }
                   else if(choice.equals("3")){
                       if(rand.nextInt(pCON)>7 && rand.nextInt(pSTR)>7){
                           System.out.println("\n\tSomehow that managed to work! It seems like a miracle, but you don't take any damage!");
                       }
                       else{
                           Bdmg = ((rand.nextInt(eSTR) + (eINT/2))*3);
                           System.out.println("\n\tYou just stand there uselessly. What did you think would happen? You took " + Bdmg + " damage since you allowed her to hack away your health!");
                       }
                   }
                   else
                       System.out.println("\n\tPlease choose a valid option!");
               }
               break;
       }
       return Bdmg;
   }
   
   public int bossThreeSkills(int skillUse, int pDEX, int pSTR, int pCON, int pCHA, int eSTR)
   {
       int Bdmg = 0;
       String choice;
       switch (skillUse)
       {
           case 0:
               System.out.println("The mob of girls appear to start hysterically crying! What will you do? \n\n\t" + 
                       "1. Try to calm them down!   2. Try to take this opportunity to attack them!     (type 1 or 2 for decision)");
               while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       if(rand.nextInt(pCHA)>7) /////////////////////ERROR//////////////////
                        {
                            System.out.println("\n\tYou were able to calm down the girls! That was weird.");
                        }
                       else
                       {
                           Bdmg = rand.nextInt(eSTR) + (eSTR/2);
                           System.out.println("\n\tYou couldn't calm them down, though they appreciate the effort! They stare at you with their tear-filled eyes and you feel extremely uncomfortable. You took " + Bdmg + " damage!");
                       }
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       Bdmg = ((rand.nextInt(eSTR) + (eSTR/2))*3);
                       System.out.println("\n\tWow, that's rude. They simply dismiss your attack as it appears that they were charging a powerful spell this whole time!  You took " + Bdmg + " damage!");
                       break;
                   }
                   else
                       System.out.println("\n\tPlease choose a valid option!");
               }
               break;
           case 1:
               System.out.println("The weird children appear to be combining together to make one huge monstrosity! Children nowadays. How do you react? \n\n\t" + 
                       "1. Take a defensive stance!     2. Try to bring the beast down before it fully metamorphosizes!     3. Gawk at how ugly it is!      (type 1, 2, or 3 for decision)");
               while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       Bdmg = ((rand.nextInt(eSTR) + (eSTR/2))*3) - pSTR - pCON;
                       System.out.println("\n\tYou have enough time to take a defensive stance and shield yourself from a powerful blow from their now huge fist,\n\t but still take " + Bdmg + " damage! They fall back out into individual girls after they hit you.");
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       if(rand.nextInt(pDEX)>8){
                           System.out.println("\n\tYou are able to reach out and pull back one of the girls in time! This interrupts their transformation and they all fall back!");
                       }
                       else{
                           Bdmg = ((rand.nextInt(eSTR) + (eSTR/2))*3);
                           System.out.println("\n\tYou aren't quick enough to stop them from transforming! They kick you away as hard as they can in their enlargened\n\t state before returning to their original individual children selves. You took " + Bdmg + " damage!");
                       }
                       break;
                   }
                   else if(choice.equals("3"))
                   {
                       Bdmg = ((rand.nextInt(eSTR) + (eSTR/2))*4);
                       System.out.println("\n\tThat's really mean, they're just trying to live their abnormal lives you meanie! Once they fully transform, they see how you're looking at them and scream at you!"
                               + "\n\t They bring their now mighty fist down for one attack before all falling out back into their original formation. You took " + Bdmg + " damage!");
                       break;
                   }
                   else
                       System.out.println("\n\tPlease choose a valid option!");
               }
               break;
       }
       return Bdmg;
   }
   
   public int[] bossFourSkills(int skillUse, int[] pSTATS, int[] eSTATS, boolean TNR)
   {
       int[] newPSTATS = new int[pSTATS.length];
       System.arraycopy(pSTATS, 0, newPSTATS, 0, newPSTATS.length);
       int mES = eSTATS[2], lPS = newPSTATS[1], dmg = 0, dodge;
       String choice;
       switch (skillUse)
       {
           case 0:
               if(TNR == true)
               {
                   System.out.println("\n\t\"I will SUCC the power right out of you!\"\n\n\tEvil Boi drained your stats!");
                   for(int i = 0; i<pSTATS.length; i++)
                   {
                       pSTATS[i] -= rand.nextInt(6)+1;
                   }     
               }
               else if(TNR == false)
               {
                   dmg = rand.nextInt(eSTATS[2]) + 10;
                   newPSTATS[0] -= dmg;
                   System.out.println("\n\tEvil Boi simply snaps his fingers and a series of explosions hit you!\n\tYou took " + dmg + " damage!");
               }
               break;
           case 1:
               if(TNR == true)
               {
                   System.out.println("\n\n\t\"I will exploit your biggest weaknesses!\"");
                   for(int i = 2; i<newPSTATS.length; i++) //find lowest player stat
                   {
                       if(lPS>newPSTATS[i])
                           lPS = newPSTATS[i];
                   }
                    for(int i = 3; i<eSTATS.length; i++) //find highest enemy stat
                   {
                       if(mES<eSTATS[i])
                           mES = eSTATS[i];
                   }
                    newPSTATS[0] -= ((mES - lPS) * 5);
                    System.out.println("\n\tEvil Boi used the power of his strongest stat against your weakest stat and blasted you\n\twith a powerful beam!"
                            + " You took " + ((mES - lPS) * 5) + " damage!");
               }
               else if(TNR == false)
               {
                   System.out.println("\n\t\"Fear my lazer beams!\"\n\tEvil Boi shoots a massive lazer toward you!\n\tDo you: "
                           + "1. shield from the attack    2. attempt dodging it");
                    while(true)
               {
                   choice = scan.nextLine();
                   if(choice.equals("1"))
                   {
                       dmg = (rand.nextInt(eSTATS[2] + 30)) - newPSTATS[1] - newPSTATS[3];
                       newPSTATS[0] -= dmg;
                       System.out.println("");
                       break;
                   }
                   else if(choice.equals("2"))
                   {
                       if(rand.nextInt(newPSTATS[2])>10)
                        {
                            System.out.println("\n\tYou managed to dodge his lazer attack!");
                        }
                       else
                       {
                           dmg = (rand.nextInt(eSTATS[2] + 30));
                           newPSTATS[0] -= dmg;
                           System.out.println("\n\n\tYou failed to dodge the lazer beam! You took " + dmg + " damage!");
                       }
                       break;
                   }
                   else
                   {
                       System.out.println("\n\tPlease type either 1 or 2");
                   }
               }
               }
               break;
           case 2:
               if(TNR == true)
               {
                  System.out.println("\n\n\t\"Hey bud, pick a number between 1 and 10\"");
                  choice = scan.nextLine();
                  dmg = rand.nextInt(eSTATS[2] * 2);
                  newPSTATS[0] -= dmg;
                  System.out.println("\n\n\t\"LooL I didn't even have a number in mind. Die\"\n\n\tEvil Boi's eyes glow red, then he snaps his fingers."
                          + "\n\tA massive line of explosions blast right into you!\n\n\tYou took " + dmg + " damage!");
               }
               else if(TNR == false)
               {
                   System.out.println("\n\n\t\"Bet your armor isn't as cool as mine\"\n\tEvil Boi proceeds to show off his crocs. As you were mesmerized by the crocs, "
                           + "\n\tHe shoots a lazer beam at you!");
                   dodge = rand.nextInt(2);
                   if(dodge == 0)
                   {
                       System.out.println("\n\n\tYou managed to dodge the attack!");
                   }
                   else if(dodge == 1)
                   {
                       dmg = eSTATS[2];
                       newPSTATS[0] -= dmg;
                       System.out.println("\n\n\tYou didn't see the attack coming! You took " + dmg + " damage!");
                   }
               }
               break;
       }
       return newPSTATS;
   }
         
}
