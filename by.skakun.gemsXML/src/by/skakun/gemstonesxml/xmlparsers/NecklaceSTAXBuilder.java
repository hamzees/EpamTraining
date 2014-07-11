package by.skakun.gemstonesxml.xmlparsers;

import by.skakun.gemstonesxml.entity.ArtificialGem;
import by.skakun.gemstonesxml.entity.Gem;
import by.skakun.gemstonesxml.entity.GemEnum;
import by.skakun.gemstonesxml.entity.RealPreciousGem;
import by.skakun.gemstonesxml.entity.SemiPreciousGem;
import by.skakun.gemstonesxml.entity.ToughnessType;
import by.skakun.gemstonesxml.exception.GemLogicException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.log4j.Logger;

public class NecklaceSTAXBuilder extends AbstractNecklaceBuilder {

 //   public static final Logger LOG = Logger.getLogger(NecklaceSTAXBuilder.class.getName());

    private XMLInputFactory inputFactory;

    public NecklaceSTAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public NecklaceSTAXBuilder(Set<Gem> gems) {
        super(gems);
    }

    @Override
    public void buildSetGems(String fileName) {
        System.out.println("StAX-парсер.");
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {

            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase()) == GemEnum.REALPRECIOUSGEM) {
                        Gem gem = buildGem(reader, GemEnum.REALPRECIOUSGEM);
                        gems.add(gem);
                    }
                    if (GemEnum.valueOf(name.toUpperCase()) == GemEnum.ARTIFICIALGEM) {
                        Gem gem = buildGem(reader, GemEnum.ARTIFICIALGEM);
                        gems.add(gem);
                    }
                    if (GemEnum.valueOf(name.toUpperCase()) == GemEnum.SEMIPRECIOUSGEM) {
                        Gem gem = buildGem(reader, GemEnum.SEMIPRECIOUSGEM);
                        gems.add(gem);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
      //      LOG.info("Файл для парсинга не найден");
        } catch (XMLStreamException ex) {
        //    LOG.info("Ошибка чтения XML-документа");
        } catch (GemLogicException ex) {
        //    LOG.info("Ошибка создания ожерелья");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка");
            }
        }
        collectNecklace();
    }

    private Gem buildGem(XMLStreamReader reader, GemEnum gemType) throws XMLStreamException, GemLogicException {
       // System.out.println(gemType);
        String id;
        int cost = 0;
        double weight = 0;
        int opacity = 0;
        String color = null;
        String name = null;
        String cutMethod = null;
        ToughnessType toughness = null;
        String symbol = null;
        String fieldOrigin = null;
        int age = 0;
        id = reader.getAttributeValue(null, GemEnum.ID.getValue());
        String eName;
        Gem gem = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    eName = reader.getLocalName();
                    switch (GemEnum.valueOf(eName.toUpperCase())) {
                        case COLOR:
                            color = getXMLText(reader);
                           // gem.setColor(color);
                            break;
                        case NAME:
                            name = getXMLText(reader);
                            break;
                        case CUTMETHOD:
                            cutMethod = getXMLText(reader);
                            break;
                        case SYMBOL:
                            symbol = getXMLText(reader);
                            break;
                        case FIELDORIGIN:
                            fieldOrigin = getXMLText(reader);
                            break;
                        case COST:
                            eName = getXMLText(reader);
                            cost = Integer.parseInt(eName);
                            break;
                        case WEIGHT:
                            eName = getXMLText(reader);
                            weight = Integer.parseInt(eName);
                            break;
                        case OPACITY:
                            eName = getXMLText(reader);
                            opacity = Integer.parseInt(eName);
                            break;
                        case TOUGHNESS:
                            toughness = ToughnessType.valueOf(getXMLText(reader).toUpperCase());
                            break;
                        case AGE:
                            eName = getXMLText(reader);
                            age = Integer.parseInt(eName);
                           // ((ArtificialGem)gem).setAge(age);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    eName = reader.getLocalName();
                    if (GemEnum.valueOf(eName.toUpperCase()) == GemEnum.REALPRECIOUSGEM) {
                        gem = new RealPreciousGem(id, fieldOrigin, toughness, cutMethod, cost, weight, opacity, color, name);
                        return gem;
                    } else if (GemEnum.valueOf(eName.toUpperCase()) == GemEnum.SEMIPRECIOUSGEM) {
                        gem = new SemiPreciousGem(id, symbol, cost, weight, opacity, color, name);
                        return gem;
                    } else if (GemEnum.valueOf(eName.toUpperCase()) == GemEnum.ARTIFICIALGEM) {
                        gem = new ArtificialGem(id, age, toughness, cutMethod, cost, weight, opacity, color, name);
                        return gem;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Неизвестный элемент");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private void collectNecklace() {
        gems.stream().forEach((emp) -> {
            System.out.println(emp);
        });
    }
}
