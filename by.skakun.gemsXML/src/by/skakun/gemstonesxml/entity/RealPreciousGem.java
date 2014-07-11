package by.skakun.gemstonesxml.entity;

import by.skakun.gemstonesxml.exception.GemLogicException;
import java.util.Objects;
import org.apache.log4j.Logger;

/**
 * This class extends class PreciousGem
 *
 * @author skakun
 */
public class RealPreciousGem extends PreciousGem {

    private String fieldOrigin;
    private static final Logger LOG = Logger.getLogger(RealPreciousGem.class);

    /**
     *
     * @param fieldOrigin
     * @param toughness
     * @param cutMethod
     * @param cost
     * @param weight
     * @param opacity
     * @param color
     * @param name
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public RealPreciousGem(String id,String fieldOrigin, ToughnessType toughness, String cutMethod, int cost, double weight, int opacity, String color, String name) throws GemLogicException {
        super(id,toughness, cutMethod, cost, weight, opacity, color, name);
        if (fieldOrigin.isEmpty()) {
            throw new GemLogicException("Страна происхождения камня должна быть определена.");
        } else {
            this.fieldOrigin = fieldOrigin;
        }
    }

    public RealPreciousGem() {
        super();
    }

    /**
     *
     * @return fieldOrigin returns gem's field of origin
     */
    public String getFieldOrigin() {
        return fieldOrigin;
    }

    /**
     *
     * @param fieldOrigin sets gem's field of origin
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public void setFieldOrigin(String fieldOrigin) throws GemLogicException {
        if (fieldOrigin.isEmpty()) {
            throw new GemLogicException("Страна происхождения камня должна быть определена.");
        } else {
            this.fieldOrigin = fieldOrigin;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ". Страна происхождения: " + fieldOrigin;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final RealPreciousGem other = (RealPreciousGem) obj;
        if (!this.fieldOrigin.equals(other.fieldOrigin)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.fieldOrigin);
        return hash;
    }
}
