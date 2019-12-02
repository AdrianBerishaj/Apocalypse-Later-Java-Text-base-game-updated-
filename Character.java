package software.engineer.and.practice;


import java.util.*;

public class Character<E> {
    SkillTree skilltree = new SkillTree();
    int lvl, maxExp, health, exp, inv, baseDmg, dmgRed, maxHealth, rep;
    String name, gameClass;
    int[] stats = new int[5];
    Items[] inventory, equipment;
    Skills[] skills;
    
    int difficultyNum = 0; //Used for determining stats of enemies
    Skills skill1 = new Skills("Boost", 0, 0, true);
    Skills skill2 = new Skills("Shield Bash", 15, 0, true);
    Skills skill3 = new Skills("Firebolt", 15, 0, true);
    Skills skill4 = new Skills("Backstab", 15, 0, true);
    Skills skill5 = new Skills("Healing Word", 0, 15, true);
    Skills skill6 = new Skills("Precise Shot", 15, 0, true);
    Skills skill7 = new Skills("Taunt", 0, 0, true);
    Skills skill8 = new Skills("Crippling Blow", 15, 0, true);
    Skills skill9 = new Skills("Thunder Storm", 25, 0, true);
    Skills skill10 = new Skills("Sleep", 0, 0, true);
    Skills skill11 = new Skills("Double Strike", 25, 0, true);
    Skills skill12 = new Skills("Decoy", 0, 0, true);
    Skills skill13 = new Skills("Radiant Beam", 20, 0, true);
    Skills skill14 = new Skills("Holy Prayer", 0, 0, true);
    Skills skill15 = new Skills("Tracking Shot", 7, 0, true);
    Skills skill16 = new Skills("Animal Friend", 20, 0, true);
    Skills[] possibleSkills = {skill1, skill2, skill3, skill4, skill5, skill6, skill7, skill8, skill9, skill10, skill11, skill12, skill13, skill14, skill15, skill16};
    
    public Character(){
        skilltree.genSkillTree();
        this.rep = 0;
        this.lvl = 0;
        this.health = 100;
        this.exp = 0;
        this.inv = 8;
        inventory = (Items[]) new Items[10];
        equipment = (Items[]) new Items[7];
        skills = (Skills[]) new Skills[15];
        skills[0] = skill1;
        name = "";
        gameClass = "";
        maxExp = 100;
        baseDmg = 10;
        dmgRed = 0;
        maxHealth = 100;
        stats[0] = maxHealth;
        stats[1] = health;
        stats[2] = baseDmg;
        stats[3] = dmgRed;
        stats[4] = rep;
    }
    public int getCurrLevel(){
        return this.lvl;
    }
    public int getCurrHealth(){
        return this.health;
    }
    public int getCurrExp(){
        return this.exp;
    }
    public int getCurrInv(){
        return this.inv;
    }
    public void loseHealth(int loss){
        this.health = health - loss;
        if (this.health <= 0){   //Checking if character is dead
            System.out.println("You Have Died.");
            System.exit(0);
        }
    }
    public void gainHealth(int gain){
        this.health = health + gain;
        if (this.health > maxHealth)   //Limiting health to maxHealth
            this.health = maxHealth;
    }
    public void useInvSlot(){
        this.inv = inv - 1;
        if (inv <= 0)
            System.out.println("Inventory is full.");
    }
    public int getDifficulty(){
        Scanner sc = new Scanner(System.in);
        //Choosing difficulty
        
        System.out.println("What difficulty would you like to play?");
        System.out.println("  Easy, Normal, Hard, or Very Hard?");
        System.out.println("Type Below:");
        while (difficultyNum == 0){   //Ensuring that a correct choice is entered
            String dif = sc.nextLine();
            if (dif.equalsIgnoreCase("Easy")){
                difficultyNum = 1;
            }
            
            else if (dif.equalsIgnoreCase("Normal")){
                difficultyNum = 2;
            }
            
            else if (dif.equalsIgnoreCase("Hard")){
                difficultyNum = 3;
            }
            
            else if (dif.equalsIgnoreCase("Very Hard")){
                difficultyNum = 4;
            }
            
            else
                System.out.println("Please enter a valid difficulty:");
                
        }
        return difficultyNum;
    }
    
    public int getDiffNum(){
        return difficultyNum;
    }
    public void getName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of your character: ");
        this.name = sc.nextLine();
    }
    public void getStarterEquip(){
        Items spoon = new Items("Spoon", 1, 0, 2, 0, 0, 0);
        Items rags = new Items("Rags", 3, 0, 0, 0, 0, 3);
        Items knife = new Items("Knife", 1, 0, 3, 0, 0, 0);
        Items commonclothes = new Items("Common Clothes", 3, 0, 0, 0, 0, 4);
        Items shortsword = new Items("Shortsword", 1, 0, 6, 0, 0, 0);
        Items ironshield = new Items("Iron Shield", 3, 0, 0, 0, 0, 5);
        Items ironhelmet = new Items("Iron Helmet", 3, 0, 0, 0, 0, 4);
        Items ironarmor = new Items("Iron Armor", 3, 0, 0, 0, 0, 15);
        Items irongauntlets = new Items("Iron Gauntlets",3, 0, 0, 0, 0, 4);
        Items irongreaves = new Items("Iron Greaves",3, 0, 0, 0, 0, 4);
        Items staff = new Items("Staff", 1, 0, 5, 0, 0, 0);
        Items robes = new Items("Robes", 3, 0, 0, 0, 0, 5);
        Items smallHpPot = new Items("Small Health Potion", 4, 10, 0, 0, 0, 0);
        Items dagger = new Items("Dagger", 1, 0, 5, 0, 0, 0);
        Items crossbow = new Items("Crossbow", 2, 0, 7, 0, 0, 0);
        Items leatherhelmet = new Items("Leather Helmet", 3, 0, 0, 0, 0, 3);
        Items leatherarmor = new Items("Leather Armor", 3, 0, 0, 0, 0, 10);
        Items leathergauntlets = new Items("Leather Gauntlets",3, 0, 0, 0, 0, 3);
        Items leatherboots = new Items("Leather Boots",3, 0, 0, 0, 0, 3);
        Items holytalisman = new Items("Holy Talisman", 3, 0, 0, 0, 0, 5);
        Items bow = new Items("Bow", 2, 0, 5, 0, 0, 0);
        String temp;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("How would you like your character to start off?");
        System.out.println("\tHobo - Starts with a spoon and rags.");
        System.out.println("\tCommoner - Starts with a knife and common clothes.");
        System.out.println("\tKnight - Starts with a shortsword, iron shield, and all four pieces of iron armor.");
        System.out.println("\tMage - Starts with a satff, knife, robes, and small health potion.");
        System.out.println("\tRogue - Starts with a dagger, crossbow, and all four pieces of leather armor.");
        System.out.println("\tPaladin - Starts with a shortsword, holy talisman, and all four pieces of iron armor.");
        System.out.println("\tHunter - Starts with a bow, dagger, and all four pieces of leather armor.");
        temp = sc.nextLine().toLowerCase();
        while(i == 0){
            switch(temp){
                case "hobo":
                    equipment = spoon.ADDequipment(equipment);
                    equipment = rags.ADDequipment(equipment);
                    stats = spoon.ADDstats(stats);
                    stats = rags.ADDstats(stats);
                    i++;
                    break;
                case "commoner":
                    equipment = knife.ADDequipment(equipment);
                    equipment = commonclothes.ADDequipment(equipment);
                    stats = knife.ADDstats(stats);
                    stats = commonclothes.ADDstats(stats);
                    i++;
                    break;
                case "knight":
                    equipment = shortsword.ADDequipment(equipment);
                    equipment = ironshield.ADDequipment(equipment);
                    equipment = ironhelmet.ADDequipment(equipment);
                    equipment = ironarmor.ADDequipment(equipment);
                    equipment = irongauntlets.ADDequipment(equipment);
                    equipment = irongreaves.ADDequipment(equipment);
                    stats = shortsword.ADDstats(stats);
                    stats = ironshield.ADDstats(stats);
                    stats = ironhelmet.ADDstats(stats);
                    stats = ironarmor.ADDstats(stats);
                    stats = irongauntlets.ADDstats(stats);
                    stats = irongreaves.ADDstats(stats);
                    i++;
                    break;
                case "mage":
                    equipment = staff.ADDequipment(equipment);
                    equipment = robes.ADDequipment(equipment);
                    inventory = smallHpPot.ADDinventory(inventory);
                    stats = staff.ADDstats(stats);
                    stats = robes.ADDstats(stats);
                    i++;
                    break;
                case "rogue":
                    equipment = dagger.ADDequipment(equipment);
                    equipment = crossbow.ADDequipment(equipment);
                    equipment = leatherhelmet.ADDequipment(equipment);
                    equipment = leatherarmor.ADDequipment(equipment);
                    equipment = leathergauntlets.ADDequipment(equipment);
                    equipment = leatherboots.ADDequipment(equipment);
                    stats = dagger.ADDstats(stats);
                    stats = crossbow.ADDstats(stats);
                    stats = leatherhelmet.ADDstats(stats);
                    stats = leatherarmor.ADDstats(stats);
                    stats = leathergauntlets.ADDstats(stats);
                    stats = leatherboots.ADDstats(stats);
                    i++;
                    break;
                case "paladin":
                    equipment = shortsword.ADDequipment(equipment);
                    equipment = holytalisman.ADDequipment(equipment);
                    equipment = ironhelmet.ADDequipment(equipment);
                    equipment = ironarmor.ADDequipment(equipment);
                    equipment = irongauntlets.ADDequipment(equipment);
                    equipment = irongreaves.ADDequipment(equipment);
                    stats = shortsword.ADDstats(stats);
                    stats = holytalisman.ADDstats(stats);
                    stats = ironhelmet.ADDstats(stats);
                    stats = ironarmor.ADDstats(stats);
                    stats = irongauntlets.ADDstats(stats);
                    stats = irongreaves.ADDstats(stats);
                    i++;
                    break;
                case "hunter":
                    equipment = bow.ADDequipment(equipment);
                    equipment = dagger.ADDequipment(equipment);
                    equipment = leatherhelmet.ADDequipment(equipment);
                    equipment = leatherarmor.ADDequipment(equipment);
                    equipment = leathergauntlets.ADDequipment(equipment);
                    equipment = leatherboots.ADDequipment(equipment);
                    stats = bow.ADDstats(stats);
                    stats = dagger.ADDstats(stats);
                    stats = leatherhelmet.ADDstats(stats);
                    stats = leatherarmor.ADDstats(stats);
                    stats = leathergauntlets.ADDstats(stats);
                    stats = leatherboots.ADDstats(stats);
                    i++;
                    break;
                default:
                    System.out.println("\nPlease choose an option from above.\n");
                    temp = sc.nextLine().toLowerCase();
            }
        }
    }
    public void gainExp(int gain){
        Scanner sc = new Scanner(System.in);
        int temp = 0;
        String input;
        Skills skill = null;
        System.out.println(gain + " experience points have been gained!" );
        this.exp = exp + gain; 
       
        if (this.exp >= maxExp){ //Checking if a level up is in order
            this.exp -= maxExp;
            System.out.println("You feel more power coursing through your veins. You have leveled up!");
            lvl++;
            maxExp = 100 + (50 * lvl);
            baseDmg = 10 + ((5 * lvl) * lvl);
            dmgRed = 0 + (1 * (lvl / 3));
            maxHealth = 100 + (20 * lvl);
            stats[0] = maxHealth;
            stats[1] = maxHealth;
            stats[2] = baseDmg;
            stats[3] = dmgRed;
            while(true){
                System.out.println("\nHere's your current progress thus far:");
                skilltree.printTree();
                System.out.print("\nPlease choose a new skill: ");
                input = sc.nextLine();
                for(int i = 0; i <= 15; i++){
                    if(input.equalsIgnoreCase(possibleSkills[i].getName())){
                        skill = possibleSkills[i];
                        temp = 1;
                        break;
                    }
                    else
                        temp = 0;
                }
                if(temp == 1 && !this.hasSkill(skill) && this.skilltree.skillAvailable(skill)){
                    System.out.println("You have unlocked the " + skill.name + " skill!");
                    System.out.println("\nInformation: " + skill.getSkillInfo());
                    skills[lvl] = skill;
                    skilltree.skillGet(skill);
                    break;
                }
               else
                    System.out.println("Please choose an available skill.\n");
            }
        }
    }
     public void showInv() //command "bag"
    {
        for (Items inventory1 : inventory) {
            System.out.println(inventory1); 
        }
    }
     public void showEquip() //command "equipment"
    {
        for (Items equipment1 : equipment) {
            System.out.println(equipment1); 
        }
    }
     public void showStats(){
         System.out.println("\n\tLevel: " + lvl + "\n\tExperience to Next Level: " + (maxExp - exp) + "\n\tHealth: " + stats[1] + "\n\tMaximum Health: " + stats[0] + "\n\tBase Damage: " + stats[2] + "\n\tDamage Reduction: " + stats[3] + "\n\tReputation: " + stats[4]);
     }
     public void showSkills(){
        for (Skills skills1 : skills) {
           System.out.println(skills1.getName()); 
        }
     }
     public boolean hasSkill(Skills temp){
        for (int j = 0; j < skills.length; j++) {
            if(skills[j] == temp)
                return true;
        }
        return false;
     }
     public void changeRep(int temp){
         stats[4] += temp;
     }
     public void help()
     {
         System.out.println("\n\n\tBasic Commands:");
         System.out.println("\t\tForward (or f) - Move forward");
         System.out.println("\t\tEquipment (or \"se\") - Show player equipment");
         System.out.println("\t\tBag (or \"b\") - Display player inventory");
         System.out.println("\t\tStats (or \"s\") - Display current player stats");
         System.out.println("\t\tSkills (or \"sk\") - Display player's skill tree");
         System.out.println("\t\tSkill Info (or \"si\") - Display info on one of your character's skills");
         System.out.println("\t\tItem Stats (or \"is\") - Show how a specific item will echange your character stats when equipped");
         System.out.println("\n\tCommands for Managing Items:");
         System.out.println("\t\tDrop (or \"d\") - Drop an item from your bag or equipment");
         System.out.println("\t\tUse (or \"u\") - Use any usable item from your bag");
         System.out.println("\t\tEquip (or \"e\") - Equip an item from your bag to your equipment");
         System.out.println("\t\tUnequip (or \"ue\") - Unequip an item from your equipment and place it in your bag");
     }
     public void combatHelp()
     {
         System.out.println("\n\n\tCombat Commands:");
         System.out.println("\tAttack (or \"a\") - Attack the enemy head on with a melee attack");
         System.out.println("\tUse Skill (or \"us\")- Uses your character's skill! It can only be used once per battle.");
         System.out.println("\tSkill Info (or \"si\") - Display info on one of your character's skills");
         System.out.println("\tUse (or \"u\") - Use any usable item from your bag \n\t(will consume a turn, even if you try using an \"empty\" item)");
         System.out.println("\tItem Stats (\"is\") - Show how a specific item will echange your character stats when equipped");
         System.out.println("\tIdentify (or \"i\") - Use your wisdom to possibly identify enemy stats! (will consume a turn!)");
         System.out.println("\tAny time during combat you may CHECK your current equipment, inventory, and current stats; will NOT consume a turn");
     }
}
