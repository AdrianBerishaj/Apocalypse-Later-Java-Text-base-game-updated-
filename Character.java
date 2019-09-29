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
    Skills skill1 = new Skills("Boost ✓", 0, 0, true);
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
        equipment = (Items[]) new Items[5];
        skills = (Skills[]) new Skills[7];
        skills[1] = skill1;
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
         
     }
     public void combatHelp()
     {
         System.out.println("\n\n\tCombat Commands:");
         
     }
}
