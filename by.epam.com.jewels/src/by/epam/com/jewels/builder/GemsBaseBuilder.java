package by.epam.com.jewels.builder;

import by.epam.com.jewels.necklace.Necklace;

/**
 * This is a basic class of the Builder pattern
 *
 * @author apple
 */
public abstract class GemsBaseBuilder {

    /**
     * Creates a new Necklace object.
     */
    private Necklace nLace = new Necklace() {
    };

    /**
     *
     * @return returns a necklace.
     */
    public Necklace getNecklace() {
        return nLace;
    }

    /**
     * abstract method to build necklace's type
     */
    public abstract void buildType();

    /**
     * abstract method to build a collection necklace's gems
     */
    public abstract void buildGems();

}
