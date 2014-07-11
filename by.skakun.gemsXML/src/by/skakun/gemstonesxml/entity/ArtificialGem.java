package by.skakun.gemstonesxml.entity;

import by.skakun.gemstonesxml.exception.GemLogicException;
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
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public ArtificialGem(String id,int age, ToughnessType toughness, String cutMethod, int cost, double weight, int opacity, String color, String name) throws GemLogicException {
        super(id,toughness, cutMethod, cost, weight, opacity, color, name);
        if (age <= 0) {
            throw new GemLogicException("Возраст камня не может быть меньше нуля");
        } else {
            this.age = age;
        }
    }

    public ArtificialGem() {
        super();
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
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public void setAge(int age) throws GemLogicException {
        if (age <= 0) {
            throw new GemLogicException("Возраст камня должен быть больше нуля");
        } else {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ". Возраст: " + age;
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
