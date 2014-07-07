package by.skakun.textparser.entity;

//неделемый
public class TextElement implements TextComponent {

    private TypeOfText type;
    private String content;

    public TextElement(TypeOfText tt, String content) {
        this.type = tt;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

    public TextElement() {
    }

    public TextElement(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void add(TextComponent tp) {
        TextElement textElement = new TextElement();
    }

}
