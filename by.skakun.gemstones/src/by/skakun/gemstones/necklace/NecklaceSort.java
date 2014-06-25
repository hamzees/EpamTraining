package by.skakun.gemstones.necklace;

import by.skakun.gemstones.entity.Gem;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.log4j.Logger;

/**
 * This class sorts the gems in the necklace by cost and opacity, and finds gems
 * with selected opacity
 *
 * @author skakun
 */
public class NecklaceSort {

    private static final Logger LOG = Logger.getLogger(NecklaceSort.class);

    /**
     * Sorts the gems in the necklace by their cost
     *
     * @param nLace is the necklace used
     */
    public static void sortGemstonesByCost(Necklace nLace) {

        LOG.info("Сортируем камни в ожерелье по стоимости.");
        ArrayList<Gem> gems = nLace.getGems();
        Collections.sort(gems, (Object o1, Object o2) -> {
            Gem g1 = (Gem) o1;
            Gem g2 = (Gem) o2;
            return (g1.getCost() - g2.getCost());
        });

    }

    /**
     *
     * @param min defines the minimum opacity for a gem to get into selection
     * @param max defines the maximum opacity for a gem to get into selection
     * @param nLace is the necklace used
     * @return the string of the gems, which are within the defined interval of
     * Opacity
     */
    public static StringBuilder selectGemsByOpacity(int min, int max, Necklace nLace) {

        StringBuilder k = new StringBuilder();
        nLace.getGems().stream().filter((item) -> ((item.getOpacity()
                > min) & (item.getOpacity() < max))).forEach((item) -> {
                    k.append(item.toString()).append(" ");
                });
        return k;

    }

}
