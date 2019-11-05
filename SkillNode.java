package software.engineer.and.practice;
import java.util.*;

public class SkillNode {
    public SkillNode parent, left2, left, center, right, right2;
    public List<SkillNode> children = null;
    public Skills skill;
    public SkillNode(Skills skill){
        this.children = new ArrayList<>();
        this.skill = skill;
        this.parent = null;
        this.left2 = null;
        this.left = null;
        this.center = null;
        this.right = null;
        this.right2 = null;
    }
    public void addChild(SkillNode child){
        children.add(child);
        child.parent = this;
    }
    public List<SkillNode> getChildren() {
        return children;
    }
    public boolean hasChildren(){
        return this.children != null;
    }
    public SkillNode getParent(){
        return this.parent;
    }
    public boolean hasParent(){
        return this.parent != null;
    }
    public String getSkill(){
        return skill.name;
    }
}
