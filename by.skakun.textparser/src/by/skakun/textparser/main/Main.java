package by.skakun.textparser.main;

import by.skakun.textparser.entity.TextComposite;
import by.skakun.textparser.parser.TextParser;
import by.skakun.textparser.subtask.TextScanner;
import by.skakun.textparser.subtask.SentenceSorting;
import by.skakun.textparser.subtask.TextWriter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    public static final Logger LOG = Logger.getLogger(Main.class.getName());

    static {
        new DOMConfigurator().doConfigure("src/properties/log4j.xml", LogManager.getLoggerRepository());
    }

    /**
     * @param args the command line arguments args[0] - имя текста для
     * считывания src/resources/text.txt
     */
    public static void main(String[] args) {
        String textForParsing;
        TextComposite text;
        LOG.info("Начинаем считывать текст...");
        textForParsing = TextScanner.readFile(args[0]).trim().replaceAll("\t", " ").replaceAll(" +", " ").replaceAll("\n+", "\n");
        text = TextParser.parseForParagraphsAndCode(textForParsing);
        LOG.info("Текст в первоначальном виде(за исключением пробелов между элементами):\n" + text.getContent());
        TextWriter.textWrite(text.getContent());
        SentenceSorting.sortSentences(text);
    }
}
