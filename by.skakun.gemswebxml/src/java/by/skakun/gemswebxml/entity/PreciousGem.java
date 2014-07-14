package by.skakun.gemswebxml.entity;

import by.skakun.gemswebxml.exception.GemLogicException;
import java.util.Objects;
import org.apache.log4j.Logger;

/**
 * This class extends basic class Gem
 *
 * @author skakun
 */
public abstract class PreciousGem extends Gem {

    private ToughnessType toughness;
    private String cutMethod;
    private static final Logger LOG = Logger.getLogger(PreciousGem.class);

    /**
     *
     * @param toughness
     * @param cutMethod
     * @param cost
     * @param weight
     * @param opacity
     * @param color
     * @param name
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public PreciousGem(String id, ToughnessType toughness, String cutMethod, int cost, double weight, int opacity, String color, String name) throws GemLogicException {
        super(id,cost, weight, opacity, color, name);
        if (!toughness.getClass().equals(ToughnessType.class)) {
            throw new GemLogicException("Неправильно указана прочность камня");
        } else {
            this.toughness = toughness;
        }
        if (cutMethod.isEmpty()) {
            throw new GemLogicException("Неправильно указан метод огранки");
        } else {
            this.cutMethod = cutMethod;
        }
    }

    public PreciousGem() {
    }

    /**
     *
     * @return the toughness returns precious gem's toughness
     */
    public ToughnessType getToughness() {
        return toughness;
    }

    /**
     *
     * @param toughness sets precious gem's toughness
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public void setToughness(ToughnessType toughness) throws GemLogicException {
        if (!toughness.getClass().equals(ToughnessType.class)) {
            throw new GemLogicException("Твердость камня должна быть больше 0.");
        } else {
            this.toughness = toughness;
        }
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
     * @throws by.skakun.gemstones.exception.GemLogicException
     */
    public void setCutMethod(String cutMethod) throws GemLogicException {
        if (cutMethod.isEmpty()) {
            throw new GemLogicException("Способ огранки камня должен быть определен.");
        } else {
            this.cutMethod = cutMethod;
        }
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
        final PreciousGem other = (PreciousGem) obj;
        if (!this.cutMethod.equals(other.getCutMethod())) {
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
        hash = 67 * hash + Objects.hashCode(this.cutMethod);
        hash = 67 * hash + Objects.hashCode(this.cutMethod);
        return hash;
    }
}
