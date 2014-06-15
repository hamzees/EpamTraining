package by.skakun.gemstones.entities;

import java.util.Objects;

/**
 * This class extends class PreciousGems
 *
 * @author skakun
 */
public class RealPreciousGems extends PreciousGems {

    private String fieldOrigin;

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
    public RealPreciousGems(String fieldOrigin, int toughness, String cutMethod, int cost, int weight, int opacity, String color, String name) {
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
        this.fieldOrigin = fieldOrigin;
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
        final RealPreciousGems other = (RealPreciousGems) obj;
        if (this.fieldOrigin != other.fieldOrigin) {
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
