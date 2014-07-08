package by.skakun.gemstones.entity;

import by.skakun.gemstones.exception.GemLogicException;
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
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public Gem(int cost, double weight, int opacity, String color, String name) throws GemLogicException {
        setCost(cost);
        setWeight(weight);
        setOpacity(opacity);
        setColor(color);
        setName(name);
    
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
        if (obj == this) {
            return true;
        }
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
     * @throws by.skakun.gemstones.exception.GemLogicException
     *
     */
    public void setColor(String color) throws GemLogicException {
        if (!color.isEmpty()) {
            this.color = color;
        } else {
            throw new GemLogicException("У камня не указан цвет.");
        }

    }

    /**
     * @return the name returns gem's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name sets name
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public void setName(String name) throws GemLogicException {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new GemLogicException("У камня не указано название.");
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
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public void setCost(int cost) throws GemLogicException {
        if (cost > 0) {
            this.cost = cost;
        } else {
            throw new GemLogicException("Цена камня должна быть больше нуля.");
        }
    }

    /**
     *
     * @param weight sets gem's weight
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public void setWeight(int weight) throws GemLogicException {
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new GemLogicException("Вес камня должен быть больше нуля.");
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
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public void setOpacity(int opacity) throws GemLogicException {
        if (opacity > 0) {
            this.opacity = opacity;
        } else {
            throw new GemLogicException("Прозрачность камня должна быть больше нуля.");
        }
    }
}
