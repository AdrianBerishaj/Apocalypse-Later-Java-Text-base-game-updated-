/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class SoftwarEngineerAndPractice {
    public static void main(String[] args) {
        boolean running = true;
        Items chainmail = new Items("Chainmail", 3, 0, 0, 0, 0, 17);
        Items dummy = new Items("Dummy Item for Method Calling", 1, 0, 0, 0, 0, 0);
        Character player = new Character();
        String input;
         Scanner scan = new Scanner(System.in);
         Random rand = new Random();
        player.showStats();
        player.showEquip();
        player.equipment = chainmail.ADDequipment(player.equipment);
        player.stats = chainmail.ADDstats(player.stats);
        player.changeRep(-5);
        player.showStats();
        player.showEquip();
        player.gainExp(100);
        player.gainExp(100);
        player.showStats();     
    
        
   Area area1 = new Area(0, null, null);
               int area1_L = rand.nextInt(3) + 5;
               //System.out.println(area1_L);
               area1.ensureExit();
               area1.ensureBoss();
               for(int i = 0; i<area1_L-1; i++)
               {
                   area1.addNode(rand.nextInt(3));
                   //area1.addNode(0);
               }
               //Area.listLength(area1);
               Area area1_pp = area1;
               Chest area1_chest = new Chest();      
        
        
        
    while(running)
    {
        boolean area1_cleared = false;
          boolean area2_cleared = false;
          boolean area3_cleared = false;
          boolean area4_cleared = false;
           System.out.println("\n\t\tAt any time, type \"help\" for a list of basic commands");
           System.out.println("\n\n\t\tYou've arrived at the mouth of the river.  You dont have much time, the mission has just started. You must move foward and find Kurtz."
                      + "\n\t\tAfter all, the mission is the only thing you live for");

           while (area1_cleared == false) {
                System.out.println("\n\t\tWhat would you like to do?");
                input = scan.nextLine();
              OUTER_4:
                OUTER_5:
                switch (input) {
                    case "help":
                        player.help();
                        break;
                    case "forward":
                    case "f":
                        area1_pp = area1_pp.getForeLink();
                        //System.out.println(area1_pp.getData());
                        switch (area1_pp.getData()) {
                            case 0:
                                int area1_encounter;
                                area1_encounter = area1.area_1_Encounter(rand.nextInt(4), player.stats[4], player.name);
                                if(area1_encounter<1000)
                                    player.stats[0] = player.stats[0] - area1_encounter;
                                else if(area1_encounter == 1111)
                                {
                                    Items katana = new Items("Katana", 1, 0, 10, 0, 0, 0);
                                     player.inventory = katana.ADDinventory(player.inventory);
                                }
                                else if(area1_encounter == 1112)
                                {
                                   Enemy rogue = new Enemy(1, 60, 15, 2) ;
                                   
                                }
    }
}
}
    
  