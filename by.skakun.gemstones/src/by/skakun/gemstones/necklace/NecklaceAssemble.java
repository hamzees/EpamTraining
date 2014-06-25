package by.skakun.gemstones.necklace;

import by.skakun.gemstones.exception.NecklaceLogicException;
import org.apache.log4j.Logger;

/**
 * This class provides information about the necklace.
 *
 * @author skakun
 */
public class NecklaceAssemble {

    private static final Logger LOG = Logger.getLogger(NecklaceAssemble.class);

    public static void assembleInformation(Necklace nLace) throws NecklaceLogicException {
        if (nLace.getGems() == null) {
            throw new NecklaceLogicException("Дальнейшие действия невозможны.");
        } else {
            LOG.info(nLace.getType());
            LOG.info("Состав ожерелья" + nLace.getGems());
            LOG.info("Общая стоимость ожерелья: " + nLace.calculateTotalCost());
            LOG.info("Общий вес ожерелья: " + nLace.calculateTotalWeight());
            NecklaceSort.sortGemstonesByCost(nLace);
            LOG.info("Отсортировано по стоимости камней: \n" + nLace.getGems());
            LOG.info("Заданным условиям прозрачности в ожерелье "
                    + "отвечают следующие камни: \n" + NecklaceSort.selectGemsByOpacity(2, 4, nLace));

        }
    }

}
