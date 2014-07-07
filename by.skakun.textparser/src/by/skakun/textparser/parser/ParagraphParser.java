package by.skakun.textparser.parser;

import by.skakun.textparser.entity.TextComposite;
import by.skakun.textparser.entity.TextComponent;
import by.skakun.textparser.entity.TypeOfText;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser {

    public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ParagraphParser.class);

    public static TextComposite parseForSentences(String string, String sentRegex, String wordRegex, String punctRegex) {
        ArrayList<TextComponent> sentences = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Pattern sentencePattern = Pattern.compile(sentRegex,
                Pattern.UNICODE_CHARACTER_CLASS);
        Matcher sentenceMatcher = sentencePattern.matcher(string);
        while (sentenceMatcher.find()) {
            sentences.add(SentenceParser.parseForWords(sentenceMatcher.group(), wordRegex, punctRegex));
            LOG.info("\t" + "Предложение" + ": " + sentenceMatcher.group());
        }
        TextComposite paragraph = new TextComposite(sentences, TypeOfText.PARAGRAPH);
        sentences.stream().forEach((tp) -> {
            TextComposite tp1 = (TextComposite) tp;
        });
        return paragraph;
    }
}
