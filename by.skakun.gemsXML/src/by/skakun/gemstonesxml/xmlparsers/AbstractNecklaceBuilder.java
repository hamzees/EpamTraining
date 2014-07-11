package by.skakun.gemstonesxml.xmlparsers;

import by.skakun.gemstonesxml.entity.Gem;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractNecklaceBuilder {

    protected Set<Gem> gems;

    public AbstractNecklaceBuilder(Set<Gem> gems) {
        this.gems = gems;
    }

    public AbstractNecklaceBuilder() {
        gems = new HashSet<Gem>();
    }

    public Set<Gem> getGems() {
        return gems;
    }

    abstract public void buildSetGems(String fileName);

}


