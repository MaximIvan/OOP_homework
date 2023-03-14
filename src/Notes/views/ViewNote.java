package Notes.views;

import Notes.controllers.NoteController;
import Notes.data.Note;
import Notes.logger.Logger;
import java.util.Scanner;
import java.util.List;

public class ViewNote {
    private NoteController noteController;
    private Logger forLog;


    public ViewNote(NoteController noteController, Logger forLog) {
        this.noteController = noteController;
        this.forLog = forLog;
    }

    public void run() {
        Commands com = Commands.NONE;
        while (true) {
            String command = prompt("Введите команду: ");
            try {
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case WRITE: write();
                        break;
                    case READ: read();
                        break;
                    case LIST: list();
                        break;
                    case REWRITE: rewriteNote();
                        break;
                    case DELETE: deleteNote();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void deleteNote() {
        String readId = prompt("Введите ID записи которую надо удалить: ");
        noteController.deleteNote(readId);
        forLog.writeInFile("Удалили запись");
    }

    private Note inputNote() {
        String head = prompt("Заголовок: ");
        String text = prompt("Текст: ");
        String date = prompt("Дата: ");
        return new Note(head, text, date);
    }

    private void write() throws Exception {
        noteController.saveNote(inputNote());
        forLog.writeInFile("Добавили запись");
    }

    private void rewriteNote() throws Exception {
        String readId = prompt("Введите новый ID записи: ");
        noteController.rewriteNote(readId, inputNote());
        forLog.writeInFile("Исправлена запись");
    }

    private void list() {
        List<Note> listNotes = noteController.readAllNotes();
        for (Note note : listNotes) {
            System.out.println(note + "\n");
            forLog.writeInFile("Просмотр журнала заметок");
        }
    }

    private void read() throws Exception {
        String id = prompt("Введите индетификатор заметки: ");
            Note note = noteController.readNote(id);
            System.out.println(note);
        forLog.writeInFile("Просмотр заметки");
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
