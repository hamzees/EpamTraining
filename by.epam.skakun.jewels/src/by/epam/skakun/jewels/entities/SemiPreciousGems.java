package by.epam.skakun.jewels.entities;

import java.util.Objects;

/**
 * This class extends basic class Gems
 *
 * @author skakun
 */
public class SemiPreciousGems extends Gems {

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
    public SemiPreciousGems(String symbol, int cost, int weight, int opacity, String color, String name) {
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
        this.symbol = symbol;
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
        final SemiPreciousGems other = (SemiPreciousGems) obj;
        if (this.symbol != other.symbol) {
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
