package Animals;

public class Horse extends Animal { //Лошадь
    private int parent_id = 7;

    public Horse(String name, String skill, String dateofbirth) {
        this.name = name;
        this.skill = skill;
        this.dateofbirth = dateofbirth;
    }

    public int getParent_id() {
        return this.parent_id;
    }
}
