package by.skakun.textparser.subtask;

import by.skakun.textparser.entity.TextComposite;
import by.skakun.textparser.entity.TextComponent;
import java.util.ArrayList;
import java.util.Collections;

public class SentenceSorting {

    public static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(SentenceSorting.class);

    public static void sortSentences(TextComposite text) {
        LOG.info("Сортируем предложения по количеству слов в них:");
        ArrayList<TextComponent> tp = text.getElements();
        tp.stream().filter((textp) -> (textp.getClass().getSimpleName().equals(TextComposite.class.getSimpleName()))).map((textp)
                -> (TextComposite) textp).map((textc) -> {
                    sortSentencesByWordCount(textc);
                    return textc;
                }).forEach((textc) -> {
                    textc.getElements().stream().forEach((textcomp) -> {
                        TextComposite textc1 = (TextComposite) textcomp;
                        LOG.info(textc1.getContent());
                    });
                });

    }

    public static void sortSentencesByWordCount(TextComponent sentencesToSort) {
        TextComposite sentences = (TextComposite) sentencesToSort;
        Collections.sort(sentences.getElements(), (Object o1, Object o2) -> {
            TextComposite tp1 = (TextComposite) o1;
            TextComposite tp2 = (TextComposite) o2;
            return (tp2.getContent().lastIndexOf(" ") - tp1.getContent().lastIndexOf(" "));
        });

    }
}
