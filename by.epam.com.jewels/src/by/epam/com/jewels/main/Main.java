package by.epam.com.jewels.main;


import by.epam.com.jewels.builder.ArtificialGemsBuilder;
import by.epam.com.jewels.builder.GemsBaseBuilder;
import by.epam.com.jewels.builder.RealPreciousGemsBuilder;
import by.epam.com.jewels.builder.SemiPreciousGemsBuilder;
import by.epam.com.jewels.necklace.Necklace;
import org.apache.log4j.Logger;

/**
 *
 * @author skakun
 */
public class Main {
static Logger log = Logger.getLogger(Main.class.getName());

    private static Necklace buildNecklace(GemsBaseBuilder builder) {
        builder.buildType();
        builder.buildGems();
        return builder.getNecklace();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Necklace necklaceRPG = buildNecklace(new RealPreciousGemsBuilder());
        log.info(necklaceRPG.getType());
        log.info("Состав ожерелья" + necklaceRPG.getGems());
        log.info("Общая стоимость ожерелья: " + necklaceRPG.totalCost());
        log.info("Общий вес ожерелья: " + necklaceRPG.totalWeight());
        
        necklaceRPG.sortGemstonesByCost();
        log.info("Отсортировано по стоимости камней: \n" + necklaceRPG.getGems());

        log.info("Заданным условиям прозрачности в ожерелье "
                + "отвечают следующие камни: \n" + necklaceRPG.collectByOpacity(2,4));
        
        Necklace necklaceSPG = buildNecklace(new SemiPreciousGemsBuilder());
        log.info(necklaceSPG.getType());
        log.info("Состав ожерелья" + necklaceSPG.getGems());
        log.info("Общая стоимость ожерелья: " + necklaceSPG.totalCost());
        log.info("Общий вес ожерелья: " + necklaceSPG.totalWeight());
        
        necklaceRPG.sortGemstonesByCost();
        log.info("Отсортировано по стоимости камней: \n" + necklaceSPG.getGems());

        log.info("Заданным условиям прозрачности в ожерелье "
                + "отвечают следующие камни: \n" + necklaceSPG.collectByOpacity(-1,3));
        
        Necklace necklaceAPG = buildNecklace(new ArtificialGemsBuilder());
        log.info(necklaceAPG.getType());
        log.info("Состав ожерелья" + necklaceAPG.getGems());
        log.info("Общая стоимость ожерелья: " + necklaceAPG.totalCost());
        log.info("Общий вес ожерелья: " + necklaceAPG.totalWeight());
        
        necklaceRPG.sortGemstonesByCost();
        log.info("Отсортировано по стоимости камней: \n" + necklaceAPG.getGems());

        log.info("Заданным условиям прозрачности в ожерелье "
                + "отвечают следующие камни: \n" + necklaceAPG.collectByOpacity(2,4));
    }

}
