import java.util.Scanner;

import Animals.*;
import Controller.NotesController;

import static java.time.chrono.JapaneseEra.values;

public class view implements viewInterface{
    protected NotesController notes;

    public view(NotesController notes) {
        this.notes = notes;
    }

    public enum animals {
        собака,
        кот,
        кошка,
        хомяк,
        лошадь,
        верблюд,
        осел,
        осёл;
    }
    public void Run()
    {
        int com;
        while (true)
        {
            this.menu();
            String command = prompt("Введите команду: ");

            try {
                com = this.validation(command);
                switch(com)
                {
                    case 5: {
                        this.notes.closeDB();
                        return;
                    }
                    case 1:
                        this.addAnimal();
                        break;
                    case 2:
                        this.deleteAnimal();
                        break;
                    case 3:
                        this.viewSkillAnimal();
                        break;
                    case 4:
                        this.addSkillAnimal();
                        break;
                }
            }catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private void menu() {
        System.out.println("Меню:");
        System.out.println("1 - Добавить животное");
        System.out.println("2 - Удалить животное");
        System.out.println("3 - Просмотреть список навыков животного");
        System.out.println("4 - Добавить навык животному");
        System.out.println("5 - Выход");
    }

    private int validation(String str)
    {
        int result = 0;
        try {
            result = Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Вы ввели недопустимое значение");
            return -1;
        }
        if(result < 1 && result > 5)
        {
            System.out.println("Выбранный вами пункт отсутствует в меню");
            return -1;
        }
        return result;
    }

    private int validationID(String str)
    {
        int result = 0;
        try {
            result = Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Введенное вами значение не является целочисленным числом");
            return -1;
        }
        return result;
    }
    private boolean validationAnimals(String text)
    {
        String str = text.toLowerCase();
        for (animals animal: animals.values())
        {
            if (animal.name().equals(str)) return true;
        }

        return false;
    }

    @Override
    public void addAnimal() {
        String animal;
        while(true)
        {
            animal = this.prompt("Введите название животного: ");
            if (this.validationAnimals(animal)) break;
            System.out.println("Введённое вами животное отсутствует.\nПопробуйте снова!!!");
        }

        String name = this.prompt("Введите имя животного: ");
        String skill = this.prompt("Введите навыки животного: ");
        String dateofbirth = this.prompt("Введите дату рождения животного: ");
        System.out.println(animal+" "+name+" "+skill);
        animals cmd;
        cmd = animals.valueOf(animal);
        switch (cmd)
        {
            case собака:
                this.notes.InsertAnimal(new Dog(name, skill, dateofbirth));
                break;
            case кот:
                this.notes.InsertAnimal(new Cat(name, skill, dateofbirth));
                break;
            case хомяк:
                this.notes.InsertAnimal(new Hamster(name, skill, dateofbirth));
                break;
            case осел:
                this.notes.InsertAnimal(new Donkey(name, skill, dateofbirth));
                break;
            case осёл:
                this.notes.InsertAnimal(new Donkey(name, skill, dateofbirth));
                break;
            case лошадь:
                this.notes.InsertAnimal(new Hamster(name, skill, dateofbirth));
                break;
            case верблюд:
                this.notes.InsertAnimal(new Camel(name, skill, dateofbirth));
                break;
        }
    }

    @Override
    public void deleteAnimal(){
        int id = 0;
        String str;
        while(true)
        {
            str = this.prompt("Введите номер id записи: ");
            id = this.validationID(str);
            if (id != -1) break;
        }
        this.notes.deleteAnimal(id);
    }

    @Override
    public void addSkillAnimal() {
        String str;
        int id = 0;
        while(true)
        {
            str = this.prompt("Введите номер id записи: ");
            id = this.validationID(str);
            if (id != -1) break;
        }

        String skill = this.prompt("Введите навык: ");
        this.notes.addSkill(id, skill);
    }

    @Override
    public void viewSkillAnimal() {
        String str;
        int id = 0;
        while(true)
        {
            str = this.prompt("Введите номер id записи: ");
            id = this.validationID(str);
            if (id != -1) break;
        }
        this.notes.readAnimal(id);
    }
}
