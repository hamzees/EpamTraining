package by.skakun.gemstones.builder;

import by.skakun.gemstones.entities.Gem;
import by.skakun.gemstones.entities.RealPreciousGem;
import by.skakun.gemstones.necklace.Necklace;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * This class extends from GemsBaseBuilder and builds a necklace from the real
 * precious gemstones.
 *
 * @author skakun
 */
public class RealPreciousGemsBuilder extends GemsBaseBuilder {

    private static final Logger LOG = Logger.getLogger(RealPreciousGemsBuilder.class.getName());

    /**
     * constructor without parameters
     */
    public RealPreciousGemsBuilder() {
        LOG.info("\nНОВОЕ ОЖЕРЕЛЬЕ");
    }

    @Override
    public void buildType() {
        getNecklace().setType("Это ожерелье из натуральных драгоценных камней.");
    }

    @Override
    public void buildGems() {
        LOG.trace("Отбираем камни для ожерелья");
        ArrayList<Gem> rpGems = new ArrayList<Gem>();
        rpGems.add(new RealPreciousGem("Германия", 5, "Круглая", 500, 2, 1, "Розовый", "Бриллиант"));
        rpGems.add(new RealPreciousGem("Италия", 4, "Ступенчатай", 400, 2, 3, "Синий", "Сапфир"));
        rpGems.add(new RealPreciousGem("Россия", 4, "Капельная", 300, 2, 5, "Красный", "Рубин"));
        getNecklace().setGems(rpGems);
    }

}
