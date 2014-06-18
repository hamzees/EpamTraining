package by.skakun.gemstones.entities;

import java.util.Objects;
import org.apache.log4j.Logger;

/**
 * This class extends basic class Gem
 *
 * @author skakun
 */
public class SemiPreciousGem extends Gem {

    public static final Logger LOG = Logger.getLogger(SemiPreciousGem.class.getName());
    private String symbol;

    /**
     *
     * @param symbol
     * @param cost
     * @param weight
     * @param opacity
     * @param color
     * @param name
     */
    public SemiPreciousGem(String symbol, int cost, int weight, int opacity, String color, String name) {
        super(cost, weight, opacity, color, name);
        this.symbol = symbol;
    }

    /**
     * @return the symbol returns semiprecious gem's symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        if (symbol != null) {
            this.symbol = symbol;
        } else {
            LOG.warn("Символ камня не может быть пустым.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Символизирует: " + symbol;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final SemiPreciousGem other = (SemiPreciousGem) obj;
        if (!this.symbol.equals(other.symbol)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.symbol);
        return hash;
    }

}
