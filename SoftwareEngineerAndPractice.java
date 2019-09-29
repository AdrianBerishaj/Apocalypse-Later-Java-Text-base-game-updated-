package software.engineer.and.practice;
public class SoftwareEngineerAndPractice {
    public static void main(String[] args) {
        Items chainmail = new Items("Chainmail", 3, 0, 0, 0, 0, 17);
        Items dummy = new Items("Dummy Item for Method Calling", 1, 0, 0, 0, 0, 0);
        Character player = new Character();
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
    }
}
