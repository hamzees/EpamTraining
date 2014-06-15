package by.skakun.gemstones.entities;

/**
 * This class extends class PreciousGems
 *
 * @author skakun
 */
public class ArtificialGems extends PreciousGems {

    private int age;

    /**
     *
     * @param age
     * @param toughness
     * @param cutMethod
     * @param cost
     * @param weight
     * @param opacity
     * @param color
     * @param name
     */
    public ArtificialGems(int age, int toughness, String cutMethod, int cost, int weight, int opacity, String color, String name) {
        super(toughness, cutMethod, cost, weight, opacity, color, name);
        this.age = age;
    }

    /**
     *
     * @return age returns artificial gem's age
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age sets artificial gem's age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + "Возраст: " + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final ArtificialGems other = (ArtificialGems) obj;
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.age;
        return hash;
    }

}
