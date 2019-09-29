package software.engineer.and.practice;
import java.util.*;

public class Chest {
    int rand;
    Items item;
    Items longsword = new Items("Longsword", 1, 0, 8, 0, 0, 0);
    Items chainmail = new Items("Chainmail", 3, 0, 0, 0, 0, 17);
    Items mace = new Items("Mace", 1, 0, 7, 0, 0, 0);
    Items bow = new Items("Bow", 2, 0, 5, 0, 0, 0);
    Items staff = new Items("Staff", 1, 0, 5, 0, 0, 0);
    Items knife = new Items("Knife", 1, 0, 3, 0, 0, 0);
    Items crossbow = new Items("Crossbow", 2, 1, 0, 7, 0, 0);
    Items shortsword = new Items("Shortsword", 1, 0, 6, 0, 0, 0);
    Items katana = new Items("Katana", 1, 0, 10, 0, 0, 0);
    Items scimitar = new Items("Scimitar", 1, 0,  15, 0, 0, 0);
    Items BLK_leather = new Items("Black Leather Armor", 3, 0, 0, 0, 0, 10);
    Items BLK_robes = new Items("Black Robes", 3, 0, 0, 0, 0, 7);
    Items robes = new Items("Robes", 3, 0, 0, 0, 0, 5);
    Items rags = new Items("Rags", 3, 0, 0, 0, 0, 3);
    Items ironarmor = new Items("Iron Armor", 3, 0, 0, 0, 0, 15);
    Items platemail = new Items("Platemail Armor", 3, 0, 0, 0, 0, 20);
    Items leathershield = new Items("Leather Buckler Shield", 3, 0, 0, 0, 0, 7);
    Items steelshield = new Items("Steel Shield", 3, 0, 0, 4, 0, 10);
    Items leatherhelmet = new Items("Leather Helmet", 3, 0, 0, 0, 0, 5);
    Items steelhelmet = new Items("Steel Helmet", 3, 0, 0, 0, 0, 7);
    Items leatherboots = new Items("Leather Boots",3, 0, 0, 0, 0, 3);
    Items steelboots = new Items("Steel Boots", 3, 0, 0, 0, 0, 5);
    Items smallHpPot = new Items("Small Health Potion", 4, 10, 0, 0, 0, 0);
    Items mediumHpPot = new Items("Health Potion", 4, 25, 0, 0, 0, 0);
    Items largeHpPot = new Items("Max Health Potion", 4, 50, 0, 0, 0, 0);
    Items[] possItems = {longsword, chainmail, mace, bow, BLK_leather, staff, BLK_robes, robes, rags, knife, crossbow, shortsword, ironarmor, platemail, leathershield, steelshield, leatherhelmet, steelhelmet, leatherboots, steelboots, katana, scimitar, smallHpPot, mediumHpPot, largeHpPot};
    public Chest(){
        rand = new Random().nextInt(possItems.length);
        item = possItems[rand];
    }
    public Items open(){
        return item;
    }
    public void newItem()
    {
        rand = new Random().nextInt(possItems.length);
        item = possItems[rand];
    }
}
