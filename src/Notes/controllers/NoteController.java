package Notes.controllers;

import Notes.data.IRepo;
import Notes.data.Note;

import java.util.List;

public class NoteController {
    private final IRepo repo;

    public NoteController(IRepo repo) {
        this.repo = repo;
    }

    public void saveNote(Note note) throws Exception {
        repo.WriteNote(note);
    }

    public Note readNote(String noteId) throws Exception {
        List<Note> notes = repo.getAllNotes();
        Note note = noteSearch(noteId, notes);
        return note;
    }

    private Note noteSearch(String noteId, List<Note> notes) throws Exception {
        for (Note note: notes) {
            if (note.getId() == noteId) {
                return note;
            }
        }
        throw new Exception("Note not found");
    }
}