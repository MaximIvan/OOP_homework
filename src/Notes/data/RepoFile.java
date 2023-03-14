package Notes.data;

import java.util.ArrayList;
import java.util.List;

public class RepoFile implements IRepo {
    private NoteMapper mapper = new NoteMapper();
    private FileOperation fileOperation;

    public RepoFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = fileOperation.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public String WriteNote(Note note) {
        List<Note> notes = getAllNotes();
        int max = 0;
        for (Note item: notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        saveNotes(notes);
        return id;
    }

    public void saveNotes(List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note item: notes) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }
}
