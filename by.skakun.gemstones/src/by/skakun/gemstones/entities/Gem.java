package by.skakun.gemstones.entities;

import org.apache.log4j.Logger;

/**
 * This is the basic class for the gemstones hierarchy.
 *
 * @author skakun
 */
public abstract class Gem {

    private int cost;
    private double weight;
    private int opacity;
    private String color;
    private String name;
    private static final Logger LOG = Logger.getLogger(Gem.class);

    /**
     *
     * @param cost
     * @param weight
     * @param opacity
     * @param color
     * @param name
     */
    public Gem(int cost, double weight, int opacity, String color, String name) {
        this.cost = cost;
        this.weight = weight;
        this.opacity = opacity;
        this.color = color;
        this.name = name;
    }

    /**
     * Default constructor.
     */
    public Gem() {
    }

    @Override
    public String toString() {
        return "Название: " + name + ". Цена: " + cost + ". Вес: " + weight
                + ". Прозрачность: " + opacity + ". Цвет: " + color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gem other = (Gem) obj;
        if (this.cost != other.cost) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        if (this.opacity != other.opacity) {
            return false;
        }
        if (!this.color.equals(other.color)) {
            return false;
        }
        if (!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.cost;
        hash = (int) (97 * hash + this.weight);
        hash = 97 * hash + this.opacity;
        return hash;
    }

    /**
     * @return the color returns gem's color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color sets color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the name returns gem's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name sets name
     */
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            LOG.warn("Название камня не должно быть пустым.");
        }
    }

    /**
     *
     * @return cost returns gem's cost
     */
    public int getCost() {
        return cost;

    }

    /**
     *
     * @return weight returns gem's weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @param cost sets gem's cost
     */
    public void setCost(int cost) {
        if (cost > 0) {
            this.cost = cost;
        } else {
            LOG.warn("Цена камня должна быть больше нуля.");
        }
    }

    /**
     *
     * @param weight sets gem's weight
     */
    public void setWeight(int weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            LOG.warn("Вес камня должен быть больше нуля.");
        }
    }

    /**
     *
     * @return opacity returns gem's opacity
     */
    public int getOpacity() {
        return opacity;
    }

    /**
     *
     * @param opacity
     */
    public void setOpacity(int opacity) {
        if (opacity > 0) {
            this.opacity = opacity;
        } else {
            LOG.warn("Прозрачность камня должна быть больше нуля.");
        }
    }
}
