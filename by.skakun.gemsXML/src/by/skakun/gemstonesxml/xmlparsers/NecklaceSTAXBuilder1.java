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

public class NecklaceSTAXBuilder1 extends AbstractNecklaceBuilder {

    //   public static final Logger LOG = Logger.getLogger(NecklaceSTAXBuilder.class.getName());
    private XMLInputFactory inputFactory;

    public NecklaceSTAXBuilder1() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public NecklaceSTAXBuilder1(Set<Gem> gems) {
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
        String id;
        Gem gem = null;
        if (gemType.getValue().equals(GemEnum.REALPRECIOUSGEM.getValue())) {
            gem = new RealPreciousGem();
        } else if (gemType.getValue().equals(GemEnum.SEMIPRECIOUSGEM.getValue())) {
            gem = new SemiPreciousGem();
        } else if (gemType.getValue().equals(GemEnum.ARTIFICIALGEM.getValue())) {
            gem = new ArtificialGem();
        }
        gem.setId(reader.getAttributeValue(null, GemEnum.ID.getValue()));
        String eName;
        String k;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    eName = reader.getLocalName();
                    switch (GemEnum.valueOf(eName.toUpperCase())) {
                        case COLOR:
                            k = getXMLText(reader);
                            gem.setColor(k);
                            break;
                        case NAME:
                            k = getXMLText(reader);
                            gem.setName(k);
                            break;
                        case CUTMETHOD:
                            if (gemType.getValue().equals(GemEnum.REALPRECIOUSGEM.getValue())) {
                                ((RealPreciousGem) gem).setCutMethod(getXMLText(reader));
                            } else if (gemType.getValue().equals(GemEnum.ARTIFICIALGEM.getValue())) {
                                ((ArtificialGem) gem).setCutMethod(getXMLText(reader));
                            }
                            break;
                        case SYMBOL:
                        //    ((SemiPreciousGem) gem).setSymbol(getXMLText(reader));
                            break;
                        case FIELDORIGIN:
                            ((RealPreciousGem) gem).setFieldOrigin(getXMLText(reader));
                            break;
                        case COST:
                            gem.setCost(Integer.parseInt(getXMLText(reader)));
                            break;
                        case WEIGHT:
                            gem.setWeight(Integer.parseInt(getXMLText(reader)));
                            break;
                        case OPACITY:
                            gem.setOpacity(Integer.parseInt(getXMLText(reader)));
                            break;
                        case TOUGHNESS:
                            if (gemType.getValue().equals(GemEnum.REALPRECIOUSGEM.getValue())) {
                                ((RealPreciousGem) gem).setToughness(ToughnessType.valueOf(getXMLText(reader).toUpperCase()));
                            } else if (gemType.getValue().equals(GemEnum.ARTIFICIALGEM.getValue())) {
                                ((ArtificialGem) gem).setToughness(ToughnessType.valueOf(getXMLText(reader).toUpperCase()));
                            }
                            break;
                        case AGE:
                           // ((ArtificialGem) gem).setAge(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    break;

            }                    

        }                            return gem;


  //      throw new XMLStreamException("Неизвестный элемент");
        
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
