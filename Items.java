package software.engineer.and.practice;

import java.util.Arrays;


public class Items<E>
{ 
   public String name;
   private int type; //type 1 = weapon, tpye 2 = ranged weapon, type 3 = armor, type 4 = consumable
   private int ADD_hp, ADD_dmg, SUB_hp, SUB_dmg, RED_dmg;
   private int[] ADDstats = new int[]{ADD_hp, ADD_dmg, RED_dmg};
   private int[] SUBstats = new int[]{SUB_hp, SUB_dmg};
  public Items(String Iname, int Itype, int Ahp, int Admg, int Shp, int Sdmg, int Rdmg)
  {
      name = Iname;
      type = Itype;
      ADD_hp = Ahp;
      SUB_hp = Shp;
      ADD_dmg = Admg;
      SUB_dmg = Sdmg;
      RED_dmg = Rdmg;
      
  }   
  public void getName()
  {
      System.out.println(name);
  }
  public void getType()
  {
      if(type == 1)
          System.out.println("Weapon");
      if(type == 2)
          System.out.println("Ranged Weapon");
      if(type == 3)
          System.out.println("Armor");
      if(type == 4)
          System.out.println("Consumable");
  }
  public void getStats(){
      System.out.println("\tHP: +" + this.ADD_hp + " and -" + this.SUB_hp + "\n\t Damage: +" + this.ADD_dmg + " and -" + this.SUB_dmg);
  }
  public int[] ADDstats(int[] stats)
  {
     
     if(type == 1 || type == 2)
     {
        int[] new_stats = new int[]{stats[0], stats[1], stats[2] + ADD_dmg - SUB_dmg, stats[3] + RED_dmg, stats[4]};  
        return new_stats;
     }
     else
     {
         int[] new_stats = new int[]{stats[0], stats[1] + ADD_hp - SUB_hp, stats[2] + ADD_dmg - SUB_dmg, stats[3] +RED_dmg, stats[4]};
         if(new_stats[1] > stats[0]){
             new_stats[1] = stats[0];
         }
         return new_stats;
     }
  }
  public int[] SUBstats(int[] stats)
  {
     
     if(type == 1 || type == 2)
     {
        int[] new_stats = new int[]{stats[0], stats[1], stats[2] - ADD_dmg + SUB_dmg, stats[3] - RED_dmg, stats[4]};  
        return new_stats;
     }
     else
     {
         int[] new_stats = new int[]{stats[0], stats[1] - ADD_hp + SUB_hp, stats[2] - ADD_dmg + SUB_dmg, stats[3] - RED_dmg, stats[4]};
         if(new_stats[1] <= 0){
             new_stats[1] = 1;
         }
         if(new_stats[1] > stats[0]){
             new_stats[1] = stats[0];
         }
         return new_stats;
     }
  }
  public Items[] ADDequipment(Items[] equipment) //
  {
      int full_slots = 0;
      Items[] new_equipment = (Items[]) new Items[equipment.length];   //create new object array to replace old (passed)
      
       System.arraycopy(equipment, 0, new_equipment, 0, new_equipment.length);  //make new array copy of old (passed) array (return passed array if array not null)
       
       for(int y = 0; y < new_equipment.length; y++)  //loop checks to see if equipment is already "full"
       {
           if(new_equipment[y]!=null)
            full_slots++;
       }
       
      if(full_slots == new_equipment.length)
      {
          System.out.println("\n\tYour equipment is full! cannot equip any more items!");
          return equipment;
      }
      
      for(int z = 0; z<new_equipment.length; z++)
      {
          if(new_equipment[z] == null)
          {
              new_equipment[z] = (Items) this;
              break;
          }
          
      }
      //System.out.println(Arrays.toString(new_equipment));
      return new_equipment;
  }
  public Items[] ADDinventory(Items[] inventory)//
  {
      int full_slots = 0;
      Items[] new_inventory = (Items[]) new Items[inventory.length];   //create new object array to replace old (passed)
      
       System.arraycopy(inventory, 0, new_inventory, 0, new_inventory.length);  //make new array copy of old (passed) array (return passed array if array not null)
       
       for(int y = 0; y<new_inventory.length; y++)  //loop checks to see if inventory is already "full"
       {
           if(new_inventory[y]!=null)
            full_slots++;
       }
       
      if(full_slots==new_inventory.length)
      {
          System.out.println("\n\tYour inventory is full! You cannot carry any more items!");
          return inventory;
      }
      
      for(int z = 0; z<new_inventory.length; z++)
      {
          if(new_inventory[z] == null)
          {
              new_inventory[z] = (Items) this;
              break;
          }
          
      }
      //System.out.println(Arrays.toString(new_inventory));
      return new_inventory;
  }
  public Items[] swapInventory(Items[] inventory, Items item) //command 
  {
      Items[] new_inventory = (Items[]) new Items[inventory.length];   //create new object array to replace old (passed)
      
      System.arraycopy(inventory, 0, new_inventory, 0, new_inventory.length);
      int temp = 0;
      for(int i = 0; i < new_inventory.length; i++)
      {
          if(new_inventory[i].equals(item))
          {
              new_inventory[i] = (Items) this;
              break;
          }
      }
      return new_inventory;
    }
  public Items[] dropInventory(Items[] inventory) //command "drop"
  {
      Items[] new_inventory = (Items[]) new Items[inventory.length];   //create new object array to replace old (passed)
      
      System.arraycopy(inventory, 0, new_inventory, 0, new_inventory.length);
      
      for(int i = 0; i < new_inventory.length; i++)
      {
          if(new_inventory[i] != null){
            if(new_inventory[i].equals(this))
            {
                new_inventory[i] = null;
                break;
            }
          }
          
      }
      return new_inventory;
  }
  public Items[] dropEquipment(Items[] equipment) //command "drop"
  {
      Items[] new_equipment = (Items[]) new Items[equipment.length];   //create new object array to replace old (passed)
      
      System.arraycopy(equipment, 0, new_equipment, 0, new_equipment.length);
      
      for(int i = 0; i < new_equipment.length; i++)
      {
          if(new_equipment[i] != null){
            if(new_equipment[i].equals(this))
            {
                new_equipment[i] = null;
                break;
            }
          }
          
      }
      return new_equipment;
  }
  public Items[][] equip(Items[] inventory, Items[] equipment) //command "equip (item name)"
  {
      int temp = 0;
      Items[] new_inventory = (Items[]) new Items[inventory.length];
      System.arraycopy(inventory, 0, new_inventory, 0, new_inventory.length);
      Items[] new_equipment = (Items[]) new Items[equipment.length];
      System.arraycopy(equipment, 0, new_equipment, 0, new_equipment.length);
       for(int i = 0; i < new_inventory.length; i++){
           if(new_inventory[i] != null){
            if(new_inventory[i].equals(this)) {
                 temp++;
                 break;
            }
           }
       }
      if(temp > 0){
          new_inventory = this.dropInventory(inventory);
          new_equipment = this.ADDequipment(equipment);
          return new Items[][]{new_inventory, new_equipment};
      }
      else{
          return new Items[][]{inventory, equipment};
      }
  }
  public Items[][] unequip(Items[] inventory, Items[] equipment) //command "unequip (item name)"
  {
      int temp = 0;
      Items[] new_inventory = (Items[]) new Items[inventory.length];
      System.arraycopy(inventory, 0, new_inventory, 0, new_inventory.length);
      Items[] new_equipment = (Items[]) new Items[equipment.length];
      System.arraycopy(equipment, 0, new_equipment, 0, new_equipment.length);
       for(int i = 0; i < new_equipment.length; i++){
           if(new_equipment[i] != null){
                if(new_equipment[i].equals(this)) {
                    temp++;
                    break;
                }
           }
       }
      if(temp > 0){
          new_equipment = this.dropEquipment(equipment);
          new_inventory = this.ADDinventory(inventory);
          return new Items[][]{new_inventory, new_equipment};
      }
      else{
          return new Items[][]{inventory, equipment};
      }
  }
  public boolean containedIn(Items[] array) //
  {
    for(int i = 0; i < array.length; i++){
        if(array[i].equals(this)) {
            return true;
        }
    }
    return false;
  }
  public boolean isFull(Items[] array){
      int full_slots = 0;
      for(int y = 0; y < array.length; y++)  //loop checks to see if inventory is already "full"
       {
           if(array[y]!=null)
                full_slots++;
       }
      if(full_slots == array.length)
          return true;
      else
          return false;
  }
    @Override
    public boolean equals(Object object) 
    {
        if(object instanceof Items) {
            Items i = (Items) object;
            return this.name.equals(i.name);
        }
        return false;
    }
    @Override
   public String toString() 
   {
       if (this != null)
           return (this.name);
       else
           return "Empty";
   }
   public boolean typeCheckRanged()
   {
      return this.type == 2;
   }
   public boolean typeCheckConsumable()
   {
       return this.type == 4;
   }
   
}
