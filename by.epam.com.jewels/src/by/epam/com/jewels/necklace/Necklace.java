package by.epam.com.jewels.necklace;

import by.epam.com.jewels.entities.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.apache.log4j.Logger;

/**
 * This class creates a necklace, which may consist of different types of gems
 * Provides methods for sorting gems in a necklace, counting total weight and
 * total cost of it.
 *
 * @author skakun
 */
public class Necklace {

    private String type;
    private ArrayList<Gems> gems;
    private static final Logger log = Logger.getLogger(Necklace.class);

    /**
     *
     * @return gems returns the gems for the necklace
     */
    public ArrayList<Gems> getGems() {
        return gems;
    }

    /**
     *
     * @return type returns type of the necklace
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type sets necklace's type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @param gems sets necklace's gems
     */
    public void setGems(ArrayList<Gems> gems) {
        this.gems = gems;
    }

    /**
     *
     * @return Returns the total weight of the necklace
     */
    public int totalWeight() {
        log.info("Вычисляем общий вес ожерелья.");
        int weight = 0;
        for (Iterator<Gems> it = gems.iterator(); it.hasNext();) {
            Gems g = it.next();
            weight += g.getWeight();
        }

        return weight;
    }

    /**
     *
     * @return Returns the total cost of the necklace
     */
    public int totalCost() {
        log.info("Вычисляем общую стоимость ожерелья.");
        int cost = 0;
        for (Iterator<Gems> it = gems.iterator(); it.hasNext();) {
            Gems g = it.next();
            cost += g.getCost();
        }

        return cost;
    }

    /**
     * Sorts the gems in the necklace by the cost
     */
    public void sortGemstonesByCost() {
        log.info("Сортируем камни в ожерелье по стоимости.");
        Collections.sort(gems, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Gems g1 = (Gems) o1;
                Gems g2 = (Gems) o2;
                if (g1.getCost() > g2.getCost()) {
                    return 1;
                }
                if (g2.getCost() > g1.getCost()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    /**
     * Sorts the gems in the necklace by the opacity
     */
    public void sortGemstonesByOpacity() {
        log.info("Сортируем камни в ожерелье по прозрачности.");

        Collections.sort(gems, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Gems g1 = (Gems) o1;
                Gems g2 = (Gems) o2;
                if (g1.getOpacity() > g2.getOpacity()) {
                    return 1;
                }
                if (g2.getOpacity() > g1.getOpacity()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    /**
     *
     * @param min defines the minimum opacity for a gem to get into selection
     * @param max defines the maximum opacity for a gem to get into selection
     * @return Returns selection of the gems with the opactity, defined by min
     * and max
     */
    public ArrayList<Gems> findGemstonesByOpacity(int min, int max) {
        log.info("Ищем крайние границы нужной прозрачности.");
        ArrayList<Gems> selection = new ArrayList<>();
        sortGemstonesByOpacity();
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
    private static int innerSearch(ArrayList<Gems> list, Integer key,
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
     * @return the string of the gems, which are within the defined interval of
     * Opacity
     */
    public StringBuilder collectByOpacity(int min, int max) {
        log.debug("Границы прозрачности от " + min + " до " + max);
        ArrayList<Gems> f = this.findGemstonesByOpacity(min, max);
        StringBuilder k = new StringBuilder();
        if (!f.isEmpty()) {
            for (Gems gem : f) {
                k.append(new StringBuilder(gem.toString()));
            }
        }
        return k;
    }
}
