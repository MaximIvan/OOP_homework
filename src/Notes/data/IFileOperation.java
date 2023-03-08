package Notes.data;

import java.util.List;

public interface IFileOperation {
    List<String> readAllLines();

    void saveAllLines(List<String> lines);
}
