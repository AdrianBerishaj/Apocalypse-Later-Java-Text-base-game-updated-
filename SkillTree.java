package software.engineer.and.practice;
import java.util.*;
public class SkillTree{
    Skills skill1 = new Skills("Boost ✓", 0, 0, true);
    Skills skill2 = new Skills("Shield Bash", 10, 0, true);
    Skills skill3 = new Skills("Firebolt", 15, 0, true);
    Skills skill4 = new Skills("Backstab", 15, 0, true);
    Skills skill5 = new Skills("Healing Word", 0, 15, true);
    Skills skill6 = new Skills("Precise Shot", 10, 0, true);
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
    SkillNode root = new SkillNode(skill1);
    SkillNode node11 = new SkillNode(skill2);
    SkillNode node12 = new SkillNode(skill3);
    SkillNode node13 = new SkillNode(skill4);
    SkillNode node14 = new SkillNode(skill5);
    SkillNode node15 = new SkillNode(skill6);
    SkillNode node21 = new SkillNode(skill7);
    SkillNode node22 = new SkillNode(skill8);
    SkillNode node23 = new SkillNode(skill9);
    SkillNode node24 = new SkillNode(skill10);
    SkillNode node25 = new SkillNode(skill11);
    SkillNode node26 = new SkillNode(skill12);
    SkillNode node27 = new SkillNode(skill13);
    SkillNode node28 = new SkillNode(skill14);
    SkillNode node29 = new SkillNode(skill15);
    SkillNode node210 = new SkillNode(skill16);
    public void genSkillTree(){
        root.addChild(node11);
        root.addChild(node12);
        root.addChild(node13);
        root.addChild(node14);
        root.addChild(node15);
        root.left2 = node11;
        root.left = node12;
        root.center = node13;
        root.right = node14;
        root.right2 = node15;
        node11.addChild(node21);
        node11.addChild(node22);
        node11.left = node21;
        node11.right = node22;
        node12.addChild(node23);
        node12.addChild(node24);
        node12.left = node23;
        node12.right = node24;
        node13.addChild(node25);
        node13.addChild(node26);
        node13.left = node25;
        node13.right = node26;
        node14.addChild(node27);
        node14.addChild(node28);
        node14.left = node27;
        node14.right = node28;
        node15.addChild(node29);
        node15.addChild(node210);
        node15.left = node29;
        node15.right = node210;
    }
    public void printTree() {
        int i = 0;
        Queue<SkillNode> currentLevel = new LinkedList<SkillNode>();
        Queue<SkillNode> nextLevel = new LinkedList<SkillNode>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            Iterator<SkillNode> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                SkillNode currentNode = iter.next();
                if (currentNode.left2 != null) {
                    nextLevel.add(currentNode.left2);
                }
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                if (currentNode.right2 != null) {
                    nextLevel.add(currentNode.right2);
                }
                System.out.print(currentNode.getSkill() + "  ");
                i++;
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<SkillNode>();
        }
    }
    public void skillGet(Skills temp){
        Queue<SkillNode> level	= new LinkedList<>();
	level.add(root);	 
	while(!level.isEmpty()){
            SkillNode node = level.poll();
            if(node.skill.getName().equalsIgnoreCase(temp.getName()))
                node.skill.changeName(node.skill.getName().concat(" ✓"));
            if(node.left2!= null){
                if(node.left2.skill.getName().equalsIgnoreCase(temp.getName())){
                    node.left2.skill.changeName(node.left2.skill.getName().concat(" ✓"));
                    break;
                }
                else
                    level.add(node.left2);
            }
            if(node.left!= null){
                if(node.left.skill.getName().equalsIgnoreCase(temp.getName())){
                    node.left.skill.changeName(node.left.skill.getName().concat(" ✓"));
                    break;
                }
                else
                    level.add(node.left);
            }
            if(node.right!= null){
                if(node.right.skill.getName().equalsIgnoreCase(temp.getName())){
                    node.right.skill.changeName(node.right.skill.getName().concat(" ✓"));
                    break;
                }
                else
                    level.add(node.right);
            }
            if(node.right2!= null){
                if(node.right2.skill.getName().equalsIgnoreCase(temp.getName())){
                    node.right2.skill.changeName(node.right2.skill.getName().concat(" ✓"));
                    break;
                }
                else
                    level.add(node.right2);
            }
        }
    }
    public boolean skillAvailable(Skills temp){
        int i = 0;
        Queue<SkillNode> currentLevel = new LinkedList<SkillNode>();
        Queue<SkillNode> nextLevel = new LinkedList<SkillNode>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            Iterator<SkillNode> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                SkillNode currentNode = iter.next();
                if (currentNode.left2 != null) {
                    nextLevel.add(currentNode.left2);
                }
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                if (currentNode.right2 != null) {
                    nextLevel.add(currentNode.right2);
                }
                if(currentNode.skill.getName().equalsIgnoreCase(temp.getName()) && currentNode.hasParent()){
                    if(currentNode.getParent().skill.name.contains("✓"))
                        return true;
                }
                i++;
            }
            currentLevel = nextLevel;
            nextLevel = new LinkedList<SkillNode>();
        }
        return false;
    }
}
