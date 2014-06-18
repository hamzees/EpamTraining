package by.skakun.gemstones.necklace;

import by.skakun.gemstones.entities.Gem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
     * Sorts the gems in the necklace by the cost
     *
     * @param nLace is the necklace used
     */
    public static void sortGemstonesByCost(Necklace nLace) {
        LOG.info("Сортируем камни в ожерелье по стоимости.");
        ArrayList<Gem> gems = nLace.getGems();
        Collections.sort(gems, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Gem g1 = (Gem) o1;
                Gem g2 = (Gem) o2;
                return (g1.getCost() - g2.getCost());

            }
        });
    }

    /**
     * Sorts the gems in the necklace by the opacity
     *
     * @param nLace is the necklace used
     */
    public static void sortGemstonesByOpacity(Necklace nLace) {
        LOG.info("Сортируем камни в ожерелье по прозрачности.");
        ArrayList<Gem> gems = nLace.getGems();
        Collections.sort(gems, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Gem g1 = (Gem) o1;
                Gem g2 = (Gem) o2;
                return (g1.getOpacity() - g2.getOpacity());
            }
        });
    }

    /**
     *
     * @param min defines the minimum opacity for a gem to get into selection
     * @param max defines the maximum opacity for a gem to get into selection
     * @param nLace is the necklace used
     * @return Returns selection of the gems with the opactity, defined by min
     * and max
     */
    public static ArrayList<Gem> findGemstonesByOpacity(int min, int max, Necklace nLace) {
        LOG.info("Ищем крайние границы нужной прозрачности.");
        ArrayList<Gem> selection = new ArrayList<>();
        sortGemstonesByOpacity(nLace);
        ArrayList<Gem> gems = nLace.getGems();
        int minIndex = innerSearch(gems, min, 0, gems.size());
        int maxIndex = innerSearch(gems, max, 0, gems.size());
        if (minIndex < 0) {
            minIndex = -1 * (minIndex + 1);
        }
        if (maxIndex < 0) {
            maxIndex = -1 * (maxIndex + 1);
        }
        for (int i = 0; i < gems.size(); i++) {
            if (i >= minIndex && i < maxIndex) {
                selection.add(gems.get(i));
            }
        }
        return selection;
    }

    /**
     * @param list defines the list of gems in the necklace
     * @param key defines the gem the method is looking for
     * @param left defines the minimum opacity for a gem to get into selection
     * @param right defines the maximum opacity for a gem to get into selection
     * @return Returns the gem, which answers to the given description. If there
     * is none, returns null.
     */
    private static int innerSearch(ArrayList<Gem> list, Integer key,
            int left, int right) {
        if (left >= right) {
            return -(left + 1);
        } else {
            int mid = (left + right) / 2;
            if (list.get(mid).getOpacity() == key) {
                int i = 1;
                while (true) {
                    if (mid - i >= 0) {
                        if (list.get(mid - i).getOpacity() == key) {
                            mid--;
                        } else {
                            return mid;
                        }
                    } else {
                        return mid;
                    }
                }

            }
            if (list.get(mid).getOpacity() > key) {
                right = mid;
            } else {
                left = mid + 1;
            }
            return innerSearch(list, key, left, right);
        }
    }

    /**
     *
     * @param min defines the minimum opacity for a gem to get into selection
     * @param max defines the maximum opacity for a gem to get into selection
     * @param nLace is the necklace used
     * @return the string of the gems, which are within the defined interval of
     * Opacity
     */
    public static StringBuilder collectByOpacity(int min, int max, Necklace nLace) {
        LOG.debug("Границы прозрачности от " + min + " до " + max);
        ArrayList<Gem> f = findGemstonesByOpacity(min, max, nLace);
        StringBuilder k = new StringBuilder();
        if (!f.isEmpty()) {
            for (Gem gem : f) {
                k.append(new StringBuilder(gem.toString()));
            }
        }
        return k;
    }

}
