package by.skakun.textparser.entity;

import java.util.ArrayList;


public class TextComposite implements TextComponent {

    private ArrayList<TextComponent> elements;
    private TypeOfText type;
    private String content;

    public TypeOfText getType() {
        return type;
    }

    public void setType(TypeOfText type) {
        this.type = type;
    }

    public TextComposite(ArrayList<TextComponent> elements,TypeOfText type) {
        this.elements = elements;
        this.type=type;
        this.content=elements.toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
    public StringBuilder textToString() {
        StringBuilder sb=new StringBuilder();
        elements.stream().forEach((tp) -> {
            sb.append(tp);
        });
        return sb;
    }

    public void setElements(ArrayList<TextComponent> elements, TypeOfText type) {
        this.elements = elements;
        this.type=type;
    }

    public void createNewElementsList(int size) {
        elements = new ArrayList<>();
    }

    public ArrayList<TextComponent> getElements() {
        return elements;
    }

    public TextComposite() {
    }

    @Override
    public void add(TextComponent tp) {
        elements.add(tp);
        
    }

    public void remove(TextComponent t) {
        elements.remove(t);
    }

    

}
