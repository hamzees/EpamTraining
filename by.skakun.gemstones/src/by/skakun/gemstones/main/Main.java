package by.skakun.gemstones.main;

import by.skakun.gemstones.builder.ArtificialGemsBuilder;
import by.skakun.gemstones.builder.GemsBaseBuilder;
import by.skakun.gemstones.builder.RealPreciousGemsBuilder;
import by.skakun.gemstones.builder.SemiPreciousGemsBuilder;
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
    
    private static Necklace buildNecklace(GemsBaseBuilder builder) {
        builder.buildType();
        builder.buildGems();
        return builder.getNecklace();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
        
        Necklace necklaceRPG = buildNecklace(new RealPreciousGemsBuilder());
        NecklaceAssemble.assembleInformation(necklaceRPG);
        
        Necklace necklaceSPG = buildNecklace(new SemiPreciousGemsBuilder());
        NecklaceAssemble.assembleInformation(necklaceSPG);
        
        Necklace necklaceAPG = buildNecklace(new ArtificialGemsBuilder());
        NecklaceAssemble.assembleInformation(necklaceAPG);
        
    }
    
}
