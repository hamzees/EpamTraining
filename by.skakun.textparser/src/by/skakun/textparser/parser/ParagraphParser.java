/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.skakun.textparser.parser;

import by.skakun.textparser.entity.Text;
import by.skakun.textparser.entity.TextPart;
import java.util.ArrayList;

/**
 *
 * @author apple
 */
public class ParagraphParser implements IParser {

    ArrayList<TextPart> paragraphs = new ArrayList<>();

    public void parse(Text text) {
        text.getContent().toString().split(System.getProperty("line.separator"));
    }
    Text text;

    text.createNewParagraphsList (paragraphs.length);
    for (String paragraph : paragraphs) {
            if (paragraph.length() > 0) {
            text.addPart(new Paragraph(paragraph));
        }
    }

}
