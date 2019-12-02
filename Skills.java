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
        int[] skillUse = new int[6]; //{damage done, healing done, skip enemy turn, percentage of damage reduction, percentage of damage boost, extra turns lasts}
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
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                case "Crippling Blow":
                    skillUse[0] = dmg + (7 * lvl);
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
                    skillUse[4] = 25;
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                case "Radiant Beam":
                    skillUse[0] = dmg + (7 * lvl);
                    skillUse[1] = hp;
                    skillUse[2] = 0;
                    skillUse[3] = 25;
                    skillUse[4] = 25;
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                case "Holy Prayer":
                    skillUse[0] = dmg;
                    skillUse[1] = hp + (5 * lvl);
                    skillUse[2] = 0;
                    skillUse[3] = 0;
                    skillUse[4] = 0;
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                case "Tracking Shot":
                    skillUse[0] = dmg + (7 * lvl);
                    skillUse[1] = hp;
                    skillUse[2] = 0;
                    skillUse[3] = 0;
                    skillUse[4] = 75;
                    skillUse[5] = 0;
                    this.uses = false;
                    return skillUse;
                case "Animal Friend":
                    skillUse[0] = dmg + (7 * lvl);
                    skillUse[1] = hp;
                    skillUse[2] = 0;
                    skillUse[3] = 25;
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
                return "BOOST - This ability gives you an extra turn in combat!";
            case "Shield Bash":
                return "SHIELD BASH - You bring your shield downwards in a devastating blow! Does 15 damage + 7 * your player level.";
            case "Firebolt":
                return "FIREBOLT - You focus your energy into conjuring a mighty firebolt, then hurl it at the enemy! Does 15 damage + 7 * your player level.";
            case "Backstab":
                return "BACKSTAB - Sneaking around the enemy, you unsheathe your weapon and bring it downwards in a blow aimed straight for a tendon. Does 15 damage + 7 * your player level.";
            case "Healing Word":
                return "HEALING WORD - You channel all of your divine energy into patching your wounds. This heals you for 15 health + 5 * your player level.";
            case "Precise Shot":
                return "PRECISE SHOT - You take your time to find a weak point in the enemy's defense and loose an arrow. Does 15 damage + 7 * your player level.";
            case "Taunt":
                return "TAUNT - You call out the flaws in your enemy's defenses. For your next turn, any damage you take is reduced by 75% and any damage you deal with a regular attack is boosted by 25%.";
            case "Crippling Blow":
                return "CRIPPLING BLOW - You spot a large weakness in your enemy's stance and strike down on it. You do 15 + 7 * your level in damage and take 50% reduced damage from their next attack against you.";
            case "Thunder Storm":
                return "THUNDER STORM - You focus and call down a gigantic thundersotrm that envelops your enemy. Does 25 + 7 * level damage.";
            case "Sleep":
                return "SLEEP - You call on your magical prowess to lull your enemy into a magical slumber. They fall asleep and lose their next two turns.";
            case "Double Strike":
                return "DOUBLE STRIKE - You unsheath your weapon and bring it down on the enmy in two strong strikes. Does 25 + 7 * your level damage.";
            case "Decoy":
                return "DECOY - You construct a illusionary copy of yourself to confuse the enemy. The enemy attacks the decoy instead and you take advantage of their confusion with a 25% increase to your damage if you use a regular attack next turn.";
            case "Radiant Beam":
                return "RADIANT BEAM - You call down the fury of your deity to smite your enemy. Does 20 + 7 * your level in damage, reduces the damage you take from the enemy's next atack by 25%, and allows you to deal 25% more damage if you use a regular attack next turn.";
            case "Holy Prayer":
                return "HOLY PRAYER - You beg your deity to show mercy, reinforcing your alligence to them. They pity you and heal you for 30 health + 5 * your player level.";
            case "Tracking Shot":
                return "TRACKING SHOT - You look for a fault in your enemy's stance and loose an arrow aimed at that point to mark it for future attacks. Does 10 damage + 7 * your player level and allows you to deal 75% increased damage if you use a regular attack next turn.";
            case "Animal Friend":
                return "ANIMAL FRIEND - You call out into the wilderness and find a creature willing to help you. This animal attaks and does 20 + 7 * your player level in damage and helps to split the enemy's attention, causing their next attack to do 25% reduced damage to you.";
            default:
                return "Not a valid skill.";
        }
    }
    public void changeName(String newname){
        this.name = newname;
    }
}
