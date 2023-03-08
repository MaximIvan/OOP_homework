package Notes.data;

import java.util.List;

public interface IRepo {
    List<Note> getAllNotes();
    String WriteNote (Note note);
    void saveNotes (List<Note> notes);
}
