package by.skakun.gemstones.necklace;

import by.skakun.gemstones.entity.Gem;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * This class creates a necklace, which may consist of different types of gems
 * Provides methods for counting total weight and
 * total cost of it.
 *
 * @author skakun
 */
public class Necklace implements Cloneable {

    private String type;
    private ArrayList<Gem> gems;
    private static final Logger LOG = Logger.getLogger(Necklace.class);

    /**
     *
     * @return gems returns the gems for the necklace
     */
    public ArrayList<Gem> getGems() {
        Necklace nLaceCopy = clone();
        return nLaceCopy.gems;
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
    public void setGems(ArrayList<Gem> gems) {
        this.gems = gems;
    }

    /**
     *
     * @return Returns the total weight of the necklace
     */
    public double calculateTotalWeight() {
        LOG.info("Вычисляем общий вес ожерелья.");
        double weight = 0;
        for (Gem g : gems) {
            weight += g.getWeight();
        }
        return weight;
    }

    /**
     *
     * @return Returns the total cost of the necklace
     */
    public int calculateTotalCost() {
        LOG.info("Вычисляем общую стоимость ожерелья.");
        int cost = 0;
        cost = gems.stream().map((g) -> g.getCost()).reduce(cost, Integer::sum);
        return cost;

    }

    @Override
    public Necklace clone() {
        Necklace nLaceCopy = null;
        try {
            nLaceCopy = (Necklace) super.clone();
            nLaceCopy.gems = (ArrayList<Gem>) gems.clone();
            return nLaceCopy;
        } catch (CloneNotSupportedException ex) {
            LOG.warn("Не получилось создать копию объекта" + ex);
            return nLaceCopy;
        }
    }

}
