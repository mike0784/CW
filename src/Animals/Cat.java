package Animals;

public class Cat extends Animal {
    private int parent_id = 6;

    public Cat(String name, String skill, String dateofbirth) {
        this.name = name;
        this.skill = skill;
        this.dateofbirth = dateofbirth;
    }

    public int getParent_id() {
        return this.parent_id;
    }
}
