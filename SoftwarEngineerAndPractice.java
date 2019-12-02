import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Connor
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
               Enemy a1_enemy = new Enemy(1, 10, 3, 1);
               
        
        while(running){
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
                                    System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                                    System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                                     OUTER:
                                     while (true) {
                                          System.out.println("\nWhat will you do " + player.name + "?");
                                        input = scan.nextLine();
                                        OUTER_1:
                                        switch (input) {
                                            case "attack":
                                            case "a":
               
                                                    int dmgDealt = rand.nextInt(player.stats[1]);
                                                    int EdmgDealt = rand.nextInt(rogue.enemyStats[2]);
                                                    System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                    rogue.enemyStats[1] -= dmgDealt;
                                                    if (rogue.enemyStats[1]<0) {
                                                        System.out.println("ENEMY DEFEATED!!!");
                                                        System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                        System.out.println("\n\n\tUpon killing the bounty hunter, you've looted his Bandit Dagger!");
                                                        Items Katana = new Items("Katana", 1, 0, 10, 0, 0, 0); //gives +2 str, +5 dex
                                                        player.inventory = Katana.ADDinventory(player.inventory);
                                                        player.stats[0] = 100;
                                                       //Skill recharge
                                                        int gain = rand.nextInt(15) + 15;
                                                        player.gainExp(gain);
                                                        break OUTER;
                                                    }
                                                    System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                    player.stats[0] -= EdmgDealt;
                                                    if (player.stats[0]<0) {
                                                        System.out.println("YOU DIED");
                                                        System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                        area1_cleared = true;
                                                        area2_cleared = true;
                                                        area3_cleared = true;
                                                        area4_cleared = true;
                                                        running = false;
                                                        break OUTER;
                                                    }
                                                

                                                break; 
                                               
                                              
                                                
                                            case "identify":
                                            case "i":
                                            System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                                    rogue.showEnemyStats();
                                                    break;
                                            
                                              case "item stats":
                                                case "is":
                                                    System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                                    try {
                                                        int temp = Integer.parseInt(scan.nextLine());
                                                        switch (temp) {
                                                            case 1:
                                                                System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                                System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                                try {
                                                                    int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                                    if(player.inventory[tempa] != null){
                                                                        System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                                        player.inventory[tempa].getStats();
                                                                    }
                                                                    else{
                                                                        System.out.println("You do not have an item in that slot. Please try again.");
                                                                    }
                                                                } catch (NumberFormatException e) {
                                                                    System.out.println("Please try again and enter a number.");
                                                                    break OUTER_1;
                                                                }
                                                                break OUTER_1;
                                                            case 2:
                                                                System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                                System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                                try {
                                                                    int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                                    if(player.equipment[tempa] != null){
                                                                        System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                                        player.equipment[tempa].getStats();
                                                                    }
                                                                    else{
                                                                        System.out.println("You do not have an item in that slot. Please try again.");
                                                                    }
                                                                } catch (NumberFormatException e) {
                                                                    System.out.println("Please try again and enter a number.");
                                                                    break OUTER_1;
                                                                }
                                                                break OUTER_1;
                                                            default:
                                                                System.out.println("Please try again and enter a valid answer.");
                                                                break;
                                                        }
                                                    }catch(NumberFormatException e){
                                                        System.out.println("Please try again and enter a number.");
                                                        break;
                                                    }
                                                    break;
                                                case "stats":
                                                case "s":
                                                    player.showStats();
                                                    break;
                                                case "combat help":
                                                    player.combatHelp();
                                                    break;
                                                default:
                                                    System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                                    break;
                                                    
                                                     case "bag":
                                                case "b":
                                                    System.out.println(Arrays.toString(player.inventory));
                                                    break;
                                                case "use":
                                                case "u":
                                                     System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                                                     System.out.println("\t" + Arrays.toString(player.inventory));
                                                     try{
                                                         int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                         if(tempa < player.inventory.length){
                                                            if(player.inventory[tempa] != null){
                                                                if(player.inventory[tempa].typeCheckConsumable()){
                                                                    System.out.println("You use " + player.inventory[tempa].name + ".");
                                                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                                                    player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                                                }
                                                                else
                                                                    System.out.println("That is not a usable item.");
                                                            }
                                                            else
                                                             System.out.println("You do not have an item in that slot.");
                                                         }
                                                         else
                                                             System.out.println("You do not have an item in that slot.");
                                                     }
                                                     catch(NumberFormatException e){
                                                         System.out.println("Please enter a number.");
                                                         break;
                                                     }
                                                         int EdmgDealt = rand.nextInt(rogue.enemyStats[2]);
                                                         //Why is this an error
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[0] -= EdmgDealt;
                                                            if (player.stats[0]<0) 
                                                            {
                                                                System.out.println("YOU DIED");
                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                area1_cleared = true;
                                                                area2_cleared = true;
                                                                area3_cleared = true;
                                                                area4_cleared = true;
                                                                running = false;
                                                                break OUTER; 
                                                            }
                                                    break;
                                                    //////ADD SKILL USE HERE
                                                    
                                                    
                                                           
                                        }
                                    }//NORMAL COMBAT END
                                }
                                else if(area1_encounter == 1113)
                                {
                                    Items mediumHpPot = new Items("Health Potion", 4, 25, 0, 0, 0, 0);
                                    player.inventory = mediumHpPot.ADDinventory(player.inventory);
                                }
                                break;
                                
                                 case 1:
                                a1_enemy.getEnemy();
                                System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                                System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                                OUTER:
                                while (true) {
                                    
                                     System.out.println("\nWhat will you do " + player.name + "?");
                                    input = scan.nextLine();
                                    OUTER_2:
                                    switch (input) {
                                        
                                         case "attack":
                                        case "a":
                                            
                                         int dmgDealt = rand.nextInt(player.stats[1]);
                                                int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                a1_enemy.enemyStats[1] -= dmgDealt;
                                                if (a1_enemy.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                    
                                                    player.stats[0] = 100;
                                                  //  player.skill.recharge();
                                                    int gain = rand.nextInt(15) + 15;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                                System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                player.stats[0] -= EdmgDealt;
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                         
                                        case "equipment":
                                        case"se":
                                            System.out.println(Arrays.toString(player.equipment));
                                            break;
                                        case "bag":
                                        case "b":
                                            System.out.println(Arrays.toString(player.inventory));
                                            break;    
                                                    
                                                    /////ADD SKILL USE and INFO
                                            
                                            //Add Item USE 
                                            
                                        }
                                     }//combat end
                                 case 2:
                                System.out.println("You found a chest! It contained: " + area1_chest.open());
                                OUTER:
                                while (true) {
                                    System.out.println("\n\tWould you like to keep the item?");
                                    System.out.println("\t\t 1. Yes");
                                    System.out.println("\t\t 2. No");
                                    input = scan.nextLine();
                                    switch (input) {
                                        case "1":
                                            System.out.println("You yank the item from the chest!\nYou gained: " + area1_chest.open());
                                            player.inventory = area1_chest.open().ADDinventory(player.inventory);
                                            System.out.println(Arrays.toString(player.inventory));
                                            area1_chest.newItem();
                                            break OUTER;
                                        case "2":
                                            System.out.println("You decided to leave the item behind.");
                                            area1_chest.newItem();
                                            break OUTER;
                                        default:
                                            System.out.println("Please enter a valid option.");
                                            break;
                                    }
                                } //CHEST END
                                break;
                              case 3:  
                                Enemy bigBoi = new Enemy(5, 50, 15, 10);
                                 System.out.println("\n\n----------------------------I T ' S   B O S S   T I M E   B O i S----------------------------");
                                System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                                OUTER:
                                while (true) {
                                 System.out.println("\nWhat will you do " + player.name + "?");
                                    input = scan.nextLine();
                                    OUTER_3:
                                    switch (input) {
                                       
                                        case "attack":
                                        case "a":
                                            
                                            int dmgDealt = rand.nextInt(player.stats[1]);
                                                int EdmgDealt;
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.stats[0] = MAX_HEALTH;  //WE NEED HEALTH RECHARGE AND SKILL RECHARGE
                                                    player.skill.recharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                                
                                                //NO BOSS SKILLS
                                                EdmgDealt = bigBoi.bossOneSkills(rand.nextInt(2),player.stats[2] , player.stats[1], player.stats[3], bigBoi.enemyStats[2]);
                                                player.stats[0] -= EdmgDealt;
                                                if (player.stats[0]<0) {
                                                    System.out.println("YOU DIED");
                                                    System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                    area1_cleared = true;
                                                    area2_cleared = true;
                                                    area3_cleared = true;
                                                    area4_cleared = true;
                                                    running = false;
                                                    break OUTER;
                                                }
                                                break;
                                                
                                             case "identify":
                                             case "i":
                                             System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                                bigBoi.showEnemyStats();
                                                break;
                                                
                                            case "equipment":
                                             case"se":
                                            System.out.println(Arrays.toString(player.equipment));
                                            break;
                                            
                                            case "bag":
                                             case "b":
                                            System.out.println(Arrays.toString(player.inventory));
                                            break;    
                                           
                                             case "item stats":
                                        case "is":
                                            System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                                            try {
                                                int temp = Integer.parseInt(scan.nextLine());
                                                switch (temp) {
                                                    case 1:
                                                        System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                        System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                                        try {
                                                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                            if(player.inventory[tempa] != null){
                                                                System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                                                player.inventory[tempa].getStats();
                                                            }
                                                            else{
                                                                System.out.println("You do not have an item in that slot. Please try again.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Please try again and enter a number.");
                                                            break OUTER_3;
                                                        }
                                                        break OUTER_3;
                                                    case 2:
                                                        System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                                        System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                                        try {
                                                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                                            if(player.equipment[tempa] != null){
                                                                System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                                                player.equipment[tempa].getStats();
                                                            }
                                                            else{
                                                                System.out.println("You do not have an item in that slot. Please try again.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Please try again and enter a number.");
                                                            break OUTER_3;
                                                        }
                                                        break OUTER_3;
                                                    default:
                                                        System.out.println("Please try again and enter a valid answer.");
                                                        break;
                                                }
                                            }catch(NumberFormatException e){
                                                System.out.println("Please try again and enter a number.");
                                                break;
                                            }
                                            break;
                                        case "stats":
                                        case "s":
                                            player.showStats();
                                            break;
                                        case "combat help":
                                            player.combatHelp();
                                            break;
                                        case "help":
                                            player.help();
                                            break;
                                        default:
                                            System.out.println("enter a valid command (use \"combat help\" for a list of basic combat commands");
                                            break;
                                    }
                                } // BOSS FIGHT END
                                break;
                                
                                  case 4:
                                System.out.println("You have found the exit to the area! But alas... you only get deeper into this hell hole instead of having freedom");
                                area1_cleared = true;
                                break;
                            default:
                                break;
                        } // AREA GET DATA END
                        break;
                    case "equipment":
                    case"se":
                        System.out.println(Arrays.toString(player.equipment));
                        break;
                    case "bag":
                    case "b":
                        System.out.println(Arrays.toString(player.inventory));
                        break;
                    case "drop":
                    case "d":
                     System.out.println("From where would you like to drop something?\n\t1. Bag\n\t2. Equipment");
                     try {
                         int temp = Integer.parseInt(scan.nextLine());
                         switch (temp) {
                             case 1:
                                 System.out.println("Which item did you want to drop from your bag? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\t" + Arrays.toString(player.inventory));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.inventory.length){
                                        if (player.inventory[tempa] != null) {
                                            System.out.println("You dropped your " + player.inventory[tempa].name + ".");
                                            player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                            break OUTER_4;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_4;
                                 }
                                 break OUTER_4;
                             case 2:
                                 System.out.println("Which item did you want to drop from your equipment? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\t" + Arrays.toString(player.equipment));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.equipment.length){
                                        if (player.equipment[tempa] != null) {
                                            System.out.println("You dropped your " + player.equipment[tempa].name + ".");
                                            player.stats = player.equipment[tempa].SUBstats(player.stats);
                                            player.equipment = player.equipment[tempa].dropEquipment(player.equipment);
                                            break OUTER_4;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_4;
                                 }
                                 break;
                             default:
                                 System.out.println("Please try again and enter a valid answer.");
                                 break;
                         }
                     }catch(NumberFormatException e){
                         System.out.println("Please try again and enter a number.");
                         break;
                     }
                     break;
                 case "equip":
                 case "e":
                    if(!dummy.isFull(player.equipment)){
                        System.out.println("What item did you want to equip from your bag? Type 1 for first item, 2 for second, and so on.");
                        System.out.println("\t" + Arrays.toString(player.inventory));
                        try{
                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                            if(tempa < player.inventory.length){
                                if(player.inventory[tempa] != null){
                                    System.out.println("You equipped your " + player.inventory[tempa].name + ".");
                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                    Items[][] temp = player.inventory[tempa].equip(player.inventory, player.equipment);
                                    player.inventory = temp[0];
                                    player.equipment = temp[1];
                                    break;
                                }
                                else
                                    System.out.println("You do not have an item in that slot.");
                            }
                            else
                                System.out.println("You do not have an equipped item in that slot.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("Please enter a number.");
                            break;
                        }
                        break;
                    }
                    else
                        System.out.println("Your equipment is full! You can't equip an item.");
                    break;
                case "unequip":
                case "ue":
                    if(!dummy.isFull(player.inventory)){
                        System.out.println("What item did you want to unequip from your equipment? Type 1 for first item, 2 for second, and so on.");
                        System.out.println("\t" + Arrays.toString(player.equipment));
                        try{
                            int tempa = Integer.parseInt(scan.nextLine()) - 1;
                            if(tempa < player.equipment.length){
                                if(player.equipment[tempa] != null){
                                    System.out.println("You unequipped your " + player.equipment[tempa].name + ".");
                                    player.stats = player.equipment[tempa].SUBstats(player.stats);
                                    Items[][] temp = player.equipment[tempa].unequip(player.inventory, player.equipment);
                                    player.inventory = temp[0];
                                    player.equipment = temp[1];
                                    break;
                                }
                                else
                                    System.out.println("You do not have an item in that slot.");
                            }
                            else
                                System.out.println("You do not have an equipped item in that slot.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("Please enter a number.");
                            break;
                        }
                        break;
                    }
                  else
                    System.out.println("Your bag is full! You can't unequip an item.");
                  break;
                 case "use":
                 case "u":
                     System.out.println("What item did you want to use from your bag? Type 1 for first item, 2 for second, and so on.");
                     System.out.println("\t" + Arrays.toString(player.inventory));
                     try{
                         int tempa = Integer.parseInt(scan.nextLine()) - 1;
                         if(tempa < player.inventory.length){
                            if(player.inventory[tempa] != null){
                                if(player.inventory[tempa].typeCheckConsumable()){
                                    System.out.println("You use " + player.inventory[tempa].name + ".");
                                    player.stats = player.inventory[tempa].ADDstats(player.stats);
                                    player.inventory = player.inventory[tempa].dropInventory(player.inventory);
                                }
                                else
                                    System.out.println("That is not a usable item.");
                            }
                            else
                             System.out.println("You do not have an item in that slot.");
                         }
                         else
                             System.out.println("You do not have an item in that slot.");
                     }
                     catch(NumberFormatException e){
                         System.out.println("Please enter a number.");
                         break;
                     }
                     break;
                 case "item stats":
                 case "is":
                     System.out.println("Where is this item located?\n\t1. Bag\n\t2. Equipment");
                     try {
                         int temp = Integer.parseInt(scan.nextLine());
                         switch (temp) {
                             case 1:
                                 System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\tBag: " + Arrays.toString(player.inventory));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.inventory.length){
                                        if(player.inventory[tempa] != null){
                                            System.out.println(player.inventory[tempa].name + " alters your stats in this way:");
                                            player.inventory[tempa].getStats();
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else{
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_5;
                                 }
                                 break OUTER_5;
                             case 2:
                                 System.out.println("What item do you want to know the stats for? Type 1 for first item, 2 for second, and so on.");
                                 System.out.println("\tEquipment: " + Arrays.toString(player.equipment));
                                 try {
                                     int tempa = Integer.parseInt(scan.nextLine()) - 1;
                                     if(tempa < player.equipment.length){
                                        if(player.equipment[tempa] != null){
                                            System.out.println(player.equipment[tempa].name + " alters your stats in this way:");
                                            player.equipment[tempa].getStats();
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else{
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_5;
                                 }
                                 break OUTER_5;
                             default:
                                 System.out.println("Please try again and enter a valid answer.");
                                 break;
                         }
                     }catch(NumberFormatException e){
                         System.out.println("Please try again and enter a number.");
                         break;
                     }
                     break;
                    case "stats":
                    case "s":
                        player.showStats();
                        break;
                    case "skill info":
                    case "si":
                //        System.out.println("\t"+player.skill.getSkillInfo());
                        break;
                    default:
                        System.out.println("enter a valid command (use \"help\" for a list of basic commands)");
                        break;
                }
            } //WHILE AREA_1 CLEARED END
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
          /////////////////////////////AREA 2 CREATION///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               int area2_L;
               Area area2 = new Area(0, null, null);
               area2_L = rand.nextInt(3) + 5;
               //System.out.println(area2_L);
               area2.ensureExit();
               area2.ensureBoss();               
                                        
                                    }   
                                }
                                }
                                
                        }
                       
                }
                   
                }
            }
        }
    
