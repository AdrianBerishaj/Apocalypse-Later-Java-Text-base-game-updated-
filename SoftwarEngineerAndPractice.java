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
        Items dummy = new Items("Dummy Item for Method Calling", 1, 0, 0, 0, 0, 0);
        Character player = new Character();
        String input;
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        player.showStats();
        player.showEquip();
        player.getName();
        player.getStarterEquip();
        player.showStats();
        player.showEquip();
        player.changeRep(0);
        player.gainExp(100);
        player.gainExp(100);
        player.showStats();
        player.gainExp(100);
        
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
                                    player.stats[1] = player.stats[1] - area1_encounter;
                                else if(area1_encounter == 1111)
                                {
                                    Items katana = new Items("Katana", 1, 0, 10, 0, 0, 0);
                                     player.inventory = katana.ADDinventory(player.inventory);
                                }
                                else if(area1_encounter == 1112)
                                {
                                   Enemy rogue = new Enemy(1, 60, 15, 2) ;
                                   int skillCarry = 0;
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
               
                                                    int dmgDealt = rand.nextInt(player.stats[2]);
                                                    int EdmgDealt = rand.nextInt(rogue.enemyStats[2]);
                                                    System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                    rogue.enemyStats[1] -= dmgDealt;
                                                    if (rogue.enemyStats[1]<0) {
                                                        System.out.println("ENEMY DEFEATED!!!");
                                                        System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                        System.out.println("\n\n\tUpon killing the rogue, you've looted his Katana!");
                                                        Items Katana = new Items("Katana", 1, 0, 10, 0, 0, 0); //gives +2 str, +5 dex
                                                        player.inventory = Katana.ADDinventory(player.inventory);
                                                        player.healthRegen();
                                                        player.allSkillRecharge();
                                                        int gain = rand.nextInt(15) + 15;
                                                        player.gainExp(gain);
                                                        break OUTER;
                                                    }
                                                    if(skillCarry == 0){
                                                        System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                        player.stats[1] -= EdmgDealt;
                                                        if (player.stats[1]<=0) {
                                                            System.out.println("YOU DIED");
                                                            System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                            area1_cleared = true;
                                                            area2_cleared = true;
                                                            area3_cleared = true;
                                                            area4_cleared = true;
                                                            running = false;
                                                            break OUTER;
                                                        }
                                                    }
                                                    else
                                                        skillCarry = 0;
                                                

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
                                                        if(skillCarry == 0){
                                                            EdmgDealt = rand.nextInt(rogue.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[1] -= EdmgDealt;
                                                            if (player.stats[1]<=0) 
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
                                                        }
                                                        else
                                                            skillCarry = 0;    
                                                    break;
                                                case "skill info":
                                                case "si":
                                                    System.out.print("\tPlease enter the name of the skill that you want information about: ");
                                                    while(true){
                                                        int temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    System.out.println(skill.getSkillInfo());
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
                                                    break;
                                                case "use skill":
                                                case "us":
                                                    System.out.println("Which skill did you want to use?");
                                                    player.showSkills();
                                                    while(true){
                                                        int temp;
                                                        temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    if(skill.uses == false){
                                                                        System.out.println("You can only use a skill once per battle! Please choose another skill.");
                                                                        break;
                                                                    }
                                                                    int[] array = new int[6];
                                                                    array = skill.use(player.lvl);
                                                                    if(array[0] != 0){
                                                                        System.out.println("The enemy has taken " + array[0] + " damage!");
                                                                        rogue.enemyStats[1] -= array[0];
                                                                        if (rogue.enemyStats[1]<0) {
                                                                            System.out.println("ENEMY DEFEATED!!!");
                                                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                                            System.out.println("\n\n\tUpon killing the bounty hunter, you've looted his Katana!");
                                                                            Items Katana = new Items("Katana", 1, 0, 10, 0, 0, 0); //gives +2 str, +5 dex
                                                                            player.inventory = Katana.ADDinventory(player.inventory);
                                                                            player.healthRegen();
                                                                            player.allSkillRecharge();
                                                                            int gain = rand.nextInt(15) + 15;
                                                                            player.gainExp(gain);
                                                                            break OUTER;
                                                                        }
                                                                    }
                                                                    if(array[1] != 0){
                                                                        System.out.println("You have healed " + array[1] + " health!");
                                                                        player.stats[1] += array[1];
                                                                    }
                                                                    if (array[2] != 0){
                                                                        System.out.println("The enemy's turn has been skipped!");
                                                                    }
                                                                    if (array[3] != 0){
                                                                        System.out.println("You gain " + array[3] + "% damage reduction!");
                                                                    }
                                                                    if (array[4] != 0){
                                                                        System.out.println("You gain " + array[4] + "% extra damage on a regular attack next turn!");
                                                                    }
                                                                    if (array[5] != 0){
                                                                        skillCarry = 2;
                                                                    }
                                                                    if(array[2] == 0 || skillCarry == 0){
                                                                        if(array [3] == 0){
                                                                            EdmgDealt = rand.nextInt(rogue.enemyStats[2]);
                                                                            System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                        else{
                                                                            EdmgDealt = rand.nextInt(rogue.enemyStats[2]);
                                                                            double EdmgredDealt = (double)(EdmgDealt * array[3] / 100);
                                                                            System.out.println("The enemy does " + EdmgredDealt + " damage back at you!");
                                                                            System.out.println("They did " + array[3] + "% reduced damage because of your skill!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (skillCarry != 0)
                                                                        skillCarry--;
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
                                                    break;
                                                    
                                                    
                                                           
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
                                int skillCarry = 0;
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
                                            
                                         int dmgDealt = rand.nextInt(player.stats[2]);
                                                int EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                a1_enemy.enemyStats[1] -= dmgDealt;
                                                if (a1_enemy.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                    
                                                    player.healthRegen();
                                                    player.allSkillRecharge();
                                                    int gain = rand.nextInt(15) + 15;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                                System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                player.stats[1] -= EdmgDealt;
                                                if (player.stats[1]<=0) {
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
                                        case "identify":
                                            case "i":
                                            System.out.println("\n\tyou take time to analyze your enemy\n\t...\n\tyou were able to identify their stats!");
                                                    a1_enemy.showEnemyStats();
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
                                                                    break OUTER_2;
                                                                }
                                                                break OUTER_2;
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
                                                                    break OUTER_2;
                                                                }
                                                                break OUTER_2;
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
                                                        if(skillCarry == 0){
                                                            EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[1] -= EdmgDealt;
                                                            if (player.stats[1]<=0) 
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
                                                        }
                                                        else
                                                            skillCarry = 0;    
                                                    break;
                                                case "skill info":
                                                case "si":
                                                    System.out.print("\tPlease enter the name of the skill that you want information about: ");
                                                    while(true){
                                                        int temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    System.out.println(skill.getSkillInfo());
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
                                                    break;
                                                case "use skill":
                                                case "us":
                                                    System.out.println("Which skill did you want to use?");
                                                    player.showSkills();
                                                    while(true){
                                                        int temp;
                                                        temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    if(skill.uses == false){
                                                                        System.out.println("You can only use a skill once per battle! Please choose another skill.");
                                                                        break;
                                                                    }
                                                                    int[] array = new int[6];
                                                                    array = skill.use(player.lvl);
                                                                    if(array[0] != 0){
                                                                        System.out.println("The enemy has taken " + array[0] + " damage!");
                                                                        a1_enemy.enemyStats[1] -= array[0];
                                                                        if (a1_enemy.enemyStats[1]<0) {
                                                                            System.out.println("ENEMY DEFEATED!!!");
                                                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                                            player.healthRegen();
                                                                            player.allSkillRecharge();
                                                                            int gain = rand.nextInt(15) + 15;
                                                                            player.gainExp(gain);
                                                                            break OUTER;
                                                                        }
                                                                    }
                                                                    if(array[1] != 0){
                                                                        System.out.println("You have healed " + array[1] + " health!");
                                                                        player.stats[1] += array[1];
                                                                    }
                                                                    if (array[2] != 0){
                                                                        System.out.println("The enemy's turn has been skipped!");
                                                                    }
                                                                    if (array[3] != 0){
                                                                        System.out.println("You gain " + array[3] + "% damage reduction!");
                                                                    }
                                                                    if (array[4] != 0){
                                                                        System.out.println("You gain " + array[4] + "% extra damage on a regular attack next turn!");
                                                                    }
                                                                    if (array[5] != 0){
                                                                        skillCarry = 2;
                                                                    }
                                                                    if(array[2] == 0 || skillCarry == 0){
                                                                        if(array [3] == 0){
                                                                            EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                                            System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                        else{
                                                                            EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                                            double EdmgredDealt = (double)(EdmgDealt * array[3] / 100);
                                                                            System.out.println("The enemy does " + EdmgredDealt + " damage back at you!");
                                                                            System.out.println("They did " + array[3] + "% reduced damage because of your skill!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (skillCarry != 0)
                                                                        skillCarry--;
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
                                                    break;            
                                            
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
                                skillCarry = 0;
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
                                            
                                            int dmgDealt = rand.nextInt(player.stats[2]);
                                                int EdmgDealt;
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n--------------------"
                                                            + "--------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.healthRegen();
                                                    player.allSkillRecharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                                
                                                //NO BOSS SKILLS
                                                EdmgDealt = bigBoi.bossOneSkills(rand.nextInt(2), 5 , player.stats[1], 50, 35);
                                                player.stats[1] -= EdmgDealt;
                                                if (player.stats[1]<=0) {
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
                                                        if(skillCarry == 0){
                                                            EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[1] -= EdmgDealt;
                                                            if (player.stats[1]<=0) 
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
                                                        }
                                                        else
                                                            skillCarry = 0;    
                                                    break;
                                                case "skill info":
                                                case "si":
                                                    System.out.print("\tPlease enter the name of the skill that you want information about: ");
                                                    while(true){
                                                        int temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    System.out.println(skill.getSkillInfo());
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
                                                    break;
                                                case "use skill":
                                                case "us":
                                                    System.out.println("Which skill did you want to use?");
                                                    player.showSkills();
                                                    while(true){
                                                        int temp;
                                                        temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    if(skill.uses == false){
                                                                        System.out.println("You can only use a skill once per battle! Please choose another skill.");
                                                                        break;
                                                                    }
                                                                    int[] array = new int[6];
                                                                    array = skill.use(player.lvl);
                                                                    if(array[0] != 0){
                                                                        System.out.println("The enemy has taken " + array[0] + " damage!");
                                                                        a1_enemy.enemyStats[1] -= array[0];
                                                                        if (a1_enemy.enemyStats[1]<0) {
                                                                            System.out.println("ENEMY DEFEATED!!!");
                                                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                                            player.healthRegen();
                                                                            player.allSkillRecharge();
                                                                            int gain = rand.nextInt(15) + 15;
                                                                            player.gainExp(gain);
                                                                            break OUTER;
                                                                        }
                                                                    }
                                                                    if(array[1] != 0){
                                                                        System.out.println("You have healed " + array[1] + " health!");
                                                                        player.stats[1] += array[1];
                                                                    }
                                                                    if (array[2] != 0){
                                                                        System.out.println("The enemy's turn has been skipped!");
                                                                    }
                                                                    if (array[3] != 0){
                                                                        System.out.println("You gain " + array[3] + "% damage reduction!");
                                                                    }
                                                                    if (array[4] != 0){
                                                                        System.out.println("You gain " + array[4] + "% extra damage on a regular attack next turn!");
                                                                    }
                                                                    if (array[5] != 0){
                                                                        skillCarry = 2;
                                                                    }
                                                                    if(array[2] == 0 || skillCarry == 0){
                                                                        if(array [3] == 0){
                                                                            EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                                            System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                        else{
                                                                            EdmgDealt = rand.nextInt(a1_enemy.enemyStats[2]);
                                                                            double EdmgredDealt = (double)(EdmgDealt * array[3] / 100);
                                                                            System.out.println("The enemy does " + EdmgredDealt + " damage back at you!");
                                                                            System.out.println("They did " + array[3] + "% reduced damage because of your skill!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (skillCarry != 0)
                                                                        skillCarry--;
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
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
                    case "skills":
                    case "sk":
                        player.skilltree.printTree();
                        break;
                    case "skill info":
                    case "si":
                        System.out.print("\tPlease enter the name of the skill that you want information about: ");
                        while(true){
                            int temp = 0;
                            String s = scan.nextLine();
                            for (Skills skill : player.skills) {
                                if (skill != null) {
                                    if (s.equalsIgnoreCase(skill.name)) {
                                        System.out.println(skill.getSkillInfo());
                                        temp++;
                                        break;
                                    }
                                }
                            }
                            if(temp != 0)
                                break;
                            else
                                System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                        }
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
               
                for(int i = 0; i<area2_L-1; i++)
               {
                   area2.addNode(rand.nextInt(3));
                   //area2.addNode(0);
               }
               //Area.listLength(area2);
               Area area2_pp = area2;
               Chest area2_chest = new Chest();
               Enemy a2_enemy = new Enemy(4, 80, 25, 15);
            
               if(area2_cleared == false)
          {
              System.out.println("\n\n\tYou some how find yourself in a forest like area. Massive vegatation and gigantic forest creatures are visable everywhere around you."
                     + "\n\tYou decide there really is no going back now, and continue to press on.");
             
          }
          while(area2_cleared == false)
          {
             System.out.println("\n\t\tWhat would you like to do?");
                input = scan.nextLine();
              OUTER_9:
             OUTER_10:
             switch (input) {
                 case "help":
                     player.help();
                     break;
                 case "forward":
                 case "f":
                     area2_pp = area2_pp.getForeLink();
                     //System.out.println(area2_pp.getData());
                     switch (area2_pp.getData()) {
                         case 0:
                             int area2_encounter;
                             area2_encounter = area2.area_2_Encounter(rand.nextInt(4), player.stats[4], player.name); /////////////////ERROR///////////////////////
                             if(area2_encounter<1000)
                                 player.stats[1] = player.stats[1] - area2_encounter;
                             
                                 else if(area2_encounter == 2221)
                             {
                                 for(int i = 1; i<player.stats.length; i++)
                                     player.stats[i] = player.stats[i] - 3;
                                 player.stats[4] -= 5;
                             }
                             else if(area2_encounter == 2222)
                             {
                                 for(int i = 1; i<player.stats.length; i++)
                                     player.stats[i] = player.stats[i] + 3;
                                 player.stats[4] += 5;
                             }
                             else if(area2_encounter == 2223)
                             {
                                 player.stats[4] = player.stats[4] + 5;
                                 
                             }
                             else if(area2_encounter == 2224)
                             {
                                 player.stats[4] = player.stats[4] + 5;
                                 Enemy Giant_Angry_Thing = new Enemy(10, 120, 35, 25);
                                int skillCarry = 0;
                                 System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                                 System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                                 OUTER:
                                 while (true) {
                                    
                                     System.out.println("\nWhat will you do " + player.name + "?");
                                     input = scan.nextLine();
                                     OUTER_6:
                                     switch (input) {
                                    
                                         case "attack":
                                         case "a":
                                         
                                                                                              int dmgDealt = rand.nextInt(player.stats[1]);
                                                 int EdmgDealt = rand.nextInt(Giant_Angry_Thing.enemyStats[2]);
                                                 System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                 Giant_Angry_Thing.enemyStats[2] -= dmgDealt;
                                                 if (Giant_Angry_Thing.enemyStats[2]<0) {
                                                     System.out.println("ENEMY DEFEATED!!!");
                                                     System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                     System.out.println("\n\n\tUpon killing the Giant angry looking thing, you've looted its claw as a weapon!");
                                                     Items Giant_Claw = new Items("Giant Claw",1, 10, 25, 0, 0, 0); //gives +6 str, -2 dex
                                                     player.inventory = Giant_Claw.ADDinventory(player.inventory);
                                                     player.healthRegen();
                                                     player.allSkillRecharge();
                                                     int gain = rand.nextInt(25) + 15;
                                                     player.gainExp(gain);
                                                     break OUTER;
                                                 }
                                                 System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                 player.stats[1] -= EdmgDealt;
                                                 if (player.stats[1]<0) {
                                                     System.out.println("YOU DIED");
                                                     System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
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
                                                Giant_Angry_Thing.showEnemyStats();
                                                break;
                                                
                                            case "equipment":
                                             case"se":
                                            System.out.println(Arrays.toString(player.equipment));
                                            break;
                                            
                                            case "bag":
                                             case "b":
                                            System.out.println(Arrays.toString(player.inventory));
                                            break;    
                                           
                                           case "use skill":
                                                case "us":
                                                    System.out.println("Which skill did you want to use?");
                                                    player.showSkills();
                                                    while(true){
                                                        int temp;
                                                        temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    if(skill.uses == false){
                                                                        System.out.println("You can only use a skill once per battle! Please choose another skill.");
                                                                        break;
                                                                    }
                                                                    int[] array = new int[6];
                                                                    array = skill.use(player.lvl);
                                                                    if(array[0] != 0){
                                                                        System.out.println("The enemy has taken " + array[0] + " damage!");
                                                                        Giant_Angry_Thing.enemyStats[1] -= array[0];
                                                                        if (Giant_Angry_Thing.enemyStats[1]<0) {
                                                                            System.out.println("ENEMY DEFEATED!!!");
                                                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                                            System.out.println("\n\n\tUpon killing the Giant angry looking thing, you've looted its claw as a weapon!");
                                                                            Items Giant_Claw = new Items("Giant Claw",1, 10, 25, 0, 0, 0); //gives +6 str, -2 dex
                                                                            player.inventory = Giant_Claw.ADDinventory(player.inventory);
                                                                            player.healthRegen();
                                                                            player.allSkillRecharge();
                                                                            int gain = rand.nextInt(25) + 15;
                                                                            player.gainExp(gain);
                                                                            break OUTER;
                                                                        }
                                                                    }
                                                                    if(array[1] != 0){
                                                                        System.out.println("You have healed " + array[1] + " health!");
                                                                        player.stats[1] += array[1];
                                                                    }
                                                                    if (array[2] != 0){
                                                                        System.out.println("The enemy's turn has been skipped!");
                                                                    }
                                                                    if (array[3] != 0){
                                                                        System.out.println("You gain " + array[3] + "% damage reduction!");
                                                                    }
                                                                    if (array[4] != 0){
                                                                        System.out.println("You gain " + array[4] + "% extra damage on a regular attack next turn!");
                                                                    }
                                                                    if (array[5] != 0){
                                                                        skillCarry = 2;
                                                                    }
                                                                    if(array[2] == 0 || skillCarry == 0){
                                                                        if(array [3] == 0){
                                                                            EdmgDealt = rand.nextInt(Giant_Angry_Thing.enemyStats[2]);
                                                                            System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                        else{
                                                                            EdmgDealt = rand.nextInt(Giant_Angry_Thing.enemyStats[2]);
                                                                            double EdmgredDealt = (double)(EdmgDealt * array[3] / 100);
                                                                            System.out.println("The enemy does " + EdmgredDealt + " damage back at you!");
                                                                            System.out.println("They did " + array[3] + "% reduced damage because of your skill!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (skillCarry != 0)
                                                                        skillCarry--;
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
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
                                                            break OUTER_6;
                                                        }
                                                        break OUTER_6;
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
                                                            break OUTER_6;
                                                        }
                                                        break OUTER_6;
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
                                     }
                                 }//Giant Bird Thing End
                             }
                             else if(area2_encounter == 2225)
                             {
                                 player.stats[1] = player.stats[1] - 10;
                                 player.stats[1] = player.stats[1] - 3;
                             }
                             break;
                         case 1:
                            a2_enemy.getEnemy2();
                            int skillCarry = 0;
                            System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                             System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                             OUTER:
                             while (true) {
                                 
                                 System.out.println("\nWhat will you do " + player.name + "?");
                                 input = scan.nextLine();
                                 OUTER_7:
                                 switch (input) {
                                  case "attack":
                                  case "a":
                                      
                                      int dmgDealt = rand.nextInt(player.stats[1]);
                                             int EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                             System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                             a2_enemy.enemyStats[1] -= dmgDealt;
                                             if (a2_enemy.enemyStats[1]<0) {
                                                 System.out.println("ENEMY DEFEATED!!!");
                                                 System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n"); 
                                                 player.healthRegen();
                                                 player.allSkillRecharge();
                                                 int gain = rand.nextInt(30) + 20;
                                                 player.gainExp(gain);
                                                 break OUTER;
                                             }
                                             System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                             player.stats[1] -= EdmgDealt;
                                             if (player.stats[1]<0) {
                                                 System.out.println("YOU DIED");
                                                 System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
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
                                             a2_enemy.showEnemyStats();
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
                                                                    break OUTER;//labled issue so i just changed it to OUTER from OUTER_2
                                                                }
                                                                break OUTER;//labled issue so i just changed it to OUTER from OUTER_2
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
                                                                    break OUTER;//labled issue so i just changed it to OUTER from OUTER_2
                                                                }
                                                                break OUTER;//labled issue so i just changed it to OUTER from OUTER_2
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
                                                        if(skillCarry == 0){
                                                            EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[1] -= EdmgDealt;
                                                            if (player.stats[1]<=0) 
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
                                                        }
                                                        else
                                                            skillCarry = 0;    
                                                    break;
                                                case "skill info":
                                                case "si":
                                                    System.out.print("\tPlease enter the name of the skill that you want information about: ");
                                                    while(true){
                                                        int temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    System.out.println(skill.getSkillInfo());
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
                                                    break;
                                                case "use skill":
                                                case "us":
                                                    System.out.println("Which skill did you want to use?");
                                                    player.showSkills();
                                                    while(true){
                                                        int temp;
                                                        temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    if(skill.uses == false){
                                                                        System.out.println("You can only use a skill once per battle! Please choose another skill.");
                                                                        break;
                                                                    }
                                                                    int[] array = new int[6];
                                                                    array = skill.use(player.lvl);
                                                                    if(array[0] != 0){
                                                                        System.out.println("The enemy has taken " + array[0] + " damage!");
                                                                        a2_enemy.enemyStats[1] -= array[0];
                                                                        if (a2_enemy.enemyStats[1]<0) {
                                                                            System.out.println("ENEMY DEFEATED!!!");
                                                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                                            player.healthRegen();
                                                                            player.allSkillRecharge();
                                                                            int gain = rand.nextInt(15) + 15;
                                                                            player.gainExp(gain);
                                                                            break OUTER;
                                                                        }
                                                                    }
                                                                    if(array[1] != 0){
                                                                        System.out.println("You have healed " + array[1] + " health!");
                                                                        player.stats[1] += array[1];
                                                                    }
                                                                    if (array[2] != 0){
                                                                        System.out.println("The enemy's turn has been skipped!");
                                                                    }
                                                                    if (array[3] != 0){
                                                                        System.out.println("You gain " + array[3] + "% damage reduction!");
                                                                    }
                                                                    if (array[4] != 0){
                                                                        System.out.println("You gain " + array[4] + "% extra damage on a regular attack next turn!");
                                                                    }
                                                                    if (array[5] != 0){
                                                                        skillCarry = 2;
                                                                    }
                                                                    if(array[2] == 0 || skillCarry == 0){
                                                                        if(array [3] == 0){
                                                                            EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                                                            System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                        else{
                                                                            EdmgDealt = rand.nextInt(a2_enemy.enemyStats[2]);
                                                                            double EdmgredDealt = (double)(EdmgDealt * array[3] / 100);
                                                                            System.out.println("The enemy does " + EdmgredDealt + " damage back at you!");
                                                                            System.out.println("They did " + array[3] + "% reduced damage because of your skill!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (skillCarry != 0)
                                                                        skillCarry--;
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }                                                
                                                    break;
                                 
                                 case "help":
                                 player.help();
                                 break;
                                 }
                             }
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
                                Enemy bigBoi = new Enemy(10, 200, 50, 20);
                                skillCarry = 0;
                                 System.out.println("\n\n----------------------------I T ' S   B O S S   T I M E   B O i S----------------------------");
                                System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                                System.out.println("Kurtz's Liutenant, Armstrong has appeared");
                                OUTER:
                                while (true) {
                                 System.out.println("\nWhat will you do " + player.name + "?");
                                    input = scan.nextLine();
                                    OUTER_3:
                                    switch (input) {
                                       
                                        case "attack":
                                        case "a":
                                            
                                            int dmgDealt = rand.nextInt(player.stats[2]);
                                                int EdmgDealt;
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n--------------------"
                                                            + "--------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.healthRegen();
                                                    player.allSkillRecharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                                
                                                
                                                EdmgDealt = bigBoi.bossTwoSkills(rand.nextInt(2), 5 , player.stats[1], 100, 35);
                                                player.stats[1] -= EdmgDealt;
                                                if (player.stats[1]<=0) {
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
                                                        if(skillCarry == 0){
                                                            EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[1] -= EdmgDealt;
                                                            if (player.stats[1]<=0) 
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
                                                        }
                                                        else
                                                            skillCarry = 0;    
                                                    break;
                                                case "skill info":
                                                case "si":
                                                    System.out.print("\tPlease enter the name of the skill that you want information about: ");
                                                    while(true){
                                                        int temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    System.out.println(skill.getSkillInfo());
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
                                                    break;
                                                case "use skill":
                                                case "us":
                                                    System.out.println("Which skill did you want to use?");
                                                    player.showSkills();
                                                    while(true){
                                                        int temp;
                                                        temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    if(skill.uses == false){
                                                                        System.out.println("You can only use a skill once per battle! Please choose another skill.");
                                                                        break;
                                                                    }
                                                                    int[] array = new int[6];
                                                                    array = skill.use(player.lvl);
                                                                    if(array[0] != 0){
                                                                        System.out.println("The enemy has taken " + array[0] + " damage!");
                                                                        bigBoi.enemyStats[1] -= array[0];
                                                                        if (bigBoi.enemyStats[1]<0) {
                                                                            System.out.println("ENEMY DEFEATED!!!");
                                                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                                            player.healthRegen();
                                                                            player.allSkillRecharge();
                                                                            int gain = rand.nextInt(15) + 15;
                                                                            player.gainExp(gain);
                                                                            break OUTER;
                                                                        }
                                                                    }
                                                                    if(array[1] != 0){
                                                                        System.out.println("You have healed " + array[1] + " health!");
                                                                        player.stats[1] += array[1];
                                                                    }
                                                                    if (array[2] != 0){
                                                                        System.out.println("The enemy's turn has been skipped!");
                                                                    }
                                                                    if (array[3] != 0){
                                                                        System.out.println("You gain " + array[3] + "% damage reduction!");
                                                                    }
                                                                    if (array[4] != 0){
                                                                        System.out.println("You gain " + array[4] + "% extra damage on a regular attack next turn!");
                                                                    }
                                                                    if (array[5] != 0){
                                                                        skillCarry = 2;
                                                                    }
                                                                    if(array[2] == 0 || skillCarry == 0){
                                                                        if(array [3] == 0){
                                                                            EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                                                            System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                        else{
                                                                            EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                                                            double EdmgredDealt = (double)(EdmgDealt * array[3] / 100);
                                                                            System.out.println("The enemy does " + EdmgredDealt + " damage back at you!");
                                                                            System.out.println("They did " + array[3] + "% reduced damage because of your skill!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (skillCarry != 0)
                                                                        skillCarry--;
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
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
                             area2_cleared = true;
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
                                            break OUTER_9;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_9;
                                 }
                                 break OUTER_9;
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
                                            break OUTER_9;
                                        }
                                        else
                                            System.out.println("You do not have an item in that slot.");
                                     }
                                     else {
                                         System.out.println("You do not have an item in that slot. Please try again.");
                                     }
                                 } catch (NumberFormatException e) {
                                     System.out.println("Please try again and enter a number.");
                                     break OUTER_9;
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
                                     break OUTER_10;
                                 }
                                 break OUTER_10;
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
                                     break OUTER_10;
                                 }
                                 break OUTER_10;
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
                                                    System.out.print("\tPlease enter the name of the skill that you want information about: ");
                                                    while(true){
                                                        int temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    System.out.println(skill.getSkillInfo());
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
                                                    break;
                                                     default:
                     System.out.println("enter a valid command (use \"help\" for a list of basic commands)");
                     break;
             }
          }
                         int area3_L;
               Area area3 = new Area(0, null, null);
               area3_L = rand.nextInt(3) + 5;
               //System.out.println(area3_L);
               area3.ensureExit();
               area3.ensureBoss();
               for(int i = 0; i<area3_L-1; i++)
               {
                   area3.addNode(rand.nextInt(3));
                   //area3.addNode(0);
               }
               //Area.listLength(area3);
               Area area3_pp = area3;
               Chest area3_chest = new Chest();
               Enemy a3_enemy = new Enemy(1, 1, 1, 1);    
                
               if(area3_cleared == false)
          {
              System.out.println("\n\n\tYouve arrived at Kurtz's camp,  You can feel his presence.  You feel as though he willed you to this camp."
                     + "\n\tThe smell of death fills the air and you can see death just about everywhere you look.");
            
          }
               while(area3_cleared == false)
          {
             System.out.println("\n\t\tYou have to press foward, Kurtz has to be stopped.  You dont even have a reason, youre heart just wishes to be filled with darkness ");
                input = scan.nextLine();
              OUTER_14:
             OUTER_16:
             switch (input) {
                 case "help":
                     player.help();
                     break;
                 case "forward":
                 case "f":
                     area3_pp = area3_pp.getForeLink();
                     //System.out.println(area3_pp.getData());
                     switch (area3_pp.getData()) {
                         case 0:
                             int area3_encounter;
                             area3_encounter = area3.area_3_Encounter(rand.nextInt(4), player.stats[2], player.name);
                             if(area3_encounter< 75)
                             {
                                 player.stats[1] = player.stats[1] - area3_encounter;
                                 if(player.stats[1]<=0)
                                 {
                                     System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                     area3_cleared = true;
                                     area4_cleared = true;
                                     running = false;
                                     break;
                                 }
                             }
                             ///////////
                             case 1:
                            a3_enemy.getEnemy3();
                            int skillCarry = 0;
                            System.out.println("\n\n----------------------------F I G H T !!!----------------------------");
                             System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                             OUTER:
                             while (true) {
                                 
                                 System.out.println("\nWhat will you do " + player.name + "?");
                                 input = scan.nextLine();
                                 OUTER_7:
                                 switch (input) {
                                  case "attack":
                                  case "a":
                                      
                                      int dmgDealt = rand.nextInt(player.stats[1]);
                                             int EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                             System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                             a3_enemy.enemyStats[1] -= dmgDealt;
                                             if (a3_enemy.enemyStats[1]<0) {
                                                 System.out.println("ENEMY DEFEATED!!!");
                                                 System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n"); 
                                                 player.healthRegen();
                                                 player.allSkillRecharge();
                                                 int gain = rand.nextInt(30) + 20;
                                                 player.gainExp(gain);
                                                 break OUTER;
                                             }
                                             System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                             player.stats[1] -= EdmgDealt;
                                             if (player.stats[1]<0) {
                                                 System.out.println("YOU DIED");
                                                 System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
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
                                             a3_enemy.showEnemyStats();
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
                                                                    break OUTER;//labled issue so i just changed it to OUTER from OUTER_2
                                                                }
                                                                break OUTER;//labled issue so i just changed it to OUTER from OUTER_2
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
                                                                    break OUTER;//labled issue so i just changed it to OUTER from OUTER_2
                                                                }
                                                                break OUTER;//labled issue so i just changed it to OUTER from OUTER_2
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
                                                        if(skillCarry == 0){
                                                            EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[1] -= EdmgDealt;
                                                            if (player.stats[1]<=0) 
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
                                                        }
                                                        else
                                                            skillCarry = 0;    
                                                    break;
                                                case "skill info":
                                                case "si":
                                                    System.out.print("\tPlease enter the name of the skill that you want information about: ");
                                                    while(true){
                                                        int temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    System.out.println(skill.getSkillInfo());
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
                                                    break;
                                                case "use skill":
                                                case "us":
                                                    System.out.println("Which skill did you want to use?");
                                                    player.showSkills();
                                                    while(true){
                                                        int temp;
                                                        temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    if(skill.uses == false){
                                                                        System.out.println("You can only use a skill once per battle! Please choose another skill.");
                                                                        break;
                                                                    }
                                                                    int[] array = new int[6];
                                                                    array = skill.use(player.lvl);
                                                                    if(array[0] != 0){
                                                                        System.out.println("The enemy has taken " + array[0] + " damage!");
                                                                        a3_enemy.enemyStats[1] -= array[0];
                                                                        if (a3_enemy.enemyStats[1]<0) {
                                                                            System.out.println("ENEMY DEFEATED!!!");
                                                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");
                                                                            player.healthRegen();
                                                                            player.allSkillRecharge();
                                                                            int gain = rand.nextInt(15) + 15;
                                                                            player.gainExp(gain);
                                                                            break OUTER;
                                                                        }
                                                                    }
                                                                    if(array[1] != 0){
                                                                        System.out.println("You have healed " + array[1] + " health!");
                                                                        player.stats[1] += array[1];
                                                                    }
                                                                    if (array[2] != 0){
                                                                        System.out.println("The enemy's turn has been skipped!");
                                                                    }
                                                                    if (array[3] != 0){
                                                                        System.out.println("You gain " + array[3] + "% damage reduction!");
                                                                    }
                                                                    if (array[4] != 0){
                                                                        System.out.println("You gain " + array[4] + "% extra damage on a regular attack next turn!");
                                                                    }
                                                                    if (array[5] != 0){
                                                                        skillCarry = 2;
                                                                    }
                                                                    if(array[2] == 0 || skillCarry == 0){
                                                                        if(array [3] == 0){
                                                                            EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                                                            System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                        else{
                                                                            EdmgDealt = rand.nextInt(a3_enemy.enemyStats[2]);
                                                                            double EdmgredDealt = (double)(EdmgDealt * array[3] / 100);
                                                                            System.out.println("The enemy does " + EdmgredDealt + " damage back at you!");
                                                                            System.out.println("They did " + array[3] + "% reduced damage because of your skill!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (skillCarry != 0)
                                                                        skillCarry--;
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }                                                
                                                    break;
                                 
                                 case "help":
                                 player.help();
                                 break;
                                 }
                             }
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
                            Enemy bigBoi = new Enemy(100, 500, 80, 50);
                           
                            System.out.println("\n\n----------------------------I T ' S   K U R T Z   T I M E   B O i S----------------------------");
                             System.out.println("combat commands can be pulled up at any time by typing \"combat help\"");
                             System.out.println("Kurtz breaths calmly and looks at you, the thing is you dont feel any judgement from this man who knows you are here to kill him");
                             System.out.println("Is this man truly evil, or something even more frightening.  You feel like you know Kurtz, it might be because hes the closing thing to you youve seen");
                             OUTER:
                             while (true) {
                                 System.out.println("\nWhat will you do " + player.name + "?");
                                 input = scan.nextLine();
                                 skillCarry = 0;
                                 OUTER_17:
                                 switch (input) {
                                     
                                 case "attack":
                                        case "a":
                                            
                                            int dmgDealt = rand.nextInt(player.stats[2]);
                                                int EdmgDealt;
                                                System.out.println("The enemy has taken " + dmgDealt + " damage!");
                                                bigBoi.enemyStats[1] -= dmgDealt;
                                                if (bigBoi.enemyStats[1]<0) {
                                                    System.out.println("ENEMY DEFEATED!!!");
                                                    System.out.println("\n\n--------------------"
                                                            + "--------BOSS HAS BEEN Y E E T E D----------------------------\n\n");
                                                    bigBoi.enemyStats[1] = 100;
                                                    player.healthRegen();
                                                    player.allSkillRecharge();
                                                    int gain = player.maxExp;
                                                    player.gainExp(gain);
                                                    break OUTER;
                                                }
                                                
                                                
                                                EdmgDealt = bigBoi.bossTwoSkills(rand.nextInt(2), 5 , player.stats[1], 50, 35);
                                                player.stats[1] -= EdmgDealt;
                                                if (player.stats[1]<=0) {
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
                                                            break OUTER;
                                                        }
                                                        break OUTER;
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
                                                            break OUTER;
                                                        }
                                                        break OUTER;
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
                                                        if(skillCarry == 0){
                                                            EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                                            System.out.println("The enemy deals " + EdmgDealt + " damage to you!");
                                                            player.stats[1] -= EdmgDealt;
                                                            if (player.stats[1]<=0) 
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
                                                        }
                                                        else
                                                            skillCarry = 0;    
                                                    break;
                                                case "skill info":
                                                case "si":
                                                    System.out.print("\tPlease enter the name of the skill that you want information about: ");
                                                    while(true){
                                                        int temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    System.out.println(skill.getSkillInfo());
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
                                                    break;
                                                case "use skill":
                                                case "us":
                                                    System.out.println("Which skill did you want to use?");
                                                    player.showSkills();
                                                    while(true){
                                                        int temp;
                                                        temp = 0;
                                                        String s = scan.nextLine();
                                                        for (Skills skill : player.skills) {
                                                            if (skill != null) {
                                                                if (s.equalsIgnoreCase(skill.name)) {
                                                                    if(skill.uses == false){
                                                                        System.out.println("You can only use a skill once per battle! Please choose another skill.");
                                                                        break;
                                                                    }
                                                                    int[] array = new int[6];
                                                                    array = skill.use(player.lvl);
                                                                    if(array[0] != 0){
                                                                        System.out.println("The enemy has taken " + array[0] + " damage!");
                                                                        bigBoi.enemyStats[1] -= array[0];
                                                                        if (bigBoi.enemyStats[1]<0) {
                                                                            System.out.println("ENEMY DEFEATED!!!");
                                                                            System.out.println("\n\n----------------------------ENEMY HAS BEEN Y E E T E D----------------------------\n\n");                                              
                                                                            player.healthRegen();
                                                                            player.allSkillRecharge();
                                                                            int gain = rand.nextInt(15) + 15;
                                                                            player.gainExp(gain);
                                                                            break OUTER;
                                                                        }
                                                                    }
                                                                    if(array[1] != 0){
                                                                        System.out.println("You have healed " + array[1] + " health!");
                                                                        player.stats[1] += array[1];
                                                                    }
                                                                    if (array[2] != 0){
                                                                        System.out.println("The enemy's turn has been skipped!");
                                                                    }
                                                                    if (array[3] != 0){
                                                                        System.out.println("You gain " + array[3] + "% damage reduction!");
                                                                    }
                                                                    if (array[4] != 0){
                                                                        System.out.println("You gain " + array[4] + "% extra damage on a regular attack next turn!");
                                                                    }
                                                                    if (array[5] != 0){
                                                                        skillCarry = 2;
                                                                    }
                                                                    if(array[2] == 0 || skillCarry == 0){
                                                                        if(array [3] == 0){
                                                                            EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                                                            System.out.println("The enemy does " + EdmgDealt + " damage back at you!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                        else{
                                                                            EdmgDealt = rand.nextInt(bigBoi.enemyStats[2]);
                                                                            double EdmgredDealt = (double)(EdmgDealt * array[3] / 100);
                                                                            System.out.println("The enemy does " + EdmgredDealt + " damage back at you!");
                                                                            System.out.println("They did " + array[3] + "% reduced damage because of your skill!");
                                                                            player.stats[1] -= EdmgDealt;
                                                                            if (player.stats[1]<=0) {
                                                                                System.out.println("YOU DIED");
                                                                                System.out.println("\n\n----------------------------G A M E   O V E R----------------------------\n\n");
                                                                                area1_cleared = true;
                                                                                area2_cleared = true;
                                                                                area3_cleared = true;
                                                                                area4_cleared = true;
                                                                                running = false;
                                                                                break OUTER;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if (skillCarry != 0)
                                                                        skillCarry--;
                                                                    temp++;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if(temp != 0)
                                                            break;
                                                        else
                                                            System.out.println("\tPlease enter a skill you have available or a valid skill name.");
                                                    }
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
                                    if(player.stats[4]>5){
                                     System.out.println("\n\n\t Kurtz is on the ground, he looks you in the eyes and says"
                                     + "\n\tI still see judgement in your eyes.  You are but a man who tries to please whoever you are around.  Let me help put things into perspective so you can understand Darkness"
                                     + "\n\tA while ago i remembered something that happened to me. I remember when I was with Special Forces... seems a thousand centuries ago. We went into a camp to inoculate some children. We left the camp after we had "
                                             + " \n\tInoculated the children for polio, and this old man came running after us and he was crying. He couldn't see. We went back there, and they had come and hacked off every inoculated arm. There they were in a pile. A pile of little arms."
                                             + " \n\t And I remember... I... I... I cried, I wept like some grandmother. I wanted to tear my teeth out; I didn't know what I wanted to do! And I want to remember it. I never want to forget it... I never want to forget."
                                             + "\n\tThis is also when i realized that they were alot stronger than us, because htey could stand that we werent monsters, we are men, with families, with passion, but they still had the strength to accomplish such feats"
                                             + "\n\tThis is what you must understand to obtain the heart of darkness.  Men must be moral but at the same time, be able to utilize their primordial instincts to kill without feeling..... without passion ..... without Judgement"
                                             + "\n\tBecause its Judgement that defeats us "); 
                                    System.out.println("\n\n\tYou look at Kurtz lifeless body.  You understood every word.  You turn around and leave the camp.... free of judgement.... free from the shackles that held you down"
                                            + "\n\tYouve obtained the Heart of Darkness");
                                    }
                                    else
                                        System.out.println("Someone like you, full of hatred and ill intent, could never understand what it means to have the Heart of Darkness.  My wisdom is wasted on you"
                                                + "\n\tIm glad i can see my end but am almost offended i was waiting for a man like you to end me"
                                                + "\n\tKurtz is already dead, the missions over");
                                    area4_cleared = true;
                             break;
                         default:
                             break;
                     }//Area End
                          break;
                          
                                    
                             }
                                  }//While Area Cleared   
                                 if(area1_cleared == true && area2_cleared == true && area3_cleared == true && area4_cleared == true && running == true)
                                   
                                   running = false;
                                    System.exit(0);
                                    break;  
                                 }
                                 
                                }
                                }
                                
                        

                       
                
                   
                
