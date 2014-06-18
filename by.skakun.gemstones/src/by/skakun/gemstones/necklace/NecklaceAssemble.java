package by.skakun.gemstones.necklace;
import org.apache.log4j.Logger;

/**
 * This class providea information about the necklace.
 *
 * @author skakun
 */
public class NecklaceAssemble {

    private static final Logger LOG = Logger.getLogger(NecklaceAssemble.class);

    public static void assembleInformation(Necklace nLace) {
        LOG.info(nLace.getType());
        LOG.info("Состав ожерелья" + nLace.getGems());
        LOG.info("Общая стоимость ожерелья: " + nLace.totalCost());
        LOG.info("Общий вес ожерелья: " + nLace.totalWeight());
        NecklaceSort.sortGemstonesByCost(nLace);
        LOG.info("Отсортировано по стоимости камней: \n" + nLace.getGems());
        try {
            LOG.info("Заданным условиям прозрачности в ожерелье "
                    + "отвечают следующие камни: \n" + NecklaceSort.collectByOpacity(1, 3, nLace));
        } catch (NumberFormatException ex) {
            LOG.debug("Неправильно введены границы прозрачности" + ex);
        }
    }

}
