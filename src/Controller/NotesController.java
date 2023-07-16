package Controller;

import Animals.*;
import database.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class NotesController {
    private database db;
    private String mask = ":";

    public NotesController(database db) {
        this.db = db;
    }

    public void InsertAnimal(Dog obj)
    {
        String query = String.format("INSERT INTO pets(parent_id, name, skill, dateofbirth) VALUES(%d, '%s', '%s', '%s')",
                obj.getParent_id(), obj.getName(), obj.getSkill(), obj.getDateOfBirth());
        this.db.queryA(query);
    }

    public void InsertAnimal(Cat obj)
    {
        String query = String.format("INSERT INTO pets(parent_id, name, skill, dateofbirth) VALUES(%s, %s, %s, %s)",
                obj.getParent_id(), obj.getName(), obj.getSkill(), obj.getDateOfBirth());
        this.db.queryA(query);
    }

    public void InsertAnimal(Hamster obj)
    {
        String query = String.format("INSERT INTO pets(parent_id, name, skill, dateofbirth) VALUES(%s, %s, %s, %s)",
                obj.getParent_id(), obj.getName(), obj.getSkill(), obj.getDateOfBirth());
        this.db.queryA(query);
    }

    public void InsertAnimal(Donkey obj)
    {
        String query = String.format("INSERT INTO pets(parent_id, name, skill, dateofbirth) VALUES(%s, %s, %s, %s)",
                obj.getParent_id(), obj.getName(), obj.getSkill(), obj.getDateOfBirth());
        this.db.queryA(query);
    }

    public void InsertAnimal(Horse obj)
    {
        String query = String.format("INSERT INTO pets(parent_id, name, skill, dateofbirth) VALUES(%s, %s, %s, %s)",
                obj.getParent_id(), obj.getName(), obj.getSkill(), obj.getDateOfBirth());
        this.db.queryA(query);
    }

    public void InsertAnimal(Camel obj)
    {
        String query = String.format("INSERT INTO pets(parent_id, name, skill, dateofbirth) VALUES(%s, %s, %s, %s)",
                obj.getParent_id(), obj.getName(), obj.getSkill(), obj.getDateOfBirth());
        this.db.queryA(query);
    }

    public void deleteAnimal(int id)
    {
        String query = String.format("DELETE FROM pets WHERE id=%d", id);
        this.db.queryA(query);
    }

    public void readAnimal(int id)
    {
        String query = String.format("SELECT id, name, skill FROM pets WHERE id=%d", id);
        ResultSet rs = this.db.queryB(query);
        try {
            rs.first();
            String skill = "";
            String[] str = rs.getString("skill").split(":");
            for (String value : str)
                skill += value + " ";
            String result = String.format("id = %d\nИмя: %s\nНавык: %s",
                    rs.getInt("id"),
                    rs.getString("name"),
                    skill);
            System.out.println(result);
        } catch (SQLException e) {
            System.out.println("Нет записи");
        }
    }

    public void addSkill(int id, String text)
    {
        String query = String.format("SELECT skill FROM pets WHERE id=%d", id);
        ResultSet rs = this.db.queryB(query);
        String skill = "";
        try {
            rs.first();
            skill = rs.getString("skill") + this.mask + text;
        } catch (SQLException e) {
            System.out.println("Нет записи");
        }
        query = String.format("UPDATE pets SET skill='%s' where id=%d", skill, id);
        System.out.println(query);
        this.db.queryA(query);
    }

    public void closeDB() {
        this.db.closeDB();
    }
}
