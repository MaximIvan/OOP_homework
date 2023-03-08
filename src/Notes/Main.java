package Notes;
import Notes.controllers.NoteController;
import Notes.data.FileOperation;
import Notes.data.IRepo;
import Notes.data.RepoFile;
import Notes.views.ViewNote;
public class Main {
   public static void main (String[] args) {
      FileOperation fileOperation = new FileOperation("C:\\Users\\Максим\\OneDrive\\Рабочий стол\\OOP_education\\Homeworks\\src\\Notes\\notes.txt");
      IRepo repo = new RepoFile(fileOperation);
      NoteController controller = new NoteController(repo);
      ViewNote view = new ViewNote(controller);
      view.run();

   }
}
