
package by.skakun.gemstones.main;

import by.skakun.gemstones.necklace.Necklace;
import by.skakun.gemstones.builder.ArtificialGemsBuilder;
import by.skakun.gemstones.builder.GemsBaseBuilder;
import by.skakun.gemstones.builder.RealPreciousGemsBuilder;
import by.skakun.gemstones.builder.SemiPreciousGemsBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;


/**
 *
 * @author skakun
 */
public class Main {
    
            public static final Logger LOG=Logger.getLogger(Main.class.getName()); 

    
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
        LOG.info(necklaceRPG.getType());
        LOG.info("Состав ожерелья" + necklaceRPG.getGems());
        LOG.info("Общая стоимость ожерелья: " + necklaceRPG.totalCost());
        LOG.info("Общий вес ожерелья: " + necklaceRPG.totalWeight());
        
        necklaceRPG.sortGemstonesByCost();
        LOG.info("Отсортировано по стоимости камней: \n" + necklaceRPG.getGems());
        
        LOG.info("Заданным условиям прозрачности в ожерелье "
                + "отвечают следующие камни: \n" + necklaceRPG.collectByOpacity(2, 4));
        
        Necklace necklaceSPG = buildNecklace(new SemiPreciousGemsBuilder());
        LOG.info(necklaceSPG.getType());
        LOG.info("Состав ожерелья" + necklaceSPG.getGems());
        LOG.info("Общая стоимость ожерелья: " + necklaceSPG.totalCost());
        LOG.info("Общий вес ожерелья: " + necklaceSPG.totalWeight());
        
        necklaceRPG.sortGemstonesByCost();
        LOG.info("Отсортировано по стоимости камней: \n" + necklaceSPG.getGems());
        
        try {
            LOG.info("Заданным условиям прозрачности в ожерелье "
                    + "отвечают следующие камни: \n" + necklaceSPG.collectByOpacity(1, 3));
        } catch (NumberFormatException ex) {
            LOG.debug("Неправильно введены границы прозрачности" + ex);
        }
        
        Necklace necklaceAPG = buildNecklace(new ArtificialGemsBuilder());
        LOG.info(necklaceAPG.getType());
        LOG.info("Состав ожерелья" + necklaceAPG.getGems());
        LOG.info("Общая стоимость ожерелья: " + necklaceAPG.totalCost());
        LOG.info("Общий вес ожерелья: " + necklaceAPG.totalWeight());
        
        necklaceRPG.sortGemstonesByCost();
        LOG.info("Отсортировано по стоимости камней: \n" + necklaceAPG.getGems());
        
        LOG.info("Заданным условиям прозрачности в ожерелье "
                + "отвечают следующие камни: \n" + necklaceAPG.collectByOpacity(2, 4));
    }
    
}
