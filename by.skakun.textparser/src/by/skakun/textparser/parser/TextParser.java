package by.skakun.textparser.parser;

import by.skakun.textparser.entity.TextComposite;
import by.skakun.textparser.entity.TextElement;
import by.skakun.textparser.entity.TextComponent;
import by.skakun.textparser.entity.TypeOfText;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(TextParser.class);

    static Properties prop = new Properties();

    public static TextComposite parseForParagraphsAndCode(String string) {
        try {
            prop.load(new FileInputStream(new File("src/properties/text.properties")));
        } catch (IOException ex) {
            LOG.info("Ошибка чтения файла свойств");
        }
        String parRegex = prop.getProperty("paragraphRegex");
        String listRegex = prop.getProperty("listingRegex");
        String wordRegex = prop.getProperty("wordRegex");
        String punctRegex = prop.getProperty("punctuationRegex");
        String senRegex = prop.getProperty("sentenceRegex");

        LOG.info("Текст:");
        ArrayList<TextComponent> paragraphsAndListings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Pattern parPattern = Pattern.compile(listRegex + "|"
                + parRegex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher wordMatcher = parPattern.matcher(string);
        while (wordMatcher.find()) {
            String parOrListing = wordMatcher.group();
            if (Pattern.matches(listRegex, parOrListing)) {
                System.out.println("!!!");
                paragraphsAndListings.add(new TextElement(TypeOfText.LISTING, wordMatcher.group()));
                LOG.info("Код: " + wordMatcher.group());
                sb.append(wordMatcher.group().replaceAll("\t", " ").replaceAll(" ", ""));
            } else {
                paragraphsAndListings.add(ParagraphParser.parseForSentences(wordMatcher.group(),senRegex,wordRegex,punctRegex));
                LOG.info("Абзац: " + wordMatcher.group());
                sb.append(wordMatcher.group().replaceAll("\t", ""));
            }

        }
        TextComposite text = new TextComposite(paragraphsAndListings, TypeOfText.PARAGRAPH);
        text.setContent(sb.toString());
        LOG.info("Парсинг текста завершен.");
        return text;
    }
}
