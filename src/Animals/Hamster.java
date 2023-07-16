package Animals;

public class Hamster extends Animal {       //Хомяк
    private int parent_id = 7;

    public Hamster(String name, String skill, String dateofbirth) {
        this.name = name;
        this.skill = skill;
        this.dateofbirth = dateofbirth;
    }

    public int getParent_id() {
        return this.parent_id;
    }
}
