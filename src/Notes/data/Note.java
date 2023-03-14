package Notes.data;
import java.sql.Date;

public class Note {

    private String id = "";
    private String head;
    private String text;
    private String date;

    public Note(String head, String text, String date) {
        this.head = head;
        this.text = text;
        this.date = date;
    }

    public Note(String id, String head, String text, String date) {
        this(head, text, date);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Идентификатор: %s\nЗаголовок: %s,\nЗаметка: %s,\nДата: %s", id, head, text, date);
    }
}
