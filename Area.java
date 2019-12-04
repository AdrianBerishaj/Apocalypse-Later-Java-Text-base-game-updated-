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
               if(pRep > 0)
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
               if(choice.equalsIgnoreCase(pName))
               {
                   int encounter = rand.nextInt(2);
                   if(encounter == 0)
                   {
                       System.out.println("\n\n\t\"Oh, the name sounds familiar.  Arent you the guy who took out that awful tyrant a couple years back?"
                               + "\n\tPlease, take this, I wont be of any use on this expedition from here on out, Good luck to you " + pName + "!\""
                                       + "\n\n\tYou've gained a Katana!");
                       value = 1111;
                   }
                   else if (encounter == 1)
                   {
                       System.out.println("\n\n\t\"I knew it, you're after Lord Kurtz!! \"");
                       value = 1112;        
                   }
               }
               else if(!choice.equalsIgnoreCase(pName))
               {
                   System.out.println("\n\n\t\"Eh... I don't know you. Could've sworn you looked like someone I know. Carry on traveller");
               }
               break;
           case 3: //value can be either 0 or 1113: 1113 - add item "DEX_Bost Potion" in main
               System.out.println("\n\n\tYou enter the room and find this very delectable looking bag on the floor that looks like it contains something amazing"
                       + "\n\tWhat do you do? 1. open   2. leave it be   (type 1  or  2)");
               String decision;
       OUTER:
       while (true) {
           decision = scan.nextLine();
           switch (decision) {
               case "1":
                   int random = rand.nextInt(2);
                   if (random == 0) {
                       System.out.println("\n\tWell whataya know... It contained a potion!\n\tYou've gained HP Potion!");
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
   
   
   
   public int area_2_Encounter(int type, int pRep, String pName)
   {
       int value = 0;
       switch (type)
       {
           case 0://value remains 0
               System.out.println("\n\tyou move on, nothing eventful happens.");
                        break;
           case 1://value can be 0-50
               System.out.println("\n\n\tYou've rustled your ways through trees and such, when all a sudden a massive snake falls right on top of you!");
               
               if(rand.nextInt(16) > 7) //////////////////////ERROR////////////////////
               {
                   System.out.println("\tYou got lucky, the snakes couldnt keep up with you're superior human brain");
               }
               else
               {
                   value = rand.nextInt(41) + 10;
                   System.out.println("\tThe snakes have outsmarted you, they bite! You have taken " + value + " damage!");
               }        
               break;
               
           case 2://value can be 2221 or 2222: 2221 - sub 3 from all stats,  2222 - add 3 to all stats
               System.out.println("\n\n\tA spirit orb rises from the forest ground.  It looks so pure, as if it is beckoning you to come foward"
                       + "\n\t\"Traveler, all I know is names and the purity of them.  Please.....Tell me.... What is your name? (You are allowed to lie)");
               String name = scan.nextLine();
               if(name.equalsIgnoreCase(pName))
               {
                   System.out.println("\n\n\tThe spirit suddenly glows red and becomes visably angry\n\tYOU! YOU ARE NO HUMAN OF PURITY, THE HEART OF DARKNESS WILL CONSUME YOU!"
                           + "\n\tYOU ARE THE DOWNFALL OF HUMAN MORALS! I CURSE YOU " + pName + "! YOU WILL NEVER OBTAIN THE TRUE HEART OF DARKNESS NOR THE POWER THAT COMES WITH IT!"
                                   + "\n\tThe spirit vanishes into thin air, and all a sudden you are hit with an excruciating, life-sucking force."
                                   + "\n\tYour stats have been drained!"
                                   +"\n\tYou think to yourself,  the heart of darkness, what does that even mean??");
                   value = 2221;
               }
               else if(!name.equalsIgnoreCase(pName))
               {
                   System.out.println("\n\n\t\"Poor thing, one with a name of such purity should never have travelled to this forest"
                           + "\n\tToo many have been lost to this dark forest, but i will not allow it to happen again.\n\tThe spirit vanishes into thin air, and all a sudden you are hit with a powerful, super-energizing force"
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
                               + "\n\tyou've gained a surge of knowledge, almost like... a bunch of memories. \n\t Your Stats grew!"
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
   
   
   public int area_3_Encounter(int type, int pRep, String pName)
   {
       int value = 0;
       switch (type)
       {
           case 0://value can be 0-75
               int bolt = rand.nextInt(51) + 25;
               int evade = rand.nextInt(25);
               System.out.println("\n\n\tThe rediculous figure's eyes glow red off in the distance. Suddenly, a massive bolt comes your way!"
                       + "\n\n\tDo you:   1. Shield yourself from the bolt(take some damage)     2. take a huge risk and try evading it(take all or no damage)"
                       + "\n\t(type 1 or 2 for decision)");
               String decision;
       OUTER:
       while (true) {
           decision = scan.nextLine();
           switch (decision) {
               case "1":
                   value = bolt - 20;
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
               System.out.println("\n\n\tIt seems as though a sheer force of darkness is causing the floor to give out!");
               if(rand.nextInt(15) > 1)
               {
                   System.out.println("\tIt seems that the darkness stopped, you ask yourself.....Why? Is the Darkness accepting you? ");
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
