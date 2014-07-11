package by.skakun.gemstonesxml.xmlvalidating;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

public class ValidatingGem {

    private String filename = "src/resources/necklace.xml";
    private String schemaname = "src/resources/gem.xsd";
    private String logname = "log.txt";
    public Schema schema = null;
    private String language = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;
    private SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    public ValidatingGem() {
        System.out.println("Проверяем на валидность xml-документ.");
        try {
            schema = factory.newSchema(new File(schemaname));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(filename, new ValidatingGemHandler(logname));
            System.out.println(filename + " is valid.");

        } catch (ParserConfigurationException ex) {
            System.out.println("ParserConfigurationException" + ex);

        } catch (SAXException ex) {
            System.out.println("SAXException" + ex);

        } catch (IOException ex) {
            System.out.println("IOException" + ex);
        }

    }
}
