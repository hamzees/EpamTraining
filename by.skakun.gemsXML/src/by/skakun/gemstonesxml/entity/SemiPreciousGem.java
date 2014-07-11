package by.skakun.gemstonesxml.entity;

import by.skakun.gemstonesxml.exception.GemLogicException;
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
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public SemiPreciousGem(String id,String symbol, int cost, double weight, int opacity, String color, String name) throws GemLogicException {
        super(id,cost, weight, opacity, color, name);
        if(symbol.isEmpty()){
            throw new GemLogicException("Символ камня должен быть указан.");
        } else{
            this.symbol = symbol;
        }
    }

    public SemiPreciousGem() {
    }

    /**
     * @return the symbol returns semiprecious gem's symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public void setSymbol(String symbol) throws GemLogicException {
        if (symbol.isEmpty()) {
            throw new GemLogicException("Символ камня должен быть указан.");
        } else {
            this.symbol = symbol;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ". Символизирует: " + symbol;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this != obj) {
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
