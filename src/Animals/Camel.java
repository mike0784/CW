package Animals;

public class Camel extends Animal {
    private int parent_id = 9;

    public Camel(String name, String skill, String dateofbirth) {
        this.name = name;
        this.skill = skill;
        this.dateofbirth = dateofbirth;
    }

    public int getParent_id() {
        return this.parent_id;
    }
}
