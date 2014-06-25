package by.skakun.gemstones.main;

import by.skakun.gemstones.builder.GemBaseBuilder;
import by.skakun.gemstones.builder.RealPreciousGemBuilder;
import by.skakun.gemstones.exception.NecklaceLogicException;
import by.skakun.gemstones.necklace.Necklace;
import by.skakun.gemstones.necklace.NecklaceAssemble;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @author skakun
 */
public class Main {

    public static final Logger LOG = Logger.getLogger(Main.class.getName());

    private static Necklace buildNecklace(GemBaseBuilder builder) {
        builder.buildType();
        builder.buildGems();
        return builder.getNecklace();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
        try {
            Necklace necklaceRPG = buildNecklace(new RealPreciousGemBuilder());
            NecklaceAssemble.assembleInformation(necklaceRPG);
        } catch (NecklaceLogicException ex) {
            LOG.warn("Проверьте правильность введенных данных. " + ex);
        }

    }

}
