package by.skakun.gemstones.builder;

import by.skakun.gemstones.entities.ArtificialGem;
import by.skakun.gemstones.entities.Gem;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * This class extends from GemsBaseBuilder and builds a necklace from the
 * artificial precious gemstones.
 *
 * @author skakun
 */
public class ArtificialGemsBuilder extends GemsBaseBuilder {

    private static final Logger LOG = Logger.getLogger(SemiPreciousGemsBuilder.class);

    /**
     * constructor without parameters
     */
    public ArtificialGemsBuilder() {
        LOG.info("\nНОВОЕ ОЖЕРЕЛЬЕ");
    }

    @Override
    public void buildType() {
        getNecklace().setType("Это ожерелье из искусственных драгоценных камней.");
    }

    @Override
    public void buildGems() {
        LOG.trace("Отбираем камни для ожерелья");
        ArrayList<Gem> rpGems = new ArrayList<Gem>();
        rpGems.add(new ArtificialGem(10, 5, "Круглая", 2500, 2, 1, "Розовый", "Бриллиант"));
        rpGems.add(new ArtificialGem(5, 4, "Ступенчатай", 2400, 2, 3, "Синий", "Сапфир"));
        rpGems.add(new ArtificialGem(3, 4, "Капельная", 2300, 2, 5, "Красный", "Рубин"));
        getNecklace().setGems(rpGems);
    }

}
