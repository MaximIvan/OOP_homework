package Notes;

import Notes.controllers.NoteController;
import Notes.data.FileOperation;
import Notes.data.IFileOperation;
import Notes.data.IRepo;
import Notes.data.RepoFile;
import Notes.logger.ILogger;
import Notes.logger.Logger;
import Notes.views.ViewNote;

public class Main {

    public static void main (String[] args) {
        IFileOperation fileOperation = new FileOperation("C:\\Users\\Максим\\OneDrive\\Рабочий стол\\OOP_education\\Homeworks\\src\\Notes\\notes.txt");
        IRepo repo = new RepoFile((FileOperation) fileOperation);
        NoteController controller = new NoteController(repo);
        ViewNote view = new ViewNote(controller, new Logger("C:\\Users\\Максим\\OneDrive\\Рабочий стол\\OOP_education\\Homeworks\\src\\Notes\\log.txt"));
        view.run();
    }
}
