
package by.epam.skakun.jewels.main;

import by.epam.skakun.jewels.builder.ArtificialGemsBuilder;
import by.epam.skakun.jewels.builder.GemsBaseBuilder;
import by.epam.skakun.jewels.builder.RealPreciousGemsBuilder;
import by.epam.skakun.jewels.builder.SemiPreciousGemsBuilder;
import by.epam.com.skakun.necklace.Necklace;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;


/**
 *
 * @author skakun
 */
public class Main {
    
    public static final Logger log=Logger.getLogger(Main.class.getName()); 

    
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
        log.info(necklaceRPG.getType());
        log.info("Состав ожерелья" + necklaceRPG.getGems());
        log.info("Общая стоимость ожерелья: " + necklaceRPG.totalCost());
        log.info("Общий вес ожерелья: " + necklaceRPG.totalWeight());
        
        necklaceRPG.sortGemstonesByCost();
        log.info("Отсортировано по стоимости камней: \n" + necklaceRPG.getGems());
        
        log.info("Заданным условиям прозрачности в ожерелье "
                + "отвечают следующие камни: \n" + necklaceRPG.collectByOpacity(2, 4));
        
        Necklace necklaceSPG = buildNecklace(new SemiPreciousGemsBuilder());
        log.info(necklaceSPG.getType());
        log.info("Состав ожерелья" + necklaceSPG.getGems());
        log.info("Общая стоимость ожерелья: " + necklaceSPG.totalCost());
        log.info("Общий вес ожерелья: " + necklaceSPG.totalWeight());
        
        necklaceRPG.sortGemstonesByCost();
        log.info("Отсортировано по стоимости камней: \n" + necklaceSPG.getGems());
        
        try {
            log.info("Заданным условиям прозрачности в ожерелье "
                    + "отвечают следующие камни: \n" + necklaceSPG.collectByOpacity(1, 3));
        } catch (NumberFormatException ex) {
            log.debug("Неправильно введены границы прозрачности" + ex);
        }
        
        Necklace necklaceAPG = buildNecklace(new ArtificialGemsBuilder());
        log.info(necklaceAPG.getType());
        log.info("Состав ожерелья" + necklaceAPG.getGems());
        log.info("Общая стоимость ожерелья: " + necklaceAPG.totalCost());
        log.info("Общий вес ожерелья: " + necklaceAPG.totalWeight());
        
        necklaceRPG.sortGemstonesByCost();
        log.info("Отсортировано по стоимости камней: \n" + necklaceAPG.getGems());
        
        log.info("Заданным условиям прозрачности в ожерелье "
                + "отвечают следующие камни: \n" + necklaceAPG.collectByOpacity(2, 4));
    }
    
}
