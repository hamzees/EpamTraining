package by.skakun.gemstones.entities;

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
     */
    public RealPreciousGem(String fieldOrigin, int toughness, String cutMethod, int cost, int weight, int opacity, String color, String name) {
        super(toughness, cutMethod, cost, weight, opacity, color, name);
        this.fieldOrigin = fieldOrigin;
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
     */
    public void setFieldOrigin(String fieldOrigin) {
        if (fieldOrigin != null) {
            this.fieldOrigin = fieldOrigin;
        } else {
            LOG.warn("Страна происхождения камня должна быть определена.");
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
