package Notes.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
public class Logger implements ILogger {
    private String logfilename;

    public Logger(String logfilename) {
        this.logfilename = logfilename;
    }

    @Override
    public void writeInFile(String action) {
        try{
            FileWriter writer = new FileWriter(logfilename, true);
            LocalDateTime eventTime = LocalDateTime.now();
            writer.write(String.format("%s %s \n", eventTime, action));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

