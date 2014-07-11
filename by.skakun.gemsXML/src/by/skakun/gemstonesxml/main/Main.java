package by.skakun.gemstonesxml.main;

import by.skakun.gemstonesxml.xmlparsers.AbstractNecklaceBuilder;
import by.skakun.gemstonesxml.xmlparsers.NecklaceBuilderFactory;
import by.skakun.gemstonesxml.xmlvalidating.ValidatingGem;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    
    public static void main(String[] args) {
        Logger LOG = Logger.getLogger(Main.class.getName());
        new DOMConfigurator().doConfigure("src/properties/log4j.xml", LogManager.getLoggerRepository());

        NecklaceBuilderFactory nFactory = new NecklaceBuilderFactory();
        //case StAX
        AbstractNecklaceBuilder builder = nFactory.createNecklaceBuilder("stax");
        builder.buildSetGems("src/resources/necklace.xml");
        //case DOM
        builder = nFactory.createNecklaceBuilder("dom");
        builder.buildSetGems("src/resources/necklace.xml");
        //case SAX
        builder = nFactory.createNecklaceBuilder("sax");
        builder.buildSetGems("src/resources/necklace.xml");
        //validating necklace.xml with gem.xsd
        ValidatingGem vg = new ValidatingGem();
    }

}
