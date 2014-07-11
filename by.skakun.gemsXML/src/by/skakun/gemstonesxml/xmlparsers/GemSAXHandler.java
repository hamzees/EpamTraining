package by.skakun.gemstonesxml.xmlparsers;

import by.skakun.gemstonesxml.entity.ArtificialGem;
import by.skakun.gemstonesxml.entity.Gem;
import by.skakun.gemstonesxml.entity.GemEnum;
import by.skakun.gemstonesxml.entity.RealPreciousGem;
import by.skakun.gemstonesxml.entity.SemiPreciousGem;
import by.skakun.gemstonesxml.entity.ToughnessType;
import by.skakun.gemstonesxml.exception.GemLogicException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GemSAXHandler extends DefaultHandler {

    private String id = null;
    private int cost = 0;
    private double weight = 0;
    private int opacity = 0;
    private String color = null;
    private String name = null;
    private String cutMethod = null;
    private ToughnessType toughness;
    private String symbol = null;
    private String fieldOrigin = null;
    private int age = 0;
    private Set<Gem> gems;
    private Gem current = null;

    private GemEnum currentEnum;
    private EnumSet<GemEnum> withText;

    public GemSAXHandler() {
        gems = new HashSet<>();
        withText = EnumSet.range(GemEnum.WEIGHT, GemEnum.AGE);
    }

    public void setGems(Set<Gem> gems) {
        this.gems = gems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (localName.equalsIgnoreCase("realpreciousgem")) {
            id = attrs.getValue(0);
        } else if ("artificialgem".equals(localName)) {
            id = attrs.getValue(0);
        } else if ("semipreciousgem".equals(localName)) {
            id = attrs.getValue(0);
        } else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (localName.equalsIgnoreCase("realpreciousgem")) {
            try {
                current = new RealPreciousGem(id, fieldOrigin, toughness, cutMethod, cost, weight, opacity, color, name);
            } catch (GemLogicException ex) {
                System.out.println("ошибка создания камня");
            }
            gems.add(current);
        } else if ("artificialgem".equals(localName)) {
            try {
                current=new ArtificialGem(id, age, toughness, cutMethod, cost, weight, opacity, color, name);
            } catch (GemLogicException ex) {
                System.out.println("ошибка создания камня");
            }
            gems.add(current);
        } else if ("semipreciousgem".equals(localName)) {
            try {
                current=new SemiPreciousGem(id, symbol, cost, weight, opacity, color, name);
            } catch (GemLogicException ex) {
                System.out.println("ошибка создания камня");
            }
            gems.add(current);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    if (!s.equals("")) {
                        name = s;
                    }
                    break;
                case CUTMETHOD:
                    if (!s.equals("")) {
                        cutMethod = s;
                    }
                    break;
                case FIELDORIGIN:
                    if (!s.equals("")) {
                        fieldOrigin = s;
                    }
                    break;
                case SYMBOL:
                    if (!s.equals("")) {
                        symbol = s;
                    }
                    break;
                case COLOR:
                    if (!s.equals("")) {
                        color = s;
                    }
                    break;
                case COST:
                    if (!s.equals("")) {
                        cost = Integer.parseInt(s);
                    }
                    break;
                case WEIGHT:
                    if (!s.equals("")) {
                        weight = Double.parseDouble(s);
                    }
                    break;
                case OPACITY:
                    if (!s.equals("")) {
                        opacity = Integer.parseInt(s);
                    }
                    break;
                case TOUGHNESS:
                    if (!s.equals("")) {
                        toughness = ToughnessType.valueOf(s.toUpperCase());
                    }
                    break;
                case AGE:
                    if (!s.equals("")) {
                        age = Integer.parseInt(s);
                    }
                    break;
            }

        }

    }

    public Set<Gem> getGems() {
        return gems;
    }
}
