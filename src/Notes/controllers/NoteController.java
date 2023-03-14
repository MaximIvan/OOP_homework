package Notes.controllers;

import Notes.data.IRepo;
import Notes.data.Note;

import java.util.ArrayList;
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

    private static Note noteSearch(String noteId, List<Note> notes) throws Exception {
        for (Note note: notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }
        throw new Exception("Note not found");
    }

    public void deleteNote(String readId) {
        List<Note> notes = repo.getAllNotes();
        List<Note> newNotes = new ArrayList<>();
        for (Note note : notes) {
            String tempId = note.getId();
            if (!tempId.equals(readId))
                newNotes.add(note);
        }
        repo.saveNotes(newNotes);
    }

    public List<Note> readAllNotes() {return repo.getAllNotes();}

    public void rewriteNote(String noteId, Note newNote) throws Exception {
        List<Note> notes = repo.getAllNotes();
        Note note = noteSearch(noteId, notes);
        note.setHead(newNote.getHead());
        note.setText(newNote.getText());
        note.setDate(newNote.getDate());
        repo.saveNotes(notes);
    }
}