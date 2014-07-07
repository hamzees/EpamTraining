package by.skakun.textparser.subtask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;

public class TextWriter {

    public static final Logger LOG = Logger.getLogger(TextWriter.class.getName());

    public static void textWrite(String text) {
        FileWriter wrt = null;
        try {
            File flt = new File("out.txt");
            wrt = new FileWriter(flt);
            wrt.append(text);
            wrt.flush();
            System.out.println("Данные записаны в файл out.txt");
        } catch (IOException ex) {
            LOG.info("Ошибка записи в файл");
        } finally {
            try {
                wrt.close();
            } catch (IOException ex) {
                LOG.info("Не получилось закрыть соединение с файлом");
            }
        }

    }
}
