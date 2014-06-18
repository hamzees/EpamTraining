package by.skakun.gemstones.entities;

import org.apache.log4j.Logger;

/**
 * This class extends class PreciousGem
 *
 * @author skakun
 */
public class ArtificialGem extends PreciousGem {

    private int age;
    private static final Logger LOG = Logger.getLogger(ArtificialGem.class);

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
    public ArtificialGem(int age, int toughness, String cutMethod, int cost, int weight, int opacity, String color, String name) {
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
        if(age>0){
        this.age = age;}
        else{
          LOG.warn("Возраст камня должен быть больше нуля.");
        }
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
        final ArtificialGem other = (ArtificialGem) obj;
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
