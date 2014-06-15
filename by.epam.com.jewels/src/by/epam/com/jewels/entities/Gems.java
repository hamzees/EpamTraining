package by.epam.com.jewels.entities;

/**
 * This is the basic class for the gemstones hierarchy. 
 * @author skakun
 */
public abstract class Gems {

    private int cost;
    private int weight;
    private int opacity;
    private String color;
    private String name;

    /**
     *
     * @param cost
     * @param weight
     * @param opacity
     * @param color
     * @param name
     */
    public Gems(int cost, int weight, int opacity, String color, String name) {
        this.cost = cost;
        this.weight = weight;
        this.opacity = opacity;
        this.color = color;
        this.name = name;
    }

    /**
     * Default constructor.
     */
    public Gems() {
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
        final Gems other = (Gems) obj;
        if (this.cost != other.cost) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        if (this.opacity != other.opacity) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (this.name != other.name) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.cost;
        hash = 97 * hash + this.weight;
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
        this.name = name;
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
    public int getWeight() {
        return weight;
    }

    /**
     *
     * @param cost sets gem's cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     *
     * @param weight sets gem's weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
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
        this.opacity = opacity;
    }
}
