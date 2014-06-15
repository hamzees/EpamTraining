package by.skakun.gemstones.entities;

import java.util.Objects;

/**
 * This class extends basic class Gems
 *
 * @author skakun
 */
public abstract class PreciousGems extends Gems {

    private int toughness;
    private String cutMethod;

    /**
     *
     * @param toughness
     * @param cutMethod
     * @param cost
     * @param weight
     * @param opacity
     * @param color
     * @param name
     */
    public PreciousGems(int toughness, String cutMethod, int cost, int weight, int opacity, String color, String name) {
        super(cost, weight, opacity, color, name);
        this.toughness = toughness;
        this.cutMethod = cutMethod;
    }

    /**
     *
     * @return the toughness returns precious gem's toughness
     */
    public int getToughness() {
        return toughness;
    }

    /**
     *
     * @param toughness sets precious gem's toughness
     */
    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    /**
     *
     * @return the cutMethod returns precious gem's cut method
     */
    public String getCutMethod() {
        return cutMethod;
    }

    /**
     *
     * @param cutMethod sets precious gem's cut method
     */
    public void setCutMethod(String cutMethod) {
        this.cutMethod = cutMethod;
    }

    @Override
    public String toString() {
        return super.toString() + ". Способ огранки: " + cutMethod + ". Прочность: " + toughness;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final PreciousGems other = (PreciousGems) obj;
        if (this.cutMethod != other.getCutMethod()) {
            return false;
        }
        if (this.toughness != other.toughness) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.toughness;
        hash = 67 * hash + Objects.hashCode(this.cutMethod);
        return hash;
    }
}
