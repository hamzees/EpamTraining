package by.skakun.gemswebxml.xmlparsers;

import by.skakun.gemswebxml.entity.ArtificialGem;
import by.skakun.gemswebxml.entity.Gem;
import by.skakun.gemswebxml.entity.GemEnum;
import by.skakun.gemswebxml.entity.RealPreciousGem;
import by.skakun.gemswebxml.entity.SemiPreciousGem;
import by.skakun.gemswebxml.entity.ToughnessType;
import by.skakun.gemswebxml.exception.GemLogicException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NecklaceDOMBuilder extends AbstractNecklaceBuilder {

    public static final Logger LOG = Logger.getLogger(NecklaceDOMBuilder.class.getName());
    private DocumentBuilder builder = null;

    public NecklaceDOMBuilder(Set<Gem> gems) {
        super(gems);
    }

    public NecklaceDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            LOG.info("Ошибка конфигурации парсинга");
        }
    }

    @Override
    public Set<Gem> buildSetGems(String fileName) {
        System.out.println("DOM-парсер.");
        Document document = null;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream(fileName);
            document = builder.parse(input);
        } catch (SAXException | IOException ex) {
            LOG.info("Ошибка чтения файла" + ex);
        }
        NodeList nodeList;
        nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node instanceof Element) {
                if (node.getNodeName().equals(GemEnum.REALPRECIOUSGEM.getValue())) {
                    try {
                        Gem gem = buildGem(node, GemEnum.REALPRECIOUSGEM);
                        gems.add(gem);
                    } catch (GemLogicException ex) {
                        LOG.info("Ошибка при создании камня");
                    }

                }
                if (node.getNodeName().equals(GemEnum.ARTIFICIALGEM.getValue())) {
                    try {
                        Gem gem = buildGem(node, GemEnum.ARTIFICIALGEM);
                        gems.add(gem);
                    } catch (GemLogicException ex) {
                        LOG.info("Ошибка при создании камня");
                    }

                }
                if (node.getNodeName().equals(GemEnum.SEMIPRECIOUSGEM.getValue())) {
                    try {
                        Gem gem = buildGem(node, GemEnum.SEMIPRECIOUSGEM);
                        gems.add(gem);
                    } catch (GemLogicException ex) {
                        LOG.info("Ошибка при создании камня");
                    }
                }
            }
        }
        collectNecklace();
        return gems;

    }

    private Gem buildGem(Node node, GemEnum type) throws GemLogicException {
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
        id = node.getAttributes().getNamedItem("id").getNodeValue();
        NodeList childNodes = node.getChildNodes();
        for (int j = 0; j < childNodes.getLength(); j++) {
            Node cNode = childNodes.item(j);
            if (cNode instanceof Element) {
                String content = cNode.getLastChild().
                        getTextContent().trim();
                switch (cNode.getNodeName()) {
                    case "name":
                        name = (content);
                        break;
                    case "weight":
                        weight = Double.parseDouble(content);
                        break;
                    case "color":
                        color = (content);
                        break;
                    case "cost":
                        cost = Integer.parseInt(content);
                        break;
                    case "opacity":
                        opacity = Integer.parseInt(content);
                        break;
                    case "symbol":
                        symbol = content;
                        break;
                    case "toughness":
                        toughness = ToughnessType.valueOf(content.toUpperCase());
                        break;
                    case "fieldOrigin":
                        fieldOrigin = (content);
                        break;
                    case "cutMethod":
                        cutMethod = (content);
                        break;
                    case "age":
                        age = Integer.parseInt(content);
                }

            }
        }
        Gem gem = null;
        if (type.equals(GemEnum.REALPRECIOUSGEM)) {
            gem = new RealPreciousGem(id, fieldOrigin, toughness, cutMethod, cost, weight, opacity, color, name);
            return gem;
        } else if (type.equals(GemEnum.SEMIPRECIOUSGEM)) {
            gem = new SemiPreciousGem(id, symbol, cost, weight, opacity, color, name);
            return gem;
        } else if (type.equals(GemEnum.ARTIFICIALGEM)) {
            gem = new ArtificialGem(id, age, toughness, cutMethod, cost, weight, opacity, color, name);
            return gem;
        }
        return gem;
    }

    private void collectNecklace() {
        gems.stream().forEach((emp) -> {
            System.out.println(emp);
        });
    }
}
