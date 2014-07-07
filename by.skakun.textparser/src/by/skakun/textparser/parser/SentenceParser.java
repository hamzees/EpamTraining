package by.skakun.textparser.parser;

import by.skakun.textparser.entity.TextComposite;
import by.skakun.textparser.entity.TextElement;
import by.skakun.textparser.entity.TextComponent;
import by.skakun.textparser.entity.TypeOfText;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(SentenceParser.class);

    public static TextComposite parseForWords(String string, String wordRegex, String punctRegex) {
        StringBuilder sb = new StringBuilder();
        ArrayList<TextComponent> wordsAndPunctuations = new ArrayList<>();
        Pattern wordPattern = Pattern.compile(wordRegex + "|"
                + punctRegex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher wordMatcher = wordPattern.matcher(string);
        while (wordMatcher.find()) {
            String wordOrPunct = wordMatcher.group();
            if (Pattern.matches(punctRegex, wordOrPunct)) {
                wordsAndPunctuations.add(new TextElement(TypeOfText.PUNCTUATION_MARK, wordMatcher.group()));
                LOG.info("\t\t" + "Знак препинания" + ": " + wordMatcher.group());
                sb.append(wordMatcher.group());
            } else {
                wordsAndPunctuations.add(new TextElement(TypeOfText.WORD, wordMatcher.group()));
                LOG.info("\t\t" + "Слово" + ": " + wordMatcher.group());
                sb.append(" ").append(wordMatcher.group());
            }

        }
        TextComposite sentence = new TextComposite(wordsAndPunctuations, TypeOfText.SENTENCE);
        sentence.setContent(sb.toString());
        return sentence;
    }

}
