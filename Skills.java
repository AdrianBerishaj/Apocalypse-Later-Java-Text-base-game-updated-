package software.engineer.and.practice;

import java.util.*;

public class Skills {
    public String name;
    public int hp, dmg;
    public boolean uses;
    public Skills(String iname, int idmg, int ihp, boolean iuses){
        name = iname;
        dmg = idmg;
        hp = ihp;
        uses = iuses;
    }
    public String getName(){
      return name;
    }
    public boolean getUses(){
        return uses;
    }
    public int[] use(int lvl){
        int[] skillUse = new int[6]; //{damage done, healing done, skip enemy turn, percentage of damage reduction, percentage of damage boost. extre turns lasts}
        if(uses == true){
            switch(name){
                case "Boost":
                    skillUse[0] = dmg;
                    skillUse[1] = hp;
                    skillUse[2] = 1;
                    skillUse[3] = 0;
                    skillUse[4] = 0;
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                case "Healing Word":
                    skillUse[0] = dmg;
                    skillUse[1] = hp + (5 * lvl);
                    skillUse[2] = 0;
                    skillUse[3] = 0;
                    skillUse[4] = 0;
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                case "Taunt":
                    skillUse[0] = dmg;
                    skillUse[1] = hp;
                    skillUse[2] = 0;
                    skillUse[3] = 75;
                    skillUse[4] = 15;
                    skillUse[5] = 1;
                    this.uses = false;
                    return skillUse;
                case "Crippling Blow":
                    skillUse[0] = dmg;
                    skillUse[1] = hp;
                    skillUse[2] = 0;
                    skillUse[3] = 50;
                    skillUse[4] = 0;
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                case "Sleep":
                    skillUse[0] = dmg;
                    skillUse[1] = hp;
                    skillUse[2] = 1;
                    skillUse[3] = 0;
                    skillUse[4] = 0;
                    skillUse[5] = 1;
                    this.uses = false;
                    return skillUse;
                case "Decoy":
                    skillUse[0] = dmg;
                    skillUse[1] = hp;
                    skillUse[2] = 0;
                    skillUse[3] = 100;
                    skillUse[4] = 0;
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                case "Radiant Beam":
                    skillUse[0] = dmg;
                    skillUse[1] = hp;
                    skillUse[2] = 0;
                    skillUse[3] = 25;
                    skillUse[4] = 25;
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                case "Tracking Shot":
                    skillUse[0] = dmg;
                    skillUse[1] = hp;
                    skillUse[2] = 0;
                    skillUse[3] = 0;
                    skillUse[4] = 75;
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                case "Animal Friend":
                    skillUse[0] = dmg;
                    skillUse[1] = hp;
                    skillUse[2] = 0;
                    skillUse[3] = 20;
                    skillUse[4] = 0;
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                default:
                    skillUse[0] = dmg + (7 * lvl);
                    skillUse[1] = hp;
                    skillUse[2] = 0;
                    skillUse[3] = 0;
                    skillUse[4] = 0;
                    this.uses = false;
                    return skillUse;
            }
        }
        else
            return skillUse;
    }
    public void recharge(){  //Need to do this after every encounter to be able to use the skill again
        this.uses = true;
    }
    public String getSkillInfo(){
        switch(name){
            case "Boost":
                return "BOOST - This ability gives you an extre turn in combat!";
            case "Shield Bash":
                return "SHIELD BASH - You bring your shield downwards in a devestating blow! Does 15 damage + 7 * your player level.";
            case "Firebolt":
                return "FIREBOLT - You focus your energy into conjuring a mighty firebolt, then hurl it at the enemy! Does 15 damage + 7 * your player level.";
            case "Backstab":
                return "BACKSTAB - Sneaking around the enemy, you unsheathe your weapon and bring it downwards in a blow aimed straight for a tendon. Does 15 damage + 7 * your player level.";
            case "Healing Word":
                return "HEALING WORD - You channel all of your divine energy into patching your wounds. This heals you for 15 health + 5 * your player level.";
            case "Precise Shot":
                return "PRECISE SHOT - You take your time to find a weak point in the enemies defense and loose an arrow. Does 15 damage + 7 * your player level.";
            case "Taunt":
                return "TAUNT - ";
            case "Crippling Blow":
                return "CRIPPLING BLOW - ";
            case "Thunder Storm":
                return "SHIELD BASH - ";
            case "Sleep":
                return "SLEEP - ";
            case "Double Strike":
                return "DOUBLE STRIKE - ";
            case "Decoy":
                return "DECOY - ";
            case "Radiant Beam":
                return "RADIANT BEAM - ";
            case "Holy Prayer":
                return "HOLY PRAYER - ";
            case "Tracking Shot":
                return "TRACKING SHOT - ";
            case "Animal Friend":
                return "ANIMAL FRIEND - ";
            default:
                return "Not a valid skill.";
        }
    }
    public void changeName(String newname){
        this.name = newname;
    }
}
