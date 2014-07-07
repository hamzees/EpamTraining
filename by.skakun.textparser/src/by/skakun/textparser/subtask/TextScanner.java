package by.skakun.textparser.subtask;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class TextScanner {

    public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(TextScanner.class);

    public static String readFile(String file) {
        
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(ls);
            }
        } catch (FileNotFoundException ex) {
            LOG.info("Файл не найден");
        } catch (UnsupportedEncodingException ex) {
            LOG.info("Неправильная кодировка считываемого файла");
        } catch (IOException ex) {
            LOG.info("Ошибка чтения файла");
        }
        return stringBuilder.toString();

    }
}
