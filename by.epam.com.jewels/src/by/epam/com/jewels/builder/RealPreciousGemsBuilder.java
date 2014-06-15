package by.epam.com.jewels.builder;

import by.epam.com.jewels.entities.Gems;
import by.epam.com.jewels.entities.RealPreciousGems;
import by.epam.com.jewels.necklace.Necklace;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * This class extends from GemsBaseBuilder and builds a necklace from the real
 * precious gemstones.
 *
 * @author apple
 */
public class RealPreciousGemsBuilder extends GemsBaseBuilder {

    private static final Logger log = Logger.getLogger(RealPreciousGemsBuilder.class);

    /**
     * constructor without parameters
     */
    public RealPreciousGemsBuilder() {
        log.info("\nНОВОЕ ОЖЕРЕЛЬЕ");
    }

    @Override
    public void buildType() {
        getNecklace().setType("Это ожерелье из натуральных драгоценных камней.");
    }

    @Override
    public void buildGems() {
        log.trace("Отбираем камни для ожерелья");
        ArrayList<Gems> rpGems = new ArrayList<Gems>();
        rpGems.add(new RealPreciousGems("Германия", 5, "Круглая", 500, 2, 1, "Розовый", "Бриллиант"));
        rpGems.add(new RealPreciousGems("Италия", 4, "Ступенчатай", 400, 2, 3, "Синий", "Сапфир"));
        rpGems.add(new RealPreciousGems("Россия", 4, "Капельная", 300, 2, 5, "Красный", "Рубин"));
        getNecklace().setGems(rpGems);
    }

}
