package Animals;

public class Donkey extends Animal {
    private int parent_id = 10;

    public Donkey(String name, String skill, String dateofbirth) {
        this.name = name;
        this.skill = skill;
        this.dateofbirth = dateofbirth;
    }

    public int getParent_id() {
        return this.parent_id;
    }
}
