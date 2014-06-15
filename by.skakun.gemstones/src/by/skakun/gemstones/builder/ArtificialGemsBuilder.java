package by.skakun.gemstones.builder;

import by.skakun.gemstones.entities.ArtificialGems;
import by.skakun.gemstones.entities.Gems;
import by.skakun.gemstones.necklace.Necklace;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * This class extends from GemsBaseBuilder and builds a necklace from the
 * artificial precious gemstones.
 *
 * @author skakun
 */
public class ArtificialGemsBuilder extends GemsBaseBuilder {

    private static final Logger log = Logger.getLogger(SemiPreciousGemsBuilder.class);

    /**
     * constructor without parameters
     */
    public ArtificialGemsBuilder() {
        log.info("\nНОВОЕ ОЖЕРЕЛЬЕ");
    }

    @Override
    public void buildType() {
        getNecklace().setType("Это ожерелье из искусственных драгоценных камней.");
    }

    @Override
    public void buildGems() {
        log.trace("Отбираем камни для ожерелья");
        ArrayList<Gems> rpGems = new ArrayList<Gems>();
        rpGems.add(new ArtificialGems(10, 5, "Круглая", 2500, 2, 1, "Розовый", "Бриллиант"));
        rpGems.add(new ArtificialGems(5, 4, "Ступенчатай", 2400, 2, 3, "Синий", "Сапфир"));
        rpGems.add(new ArtificialGems(3, 4, "Капельная", 2300, 2, 5, "Красный", "Рубин"));
        getNecklace().setGems(rpGems);
    }

}
