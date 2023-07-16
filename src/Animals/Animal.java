package Animals;

public abstract class Animal {
    protected String name;
    protected String skill;
    protected String dateofbirth;

    public String getName()
    {
        return this.name;
    }
    public String getSkill() {
        return  this.skill;
    }

    public String getDateOfBirth() {
        return this.dateofbirth;
    }
}
