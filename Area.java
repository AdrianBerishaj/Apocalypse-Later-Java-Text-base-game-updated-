import java.util.Random;
import java.util.Scanner;


public class Area<E> 
{
   Area<E> forelink, backlink;
   int data;
   Scanner scan = new Scanner(System.in);
   Random rand = new Random();
   String input;
   boolean nodeCleared;
   
   public<E> Area(int Encounter_Data, Area initialForeLink, Area initialBackLink)
   {
       forelink = initialForeLink;
       backlink = initialBackLink;
       data = Encounter_Data;
       nodeCleared = false;
   }
   
   public int getData()
   {
       return data;
   }
   
   public void setData(int newData)
   {
       data = newData;
   }
   public Area getForeLink() // command "forward"
   {
       return forelink;
   }
   
   public Area getBackLink() // command "back"
   {
       return backlink;
   }
   
   public void addNode(int data)
   {
       this.forelink = new Area(data, this.forelink, this);
       //System.out.println("Data: " + data);
   }
   
   public void ensureBoss()
   {
      this.addNode(3);
   }
   
   public void ensureExit()
   {
     this.addNode(4);
   }
   
   public static int listLength(Area head) // FOR TESTING PURPOSES
    {
        Area cursor;
        int answer = 0;
        for(cursor = head; cursor!=null; cursor = cursor.getForeLink())
            answer++;
        //System.out.println(answer);      //LENGTH OF AREA
        return answer;
    }
   
   public int area_1_Encounter(int type, int pRep, String pName)
   {
       int value = 0;
       switch (type)
       {
           case 0: //value remains 0
               System.out.println("\n\tNothing happens, but you dont feel relieved.");    
               break;
           case 1: //value can be 0-50
               System.out.println("\n\tSoldiers seem to be blocking most the river.  They dont look intimidating");
               if(rand.nextInt(pRep) > 0)
               {
                   System.out.println("\tluckily, the soldiers didnt find anything suspicious with you so they let you pass");
               }
               else
               {
                   value = rand.nextInt(20) + 10;
                   System.out.println("\tThe soldiers start unloading on your boat, i guess the word got around.  You take" + value + " damage!");
               }
               break;
           case 2: //value can be either 1111 or 1112: 1111 - add item "Bandit Dagger" in Main, 1112 - initiate battle in Main
               System.out.println("\n\tYou see a man lying in shade."
                       + "\n\tHe notices you.\n\n\t\"Wait a minute... you look familiar... State your name!\""
                       + "\n\n\tWhat do you tell him?");
               String choice = scan.nextLine();
               if(choice.equals(pName))
               {
                   int encounter = rand.nextInt(2);
                   if(encounter == 0)
                   {
                       System.out.println("\n\n\t\"Oh, I know you! you're one of the expedition leaders here to take out Big Boi!"
                               + "\n\tPlease, take this, I wont be of any use on this expedition from here on out, Good luck to you " + pName + "!\""
                                       + "\n\n\tYou've gained Bandit Dagger!");
                       value = 1111;
                   }
                   else if (encounter == 1)
                   {
                       System.out.println("\n\n\t\"I knew it! you're the guy from the bounty! GET OVER HERE!\"");
                       value = 1112;        
                   }
               }
               else if(!choice.equals(pName))
               {
                   System.out.println("\n\n\t\"Eh... I don't know you. Could've sworn you looked like someone I know. Carry on traveller");
               }
               break;
           case 3: //value can be either 0 or 1113: 1113 - add item "DEX_Bost Potion" in main
               System.out.println("\n\n\tYou enter the room and find this very delactable looking bag on the floor that looks like it contains something amazing"
                       + "\n\tWhat do you do? 1. open   2. leave it be   (type 1  or  2)");
               String decision;
       OUTER:
       while (true) {
           decision = scan.nextLine();
           switch (decision) {
               case "1":
                   int random = rand.nextInt(2);
                   if (random == 0) {
                       System.out.println("\n\tWell whataya know... It contained a potion!\n\tYou've gained DEX_Boost Potion!");
                       value = 1113;
                       break OUTER;
                   } else if (random == 1) {
                       value = rand.nextInt(26);
                       System.out.println("\n\n\tUpon opening the bag, a bunch of tiny explosions flood out of the bag like a sparkler!"
                               + "\n\t You take " + value + " Damage!    and hear laughter out in the distance");
                       break OUTER;
                   }
                   break;
               case "2":
                   System.out.println("\n\n\tFine... suit yourself. It was a nice looking bag though");
                   break OUTER;
               default:
                   System.out.println("type either 1 or 2 for your decision");
                   break;
           }
       }
               break;
       }
       return value;
   }
   
   
   
   public int area_2_Encounter(int type, int pInt, String pName)
   {
       int value = 0;
       switch (type)
       {
           case 0://value remains 0
               System.out.println("\n\tyou move on, nothing eventful happens.");
                        break;
           case 1://value can be 0-50
               System.out.println("\n\n\tYou've rustled your ways through trees and such, when all a sudden a massive snake falls right on top of you!");
               
               if(rand.nextInt(pInt) > 7) //////////////////////ERROR////////////////////
               {
                   System.out.println("\tYou were smart enough what to do in this situation, so you were able to get out of it safely");
               }
               else
               {
                   value = rand.nextInt(41) + 10;
                   System.out.println("\tYou were not smart enough what to do in this situation, casuing the snake to bite! You have taken " + value + " damage!");
               }        
               break;
               
           case 2://value can be 2221 or 2222: 2221 - sub 3 from all stats,  2222 - add 3 to all stats
               System.out.println("\n\n\tYou find yourself in an open area, with a forest spirit of some sort floating above a small lake. She motions you to confront her"
                       + "\n\t\"Traveler lost in the woods... how did you even end up in these woods... Who are you? And why are you here? (she wants to know your name)");
               String name = scan.nextLine();
               if(name.equals(pName))
               {
                   System.out.println("\n\n\tThe spirit suddenly glows red and becomes visably angry\n\tYOU! YOU ARE THE ONE WHO HAS DAMAGED THIS ONCE PEACEFUL LAND!"
                           + "\n\tYOU ARE THE ONE WHO IS RESPONSIBLE FOR EVERYTHING BAD! I CURSE YOU " + pName + "! I CURSE YOU WITH ETERNAL DEVISTATION!"
                                   + "\n\tThe spirit vanishes into thin air, and all a sudden you are hit with an excruciating, life-sucking force."
                                   + "\n\tYour stats have been drained!");
                   value = 2221;
               }
               else if(!name.equals(pName))
               {
                   System.out.println("\n\n\t\"Poor thing, how could you ever end up in this accursed land... Please, take my blessing. May it give you"
                           + "\n\tthe power to escape this place.\n\tThe spirit vanishes into thin air, and all a sudden you are hit with a powerful, super-energizing force"
                           + "\n\tYour stats have been boosted!");
                   value = 2222;
               }
               break;
           case 3://value can be 2223, 2224, 2225: 2223 - add 5 to INT,  2224 - add 5 to INT + initiate battle in main,  2225 - sub 10 HP and sub 3 STR
               System.out.println("\n\n\tAs you traverse the woods, your eye catches a bush with what looks like edible berries. \n\tYou can't even remember the last time you ate"
                       + "and it's tearing you apart. \n\tWhat do you do?   1. eat the berries     2. leave them be and continue on   (type 1 or 2 for decision)");
               
               String decision;
       OUTER:
       while (true) {
           decision = scan.nextLine();
           switch (decision) {
               case "1":
                   int random = rand.nextInt(2);
                   if(random == 0)
                   {
                       System.out.println("\n\n\tYou say crew it and devour them all. You have satisified your hunger, but not only that, you feel like"
                               + "\n\tyou've gained a surge of knowledge, almost like... a bunch of memories. \n\t Your Intelligence grew!");
                       value = 2223;
                   }
                   else if(random == 1)
                   {
                       System.out.println("\n\n\tYou say screw it and devour them all. You have satisified your hunger, but not only that, you feel like"
                               + "\n\tyou've gained a surge of knowledge, almost like... a bunch of memories. \n\t Your Intelligence grew!"
                               + "\n\n\tHowever, all a sudden, you hear a loud shrieking noise above you. You look and see this gigantic creature, shrieking at you"
                               + "\n\twith an intent to kill you. You question to yourself \"I... prooooobably ate its children\" (you did :/ )");
                       value = 2224;
                   }
                   break OUTER;
               case "2":
                   System.out.println("\n\n\tYou decide it's probably best to not eat unknown berries. Nonetheless though, you are drained by starvation"
                           + "\n\tYour HP and Strength have been drained!");
                   value = 2225;
                   break OUTER;
               default:
                   System.out.println("type either 1 or 2 for your decision");
                   break;
           }
       }
               
               break;
       }
       return value;
   }
   
   
   
   public int area_3_Encounter(int type, int pDex, String pName)
   {
       int value = 0;
       switch (type)
       {
           case 0://value remains 0
               System.out.println("\n\tyou move on, nothing eventful happens.");
                        break;
           case 1://value can be 0-999
               System.out.println("\n\tIn the corridor you enter, A large ball of bones rolls toward you!");
               if(rand.nextInt(pDex) > 1)
               {
                   System.out.println("\tIt was luckily going slow enough for you to step out of it's way ez pz");
               }
               else
               {
                   value = rand.nextInt(1000);
                   System.out.println("\tYou were stunned by the sheer horror and were run over by the ball of bones! You have taken " + value + " damage!"
                           + "\n\t(P.S - that's just... hilariously unlucky");
               }
               break;
           case 2://value can be 0 or 3331: 3331 - set boolean "TrueNameRevealed" to true
               System.out.println("\n\n\tYou enter the next cell, only to find a wizard boi at the end of the room, reading. \n\t\"Ah, it's you. I was "
                       + "wondering if you'd make it this far. The escape you seek though is far from here, but I can help you. This here book is\n\ta database"
                       + "of all people of all kinds. Just tell me your true name, and I can grant you power to help you on your journey\" (enter a name) ");
               String name = scan.nextLine();
               if(name.equals(pName))
               {
                   System.out.println("\n\n\t\"Heh heh heh...ooohhh, You complete idiot\"\n\tThe wizrd smirks, shuts book in his hand, then vanishes into thin air"
                           + "\n\n\t\".....Probably wasn't a good idea I guess\"\n");
                   value = 3331;
               }
               if(!name.equals(pName))
               {
                   System.out.println("\n\n\tThe wizard looks angry, then violently shuts his book.\n\t\"Curses... You're lying\"\n\tThe wizard then vanishes into thin air!"
                           + "\n\n\t.....well that was weird");
               }
               break;
           case 3://value can be 0 or 3332: 3332 - initate battle in Main
               System.out.println("\n\n\tYou encounter a wicked looking alter with a little portal like object in it's center. \n\tYou sense terrible evil coming from "
                       + "/n/tthe portal, and can faintly hear screaming coming from it. \n\tWhat will you do? 1. LooL go inside   2. that ain't happening (type 1 or 2)");
               String decision;
       OUTER:
       while (true) {
           decision = scan.nextLine();
           switch (decision) {
               case "1":
                   System.out.println("\n\n\tFor some profound reason, you're like \"yeet\" then swan dived right into the portal."
                           + "\n\tyou fall a decent height, land, then end up in this... void of some sort. Everything is black, all around. Then all a sudden, a great flash"
                           + "\n\tappears off in the distance, and a unholy shriek is heard followed by loud stomping heading your way!\n\n\t\"well... imma die\"\n\n");
                   value = 3332;
                   break OUTER;
               case "2":
                   System.out.println("You, a sane person ,decide you shouldn't yeet right on into a hellish portal, and move on");
                   break OUTER;
               default:
                   System.out.println("type either 1 or 2 for your decision");
                   break;
           }
       }
               break;
       }
       return value;
   }
   
   
   
   public int area_4_Encounter(int type, int pSTR, int pDEX, int pCON)
   {
       int value = 0;
       switch (type)
       {
           case 0://value can be 0-75
               int bolt = rand.nextInt(51) + 25;
               int evade = rand.nextInt(pDEX);
               System.out.println("\n\n\tThe rediculous figure's eyes glow red off in the distance. Suddenly, a massive bolt comes your way!"
                       + "\n\n\tDo you:   1. Shield yourself from the bolt(take some damage)     2. take a huge risk and try evading it(take all or no damage)"
                       + "\n\t(type 1 or 2 for decision)");
               String decision;
       OUTER:
       while (true) {
           decision = scan.nextLine();
           switch (decision) {
               case "1":
                   value = bolt - pSTR - pCON;
                   System.out.println("\n\tYou shield yourself from the bolt, but take " + value + " damage!");
                   break OUTER;
               case "2":
                   if(evade > 10)
                   {
                       System.out.println("\n\n\tYou've managed to dodge the bolt! nice");
                   }
                   else if(evade<10)
                   {
                       System.out.println("\n\n\tYou failed to dodge the bolt and took all of it's power! \nYou took " + bolt + " damage!");
                       value = bolt;
                   }
                   break OUTER;
               default:
                   System.out.println("please type either 1 or 2");
                   break;
           }
       }
               
                        break;
           case 1://value can be 0 or 999999999 LooL
               System.out.println("\n\n\tThe floating floor beneath you crumbles and is about to shatter!");
               if(rand.nextInt(pDEX) > 1)
               {
                   System.out.println("\tYou managed to hop to the next platform before you fell into the endless rift, ez pz");
               }
               else
               {
                   value = 999999999;
                   System.out.println("\tYou were in shock and couldn't hop to the next platform in time and fell into the rift! \n\tYou took " + value + " damage!"
                           + "\n\t(P.S - that's just... hilariously unlucky");
               }
               break;
       }
       return value;
   }
}