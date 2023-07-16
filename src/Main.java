import Controller.NotesController;
import database.database;
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        database db = new database();
        if(db.openDB())
        {
            NotesController notes = new NotesController(db);
            view note = new view(notes);
            note.Run();
        }

    }
}