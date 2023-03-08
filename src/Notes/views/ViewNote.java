package Notes.views;

import Notes.controllers.NoteController;
import Notes.data.Note;

import java.util.Scanner;
import java.util.List;

public class ViewNote {
    private NoteController noteController;

    public ViewNote(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        Commands com = Commands.NONE;
        while (true) {
            String command = prompt("Введите команду: ");
            try {
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case WRITE -> write();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Note inputNote() {
        String head = prompt("Заголовок: ");
        String text = prompt("Текст: ");
        String date = prompt("Дата: ");
        return new Note(head, text, date);
    }

    private void write() throws Exception {
        noteController.saveNote(inputNote());
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
